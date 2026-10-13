package com.mouthpiece.app.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/mouthpiece/app/domain/GenState;", "", "Idle", "Loading", "Done", "Failed", "Lcom/mouthpiece/app/domain/GenState$Done;", "Lcom/mouthpiece/app/domain/GenState$Failed;", "Lcom/mouthpiece/app/domain/GenState$Idle;", "Lcom/mouthpiece/app/domain/GenState$Loading;", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GenState {

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/mouthpiece/app/domain/GenState$Idle;", "Lcom/mouthpiece/app/domain/GenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Idle implements GenState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Idle)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1520688158;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/mouthpiece/app/domain/GenState$Loading;", "Lcom/mouthpiece/app/domain/GenState;", "done", "", "total", "<init>", "(II)V", "getDone", "()I", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Loading implements GenState {
        public static final int $stable = 0;
        private final int done;
        private final int total;

        public static /* synthetic */ Loading copy$default(Loading loading, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = loading.done;
            }
            if ((i3 & 2) != 0) {
                i2 = loading.total;
            }
            return loading.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDone() {
            return this.done;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final Loading copy(int done, int total) {
            return new Loading(done, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            Loading loading = (Loading) other;
            return this.done == loading.done && this.total == loading.total;
        }

        public int hashCode() {
            return (Integer.hashCode(this.done) * 31) + Integer.hashCode(this.total);
        }

        public String toString() {
            return "Loading(done=" + this.done + ", total=" + this.total + ")";
        }

        public Loading(int done, int total) {
            this.done = done;
            this.total = total;
        }

        public final int getDone() {
            return this.done;
        }

        public final int getTotal() {
            return this.total;
        }
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/mouthpiece/app/domain/GenState$Done;", "Lcom/mouthpiece/app/domain/GenState;", "replies", "", "Lcom/mouthpiece/app/domain/Reply;", "<init>", "(Ljava/util/List;)V", "getReplies", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Done implements GenState {
        public static final int $stable = 8;
        private final List<Reply> replies;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Done copy$default(Done done, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = done.replies;
            }
            return done.copy(list);
        }

        public final List<Reply> component1() {
            return this.replies;
        }

        public final Done copy(List<Reply> replies) {
            Intrinsics.checkNotNullParameter(replies, "replies");
            return new Done(replies);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Done) && Intrinsics.areEqual(this.replies, ((Done) other).replies);
        }

        public int hashCode() {
            return this.replies.hashCode();
        }

        public String toString() {
            return "Done(replies=" + this.replies + ")";
        }

        public Done(List<Reply> replies) {
            Intrinsics.checkNotNullParameter(replies, "replies");
            this.replies = replies;
        }

        public final List<Reply> getReplies() {
            return this.replies;
        }
    }

    /* JADX INFO: compiled from: Models.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/mouthpiece/app/domain/GenState$Failed;", "Lcom/mouthpiece/app/domain/GenState;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Failed implements GenState {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.message;
            }
            return failed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Failed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Failed(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Failed) && Intrinsics.areEqual(this.message, ((Failed) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Failed(message=" + this.message + ")";
        }

        public Failed(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
