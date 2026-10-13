package com.mouthpiece.app.data.repository

import com.mouthpiece.app.model.AppSettings
import com.mouthpiece.app.model.ReplyRequest
import com.mouthpiece.app.model.StylePreset

/**
 * 生成结果的缓存键。
 *
 * 七段拼接，每段格式为 `长度:值|`（长度前缀避免分隔符歧义）。
 * 换模型、换风格、换强度、换说话对象、改补充要求、改原话 —— 任一变化都会 miss。
 */
fun replyCacheKey(
    request: ReplyRequest,
    style: StylePreset,
    config: AppSettings,
): String = buildString {
    field(config.baseUrl.trim())
    field(config.model.trim())
    field(style.id)
    field(request.strength.toString())
    field(request.persona?.id ?: "")
    field(request.extraHint.trim())
    field(request.incoming.trim())
}

private fun StringBuilder.field(value: String) {
    append(value.length).append(':').append(value).append('|')
}
