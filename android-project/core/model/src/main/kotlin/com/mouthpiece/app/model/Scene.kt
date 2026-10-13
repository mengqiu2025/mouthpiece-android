package com.mouthpiece.app.model

/**
 * 风格所属场景。
 *
 * [ALL] 是一个「不过滤」的伪场景，不是真实分类 —— 用它查询时会放行全部风格。
 */
enum class Scene(val label: String) {
    ALL("全部"),
    WORKPLACE("职场"),
    LOVE("恋爱"),
    SOCIAL("社交"),
    GENERAL("通用"),
}
