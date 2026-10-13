package com.mouthpiece.app.ui;

import com.mouthpiece.app.vm.SettingsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$24$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    AppRootKt$AppRoot$5$1$24$1(Object obj) {
        super(1, obj, SettingsViewModel.class, "setWatermark", "setWatermark(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p0) {
        ((SettingsViewModel) this.receiver).setWatermark(p0);
    }
}
