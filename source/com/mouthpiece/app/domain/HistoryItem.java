package com.mouthpiece.app.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/mouthpiece/app/domain/HistoryItem;", "", "id", "", "incoming", "", "reply", "styleName", "createdAt", "favorite", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getId", "()J", "getIncoming", "()Ljava/lang/String;", "getReply", "getStyleName", "getCreatedAt", "getFavorite", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HistoryItem {
    public static final int $stable = 0;
    private final long createdAt;
    private final boolean favorite;
    private final long id;
    private final String incoming;
    private final String reply;
    private final String styleName;

    public static /* synthetic */ HistoryItem copy$default(HistoryItem historyItem, long j, String str, String str2, String str3, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = historyItem.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = historyItem.incoming;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = historyItem.reply;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = historyItem.styleName;
        }
        return historyItem.copy(j3, str4, str5, str3, (i & 16) != 0 ? historyItem.createdAt : j2, (i & 32) != 0 ? historyItem.favorite : z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIncoming() {
        return this.incoming;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReply() {
        return this.reply;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getStyleName() {
        return this.styleName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getFavorite() {
        return this.favorite;
    }

    public final HistoryItem copy(long id, String incoming, String reply, String styleName, long createdAt, boolean favorite) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        return new HistoryItem(id, incoming, reply, styleName, createdAt, favorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryItem)) {
            return false;
        }
        HistoryItem historyItem = (HistoryItem) other;
        return this.id == historyItem.id && Intrinsics.areEqual(this.incoming, historyItem.incoming) && Intrinsics.areEqual(this.reply, historyItem.reply) && Intrinsics.areEqual(this.styleName, historyItem.styleName) && this.createdAt == historyItem.createdAt && this.favorite == historyItem.favorite;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.id) * 31) + this.incoming.hashCode()) * 31) + this.reply.hashCode()) * 31) + this.styleName.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Boolean.hashCode(this.favorite);
    }

    public String toString() {
        return "HistoryItem(id=" + this.id + ", incoming=" + this.incoming + ", reply=" + this.reply + ", styleName=" + this.styleName + ", createdAt=" + this.createdAt + ", favorite=" + this.favorite + ")";
    }

    public HistoryItem(long id, String incoming, String reply, String styleName, long createdAt, boolean favorite) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        this.id = id;
        this.incoming = incoming;
        this.reply = reply;
        this.styleName = styleName;
        this.createdAt = createdAt;
        this.favorite = favorite;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HistoryItem(long j, String str, String str2, String str3, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2;
        if ((i & 32) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        this(j, str, str2, str3, j2, z2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getIncoming() {
        return this.incoming;
    }

    public final String getReply() {
        return this.reply;
    }

    public final String getStyleName() {
        return this.styleName;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final boolean getFavorite() {
        return this.favorite;
    }
}
