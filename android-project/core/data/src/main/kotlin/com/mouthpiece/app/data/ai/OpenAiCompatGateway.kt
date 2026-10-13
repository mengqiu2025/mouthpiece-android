package com.mouthpiece.app.data.ai

import com.mouthpiece.app.model.AppSettings
import kotlinx.coroutines.suspendCancellableCoroutine
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.URL
import java.net.UnknownHostException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * OpenAI 兼容协议实现（裸 [HttpURLConnection]，不依赖 OkHttp）。
 *
 * 兼容性设计：
 * - 首轮带 `reasoning_effort = "max"`；若服务端返回 400 且响应体提到
 *   `reasoning` / `effort`，则判定为「不支持该参数」并去掉它重试一次。
 * - 若返回内容为空且 `finish_reason == "length"`，说明被 `max_tokens` 截断，
 *   放大到 4096 重试一次。
 *
 * 构造参数用 `() -> AppSettings` 而不是 `AppSettings`，这样设置改了不用重建网关。
 */
class OpenAiCompatGateway(
    private val settingsProvider: () -> AppSettings,
) : AiGateway {

    override suspend fun complete(system: String, user: String, temperature: Float): String =
        request(system, user, temperature)

    private suspend fun request(system: String, user: String, temperature: Float): String {
        val config = settingsProvider()
        if (config.apiKey.isBlank()) throw IOException("未配置 API Key")
        if (config.baseUrl.isBlank()) throw IOException("未配置接口地址")
        if (config.model.isBlank()) throw IOException("未配置模型名")

        val endpoint = chatCompletionsEndpoint(config.baseUrl)
        val messages = JSONArray()
            .put(JSONObject().put("role", "system").put("content", system))
            .put(JSONObject().put("role", "user").put("content", user))

        // 第一轮：带 reasoning_effort
        var response = call(
            endpoint,
            config.apiKey,
            buildBody(config, temperature, messages, MAX_TOKENS, REASONING_EFFORT),
        )

        // 服务端明确拒绝 reasoning_effort → 去掉该参数重试一次
        if (response.code == HTTP_BAD_REQUEST && looksLikeUnsupportedReasoningParam(response.body)) {
            response = call(
                endpoint,
                config.apiKey,
                buildBody(config, temperature, messages, MAX_TOKENS, null),
            )
        }

        if (response.code !in 200..299) {
            throw IOException(httpErrorMessage(response.code))
        }

        var parsed = parse(response.body)

        // 被 max_tokens 截断 → 放大上限重试一次
        if (parsed.content.isEmpty() && parsed.finishReason == FINISH_REASON_LENGTH) {
            val retry = call(
                endpoint,
                config.apiKey,
                buildBody(config, temperature, messages, MAX_TOKENS_RETRY, null),
            )
            if (retry.code !in 200..299) {
                throw IOException(httpErrorMessage(retry.code))
            }
            parsed = parse(retry.body)
        }

        if (parsed.content.isEmpty()) throw IOException("模型返回空内容")

        return parsed.content.trim(*TRIM_CHARS)
    }

    // -----------------------------------------------------------------------
    // 请求体
    // -----------------------------------------------------------------------

    private fun buildBody(
        config: AppSettings,
        temperature: Float,
        messages: JSONArray,
        maxTokens: Int,
        effort: String?,
    ): String {
        val json = JSONObject()
            .put("model", config.model)
            .put("temperature", temperature.toDouble())
            .put("max_tokens", maxTokens)
            .put("messages", messages)
        if (effort != null) json.put("reasoning_effort", effort)
        return json.toString()
    }

    // -----------------------------------------------------------------------
    // HTTP
    // -----------------------------------------------------------------------

    // URL(String) 在 JDK 20+ 被标记为 deprecated，但 Android 上没有这个问题；
    // 保持与原实现一致的写法，避免引入 URI 解析的行为差异。
    @Suppress("DEPRECATION")
    private fun open(endpoint: String, apiKey: String): HttpURLConnection {
        val connection = URL(endpoint).openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.connectTimeout = CONNECT_TIMEOUT_MS
        connection.readTimeout = AiTimeouts.READ_MS
        connection.doOutput = true
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8")
        connection.setRequestProperty("Authorization", "Bearer $apiKey")
        return connection
    }

    private fun execute(connection: HttpURLConnection, body: String): Response {
        connection.outputStream.use { it.write(body.toByteArray(Charsets.UTF_8)) }

        val code = connection.responseCode
        val stream = if (code in 200..299) connection.inputStream else connection.errorStream
        val text = stream?.bufferedReader(Charsets.UTF_8)?.use { it.readText() }.orEmpty()

        if (code !in 200..299) connection.disconnect()
        return Response(code, text)
    }

    /**
     * 执行一次请求，并把取消信号转成 [HttpURLConnection.disconnect]。
     *
     * 阻塞式 HTTP 跑在调用方所在线程 —— 上层是在 `Dispatchers.IO` 上发起生成的，
     * 所以这里不再额外切换调度器。
     */
    private suspend fun call(endpoint: String, apiKey: String, body: String): Response {
        val connection = open(endpoint, apiKey)
        return suspendCancellableCoroutine { cont ->
            cont.invokeOnCancellation { connection.disconnect() }
            try {
                val response = execute(connection, body)
                if (cont.isActive) cont.resume(response)
            } catch (error: Throwable) {
                connection.disconnect()
                if (cont.isActive) cont.resumeWithException(friendlyNetworkError(error))
            }
        }
    }

    // -----------------------------------------------------------------------
    // 解析
    // -----------------------------------------------------------------------

    private fun parse(body: String): Parsed {
        val root = runCatching { JSONObject(body) }.getOrElse {
            throw IOException("服务端返回的不是合法 JSON")
        }
        val choices = root.optJSONArray("choices")
            ?: throw IOException("服务端返回缺少 choices 字段")
        if (choices.length() == 0) throw IOException("模型没有返回任何候选结果")

        val choice = choices.optJSONObject(0) ?: throw IOException("模型返回结构异常")
        val message = choice.optJSONObject("message") ?: throw IOException("模型返回结构异常")

        return Parsed(
            content = message.optNullableString("content").orEmpty(),
            finishReason = choice.optNullableString("finish_reason"),
        )
    }

    private fun looksLikeUnsupportedReasoningParam(body: String): Boolean {
        val lower = body.lowercase()
        return lower.contains("reasoning") || lower.contains("effort")
    }

    // -----------------------------------------------------------------------
    // 错误翻译
    // -----------------------------------------------------------------------

    private fun httpErrorMessage(code: Int): String = when (code) {
        HTTP_BAD_REQUEST -> "HTTP 400：请求被拒绝，通常是模型名或参数不被支持"
        401, 403 -> "HTTP $code：API Key 无效或没有权限"
        404 -> "HTTP 404：接口地址不存在，请检查是否填到 /v1 为止"
        408 -> "HTTP 408：服务端等待超时"
        413 -> "HTTP 413：请求体过大"
        429 -> "HTTP 429：请求过于频繁或余额/额度不足"
        in 500..599 -> "HTTP $code：服务端暂时不可用，请稍后重试"
        else -> "HTTP $code"
    }

    private fun friendlyNetworkError(error: Throwable): Throwable = when (error) {
        is SocketTimeoutException -> IOException("服务端响应超时（单次请求 25 秒），请稍后重试")
        is UnknownHostException -> IOException("无法解析接口地址，请检查网络与「设置 → AI 服务」里的地址")
        is ConnectException -> IOException("无法连接接口地址，请检查地址是否正确、网络是否可用")
        else -> error
    }

    // -----------------------------------------------------------------------
    // 内部类型与常量
    // -----------------------------------------------------------------------

    private data class Response(val code: Int, val body: String)

    private data class Parsed(val content: String, val finishReason: String?)

    companion object {
        const val MAX_TOKENS = 2048
        const val MAX_TOKENS_RETRY = 4096
        const val REASONING_EFFORT = "max"

        private const val CONNECT_TIMEOUT_MS = 8_000
        private const val HTTP_BAD_REQUEST = 400
        private const val FINISH_REASON_LENGTH = "length"

        /** 返回前裁掉的字符：`"` `“` `”` `\n` 空格 `\t` */
        private val TRIM_CHARS = charArrayOf('"', '\u201C', '\u201D', '\n', ' ', '\t')
    }
}
