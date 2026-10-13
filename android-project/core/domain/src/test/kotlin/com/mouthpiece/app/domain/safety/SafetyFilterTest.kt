package com.mouthpiece.app.domain.safety

import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * 安全过滤的行为断言。
 *
 * 注意几处**反直觉但确实如此**的行为，都是原实现的真实语义
 * （已用字节码逐条核对，见 core/README.md 的「反编译错误修正」）：
 *
 * 1. 输入黑名单是 **24 条精确短语**，不是关键词。列表里只有「怎么开盒」
 *    「如何开盒」「帮我开盒」「开盒教程」「开盒方法」，**没有裸的「开盒」**。
 *    所以「开盒」两个字本身不会被拦。
 * 2. 否定前缀只回看命中位置**前 3 个字符**，且必须**紧贴**命中词。
 *    「防诈骗话术」放行，但「如何防范诈骗话术」会被拦（回看窗口取到的是「何防范」）。
 * 3. `isOutputSafe` 的语义是「安全返回 true」。空白文本视为**不安全**。
 */
class SafetyFilterTest {

    // -----------------------------------------------------------------------
    // validateInput —— 基础校验
    // -----------------------------------------------------------------------

    @Test
    fun `空输入被拦截`() {
        assertNotNull(SafetyFilter.validateInput(""))
        assertNotNull(SafetyFilter.validateInput("   "))
    }

    @Test
    fun `超过 600 字被拦截`() {
        assertNotNull(SafetyFilter.validateInput("啊".repeat(601)))
        assertNull(SafetyFilter.validateInput("啊".repeat(600)))
    }

    @Test
    fun `正常输入放行`() {
        assertNull(SafetyFilter.validateInput("老板问我这个需求今晚能不能给"))
        assertNull(SafetyFilter.validateInput("帮我看看这个"))
    }

    @Test
    fun `命中输入黑名单被拦截`() {
        assertNotNull(SafetyFilter.validateInput("怎么开盒"))
        assertNotNull(SafetyFilter.validateInput("帮我开盒"))
        assertNotNull(SafetyFilter.validateInput("诈骗话术"))
        assertNotNull(SafetyFilter.validateInput("怎么网暴"))
        assertNotNull(SafetyFilter.validateInput("人肉搜索教程"))
    }

    // -----------------------------------------------------------------------
    // 输入黑名单是「精确短语」
    // -----------------------------------------------------------------------

    @Test
    fun `输入黑名单不含裸的「开盒」`() {
        // 列表里是「怎么开盒 / 如何开盒 / 帮我开盒 / 开盒教程 / 开盒方法」，
        // 没有单独的「开盒」—— 这是原实现的一个覆盖缺口，不是重写引入的
        assertNull(SafetyFilter.validateInput("开盒"))
        assertNull(SafetyFilter.validateInput("不要开盒"))
        assertNull(SafetyFilter.validateInput("我想开盒"))
        // 但带上具体短语就会被拦
        assertNotNull(SafetyFilter.validateInput("开盒教程"))
        assertNotNull(SafetyFilter.validateInput("我想学开盒教程"))
    }

    @Test
    fun `输入黑名单不含裸的「人肉搜索」`() {
        assertNull(SafetyFilter.validateInput("人肉搜索"))
        assertNotNull(SafetyFilter.validateInput("人肉搜索教程"))
    }

    // -----------------------------------------------------------------------
    // 否定前缀白名单 —— 最容易写错的地方
    // -----------------------------------------------------------------------

    @Test
    fun `紧贴命中词的否定前缀可以豁免`() {
        assertNull(SafetyFilter.validateInput("不要怎么开盒"))
        assertNull(SafetyFilter.validateInput("拒绝帮我开盒"))
        assertNull(SafetyFilter.validateInput("防诈骗话术"))
        assertNull(SafetyFilter.validateInput("避免开盒教程"))
    }

    @Test
    fun `没有否定前缀则拦截`() {
        assertNotNull(SafetyFilter.validateInput("教我开盒教程"))
        assertNotNull(SafetyFilter.validateInput("怎么开盒"))
    }

    @Test
    fun `回看窗口只有 3 个字符`() {
        // 「不要」紧贴命中词 → 豁免
        assertNull(SafetyFilter.validateInput("不要怎么开盒"))
        // 中间隔了 3 个字符，窗口取到的是「嗯嗯嗯」 → 不豁免
        assertNotNull(SafetyFilter.validateInput("不要嗯嗯嗯怎么开盒"))
    }

    @Test
    fun `否定词出现在命中词之后就无效`() {
        // 「防」必须在「诈骗话术」前面才生效
        assertNull(SafetyFilter.validateInput("防诈骗话术"))
        assertNotNull(SafetyFilter.validateInput("诈骗话术，请注意防范"))
    }

    @Test
    fun `同一个词出现多次时只要有一处没被豁免就拦截`() {
        // 第一处「不要怎么开盒」被豁免，第二处「如何开盒」没有被豁免
        assertNotNull(SafetyFilter.validateInput("不要怎么开盒，如何开盒"))
    }

    // -----------------------------------------------------------------------
    // isOutputSafe —— 安全返回 true
    // -----------------------------------------------------------------------

    @Test
    fun `空白输出视为不安全`() {
        assertFalse(SafetyFilter.isOutputSafe(""))
        assertFalse(SafetyFilter.isOutputSafe("   "))
    }

    @Test
    fun `正常输出是安全的`() {
        assertTrue(SafetyFilter.isOutputSafe("收到，我先同步一下目前的进度。"))
    }

    @Test
    fun `命中输出黑名单则不安全`() {
        assertFalse(SafetyFilter.isOutputSafe("这是诈骗"))
        assertFalse(SafetyFilter.isOutputSafe("教你怎么开盒"))
        assertFalse(SafetyFilter.isOutputSafe("我帮你人肉他"))
    }

    @Test
    fun `输出黑名单比输入黑名单更宽`() {
        // 输出侧有裸的「开盒」和「人肉」，输入侧没有
        assertFalse(SafetyFilter.isOutputSafe("开盒"))
        assertFalse(SafetyFilter.isOutputSafe("人肉"))
    }

    @Test
    fun `输出侧同样享受否定前缀豁免`() {
        // 「防」紧贴在「诈骗」前面
        assertTrue(SafetyFilter.isOutputSafe("这是防诈骗提示"))
        // 否定词在后面 → 不豁免
        assertFalse(SafetyFilter.isOutputSafe("这是诈骗，请不要相信"))
    }
}
