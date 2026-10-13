package com.mouthpiece.app.data.storage

import android.content.Context
import com.mouthpiece.app.model.AppSettings
import com.mouthpiece.app.model.QuotaState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate

/**
 * 设置 + 免费配额持久化（SharedPreferences）。
 *
 * 存储选型说明：别被 APK 里的 `androidx.room.*` 类误导 —— 那是 WorkManager
 * 的传递依赖，本应用**没有**用 Room，设置走的是 SharedPreferences。
 *
 * 会员（`is_pro`）是个**纯本地开关**，原实现没有接任何支付逻辑。
 */
class SettingsStore(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _settings = MutableStateFlow(loadSettings())
    val settings: StateFlow<AppSettings> = _settings.asStateFlow()

    private val _quota = MutableStateFlow(loadQuota())
    val quota: StateFlow<QuotaState> = _quota.asStateFlow()

    private fun loadSettings(): AppSettings = AppSettings(
        baseUrl = prefs.getString(KEY_BASE_URL, null) ?: AppSettings.DEFAULT_BASE_URL,
        apiKey = prefs.getString(KEY_API_KEY, "") ?: "",
        model = prefs.getString(KEY_MODEL, null) ?: AppSettings.DEFAULT_MODEL,
        watermark = prefs.getBoolean(KEY_WATERMARK, true),
        incognito = prefs.getBoolean(KEY_INCOGNITO, false),
        personaId = prefs.getString(KEY_PERSONA_ID, null),
        notifyEnabled = prefs.getBoolean(KEY_NOTIFY_ENABLED, false),
        notifyHour = prefs.getInt(KEY_NOTIFY_HOUR, AppSettings.DEFAULT_NOTIFY_HOUR),
    )

    private fun loadQuota(): QuotaState {
        rollOverIfNewDay()
        return QuotaState(
            used = prefs.getInt(KEY_QUOTA_USED, 0),
            limit = AppSettings.FREE_DAILY_QUOTA,
            isPro = prefs.getBoolean(KEY_PRO, false),
        )
    }

    /** 跨天则把当天用量清零。每次读配额前都会先跑一遍。 */
    private fun rollOverIfNewDay() {
        val today = today()
        if (prefs.getString(KEY_QUOTA_DATE, null) != today) {
            prefs.edit().putString(KEY_QUOTA_DATE, today).putInt(KEY_QUOTA_USED, 0).apply()
        }
    }

    fun update(block: (AppSettings) -> AppSettings) {
        val next = block(_settings.value)
        prefs.edit()
            .putString(KEY_BASE_URL, next.baseUrl)
            .putString(KEY_API_KEY, next.apiKey)
            .putString(KEY_MODEL, next.model)
            .putBoolean(KEY_WATERMARK, next.watermark)
            .putBoolean(KEY_INCOGNITO, next.incognito)
            .putString(KEY_PERSONA_ID, next.personaId)
            .putBoolean(KEY_NOTIFY_ENABLED, next.notifyEnabled)
            .putInt(KEY_NOTIFY_HOUR, next.notifyHour)
            .apply()
        _settings.value = next
    }

    /** 最近一次真正用掉配额（或收藏）的日期，用于「断签提醒」。 */
    fun lastActiveDate(): String? = prefs.getString(KEY_LAST_ACTIVE, null)

    fun today(): String = LocalDate.now().toString()

    /**
     * 生成前的配额校验。
     *
     * @return 额度耗尽时返回提示文案；可用返回 `null`。
     */
    fun checkQuota(): String? {
        rollOverIfNewDay()
        val state = loadQuota()
        _quota.value = state
        return if (state.exhausted) "今天的免费次数用完了，明天再来，或升级会员解锁无限次。" else null
    }

    /** 扣一次额度，同时刷新「最近活跃日期」。 */
    fun consumeQuota() {
        rollOverIfNewDay()
        val used = prefs.getInt(KEY_QUOTA_USED, 0) + 1
        prefs.edit()
            .putInt(KEY_QUOTA_USED, used)
            .putString(KEY_LAST_ACTIVE, today())
            .apply()
        _quota.value = loadQuota()
    }

    /** 模拟会员开关。注意：**没有接任何支付逻辑**，纯本地。 */
    fun setPro(value: Boolean) {
        prefs.edit().putBoolean(KEY_PRO, value).apply()
        _quota.value = loadQuota()
    }

    fun clearAll() {
        prefs.edit().clear().apply()
        _settings.value = loadSettings()
        _quota.value = loadQuota()
    }

    companion object {
        private const val PREFS_NAME = "mouthpiece_settings"

        const val KEY_BASE_URL = "base_url"
        const val KEY_API_KEY = "api_key"
        const val KEY_MODEL = "model"
        const val KEY_WATERMARK = "watermark"
        const val KEY_INCOGNITO = "incognito"
        const val KEY_PERSONA_ID = "persona_id"
        const val KEY_QUOTA_DATE = "quota_date"
        const val KEY_QUOTA_USED = "quota_used"
        const val KEY_PRO = "is_pro"
        const val KEY_NOTIFY_ENABLED = "notify_enabled"
        const val KEY_NOTIFY_HOUR = "notify_hour"
        const val KEY_LAST_ACTIVE = "last_active_date"
    }
}
