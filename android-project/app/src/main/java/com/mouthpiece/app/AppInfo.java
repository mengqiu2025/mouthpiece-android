package com.mouthpiece.app;

import kotlin.Metadata;

/* JADX INFO: compiled from: AppInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/mouthpiece/app/AppInfo;", "", "<init>", "()V", "CHANNEL", "", "versionLabel", "getVersionLabel", "()Ljava/lang/String;", "buildNumber", "", "getBuildNumber", "()I", "versionWithBuild", "getVersionWithBuild", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppInfo {
    public static final int $stable = 0;
    public static final String CHANNEL = "内测版";
    public static final AppInfo INSTANCE = new AppInfo();

    private AppInfo() {
    }

    public final String getVersionLabel() {
        return "内测版 v0.1.4";
    }

    public final int getBuildNumber() {
        return 5;
    }

    public final String getVersionWithBuild() {
        return "v0.1.4 (" + getBuildNumber() + ")";
    }
}
