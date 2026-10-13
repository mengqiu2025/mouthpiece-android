package com.mouthpiece.app.ui.screens;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mouthpiece.app.data.HistoryStore;
import com.mouthpiece.app.domain.GenState;
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.domain.StylePreset;
import com.mouthpiece.app.ui.components.ComponentsKt;
import com.mouthpiece.app.vm.MainUiState;
import com.mouthpiece.app.vm.ReplyKey;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResultScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\f\u001a\u008d\u0001\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001e\u001a9\u0010\u001f\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000f2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010$\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00112\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"ResultScreen", "", "state", "Lcom/mouthpiece/app/vm/MainUiState;", "onBack", "Lkotlin/Function0;", "onCopy", "Lkotlin/Function1;", "Lcom/mouthpiece/app/domain/Reply;", "onFavorite", "onShare", "onRegenerate", "(Lcom/mouthpiece/app/vm/MainUiState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DoneContent", "replies", "", "aiError", "", "sharing", "", "favoriteKeys", "", "Lcom/mouthpiece/app/vm/ReplyKey;", "incoming", "(Ljava/util/List;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PageIndicator", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "pageCount", "", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/runtime/Composer;I)V", "LoadingContent", "styles", "Lcom/mouthpiece/app/domain/StylePreset;", "done", "total", "(Ljava/util/List;IILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CenterButton", "text", "onClick", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ResultScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CenterButton$lambda$17(String str, Function0 function0, int i, Composer composer, int i2) {
        CenterButton(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DoneContent$lambda$5(List list, String str, boolean z, Set set, String str2, Function1 function1, Function1 function2, Function1 function3, Function0 function0, int i, Composer composer, int i2) {
        DoneContent(list, str, z, set, str2, function1, function2, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DoneContent$lambda$9(List list, String str, boolean z, Set set, String str2, Function1 function1, Function1 function2, Function1 function3, Function0 function0, int i, Composer composer, int i2) {
        DoneContent(list, str, z, set, str2, function1, function2, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingContent$lambda$15(List list, int i, int i2, Function0 function0, int i3, Composer composer, int i4) {
        LoadingContent(list, i, i2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageIndicator$lambda$12(PagerState pagerState, int i, int i2, Composer composer, int i3) {
        PageIndicator(pagerState, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResultScreen$lambda$3(MainUiState mainUiState, Function0 function0, Function1 function1, Function1 function2, Function1 function3, Function0 function4, int i, Composer composer, int i2) {
        ResultScreen(mainUiState, function0, function1, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ResultScreen(final MainUiState state, Function0<Unit> onBack, final Function1<? super Reply, Unit> onCopy, final Function1<? super Reply, Unit> onFavorite, final Function1<? super Reply, Unit> onShare, final Function0<Unit> onRegenerate, Composer $composer, final int $changed) {
        Function0<Unit> function0;
        Function0<ComposeUiNode> function1;
        int i;
        Function0<ComposeUiNode> function2;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onCopy, "onCopy");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onShare, "onShare");
        Intrinsics.checkNotNullParameter(onRegenerate, "onRegenerate");
        Composer $composer2 = $composer.startRestartGroup(1113937005);
        ComposerKt.sourceInformation($composer2, "C(ResultScreen)P(5!3,4)53@2074L28,57@2147L1373:ResultScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onBack) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(onCopy) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(onFavorite) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(onShare) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(onRegenerate) ? 131072 : 65536;
        }
        int $dirty2 = $dirty;
        if ((74899 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1113937005, $dirty2, -1, "com.mouthpiece.app.ui.screens.ResultScreen (ResultScreen.kt:52)");
            }
            BackHandlerKt.BackHandler(false, onBack, $composer2, $dirty2 & 112, 1);
            List<StylePreset> selectedStyles = state.getSelectedStyles();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            Composer composer = $composer2;
            ComposerKt.sourceInformationMarkerStart(composer, -1437247255, "C58@2199L146,64@2355L29:ResultScreen.kt#987w0c");
            ComponentsKt.AppHeader("挑一句直接用", StringsKt.take(StringsKt.replace$default(state.getIncoming(), '\n', ' ', false, 4, (Object) null), 28), onBack, null, composer, (($dirty2 << 3) & 896) | 6, 8);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), composer, 6);
            GenState genState = state.getGenState();
            if (genState instanceof GenState.Done) {
                composer.startReplaceGroup(784928774);
                ComposerKt.sourceInformation(composer, "67@2465L399");
                DoneContent(((GenState.Done) genState).getReplies(), state.getAiError(), state.getSharing(), state.getFavoriteKeys(), state.getIncoming(), onCopy, onFavorite, onShare, onRegenerate, composer, (($dirty2 << 9) & 458752) | (($dirty2 << 9) & 3670016) | (($dirty2 << 9) & 29360128) | (234881024 & ($dirty2 << 9)));
                composer = composer;
                composer.endReplaceGroup();
                function0 = onBack;
            } else {
                function0 = onBack;
                if (genState instanceof GenState.Loading) {
                    composer.startReplaceGroup(784942511);
                    ComposerKt.sourceInformation(composer, "79@2901L184");
                    LoadingContent(selectedStyles, ((GenState.Loading) genState).getDone(), ((GenState.Loading) genState).getTotal(), onRegenerate, composer, ($dirty2 >> 6) & 7168);
                    composer.endReplaceGroup();
                } else if (genState instanceof GenState.Failed) {
                    composer.startReplaceGroup(784949547);
                    ComposerKt.sourceInformation(composer, "86@3121L180");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default2);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int i6 = ((((6 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        function2 = constructor2;
                        composer.createNode(function2);
                    } else {
                        function2 = constructor2;
                        composer.useNode();
                    }
                    Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl(composer);
                    Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl2.getInserting()) {
                        i2 = 6;
                    } else {
                        i2 = 6;
                        if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        }
                        Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = (i6 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i8 = ((i2 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer, 1660088376, "C87@3181L55,88@3253L34:ResultScreen.kt#987w0c");
                        ComponentsKt.EmptyState("没能生成", ((GenState.Failed) genState).getMessage(), composer, 6);
                        CenterButton("重新生成", onRegenerate, composer, (($dirty2 >> 12) & 112) | 6);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    }
                    composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i9 = (i6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    int i10 = ((i2 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, 1660088376, "C87@3181L55,88@3253L34:ResultScreen.kt#987w0c");
                    ComponentsKt.EmptyState("没能生成", ((GenState.Failed) genState).getMessage(), composer, 6);
                    CenterButton("重新生成", onRegenerate, composer, (($dirty2 >> 12) & 112) | 6);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else if (Intrinsics.areEqual(genState, GenState.Idle.INSTANCE)) {
                    composer.startReplaceGroup(784956291);
                    ComposerKt.sourceInformation(composer, "91@3332L172");
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default3);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i11 = ((((6 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        function1 = constructor3;
                        composer.createNode(function1);
                    } else {
                        function1 = constructor3;
                        composer.useNode();
                    }
                    Composer composerM3831constructorimpl3 = Updater.m3831constructorimpl(composer);
                    Updater.m3838setimpl(composerM3831constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl3.getInserting()) {
                        i = 6;
                    } else {
                        i = 6;
                        if (!Intrinsics.areEqual(composerM3831constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        }
                        Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i12 = (i11 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        int i13 = ((i >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer, -380586977, "C92@3392L54,93@3463L27:ResultScreen.kt#987w0c");
                        ComponentsKt.EmptyState("还没有结果", "回到输入页粘贴一句话试试", composer, 54);
                        CenterButton("去输入", function0, composer, ($dirty2 & 112) | 6);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    }
                    composerM3831constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3831constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i14 = (i11 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    int i15 = ((i >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, -380586977, "C92@3392L54,93@3463L27:ResultScreen.kt#987w0c");
                    ComponentsKt.EmptyState("还没有结果", "回到输入页粘贴一句话试试", composer, 54);
                    CenterButton("去输入", function0, composer, ($dirty2 & 112) | 6);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(784927223);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            function0 = onBack;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function3 = function0;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResultScreenKt.ResultScreen$lambda$3(state, function3, onCopy, onFavorite, onShare, onRegenerate, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x025d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0277  */
    /* JADX WARN: Code duplicated, block: B:99:0x0254  */
    private static final void DoneContent(final List<Reply> list, final String aiError, final boolean sharing, final Set<ReplyKey> set, final String incoming, final Function1<? super Reply, Unit> function1, final Function1<? super Reply, Unit> function2, final Function1<? super Reply, Unit> function3, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function1<? super Reply, Unit> function4;
        Function1<? super Reply, Unit> function5;
        Function1<? super Reply, Unit> function6;
        Composer $composer2;
        Function0<ComposeUiNode> function7;
        int i;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer $composer3 = $composer.startRestartGroup(1608251193);
        ComposerKt.sourceInformation($composer3, "C(DoneContent)P(7!1,8!4,6)119@4090L16,119@4059L48,121@4113L1589:ResultScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(aiError) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(sharing) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(set) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(incoming) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            function4 = function1;
            $dirty |= $composer3.changedInstance(function4) ? 131072 : 65536;
        } else {
            function4 = function1;
        }
        if ((1572864 & $changed) == 0) {
            function5 = function2;
            $dirty |= $composer3.changedInstance(function5) ? 1048576 : 524288;
        } else {
            function5 = function2;
        }
        if ((12582912 & $changed) == 0) {
            function6 = function3;
            $dirty |= $composer3.changedInstance(function6) ? 8388608 : 4194304;
        } else {
            function6 = function3;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1608251193, $dirty2, -1, "com.mouthpiece.app.ui.screens.DoneContent (ResultScreen.kt:110)");
            }
            $composer3.startReplaceGroup(-658820554);
            ComposerKt.sourceInformation($composer3, "112@3848L167");
            if (list.isEmpty()) {
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxSize$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    function7 = constructor;
                    $composer3.createNode(function7);
                } else {
                    function7 = constructor;
                    $composer3.useNode();
                }
                Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3831constructorimpl.getInserting()) {
                    i = currentCompositeKeyHash;
                    if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(i))) {
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = (i2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i4 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1293070838, "C113@3904L54,114@3971L34:ResultScreen.kt#987w0c");
                    ComponentsKt.EmptyState("还没有结果", "回到输入页粘贴一句话试试", $composer3, 54);
                    CenterButton("重新生成", function0, $composer3, (($dirty2 >> 21) & 112) | 6);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function1<? super Reply, Unit> function8 = function4;
                        final Function1<? super Reply, Unit> function9 = function5;
                        final Function1<? super Reply, Unit> function10 = function6;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ResultScreenKt.DoneContent$lambda$5(list, aiError, sharing, set, incoming, function8, function9, function10, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i = currentCompositeKeyHash;
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(i));
                composerM3831constructorimpl.apply(Integer.valueOf(i), setCompositeKeyHash);
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i6 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1293070838, "C113@3904L54,114@3971L34:ResultScreen.kt#987w0c");
                ComponentsKt.EmptyState("还没有结果", "回到输入页粘贴一句话试试", $composer3, 54);
                CenterButton("重新生成", function0, $composer3, (($dirty2 >> 21) & 112) | 6);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function1 function11 = function4;
                    final Function1 function12 = function5;
                    final Function1 function13 = function6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ResultScreenKt.DoneContent$lambda$5(list, aiError, sharing, set, incoming, function11, function12, function13, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer3, "CC(remember):ResultScreen.kt#9igjgp");
            boolean zChangedInstance = $composer3.changedInstance(list);
            Object objRememberedValue = $composer3.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(list.size());
                    }
                };
                $composer3.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            $composer3.endReplaceGroup();
            PagerState pagerState = PagerStateKt.rememberPagerState(0, 0.0f, (Function0) objRememberedValue, $composer3, 0, 3);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxSize$default2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i7 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = (i7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            int i9 = ((6 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 20018885, "C136@4649L602,131@4450L801,152@5261L64,154@5335L322,164@5666L30:ResultScreen.kt#987w0c");
            $composer3.startReplaceGroup(-414997482);
            ComposerKt.sourceInformation($composer3, "125@4284L146");
            if (aiError != null) {
                ComponentsKt.AiFallbackNotice(aiError, PaddingKt.m737paddingVpY3zN4(Modifier.INSTANCE, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(4)), $composer3, (($dirty2 >> 3) & 14) | 48, 0);
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            PagerKt.m981HorizontalPager8jOkeI(pagerState, ColumnScope.weight$default(columnScope, Modifier.INSTANCE, 1.0f, false, 2, null), PaddingKt.m731PaddingValuesYgX7TsA$default(Dp.m7016constructorimpl(20), 0.0f, 2, null), null, 0, Dp.m7016constructorimpl(12), null, null, false, false, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(447283618, true, new ResultScreenKt$DoneContent$3$1(list, sharing, set, incoming, function1, function2, function3, function0), $composer3, 54), $composer3, 196992, 24576, 16344);
            PageIndicator(pagerState, list.size(), $composer3, 0);
            ButtonKt.Button(function0, SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), Dp.m7016constructorimpl(56)), false, RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), null, null, null, null, null, ComposableSingletons$ResultScreenKt.INSTANCE.getLambda$1849054355$app_debug(), $composer3, (($dirty2 >> 24) & 14) | 805306416, HistoryStore.MAX_ITEMS);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(28)), $composer3, 6);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ResultScreenKt.DoneContent$lambda$9(list, aiError, sharing, set, incoming, function1, function2, function3, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0192  */
    /* JADX WARN: Code duplicated, block: B:44:0x019d  */
    /* JADX WARN: Code duplicated, block: B:45:0x019f  */
    /* JADX WARN: Code duplicated, block: B:48:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:52:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:53:0x0200  */
    /* JADX WARN: Code duplicated, block: B:57:0x025b  */
    private static final void PageIndicator(final PagerState pagerState, final int pageCount, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Composer composer;
        int i;
        int i2;
        boolean z;
        boolean z2;
        float fM7016constructorimpl;
        long outline;
        Composer $composer3 = $composer.startRestartGroup(891736226);
        ComposerKt.sourceInformation($composer3, "C(PageIndicator)P(1)176@5926L819:ResultScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(pagerState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(pageCount) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(891736226, $dirty, -1, "com.mouthpiece.app.ui.screens.PageIndicator (ResultScreen.kt:175)");
            }
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m7016constructorimpl(16), 1, null);
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier = modifierM738paddingVpY3zN4$default;
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = (i3 >> 6) & 14;
                composer = $composer2;
                ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                i = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, 1066692504, "C:ResultScreen.kt#987w0c");
                composer.startReplaceGroup(-519779893);
                ComposerKt.sourceInformation(composer, "*185@6251L478");
                i2 = 0;
                while (i2 < pageCount) {
                    int i5 = i2;
                    if (i2 == pagerState.getCurrentPage()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z;
                    int i6 = i;
                    Modifier modifier2 = modifier;
                    int i7 = currentCompositeKeyHash;
                    Modifier modifierM738paddingVpY3zN4$default2 = PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(4), 0.0f, 2, null);
                    if (z2) {
                        fM7016constructorimpl = Dp.m7016constructorimpl(10);
                    } else {
                        fM7016constructorimpl = Dp.m7016constructorimpl(7);
                    }
                    Modifier modifierClip = ClipKt.clip(SizeKt.m783size3ABfNKs(modifierM738paddingVpY3zN4$default2, fM7016constructorimpl), RoundedCornerShapeKt.getCircleShape());
                    if (z2) {
                        composer.startReplaceGroup(-294664357);
                        ComposerKt.sourceInformation(composer, "192@6553L11");
                        outline = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-294570117);
                        ComposerKt.sourceInformation(composer, "194@6648L11");
                        outline = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutline();
                        composer.endReplaceGroup();
                    }
                    BoxKt.Box(BackgroundKt.m245backgroundbw27NRU$default(modifierClip, outline, null, 2, null), composer, 0);
                    i2 = i5 + 1;
                    currentCompositeKeyHash = i7;
                    modifier = modifier2;
                    i = i6;
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = (i3 >> 6) & 14;
            composer = $composer2;
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            i = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer, 1066692504, "C:ResultScreen.kt#987w0c");
            composer.startReplaceGroup(-519779893);
            ComposerKt.sourceInformation(composer, "*185@6251L478");
            i2 = 0;
            while (i2 < pageCount) {
                int i9 = i2;
                if (i2 == pagerState.getCurrentPage()) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
                int i10 = i;
                Modifier modifier3 = modifier;
                int i11 = currentCompositeKeyHash;
                Modifier modifierM738paddingVpY3zN4$default3 = PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(4), 0.0f, 2, null);
                if (z2) {
                    fM7016constructorimpl = Dp.m7016constructorimpl(10);
                } else {
                    fM7016constructorimpl = Dp.m7016constructorimpl(7);
                }
                Modifier modifierClip2 = ClipKt.clip(SizeKt.m783size3ABfNKs(modifierM738paddingVpY3zN4$default3, fM7016constructorimpl), RoundedCornerShapeKt.getCircleShape());
                if (z2) {
                    composer.startReplaceGroup(-294664357);
                    ComposerKt.sourceInformation(composer, "192@6553L11");
                    outline = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-294570117);
                    ComposerKt.sourceInformation(composer, "194@6648L11");
                    outline = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOutline();
                    composer.endReplaceGroup();
                }
                BoxKt.Box(BackgroundKt.m245backgroundbw27NRU$default(modifierClip2, outline, null, 2, null), composer, 0);
                i2 = i9 + 1;
                currentCompositeKeyHash = i11;
                modifier = modifier3;
                i = i10;
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResultScreenKt.PageIndicator$lambda$12(pagerState, pageCount, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0218  */
    /* JADX WARN: Code duplicated, block: B:52:0x0220  */
    /* JADX WARN: Code duplicated, block: B:55:0x0230  */
    /* JADX WARN: Code duplicated, block: B:56:0x0233  */
    /* JADX WARN: Code duplicated, block: B:59:0x0255  */
    /* JADX WARN: Code duplicated, block: B:60:0x026f  */
    /* JADX WARN: Code duplicated, block: B:64:0x02a8  */
    private static final void LoadingContent(final List<StylePreset> list, final int done, final int total, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function1;
        Composer $composer2;
        Composer composer;
        List<StylePreset> list2;
        int i;
        int i2;
        float fCoerceIn;
        int i3;
        int i4 = done;
        int i5 = total;
        Composer $composer3 = $composer.startRestartGroup(95485256);
        ComposerKt.sourceInformation($composer3, "C(LoadingContent)P(2!1,3)209@6914L711:ResultScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(i4) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(i5) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(95485256, $dirty2, -1, "com.mouthpiece.app.ui.screens.LoadingContent (ResultScreen.kt:208)");
            }
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(20), 0.0f, 2, null);
            Arrangement.Vertical verticalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM617spacedBy0680j_4, Alignment.INSTANCE.getStart(), $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((((54 << 3) & 112) << 6) & 896) | 6;
            int i7 = 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function1 = constructor;
                $composer3.createNode(function1);
            } else {
                function1 = constructor;
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i8 = (i6 >> 6) & 14;
                composer = $composer2;
                ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i9 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, -1176592393, "C217@7173L10,218@7230L11,215@7093L247:ResultScreen.kt#987w0c");
                TextKt.m2842Text4IGK_g("正在生成 " + i4 + "/" + i5, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6930getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 0, 3120, 55290);
                composer.startReplaceGroup(1486074213);
                ComposerKt.sourceInformation(composer, "*223@7401L150");
                list2 = list;
                i = 0;
                i2 = 0;
                for (Object obj : list2) {
                    int i10 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterable iterable = list2;
                    StylePreset stylePreset = (StylePreset) obj;
                    int i11 = i;
                    if (i5 == 0) {
                        fCoerceIn = 0.0f;
                    } else {
                        fCoerceIn = RangesKt.coerceIn(i4 / i5, 0.0f, 1.0f);
                    }
                    ComponentsKt.LoadingCard(stylePreset, fCoerceIn, composer, StylePreset.$stable);
                    composer.startReplaceGroup(1486080651);
                    ComposerKt.sourceInformation(composer, "227@7580L29");
                    if (i2 == 1) {
                        i3 = i7;
                        SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(2)), composer, i3);
                    } else {
                        i3 = i7;
                    }
                    composer.endReplaceGroup();
                    i5 = total;
                    i7 = i3;
                    i2 = i10;
                    list2 = iterable;
                    i = i11;
                    i4 = done;
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i12 = (i6 >> 6) & 14;
            composer = $composer2;
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i13 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer, -1176592393, "C217@7173L10,218@7230L11,215@7093L247:ResultScreen.kt#987w0c");
            TextKt.m2842Text4IGK_g("正在生成 " + i4 + "/" + i5, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6930getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 0, 3120, 55290);
            composer.startReplaceGroup(1486074213);
            ComposerKt.sourceInformation(composer, "*223@7401L150");
            list2 = list;
            i = 0;
            i2 = 0;
            while (r30.hasNext()) {
                int i14 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable iterable2 = list2;
                StylePreset stylePreset2 = (StylePreset) obj;
                int i15 = i;
                if (i5 == 0) {
                    fCoerceIn = 0.0f;
                } else {
                    fCoerceIn = RangesKt.coerceIn(i4 / i5, 0.0f, 1.0f);
                }
                ComponentsKt.LoadingCard(stylePreset2, fCoerceIn, composer, StylePreset.$stable);
                composer.startReplaceGroup(1486080651);
                ComposerKt.sourceInformation(composer, "227@7580L29");
                if (i2 == 1) {
                    i3 = i7;
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(2)), composer, i3);
                } else {
                    i3 = i7;
                }
                composer.endReplaceGroup();
                i5 = total;
                i7 = i3;
                i2 = i14;
                list2 = iterable2;
                i = i15;
                i4 = done;
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ResultScreenKt.LoadingContent$lambda$15(list, done, total, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void CenterButton(final String text, Function0<Unit> function0, Composer $composer, final int $changed) {
        final Function0<Unit> function1 = function0;
        Composer $composer2 = $composer.startRestartGroup(-1226069909);
        ComposerKt.sourceInformation($composer2, "C(CenterButton)P(1)234@7707L440:ResultScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1226069909, $dirty, -1, "com.mouthpiece.app.ui.screens.CenterButton (ResultScreen.kt:233)");
            }
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(20), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1943417731, "C246@8061L80,240@7870L271:ResultScreen.kt#987w0c");
            function1 = function0;
            ButtonKt.Button(function1, SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(56)), false, RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1635835489, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$CenterButton$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer $composer3, int $changed2) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    ComposerKt.sourceInformation($composer3, "C247@8108L10,247@8075L56:ResultScreen.kt#987w0c");
                    if (($changed2 & 17) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1635835489, $changed2, -1, "com.mouthpiece.app.ui.screens.CenterButton.<anonymous>.<anonymous> (ResultScreen.kt:247)");
                    }
                    TextKt.m2842Text4IGK_g(text, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 0, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 805306416, HistoryStore.MAX_ITEMS);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ResultScreenKt.CenterButton$lambda$17(text, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
