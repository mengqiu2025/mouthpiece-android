package com.mouthpiece.app.model

/**
 * 配额状态。
 *
 * [isPro] 是个**纯本地开关**，原实现没有接任何支付逻辑。
 */
data class QuotaState(
    val used: Int,
    val limit: Int,
    val isPro: Boolean,
) {
    val remaining: Int
        get() = if (isPro) Int.MAX_VALUE else maxOf(limit - used, 0)

    val exhausted: Boolean
        get() = !isPro && used >= limit
}
