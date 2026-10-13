package com.mouthpiece.app.model

/**
 * 一次生成请求。
 *
 * [styles] 在仓储层会被拆成单风格请求（一次 [com.mouthpiece.app.data.ai.AiGateway.complete] 只负责一种风格）。
 */
data class ReplyRequest(
    val incoming: String,
    val styles: List<StylePreset>,
    /** 表达强度 1–5，越界时由 ViewModel 夹到区间内。 */
    val strength: Int,
    val persona: Persona?,
    val extraHint: String = "",
)
