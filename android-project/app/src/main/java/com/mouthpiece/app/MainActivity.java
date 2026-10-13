package com.mouthpiece.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\r"}, d2 = {"Lcom/mouthpiece/app/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "extractSharedText", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String strExtractSharedText;
        super.onCreate(savedInstanceState);
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        serviceLocator.init(applicationContext);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        if (savedInstanceState == null && (strExtractSharedText = extractSharedText(getIntent())) != null) {
            ServiceLocator.INSTANCE.emitSharedText(strExtractSharedText);
        }
        ComponentActivityKt.setContent$default(this, null, ComposableSingletons$MainActivityKt.INSTANCE.m7496getLambda$1548998213$app_debug(), 1, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        String strExtractSharedText = extractSharedText(intent);
        if (strExtractSharedText != null) {
            ServiceLocator.INSTANCE.emitSharedText(strExtractSharedText);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String extractSharedText(Intent intent) {
        String raw;
        String string;
        CharSequence charSequenceExtra;
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1173264947:
                    raw = action.equals("android.intent.action.SEND") ? intent.getStringExtra("android.intent.extra.TEXT") : null;
                    break;
                case 1703997026:
                    raw = (!action.equals("android.intent.action.PROCESS_TEXT") || (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.PROCESS_TEXT")) == null) ? null : charSequenceExtra.toString();
                    break;
                default:
                    raw = null;
                    break;
            }
        } else {
            raw = null;
        }
        if (raw == null || (string = StringsKt.trim((CharSequence) raw).toString()) == null) {
            return null;
        }
        if (string.length() > 0) {
            return string;
        }
        return null;
    }
}
