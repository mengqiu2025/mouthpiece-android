package com.mouthpiece.app.domain;

import androidx.autofill.HintConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Models.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/mouthpiece/app/domain/StylePreset;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "emoji", "scene", "Lcom/mouthpiece/app/domain/Scene;", "tagline", "systemPrompt", "temperature", "", "hints", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mouthpiece/app/domain/Scene;Ljava/lang/String;Ljava/lang/String;FLjava/util/List;)V", "getId", "()Ljava/lang/String;", "getName", "getEmoji", "getScene", "()Lcom/mouthpiece/app/domain/Scene;", "getTagline", "getSystemPrompt", "getTemperature", "()F", "getHints", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StylePreset {
    public static final int $stable = 8;
    private final String emoji;
    private final List<String> hints;
    private final String id;
    private final String name;
    private final Scene scene;
    private final String systemPrompt;
    private final String tagline;
    private final float temperature;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StylePreset copy$default(StylePreset stylePreset, String str, String str2, String str3, Scene scene, String str4, String str5, float f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stylePreset.id;
        }
        if ((i & 2) != 0) {
            str2 = stylePreset.name;
        }
        if ((i & 4) != 0) {
            str3 = stylePreset.emoji;
        }
        if ((i & 8) != 0) {
            scene = stylePreset.scene;
        }
        if ((i & 16) != 0) {
            str4 = stylePreset.tagline;
        }
        if ((i & 32) != 0) {
            str5 = stylePreset.systemPrompt;
        }
        if ((i & 64) != 0) {
            f = stylePreset.temperature;
        }
        if ((i & 128) != 0) {
            list = stylePreset.hints;
        }
        float f2 = f;
        List list2 = list;
        String str6 = str4;
        String str7 = str5;
        return stylePreset.copy(str, str2, str3, scene, str6, str7, f2, list2);
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
    public final String getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Scene getScene() {
        return this.scene;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTagline() {
        return this.tagline;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getTemperature() {
        return this.temperature;
    }

    public final List<String> component8() {
        return this.hints;
    }

    public final StylePreset copy(String id, String name, String emoji, Scene scene, String tagline, String systemPrompt, float temperature, List<String> hints) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(tagline, "tagline");
        Intrinsics.checkNotNullParameter(systemPrompt, "systemPrompt");
        Intrinsics.checkNotNullParameter(hints, "hints");
        return new StylePreset(id, name, emoji, scene, tagline, systemPrompt, temperature, hints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StylePreset)) {
            return false;
        }
        StylePreset stylePreset = (StylePreset) other;
        return Intrinsics.areEqual(this.id, stylePreset.id) && Intrinsics.areEqual(this.name, stylePreset.name) && Intrinsics.areEqual(this.emoji, stylePreset.emoji) && this.scene == stylePreset.scene && Intrinsics.areEqual(this.tagline, stylePreset.tagline) && Intrinsics.areEqual(this.systemPrompt, stylePreset.systemPrompt) && Float.compare(this.temperature, stylePreset.temperature) == 0 && Intrinsics.areEqual(this.hints, stylePreset.hints);
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.emoji.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.tagline.hashCode()) * 31) + this.systemPrompt.hashCode()) * 31) + Float.hashCode(this.temperature)) * 31) + this.hints.hashCode();
    }

    public String toString() {
        return "StylePreset(id=" + this.id + ", name=" + this.name + ", emoji=" + this.emoji + ", scene=" + this.scene + ", tagline=" + this.tagline + ", systemPrompt=" + this.systemPrompt + ", temperature=" + this.temperature + ", hints=" + this.hints + ")";
    }

    public StylePreset(String id, String name, String emoji, Scene scene, String tagline, String systemPrompt, float temperature, List<String> hints) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(tagline, "tagline");
        Intrinsics.checkNotNullParameter(systemPrompt, "systemPrompt");
        Intrinsics.checkNotNullParameter(hints, "hints");
        this.id = id;
        this.name = name;
        this.emoji = emoji;
        this.scene = scene;
        this.tagline = tagline;
        this.systemPrompt = systemPrompt;
        this.temperature = temperature;
        this.hints = hints;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StylePreset(String str, String str2, String str3, Scene scene, String str4, String str5, float f, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        float f2;
        List listEmptyList;
        if ((i & 64) == 0) {
            f2 = f;
        } else {
            f2 = 0.8f;
        }
        if ((i & 128) == 0) {
            listEmptyList = list;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this(str, str2, str3, scene, str4, str5, f2, listEmptyList);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final String getTagline() {
        return this.tagline;
    }

    public final String getSystemPrompt() {
        return this.systemPrompt;
    }

    public final float getTemperature() {
        return this.temperature;
    }

    public final List<String> getHints() {
        return this.hints;
    }
}
