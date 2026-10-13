package com.mouthpiece.app.model

/**
 * 应用设置。
 *
 * 默认值全部按反编译结果 1:1 还原，注意 [watermark] 默认是 **true**。
 */
data class AppSettings(
    val baseUrl: String = DEFAULT_BASE_URL,
    val apiKey: String = "",
    val model: String = DEFAULT_MODEL,
    /** 分享卡片是否带水印。注意默认是 **true**。 */
    val watermark: Boolean = true,
    val incognito: Boolean = false,
    val personaId: String? = null,
    val notifyEnabled: Boolean = false,
    val notifyHour: Int = DEFAULT_NOTIFY_HOUR,
) {
    /** 只有填了 API Key 才算「AI 可用」；否则全部走离线模板。 */
    val aiReady: Boolean get() = apiKey.isNotBlank()

    companion object {
        const val DEFAULT_BASE_URL = "https://api.openai.com/v1"
        const val DEFAULT_MODEL = "gpt-4o-mini"

        /** 每天免费生成次数。 */
        const val FREE_DAILY_QUOTA = 10

        const val DEFAULT_NOTIFY_HOUR = 9

        /** 「断签提醒」用的晚间时段。 */
        const val STREAK_NOTIFY_HOUR = 21

        /** 设置页可选的通知时间。 */
        val NOTIFY_HOURS = listOf(8, 9, 12, 20)
    }
}
