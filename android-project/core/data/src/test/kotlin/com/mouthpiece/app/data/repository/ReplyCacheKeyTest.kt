package com.mouthpiece.app.data.repository

import com.mouthpiece.app.model.AppSettings
import com.mouthpiece.app.model.Persona
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.Scene
import com.mouthpiece.app.model.StylePreset
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * 缓存键算法的回归测试。
 *
 * 这份测试是为了证明「把 `cacheKey` 从 `ReplyRepository` 抽成独立文件」
 * 没有改变行为：七段中的任何一段变化都必须导致 miss。
 */
class ReplyCacheKeyTest {

    private val style = StylePreset(
        id = "pro",
        name = "职场得体",
        emoji = "💼",
        scene = Scene.WORKPLACE,
        tagline = "专业、简洁、有边界",
        systemPrompt = "你是职场沟通顾问。",
        temperature = 0.7f,
    )

    private val config = AppSettings(
        baseUrl = "https://api.openai.com/v1",
        apiKey = "sk-test",
        model = "gpt-4o-mini",
    )

    private fun request(
        incoming: String = "在吗",
        strength: Int = 3,
        persona: Persona? = null,
        extraHint: String = "",
        styles: List<StylePreset> = listOf(style),
    ) = ReplyRequest(incoming, styles, strength, persona, extraHint)

    private fun key(
        request: ReplyRequest = request(),
        style: StylePreset = this.style,
        config: AppSettings = this.config,
    ): String = replyCacheKey(request, style, config)

    @Test
    fun `完全相同的输入得到相同的键`() {
        assertEquals(key(), key())
    }

    @Test
    fun `换 baseUrl 会 miss`() {
        assertNotEquals(key(), key(config = config.copy(baseUrl = "https://other.example/v1")))
    }

    @Test
    fun `换模型会 miss`() {
        assertNotEquals(key(), key(config = config.copy(model = "gpt-4o")))
    }

    @Test
    fun `换风格会 miss`() {
        assertNotEquals(key(), key(style = style.copy(id = "funny")))
    }

    @Test
    fun `换强度会 miss`() {
        assertNotEquals(key(), key(request = request(strength = 5)))
    }

    @Test
    fun `换说话对象会 miss`() {
        val boss = Persona("p1", "老板", "直属上级", "", "")
        assertNotEquals(key(), key(request = request(persona = boss)))
    }

    @Test
    fun `改补充要求会 miss`() {
        assertNotEquals(key(), key(request = request(extraHint = "再硬一点")))
    }

    @Test
    fun `改原话会 miss`() {
        assertNotEquals(key(), key(request = request(incoming = "在吗？")))
    }

    // -----------------------------------------------------------------------
    // 归一化：长度前缀 + trim
    // -----------------------------------------------------------------------

    @Test
    fun `长度前缀消除分隔符歧义`() {
        // 值里带「|」时，若只做朴素拼接，下面两种组合会拼出同一个键：
        //   extraHint="a|b", incoming="c"  →  "…|a|b|c|"
        //   extraHint="a",   incoming="b|c" →  "…|a|b|c|"
        // 长度前缀（"3:a|b|1:c|" vs "1:a|3:b|c|"）把它们区分开。
        val a = key(request = request(extraHint = "a|b", incoming = "c"))
        val b = key(request = request(extraHint = "a", incoming = "b|c"))
        assertNotEquals(a, b)
    }

    @Test
    fun `baseUrl model extraHint incoming 会先 trim`() {
        assertEquals(
            key(config = config.copy(baseUrl = "https://api.openai.com/v1  ")),
            key(config = config.copy(baseUrl = "https://api.openai.com/v1")),
        )
        assertEquals(
            key(request = request(incoming = " 在吗 ")),
            key(request = request(incoming = "在吗")),
        )
        assertEquals(
            key(request = request(extraHint = " 再硬一点 ")),
            key(request = request(extraHint = "再硬一点")),
        )
    }
}
