package com.mouthpiece.app.ui.screens;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.mouthpiece.app.domain.HistoryItem;
import com.mouthpiece.app.ui.components.ComponentsKt;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistoryScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0097\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\u0010H\u0007¢\u0006\u0002\u0010\u0017\u001a?\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0003¢\u0006\u0002\u0010\u001a\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"timeFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "formatTime", "", "millis", "", "HistoryScreen", "", "items", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "query", "onlyFavorite", "", "onQueryChange", "Lkotlin/Function1;", "onToggleFavoriteFilter", "Lkotlin/Function0;", "onToggleFavorite", "onDelete", "onClear", "onReuse", "(Ljava/util/List;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HistoryCard", "item", "(Lcom/mouthpiece/app/domain/HistoryItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "confirmClear"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HistoryScreenKt {
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryCard$lambda$16(HistoryItem historyItem, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        HistoryCard(historyItem, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$14$lambda$6(List list, String str, boolean z, Function1 function1, Function0 function0, Function1 function2, Function1 function3, Function0 function4, Function1 function5, int i, Composer composer, int i2) {
        HistoryScreen(list, str, z, function1, function0, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$15(List list, String str, boolean z, Function1 function1, Function0 function0, Function1 function2, Function1 function3, Function0 function4, Function1 function5, int i, Composer composer, int i2) {
        HistoryScreen(list, str, z, function1, function0, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatTime(long millis) {
        String str = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).format(timeFormatter);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0318  */
    /* JADX WARN: Code duplicated, block: B:103:0x0456  */
    /* JADX WARN: Code duplicated, block: B:106:0x0462  */
    /* JADX WARN: Code duplicated, block: B:107:0x0466  */
    /* JADX WARN: Code duplicated, block: B:118:0x0523  */
    /* JADX WARN: Code duplicated, block: B:119:0x053b  */
    /* JADX WARN: Code duplicated, block: B:122:0x056a  */
    /* JADX WARN: Code duplicated, block: B:124:0x057e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0587  */
    /* JADX WARN: Code duplicated, block: B:128:0x05a0  */
    /* JADX WARN: Code duplicated, block: B:130:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:132:0x060c  */
    /* JADX WARN: Code duplicated, block: B:133:0x060e  */
    /* JADX WARN: Code duplicated, block: B:136:0x0618  */
    /* JADX WARN: Code duplicated, block: B:137:0x061a  */
    /* JADX WARN: Code duplicated, block: B:140:0x0624  */
    /* JADX WARN: Code duplicated, block: B:141:0x0626  */
    /* JADX WARN: Code duplicated, block: B:148:0x063b  */
    /* JADX WARN: Code duplicated, block: B:151:0x0680  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:97:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:98:0x02e0  */
    public static final void HistoryScreen(final List<HistoryItem> list, final String query, final boolean onlyFavorite, final Function1<? super String, Unit> onQueryChange, final Function0<Unit> onToggleFavoriteFilter, final Function1<? super Long, Unit> onToggleFavorite, final Function1<? super Long, Unit> onDelete, final Function0<Unit> onClear, final Function1<? super HistoryItem, Unit> onReuse, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        String str;
        int i;
        char c;
        byte b;
        int i2;
        Composer composer;
        float f;
        Composer composer2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM3831constructorimpl;
        Composer composer3;
        final Function1<? super Long, Unit> function1;
        final Function1<? super Long, Unit> function2;
        final Function1<? super HistoryItem, Unit> function3;
        Composer $composer2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue2;
        final List<HistoryItem> items = list;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Intrinsics.checkNotNullParameter(onToggleFavoriteFilter, "onToggleFavoriteFilter");
        Intrinsics.checkNotNullParameter(onToggleFavorite, "onToggleFavorite");
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(onClear, "onClear");
        Intrinsics.checkNotNullParameter(onReuse, "onReuse");
        Composer $composer3 = $composer.startRestartGroup(-1629540487);
        ComposerKt.sourceInformation($composer3, "C(HistoryScreen)P(!1,8,7,3,6,5,2)63@2584L34,65@2624L2295:HistoryScreen.kt#987w0c");
        int currentMarker = $composer3.getCurrentMarker();
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(items) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(query) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(onlyFavorite) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onQueryChange) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(onToggleFavoriteFilter) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onToggleFavorite) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onDelete) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onClear) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onReuse) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1629540487, $dirty, -1, "com.mouthpiece.app.ui.screens.HistoryScreen (HistoryScreen.kt:62)");
            }
            $composer3.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer3, "CC(remember):HistoryScreen.kt#9igjgp");
            Object objRememberedValue3 = $composer3.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
                objRememberedValue3 = objMutableStateOf$default;
            }
            final MutableState confirmClear$delegate = (MutableState) objRememberedValue3;
            $composer3.endReplaceGroup();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor2;
                $composer3.createNode(function0);
            } else {
                function0 = constructor2;
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl2.getInserting()) {
                str = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            } else {
                str = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
                if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = (i3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                $composer3.startReplaceGroup(1449110275);
                ComposerKt.sourceInformation($composer3, "C69@2780L158,66@2676L272,86@3258L326,97@3594L512,126@4584L329,120@4300L613:HistoryScreen.kt#987w0c");
                ComponentsKt.AppHeader("历史", "共 " + items.size() + " 条", null, ComposableLambdaKt.rememberComposableLambda(1301161539, true, new HistoryScreenKt$HistoryScreen$1$1(items, confirmClear$delegate), $composer3, 54), $composer3, 3078, 4);
                $composer3.startReplaceGroup(-645984091);
                ComposerKt.sourceInformation($composer3, "82@3200L24,77@2990L248");
                if (HistoryScreen$lambda$1(confirmClear$delegate)) {
                    $composer3.startReplaceGroup(5004770);
                    ComposerKt.sourceInformation($composer3, "CC(remember):HistoryScreen.kt#9igjgp");
                    objRememberedValue2 = $composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HistoryScreenKt.HistoryScreen$lambda$14$lambda$4$lambda$3(confirmClear$delegate);
                            }
                        };
                        $composer3.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function4 = (Function0) objRememberedValue2;
                    $composer3.endReplaceGroup();
                    int i6 = (($dirty >> 12) & 7168) | 24582;
                    i2 = 1;
                    i = 2;
                    c = CharCompanionObject.MIN_VALUE;
                    b = -692256719;
                    composer = $composer3;
                    f = 0.0f;
                    ComponentsKt.ConfirmDialog("清空全部历史？", "将删除本机保存的全部历史记录，且无法恢复（不受当前搜索 / 只看收藏筛选影响）。", null, onClear, function4, composer, i6, 4);
                } else {
                    i = 2;
                    c = CharCompanionObject.MIN_VALUE;
                    b = -692256719;
                    i2 = 1;
                    composer = $composer3;
                    f = 0.0f;
                }
                composer.endReplaceGroup();
                composer2 = composer;
                OutlinedTextFieldKt.OutlinedTextField(query, onQueryChange, SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), f, i, null), f, i2, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$711786217$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), (TextFieldColors) null, composer2, (($dirty >> 3) & 14) | 1573248 | (($dirty >> 6) & 112), 12582912, 0, 6160312);
                Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(Modifier.INSTANCE, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(12));
                Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, centerVertically, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM737paddingVpY3zN4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i7 = ((((438 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM3831constructorimpl = Updater.m3831constructorimpl(composer2);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                int i8 = (i7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i9 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, 1101686485, "C102@3825L146:HistoryScreen.kt#987w0c");
                ComponentsKt.PillToggle("只看收藏", onlyFavorite, onToggleFavoriteFilter, composer2, (($dirty >> 3) & 112) | 6 | (($dirty >> 6) & 896));
                composer2.startReplaceGroup(451185199);
                ComposerKt.sourceInformation(composer2, "108@4053L11,108@4023L59");
                if (list.isEmpty()) {
                    composer3 = composer2;
                    ComponentsKt.m7504TagPilliJQMabo("暂无记录", MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), composer3, 6, 0);
                } else {
                    composer3 = composer2;
                }
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.startReplaceGroup(-645947151);
                ComposerKt.sourceInformation(composer2, "113@4151L110");
                if (list.isEmpty()) {
                    ComponentsKt.EmptyState("还没有记录", "复制、收藏或分享一条回复后，会自动沉淀到这里", composer2, 54);
                    composer2.endToMarker(currentMarker);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return HistoryScreenKt.HistoryScreen$lambda$14$lambda$6(list, query, onlyFavorite, onQueryChange, onToggleFavoriteFilter, onToggleFavorite, onDelete, onClear, onReuse, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                items = list;
                function1 = onToggleFavorite;
                function2 = onDelete;
                function3 = onReuse;
                composer2.endReplaceGroup();
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                PaddingValues paddingValuesM733PaddingValuesa9UjIt4$default = PaddingKt.m733PaddingValuesa9UjIt4$default(Dp.m7016constructorimpl(20), 0.0f, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(32), 2, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(12));
                composer2.startReplaceGroup(-1224400529);
                ComposerKt.sourceInformation(composer2, "CC(remember):HistoryScreen.kt#9igjgp");
                $composer2 = $composer3;
                boolean zChangedInstance = $composer2.changedInstance(items);
                if (($dirty & 458752) == 131072) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z5 = zChangedInstance | z;
                if (($dirty & 3670016) == 1048576) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = z5 | z2;
                if (($dirty & 234881024) == 67108864) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z6 | z3;
                objRememberedValue = composer2.rememberedValue();
                if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return HistoryScreenKt.HistoryScreen$lambda$14$lambda$13$lambda$12(items, function1, function2, function3, (LazyListScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                composer2.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierFillMaxSize$default2, null, paddingValuesM733PaddingValuesa9UjIt4$default, false, horizontalOrVerticalM617spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, composer2, 24966, 490);
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i10 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i11 = ((6 >> 6) & 112) | 6;
            $composer3.startReplaceGroup(1449110275);
            ComposerKt.sourceInformation($composer3, "C69@2780L158,66@2676L272,86@3258L326,97@3594L512,126@4584L329,120@4300L613:HistoryScreen.kt#987w0c");
            ComponentsKt.AppHeader("历史", "共 " + items.size() + " 条", null, ComposableLambdaKt.rememberComposableLambda(1301161539, true, new HistoryScreenKt$HistoryScreen$1$1(items, confirmClear$delegate), $composer3, 54), $composer3, 3078, 4);
            $composer3.startReplaceGroup(-645984091);
            ComposerKt.sourceInformation($composer3, "82@3200L24,77@2990L248");
            if (HistoryScreen$lambda$1(confirmClear$delegate)) {
                $composer3.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer3, "CC(remember):HistoryScreen.kt#9igjgp");
                objRememberedValue2 = $composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HistoryScreenKt.HistoryScreen$lambda$14$lambda$4$lambda$3(confirmClear$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(objRememberedValue2);
                }
                Function0 function5 = (Function0) objRememberedValue2;
                $composer3.endReplaceGroup();
                int i12 = (($dirty >> 12) & 7168) | 24582;
                i2 = 1;
                i = 2;
                c = CharCompanionObject.MIN_VALUE;
                b = -692256719;
                composer = $composer3;
                f = 0.0f;
                ComponentsKt.ConfirmDialog("清空全部历史？", "将删除本机保存的全部历史记录，且无法恢复（不受当前搜索 / 只看收藏筛选影响）。", null, onClear, function5, composer, i12, 4);
            } else {
                i = 2;
                c = CharCompanionObject.MIN_VALUE;
                b = -692256719;
                i2 = 1;
                composer = $composer3;
                f = 0.0f;
            }
            composer.endReplaceGroup();
            composer2 = composer;
            OutlinedTextFieldKt.OutlinedTextField(query, onQueryChange, SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), f, i, null), f, i2, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$711786217$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), (TextFieldColors) null, composer2, (($dirty >> 3) & 14) | 1573248 | (($dirty >> 6) & 112), 12582912, 0, 6160312);
            Modifier modifierM737paddingVpY3zN5 = PaddingKt.m737paddingVpY3zN4(Modifier.INSTANCE, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(12));
            Arrangement.Horizontal horizontalM617spacedBy0680j_5 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_5, centerVertically2, composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM737paddingVpY3zN5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i13 = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM3831constructorimpl = Updater.m3831constructorimpl(composer2);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3831constructorimpl.getInserting()) {
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            int i14 = (i13 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i15 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, 1101686485, "C102@3825L146:HistoryScreen.kt#987w0c");
            ComponentsKt.PillToggle("只看收藏", onlyFavorite, onToggleFavoriteFilter, composer2, (($dirty >> 3) & 112) | 6 | (($dirty >> 6) & 896));
            composer2.startReplaceGroup(451185199);
            ComposerKt.sourceInformation(composer2, "108@4053L11,108@4023L59");
            if (list.isEmpty()) {
                composer3 = composer2;
                ComponentsKt.m7504TagPilliJQMabo("暂无记录", MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), composer3, 6, 0);
            } else {
                composer3 = composer2;
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.startReplaceGroup(-645947151);
            ComposerKt.sourceInformation(composer2, "113@4151L110");
            if (list.isEmpty()) {
                ComponentsKt.EmptyState("还没有记录", "复制、收藏或分享一条回复后，会自动沉淀到这里", composer2, 54);
                composer2.endToMarker(currentMarker);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HistoryScreenKt.HistoryScreen$lambda$14$lambda$6(list, query, onlyFavorite, onQueryChange, onToggleFavoriteFilter, onToggleFavorite, onDelete, onClear, onReuse, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            items = list;
            function1 = onToggleFavorite;
            function2 = onDelete;
            function3 = onReuse;
            composer2.endReplaceGroup();
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            PaddingValues paddingValuesM733PaddingValuesa9UjIt4$default2 = PaddingKt.m733PaddingValuesa9UjIt4$default(Dp.m7016constructorimpl(20), 0.0f, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(32), 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM617spacedBy0680j_5 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(12));
            composer2.startReplaceGroup(-1224400529);
            ComposerKt.sourceInformation(composer2, "CC(remember):HistoryScreen.kt#9igjgp");
            $composer2 = $composer3;
            boolean zChangedInstance2 = $composer2.changedInstance(items);
            if (($dirty & 458752) == 131072) {
                z = true;
            } else {
                z = false;
            }
            boolean z7 = zChangedInstance2 | z;
            if (($dirty & 3670016) == 1048576) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z8 = z7 | z2;
            if (($dirty & 234881024) == 67108864) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = z8 | z3;
            objRememberedValue = composer2.rememberedValue();
            if (!z4) {
                Object obj2 = new Function1() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return HistoryScreenKt.HistoryScreen$lambda$14$lambda$13$lambda$12(items, function1, function2, function3, (LazyListScope) obj3);
                    }
                };
                composer2.updateRememberedValue(obj2);
                objRememberedValue = obj2;
            } else {
                Object obj3 = new Function1() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return HistoryScreenKt.HistoryScreen$lambda$14$lambda$13$lambda$12(items, function1, function2, function3, (LazyListScope) obj4);
                    }
                };
                composer2.updateRememberedValue(obj3);
                objRememberedValue = obj3;
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(modifierFillMaxSize$default3, null, paddingValuesM733PaddingValuesa9UjIt4$default2, false, horizontalOrVerticalM617spacedBy0680j_5, null, null, false, null, (Function1) objRememberedValue, composer2, 24966, 490);
            composer2.endReplaceGroup();
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
            function2 = onDelete;
            $composer2 = $composer3;
            function3 = onReuse;
            function1 = onToggleFavorite;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return HistoryScreenKt.HistoryScreen$lambda$15(items, query, onlyFavorite, onQueryChange, onToggleFavoriteFilter, function1, function2, onClear, function3, $changed, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    private static final boolean HistoryScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HistoryScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$14$lambda$4$lambda$3(MutableState $confirmClear$delegate) {
        HistoryScreen$lambda$2($confirmClear$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HistoryScreen$lambda$14$lambda$13$lambda$12(final List $items, final Function1 $onToggleFavorite, final Function1 $onDelete, final Function1 $onReuse, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function1 = new Function1() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HistoryScreenKt.HistoryScreen$lambda$14$lambda$13$lambda$12$lambda$7((HistoryItem) obj);
            }
        };
        final Function1 function2 = new Function1() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$lambda$14$lambda$13$lambda$12$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((HistoryItem) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(HistoryItem historyItem) {
                return null;
            }
        };
        LazyColumn.items($items.size(), new Function1<Integer, Object>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$lambda$14$lambda$13$lambda$12$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return function1.invoke($items.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$lambda$14$lambda$13$lambda$12$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return function2.invoke($items.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$lambda$14$lambda$13$lambda$12$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C178@8826L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int i = $dirty & 14;
                final HistoryItem historyItem = (HistoryItem) $items.get(it);
                $composer.startReplaceGroup(-1653365109);
                ComposerKt.sourceInformation($composer, "C*130@4739L29,131@4801L21,132@4854L17,128@4654L235:HistoryScreen.kt#987w0c");
                $composer.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation($composer, "CC(remember):HistoryScreen.kt#9igjgp");
                boolean zChanged = $composer.changed($onToggleFavorite) | ((((i & 112) ^ 48) > 32 && $composer.changed(historyItem)) || (i & 48) == 32);
                Object objRememberedValue = $composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = $onToggleFavorite;
                    Object obj = (Function0) new Function0<Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$1$5$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function3.invoke(Long.valueOf(historyItem.getId()));
                        }
                    };
                    $composer.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                Function0 function0 = (Function0) objRememberedValue;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation($composer, "CC(remember):HistoryScreen.kt#9igjgp");
                boolean zChanged2 = $composer.changed($onDelete) | ((((i & 112) ^ 48) > 32 && $composer.changed(historyItem)) || (i & 48) == 32);
                Object objRememberedValue2 = $composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function4 = $onDelete;
                    Object obj2 = (Function0) new Function0<Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$1$5$1$2$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function4.invoke(Long.valueOf(historyItem.getId()));
                        }
                    };
                    $composer.updateRememberedValue(obj2);
                    objRememberedValue2 = obj2;
                }
                Function0 function5 = (Function0) objRememberedValue2;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation($composer, "CC(remember):HistoryScreen.kt#9igjgp");
                boolean zChanged3 = $composer.changed($onReuse) | ((((i & 112) ^ 48) > 32 && $composer.changed(historyItem)) || (i & 48) == 32);
                Object objRememberedValue3 = $composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function6 = $onReuse;
                    Object obj3 = (Function0) new Function0<Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$1$5$1$2$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function6.invoke(historyItem);
                        }
                    };
                    $composer.updateRememberedValue(obj3);
                    objRememberedValue3 = obj3;
                }
                $composer.endReplaceGroup();
                HistoryScreenKt.HistoryCard(historyItem, function0, function5, (Function0) objRememberedValue3, $composer, (i >> 3) & 14);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object HistoryScreen$lambda$14$lambda$13$lambda$12$lambda$7(HistoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Long.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HistoryCard(final HistoryItem item, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1097708207);
        ComposerKt.sourceInformation($composer3, "C(HistoryCard)P(!1,3)149@5256L11,149@5206L70,150@5283L1580,146@5075L1788:HistoryScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty & 1171) != 1170 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1097708207, $dirty, -1, "com.mouthpiece.app.ui.screens.HistoryCard (HistoryScreen.kt:145)");
            }
            $composer2 = $composer3;
            CardKt.ElevatedCard(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(20)), CardDefaults.INSTANCE.m1980elevatedCardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, ComposableLambdaKt.rememberComposableLambda(500954358, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt.HistoryCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope ElevatedCard, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function3;
                    Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
                    ComposerKt.sourceInformation($composer4, "C151@5293L1564:HistoryScreen.kt#987w0c");
                    if (($changed2 & 17) == 16 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(500954358, $changed2, -1, "com.mouthpiece.app.ui.screens.HistoryCard.<anonymous> (HistoryScreen.kt:151)");
                    }
                    Modifier modifierM736padding3ABfNKs = PaddingKt.m736padding3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(18));
                    final HistoryItem historyItem = item;
                    Function0<Unit> function4 = function2;
                    Function0<Unit> function5 = function0;
                    Function0<Unit> function6 = function1;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer4, modifierM736padding3ABfNKs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i = ((((6 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor);
                    } else {
                        $composer4.useNode();
                    }
                    Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer4);
                    Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = (i >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    int i3 = ((6 >> 6) & 112) | 6;
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 991403210, "C152@5350L814,173@6260L10,174@6321L11,171@6178L265,178@6456L30,181@6578L10,182@6638L11,179@6499L174,184@6686L30,185@6729L118:HistoryScreen.kt#987w0c");
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier modifier = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer4, modifier);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int i4 = ((((384 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function3 = constructor2;
                        $composer4.createNode(function3);
                    } else {
                        function3 = constructor2;
                        $composer4.useNode();
                    }
                    Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer4);
                    Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i5 = (i4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i6 = ((384 >> 6) & 112) | 6;
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -553740083, "C153@5420L23,154@5460L28,157@5608L10,158@5673L11,155@5505L214,160@5736L27,161@5819L31,161@5780L70,162@5867L283:HistoryScreen.kt#987w0c");
                    ComponentsKt.m7504TagPilliJQMabo(historyItem.getStyleName(), 0L, $composer4, 0, 2);
                    SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(HistoryScreenKt.formatTime(historyItem.getCreatedAt()), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 0, 0, 65530);
                    SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                    IconButtonKt.IconButton(function5, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-934464225, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryCard$1$1$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer5, int $changed3) {
                            ComposerKt.sourceInformation($composer5, "C161@5821L27:HistoryScreen.kt#987w0c");
                            if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-934464225, $changed3, -1, "com.mouthpiece.app.ui.screens.HistoryCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HistoryScreen.kt:161)");
                            }
                            ComponentsKt.FavoriteMark(historyItem.getFavorite(), 0, $composer5, 0, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    IconButtonKt.IconButton(function6, null, false, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$998004616$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.m2842Text4IGK_g(historyItem.getIncoming(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6930getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 0, 3120, 55290);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(10)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(historyItem.getReply(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 0, 0, 65530);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(12)), $composer4, 6);
                    ButtonKt.TextButton(function4, columnScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getEnd()), false, null, null, null, null, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$388110307$app_debug(), $composer4, 805306368, 508);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 24582, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HistoryScreenKt.HistoryCard$lambda$16(item, function0, function1, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
