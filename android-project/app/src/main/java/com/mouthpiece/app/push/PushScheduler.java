package com.mouthpiece.app.push;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mouthpiece/app/push/PushScheduler;", "", "<init>", "()V", "WORK_TIP", "", "WORK_STREAK", "sync", "", "context", "Landroid/content/Context;", "enabled", "", "hour", "", "force", "previewNow", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "request", "Landroidx/work/PeriodicWorkRequest;", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushScheduler {
    public static final int $stable = 0;
    public static final PushScheduler INSTANCE = new PushScheduler();
    private static final String WORK_STREAK = "mouthpiece_streak";
    private static final String WORK_TIP = "mouthpiece_daily_tip";

    private PushScheduler() {
    }

    public static /* synthetic */ void sync$default(PushScheduler pushScheduler, Context context, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        pushScheduler.sync(context, z, i, z2);
    }

    public final void sync(Context context, boolean enabled, int hour, boolean force) {
        ExistingPeriodicWorkPolicy policy;
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager manager = WorkManager.INSTANCE.getInstance(context);
        if (!enabled) {
            manager.cancelUniqueWork(WORK_TIP);
            manager.cancelUniqueWork(WORK_STREAK);
            return;
        }
        if (force) {
            policy = ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE;
        } else {
            policy = ExistingPeriodicWorkPolicy.KEEP;
        }
        manager.enqueueUniquePeriodicWork(WORK_TIP, policy, request(DailyPushWorker.TYPE_TIP, hour));
        manager.enqueueUniquePeriodicWork(WORK_STREAK, policy, request(DailyPushWorker.TYPE_STREAK, 21));
    }

    public static /* synthetic */ void previewNow$default(PushScheduler pushScheduler, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = DailyPushWorker.TYPE_TIP;
        }
        pushScheduler.previewNow(context, str);
    }

    public final void previewNow(Context context, String type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        WorkManager companion = WorkManager.INSTANCE.getInstance(context);
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) DailyPushWorker.class);
        Pair[] pairArr = {TuplesKt.to(DailyPushWorker.KEY_TYPE, type)};
        Data.Builder builder2 = new Data.Builder();
        for (Pair pair : pairArr) {
            builder2.put((String) pair.getFirst(), pair.getSecond());
        }
        companion.enqueue(builder.setInputData(builder2.build()).build());
    }

    private final PeriodicWorkRequest request(String type, int hour) {
        PeriodicWorkRequest.Builder initialDelay = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) DailyPushWorker.class, 24L, TimeUnit.HOURS).setInitialDelay(PushTime.millisUntil$default(PushTime.INSTANCE, hour, 0L, 2, null), TimeUnit.MILLISECONDS);
        Pair[] pairArr = {TuplesKt.to(DailyPushWorker.KEY_TYPE, type)};
        Data.Builder builder = new Data.Builder();
        for (Pair pair : pairArr) {
            builder.put((String) pair.getFirst(), pair.getSecond());
        }
        return initialDelay.setInputData(builder.build()).build();
    }
}
