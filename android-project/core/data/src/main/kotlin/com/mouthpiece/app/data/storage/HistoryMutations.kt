package com.mouthpiece.app.data.storage

import com.mouthpiece.app.model.HistoryItem

/**
 * 历史的纯函数变换。
 *
 * 抽出来的目的是可测试：不碰 SharedPreferences、不碰文件、不碰协程。
 * [newId] 与 [now] 都从外部注入，测试时可以直接给固定值。
 */
object HistoryMutations {

    /**
     * 切换某条回复的收藏状态。
     *
     * 用 `(incoming, reply)` 二元组定位条目 —— 这也是历史的去重键。
     * 条目不存在时会**新建一条并置为已收藏**，放在列表最前面。
     *
     * @return 变换后的新列表（原列表不被修改）
     */
    fun toggleFavorite(
        items: List<HistoryItem>,
        incoming: String,
        reply: String,
        styleName: String,
        newId: () -> Long,
        now: Long,
    ): List<HistoryItem> {
        val existing = items.firstOrNull { it.incoming == incoming && it.reply == reply }

        if (existing == null) {
            val created = HistoryItem(
                id = newId(),
                incoming = incoming,
                reply = reply,
                styleName = styleName,
                createdAt = now,
                favorite = true,
            )
            return listOf(created) + items
        }

        return items.map { item ->
            if (item.id == existing.id) item.copy(favorite = !item.favorite) else item
        }
    }
}
