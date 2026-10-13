package com.mouthpiece.app;

import android.app.Application;
import kotlin.Metadata;

/* JADX INFO: compiled from: MouthpieceApp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/mouthpiece/app/MouthpieceApp;", "Landroid/app/Application;", "<init>", "()V", "onCreate", "", "onTrimMemory", "level", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MouthpieceApp extends Application {
    public static final int $stable = 8;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        ServiceLocator.INSTANCE.init(this);
        ServiceLocator.syncPushSchedule$default(ServiceLocator.INSTANCE, false, 1, null);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == 20) {
            ServiceLocator.INSTANCE.flushHistory();
        }
    }
}
