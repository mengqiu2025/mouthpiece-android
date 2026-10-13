package com.mouthpiece.app.data.repository

import com.mouthpiece.app.data.ai.AiGateway
import com.mouthpiece.app.domain.prompt.LocalTemplateEngine
import com.mouthpiece.app.domain.prompt.PromptBuilder
import com.mouthpiece.app.domain.safety.SafetyFilter
import com.mouthpiece.app.model.AppSettings
import com.mouthpiece.app.model.Reply
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.ReplySource
import com.mouthpiece.app.model.StylePreset
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.CancellationException

/**
 * 生成编排：缓存 → AI → 安全校验 → 失败回退离线模板。
 *
 * 三条不变式：
 * 1. **永远有兜底** —— 任何异常都会返回一条离线回复，UI 不会拿到空结果。
 * 2. **缓存写入在安全校验之后** —— 被拦下的内容不会进缓存。
 * 3. **取消要透传** —— `CancellationException` 直接抛出，不吞掉。
 *
 * 缓存策略见 [ReplyCache]，缓存键算法见 [replyCacheKey]，二者都已拆成独立文件。
 */
class ReplyRepository(
    private val settingsProvider: () -> AppSettings,
    private val ai: AiGateway,
    private val local: LocalTemplateEngine = LocalTemplateEngine(),
    private val cache: ReplyCache = ReplyCache(),
) {

    private val _lastAiError = MutableStateFlow<String?>(null)

    /** AI 调用失败的最近一条错误消息。UI 消费后调 [clearAiError]。 */
    val lastAiError: StateFlow<String?> = _lastAiError.asStateFlow()

    private var seedCounter = 0

    fun clearAiError() {
        _lastAiError.value = null
    }

    /** 单调递增的种子，用于离线模板轮换。 */
    fun newSeed(): Int = seedCounter++

    fun clearCache() {
        cache.clear()
    }

    // -----------------------------------------------------------------------
    // 生成
    // -----------------------------------------------------------------------

    suspend fun generateOne(
        request: ReplyRequest,
        style: StylePreset,
        seed: Int,
        bypassCache: Boolean = false,
    ): Reply = generateOutcome(request, style, seed, bypassCache).reply

    /**
     * 生成一种风格的一条回复。
     *
     * @param bypassCache 「换一批」时传 `true`，跳过缓存强制重新请求
     */
    suspend fun generateOutcome(
        request: ReplyRequest,
        style: StylePreset,
        seed: Int,
        bypassCache: Boolean = false,
    ): Outcome {
        // 拆成单风格请求：一次 complete 只负责一种风格
        val single = request.copy(styles = listOf(style))
        val config = settingsProvider()

        // 没配 Key → 直接走离线模板（不算错误，不给用户报错）
        if (!config.aiReady) {
            return Outcome(local.generate(single, seed).first(), error = null)
        }

        val key = replyCacheKey(request, style, config)
        if (!bypassCache) {
            cache[key]?.let { return Outcome(it, error = null, fromCache = true) }
        }

        return try {
            val text = ai.complete(
                system = PromptBuilder.system(single),
                user = PromptBuilder.user(single),
                temperature = style.temperature,
            )
            val cleaned = clean(text)
            check(SafetyFilter.isOutputSafe(cleaned)) { "内容未通过安全校验" }

            val reply = Reply(
                styleId = style.id,
                styleName = style.name,
                emoji = style.emoji,
                text = cleaned,
                source = ReplySource.AI,
            )
            cache[key] = reply
            Outcome(reply, error = null)
        } catch (e: Throwable) {
            // 取消必须透传，否则「换一批」取消上一次请求会变成静默成功
            if (e is CancellationException) throw e

            val message = e.message ?: e::class.java.simpleName
            _lastAiError.value = message
            Outcome(local.generate(single, seed).first(), error = message)
        }
    }

    // -----------------------------------------------------------------------
    // 内部
    // -----------------------------------------------------------------------

    /**
     * 清洗模型输出：去首尾空白 → 去掉「回复：」前缀 → 再去掉包裹的引号。
     *
     * 顺序不能调换：有些模型会输出 `"回复：xxx"`，必须**先剥前缀再剥引号**
     * 才能正确处理这种带引号的「回复：」。
     */
    private fun clean(text: String): String =
        text.trim()
            .removePrefix("回复：")
            .removePrefix("回复:")
            .trim()
            .trim('"', '\u201C', '\u201D')
            .trim()

    /**
     * 单条生成的结果包装。
     *
     * [error] 非空表示这次实际用了离线兜底，UI 据此提示用户。
     */
    data class Outcome(
        val reply: Reply,
        val error: String?,
        val fromCache: Boolean = false,
    )
}
