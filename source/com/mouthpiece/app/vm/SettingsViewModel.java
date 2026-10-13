package com.mouthpiece.app.vm;

import androidx.lifecycle.ViewModel;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mouthpiece.app.ServiceLocator;
import com.mouthpiece.app.data.HistoryStore;
import com.mouthpiece.app.data.PersonaStore;
import com.mouthpiece.app.data.SettingsStore;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.QuotaState;
import com.mouthpiece.app.push.DailyPushWorker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: AppViewModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006$"}, d2 = {"Lcom/mouthpiece/app/vm/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "settings", "Lcom/mouthpiece/app/data/SettingsStore;", "history", "Lcom/mouthpiece/app/data/HistoryStore;", "personas", "Lcom/mouthpiece/app/data/PersonaStore;", "<init>", "(Lcom/mouthpiece/app/data/SettingsStore;Lcom/mouthpiece/app/data/HistoryStore;Lcom/mouthpiece/app/data/PersonaStore;)V", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/mouthpiece/app/domain/AppSettings;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "quota", "Lcom/mouthpiece/app/domain/QuotaState;", "getQuota", "setBaseUrl", "", "value", "", "setApiKey", "setModel", "setWatermark", "", "setIncognito", "setPro", "setNotifyEnabled", "setNotifyHour", "hour", "", "previewPush", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "clearHistory", "clearEverything", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final HistoryStore history;
    private final PersonaStore personas;
    private final StateFlow<QuotaState> quota;
    private final SettingsStore settings;
    private final StateFlow<AppSettings> state;

    public SettingsViewModel(SettingsStore settings, HistoryStore history, PersonaStore personas) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(history, "history");
        Intrinsics.checkNotNullParameter(personas, "personas");
        this.settings = settings;
        this.history = history;
        this.personas = personas;
        this.state = this.settings.getSettings();
        this.quota = this.settings.getQuota();
    }

    public final StateFlow<AppSettings> getState() {
        return this.state;
    }

    public final StateFlow<QuotaState> getQuota() {
        return this.quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setBaseUrl$lambda$0(String $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, StringsKt.trim((CharSequence) $value).toString(), null, null, false, false, null, false, 0, 254, null);
    }

    public final void setBaseUrl(final String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setBaseUrl$lambda$0(value, (AppSettings) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setApiKey$lambda$1(String $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, StringsKt.trim((CharSequence) $value).toString(), null, false, false, null, false, 0, 253, null);
    }

    public final void setApiKey(final String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setApiKey$lambda$1(value, (AppSettings) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setModel$lambda$2(String $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, StringsKt.trim((CharSequence) $value).toString(), false, false, null, false, 0, 251, null);
    }

    public final void setModel(final String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setModel$lambda$2(value, (AppSettings) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setWatermark$lambda$3(boolean $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, null, $value, false, null, false, 0, 247, null);
    }

    public final void setWatermark(final boolean value) {
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setWatermark$lambda$3(value, (AppSettings) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setIncognito$lambda$4(boolean $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, null, false, $value, null, false, 0, 239, null);
    }

    public final void setIncognito(final boolean value) {
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setIncognito$lambda$4(value, (AppSettings) obj);
            }
        });
    }

    public final void setPro(boolean value) {
        this.settings.setPro(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setNotifyEnabled$lambda$5(boolean $value, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, null, false, false, null, $value, 0, 191, null);
    }

    public final void setNotifyEnabled(final boolean value) {
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setNotifyEnabled$lambda$5(value, (AppSettings) obj);
            }
        });
        ServiceLocator.INSTANCE.syncPushSchedule(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings setNotifyHour$lambda$6(int $hour, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, null, false, false, null, false, $hour, WorkQueueKt.MASK, null);
    }

    public final void setNotifyHour(final int hour) {
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.SettingsViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsViewModel.setNotifyHour$lambda$6(hour, (AppSettings) obj);
            }
        });
        ServiceLocator.INSTANCE.syncPushSchedule(true);
    }

    public static /* synthetic */ void previewPush$default(SettingsViewModel settingsViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DailyPushWorker.TYPE_TIP;
        }
        settingsViewModel.previewPush(str);
    }

    public final void previewPush(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ServiceLocator.INSTANCE.previewPush(type);
    }

    public final void clearHistory() {
        this.history.clear();
    }

    public final void clearEverything() {
        this.history.clear();
        this.personas.clear();
        this.settings.clearAll();
    }
}
