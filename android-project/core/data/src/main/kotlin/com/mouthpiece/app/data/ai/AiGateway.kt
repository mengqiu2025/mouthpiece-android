package com.mouthpiece.app.data.ai

/**
 * AI 网关接口。只有一个方法：给 system + user，返回一段文本。
 *
 * 业务语义（风格、强度、说话对象）全部通过提示词注入，网关本身不感知。
 */
interface AiGateway {
    suspend fun complete(system: String, user: String, temperature: Float): String
}
