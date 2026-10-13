package com.mouthpiece.app.model

/** 一条可直接发送的回复。 */
data class Reply(
    val styleId: String,
    val styleName: String,
    val emoji: String,
    val text: String,
    val source: ReplySource,
)
