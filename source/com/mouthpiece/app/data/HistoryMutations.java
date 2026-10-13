package com.mouthpiece.app.data;

import com.mouthpiece.app.domain.HistoryItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistoryMutations.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/mouthpiece/app/data/HistoryMutations;", "", "<init>", "()V", "toggleFavorite", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "items", "incoming", "", "reply", "styleName", "newId", "Lkotlin/Function0;", "", "now", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryMutations {
    public static final int $stable = 0;
    public static final HistoryMutations INSTANCE = new HistoryMutations();

    private HistoryMutations() {
    }

    public final List<HistoryItem> toggleFavorite(List<HistoryItem> items, String incoming, String reply, String styleName, Function0<Long> newId, long now) {
        Object next;
        HistoryItem historyItem;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(newId, "newId");
        Iterator it = items.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            historyItem = (HistoryItem) next;
        } while (!(Intrinsics.areEqual(historyItem.getIncoming(), incoming) && Intrinsics.areEqual(historyItem.getReply(), reply)));
        HistoryItem existing = (HistoryItem) next;
        if (existing == null) {
            return CollectionsKt.plus((Collection) CollectionsKt.listOf(new HistoryItem(newId.invoke().longValue(), incoming, reply, styleName, now, true)), (Iterable) items);
        }
        List<HistoryItem> list = items;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (HistoryItem historyItemCopy$default : list) {
            if (historyItemCopy$default.getId() == existing.getId()) {
                historyItemCopy$default = HistoryItem.copy$default(historyItemCopy$default, 0L, null, null, null, 0L, !historyItemCopy$default.getFavorite(), 31, null);
            }
            arrayList.add(historyItemCopy$default);
        }
        return (List) arrayList;
    }
}
