package com.mouthpiece.app.domain.prompt

import com.mouthpiece.app.domain.prompt.LocalTemplateEngine.Intent
import com.mouthpiece.app.domain.style.StyleCatalog
import com.mouthpiece.app.model.Persona
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.ReplySource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LocalTemplateEngineTest {

    // -----------------------------------------------------------------------
    // 意图识别
    // -----------------------------------------------------------------------

    @Test
    fun `识别道歉`() {
        assertEquals(Intent.APOLOGY, Intent.of("对不起"))
        assertEquals(Intent.APOLOGY, Intent.of("我错了"))
    }

    @Test
    fun `识别指责`() {
        assertEquals(Intent.BLAME, Intent.of("你怎么还没给我"))
        assertEquals(Intent.BLAME, Intent.of("说好的今天给呢"))
    }

    @Test
    fun `识别邀约`() {
        assertEquals(Intent.INVITE, Intent.of("周末一起吃饭吗"))
        assertEquals(Intent.INVITE, Intent.of("明天约一下"))
    }

    @Test
    fun `识别搭讪`() {
        assertEquals(Intent.FLIRT, Intent.of("在干嘛"))
        assertEquals(Intent.FLIRT, Intent.of("晚安"))
    }

    @Test
    fun `识别请求`() {
        assertEquals(Intent.REQUEST, Intent.of("帮我看看这个"))
        assertEquals(Intent.REQUEST, Intent.of("可以吗"))
    }

    @Test
    fun `识别疑问`() {
        assertEquals(Intent.QUESTION, Intent.of("这个多少钱"))
        assertEquals(Intent.QUESTION, Intent.of("是这样吗？"))
    }

    @Test
    fun `都不命中时回退到 CHAT`() {
        assertEquals(Intent.CHAT, Intent.of("好的"))
        assertEquals(Intent.CHAT, Intent.of("嗯"))
    }

    // -----------------------------------------------------------------------
    // 优先级：顺序即优先级
    // -----------------------------------------------------------------------

    @Test
    fun `道歉优先于指责`() {
        // 同时含「对不起」和「你怎么」，APOLOGY 在 rules 里更靠前
        assertEquals(Intent.APOLOGY, Intent.of("对不起，你怎么又这样"))
    }

    // -----------------------------------------------------------------------
    // 「约」字误报
    // -----------------------------------------------------------------------

    @Test
    fun `预约不会被误判成邀约`() {
        assertEquals(Intent.CHAT, Intent.of("预约一下"))
    }

    @Test
    fun `大约不会被误判成邀约`() {
        assertEquals(Intent.CHAT, Intent.of("大约几点"))
    }

    @Test
    fun `签约类词不会被误判成邀约`() {
        assertEquals(Intent.CHAT, Intent.of("签约流程"))
        assertEquals(Intent.CHAT, Intent.of("合同违约"))
    }

    @Test
    fun `真的邀约仍然能识别`() {
        assertEquals(Intent.INVITE, Intent.of("明天约一下"))
        assertEquals(Intent.INVITE, Intent.of("约饭吗"))
    }

    // -----------------------------------------------------------------------
    // 生成
    // -----------------------------------------------------------------------

    @Test
    fun `每个风格各生成一条离线回复`() {
        val styles = StyleCatalog.byIds(listOf("high_eq", "pro"))
        val replies = LocalTemplateEngine().generate(
            ReplyRequest(incoming = "好的", styles = styles, strength = 3, persona = null),
            seed = 0,
        )
        assertEquals(2, replies.size)
        assertTrue(replies.all { it.source == ReplySource.LOCAL })
    }

    @Test
    fun `无人设时占位符替换为「你」`() {
        val style = StyleCatalog.byId("high_eq")!!
        val replies = LocalTemplateEngine().generate(
            ReplyRequest(incoming = "好的", styles = listOf(style), strength = 3, persona = null),
            seed = 0,
        )
        assertTrue(replies.first().text.contains("你要是方便"))
        assertTrue(!replies.first().text.contains("{他}"))
    }

    @Test
    fun `有人设时占位符替换为称呼`() {
        val style = StyleCatalog.byId("high_eq")!!
        val persona = Persona("p1", "老板", "直属上级", "", "")
        val replies = LocalTemplateEngine().generate(
            ReplyRequest(incoming = "好的", styles = listOf(style), strength = 3, persona = persona),
            seed = 0,
        )
        assertTrue(replies.first().text.contains("老板要是方便"))
        assertTrue(!replies.first().text.contains("{他}"))
    }

    @Test
    fun `不同 seed 轮换到不同话术`() {
        val style = StyleCatalog.byId("hard_no")!!   // 有 3 条 hint
        val engine = LocalTemplateEngine()
        val request = ReplyRequest("好的", listOf(style), 3, null)

        val texts = (0..2).map { engine.generate(request, seed = it).first().text }.toSet()
        assertEquals(3, texts.size)
    }

    @Test
    fun `负 seed 不会越界`() {
        val style = StyleCatalog.byId("hard_no")!!
        val replies = LocalTemplateEngine().generate(
            ReplyRequest("好的", listOf(style), 3, null),
            seed = Int.MIN_VALUE,
        )
        assertEquals(1, replies.size)
    }
}
