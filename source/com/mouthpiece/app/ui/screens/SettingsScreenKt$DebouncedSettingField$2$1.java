package com.mouthpiece.app.ui.screens;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.ui.screens.SettingsScreenKt$DebouncedSettingField$2$1", f = "SettingsScreen.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
final class SettingsScreenKt$DebouncedSettingField$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $draft$delegate;
    final /* synthetic */ Function1<String, Unit> $onCommit;
    final /* synthetic */ String $value;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SettingsScreenKt$DebouncedSettingField$2$1(String str, Function1<? super String, Unit> function1, MutableState<String> mutableState, Continuation<? super SettingsScreenKt$DebouncedSettingField$2$1> continuation) {
        super(2, continuation);
        this.$value = str;
        this.$onCommit = function1;
        this.$draft$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsScreenKt$DebouncedSettingField$2$1(this.$value, this.$onCommit, this.$draft$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsScreenKt$DebouncedSettingField$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(SettingsScreenKt.DebouncedSettingField$lambda$16(this.$draft$delegate), this.$value)) {
                    return Unit.INSTANCE;
                }
                this.label = 1;
                if (DelayKt.delay(400L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$onCommit.invoke(SettingsScreenKt.DebouncedSettingField$lambda$16(this.$draft$delegate));
        return Unit.INSTANCE;
    }
}
