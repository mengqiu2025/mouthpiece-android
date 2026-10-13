package com.mouthpiece.app.domain;

import com.mouthpiece.app.data.SettingsStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J[\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\fHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014¨\u0006*"}, d2 = {"Lcom/mouthpiece/app/domain/AppSettings;", "", "baseUrl", "", "apiKey", SettingsStore.KEY_MODEL, SettingsStore.KEY_WATERMARK, "", SettingsStore.KEY_INCOGNITO, "personaId", "notifyEnabled", "notifyHour", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZI)V", "getBaseUrl", "()Ljava/lang/String;", "getApiKey", "getModel", "getWatermark", "()Z", "getIncognito", "getPersonaId", "getNotifyEnabled", "getNotifyHour", "()I", "aiReady", "getAiReady", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AppSettings {
    public static final int $stable = 0;
    public static final String DEFAULT_BASE_URL = "https://api.openai.com/v1";
    public static final String DEFAULT_MODEL = "gpt-4o-mini";
    public static final int DEFAULT_NOTIFY_HOUR = 9;
    public static final int FREE_DAILY_QUOTA = 10;
    public static final int STREAK_NOTIFY_HOUR = 21;
    private final String apiKey;
    private final String baseUrl;
    private final boolean incognito;
    private final String model;
    private final boolean notifyEnabled;
    private final int notifyHour;
    private final String personaId;
    private final boolean watermark;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> NOTIFY_HOURS = CollectionsKt.listOf((Object[]) new Integer[]{8, 9, 12, 20});

    public AppSettings() {
        this(null, null, null, false, false, null, false, 0, 255, null);
    }

    public static /* synthetic */ AppSettings copy$default(AppSettings appSettings, String str, String str2, String str3, boolean z, boolean z2, String str4, boolean z3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appSettings.baseUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = appSettings.apiKey;
        }
        if ((i2 & 4) != 0) {
            str3 = appSettings.model;
        }
        if ((i2 & 8) != 0) {
            z = appSettings.watermark;
        }
        if ((i2 & 16) != 0) {
            z2 = appSettings.incognito;
        }
        if ((i2 & 32) != 0) {
            str4 = appSettings.personaId;
        }
        if ((i2 & 64) != 0) {
            z3 = appSettings.notifyEnabled;
        }
        if ((i2 & 128) != 0) {
            i = appSettings.notifyHour;
        }
        boolean z4 = z3;
        int i3 = i;
        boolean z5 = z2;
        String str5 = str4;
        return appSettings.copy(str, str2, str3, z, z5, str5, z4, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getWatermark() {
        return this.watermark;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIncognito() {
        return this.incognito;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPersonaId() {
        return this.personaId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getNotifyEnabled() {
        return this.notifyEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getNotifyHour() {
        return this.notifyHour;
    }

    public final AppSettings copy(String baseUrl, String apiKey, String model, boolean watermark, boolean incognito, String personaId, boolean notifyEnabled, int notifyHour) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(model, "model");
        return new AppSettings(baseUrl, apiKey, model, watermark, incognito, personaId, notifyEnabled, notifyHour);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSettings)) {
            return false;
        }
        AppSettings appSettings = (AppSettings) other;
        return Intrinsics.areEqual(this.baseUrl, appSettings.baseUrl) && Intrinsics.areEqual(this.apiKey, appSettings.apiKey) && Intrinsics.areEqual(this.model, appSettings.model) && this.watermark == appSettings.watermark && this.incognito == appSettings.incognito && Intrinsics.areEqual(this.personaId, appSettings.personaId) && this.notifyEnabled == appSettings.notifyEnabled && this.notifyHour == appSettings.notifyHour;
    }

    public int hashCode() {
        return (((((((((((((this.baseUrl.hashCode() * 31) + this.apiKey.hashCode()) * 31) + this.model.hashCode()) * 31) + Boolean.hashCode(this.watermark)) * 31) + Boolean.hashCode(this.incognito)) * 31) + (this.personaId == null ? 0 : this.personaId.hashCode())) * 31) + Boolean.hashCode(this.notifyEnabled)) * 31) + Integer.hashCode(this.notifyHour);
    }

    public String toString() {
        return "AppSettings(baseUrl=" + this.baseUrl + ", apiKey=" + this.apiKey + ", model=" + this.model + ", watermark=" + this.watermark + ", incognito=" + this.incognito + ", personaId=" + this.personaId + ", notifyEnabled=" + this.notifyEnabled + ", notifyHour=" + this.notifyHour + ")";
    }

    public AppSettings(String baseUrl, String apiKey, String model, boolean watermark, boolean incognito, String personaId, boolean notifyEnabled, int notifyHour) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(model, "model");
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.model = model;
        this.watermark = watermark;
        this.incognito = incognito;
        this.personaId = personaId;
        this.notifyEnabled = notifyEnabled;
        this.notifyHour = notifyHour;
    }

    public /* synthetic */ AppSettings(String str, String str2, String str3, boolean z, boolean z2, String str4, boolean z3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? DEFAULT_BASE_URL : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? DEFAULT_MODEL : str3, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? 9 : i);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getModel() {
        return this.model;
    }

    public final boolean getWatermark() {
        return this.watermark;
    }

    public final boolean getIncognito() {
        return this.incognito;
    }

    public final String getPersonaId() {
        return this.personaId;
    }

    public final boolean getNotifyEnabled() {
        return this.notifyEnabled;
    }

    public final int getNotifyHour() {
        return this.notifyHour;
    }

    public final boolean getAiReady() {
        return !StringsKt.isBlank(this.apiKey);
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/mouthpiece/app/domain/AppSettings$Companion;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "DEFAULT_MODEL", "FREE_DAILY_QUOTA", "", "DEFAULT_NOTIFY_HOUR", "STREAK_NOTIFY_HOUR", "NOTIFY_HOURS", "", "getNOTIFY_HOURS", "()Ljava/util/List;", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Integer> getNOTIFY_HOURS() {
            return AppSettings.NOTIFY_HOURS;
        }
    }
}
