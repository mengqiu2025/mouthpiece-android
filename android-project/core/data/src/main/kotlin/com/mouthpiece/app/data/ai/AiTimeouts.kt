package com.mouthpiece.app.data.ai

/** AI 请求的超时预算。 */
object AiTimeouts {

    /** 单次请求的读超时。 */
    const val READ_MS = 25_000

    /** 端到端预算（连接 + 重试）。 */
    const val TOTAL_MS = 40_000L
}
