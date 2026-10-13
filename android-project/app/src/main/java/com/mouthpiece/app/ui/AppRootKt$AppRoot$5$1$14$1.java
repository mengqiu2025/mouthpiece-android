package com.mouthpiece.app.ui;

import com.mouthpiece.app.vm.HistoryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$14$1 extends FunctionReferenceImpl implements Function0<Unit> {
    AppRootKt$AppRoot$5$1$14$1(Object obj) {
        super(0, obj, HistoryViewModel.class, "toggleOnlyFavorite", "toggleOnlyFavorite()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((HistoryViewModel) this.receiver).toggleOnlyFavorite();
    }
}
