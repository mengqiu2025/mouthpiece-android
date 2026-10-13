package com.mouthpiece.app.domain.prompt

import com.mouthpiece.app.model.Reply
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.ReplySource

/**
 * 离线模板引擎。
 *
 * 两个触发场景：
 * 1. 用户没配置 API Key（`AppSettings.aiReady == false`）
 * 2. AI 调用失败（超时、鉴权失败、返回结构异常……）
 *
 * 意图识别按 [Intent.rules] 的**声明顺序**匹配，命中即返回；全不命中为 [Intent.CHAT]。
 */
class LocalTemplateEngine {

    enum class Intent {
        REQUEST,
        INVITE,
        QUESTION,
        BLAME,
        APOLOGY,
        FLIRT,
        CHAT;

        companion object {
            /**
             * 顺序即优先级 —— 先判道歉，再判指责，最后才是疑问。
             * 例：「你怎么又这样，对不起」会判成 APOLOGY（道歉优先）。
             */
            private val rules: List<Pair<Intent, List<String>>> = listOf(
                APOLOGY to listOf("对不起", "抱歉", "我错了", "不好意思"),
                BLAME to listOf("你怎么", "为什么没", "又这样", "说好的", "你明明"),
                INVITE to listOf(
                    "一起", "要不要", "来吗", "参加", "有空吗",
                    "约吗", "约个", "约一下", "约饭", "约会", "约你",
                ),
                FLIRT to listOf("想你", "喜欢你", "在干嘛", "晚安", "想见你", "心动"),
                REQUEST to listOf(
                    "帮我", "帮忙", "能不能", "可以吗", "麻烦你", "请你",
                    "借我", "加个班", "支持一下",
                ),
                QUESTION to listOf("?", "？", "怎么", "为什么", "多少", "什么", "是不是"),
            )

            /**
             * 「约」字误报白名单。
             *
             * INVITE 里有一堆以「约」开头的关键词，但「大约」「预约」「签约」等词
             * 也会包含「约」。判定时回看命中位置的前一个字符组成两字窗口，
             * 若命中本表则视为误报、跳过。
             */
            private val yueFalsePositives: List<String> = listOf(
                "大约", "预约", "节约", "制约", "签约", "合约", "条约",
                "违约", "盟约", "履约", "续约", "毁约", "邀约",
            )

            fun of(text: String): Intent =
                rules.firstOrNull { (_, keys) -> keys.any { matches(text, it) } }
                    ?.first
                    ?: CHAT

            private fun matches(text: String, key: String): Boolean {
                if (!key.startsWith('约')) return text.contains(key)

                var index = text.indexOf(key)
                while (index >= 0) {
                    val windowStart = maxOf(index - 1, 0)
                    val window = text.substring(windowStart, index + 1)
                    if (window !in yueFalsePositives) return true
                    index = text.indexOf(key, index + 1)
                }
                return false
            }
        }
    }

    /**
     * 为每个风格各生成一条离线回复。
     *
     * 取哪条话术由 `seed + intent.ordinal` 决定，所以同一个输入点「换一批」
     * 会轮换到不同模板；人设的称呼会替换掉话术里的 `{他}` 占位符。
     */
    fun generate(request: ReplyRequest, seed: Int = 0): List<Reply> {
        val intent = Intent.of(request.incoming)
        val speaker = request.persona?.name?.takeIf { it.isNotBlank() } ?: "你"

        return request.styles.map { style ->
            val hints = style.hints.ifEmpty { listOf(FALLBACK_REPLY) }
            val index = ((seed + intent.ordinal) % hints.size + hints.size) % hints.size
            Reply(
                styleId = style.id,
                styleName = style.name,
                emoji = style.emoji,
                text = hints[index].replace("{他}", speaker),
                source = ReplySource.LOCAL,
            )
        }
    }

    private companion object {
        const val FALLBACK_REPLY = "收到，我想想怎么回。"
    }
}
