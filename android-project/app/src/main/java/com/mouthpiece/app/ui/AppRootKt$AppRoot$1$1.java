package com.mouthpiece.app.ui;

import androidx.compose.runtime.MutableState;
import com.mouthpiece.app.vm.MainViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.ui.AppRootKt$AppRoot$1$1", f = "AppRoot.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
final class AppRootKt$AppRoot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ Flow<String> $sharedText;
    final /* synthetic */ MutableState<Tab> $tab$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppRootKt$AppRoot$1$1(Flow<String> flow, MainViewModel mainViewModel, MutableState<Tab> mutableState, Continuation<? super AppRootKt$AppRoot$1$1> continuation) {
        super(2, continuation);
        this.$sharedText = flow;
        this.$mainViewModel = mainViewModel;
        this.$tab$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppRootKt$AppRoot$1$1(this.$sharedText, this.$mainViewModel, this.$tab$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppRootKt$AppRoot$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<String> flow = this.$sharedText;
                final MainViewModel mainViewModel = this.$mainViewModel;
                final MutableState<Tab> mutableState = this.$tab$delegate;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: com.mouthpiece.app.ui.AppRootKt$AppRoot$1$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((String) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(String text, Continuation<? super Unit> continuation) {
                        mainViewModel.onSharedText(text);
                        AppRootKt.AppRoot$lambda$10(mutableState, Tab.GENERATE);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
