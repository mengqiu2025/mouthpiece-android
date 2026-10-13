package com.mouthpiece.app.vm;

import com.mouthpiece.app.data.ReplyRepository;
import com.mouthpiece.app.domain.GenState;
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.domain.ReplyRequest;
import com.mouthpiece.app.domain.ReplySource;
import com.mouthpiece.app.domain.StylePreset;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$startGeneration$4$2$1", f = "MainViewModel.kt", i = {1, 1}, l = {277, 409}, m = "invokeSuspend", n = {"outcome", "$this$withLock_u24default\\3"}, s = {"L$0", "L$1"})
final class MainViewModel$startGeneration$4$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $bypassCache;
    final /* synthetic */ List<ReplyRepository.Outcome> $collected;
    final /* synthetic */ List<String> $errors;
    final /* synthetic */ Mutex $lock;
    final /* synthetic */ ReplyRequest $request;
    final /* synthetic */ int $seed;
    final /* synthetic */ StylePreset $style;
    final /* synthetic */ List<StylePreset> $styles;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ MainViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainViewModel$startGeneration$4$2$1(Mutex mutex, MainViewModel mainViewModel, ReplyRequest replyRequest, StylePreset stylePreset, int i, boolean z, List<ReplyRepository.Outcome> list, List<String> list2, List<StylePreset> list3, Continuation<? super MainViewModel$startGeneration$4$2$1> continuation) {
        super(2, continuation);
        this.$lock = mutex;
        this.this$0 = mainViewModel;
        this.$request = replyRequest;
        this.$style = stylePreset;
        this.$seed = i;
        this.$bypassCache = z;
        this.$collected = list;
        this.$errors = list2;
        this.$styles = list3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainViewModel$startGeneration$4$2$1 mainViewModel$startGeneration$4$2$1 = new MainViewModel$startGeneration$4$2$1(this.$lock, this.this$0, this.$request, this.$style, this.$seed, this.$bypassCache, this.$collected, this.$errors, this.$styles, continuation);
        mainViewModel$startGeneration$4$2$1.L$0 = obj;
        return mainViewModel$startGeneration$4$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainViewModel$startGeneration$4$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0090  */
    /* JADX WARN: Code duplicated, block: B:34:0x00dc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ec A[Catch: all -> 0x0147, TryCatch #1 {all -> 0x0147, blocks: (B:37:0x00e0, B:39:0x00ec, B:40:0x00f3, B:41:0x00f8, B:43:0x013d), top: B:52:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x014c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) throws Throwable {
        Object $result2;
        Object $result3;
        Throwable th;
        Object objM7545constructorimpl;
        StylePreset stylePreset;
        Throwable thM7548exceptionOrNullimpl;
        ReplyRepository.Outcome outcome;
        Mutex mutex;
        List<ReplyRepository.Outcome> list;
        MainViewModel mainViewModel;
        List<String> list2;
        List<StylePreset> list3;
        Object obj;
        List<ReplyRepository.Outcome> list4;
        String error;
        MutableStateFlow mutableStateFlow;
        Object value;
        MainUiState mainUiState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                MainViewModel mainViewModel2 = this.this$0;
                ReplyRequest replyRequest = this.$request;
                StylePreset stylePreset2 = this.$style;
                int i = this.$seed;
                boolean z = this.$bypassCache;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ReplyRepository replyRepository = mainViewModel2.repository;
                    boolean z2 = z;
                    this.label = 1;
                    $result3 = replyRepository.generateOutcome(replyRequest, stylePreset2, i, z2, this);
                    if ($result3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objM7545constructorimpl = Result.m7545constructorimpl((ReplyRepository.Outcome) $result3);
                    stylePreset = this.$style;
                    thM7548exceptionOrNullimpl = Result.m7548exceptionOrNullimpl(objM7545constructorimpl);
                    if (thM7548exceptionOrNullimpl != null) {
                        if (!(thM7548exceptionOrNullimpl instanceof CancellationException)) {
                            throw thM7548exceptionOrNullimpl;
                        }
                        objM7545constructorimpl = new ReplyRepository.Outcome(new Reply(stylePreset.getId(), stylePreset.getName(), stylePreset.getEmoji(), "这次没生成出来，点「换一批」再试试。", ReplySource.LOCAL), thM7548exceptionOrNullimpl.getMessage(), false, 4, null);
                    }
                    outcome = (ReplyRepository.Outcome) objM7545constructorimpl;
                    mutex = this.$lock;
                    list = this.$collected;
                    mainViewModel = this.this$0;
                    list2 = this.$errors;
                    list3 = this.$styles;
                    obj = null;
                    this.L$0 = outcome;
                    this.L$1 = mutex;
                    this.L$2 = list;
                    this.L$3 = mainViewModel;
                    this.L$4 = list2;
                    this.L$5 = list3;
                    this.label = 2;
                    if (mutex.lock(null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list4 = list;
                    try {
                        list4.add(outcome);
                        error = outcome.getError();
                        if (error != null) {
                            list2.add(error);
                        }
                        mutableStateFlow = mainViewModel._ui;
                        do {
                            value = mutableStateFlow.getValue();
                            mainUiState = (MainUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : new GenState.Loading(list4.size(), list3.size()), (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
                        Unit unit = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    } finally {
                        mutex.unlock(obj);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
                }
                break;
            case 1:
                $result3 = $result;
                try {
                    ResultKt.throwOnFailure($result3);
                    $result2 = $result3;
                    objM7545constructorimpl = Result.m7545constructorimpl((ReplyRepository.Outcome) $result3);
                } catch (Throwable th3) {
                    th = th3;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
                }
                stylePreset = this.$style;
                thM7548exceptionOrNullimpl = Result.m7548exceptionOrNullimpl(objM7545constructorimpl);
                if (thM7548exceptionOrNullimpl != null) {
                    if (!(thM7548exceptionOrNullimpl instanceof CancellationException)) {
                        throw thM7548exceptionOrNullimpl;
                    }
                    objM7545constructorimpl = new ReplyRepository.Outcome(new Reply(stylePreset.getId(), stylePreset.getName(), stylePreset.getEmoji(), "这次没生成出来，点「换一批」再试试。", ReplySource.LOCAL), thM7548exceptionOrNullimpl.getMessage(), false, 4, null);
                }
                outcome = (ReplyRepository.Outcome) objM7545constructorimpl;
                mutex = this.$lock;
                list = this.$collected;
                mainViewModel = this.this$0;
                list2 = this.$errors;
                list3 = this.$styles;
                obj = null;
                this.L$0 = outcome;
                this.L$1 = mutex;
                this.L$2 = list;
                this.L$3 = mainViewModel;
                this.L$4 = list2;
                this.L$5 = list3;
                this.label = 2;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list4 = list;
                list4.add(outcome);
                error = outcome.getError();
                if (error != null) {
                    list2.add(error);
                }
                mutableStateFlow = mainViewModel._ui;
                do {
                    value = mutableStateFlow.getValue();
                    mainUiState = (MainUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : new GenState.Loading(list4.size(), list3.size()), (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
                Unit unit2 = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 2:
                list3 = (List) this.L$5;
                list2 = (List) this.L$4;
                mainViewModel = (MainViewModel) this.L$3;
                list4 = (List) this.L$2;
                obj = null;
                mutex = (Mutex) this.L$1;
                outcome = (ReplyRepository.Outcome) this.L$0;
                ResultKt.throwOnFailure($result);
                list4.add(outcome);
                error = outcome.getError();
                if (error != null) {
                    list2.add(error);
                }
                mutableStateFlow = mainViewModel._ui;
                do {
                    value = mutableStateFlow.getValue();
                    mainUiState = (MainUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : new GenState.Loading(list4.size(), list3.size()), (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
                Unit unit3 = Unit.INSTANCE;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
