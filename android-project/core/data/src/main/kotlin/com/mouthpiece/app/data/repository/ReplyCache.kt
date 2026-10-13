package com.mouthpiece.app.data.repository

import com.mouthpiece.app.model.Reply
import java.util.Collections

/** 内存缓存默认上限。 */
const val REPLY_CACHE_MAX = 200

/**
 * 回复内存缓存：**访问序 LRU**，超过 [maxEntries] 自动淘汰最久未用的条目。
 *
 * 从 `ReplyRepository` 中抽出，使「缓存策略」与「生成编排」各自独立可测。
 * 内部用 `Collections.synchronizedMap` 包裹一个 `accessOrder = true` 的
 * `LinkedHashMap`，多风格并发生成时（每种风格一个协程）也安全。
 */
class ReplyCache(private val maxEntries: Int = REPLY_CACHE_MAX) {

    private val map: MutableMap<String, Reply> = Collections.synchronizedMap(
        object : LinkedHashMap<String, Reply>(
            /* initialCapacity = */ 16,
            /* loadFactor = */ 0.75f,
            /* accessOrder = */ true,
        ) {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, Reply>): Boolean =
                size > maxEntries
        },
    )

    val size: Int get() = map.size

    operator fun get(key: String): Reply? = map[key]

    operator fun set(key: String, reply: Reply) {
        map[key] = reply
    }

    fun clear() {
        map.clear()
    }
}
