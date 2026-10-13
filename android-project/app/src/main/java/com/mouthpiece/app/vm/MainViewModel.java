package com.mouthpiece.app.vm;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mouthpiece.app.data.HistoryStore;
import com.mouthpiece.app.data.PersonaStore;
import com.mouthpiece.app.data.ReplyRepository;
import com.mouthpiece.app.data.SettingsStore;
import com.mouthpiece.app.data.ShareCardRenderer;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.HistoryItem;
import com.mouthpiece.app.domain.Persona;
import com.mouthpiece.app.domain.QuotaState;
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.domain.ReplyRequest;
import com.mouthpiece.app.domain.SafetyFilter;
import com.mouthpiece.app.domain.Scene;
import com.mouthpiece.app.domain.StyleCatalog;
import com.mouthpiece.app.domain.StylePreset;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020#J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001cJ\u0006\u0010(\u001a\u00020\u001aJ\u0006\u0010)\u001a\u00020\u001aJ\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0002J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/J\u0006\u00102\u001a\u00020\u001aJ\u0006\u00103\u001a\u00020\u001aJ\u0010\u00104\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/mouthpiece/app/vm/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/mouthpiece/app/data/ReplyRepository;", "settings", "Lcom/mouthpiece/app/data/SettingsStore;", "personas", "Lcom/mouthpiece/app/data/PersonaStore;", "history", "Lcom/mouthpiece/app/data/HistoryStore;", "cards", "Lcom/mouthpiece/app/data/ShareCardRenderer;", "appContext", "Landroid/content/Context;", "<init>", "(Lcom/mouthpiece/app/data/ReplyRepository;Lcom/mouthpiece/app/data/SettingsStore;Lcom/mouthpiece/app/data/PersonaStore;Lcom/mouthpiece/app/data/HistoryStore;Lcom/mouthpiece/app/data/ShareCardRenderer;Landroid/content/Context;)V", "_ui", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/mouthpiece/app/vm/MainUiState;", "ui", "Lkotlinx/coroutines/flow/StateFlow;", "getUi", "()Lkotlinx/coroutines/flow/StateFlow;", "generationJob", "Lkotlinx/coroutines/Job;", "onIncomingChange", "", "value", "", "onSharedText", "text", "onSceneChange", "scene", "Lcom/mouthpiece/app/domain/Scene;", "onStrengthChange", "", "onExtraHintChange", "onPersonaChange", "id", "toggleStyle", "generate", "regenerate", "startGeneration", "bypassCache", "", "copyReply", "reply", "Lcom/mouthpiece/app/domain/Reply;", "favoriteReply", "shareReply", "backToEdit", "consumeMessage", "remember", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainViewModel extends ViewModel {

    @Deprecated
    public static final int MAX_STYLES = 5;
    private final MutableStateFlow<MainUiState> _ui;
    private final Context appContext;
    private final ShareCardRenderer cards;
    private Job generationJob;
    private final HistoryStore history;
    private final PersonaStore personas;
    private final ReplyRepository repository;
    private final SettingsStore settings;
    private final StateFlow<MainUiState> ui;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MainViewModel(ReplyRepository repository, SettingsStore settings, PersonaStore personas, HistoryStore history, ShareCardRenderer cards, Context appContext) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(personas, "personas");
        Intrinsics.checkNotNullParameter(history, "history");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.repository = repository;
        this.settings = settings;
        this.personas = personas;
        this.history = history;
        this.cards = cards;
        this.appContext = appContext;
        this._ui = StateFlowKt.MutableStateFlow(new MainUiState(null, null, null, 0, null, null, null, false, null, null, false, false, null, false, null, 32767, null));
        this.ui = FlowKt.asStateFlow(this._ui);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final StateFlow<MainUiState> getUi() {
        return this.ui;
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$1", f = "MainViewModel.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow flowCombine = FlowKt.combine(MainViewModel.this.settings.getSettings(), MainViewModel.this.settings.getQuota(), MainViewModel.this.personas.getPersonas(), new C01601(null));
                    final MainViewModel mainViewModel = MainViewModel.this;
                    this.label = 1;
                    if (flowCombine.collect(new FlowCollector() { // from class: com.mouthpiece.app.vm.MainViewModel.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Triple<AppSettings, QuotaState, ? extends List<Persona>>) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Code duplicated, block: B:20:0x0068  */
                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(Triple<AppSettings, QuotaState, ? extends List<Persona>> triple, Continuation<? super Unit> continuation) {
                            boolean z;
                            boolean z2;
                            AppSettings appSettingsComponent1 = triple.component1();
                            QuotaState quotaStateComponent2 = triple.component2();
                            List<Persona> listComponent3 = triple.component3();
                            MutableStateFlow mutableStateFlow = mainViewModel._ui;
                            while (true) {
                                Object value = mutableStateFlow.getValue();
                                MainUiState mainUiState = (MainUiState) value;
                                String personaId = mainUiState.getPersonaId();
                                String str = null;
                                if (personaId != null) {
                                    List<Persona> list = listComponent3;
                                    if (!(list instanceof Collection) || !list.isEmpty()) {
                                        Iterator<T> it = list.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                z2 = false;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(((Persona) it.next()).getId(), personaId)) {
                                                z2 = true;
                                                break;
                                            }
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        personaId = null;
                                    }
                                } else {
                                    personaId = null;
                                }
                                String str2 = personaId;
                                String personaId2 = appSettingsComponent1.getPersonaId();
                                if (personaId2 != null) {
                                    List<Persona> list2 = listComponent3;
                                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                        Iterator<T> it2 = list2.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                z = false;
                                                break;
                                            }
                                            if (Intrinsics.areEqual(((Persona) it2.next()).getId(), personaId2)) {
                                                z = true;
                                                break;
                                            }
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        str = personaId2;
                                    }
                                }
                                MutableStateFlow mutableStateFlow2 = mutableStateFlow;
                                AppSettings appSettings = appSettingsComponent1;
                                List<Persona> list3 = listComponent3;
                                if (mutableStateFlow2.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : str2 == null ? str : str2, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : quotaStateComponent2, (31199 & 1024) != 0 ? mainUiState.aiReady : appSettingsComponent1.getAiReady(), (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null))) {
                                    return Unit.INSTANCE;
                                }
                                listComponent3 = list3;
                                mutableStateFlow = mutableStateFlow2;
                                appSettingsComponent1 = appSettings;
                            }
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

        /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00012\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/mouthpiece/app/domain/AppSettings;", "Lcom/mouthpiece/app/domain/QuotaState;", "", "Lcom/mouthpiece/app/domain/Persona;", "config", "quota", "list"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$1$1", f = "MainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01601 extends SuspendLambda implements Function4<AppSettings, QuotaState, List<? extends Persona>, Continuation<? super Triple<? extends AppSettings, ? extends QuotaState, ? extends List<? extends Persona>>>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            int label;

            C01601(Continuation<? super C01601> continuation) {
                super(4, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(AppSettings appSettings, QuotaState quotaState, List<Persona> list, Continuation<? super Triple<AppSettings, QuotaState, ? extends List<Persona>>> continuation) {
                C01601 c01601 = new C01601(continuation);
                c01601.L$0 = appSettings;
                c01601.L$1 = quotaState;
                c01601.L$2 = list;
                return c01601.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(AppSettings appSettings, QuotaState quotaState, List<? extends Persona> list, Continuation<? super Triple<? extends AppSettings, ? extends QuotaState, ? extends List<? extends Persona>>> continuation) {
                return invoke2(appSettings, quotaState, (List<Persona>) list, (Continuation<? super Triple<AppSettings, QuotaState, ? extends List<Persona>>>) continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        AppSettings config = (AppSettings) this.L$0;
                        QuotaState quota = (QuotaState) this.L$1;
                        List list = (List) this.L$2;
                        return new Triple(config, quota, list);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$2", f = "MainViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (MainViewModel.this.history.getItems().collect(new AnonymousClass1(MainViewModel.this), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainViewModel.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ MainViewModel this$0;

            AnonymousClass1(MainViewModel mainViewModel) {
                this.this$0 = mainViewModel;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((List<HistoryItem>) value, (Continuation<? super Unit>) $completion);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Object emit(List<HistoryItem> list, Continuation<? super Unit> continuation) {
                Object value;
                MainUiState mainUiState;
                Collection hashSet;
                MutableStateFlow mutableStateFlow = this.this$0._ui;
                do {
                    value = mutableStateFlow.getValue();
                    mainUiState = (MainUiState) value;
                    Sequence<HistoryItem> sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(list), new Function1() { // from class: com.mouthpiece.app.vm.MainViewModel$2$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(MainViewModel.AnonymousClass2.AnonymousClass1.emit$lambda$2$lambda$0((HistoryItem) obj));
                        }
                    });
                    hashSet = new HashSet();
                    for (HistoryItem historyItem : sequenceFilter) {
                        hashSet.add(new ReplyKey(historyItem.getIncoming(), historyItem.getReply()));
                    }
                } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : (Set) hashSet)));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean emit$lambda$2$lambda$0(HistoryItem it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFavorite();
            }
        }
    }

    public final void onIncomingChange(String value) {
        MainUiState value2;
        MainUiState mainUiState;
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value2 = mutableStateFlow.getValue();
            mainUiState = value2;
        } while (!mutableStateFlow.compareAndSet(value2, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : StringsKt.take(value, SafetyFilter.HARD_INPUT_LIMIT), (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : value.length() > 6000, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void onSharedText(String text) {
        MainUiState value;
        MainUiState mainUiState;
        String string;
        Intrinsics.checkNotNullParameter(text, "text");
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
            string = StringsKt.trim((CharSequence) text).toString();
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : StringsKt.take(string, SafetyFilter.HARD_INPUT_LIMIT), (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : string.length() > 6000, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void onSceneChange(Scene scene) {
        Scene scene2 = scene;
        Intrinsics.checkNotNullParameter(scene2, "scene");
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        while (true) {
            MainUiState value = mutableStateFlow.getValue();
            MutableStateFlow<MainUiState> mutableStateFlow2 = mutableStateFlow;
            MainUiState mainUiState = value;
            if (mutableStateFlow2.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : scene2, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null))) {
                return;
            }
            scene2 = scene;
            mutableStateFlow = mutableStateFlow2;
        }
    }

    public final void onStrengthChange(int value) {
        MainUiState value2;
        MainUiState mainUiState;
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value2 = mutableStateFlow.getValue();
            mainUiState = value2;
        } while (!mutableStateFlow.compareAndSet(value2, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : RangesKt.coerceIn(value, 1, 5), (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void onExtraHintChange(String value) {
        MainUiState value2;
        MainUiState mainUiState;
        Intrinsics.checkNotNullParameter(value, "value");
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value2 = mutableStateFlow.getValue();
            mainUiState = value2;
        } while (!mutableStateFlow.compareAndSet(value2, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : StringsKt.take(value, 60), (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void onPersonaChange(final String id) {
        MainUiState value;
        MainUiState mainUiState;
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : id, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
        this.settings.update(new Function1() { // from class: com.mouthpiece.app.vm.MainViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainViewModel.onPersonaChange$lambda$6(id, (AppSettings) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings onPersonaChange$lambda$6(String $id, AppSettings it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AppSettings.copy$default(it, null, null, null, false, false, $id, false, 0, 223, null);
    }

    public final void toggleStyle(String id) {
        MainUiState value;
        MainUiState mainUiState;
        MainUiState value2;
        MainUiState mainUiState2;
        MainUiState value3;
        MainUiState mainUiState3;
        Intrinsics.checkNotNullParameter(id, "id");
        List<String> selectedStyleIds = this._ui.getValue().getSelectedStyleIds();
        if (!selectedStyleIds.contains(id)) {
            if (selectedStyleIds.size() < 5) {
                MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
                do {
                    value = mutableStateFlow.getValue();
                    mainUiState = value;
                } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : CollectionsKt.plus((Collection<? extends String>) selectedStyleIds, id), (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
                return;
            }
            MutableStateFlow<MainUiState> mutableStateFlow2 = this._ui;
            do {
                value2 = mutableStateFlow2.getValue();
                mainUiState2 = value2;
            } while (!mutableStateFlow2.compareAndSet(value2, mainUiState2.copy((31199 & 1) != 0 ? mainUiState2.incoming : null, (31199 & 2) != 0 ? mainUiState2.scene : null, (31199 & 4) != 0 ? mainUiState2.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState2.strength : 0, (31199 & 16) != 0 ? mainUiState2.extraHint : null, (31199 & 32) != 0 ? mainUiState2.personaId : null, (31199 & 64) != 0 ? mainUiState2.genState : null, (31199 & 128) != 0 ? mainUiState2.showResult : false, (31199 & 256) != 0 ? mainUiState2.message : "一次最多横向对比 5 种风格，先去掉一个吧", (31199 & 512) != 0 ? mainUiState2.quota : null, (31199 & 1024) != 0 ? mainUiState2.aiReady : false, (31199 & 2048) != 0 ? mainUiState2.sharing : false, (31199 & 4096) != 0 ? mainUiState2.aiError : null, (31199 & 8192) != 0 ? mainUiState2.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState2.favoriteKeys : null)));
            return;
        }
        MutableStateFlow<MainUiState> mutableStateFlow3 = this._ui;
        do {
            value3 = mutableStateFlow3.getValue();
            mainUiState3 = value3;
        } while (!mutableStateFlow3.compareAndSet(value3, mainUiState3.copy((31199 & 1) != 0 ? mainUiState3.incoming : null, (31199 & 2) != 0 ? mainUiState3.scene : null, (31199 & 4) != 0 ? mainUiState3.selectedStyleIds : CollectionsKt.minus(selectedStyleIds, id), (31199 & 8) != 0 ? mainUiState3.strength : 0, (31199 & 16) != 0 ? mainUiState3.extraHint : null, (31199 & 32) != 0 ? mainUiState3.personaId : null, (31199 & 64) != 0 ? mainUiState3.genState : null, (31199 & 128) != 0 ? mainUiState3.showResult : false, (31199 & 256) != 0 ? mainUiState3.message : null, (31199 & 512) != 0 ? mainUiState3.quota : null, (31199 & 1024) != 0 ? mainUiState3.aiReady : false, (31199 & 2048) != 0 ? mainUiState3.sharing : false, (31199 & 4096) != 0 ? mainUiState3.aiError : null, (31199 & 8192) != 0 ? mainUiState3.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState3.favoriteKeys : null)));
    }

    public final void generate() {
        startGeneration(false);
    }

    public final void regenerate() {
        startGeneration(true);
    }

    private final void startGeneration(boolean bypassCache) {
        MainUiState value;
        MainUiState mainUiState;
        MainUiState value2;
        MainUiState mainUiState2;
        MainUiState value3;
        MainUiState mainUiState3;
        MainUiState state = this._ui.getValue();
        String input = StringsKt.trim((CharSequence) state.getIncoming()).toString();
        String strValidateInput = SafetyFilter.INSTANCE.validateInput(input);
        if (strValidateInput != null) {
            MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
            do {
                value3 = mutableStateFlow.getValue();
                mainUiState3 = value3;
            } while (!mutableStateFlow.compareAndSet(value3, mainUiState3.copy((31199 & 1) != 0 ? mainUiState3.incoming : null, (31199 & 2) != 0 ? mainUiState3.scene : null, (31199 & 4) != 0 ? mainUiState3.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState3.strength : 0, (31199 & 16) != 0 ? mainUiState3.extraHint : null, (31199 & 32) != 0 ? mainUiState3.personaId : null, (31199 & 64) != 0 ? mainUiState3.genState : null, (31199 & 128) != 0 ? mainUiState3.showResult : false, (31199 & 256) != 0 ? mainUiState3.message : strValidateInput, (31199 & 512) != 0 ? mainUiState3.quota : null, (31199 & 1024) != 0 ? mainUiState3.aiReady : false, (31199 & 2048) != 0 ? mainUiState3.sharing : false, (31199 & 4096) != 0 ? mainUiState3.aiError : null, (31199 & 8192) != 0 ? mainUiState3.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState3.favoriteKeys : null)));
            return;
        }
        List<StylePreset> listSelectedInScene = StyleCatalog.INSTANCE.selectedInScene(state.getSelectedStyleIds(), state.getScene());
        if (listSelectedInScene.isEmpty()) {
            MutableStateFlow<MainUiState> mutableStateFlow2 = this._ui;
            do {
                value2 = mutableStateFlow2.getValue();
                mainUiState2 = value2;
            } while (!mutableStateFlow2.compareAndSet(value2, mainUiState2.copy((31199 & 1) != 0 ? mainUiState2.incoming : null, (31199 & 2) != 0 ? mainUiState2.scene : null, (31199 & 4) != 0 ? mainUiState2.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState2.strength : 0, (31199 & 16) != 0 ? mainUiState2.extraHint : null, (31199 & 32) != 0 ? mainUiState2.personaId : null, (31199 & 64) != 0 ? mainUiState2.genState : null, (31199 & 128) != 0 ? mainUiState2.showResult : false, (31199 & 256) != 0 ? mainUiState2.message : "至少选一种风格", (31199 & 512) != 0 ? mainUiState2.quota : null, (31199 & 1024) != 0 ? mainUiState2.aiReady : false, (31199 & 2048) != 0 ? mainUiState2.sharing : false, (31199 & 4096) != 0 ? mainUiState2.aiError : null, (31199 & 8192) != 0 ? mainUiState2.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState2.favoriteKeys : null)));
            return;
        }
        String strCheckQuota = this.settings.checkQuota();
        if (strCheckQuota != null) {
            MutableStateFlow<MainUiState> mutableStateFlow3 = this._ui;
            do {
                value = mutableStateFlow3.getValue();
                mainUiState = value;
            } while (!mutableStateFlow3.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : strCheckQuota, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
            return;
        }
        int seed = this.repository.newSeed();
        ReplyRequest replyRequest = new ReplyRequest(input, listSelectedInScene, state.getStrength(), this.personas.find(state.getPersonaId()), state.getExtraHint());
        boolean aiReadyAtStart = state.getAiReady();
        Job job = this.generationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.generationJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass4(listSelectedInScene, aiReadyAtStart, replyRequest, seed, bypassCache, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$startGeneration$4, reason: invalid class name */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$startGeneration$4", f = "MainViewModel.kt", i = {0, 0}, l = {298}, m = "invokeSuspend", n = {"collected", "errors"}, s = {"L$0", "L$1"})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $aiReadyAtStart;
        final /* synthetic */ boolean $bypassCache;
        final /* synthetic */ ReplyRequest $request;
        final /* synthetic */ int $seed;
        final /* synthetic */ List<StylePreset> $styles;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(List<StylePreset> list, boolean z, ReplyRequest replyRequest, int i, boolean z2, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$styles = list;
            this.$aiReadyAtStart = z;
            this.$request = replyRequest;
            this.$seed = i;
            this.$bypassCache = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = MainViewModel.this.new AnonymousClass4(this.$styles, this.$aiReadyAtStart, this.$request, this.$seed, this.$bypassCache, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x018f  */
        /* JADX WARN: Code duplicated, block: B:72:0x023d  */
        /* JADX WARN: Code duplicated, block: B:89:0x0193 A[SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r6v2 */
        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v17 java.lang.Object, still in use, count: 2, list:
              (r15v17 java.lang.Object) from 0x018a: PHI (r15 I:??) = (r15v14 java.lang.Object), (r15v17 java.lang.Object) binds: [B:32:0x0189, B:91:0x018a] A[DONT_GENERATE, DONT_INLINE]
              (r15v17 java.lang.Object A[D('element\12' java.lang.Object)]) from 0x016f: CHECK_CAST (com.mouthpiece.app.data.ReplyRepository$Outcome) (r15v17 java.lang.Object A[D('element\12' java.lang.Object)])
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
            	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
            	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r34) {
            /*
                Method dump skipped, instruction units count: 700
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mouthpiece.app.vm.MainViewModel.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void copyReply(Reply reply) {
        MainUiState value;
        MainUiState mainUiState;
        Intrinsics.checkNotNullParameter(reply, "reply");
        Object systemService = this.appContext.getSystemService("clipboard");
        ClipboardManager clipboard = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboard != null) {
            clipboard.setPrimaryClip(ClipData.newPlainText("嘴替", reply.getText()));
        }
        remember(reply);
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : "已复制，直接粘贴就能用", (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void favoriteReply(Reply reply) {
        MainUiState value;
        MainUiState mainUiState;
        MainUiState value2;
        MainUiState mainUiState2;
        Intrinsics.checkNotNullParameter(reply, "reply");
        if (this.settings.getSettings().getValue().getIncognito()) {
            MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
            do {
                value2 = mutableStateFlow.getValue();
                mainUiState2 = value2;
            } while (!mutableStateFlow.compareAndSet(value2, mainUiState2.copy((31199 & 1) != 0 ? mainUiState2.incoming : null, (31199 & 2) != 0 ? mainUiState2.scene : null, (31199 & 4) != 0 ? mainUiState2.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState2.strength : 0, (31199 & 16) != 0 ? mainUiState2.extraHint : null, (31199 & 32) != 0 ? mainUiState2.personaId : null, (31199 & 64) != 0 ? mainUiState2.genState : null, (31199 & 128) != 0 ? mainUiState2.showResult : false, (31199 & 256) != 0 ? mainUiState2.message : "无痕模式已开启，收藏不会写入历史", (31199 & 512) != 0 ? mainUiState2.quota : null, (31199 & 1024) != 0 ? mainUiState2.aiReady : false, (31199 & 2048) != 0 ? mainUiState2.sharing : false, (31199 & 4096) != 0 ? mainUiState2.aiError : null, (31199 & 8192) != 0 ? mainUiState2.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState2.favoriteKeys : null)));
            return;
        }
        boolean nowFavorite = this.history.toggleFavorite(StringsKt.trim((CharSequence) this._ui.getValue().getIncoming()).toString(), reply.getText(), reply.getStyleName());
        MutableStateFlow<MainUiState> mutableStateFlow2 = this._ui;
        do {
            value = mutableStateFlow2.getValue();
            mainUiState = value;
        } while (!mutableStateFlow2.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : nowFavorite ? "已收藏到历史" : "已取消收藏", (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void shareReply(Reply reply) {
        MainUiState value;
        MainUiState mainUiState;
        Intrinsics.checkNotNullParameter(reply, "reply");
        if (this._ui.getValue().getSharing()) {
            return;
        }
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : true, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
        remember(reply);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07222(reply, null), 3, null);
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.vm.MainViewModel$shareReply$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.vm.MainViewModel$shareReply$2", f = "MainViewModel.kt", i = {}, l = {369}, m = "invokeSuspend", n = {}, s = {})
    static final class C07222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Reply $reply;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07222(Reply reply, Continuation<? super C07222> continuation) {
            super(2, continuation);
            this.$reply = reply;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainViewModel.this.new C07222(this.$reply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.mouthpiece.app.data.ShareCardRenderer] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r3v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object value;
            MainUiState mainUiState;
            Object value2;
            MainUiState mainUiState2;
            Object value3;
            MainUiState mainUiState3;
            Object $result2;
            Object $result3;
            Object value4;
            MainUiState mainUiState4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r2 = this.label;
            try {
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        Object objRender = MainViewModel.this.cards.render(StringsKt.trim((CharSequence) ((MainUiState) MainViewModel.this._ui.getValue()).getIncoming()).toString(), this.$reply, MainViewModel.this.settings.getSettings().getValue().getWatermark(), this);
                        if (objRender == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result3 = objRender;
                        break;
                    case 1:
                        $result3 = $result;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    r2 = (File) $result3;
                    Intent chooser = Intent.createChooser(MainViewModel.this.cards.shareIntent(r2), "分享回复卡片");
                    chooser.addFlags(268435456);
                    MainViewModel.this.appContext.startActivity(chooser);
                    MutableStateFlow mutableStateFlow = MainViewModel.this._ui;
                    do {
                        value4 = mutableStateFlow.getValue();
                        mainUiState4 = (MainUiState) value4;
                    } while (!mutableStateFlow.compareAndSet(value4, mainUiState4.copy((31199 & 1) != 0 ? mainUiState4.incoming : null, (31199 & 2) != 0 ? mainUiState4.scene : null, (31199 & 4) != 0 ? mainUiState4.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState4.strength : 0, (31199 & 16) != 0 ? mainUiState4.extraHint : null, (31199 & 32) != 0 ? mainUiState4.personaId : null, (31199 & 64) != 0 ? mainUiState4.genState : null, (31199 & 128) != 0 ? mainUiState4.showResult : false, (31199 & 256) != 0 ? mainUiState4.message : null, (31199 & 512) != 0 ? mainUiState4.quota : null, (31199 & 1024) != 0 ? mainUiState4.aiReady : false, (31199 & 2048) != 0 ? mainUiState4.sharing : false, (31199 & 4096) != 0 ? mainUiState4.aiError : null, (31199 & 8192) != 0 ? mainUiState4.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState4.favoriteKeys : null)));
                } catch (Throwable th) {
                    error = th;
                    r2 = $result2;
                    try {
                        if (error instanceof CancellationException) {
                            throw error;
                        }
                        MutableStateFlow mutableStateFlow2 = MainViewModel.this._ui;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            mainUiState2 = (MainUiState) value2;
                        } while (!mutableStateFlow2.compareAndSet(value2, mainUiState2.copy((31199 & 1) != 0 ? mainUiState2.incoming : null, (31199 & 2) != 0 ? mainUiState2.scene : null, (31199 & 4) != 0 ? mainUiState2.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState2.strength : 0, (31199 & 16) != 0 ? mainUiState2.extraHint : null, (31199 & 32) != 0 ? mainUiState2.personaId : null, (31199 & 64) != 0 ? mainUiState2.genState : null, (31199 & 128) != 0 ? mainUiState2.showResult : false, (31199 & 256) != 0 ? mainUiState2.message : "分享图生成失败：" + error.getMessage(), (31199 & 512) != 0 ? mainUiState2.quota : null, (31199 & 1024) != 0 ? mainUiState2.aiReady : false, (31199 & 2048) != 0 ? mainUiState2.sharing : false, (31199 & 4096) != 0 ? mainUiState2.aiError : null, (31199 & 8192) != 0 ? mainUiState2.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState2.favoriteKeys : null)));
                        MutableStateFlow mutableStateFlow3 = MainViewModel.this._ui;
                        do {
                            value3 = mutableStateFlow3.getValue();
                            mainUiState3 = (MainUiState) value3;
                        } while (!mutableStateFlow3.compareAndSet(value3, mainUiState3.copy((31199 & 1) != 0 ? mainUiState3.incoming : null, (31199 & 2) != 0 ? mainUiState3.scene : null, (31199 & 4) != 0 ? mainUiState3.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState3.strength : 0, (31199 & 16) != 0 ? mainUiState3.extraHint : null, (31199 & 32) != 0 ? mainUiState3.personaId : null, (31199 & 64) != 0 ? mainUiState3.genState : null, (31199 & 128) != 0 ? mainUiState3.showResult : false, (31199 & 256) != 0 ? mainUiState3.message : null, (31199 & 512) != 0 ? mainUiState3.quota : null, (31199 & 1024) != 0 ? mainUiState3.aiReady : false, (31199 & 2048) != 0 ? mainUiState3.sharing : false, (31199 & 4096) != 0 ? mainUiState3.aiError : null, (31199 & 8192) != 0 ? mainUiState3.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState3.favoriteKeys : null)));
                    } catch (Throwable error) {
                        MutableStateFlow mutableStateFlow4 = MainViewModel.this._ui;
                        do {
                            value = mutableStateFlow4.getValue();
                            mainUiState = (MainUiState) value;
                        } while (!mutableStateFlow4.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
                        throw error;
                    }
                }
            } catch (Throwable th2) {
                error = th2;
            }
            return Unit.INSTANCE;
        }
    }

    public final void backToEdit() {
        MainUiState value;
        MainUiState mainUiState;
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    public final void consumeMessage() {
        MainUiState value;
        MainUiState mainUiState;
        MutableStateFlow<MainUiState> mutableStateFlow = this._ui;
        do {
            value = mutableStateFlow.getValue();
            mainUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, mainUiState.copy((31199 & 1) != 0 ? mainUiState.incoming : null, (31199 & 2) != 0 ? mainUiState.scene : null, (31199 & 4) != 0 ? mainUiState.selectedStyleIds : null, (31199 & 8) != 0 ? mainUiState.strength : 0, (31199 & 16) != 0 ? mainUiState.extraHint : null, (31199 & 32) != 0 ? mainUiState.personaId : null, (31199 & 64) != 0 ? mainUiState.genState : null, (31199 & 128) != 0 ? mainUiState.showResult : false, (31199 & 256) != 0 ? mainUiState.message : null, (31199 & 512) != 0 ? mainUiState.quota : null, (31199 & 1024) != 0 ? mainUiState.aiReady : false, (31199 & 2048) != 0 ? mainUiState.sharing : false, (31199 & 4096) != 0 ? mainUiState.aiError : null, (31199 & 8192) != 0 ? mainUiState.inputTruncated : false, (31199 & 16384) != 0 ? mainUiState.favoriteKeys : null)));
    }

    private final void remember(Reply reply) {
        if (this.settings.getSettings().getValue().getIncognito()) {
            return;
        }
        String input = StringsKt.trim((CharSequence) this._ui.getValue().getIncoming()).toString();
        if (this.history.exists(input, reply.getText())) {
            return;
        }
        this.history.add(input, reply.getText(), reply.getStyleName());
    }

    /* JADX INFO: compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mouthpiece/app/vm/MainViewModel$Companion;", "", "<init>", "()V", "MAX_STYLES", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
