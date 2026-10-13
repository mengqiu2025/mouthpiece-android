package com.mouthpiece.app.domain;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/mouthpiece/app/domain/Persona;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "relation", "tone", "taboo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getRelation", "getTone", "getTaboo", "displayName", "getDisplayName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Persona {
    public static final int $stable = 0;
    private final String id;
    private final String name;
    private final String relation;
    private final String taboo;
    private final String tone;

    public static /* synthetic */ Persona copy$default(Persona persona, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = persona.id;
        }
        if ((i & 2) != 0) {
            str2 = persona.name;
        }
        if ((i & 4) != 0) {
            str3 = persona.relation;
        }
        if ((i & 8) != 0) {
            str4 = persona.tone;
        }
        if ((i & 16) != 0) {
            str5 = persona.taboo;
        }
        String str6 = str5;
        String str7 = str3;
        return persona.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRelation() {
        return this.relation;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTone() {
        return this.tone;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTaboo() {
        return this.taboo;
    }

    public final Persona copy(String id, String name, String relation, String tone, String taboo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(tone, "tone");
        Intrinsics.checkNotNullParameter(taboo, "taboo");
        return new Persona(id, name, relation, tone, taboo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) other;
        return Intrinsics.areEqual(this.id, persona.id) && Intrinsics.areEqual(this.name, persona.name) && Intrinsics.areEqual(this.relation, persona.relation) && Intrinsics.areEqual(this.tone, persona.tone) && Intrinsics.areEqual(this.taboo, persona.taboo);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.relation.hashCode()) * 31) + this.tone.hashCode()) * 31) + this.taboo.hashCode();
    }

    public String toString() {
        return "Persona(id=" + this.id + ", name=" + this.name + ", relation=" + this.relation + ", tone=" + this.tone + ", taboo=" + this.taboo + ")";
    }

    public Persona(String id, String name, String relation, String tone, String taboo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(tone, "tone");
        Intrinsics.checkNotNullParameter(taboo, "taboo");
        this.id = id;
        this.name = name;
        this.relation = relation;
        this.tone = tone;
        this.taboo = taboo;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRelation() {
        return this.relation;
    }

    public final String getTone() {
        return this.tone;
    }

    public final String getTaboo() {
        return this.taboo;
    }

    public final String getDisplayName() {
        if (StringsKt.isBlank(this.relation)) {
            return this.name;
        }
        return this.name + "（" + this.relation + "）";
    }
}
