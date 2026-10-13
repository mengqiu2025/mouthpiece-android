package com.mouthpiece.app.ui;

import com.mouthpiece.app.vm.MainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$9$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    AppRootKt$AppRoot$5$1$9$1(Object obj) {
        super(1, obj, MainViewModel.class, "onStrengthChange", "onStrengthChange(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int p0) {
        ((MainViewModel) this.receiver).onStrengthChange(p0);
    }
}
