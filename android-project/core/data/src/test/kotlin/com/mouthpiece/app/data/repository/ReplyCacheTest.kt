package com.mouthpiece.app.data.repository

import com.mouthpiece.app.model.Reply
import com.mouthpiece.app.model.ReplySource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Test

/**
 * LRU 缓存的回归测试。
 *
 * 这份测试是为了证明「把内嵌的 `LinkedHashMap` 抽成独立的 [ReplyCache]」
 * 没有改变缓存语义：访问序淘汰、容量上限、清空。
 */
class ReplyCacheTest {

    private fun reply(text: String) = Reply(
        styleId = "pro",
        styleName = "职场得体",
        emoji = "💼",
        text = text,
        source = ReplySource.AI,
    )

    @Test
    fun `未命中返回 null`() {
        assertNull(ReplyCache().get("missing"))
    }

    @Test
    fun `写入后可读回同一个实例`() {
        val cache = ReplyCache()
        val value = reply("收到")
        cache["k"] = value
        assertSame(value, cache["k"])
    }

    @Test
    fun `超过上限后淘汰最久未用的条目`() {
        val cache = ReplyCache(maxEntries = 2)
        cache["a"] = reply("A")
        cache["b"] = reply("B")
        cache["c"] = reply("C")

        assertEquals(2, cache.size)
        assertNull(cache["a"])
        assertEquals("B", cache["b"]!!.text)
        assertEquals("C", cache["c"]!!.text)
    }

    @Test
    fun `被访问过的条目会变成最近使用`() {
        val cache = ReplyCache(maxEntries = 2)
        cache["a"] = reply("A")
        cache["b"] = reply("B")

        // 访问 a → a 变成最近使用，接下来插入 c 应该淘汰 b
        cache["a"]
        cache["c"] = reply("C")

        assertEquals("A", cache["a"]!!.text)
        assertNull(cache["b"])
        assertEquals("C", cache["c"]!!.text)
    }

    @Test
    fun `clear 清空全部条目`() {
        val cache = ReplyCache()
        cache["a"] = reply("A")
        cache.clear()
        assertEquals(0, cache.size)
        assertNull(cache["a"])
    }

    @Test
    fun `默认上限为 200`() {
        assertEquals(200, REPLY_CACHE_MAX)
        val cache = ReplyCache()
        repeat(250) { index -> cache["k$index"] = reply("R$index") }
        assertEquals(REPLY_CACHE_MAX, cache.size)
    }
}
