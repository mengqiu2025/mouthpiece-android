package com.mouthpiece.app.vm;

import com.mouthpiece.app.domain.GenState;
import com.mouthpiece.app.domain.QuotaState;
import com.mouthpiece.app.domain.Scene;
import com.mouthpiece.app.domain.StyleCatalog;
import com.mouthpiece.app.domain.StylePreset;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\rHÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0012HÆ\u0003J\t\u0010J\u001a\u00020\u000fHÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u000fHÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0003J±\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018HÆ\u0001J\u0013\u0010P\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\tHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R!\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b5\u0010!R\u0011\u00108\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b9\u0010\u001dR\u0011\u0010:\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0011\u0010<\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b=\u0010)¨\u0006T"}, d2 = {"Lcom/mouthpiece/app/vm/MainUiState;", "", "incoming", "", "scene", "Lcom/mouthpiece/app/domain/Scene;", "selectedStyleIds", "", "strength", "", "extraHint", "personaId", "genState", "Lcom/mouthpiece/app/domain/GenState;", "showResult", "", "message", "quota", "Lcom/mouthpiece/app/domain/QuotaState;", "aiReady", "sharing", "aiError", "inputTruncated", "favoriteKeys", "", "Lcom/mouthpiece/app/vm/ReplyKey;", "<init>", "(Ljava/lang/String;Lcom/mouthpiece/app/domain/Scene;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/mouthpiece/app/domain/GenState;ZLjava/lang/String;Lcom/mouthpiece/app/domain/QuotaState;ZZLjava/lang/String;ZLjava/util/Set;)V", "getIncoming", "()Ljava/lang/String;", "getScene", "()Lcom/mouthpiece/app/domain/Scene;", "getSelectedStyleIds", "()Ljava/util/List;", "getStrength", "()I", "getExtraHint", "getPersonaId", "getGenState", "()Lcom/mouthpiece/app/domain/GenState;", "getShowResult", "()Z", "getMessage", "getQuota", "()Lcom/mouthpiece/app/domain/QuotaState;", "getAiReady", "getSharing", "getAiError", "getInputTruncated", "getFavoriteKeys", "()Ljava/util/Set;", "selectedStyles", "Lcom/mouthpiece/app/domain/StylePreset;", "getSelectedStyles", "selectedStyles$delegate", "Lkotlin/Lazy;", "quotaText", "getQuotaText", "canGenerate", "getCanGenerate", "inputOverLimit", "getInputOverLimit", "isFavorite", "replyText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MainUiState {
    public static final int $stable = 8;
    private final String aiError;
    private final boolean aiReady;
    private final boolean canGenerate;
    private final String extraHint;
    private final Set<ReplyKey> favoriteKeys;
    private final GenState genState;
    private final String incoming;
    private final boolean inputTruncated;
    private final String message;
    private final String personaId;
    private final QuotaState quota;
    private final Scene scene;
    private final List<String> selectedStyleIds;

    /* JADX INFO: renamed from: selectedStyles$delegate, reason: from kotlin metadata */
    private final Lazy selectedStyles;
    private final boolean sharing;
    private final boolean showResult;
    private final int strength;

    public MainUiState() {
        this(null, null, null, 0, null, null, null, false, null, null, false, false, null, false, null, 32767, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIncoming() {
        return this.incoming;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final QuotaState getQuota() {
        return this.quota;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getAiReady() {
        return this.aiReady;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getSharing() {
        return this.sharing;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAiError() {
        return this.aiError;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getInputTruncated() {
        return this.inputTruncated;
    }

    public final Set<ReplyKey> component15() {
        return this.favoriteKeys;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Scene getScene() {
        return this.scene;
    }

    public final List<String> component3() {
        return this.selectedStyleIds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getStrength() {
        return this.strength;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExtraHint() {
        return this.extraHint;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPersonaId() {
        return this.personaId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final GenState getGenState() {
        return this.genState;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowResult() {
        return this.showResult;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final MainUiState copy(String incoming, Scene scene, List<String> selectedStyleIds, int strength, String extraHint, String personaId, GenState genState, boolean showResult, String message, QuotaState quota, boolean aiReady, boolean sharing, String aiError, boolean inputTruncated, Set<ReplyKey> favoriteKeys) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(selectedStyleIds, "selectedStyleIds");
        Intrinsics.checkNotNullParameter(extraHint, "extraHint");
        Intrinsics.checkNotNullParameter(genState, "genState");
        Intrinsics.checkNotNullParameter(quota, "quota");
        Intrinsics.checkNotNullParameter(favoriteKeys, "favoriteKeys");
        return new MainUiState(incoming, scene, selectedStyleIds, strength, extraHint, personaId, genState, showResult, message, quota, aiReady, sharing, aiError, inputTruncated, favoriteKeys);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MainUiState)) {
            return false;
        }
        MainUiState mainUiState = (MainUiState) other;
        return Intrinsics.areEqual(this.incoming, mainUiState.incoming) && this.scene == mainUiState.scene && Intrinsics.areEqual(this.selectedStyleIds, mainUiState.selectedStyleIds) && this.strength == mainUiState.strength && Intrinsics.areEqual(this.extraHint, mainUiState.extraHint) && Intrinsics.areEqual(this.personaId, mainUiState.personaId) && Intrinsics.areEqual(this.genState, mainUiState.genState) && this.showResult == mainUiState.showResult && Intrinsics.areEqual(this.message, mainUiState.message) && Intrinsics.areEqual(this.quota, mainUiState.quota) && this.aiReady == mainUiState.aiReady && this.sharing == mainUiState.sharing && Intrinsics.areEqual(this.aiError, mainUiState.aiError) && this.inputTruncated == mainUiState.inputTruncated && Intrinsics.areEqual(this.favoriteKeys, mainUiState.favoriteKeys);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.incoming.hashCode() * 31) + this.scene.hashCode()) * 31) + this.selectedStyleIds.hashCode()) * 31) + Integer.hashCode(this.strength)) * 31) + this.extraHint.hashCode()) * 31) + (this.personaId == null ? 0 : this.personaId.hashCode())) * 31) + this.genState.hashCode()) * 31) + Boolean.hashCode(this.showResult)) * 31) + (this.message == null ? 0 : this.message.hashCode())) * 31) + this.quota.hashCode()) * 31) + Boolean.hashCode(this.aiReady)) * 31) + Boolean.hashCode(this.sharing)) * 31) + (this.aiError != null ? this.aiError.hashCode() : 0)) * 31) + Boolean.hashCode(this.inputTruncated)) * 31) + this.favoriteKeys.hashCode();
    }

    public String toString() {
        return "MainUiState(incoming=" + this.incoming + ", scene=" + this.scene + ", selectedStyleIds=" + this.selectedStyleIds + ", strength=" + this.strength + ", extraHint=" + this.extraHint + ", personaId=" + this.personaId + ", genState=" + this.genState + ", showResult=" + this.showResult + ", message=" + this.message + ", quota=" + this.quota + ", aiReady=" + this.aiReady + ", sharing=" + this.sharing + ", aiError=" + this.aiError + ", inputTruncated=" + this.inputTruncated + ", favoriteKeys=" + this.favoriteKeys + ")";
    }

    public MainUiState(String incoming, Scene scene, List<String> selectedStyleIds, int strength, String extraHint, String personaId, GenState genState, boolean showResult, String message, QuotaState quota, boolean aiReady, boolean sharing, String aiError, boolean inputTruncated, Set<ReplyKey> favoriteKeys) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(selectedStyleIds, "selectedStyleIds");
        Intrinsics.checkNotNullParameter(extraHint, "extraHint");
        Intrinsics.checkNotNullParameter(genState, "genState");
        Intrinsics.checkNotNullParameter(quota, "quota");
        Intrinsics.checkNotNullParameter(favoriteKeys, "favoriteKeys");
        this.incoming = incoming;
        this.scene = scene;
        this.selectedStyleIds = selectedStyleIds;
        this.strength = strength;
        this.extraHint = extraHint;
        this.personaId = personaId;
        this.genState = genState;
        this.showResult = showResult;
        this.message = message;
        this.quota = quota;
        this.aiReady = aiReady;
        this.sharing = sharing;
        this.aiError = aiError;
        this.inputTruncated = inputTruncated;
        this.favoriteKeys = favoriteKeys;
        this.selectedStyles = LazyKt.lazy(new Function0() { // from class: com.mouthpiece.app.vm.MainUiState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainUiState.selectedStyles_delegate$lambda$0(this.f$0);
            }
        });
        this.canGenerate = !StringsKt.isBlank(this.incoming) && StringsKt.trim((CharSequence) this.incoming).toString().length() <= 600 && StyleCatalog.INSTANCE.hasSelectionInScene(this.selectedStyleIds, this.scene);
    }

    public /* synthetic */ MainUiState(String str, Scene scene, List list, int i, String str2, String str3, GenState genState, boolean z, String str4, QuotaState quotaState, boolean z2, boolean z3, String str5, boolean z4, Set set, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? Scene.ALL : scene, (i2 & 4) != 0 ? StyleCatalog.INSTANCE.getDefaultSelection() : list, (i2 & 8) != 0 ? 3 : i, (i2 & 16) == 0 ? str2 : "", (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? GenState.Idle.INSTANCE : genState, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? new QuotaState(0, 10, false) : quotaState, (i2 & 1024) != 0 ? false : z2, (i2 & 2048) != 0 ? false : z3, (i2 & 4096) == 0 ? str5 : null, (i2 & 8192) == 0 ? z4 : false, (i2 & 16384) != 0 ? SetsKt.emptySet() : set);
    }

    public final String getIncoming() {
        return this.incoming;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final List<String> getSelectedStyleIds() {
        return this.selectedStyleIds;
    }

    public final int getStrength() {
        return this.strength;
    }

    public final String getExtraHint() {
        return this.extraHint;
    }

    public final String getPersonaId() {
        return this.personaId;
    }

    public final GenState getGenState() {
        return this.genState;
    }

    public final boolean getShowResult() {
        return this.showResult;
    }

    public final String getMessage() {
        return this.message;
    }

    public final QuotaState getQuota() {
        return this.quota;
    }

    public final boolean getAiReady() {
        return this.aiReady;
    }

    public final boolean getSharing() {
        return this.sharing;
    }

    public final String getAiError() {
        return this.aiError;
    }

    public final boolean getInputTruncated() {
        return this.inputTruncated;
    }

    public final Set<ReplyKey> getFavoriteKeys() {
        return this.favoriteKeys;
    }

    public final List<StylePreset> getSelectedStyles() {
        return (List) this.selectedStyles.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List selectedStyles_delegate$lambda$0(MainUiState this$0) {
        return StyleCatalog.INSTANCE.selectedInScene(this$0.selectedStyleIds, this$0.scene);
    }

    public final String getQuotaText() {
        if (this.quota.isPro()) {
            return "会员 · 无限次";
        }
        return "今日剩余 " + this.quota.getRemaining() + "/" + this.quota.getLimit() + " 次";
    }

    public final boolean getCanGenerate() {
        return this.canGenerate;
    }

    public final boolean getInputOverLimit() {
        return StringsKt.trim((CharSequence) this.incoming).toString().length() > 600;
    }

    public final boolean isFavorite(String replyText) {
        Intrinsics.checkNotNullParameter(replyText, "replyText");
        return this.favoriteKeys.contains(new ReplyKey(StringsKt.trim((CharSequence) this.incoming).toString(), replyText));
    }
}
