package com.mouthpiece.app.model

/** 一条历史记录。 */
data class HistoryItem(
    val id: Long,
    val incoming: String,
    val reply: String,
    val styleName: String,
    val createdAt: Long,
    val favorite: Boolean = false,
)
