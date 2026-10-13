package com.mouthpiece.app.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006\""}, d2 = {"Lcom/mouthpiece/app/domain/ReplyRequest;", "", "incoming", "", "styles", "", "Lcom/mouthpiece/app/domain/StylePreset;", "strength", "", "persona", "Lcom/mouthpiece/app/domain/Persona;", "extraHint", "<init>", "(Ljava/lang/String;Ljava/util/List;ILcom/mouthpiece/app/domain/Persona;Ljava/lang/String;)V", "getIncoming", "()Ljava/lang/String;", "getStyles", "()Ljava/util/List;", "getStrength", "()I", "getPersona", "()Lcom/mouthpiece/app/domain/Persona;", "getExtraHint", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ReplyRequest {
    public static final int $stable = 8;
    private final String extraHint;
    private final String incoming;
    private final Persona persona;
    private final int strength;
    private final List<StylePreset> styles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReplyRequest copy$default(ReplyRequest replyRequest, String str, List list, int i, Persona persona, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = replyRequest.incoming;
        }
        if ((i2 & 2) != 0) {
            list = replyRequest.styles;
        }
        if ((i2 & 4) != 0) {
            i = replyRequest.strength;
        }
        if ((i2 & 8) != 0) {
            persona = replyRequest.persona;
        }
        if ((i2 & 16) != 0) {
            str2 = replyRequest.extraHint;
        }
        String str3 = str2;
        int i3 = i;
        return replyRequest.copy(str, list, i3, persona, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIncoming() {
        return this.incoming;
    }

    public final List<StylePreset> component2() {
        return this.styles;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStrength() {
        return this.strength;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Persona getPersona() {
        return this.persona;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExtraHint() {
        return this.extraHint;
    }

    public final ReplyRequest copy(String incoming, List<StylePreset> styles, int strength, Persona persona, String extraHint) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(styles, "styles");
        Intrinsics.checkNotNullParameter(extraHint, "extraHint");
        return new ReplyRequest(incoming, styles, strength, persona, extraHint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReplyRequest)) {
            return false;
        }
        ReplyRequest replyRequest = (ReplyRequest) other;
        return Intrinsics.areEqual(this.incoming, replyRequest.incoming) && Intrinsics.areEqual(this.styles, replyRequest.styles) && this.strength == replyRequest.strength && Intrinsics.areEqual(this.persona, replyRequest.persona) && Intrinsics.areEqual(this.extraHint, replyRequest.extraHint);
    }

    public int hashCode() {
        return (((((((this.incoming.hashCode() * 31) + this.styles.hashCode()) * 31) + Integer.hashCode(this.strength)) * 31) + (this.persona == null ? 0 : this.persona.hashCode())) * 31) + this.extraHint.hashCode();
    }

    public String toString() {
        return "ReplyRequest(incoming=" + this.incoming + ", styles=" + this.styles + ", strength=" + this.strength + ", persona=" + this.persona + ", extraHint=" + this.extraHint + ")";
    }

    public ReplyRequest(String incoming, List<StylePreset> styles, int strength, Persona persona, String extraHint) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(styles, "styles");
        Intrinsics.checkNotNullParameter(extraHint, "extraHint");
        this.incoming = incoming;
        this.styles = styles;
        this.strength = strength;
        this.persona = persona;
        this.extraHint = extraHint;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ReplyRequest(String str, List list, int i, Persona persona, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String str3;
        if ((i2 & 16) == 0) {
            str3 = str2;
        } else {
            str3 = "";
        }
        this(str, list, i, persona, str3);
    }

    public final String getIncoming() {
        return this.incoming;
    }

    public final List<StylePreset> getStyles() {
        return this.styles;
    }

    public final int getStrength() {
        return this.strength;
    }

    public final Persona getPersona() {
        return this.persona;
    }

    public final String getExtraHint() {
        return this.extraHint;
    }
}
