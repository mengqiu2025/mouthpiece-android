package com.mouthpiece.app.push;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.mouthpiece.app.data.SettingsStore;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DailyPushWorker.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/mouthpiece/app/push/DailyPushWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendDailyTip", "", "sendStreakIfNeeded", "store", "Lcom/mouthpiece/app/data/SettingsStore;", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DailyPushWorker extends CoroutineWorker {
    public static final int ID_STREAK = 1002;
    public static final int ID_TIP = 1001;
    public static final String KEY_TYPE = "push_type";
    public static final String TYPE_STREAK = "streak";
    public static final String TYPE_TIP = "daily_tip";
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyPushWorker(Context appContext, WorkerParameters params) {
        super(appContext, params);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        Object objM7545constructorimpl;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        SettingsStore store = new SettingsStore(applicationContext);
        if (!store.getSettings().getValue().getNotifyEnabled()) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
            return resultSuccess;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DailyPushWorker dailyPushWorker = this;
            if (Intrinsics.areEqual(dailyPushWorker.getInputData().getString(KEY_TYPE), TYPE_STREAK)) {
                dailyPushWorker.sendStreakIfNeeded(store);
            } else {
                dailyPushWorker.sendDailyTip();
            }
            objM7545constructorimpl = Result.m7545constructorimpl(ListenableWorker.Result.success());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7548exceptionOrNullimpl(objM7545constructorimpl) == null) {
            return objM7545constructorimpl;
        }
        ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess2, "success(...)");
        return resultSuccess2;
    }

    private final void sendDailyTip() {
        DailyTip tip = DailyTipCatalog.today$default(DailyTipCatalog.INSTANCE, 0L, 1, null);
        PushNotifier pushNotifier = PushNotifier.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        pushNotifier.show(applicationContext, 1001, tip.getTitle(), tip.getBody());
    }

    private final void sendStreakIfNeeded(SettingsStore store) {
        if (Intrinsics.areEqual(store.lastActiveDate(), store.today())) {
            return;
        }
        PushNotifier pushNotifier = PushNotifier.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        pushNotifier.show(applicationContext, 1002, DailyTipCatalog.STREAK_TITLE, DailyTipCatalog.STREAK_BODY);
    }
}
