package com.mouthpiece.app.data;

import android.content.Context;
import com.mouthpiece.app.domain.HistoryItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: Stores.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u001eJ\u001e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"J\u0016\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"J\u001e\u0010*\u001a\u00020)2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0019J\u0006\u0010-\u001a\u00020\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/mouthpiece/app/data/HistoryStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Ljava/io/File;", "backup", "io", "Lkotlinx/coroutines/CoroutineScope;", "pendingWrite", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "writeLock", "Ljava/util/concurrent/locks/ReentrantLock;", "_items", "items", "Lkotlinx/coroutines/flow/StateFlow;", "getItems", "()Lkotlinx/coroutines/flow/StateFlow;", "idCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "nextId", "", "read", "recoverFromBackup", "readBackup", "write", "", "list", "writeAtomically", "content", "", "flush", "add", "incoming", "reply", "styleName", "exists", "", "toggleFavorite", "id", "delete", "clear", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryStore {

    @Deprecated
    public static final long FLUSH_LOCK_TIMEOUT_MS = 50;

    @Deprecated
    public static final int MAX_ITEMS = 500;

    @Deprecated
    public static final long WRITE_DEBOUNCE_MS = 500;
    private final MutableStateFlow<List<HistoryItem>> _items;
    private final File backup;
    private final File file;
    private final AtomicLong idCounter;
    private final CoroutineScope io;
    private final StateFlow<List<HistoryItem>> items;
    private final MutableStateFlow<List<HistoryItem>> pendingWrite;
    private final ReentrantLock writeLock;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public HistoryStore(Context context) {
        Long lValueOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.file = new File(context.getFilesDir(), "history.json");
        this.backup = new File(context.getFilesDir(), "history.json.bak");
        this.io = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        this.pendingWrite = StateFlowKt.MutableStateFlow(null);
        this.writeLock = new ReentrantLock();
        this._items = StateFlowKt.MutableStateFlow(read());
        this.items = FlowKt.asStateFlow(this._items);
        Iterator<T> it = this._items.getValue().iterator();
        if (it.hasNext()) {
            lValueOf = Long.valueOf(((HistoryItem) it.next()).getId());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((HistoryItem) it.next()).getId());
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
        } else {
            lValueOf = null;
        }
        Long l = lValueOf;
        this.idCounter = new AtomicLong(l != null ? l.longValue() : 0L);
        BuildersKt__Builders_commonKt.launch$default(this.io, null, null, new AnonymousClass1(null), 3, null);
    }

    public final StateFlow<List<HistoryItem>> getItems() {
        return this.items;
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.data.HistoryStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: Stores.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.HistoryStore$1", f = "Stores.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HistoryStore.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.mouthpiece.app.data.HistoryStore$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Stores.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "snapshot", "", "Lcom/mouthpiece/app/domain/HistoryItem;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.mouthpiece.app.data.HistoryStore$1$1", f = "Stores.kt", i = {0}, l = {248}, m = "invokeSuspend", n = {"snapshot"}, s = {"L$0"})
        static final class C01591 extends SuspendLambda implements Function2<List<? extends HistoryItem>, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$launch;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HistoryStore this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01591(CoroutineScope coroutineScope, HistoryStore historyStore, Continuation<? super C01591> continuation) {
                super(2, continuation);
                this.$$this$launch = coroutineScope;
                this.this$0 = historyStore;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01591 c01591 = new C01591(this.$$this$launch, this.this$0, continuation);
                c01591.L$0 = obj;
                return c01591;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(List<? extends HistoryItem> list, Continuation<? super Unit> continuation) {
                return invoke2((List<HistoryItem>) list, continuation);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<HistoryItem> list, Continuation<? super Unit> continuation) {
                return ((C01591) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                List<HistoryItem> list;
                Object objM7545constructorimpl;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        List<HistoryItem> list2 = (List) this.L$0;
                        this.L$0 = list2;
                        this.label = 1;
                        if (DelayKt.delay(500L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list = list2;
                        break;
                        break;
                    case 1:
                        list = (List) this.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                HistoryStore historyStore = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    historyStore.writeAtomically(HistoryCodec.INSTANCE.encode(list));
                    objM7545constructorimpl = Result.m7545constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
                }
                boolean persisted = Result.m7552isSuccessimpl(objM7545constructorimpl);
                if (persisted && this.this$0.pendingWrite.getValue() == list) {
                    this.this$0.pendingWrite.setValue(null);
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    this.label = 1;
                    if (FlowKt.collectLatest(FlowKt.filterNotNull(HistoryStore.this.pendingWrite), new C01591($this$launch, HistoryStore.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final long nextId() {
        return this.idCounter.incrementAndGet();
    }

    private final List<HistoryItem> read() {
        Object objM7545constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            HistoryStore historyStore = this;
            Result.m7545constructorimpl(Boolean.valueOf(new File(historyStore.file.getParentFile(), historyStore.file.getName() + ".tmp").delete()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            HistoryStore historyStore2 = this;
            objM7545constructorimpl = Result.m7545constructorimpl(historyStore2.file.exists() ? FilesKt.readText(historyStore2.file, Charsets.UTF_8) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th2));
        }
        String raw = (String) (Result.m7551isFailureimpl(objM7545constructorimpl) ? null : objM7545constructorimpl);
        if (raw == null) {
            return readBackup();
        }
        List<HistoryItem> listDecodeOrNull = HistoryCodec.INSTANCE.decodeOrNull(raw);
        return listDecodeOrNull == null ? recoverFromBackup() : listDecodeOrNull;
    }

    private final List<HistoryItem> recoverFromBackup() {
        List<HistoryItem> backup = readBackup();
        if (!backup.isEmpty()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                writeAtomically(HistoryCodec.INSTANCE.encode(backup));
                Result.m7545constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7545constructorimpl(ResultKt.createFailure(th));
            }
        }
        return backup;
    }

    private final List<HistoryItem> readBackup() {
        Object objM7545constructorimpl;
        List<HistoryItem> listEmptyList;
        try {
            Result.Companion companion = Result.INSTANCE;
            HistoryStore historyStore = this;
            if (!historyStore.backup.exists() || (listEmptyList = HistoryCodec.INSTANCE.decodeOrNull(FilesKt.readText(historyStore.backup, Charsets.UTF_8))) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            objM7545constructorimpl = Result.m7545constructorimpl(listEmptyList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        List listEmptyList2 = CollectionsKt.emptyList();
        if (Result.m7551isFailureimpl(objM7545constructorimpl)) {
            objM7545constructorimpl = listEmptyList2;
        }
        return (List) objM7545constructorimpl;
    }

    private final void write(List<HistoryItem> list) {
        List<HistoryItem> listTake = CollectionsKt.take(list, MAX_ITEMS);
        this._items.setValue(listTake);
        this.pendingWrite.setValue(listTake);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeAtomically(String content) {
        this.writeLock.lock();
        try {
            File dir = this.file.getParentFile();
            if (dir != null) {
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File tmp = new File(dir, this.file.getName() + ".tmp");
                FilesKt.writeText(tmp, content, Charsets.UTF_8);
                if (this.file.exists()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        HistoryStore historyStore = this;
                        Result.m7545constructorimpl(FilesKt.copyTo$default(historyStore.file, historyStore.backup, true, 0, 4, null));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m7545constructorimpl(ResultKt.createFailure(th));
                    }
                }
                if (!tmp.renameTo(this.file)) {
                    FilesKt.writeText(this.file, content, Charsets.UTF_8);
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        HistoryStore historyStore2 = this;
                        Result.m7545constructorimpl(Boolean.valueOf(tmp.delete()));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        Result.m7545constructorimpl(ResultKt.createFailure(th2));
                    }
                }
                this.writeLock.unlock();
                return;
            }
            this.writeLock.unlock();
        } catch (Throwable th3) {
            this.writeLock.unlock();
            throw th3;
        }
    }

    public final void flush() {
        Object objM7545constructorimpl;
        List<HistoryItem> value = this.pendingWrite.getValue();
        if (value == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(Boolean.valueOf(this.writeLock.tryLock(50L, TimeUnit.MILLISECONDS)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7551isFailureimpl(objM7545constructorimpl)) {
            objM7545constructorimpl = false;
        }
        boolean acquired = ((Boolean) objM7545constructorimpl).booleanValue();
        try {
            if (acquired) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    writeAtomically(HistoryCodec.INSTANCE.encode(value));
                    Result.m7545constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m7545constructorimpl(ResultKt.createFailure(th2));
                }
                if (this.pendingWrite.getValue() == value) {
                    this.pendingWrite.setValue(null);
                }
            }
        } finally {
            this.writeLock.unlock();
        }
    }

    public final void add(String incoming, String reply, String styleName) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        HistoryItem item = new HistoryItem(nextId(), incoming, reply, styleName, System.currentTimeMillis(), false, 32, null);
        write(CollectionsKt.take(CollectionsKt.plus((Collection) CollectionsKt.listOf(item), (Iterable) this._items.getValue()), MAX_ITEMS));
    }

    public final boolean exists(String incoming, String reply) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Iterable<HistoryItem> value = this._items.getValue();
        if ((value instanceof Collection) && ((Collection) value).isEmpty()) {
            return false;
        }
        for (HistoryItem historyItem : value) {
            if (Intrinsics.areEqual(historyItem.getIncoming(), incoming) && Intrinsics.areEqual(historyItem.getReply(), reply)) {
                return true;
            }
        }
        return false;
    }

    public final boolean toggleFavorite(String incoming, String reply, String styleName) {
        Object next;
        HistoryItem historyItem;
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Iterable iterable = HistoryMutations.INSTANCE.toggleFavorite(this._items.getValue(), incoming, reply, styleName, new HistoryStore$toggleFavorite$next$1(this), System.currentTimeMillis());
        write(CollectionsKt.take(iterable, MAX_ITEMS));
        Iterator it = iterable.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            historyItem = (HistoryItem) next;
        } while (!(Intrinsics.areEqual(historyItem.getIncoming(), incoming) && Intrinsics.areEqual(historyItem.getReply(), reply)));
        HistoryItem historyItem2 = (HistoryItem) next;
        return historyItem2 != null && historyItem2.getFavorite();
    }

    public final void toggleFavorite(long id) {
        Iterable<HistoryItem> value = this._items.getValue();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (HistoryItem historyItemCopy$default : value) {
            if (historyItemCopy$default.getId() == id) {
                historyItemCopy$default = HistoryItem.copy$default(historyItemCopy$default, 0L, null, null, null, 0L, !historyItemCopy$default.getFavorite(), 31, null);
            }
            arrayList.add(historyItemCopy$default);
        }
        write((List) arrayList);
    }

    public final void delete(long id) {
        Iterable value = this._items.getValue();
        Collection arrayList = new ArrayList();
        for (Object obj : value) {
            if (!(((HistoryItem) obj).getId() == id)) {
                arrayList.add(obj);
            }
        }
        write((List) arrayList);
    }

    public final void clear() {
        write(CollectionsKt.emptyList());
    }

    /* JADX INFO: compiled from: Stores.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mouthpiece/app/data/HistoryStore$Companion;", "", "<init>", "()V", "MAX_ITEMS", "", "WRITE_DEBOUNCE_MS", "", "FLUSH_LOCK_TIMEOUT_MS", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
