package com.mouthpiece.app.push;

import java.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: compiled from: PushTime.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/mouthpiece/app/push/PushTime;", "", "<init>", "()V", "millisUntil", "", "hour", "", "now", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushTime {
    public static final int $stable = 0;
    public static final PushTime INSTANCE = new PushTime();

    private PushTime() {
    }

    public static /* synthetic */ long millisUntil$default(PushTime pushTime, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return pushTime.millisUntil(i, j);
    }

    public final long millisUntil(int hour, long now) {
        Calendar target = Calendar.getInstance();
        target.setTimeInMillis(now);
        target.set(11, hour);
        target.set(12, 0);
        target.set(13, 0);
        target.set(14, 0);
        if (target.getTimeInMillis() <= now) {
            target.add(6, 1);
        }
        return target.getTimeInMillis() - now;
    }
}
