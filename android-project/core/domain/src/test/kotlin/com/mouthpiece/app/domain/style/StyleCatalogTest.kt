package com.mouthpiece.app.domain.style

import com.mouthpiece.app.model.Scene
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class StyleCatalogTest {

    @Test
    fun `共 12 种风格`() {
        assertEquals(12, StyleCatalog.all.size)
    }

    @Test
    fun `id 不重复`() {
        assertEquals(StyleCatalog.all.size, StyleCatalog.all.map { it.id }.toSet().size)
    }

    @Test
    fun `默认选中三种`() {
        assertEquals(listOf("high_eq", "pro", "funny"), StyleCatalog.defaultSelection)
    }

    @Test
    fun `每种风格都有 system prompt 和 3 条离线话术`() {
        for (style in StyleCatalog.all) {
            assertTrue("${style.id} 缺 systemPrompt", style.systemPrompt.isNotBlank())
            assertTrue("${style.id} 缺 tagline", style.tagline.isNotBlank())
            assertEquals("${style.id} 的 hints 数量不对", 3, style.hints.size)
        }
    }

    // -----------------------------------------------------------------------
    // temperature —— 4 个风格用默认值 0.8，最容易看错
    // -----------------------------------------------------------------------

    @Test
    fun `未显式指定 temperature 的风格取默认值 0_8`() {
        assertEquals(0.8f, StyleCatalog.byId("high_eq")!!.temperature, 0.0001f)
        assertEquals(0.8f, StyleCatalog.byId("soft_no")!!.temperature, 0.0001f)
        assertEquals(0.8f, StyleCatalog.byId("subtle")!!.temperature, 0.0001f)
        assertEquals(0.8f, StyleCatalog.byId("opener")!!.temperature, 0.0001f)
    }

    @Test
    fun `显式指定的 temperature`() {
        assertEquals(0.7f, StyleCatalog.byId("pro")!!.temperature, 0.0001f)
        assertEquals(0.5f, StyleCatalog.byId("hard_no")!!.temperature, 0.0001f)
        assertEquals(0.9f, StyleCatalog.byId("coquettish")!!.temperature, 0.0001f)
        assertEquals(0.6f, StyleCatalog.byId("aloof")!!.temperature, 0.0001f)
        assertEquals(0.9f, StyleCatalog.byId("flirty")!!.temperature, 0.0001f)
        assertEquals(1.0f, StyleCatalog.byId("funny")!!.temperature, 0.0001f)
        assertEquals(0.8f, StyleCatalog.byId("classical")!!.temperature, 0.0001f)
        assertEquals(0.6f, StyleCatalog.byId("service")!!.temperature, 0.0001f)
    }

    // -----------------------------------------------------------------------
    // 查询
    // -----------------------------------------------------------------------

    @Test
    fun `按 id 查询`() {
        assertNotNull(StyleCatalog.byId("service"))
        assertEquals("客服腔", StyleCatalog.byId("service")!!.name)
        assertNull(StyleCatalog.byId("not_exist"))
    }

    @Test
    fun `按场景分组`() {
        assertEquals(12, StyleCatalog.ofScene(Scene.ALL).size)
        assertEquals(3, StyleCatalog.ofScene(Scene.WORKPLACE).size)
        assertEquals(3, StyleCatalog.ofScene(Scene.LOVE).size)
        assertEquals(3, StyleCatalog.ofScene(Scene.SOCIAL).size)
        assertEquals(3, StyleCatalog.ofScene(Scene.GENERAL).size)
    }

    @Test
    fun `按 id 批量查询会跳过不存在的 id`() {
        val result = StyleCatalog.byIds(listOf("pro", "not_exist", "funny"))
        assertEquals(2, result.size)
        assertEquals(listOf("pro", "funny"), result.map { it.id })
    }

    // -----------------------------------------------------------------------
    // 场景内选中判定 —— 生成前校验用的就是它
    // -----------------------------------------------------------------------

    @Test
    fun `只统计当前场景下的选中项`() {
        val selected = listOf("high_eq", "pro", "funny")
        assertEquals(listOf("pro"), StyleCatalog.selectedInScene(selected, Scene.WORKPLACE).map { it.id })
        assertEquals(listOf("funny"), StyleCatalog.selectedInScene(selected, Scene.SOCIAL).map { it.id })
        assertEquals(
            listOf("high_eq"),
            StyleCatalog.selectedInScene(selected, Scene.GENERAL).map { it.id },
        )
    }

    @Test
    fun `ALL 场景放行全部选中项`() {
        val selected = listOf("high_eq", "pro", "funny")
        assertEquals(3, StyleCatalog.selectedInScene(selected, Scene.ALL).size)
    }

    @Test
    fun `切换场景后可能出现选中项为空`() {
        // 只选了「撒娇」（LOVE），切到职场场景就一个都不剩 —— 这正是
        // 「明明选了风格却提示至少选一种」的成因
        val selected = listOf("coquettish")
        assertTrue(StyleCatalog.selectedInScene(selected, Scene.LOVE).isNotEmpty())
        assertTrue(StyleCatalog.selectedInScene(selected, Scene.WORKPLACE).isEmpty())
        assertFalse(StyleCatalog.hasSelectionInScene(selected, Scene.WORKPLACE))
    }

    @Test
    fun `hasSelectionInScene 与 selectedInScene 一致`() {
        val selected = listOf("pro")
        for (scene in Scene.entries) {
            assertEquals(
                StyleCatalog.selectedInScene(selected, scene).isNotEmpty(),
                StyleCatalog.hasSelectionInScene(selected, scene),
            )
        }
    }
}
