package com.mouthpiece.app.data;

import com.mouthpiece.app.domain.HistoryItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HistoryCodec.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/mouthpiece/app/data/HistoryCodec;", "", "<init>", "()V", "encode", "", "items", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "decode", "raw", "decodeOrNull", "readOne", "array", "Lorg/json/JSONArray;", "index", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryCodec {
    public static final int $stable = 0;
    public static final HistoryCodec INSTANCE = new HistoryCodec();

    private HistoryCodec() {
    }

    public final String encode(List<HistoryItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        JSONArray array = new JSONArray();
        for (HistoryItem historyItem : items) {
            array.put(new JSONObject().put("id", historyItem.getId()).put("incoming", historyItem.getIncoming()).put("reply", historyItem.getReply()).put("styleName", historyItem.getStyleName()).put("createdAt", historyItem.getCreatedAt()).put("favorite", historyItem.getFavorite()));
        }
        String string = array.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final List<HistoryItem> decode(String raw) {
        List<HistoryItem> listDecodeOrNull = decodeOrNull(raw);
        return listDecodeOrNull == null ? CollectionsKt.emptyList() : listDecodeOrNull;
    }

    public final List<HistoryItem> decodeOrNull(String raw) {
        Object objM7545constructorimpl;
        Object objM7545constructorimpl2;
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            HistoryCodec historyCodec = this;
            JSONArray jSONArray = new JSONArray(raw);
            Iterable iterableUntil = RangesKt.until(0, jSONArray.length());
            Collection arrayList = new ArrayList();
            Iterator<Integer> it = iterableUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    try {
                        objM7545constructorimpl2 = Result.m7545constructorimpl(historyCodec.readOne(jSONArray, iNextInt));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion3 = Result.INSTANCE;
                        objM7545constructorimpl2 = Result.m7545constructorimpl(ResultKt.createFailure(th));
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (Result.m7551isFailureimpl(objM7545constructorimpl2)) {
                    objM7545constructorimpl2 = null;
                }
                HistoryItem historyItem = (HistoryItem) objM7545constructorimpl2;
                if (historyItem != null) {
                    arrayList.add(historyItem);
                }
            }
            objM7545constructorimpl = Result.m7545constructorimpl(CollectionsKt.sortedWith((List) arrayList, new Comparator() { // from class: com.mouthpiece.app.data.HistoryCodec$decodeOrNull$lambda$4$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((HistoryItem) t2).getCreatedAt()), Long.valueOf(((HistoryItem) t).getCreatedAt()));
                }
            }));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th3));
        }
        return (List) (Result.m7551isFailureimpl(objM7545constructorimpl) ? null : objM7545constructorimpl);
    }

    private final HistoryItem readOne(JSONArray array, int index) throws JSONException {
        JSONObject json = array.getJSONObject(index);
        long jOptLong = json.optLong("id");
        String strOptString = json.optString("incoming");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strOptString2 = json.optString("reply");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = json.optString("styleName");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        return new HistoryItem(jOptLong, strOptString, strOptString2, strOptString3, json.optLong("createdAt"), json.optBoolean("favorite"));
    }
}
