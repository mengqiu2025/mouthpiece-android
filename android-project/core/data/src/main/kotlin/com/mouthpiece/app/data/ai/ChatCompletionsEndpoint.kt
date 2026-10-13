package com.mouthpiece.app.data.ai

/**
 * 把用户填的 baseUrl 拼成 chat/completions 端点。
 *
 * - `https://api.openai.com/v1` → `https://api.openai.com/v1/chat/completions`
 * - 已经带 `/chat/completions` 的地址原样返回
 * - 空字符串返回空串（调用前会被「未配置接口地址」拦下）
 */
fun chatCompletionsEndpoint(baseUrl: String): String {
    val trimmed = baseUrl.trim().trimEnd('/')
    if (trimmed.isEmpty()) return ""
    return if (trimmed.endsWith("/chat/completions")) trimmed else "$trimmed/chat/completions"
}
