package com.mouthpiece.app.ui;

import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.vm.MainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$4$1 extends FunctionReferenceImpl implements Function1<Reply, Unit> {
    AppRootKt$AppRoot$5$1$4$1(Object obj) {
        super(1, obj, MainViewModel.class, "shareReply", "shareReply(Lcom/mouthpiece/app/domain/Reply;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Reply reply) {
        invoke2(reply);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Reply p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MainViewModel) this.receiver).shareReply(p0);
    }
}
