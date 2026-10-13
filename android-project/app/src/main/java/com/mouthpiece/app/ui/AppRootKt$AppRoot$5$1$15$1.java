package com.mouthpiece.app.ui;

import com.mouthpiece.app.vm.HistoryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$15$1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    AppRootKt$AppRoot$5$1$15$1(Object obj) {
        super(1, obj, HistoryViewModel.class, "toggleFavorite", "toggleFavorite(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long p0) {
        ((HistoryViewModel) this.receiver).toggleFavorite(p0);
    }
}
