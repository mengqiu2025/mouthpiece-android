package com.mouthpiece.app.domain.prompt

import com.mouthpiece.app.domain.style.StyleCatalog
import com.mouthpiece.app.model.Persona
import com.mouthpiece.app.model.ReplyRequest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PromptBuilderTest {

    private val style = StyleCatalog.byId("pro")!!

    private fun request(
        incoming: String = "这个需求今晚能给我吗？",
        strength: Int = 3,
        persona: Persona? = null,
        extraHint: String = "",
    ) = ReplyRequest(
        incoming = incoming,
        styles = listOf(style),
        strength = strength,
        persona = persona,
        extraHint = extraHint,
    )

    // -----------------------------------------------------------------------
    // system
    // -----------------------------------------------------------------------

    @Test
    fun `system 以风格的 systemPrompt 开头`() {
        assertTrue(PromptBuilder.system(request()).startsWith(style.systemPrompt))
    }

    @Test
    fun `system 包含表达强度规则`() {
        val system = PromptBuilder.system(request(strength = 5))
        assertTrue(system.contains("【表达强度】"))
        assertTrue(system.contains("表达非常直接，开门见山给出明确态度，不解释、不铺垫、不留余地。"))
    }

    @Test
    fun `强度越界回退到 3`() {
        val fallback = "表达自然平衡，既说清态度也不让对方难堪。"
        assertTrue(PromptBuilder.system(request(strength = 0)).contains(fallback))
        assertTrue(PromptBuilder.system(request(strength = 99)).contains(fallback))
    }

    @Test
    fun `无人设时不拼接说话对象段`() {
        assertFalse(PromptBuilder.system(request(persona = null)).contains("【说话对象】"))
    }

    @Test
    fun `有人设时拼接称呼关系语气与禁忌`() {
        val persona = Persona("p1", "老板", "直属上级", "简洁、尊重", "不要说做不到")
        val system = PromptBuilder.system(request(persona = persona))

        assertTrue(system.contains("【说话对象】"))
        assertTrue(system.contains("对方是你的直属上级，称呼「老板」。"))
        assertTrue(system.contains("语气要求：简洁、尊重。"))
        assertTrue(system.contains("绝对不要出现：不要说做不到。"))
    }

    @Test
    fun `关系为空时用沟通对象兜底`() {
        val persona = Persona("p1", "小李", "", "", "")
        val system = PromptBuilder.system(request(persona = persona))

        assertTrue(system.contains("对方是你的沟通对象，称呼「小李」。"))
        // 语气和禁忌为空 → 不出现对应句子
        assertFalse(system.contains("语气要求："))
        assertFalse(system.contains("绝对不要出现："))
    }

    @Test
    fun `system 始终包含输出要求`() {
        val system = PromptBuilder.system(request())
        assertTrue(system.contains("【输出要求】"))
        assertTrue(system.contains("只输出一条可以直接发送的回复正文"))
        assertTrue(system.contains("控制在 80 字以内"))
        assertTrue(system.contains("不要提及自己是 AI，也不要提及「嘴替」"))
    }

    @Test
    fun `styles 为空时 systemPrompt 退化为空串但结构完整`() {
        val empty = ReplyRequest("在吗", emptyList(), 3, null)
        val system = PromptBuilder.system(empty)
        assertTrue(system.startsWith("\n\n【表达强度】"))
        assertTrue(system.contains("【输出要求】"))
    }

    // -----------------------------------------------------------------------
    // user
    // -----------------------------------------------------------------------

    @Test
    fun `user 包含对方的话`() {
        val user = PromptBuilder.user(request(incoming = "今晚能给我吗？"))
        assertEquals("对方对我说：\n今晚能给我吗？\n\n请给出你的回复。", user)
    }

    @Test
    fun `user 会 trim 首尾空白`() {
        val user = PromptBuilder.user(request(incoming = "  在吗  "))
        assertTrue(user.contains("\n在吗\n"))
    }

    @Test
    fun `无补充要求时省略该段`() {
        assertFalse(PromptBuilder.user(request(extraHint = "")).contains("补充要求"))
        assertFalse(PromptBuilder.user(request(extraHint = "   ")).contains("补充要求"))
    }

    @Test
    fun `有补充要求时拼接进去`() {
        val user = PromptBuilder.user(request(extraHint = "不要太软，我要保住立场"))
        assertTrue(user.contains("补充要求：不要太软，我要保住立场"))
    }
}
