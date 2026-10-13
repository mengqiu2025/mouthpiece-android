package com.mouthpiece.app.ui;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.State;
import com.mouthpiece.app.vm.MainUiState;
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

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.ui.AppRootKt$AppRoot$2$1", f = "AppRoot.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
final class AppRootKt$AppRoot$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<MainUiState> $mainState$delegate;
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppRootKt$AppRoot$2$1(State<MainUiState> state, SnackbarHostState snackbarHostState, MainViewModel mainViewModel, Continuation<? super AppRootKt$AppRoot$2$1> continuation) {
        super(2, continuation);
        this.$mainState$delegate = state;
        this.$snackbarHostState = snackbarHostState;
        this.$mainViewModel = mainViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppRootKt$AppRoot$2$1(this.$mainState$delegate, this.$snackbarHostState, this.$mainViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppRootKt$AppRoot$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        MainViewModel mainViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String message = AppRootKt.AppRoot$lambda$1(this.$mainState$delegate).getMessage();
                if (message != null) {
                    SnackbarHostState snackbarHostState = this.$snackbarHostState;
                    MainViewModel mainViewModel2 = this.$mainViewModel;
                    this.L$0 = mainViewModel2;
                    this.label = 1;
                    if (SnackbarHostState.showSnackbar$default(snackbarHostState, message, null, false, null, this, 14, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mainViewModel = mainViewModel2;
                    mainViewModel.consumeMessage();
                }
                return Unit.INSTANCE;
            case 1:
                mainViewModel = (MainViewModel) this.L$0;
                ResultKt.throwOnFailure($result);
                mainViewModel.consumeMessage();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
