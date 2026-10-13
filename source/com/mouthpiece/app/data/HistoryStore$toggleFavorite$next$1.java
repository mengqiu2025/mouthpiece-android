package com.mouthpiece.app.data;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: Stores.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class HistoryStore$toggleFavorite$next$1 extends FunctionReferenceImpl implements Function0<Long> {
    HistoryStore$toggleFavorite$next$1(Object obj) {
        super(0, obj, HistoryStore.class, "nextId", "nextId()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(((HistoryStore) this.receiver).nextId());
    }
}
