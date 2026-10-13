package com.mouthpiece.app.data.ai

import org.json.JSONObject

/** 取可空字符串，并把 `"null"` / `"undefined"` / 空串统一视为 `null`。 */
fun JSONObject.optNullableString(key: String): String? {
    if (isNull(key)) return null
    val raw = optString(key).trim()
    if (raw.isEmpty() || raw == "null" || raw == "undefined") return null
    return raw
}
