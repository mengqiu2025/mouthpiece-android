package com.mouthpiece.app.data.repository

import com.mouthpiece.app.data.ai.AiGateway
import com.mouthpiece.app.model.AppSettings
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.ReplySource
import com.mouthpiece.app.model.Scene
import com.mouthpiece.app.model.StylePreset
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.IOException

/**
 * 生成编排的回归测试。
 *
 * 覆盖重构前后必须完全一致的三条不变式：
 * 1. 永远有兜底（AI 失败 / 未配 Key → 离线模板）
 * 2. 缓存写入在安全校验之后（被拦下的内容不进缓存）
 * 3. 取消要透传（`CancellationException` 直接抛出，且不污染错误状态）
 */
class ReplyRepositoryTest {

    private val style = StylePreset(
        id = "pro",
        name = "职场得体",
        emoji = "💼",
        scene = Scene.WORKPLACE,
        tagline = "专业、简洁、有边界",
        systemPrompt = "你是职场沟通顾问。",
        temperature = 0.7f,
        hints = listOf("收到，我先同步一下进度。"),
    )

    private val ready = AppSettings(
        baseUrl = "https://api.openai.com/v1",
        apiKey = "sk-test",
        model = "gpt-4o-mini",
    )

    private val notReady = ready.copy(apiKey = "")

    private fun request() = ReplyRequest(incoming = "在吗", styles = listOf(style), strength = 3, persona = null)

    /** 可控的假网关：记录调用次数，返回内容由 [onComplete] 决定。 */
    private class FakeGateway(private val onComplete: suspend () -> String) : AiGateway {
        var calls = 0
            private set

        override suspend fun complete(system: String, user: String, temperature: Float): String {
            calls++
            return onComplete()
        }
    }

    // -----------------------------------------------------------------------
    // 兜底
    // -----------------------------------------------------------------------

    @Test
    fun `未配置 API Key 时走离线模板且不报错`() {
        val gateway = FakeGateway { "AI 回复" }
        val repo = ReplyRepository({ notReady }, gateway)

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(ReplySource.LOCAL, outcome.reply.source)
        assertNull(outcome.error)
        assertFalse(outcome.fromCache)
        assertEquals(0, gateway.calls)
    }

    @Test
    fun `AI 失败时回退离线并记录错误`() {
        val repo = ReplyRepository({ ready }, FakeGateway { throw IOException("连接超时") })

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(ReplySource.LOCAL, outcome.reply.source)
        assertEquals("连接超时", outcome.error)
        assertEquals("连接超时", repo.lastAiError.value)
    }

    @Test
    fun `AI 返回不安全内容时回退离线`() {
        val gateway = FakeGateway { "教你怎么开盒" }
        val repo = ReplyRepository({ ready }, gateway)

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(ReplySource.LOCAL, outcome.reply.source)
        assertEquals("内容未通过安全校验", outcome.error)
    }

    @Test
    fun `被安全校验拦下的内容不会进缓存`() {
        val gateway = FakeGateway { "教你怎么开盒" }
        val repo = ReplyRepository({ ready }, gateway)

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        // 两次都真的打了网关 —— 说明第一次的兜底结果没有被缓存
        assertEquals(2, gateway.calls)
    }

    // -----------------------------------------------------------------------
    // 缓存
    // -----------------------------------------------------------------------

    @Test
    fun `AI 成功时来源为 AI`() {
        val repo = ReplyRepository({ ready }, FakeGateway { "收到，我先同步一下进度。" })

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(ReplySource.AI, outcome.reply.source)
        assertEquals("收到，我先同步一下进度。", outcome.reply.text)
        assertNull(outcome.error)
        assertFalse(outcome.fromCache)
    }

    @Test
    fun `相同参数第二次命中缓存`() {
        val gateway = FakeGateway { "收到" }
        val repo = ReplyRepository({ ready }, gateway)

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        val second = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(1, gateway.calls)
        assertTrue(second.fromCache)
        assertEquals("收到", second.reply.text)
    }

    @Test
    fun `bypassCache 会跳过缓存重新请求`() {
        val gateway = FakeGateway { "收到" }
        val repo = ReplyRepository({ ready }, gateway)

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        val second = runBlocking { repo.generateOutcome(request(), style, seed = 0, bypassCache = true) }

        assertEquals(2, gateway.calls)
        assertFalse(second.fromCache)
    }

    @Test
    fun `未配置 Key 的离线结果不会进缓存`() {
        var settings = notReady
        val gateway = FakeGateway { "AI 回复" }
        val repo = ReplyRepository({ settings }, gateway)

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        settings = ready
        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(1, gateway.calls)
        assertEquals(ReplySource.AI, outcome.reply.source)
        assertFalse(outcome.fromCache)
    }

    @Test
    fun `clearCache 之后会重新请求`() {
        val gateway = FakeGateway { "收到" }
        val repo = ReplyRepository({ ready }, gateway)

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        repo.clearCache()
        runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals(2, gateway.calls)
    }

    // -----------------------------------------------------------------------
    // 取消
    // -----------------------------------------------------------------------

    @Test
    fun `取消异常必须透传且不写入错误状态`() {
        val repo = ReplyRepository({ ready }, FakeGateway { throw CancellationException("换一批") })

        var caught: Throwable? = null
        runBlocking {
            try {
                repo.generateOutcome(request(), style, seed = 0)
            } catch (e: Throwable) {
                caught = e
            }
        }

        assertTrue("CancellationException 必须原样抛出", caught is CancellationException)
        assertNull("取消不应该被当成 AI 错误展示", repo.lastAiError.value)
    }

    // -----------------------------------------------------------------------
    // 输出清洗
    // -----------------------------------------------------------------------

    @Test
    fun `清洗会剥掉「回复：」前缀`() {
        val repo = ReplyRepository({ ready }, FakeGateway { "\n回复：收到\n" })

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals("收到", outcome.reply.text)
    }

    @Test
    fun `清洗会剥掉包裹的引号`() {
        val repo = ReplyRepository({ ready }, FakeGateway { "“收到，好的”" })

        val outcome = runBlocking { repo.generateOutcome(request(), style, seed = 0) }

        assertEquals("收到，好的", outcome.reply.text)
    }

    // -----------------------------------------------------------------------
    // 其他
    // -----------------------------------------------------------------------

    @Test
    fun `generateOne 返回生成结果`() {
        val repo = ReplyRepository({ ready }, FakeGateway { "收到" })

        val reply = runBlocking { repo.generateOne(request(), style, seed = 0) }

        assertEquals("收到", reply.text)
        assertEquals("pro", reply.styleId)
    }

    @Test
    fun `newSeed 单调递增`() {
        val repo = ReplyRepository({ ready }, FakeGateway { "收到" })

        assertEquals(0, repo.newSeed())
        assertEquals(1, repo.newSeed())
        assertEquals(2, repo.newSeed())
    }

    @Test
    fun `clearAiError 清空错误`() {
        val repo = ReplyRepository({ ready }, FakeGateway { throw IOException("连接超时") })

        runBlocking { repo.generateOutcome(request(), style, seed = 0) }
        assertNotNull(repo.lastAiError.value)

        repo.clearAiError()
        assertNull(repo.lastAiError.value)
    }
}
