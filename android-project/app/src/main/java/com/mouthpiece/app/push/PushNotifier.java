package com.mouthpiece.app.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.mouthpiece.app.MainActivity;
import com.mouthpiece.app.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushNotifier.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ(\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/mouthpiece/app/push/PushNotifier;", "", "<init>", "()V", "CHANNEL_ID", "", "ensureChannel", "", "context", "Landroid/content/Context;", "canNotify", "", "show", "id", "", "title", "body", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushNotifier {
    public static final int $stable = 0;
    public static final String CHANNEL_ID = "mouthpiece_daily";
    public static final PushNotifier INSTANCE = new PushNotifier();

    private PushNotifier() {
    }

    public final void ensureChannel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManager manager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (manager != null && manager.getNotificationChannel(CHANNEL_ID) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "每日话术", 3);
            notificationChannel.setDescription("每天一条沟通话术灵感，以及断签提醒");
            manager.createNotificationChannel(notificationChannel);
        }
    }

    public final boolean canNotify(Context context) {
        Object objM7545constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            PushNotifier pushNotifier = this;
            objM7545constructorimpl = Result.m7545constructorimpl(Boolean.valueOf(NotificationManagerCompat.from(context).areNotificationsEnabled()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7551isFailureimpl(objM7545constructorimpl)) {
            objM7545constructorimpl = false;
        }
        return ((Boolean) objM7545constructorimpl).booleanValue();
    }

    public final void show(Context context, int id, String title, String body) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        ensureChannel(context);
        if (canNotify(context)) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setFlags(335544320);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent, 201326592);
            Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_notification).setContentTitle(title).setContentText(body).setStyle(new NotificationCompat.BigTextStyle().bigText(body)).setContentIntent(pendingIntent).setAutoCancel(true).setPriority(0).build();
            Intrinsics.checkNotNullExpressionValue(notification, "build(...)");
            try {
                Result.Companion companion = Result.INSTANCE;
                PushNotifier pushNotifier = this;
                NotificationManagerCompat.from(context).notify(id, notification);
                Result.m7545constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7545constructorimpl(ResultKt.createFailure(th));
            }
        }
    }
}
