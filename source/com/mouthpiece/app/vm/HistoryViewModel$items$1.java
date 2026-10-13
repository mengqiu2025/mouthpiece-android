package com.mouthpiece.app.vm;

import com.mouthpiece.app.domain.HistoryItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AppViewModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "list", "keyword", "", "onlyFav", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.vm.HistoryViewModel$items$1", f = "AppViewModels.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HistoryViewModel$items$1 extends SuspendLambda implements Function4<List<? extends HistoryItem>, String, Boolean, Continuation<? super List<? extends HistoryItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;

    HistoryViewModel$items$1(Continuation<? super HistoryViewModel$items$1> continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(List<? extends HistoryItem> list, String str, Boolean bool, Continuation<? super List<? extends HistoryItem>> continuation) {
        return invoke((List<HistoryItem>) list, str, bool.booleanValue(), (Continuation<? super List<HistoryItem>>) continuation);
    }

    public final Object invoke(List<HistoryItem> list, String str, boolean z, Continuation<? super List<HistoryItem>> continuation) {
        HistoryViewModel$items$1 historyViewModel$items$1 = new HistoryViewModel$items$1(continuation);
        historyViewModel$items$1.L$0 = list;
        historyViewModel$items$1.L$1 = str;
        historyViewModel$items$1.Z$0 = z;
        return historyViewModel$items$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                final String keyword = (String) this.L$1;
                boolean onlyFav = this.Z$0;
                Sequence sequenceAsSequence = CollectionsKt.asSequence(list);
                final boolean z = onlyFav;
                return SequencesKt.toList(SequencesKt.filter(SequencesKt.filter(sequenceAsSequence, new Function1() { // from class: com.mouthpiece.app.vm.HistoryViewModel$items$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(HistoryViewModel$items$1.invokeSuspend$lambda$0(z, (HistoryItem) obj2));
                    }
                }), new Function1() { // from class: com.mouthpiece.app.vm.HistoryViewModel$items$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(HistoryViewModel$items$1.invokeSuspend$lambda$1(keyword, (HistoryItem) obj2));
                    }
                }));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(boolean $onlyFav, HistoryItem it) {
        return !$onlyFav || it.getFavorite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$1(String $keyword, HistoryItem it) {
        return StringsKt.isBlank($keyword) || StringsKt.contains((CharSequence) it.getIncoming(), (CharSequence) $keyword, true) || StringsKt.contains((CharSequence) it.getReply(), (CharSequence) $keyword, true);
    }
}
