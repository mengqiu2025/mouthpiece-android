package com.mouthpiece.app.domain;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/mouthpiece/app/domain/QuotaState;", "", "used", "", "limit", "isPro", "", "<init>", "(IIZ)V", "getUsed", "()I", "getLimit", "()Z", "remaining", "getRemaining", "exhausted", "getExhausted", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class QuotaState {
    public static final int $stable = 0;
    private final boolean isPro;
    private final int limit;
    private final int used;

    public static /* synthetic */ QuotaState copy$default(QuotaState quotaState, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = quotaState.used;
        }
        if ((i3 & 2) != 0) {
            i2 = quotaState.limit;
        }
        if ((i3 & 4) != 0) {
            z = quotaState.isPro;
        }
        return quotaState.copy(i, i2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUsed() {
        return this.used;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsPro() {
        return this.isPro;
    }

    public final QuotaState copy(int used, int limit, boolean isPro) {
        return new QuotaState(used, limit, isPro);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuotaState)) {
            return false;
        }
        QuotaState quotaState = (QuotaState) other;
        return this.used == quotaState.used && this.limit == quotaState.limit && this.isPro == quotaState.isPro;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.used) * 31) + Integer.hashCode(this.limit)) * 31) + Boolean.hashCode(this.isPro);
    }

    public String toString() {
        return "QuotaState(used=" + this.used + ", limit=" + this.limit + ", isPro=" + this.isPro + ")";
    }

    public QuotaState(int used, int limit, boolean isPro) {
        this.used = used;
        this.limit = limit;
        this.isPro = isPro;
    }

    public final int getUsed() {
        return this.used;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final boolean isPro() {
        return this.isPro;
    }

    public final int getRemaining() {
        if (this.isPro) {
            return Integer.MAX_VALUE;
        }
        return RangesKt.coerceAtLeast(this.limit - this.used, 0);
    }

    public final boolean getExhausted() {
        return !this.isPro && this.used >= this.limit;
    }
}
