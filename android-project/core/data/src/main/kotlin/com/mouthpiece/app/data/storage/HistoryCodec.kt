package com.mouthpiece.app.data.storage

import com.mouthpiece.app.model.HistoryItem
import org.json.JSONArray
import org.json.JSONObject

/**
 * 历史记录的 JSON 编解码。
 *
 * 用的是 Android 内置的 `org.json`，**不是** kotlinx.serialization。
 * 解码走「逐条容错」策略：单条解析失败只丢那一条，不影响整体；
 * 整体解析失败返回 `null`，由调用方决定是否回退到备份文件。
 */
object HistoryCodec {

    fun encode(items: List<HistoryItem>): String {
        val array = JSONArray()
        for (item in items) {
            array.put(
                JSONObject()
                    .put("id", item.id)
                    .put("incoming", item.incoming)
                    .put("reply", item.reply)
                    .put("styleName", item.styleName)
                    .put("createdAt", item.createdAt)
                    .put("favorite", item.favorite),
            )
        }
        return array.toString()
    }

    /** 容错解码，失败时返回空列表。 */
    fun decode(raw: String?): List<HistoryItem> = decodeOrNull(raw).orEmpty()

    /** 容错解码，失败时返回 `null`（调用方据此决定是否读备份）。 */
    fun decodeOrNull(raw: String?): List<HistoryItem>? {
        if (raw.isNullOrBlank()) return null
        return runCatching {
            val array = JSONArray(raw)
            (0 until array.length())
                .mapNotNull { index -> runCatching { readOne(array, index) }.getOrNull() }
                .sortedByDescending { it.createdAt }
        }.getOrNull()
    }

    private fun readOne(array: JSONArray, index: Int): HistoryItem {
        val json = array.getJSONObject(index)
        return HistoryItem(
            id = json.optLong("id"),
            incoming = json.optString("incoming"),
            reply = json.optString("reply"),
            styleName = json.optString("styleName"),
            createdAt = json.optLong("createdAt"),
            favorite = json.optBoolean("favorite"),
        )
    }
}
