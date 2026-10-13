package com.mouthpiece.app.ui;

import com.mouthpiece.app.domain.Persona;
import com.mouthpiece.app.vm.PersonaViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class AppRootKt$AppRoot$5$1$19$1 extends FunctionReferenceImpl implements Function1<Persona, Unit> {
    AppRootKt$AppRoot$5$1$19$1(Object obj) {
        super(1, obj, PersonaViewModel.class, "save", "save(Lcom/mouthpiece/app/domain/Persona;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persona persona) {
        invoke2(persona);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Persona p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PersonaViewModel) this.receiver).save(p0);
    }
}
