package com.mouthpiece.app.data;

import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.LocalTemplateEngine;
import com.mouthpiece.app.domain.Persona;
import com.mouthpiece.app.domain.PromptBuilder;
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.domain.ReplyRequest;
import com.mouthpiece.app.domain.ReplySource;
import com.mouthpiece.app.domain.SafetyFilter;
import com.mouthpiece.app.domain.StylePreset;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ReplyRepository.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001*B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J0\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J0\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J \u0010%\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010'\u001a\u00020\u0016J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\rH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/mouthpiece/app/data/ReplyRepository;", "", "settingsProvider", "Lkotlin/Function0;", "Lcom/mouthpiece/app/domain/AppSettings;", "ai", "Lcom/mouthpiece/app/data/AiGateway;", "local", "Lcom/mouthpiece/app/domain/LocalTemplateEngine;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/mouthpiece/app/data/AiGateway;Lcom/mouthpiece/app/domain/LocalTemplateEngine;)V", "cache", "", "", "Lcom/mouthpiece/app/domain/Reply;", "_lastAiError", "Lkotlinx/coroutines/flow/MutableStateFlow;", "lastAiError", "Lkotlinx/coroutines/flow/StateFlow;", "getLastAiError", "()Lkotlinx/coroutines/flow/StateFlow;", "clearAiError", "", "newSeed", "", "seedCounter", "generateOne", "request", "Lcom/mouthpiece/app/domain/ReplyRequest;", "style", "Lcom/mouthpiece/app/domain/StylePreset;", "seed", "bypassCache", "", "(Lcom/mouthpiece/app/domain/ReplyRequest;Lcom/mouthpiece/app/domain/StylePreset;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateOutcome", "Lcom/mouthpiece/app/data/ReplyRepository$Outcome;", "cacheKey", "config", "clearCache", "clean", "text", "Outcome", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyRepository {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _lastAiError;
    private final AiGateway ai;
    private final Map<String, Reply> cache;
    private final StateFlow<String> lastAiError;
    private final LocalTemplateEngine local;
    private int seedCounter;
    private final Function0<AppSettings> settingsProvider;

    /* JADX INFO: renamed from: com.mouthpiece.app.data.ReplyRepository$generateOne$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReplyRepository.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.ReplyRepository", f = "ReplyRepository.kt", i = {}, l = {101}, m = "generateOne", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReplyRepository.this.generateOne(null, null, 0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.data.ReplyRepository$generateOutcome$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReplyRepository.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.ReplyRepository", f = "ReplyRepository.kt", i = {0, 0, 0, 0, 0}, l = {129}, m = "generateOutcome", n = {"style", "single", "key", "$this$generateOutcome_u24lambda_u241\\2", "seed"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
    static final class C07191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C07191(Continuation<? super C07191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReplyRepository.this.generateOutcome(null, null, 0, false, this);
        }
    }

    public ReplyRepository(Function0<AppSettings> settingsProvider, AiGateway ai, LocalTemplateEngine local) {
        Intrinsics.checkNotNullParameter(settingsProvider, "settingsProvider");
        Intrinsics.checkNotNullParameter(ai, "ai");
        Intrinsics.checkNotNullParameter(local, "local");
        this.settingsProvider = settingsProvider;
        this.ai = ai;
        this.local = local;
        Map<String, Reply> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap<String, Reply>() { // from class: com.mouthpiece.app.data.ReplyRepository$cache$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object key) {
                if (key instanceof String) {
                    return containsKey((String) key);
                }
                return false;
            }

            public /* bridge */ boolean containsKey(String p0) {
                return super.containsKey((Object) p0);
            }

            public /* bridge */ boolean containsValue(Reply p0) {
                return super.containsValue((Object) p0);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object value) {
                if (value instanceof Reply) {
                    return containsValue((Reply) value);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, Reply>> entrySet() {
                return getEntries();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Reply get(Object key) {
                if (key instanceof String) {
                    return get((String) key);
                }
                return null;
            }

            public /* bridge */ Reply get(String p0) {
                return (Reply) super.get((Object) p0);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object key) {
                if (key instanceof String) {
                    return get((String) key);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, Reply>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            public final /* bridge */ Reply getOrDefault(Object key, Reply defaultValue) {
                return !(key instanceof String) ? defaultValue : getOrDefault((String) key, defaultValue);
            }

            public /* bridge */ Reply getOrDefault(String p0, Reply p1) {
                return (Reply) super.getOrDefault((Object) p0, p1);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object key, Object defaultValue) {
                return !(key instanceof String) ? defaultValue : getOrDefault((String) key, (Reply) defaultValue);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<Reply> getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Reply remove(Object key) {
                if (key instanceof String) {
                    return remove((String) key);
                }
                return null;
            }

            public /* bridge */ Reply remove(String p0) {
                return (Reply) super.remove((Object) p0);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object key) {
                if (key instanceof String) {
                    return remove((String) key);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object key, Object value) {
                if ((key instanceof String) && (value instanceof Reply)) {
                    return remove((String) key, (Reply) value);
                }
                return false;
            }

            public /* bridge */ boolean remove(String p0, Reply p1) {
                return super.remove((Object) p0, (Object) p1);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Reply> values() {
                return getValues();
            }

            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<String, Reply> eldest) {
                return size() > 200;
            }
        });
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        this.cache = mapSynchronizedMap;
        this._lastAiError = StateFlowKt.MutableStateFlow(null);
        this.lastAiError = FlowKt.asStateFlow(this._lastAiError);
    }

    public /* synthetic */ ReplyRepository(Function0 function0, AiGateway aiGateway, LocalTemplateEngine localTemplateEngine, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, aiGateway, (i & 4) != 0 ? new LocalTemplateEngine() : localTemplateEngine);
    }

    /* JADX INFO: compiled from: ReplyRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/mouthpiece/app/data/ReplyRepository$Outcome;", "", "reply", "Lcom/mouthpiece/app/domain/Reply;", "error", "", "fromCache", "", "<init>", "(Lcom/mouthpiece/app/domain/Reply;Ljava/lang/String;Z)V", "getReply", "()Lcom/mouthpiece/app/domain/Reply;", "getError", "()Ljava/lang/String;", "getFromCache", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Outcome {
        public static final int $stable = 0;
        private final String error;
        private final boolean fromCache;
        private final Reply reply;

        public static /* synthetic */ Outcome copy$default(Outcome outcome, Reply reply, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                reply = outcome.reply;
            }
            if ((i & 2) != 0) {
                str = outcome.error;
            }
            if ((i & 4) != 0) {
                z = outcome.fromCache;
            }
            return outcome.copy(reply, str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Reply getReply() {
            return this.reply;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getFromCache() {
            return this.fromCache;
        }

        public final Outcome copy(Reply reply, String error, boolean fromCache) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            return new Outcome(reply, error, fromCache);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Outcome)) {
                return false;
            }
            Outcome outcome = (Outcome) other;
            return Intrinsics.areEqual(this.reply, outcome.reply) && Intrinsics.areEqual(this.error, outcome.error) && this.fromCache == outcome.fromCache;
        }

        public int hashCode() {
            return (((this.reply.hashCode() * 31) + (this.error == null ? 0 : this.error.hashCode())) * 31) + Boolean.hashCode(this.fromCache);
        }

        public String toString() {
            return "Outcome(reply=" + this.reply + ", error=" + this.error + ", fromCache=" + this.fromCache + ")";
        }

        public Outcome(Reply reply, String error, boolean fromCache) {
            Intrinsics.checkNotNullParameter(reply, "reply");
            this.reply = reply;
            this.error = error;
            this.fromCache = fromCache;
        }

        public /* synthetic */ Outcome(Reply reply, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(reply, str, (i & 4) != 0 ? false : z);
        }

        public final Reply getReply() {
            return this.reply;
        }

        public final String getError() {
            return this.error;
        }

        public final boolean getFromCache() {
            return this.fromCache;
        }
    }

    public final StateFlow<String> getLastAiError() {
        return this.lastAiError;
    }

    public final void clearAiError() {
        this._lastAiError.setValue(null);
    }

    public final int newSeed() {
        int i = this.seedCounter;
        this.seedCounter = i + 1;
        return i;
    }

    public static /* synthetic */ Object generateOne$default(ReplyRepository replyRepository, ReplyRequest replyRequest, StylePreset stylePreset, int i, boolean z, Continuation continuation, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return replyRepository.generateOne(replyRequest, stylePreset, i, z2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object generateOne(ReplyRequest request, StylePreset style, int seed, boolean bypassCache, Continuation<? super Reply> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objGenerateOutcome;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean z = bypassCache;
                anonymousClass2.label = 1;
                objGenerateOutcome = generateOutcome(request, style, seed, z, anonymousClass2);
                if (objGenerateOutcome == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objGenerateOutcome = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((Outcome) objGenerateOutcome).getReply();
    }

    public static /* synthetic */ Object generateOutcome$default(ReplyRepository replyRepository, ReplyRequest replyRequest, StylePreset stylePreset, int i, boolean z, Continuation continuation, int i2, Object obj) {
        boolean z2;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        return replyRepository.generateOutcome(replyRequest, stylePreset, i, z2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ee A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, blocks: (B:13:0x0048, B:31:0x00e0, B:33:0x00ee, B:34:0x0108, B:35:0x0115), top: B:53:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0108 A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, blocks: (B:13:0x0048, B:31:0x00e0, B:33:0x00ee, B:34:0x0108, B:35:0x0115), top: B:53:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0128  */
    /* JADX WARN: Code duplicated, block: B:43:0x013b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0140  */
    /* JADX WARN: Code duplicated, block: B:47:0x0146  */
    /* JADX WARN: Code duplicated, block: B:50:0x016b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object generateOutcome(ReplyRequest request, StylePreset stylePreset, int seed, boolean bypassCache, Continuation<? super Outcome> continuation) throws Throwable {
        C07191 c07191;
        ReplyRepository replyRepository;
        StylePreset style;
        ReplyRequest single;
        String key;
        int seed2;
        Object objComplete;
        ReplyRepository replyRepository2;
        Reply reply;
        Object objM7545constructorimpl;
        Throwable thM7548exceptionOrNullimpl;
        String message;
        String strClean;
        if (continuation instanceof C07191) {
            c07191 = (C07191) continuation;
            if ((c07191.label & Integer.MIN_VALUE) != 0) {
                c07191.label -= Integer.MIN_VALUE;
            } else {
                c07191 = new C07191(continuation);
            }
        } else {
            c07191 = new C07191(continuation);
        }
        C07191 c07192 = c07191;
        Object $result = c07192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07192.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                replyRepository = this;
                style = stylePreset;
                single = ReplyRequest.copy$default(request, null, CollectionsKt.listOf(style), 0, null, null, 29, null);
                AppSettings config = replyRepository.settingsProvider.invoke();
                if (!config.getAiReady()) {
                    return new Outcome((Reply) CollectionsKt.first((List) replyRepository.local.generate(single, seed)), null, false, 4, null);
                }
                key = replyRepository.cacheKey(request, style, config);
                if (!bypassCache && (reply = replyRepository.cache.get(key)) != null) {
                    return new Outcome(reply, null, true);
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ReplyRepository replyRepository3 = replyRepository;
                    AiGateway aiGateway = replyRepository3.ai;
                    String strSystem = PromptBuilder.INSTANCE.system(single);
                    String strUser = PromptBuilder.INSTANCE.user(single);
                    float temperature = style.getTemperature();
                    c07192.L$0 = style;
                    c07192.L$1 = single;
                    c07192.L$2 = key;
                    c07192.L$3 = replyRepository3;
                    c07192.I$0 = seed;
                    c07192.label = 1;
                    objComplete = aiGateway.complete(strSystem, strUser, temperature, c07192);
                    if (objComplete == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    replyRepository2 = replyRepository3;
                    seed2 = seed;
                    strClean = replyRepository2.clean((String) objComplete);
                    if (SafetyFilter.INSTANCE.isOutputSafe(strClean)) {
                        throw new IllegalStateException("内容未通过安全校验".toString());
                    }
                    objM7545constructorimpl = Result.m7545constructorimpl(new Reply(style.getId(), style.getName(), style.getEmoji(), strClean, ReplySource.AI));
                    thM7548exceptionOrNullimpl = Result.m7548exceptionOrNullimpl(objM7545constructorimpl);
                    if (thM7548exceptionOrNullimpl == null) {
                        Reply reply2 = (Reply) objM7545constructorimpl;
                        replyRepository.cache.put(key, reply2);
                        return new Outcome(reply2, null, false, 4, null);
                    }
                    if (!(thM7548exceptionOrNullimpl instanceof CancellationException)) {
                        throw thM7548exceptionOrNullimpl;
                    }
                    message = thM7548exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = thM7548exceptionOrNullimpl.getClass().getSimpleName();
                    }
                    String str = message;
                    replyRepository._lastAiError.setValue(str);
                    return new Outcome((Reply) CollectionsKt.first((List) replyRepository.local.generate(single, seed2)), str, false, 4, null);
                } catch (Throwable th) {
                    th = th;
                    seed2 = seed;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
                }
                break;
            case 1:
                replyRepository = this;
                seed2 = c07192.I$0;
                replyRepository2 = (ReplyRepository) c07192.L$3;
                key = (String) c07192.L$2;
                single = (ReplyRequest) c07192.L$1;
                style = (StylePreset) c07192.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objComplete = $result;
                    strClean = replyRepository2.clean((String) objComplete);
                    if (SafetyFilter.INSTANCE.isOutputSafe(strClean)) {
                        throw new IllegalStateException("内容未通过安全校验".toString());
                    }
                    objM7545constructorimpl = Result.m7545constructorimpl(new Reply(style.getId(), style.getName(), style.getEmoji(), strClean, ReplySource.AI));
                    thM7548exceptionOrNullimpl = Result.m7548exceptionOrNullimpl(objM7545constructorimpl);
                    if (thM7548exceptionOrNullimpl == null) {
                        Reply reply3 = (Reply) objM7545constructorimpl;
                        replyRepository.cache.put(key, reply3);
                        return new Outcome(reply3, null, false, 4, null);
                    }
                    if (!(thM7548exceptionOrNullimpl instanceof CancellationException)) {
                        throw thM7548exceptionOrNullimpl;
                    }
                    message = thM7548exceptionOrNullimpl.getMessage();
                    if (message == null) {
                        message = thM7548exceptionOrNullimpl.getClass().getSimpleName();
                    }
                    String str2 = message;
                    replyRepository._lastAiError.setValue(str2);
                    return new Outcome((Reply) CollectionsKt.first((List) replyRepository.local.generate(single, seed2)), str2, false, 4, null);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String cacheKey(ReplyRequest request, StylePreset style, AppSettings config) {
        StringBuilder sb = new StringBuilder();
        cacheKey$lambda$4$field(sb, StringsKt.trim((CharSequence) config.getBaseUrl()).toString());
        cacheKey$lambda$4$field(sb, StringsKt.trim((CharSequence) config.getModel()).toString());
        cacheKey$lambda$4$field(sb, style.getId());
        cacheKey$lambda$4$field(sb, String.valueOf(request.getStrength()));
        Persona persona = request.getPersona();
        String id = persona != null ? persona.getId() : null;
        if (id == null) {
            id = "";
        }
        cacheKey$lambda$4$field(sb, id);
        cacheKey$lambda$4$field(sb, StringsKt.trim((CharSequence) request.getExtraHint()).toString());
        cacheKey$lambda$4$field(sb, StringsKt.trim((CharSequence) request.getIncoming()).toString());
        return sb.toString();
    }

    private static final void cacheKey$lambda$4$field(StringBuilder $this_buildString, String value) {
        $this_buildString.append(value.length()).append(':').append(value).append('|');
    }

    public final void clearCache() {
        this.cache.clear();
    }

    private final String clean(String text) {
        return StringsKt.trim((CharSequence) StringsKt.trim(StringsKt.trim((CharSequence) StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim((CharSequence) text).toString(), (CharSequence) "回复："), (CharSequence) "回复:")).toString(), Typography.quote, Typography.leftDoubleQuote, Typography.rightDoubleQuote)).toString();
    }
}
