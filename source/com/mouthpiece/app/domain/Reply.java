package com.mouthpiece.app.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/mouthpiece/app/domain/Reply;", "", "styleId", "", "styleName", "emoji", "text", "source", "Lcom/mouthpiece/app/domain/ReplySource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mouthpiece/app/domain/ReplySource;)V", "getStyleId", "()Ljava/lang/String;", "getStyleName", "getEmoji", "getText", "getSource", "()Lcom/mouthpiece/app/domain/ReplySource;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Reply {
    public static final int $stable = 0;
    private final String emoji;
    private final ReplySource source;
    private final String styleId;
    private final String styleName;
    private final String text;

    public static /* synthetic */ Reply copy$default(Reply reply, String str, String str2, String str3, String str4, ReplySource replySource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reply.styleId;
        }
        if ((i & 2) != 0) {
            str2 = reply.styleName;
        }
        if ((i & 4) != 0) {
            str3 = reply.emoji;
        }
        if ((i & 8) != 0) {
            str4 = reply.text;
        }
        if ((i & 16) != 0) {
            replySource = reply.source;
        }
        ReplySource replySource2 = replySource;
        String str5 = str3;
        return reply.copy(str, str2, str5, str4, replySource2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStyleId() {
        return this.styleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStyleName() {
        return this.styleName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final ReplySource getSource() {
        return this.source;
    }

    public final Reply copy(String styleId, String styleName, String emoji, String text, ReplySource source) {
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        return new Reply(styleId, styleName, emoji, text, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reply)) {
            return false;
        }
        Reply reply = (Reply) other;
        return Intrinsics.areEqual(this.styleId, reply.styleId) && Intrinsics.areEqual(this.styleName, reply.styleName) && Intrinsics.areEqual(this.emoji, reply.emoji) && Intrinsics.areEqual(this.text, reply.text) && this.source == reply.source;
    }

    public int hashCode() {
        return (((((((this.styleId.hashCode() * 31) + this.styleName.hashCode()) * 31) + this.emoji.hashCode()) * 31) + this.text.hashCode()) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "Reply(styleId=" + this.styleId + ", styleName=" + this.styleName + ", emoji=" + this.emoji + ", text=" + this.text + ", source=" + this.source + ")";
    }

    public Reply(String styleId, String styleName, String emoji, String text, ReplySource source) {
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(styleName, "styleName");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        this.styleId = styleId;
        this.styleName = styleName;
        this.emoji = emoji;
        this.text = text;
        this.source = source;
    }

    public final String getStyleId() {
        return this.styleId;
    }

    public final String getStyleName() {
        return this.styleName;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final String getText() {
        return this.text;
    }

    public final ReplySource getSource() {
        return this.source;
    }
}
