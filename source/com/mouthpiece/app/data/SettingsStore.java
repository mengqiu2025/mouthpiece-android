package com.mouthpiece.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.QuotaState;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Stores.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006%"}, d2 = {"Lcom/mouthpiece/app/data/SettingsStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "_settings", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mouthpiece/app/domain/AppSettings;", "settings", "Lkotlinx/coroutines/flow/StateFlow;", "getSettings", "()Lkotlinx/coroutines/flow/StateFlow;", "_quota", "Lcom/mouthpiece/app/domain/QuotaState;", "quota", "getQuota", "loadSettings", "loadQuota", "rollOverIfNewDay", "", "update", "block", "Lkotlin/Function1;", "lastActiveDate", "", "today", "checkQuota", "consumeQuota", "setPro", "value", "", "clearAll", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsStore {

    @Deprecated
    public static final String KEY_API_KEY = "api_key";

    @Deprecated
    public static final String KEY_BASE_URL = "base_url";

    @Deprecated
    public static final String KEY_INCOGNITO = "incognito";

    @Deprecated
    public static final String KEY_LAST_ACTIVE = "last_active_date";

    @Deprecated
    public static final String KEY_MODEL = "model";

    @Deprecated
    public static final String KEY_NOTIFY_ENABLED = "notify_enabled";

    @Deprecated
    public static final String KEY_NOTIFY_HOUR = "notify_hour";

    @Deprecated
    public static final String KEY_PERSONA_ID = "persona_id";

    @Deprecated
    public static final String KEY_PRO = "is_pro";

    @Deprecated
    public static final String KEY_QUOTA_DATE = "quota_date";

    @Deprecated
    public static final String KEY_QUOTA_USED = "quota_used";

    @Deprecated
    public static final String KEY_WATERMARK = "watermark";
    private final MutableStateFlow<QuotaState> _quota;
    private final MutableStateFlow<AppSettings> _settings;
    private final SharedPreferences prefs;
    private final StateFlow<QuotaState> quota;
    private final StateFlow<AppSettings> settings;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SettingsStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences("mouthpiece_settings", 0);
        this._settings = StateFlowKt.MutableStateFlow(loadSettings());
        this.settings = FlowKt.asStateFlow(this._settings);
        this._quota = StateFlowKt.MutableStateFlow(loadQuota());
        this.quota = FlowKt.asStateFlow(this._quota);
    }

    public final StateFlow<AppSettings> getSettings() {
        return this.settings;
    }

    public final StateFlow<QuotaState> getQuota() {
        return this.quota;
    }

    private final AppSettings loadSettings() {
        String string = this.prefs.getString(KEY_BASE_URL, null);
        if (string == null) {
            string = AppSettings.DEFAULT_BASE_URL;
        }
        String string2 = this.prefs.getString(KEY_API_KEY, "");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = this.prefs.getString(KEY_MODEL, null);
        if (string3 == null) {
            string3 = AppSettings.DEFAULT_MODEL;
        }
        return new AppSettings(string, string2, string3, this.prefs.getBoolean(KEY_WATERMARK, true), this.prefs.getBoolean(KEY_INCOGNITO, false), this.prefs.getString(KEY_PERSONA_ID, null), this.prefs.getBoolean(KEY_NOTIFY_ENABLED, false), this.prefs.getInt(KEY_NOTIFY_HOUR, 9));
    }

    private final QuotaState loadQuota() {
        rollOverIfNewDay();
        return new QuotaState(this.prefs.getInt(KEY_QUOTA_USED, 0), 10, this.prefs.getBoolean(KEY_PRO, false));
    }

    private final void rollOverIfNewDay() {
        String today = today();
        if (!Intrinsics.areEqual(this.prefs.getString(KEY_QUOTA_DATE, null), today)) {
            this.prefs.edit().putString(KEY_QUOTA_DATE, today).putInt(KEY_QUOTA_USED, 0).apply();
        }
    }

    public final void update(Function1<? super AppSettings, AppSettings> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AppSettings next = block.invoke(this._settings.getValue());
        this.prefs.edit().putString(KEY_BASE_URL, next.getBaseUrl()).putString(KEY_API_KEY, next.getApiKey()).putString(KEY_MODEL, next.getModel()).putBoolean(KEY_WATERMARK, next.getWatermark()).putBoolean(KEY_INCOGNITO, next.getIncognito()).putString(KEY_PERSONA_ID, next.getPersonaId()).putBoolean(KEY_NOTIFY_ENABLED, next.getNotifyEnabled()).putInt(KEY_NOTIFY_HOUR, next.getNotifyHour()).apply();
        this._settings.setValue(next);
    }

    public final String lastActiveDate() {
        return this.prefs.getString(KEY_LAST_ACTIVE, null);
    }

    public final String today() {
        String string = LocalDate.now().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String checkQuota() {
        rollOverIfNewDay();
        QuotaState q = loadQuota();
        this._quota.setValue(q);
        if (q.getExhausted()) {
            return "今天的免费次数用完了，明天再来，或升级会员解锁无限次。";
        }
        return null;
    }

    public final void consumeQuota() {
        rollOverIfNewDay();
        int used = this.prefs.getInt(KEY_QUOTA_USED, 0) + 1;
        this.prefs.edit().putInt(KEY_QUOTA_USED, used).putString(KEY_LAST_ACTIVE, today()).apply();
        this._quota.setValue(loadQuota());
    }

    public final void setPro(boolean value) {
        this.prefs.edit().putBoolean(KEY_PRO, value).apply();
        this._quota.setValue(loadQuota());
    }

    public final void clearAll() {
        this.prefs.edit().clear().apply();
        this._settings.setValue(loadSettings());
        this._quota.setValue(loadQuota());
    }

    /* JADX INFO: compiled from: Stores.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mouthpiece/app/data/SettingsStore$Companion;", "", "<init>", "()V", "KEY_BASE_URL", "", "KEY_API_KEY", "KEY_MODEL", "KEY_WATERMARK", "KEY_INCOGNITO", "KEY_PERSONA_ID", "KEY_QUOTA_DATE", "KEY_QUOTA_USED", "KEY_PRO", "KEY_NOTIFY_ENABLED", "KEY_NOTIFY_HOUR", "KEY_LAST_ACTIVE", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
