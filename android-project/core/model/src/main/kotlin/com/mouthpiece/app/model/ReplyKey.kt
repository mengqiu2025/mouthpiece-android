package com.mouthpiece.app.model

/**
 * 收藏去重键。
 *
 * 原项目里这个类位于 `vm/MainViewModel.kt`（跟着 `MainUiState.favoriteKeys` 走），
 * 但语义上属于领域模型，这里一并归入 model 层。
 */
data class ReplyKey(
    val incoming: String,
    val reply: String,
)
