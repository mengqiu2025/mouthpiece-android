package com.mouthpiece.app.model

/** 生成状态机。 */
sealed class GenState {

    data object Idle : GenState()

    /** [done] 是「已完成的风格数」，用于进度显示。 */
    data class Loading(val done: Int, val total: Int) : GenState()

    data class Done(val replies: List<Reply>) : GenState()

    /**
     * 注意：生成主流程**不会**进入这个状态 —— 无论成败最终都落到 [Done]，
     * 单条失败信息通过 `MainUiState.aiError` 展示。此状态是预留。
     */
    data class Failed(val message: String) : GenState()
}
