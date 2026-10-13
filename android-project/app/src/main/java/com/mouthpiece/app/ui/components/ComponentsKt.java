package com.mouthpiece.app.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FavoriteBorderKt;
import androidx.compose.material.icons.filled.FavoriteKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.domain.ReplySource;
import com.mouthpiece.app.domain.StylePreset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Components.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t\u001a5\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001as\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001a\u001d\u0010&\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010'\u001a\u001f\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010*\u001a!\u0010+\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u000203H\u0007¢\u0006\u0002\u00104\u001a+\u00105\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u00106\u001aC\u00107\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010<\u001a\u001f\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010*¨\u0006?"}, d2 = {"AppHeader", "", "title", "", "subtitle", "onClose", "Lkotlin/Function0;", "trailing", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "StyleChip", "style", "Lcom/mouthpiece/app/domain/StylePreset;", "selected", "", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/mouthpiece/app/domain/StylePreset;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ReplyCard", "reply", "Lcom/mouthpiece/app/domain/Reply;", "position", "onCopy", "onFavorite", "onShare", "onRegenerate", "shareEnabled", "isFavorite", "(Lcom/mouthpiece/app/domain/Reply;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/runtime/Composer;II)V", "SourceBadge", "source", "Lcom/mouthpiece/app/domain/ReplySource;", "(Lcom/mouthpiece/app/domain/ReplySource;Landroidx/compose/runtime/Composer;I)V", "LoadingCard", NotificationCompat.CATEGORY_PROGRESS, "", "(Lcom/mouthpiece/app/domain/StylePreset;FLandroidx/compose/runtime/Composer;I)V", "EmptyState", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SectionLabel", "text", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TagPill", "color", "Landroidx/compose/ui/graphics/Color;", "TagPill-iJQMabo", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;II)V", "FavoriteMark", "active", "size", "", "(ZILandroidx/compose/runtime/Composer;II)V", "PillToggle", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ConfirmDialog", "message", "confirmText", "onConfirm", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AiFallbackNotice", "reason", "app_debug"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ComponentsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AiFallbackNotice$lambda$20(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AiFallbackNotice(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppHeader$lambda$2(String str, String str2, Function0 function0, Function2 function2, int i, int i2, Composer composer, int i3) {
        AppHeader(str, str2, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmDialog$lambda$18(String str, String str2, String str3, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        ConfirmDialog(str, str2, str3, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyState$lambda$11(String str, String str2, int i, Composer composer, int i2) {
        EmptyState(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteMark$lambda$15(boolean z, int i, int i2, int i3, Composer composer, int i4) {
        FavoriteMark(z, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingCard$lambda$9(StylePreset stylePreset, float f, int i, Composer composer, int i2) {
        LoadingCard(stylePreset, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PillToggle$lambda$17(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        PillToggle(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReplyCard$lambda$6(Reply reply, String str, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Modifier modifier, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        ReplyCard(reply, str, function0, function1, function2, function3, modifier, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionLabel$lambda$12(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SectionLabel(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SourceBadge$lambda$8(ReplySource replySource, int i, Composer composer, int i2) {
        SourceBadge(replySource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyleChip$lambda$5(StylePreset stylePreset, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StyleChip(stylePreset, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TagPill_iJQMabo$lambda$14(String str, long j, int i, int i2, Composer composer, int i3) {
        m7504TagPilliJQMabo(str, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x043a  */
    /* JADX WARN: Code duplicated, block: B:102:0x0458  */
    /* JADX WARN: Code duplicated, block: B:105:0x047c  */
    /* JADX WARN: Code duplicated, block: B:93:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:94:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:98:0x041f  */
    public static final void AppHeader(final String title, String subtitle, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        String str;
        Function0<Unit> function1;
        Function2<? super Composer, ? super Integer, Unit> function3;
        CompositionLocalMap compositionLocalMap;
        int $dirty;
        int $dirty2;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Composer $composer2;
        Composer composer;
        String subtitle2;
        Composer composer2;
        Function0<Unit> function5;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final String subtitle3;
        final Function0<Unit> function7;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(884225700);
        ComposerKt.sourceInformation($composer3, "C(AppHeader)P(2,1)55@2315L1056:Components.kt#vgzelz");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
            str = subtitle;
        } else if (($changed & 48) == 0) {
            str = subtitle;
            $dirty3 |= $composer3.changed(str) ? 32 : 16;
        } else {
            str = subtitle;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
            function1 = function0;
        } else if (($changed & 384) == 0) {
            function1 = function0;
            $dirty3 |= $composer3.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            function3 = function2;
        } else if (($changed & 3072) == 0) {
            function3 = function2;
            $dirty3 |= $composer3.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function2;
        }
        if (($dirty3 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            subtitle3 = str;
            function7 = function1;
            function6 = function3;
        } else {
            String subtitle4 = i2 != 0 ? null : str;
            Function0<Unit> function8 = i3 != 0 ? null : function1;
            if (i4 != 0) {
                function3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(884225700, $dirty3, -1, "com.mouthpiece.app.ui.components.AppHeader (Components.kt:54)");
            }
            Modifier modifierM739paddingqDBjuR0 = PaddingKt.m739paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(16), Dp.m7016constructorimpl(12), Dp.m7016constructorimpl(8));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM739paddingqDBjuR0);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i5 = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i6 = (i5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            int i7 = ((384 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1256023109, "C61@2525L502:Components.kt#vgzelz");
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i8 = ((((0 << 3) & 112) << 6) & 896) | 6;
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
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl2.getInserting()) {
                compositionLocalMap = currentCompositionLocalMap2;
                $dirty = $dirty3;
            } else {
                compositionLocalMap = currentCompositionLocalMap2;
                $dirty = $dirty3;
                if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = (i8 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 524062114, "C64@2652L10,65@2716L11,62@2578L176:Components.kt#vgzelz");
                $dirty2 = $dirty;
                function4 = function3;
                $composer2 = $composer3;
                TextKt.m2842Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getHeadlineSmall(), $composer3, $dirty2 & 14, 0, 65530);
                $composer3.startReplaceGroup(-398730908);
                ComposerKt.sourceInformation($composer3, "70@2892L10,71@2957L11,68@2807L196");
                if (subtitle4 != null) {
                    String subtitle5 = subtitle4;
                    TextKt.m2842Text4IGK_g(subtitle5, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, ($dirty2 >> 3) & 14, 0, 65530);
                    subtitle2 = subtitle5;
                    composer = $composer3;
                } else {
                    composer = $composer3;
                    subtitle2 = subtitle4;
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.startReplaceGroup(-1564521688);
                ComposerKt.sourceInformation($composer3, "75@3046L8");
                if (function4 != null) {
                    function4.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
                }
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-1564520850);
                ComposerKt.sourceInformation($composer3, "77@3098L257");
                if (function8 != null) {
                    function5 = function8;
                    IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$1578118600$app_debug(), $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    composer2 = $composer3;
                } else {
                    composer2 = $composer3;
                    function5 = function8;
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function4;
                subtitle3 = subtitle2;
                function7 = function5;
            }
            composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = (i8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 524062114, "C64@2652L10,65@2716L11,62@2578L176:Components.kt#vgzelz");
            $dirty2 = $dirty;
            function4 = function3;
            $composer2 = $composer3;
            TextKt.m2842Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getHeadlineSmall(), $composer3, $dirty2 & 14, 0, 65530);
            $composer3.startReplaceGroup(-398730908);
            ComposerKt.sourceInformation($composer3, "70@2892L10,71@2957L11,68@2807L196");
            if (subtitle4 != null) {
                String subtitle6 = subtitle4;
                TextKt.m2842Text4IGK_g(subtitle6, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, ($dirty2 >> 3) & 14, 0, 65530);
                subtitle2 = subtitle6;
                composer = $composer3;
            } else {
                composer = $composer3;
                subtitle2 = subtitle4;
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(-1564521688);
            ComposerKt.sourceInformation($composer3, "75@3046L8");
            if (function4 != null) {
                function4.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1564520850);
            ComposerKt.sourceInformation($composer3, "77@3098L257");
            if (function8 != null) {
                function5 = function8;
                IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$1578118600$app_debug(), $composer3, (($dirty2 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                composer2 = $composer3;
            } else {
                composer2 = $composer3;
                function5 = function8;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function4;
            subtitle3 = subtitle2;
            function7 = function5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.AppHeader$lambda$2(title, subtitle3, function7, function6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0462  */
    /* JADX WARN: Code duplicated, block: B:83:0x0312  */
    /* JADX WARN: Code duplicated, block: B:86:0x031e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0324  */
    /* JADX WARN: Code duplicated, block: B:98:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:99:0x03d4  */
    public static final void StyleChip(final StylePreset style, final boolean selected, final Function0<Unit> onClick, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0<ComposeUiNode> function0;
        int i2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function1;
        Composer composerM3831constructorimpl;
        long onSurface;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-2063167409);
        ComposerKt.sourceInformation($composer2, "C(StyleChip)P(3,2,1)96@3589L11,97@3605L1116:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(style) : $composer2.changedInstance(style) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(onClick) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2063167409, $dirty2, -1, "com.mouthpiece.app.ui.components.StyleChip (Components.kt:95)");
            }
            ColorScheme scheme = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable);
            Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(ClickableKt.m279clickableXHw0xAI$default(BorderKt.border(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(SizeKt.m771heightInVpY3zN4$default(modifier3, Dp.m7016constructorimpl(48), 0.0f, 2, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(16))), selected ? scheme.getPrimaryContainer() : scheme.getSurface(), null, 2, null), BorderStrokeKt.m272BorderStrokecXLIe8U(Dp.m7016constructorimpl(1), selected ? scheme.getPrimary() : scheme.getOutline()), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(16))), false, null, null, onClick, 7, null), Dp.m7016constructorimpl(14), Dp.m7016constructorimpl(6));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierM737paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor2;
                $composer2.createNode(function0);
            } else {
                function0 = constructor2;
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3831constructorimpl2.getInserting()) {
                i2 = 384;
                if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = (i4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i6 = ((i2 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -1457807539, "C110@4136L42,111@4187L28,112@4224L491:Components.kt#vgzelz");
                TextKt.m2842Text4IGK_g(style.getEmoji(), (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Modifier modifier5 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifier5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i7 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function1 = constructor;
                    $composer2.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer2.useNode();
                }
                composerM3831constructorimpl = Updater.m3831constructorimpl($composer2);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                int i8 = (i7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i9 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1781730222, "C115@4324L10,113@4245L201,120@4541L10,118@4459L246:Components.kt#vgzelz");
                String name = style.getName();
                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelLarge();
                if (selected) {
                    onSurface = scheme.getOnPrimaryContainer();
                } else {
                    onSurface = scheme.getOnSurface();
                }
                TextKt.m2842Text4IGK_g(name, (Modifier) null, onSurface, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, labelLarge, $composer2, 0, 0, 65530);
                TextKt.m2842Text4IGK_g(style.getTagline(), (Modifier) null, scheme.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6930getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 0, 3120, 55290);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                i2 = 384;
            }
            composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i10 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i11 = ((i2 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1457807539, "C110@4136L42,111@4187L28,112@4224L491:Components.kt#vgzelz");
            TextKt.m2842Text4IGK_g(style.getEmoji(), (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
            SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier modifier6 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer2, modifier6);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i12 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor;
                $composer2.createNode(function1);
            } else {
                function1 = constructor;
                $composer2.useNode();
            }
            composerM3831constructorimpl = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3831constructorimpl.getInserting()) {
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            int i13 = (i12 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i14 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1781730222, "C115@4324L10,113@4245L201,120@4541L10,118@4459L246:Components.kt#vgzelz");
            String name2 = style.getName();
            TextStyle labelLarge2 = MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelLarge();
            if (selected) {
                onSurface = scheme.getOnPrimaryContainer();
            } else {
                onSurface = scheme.getOnSurface();
            }
            TextKt.m2842Text4IGK_g(name2, (Modifier) null, onSurface, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, labelLarge2, $composer2, 0, 0, 65530);
            TextKt.m2842Text4IGK_g(style.getTagline(), (Modifier) null, scheme.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6930getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, 0, 3120, 55290);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.StyleChip$lambda$5(style, selected, onClick, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ReplyCard(final Reply reply, final String position, final Function0<Unit> onCopy, final Function0<Unit> onFavorite, final Function0<Unit> onShare, final Function0<Unit> onRegenerate, Modifier modifier, boolean shareEnabled, boolean isFavorite, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean shareEnabled2;
        boolean isFavorite2;
        Composer $composer2;
        final Modifier modifier4;
        final boolean shareEnabled3;
        final boolean isFavorite3;
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(onCopy, "onCopy");
        Intrinsics.checkNotNullParameter(onFavorite, "onFavorite");
        Intrinsics.checkNotNullParameter(onShare, "onShare");
        Intrinsics.checkNotNullParameter(onRegenerate, "onRegenerate");
        Composer $composer3 = $composer.startRestartGroup(-723240041);
        ComposerKt.sourceInformation($composer3, "C(ReplyCard)P(7,6,2,3,5,4,1,8)153@5412L11,152@5349L92,155@5476L46,156@5529L2717,149@5218L3028:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(reply) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(position) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onCopy) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onFavorite) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(onShare) ? 16384 : 8192;
        }
        if ((i & 32) != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            $dirty |= $composer3.changedInstance(onRegenerate) ? 131072 : 65536;
        }
        int i2 = i & 64;
        if (i2 != 0) {
            $dirty |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 128;
        if (i3 != 0) {
            $dirty |= 12582912;
            z = shareEnabled;
        } else if ((12582912 & $changed) == 0) {
            z = shareEnabled;
            $dirty |= $composer3.changed(z) ? 8388608 : 4194304;
        } else {
            z = shareEnabled;
        }
        int i4 = i & 256;
        if (i4 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(isFavorite) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($dirty & 38347923) != 38347922 || !$composer3.getSkipping()) {
            if (i2 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                shareEnabled2 = z;
            } else {
                shareEnabled2 = true;
            }
            if (i4 == 0) {
                isFavorite2 = isFavorite;
            } else {
                isFavorite2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-723240041, $dirty, -1, "com.mouthpiece.app.ui.components.ReplyCard (Components.kt:148)");
            }
            final boolean shareEnabled4 = shareEnabled2;
            final boolean isFavorite4 = isFavorite2;
            CardKt.ElevatedCard(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(24)), CardDefaults.INSTANCE.m1980elevatedCardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer3, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m1981elevatedCardElevationaqJV_2Y(Dp.m7016constructorimpl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, (CardDefaults.$stable << 18) | 6, 62), ComposableLambdaKt.rememberComposableLambda(-793265668, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt.ReplyCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:57:0x0619  */
                /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
                public final void invoke(ColumnScope ElevatedCard, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    int i5;
                    Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
                    ComposerKt.sourceInformation($composer4, "C157@5539L2701:Components.kt#vgzelz");
                    if (($changed2 & 17) == 16 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-793265668, $changed2, -1, "com.mouthpiece.app.ui.components.ReplyCard.<anonymous> (Components.kt:157)");
                    }
                    Modifier modifierM736padding3ABfNKs = PaddingKt.m736padding3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(20));
                    Reply reply2 = reply;
                    String str = position;
                    Function0<Unit> function2 = onCopy;
                    Function0<Unit> function3 = onShare;
                    boolean z2 = shareEnabled4;
                    Function0<Unit> function4 = onFavorite;
                    Function0<Unit> function5 = onRegenerate;
                    final boolean z3 = isFavorite4;
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer4, modifierM736padding3ABfNKs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i6 = ((((6 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function0 = constructor;
                        $composer4.createNode(function0);
                    } else {
                        function0 = constructor;
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
                    int i7 = (i6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i8 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -81723853, "C158@5596L729,176@6339L30,179@6461L10,180@6521L11,177@6382L174,182@6569L30,184@6613L1617:Components.kt#vgzelz");
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier modifier5 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer4, modifier5);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int i9 = ((((384 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function1 = constructor2;
                        $composer4.createNode(function1);
                    } else {
                        function1 = constructor2;
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
                    int i10 = (i9 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i11 = ((384 >> 6) & 112) | 6;
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -526381764, "C159@5666L42,160@5725L28,163@5862L10,164@5928L11,161@5770L197,166@5984L27,167@6028L25,168@6070L28,171@6200L10,172@6265L11,169@6115L196:Components.kt#vgzelz");
                    TextKt.m2842Text4IGK_g(reply2.getEmoji(), (Modifier) null, 0L, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3072, 0, 131062);
                    SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(reply2.getStyleName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleMedium(), $composer4, 0, 0, 65530);
                    SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                    ComponentsKt.SourceBadge(reply2.getSource(), $composer4, 0);
                    SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(16)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(reply2.getText(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyLarge(), $composer4, 0, 0, 65530);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(20)), $composer4, 6);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier modifier6 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer4, modifier6);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i12 = ((((384 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor3);
                    } else {
                        $composer4.useNode();
                    }
                    Composer composerM3831constructorimpl3 = Updater.m3831constructorimpl($composer4);
                    Updater.m3838setimpl(composerM3831constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3831constructorimpl3.getInserting()) {
                        i5 = 6;
                        if (!Intrinsics.areEqual(composerM3831constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        }
                        Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i13 = (i12 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        int i14 = ((384 >> 6) & 112) | 6;
                        RowScope rowScope2 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1316673925, "C185@6683L50,186@6750L28,187@6795L308,194@7153L722,194@7120L755,211@7892L27,212@7936L280:Components.kt#vgzelz");
                        ButtonKt.FilledTonalButton(function2, null, false, null, null, null, null, null, null, ComposableSingletons$ComponentsKt.INSTANCE.m7506getLambda$1366598407$app_debug(), $composer4, 805306368, 510);
                        SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer4, i5);
                        IconButtonKt.IconButton(function3, null, z2, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$596680910$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                        IconButtonKt.IconButton(function4, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1160544951, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$ReplyCard$1$1$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                long j;
                                ComposerKt.sourceInformation($composer5, "C195@7175L682:Components.kt#vgzelz");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1160544951, $changed3, -1, "com.mouthpiece.app.ui.components.ReplyCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Components.kt:195)");
                                }
                                ImageVector favorite = z3 ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault());
                                String str2 = z3 ? "取消收藏" : "收藏";
                                if (z3) {
                                    $composer5.startReplaceGroup(-691611632);
                                    ComposerKt.sourceInformation($composer5, "205@7684L11");
                                    long secondary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getSecondary();
                                    $composer5.endReplaceGroup();
                                    j = secondary;
                                } else {
                                    $composer5.startReplaceGroup(-691515191);
                                    ComposerKt.sourceInformation($composer5, "207@7781L11");
                                    long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant();
                                    $composer5.endReplaceGroup();
                                    j = onSurfaceVariant;
                                }
                                IconKt.m2299Iconww6aTOc(favorite, str2, (Modifier) null, j, $composer5, 0, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        SpacerKt.Spacer(RowScope.weight$default(rowScope2, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                        IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$1573451158$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
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
                    i5 = 6;
                    composerM3831constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3831constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i15 = (i12 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i16 = ((384 >> 6) & 112) | 6;
                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1316673925, "C185@6683L50,186@6750L28,187@6795L308,194@7153L722,194@7120L755,211@7892L27,212@7936L280:Components.kt#vgzelz");
                    ButtonKt.FilledTonalButton(function2, null, false, null, null, null, null, null, null, ComposableSingletons$ComponentsKt.INSTANCE.m7506getLambda$1366598407$app_debug(), $composer4, 805306368, 510);
                    SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer4, i5);
                    IconButtonKt.IconButton(function3, null, z2, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$596680910$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                    IconButtonKt.IconButton(function4, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1160544951, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$ReplyCard$1$1$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer5, int $changed3) {
                            long j;
                            ComposerKt.sourceInformation($composer5, "C195@7175L682:Components.kt#vgzelz");
                            if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                $composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1160544951, $changed3, -1, "com.mouthpiece.app.ui.components.ReplyCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Components.kt:195)");
                            }
                            ImageVector favorite = z3 ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault());
                            String str2 = z3 ? "取消收藏" : "收藏";
                            if (z3) {
                                $composer5.startReplaceGroup(-691611632);
                                ComposerKt.sourceInformation($composer5, "205@7684L11");
                                long secondary = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getSecondary();
                                $composer5.endReplaceGroup();
                                j = secondary;
                            } else {
                                $composer5.startReplaceGroup(-691515191);
                                ComposerKt.sourceInformation($composer5, "207@7781L11");
                                long onSurfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer5, MaterialTheme.$stable).getOnSurfaceVariant();
                                $composer5.endReplaceGroup();
                                j = onSurfaceVariant;
                            }
                            IconKt.m2299Iconww6aTOc(favorite, str2, (Modifier) null, j, $composer5, 0, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer4, 54), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    SpacerKt.Spacer(RowScope.weight$default(rowScope3, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                    IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$1573451158$app_debug(), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
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
            }, $composer3, 54), $composer3, 24576, 0);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            shareEnabled3 = shareEnabled4;
            isFavorite3 = isFavorite4;
        } else {
            $composer3.skipToGroupEnd();
            shareEnabled3 = z;
            isFavorite3 = isFavorite;
            $composer2 = $composer3;
            modifier4 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.ReplyCard$lambda$6(reply, position, onCopy, onFavorite, onShare, onRegenerate, modifier4, shareEnabled3, isFavorite3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x022c  */
    public static final void SourceBadge(final ReplySource source, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        long foreground;
        Composer $composer3 = $composer.startRestartGroup(-1946057732);
        ComposerKt.sourceInformation($composer3, "C(SourceBadge)226@8340L11,229@8564L328:Components.kt#vgzelz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(source.ordinal()) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946057732, $dirty, -1, "com.mouthpiece.app.ui.components.SourceBadge (Components.kt:225)");
            }
            ColorScheme scheme = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable);
            long background = source == ReplySource.AI ? scheme.getPrimaryContainer() : scheme.getSurfaceVariant();
            long foreground2 = source == ReplySource.AI ? scheme.getOnPrimaryContainer() : scheme.getOnSurfaceVariant();
            Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(8))), background, null, 2, null), Dp.m7016constructorimpl(8), Dp.m7016constructorimpl(3));
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM737paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((0 << 3) & 112) << 6) & 896) | 6;
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
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                $composer2 = $composer3;
                foreground = foreground2;
            } else {
                $composer2 = $composer3;
                foreground = foreground2;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = (i >> 6) & 14;
                Composer composer = $composer2;
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, 1494332741, "C237@8823L10,235@8750L136:Components.kt#vgzelz");
                TextKt.m2842Text4IGK_g(source.getLabel(), (Modifier) null, foreground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 0, 0, 65530);
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
            int i4 = (i >> 6) & 14;
            Composer composer2 = $composer2;
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, 1494332741, "C237@8823L10,235@8750L136:Components.kt#vgzelz");
            TextKt.m2842Text4IGK_g(source.getLabel(), (Modifier) null, foreground, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelSmall(), composer2, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.SourceBadge$lambda$8(source, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void LoadingCard(final StylePreset style, final float progress, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(style, "style");
        Composer $composer2 = $composer.startRestartGroup(2025223901);
        ComposerKt.sourceInformation($composer2, "C(LoadingCard)P(1)249@9178L11,249@9128L70,250@9205L1010,246@8997L1218:Components.kt#vgzelz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(style) : $composer2.changedInstance(style) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(progress) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025223901, $dirty, -1, "com.mouthpiece.app.ui.components.LoadingCard (Components.kt:245)");
            }
            CardKt.ElevatedCard(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(24)), CardDefaults.INSTANCE.m1980elevatedCardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, ComposableLambdaKt.rememberComposableLambda(1896906114, true, new C07201(progress, style), $composer2, 54), $composer2, 24582, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.LoadingCard$lambda$9(style, progress, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.components.ComponentsKt$LoadingCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Components.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C07201 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ float $progress;
        final /* synthetic */ StylePreset $style;

        C07201(float f, StylePreset stylePreset) {
            this.$progress = f;
            this.$style = stylePreset;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$3$lambda$2$lambda$1(float $progress) {
            return $progress;
        }

        /* JADX WARN: Code duplicated, block: B:28:0x01cb  */
        /* JADX WARN: Code duplicated, block: B:31:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:32:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:51:0x03e5  */
        /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
        public final void invoke(ColumnScope ElevatedCard, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            StylePreset stylePreset;
            int i;
            int currentCompositeKeyHash;
            Function0<ComposeUiNode> constructor;
            Function0<ComposeUiNode> function1;
            Composer composerM3831constructorimpl;
            boolean zChanged;
            Object objRememberedValue;
            Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
            ComposerKt.sourceInformation($composer, "C251@9215L994:Components.kt#vgzelz");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1896906114, $changed, -1, "com.mouthpiece.app.ui.components.LoadingCard.<anonymous> (Components.kt:251)");
            }
            Modifier modifierM736padding3ABfNKs = PaddingKt.m736padding3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(20));
            final float f = this.$progress;
            StylePreset stylePreset2 = this.$style;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifierM736padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i2 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor2;
                $composer.createNode(function0);
            } else {
                function0 = constructor2;
                $composer.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3831constructorimpl2.getInserting()) {
                stylePreset = stylePreset2;
                i = 6;
                if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = (i2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i4 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1676380744, "C252@9272L634,267@9919L30,269@10014L12,268@9962L237:Components.kt#vgzelz");
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Modifier modifier = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = $composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer, modifier);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i5 = ((((384 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor;
                    $composer.useNode();
                }
                composerM3831constructorimpl = Updater.m3831constructorimpl($composer);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = (i5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                int i7 = ((384 >> 6) & 112) | 6;
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1697418485, "C253@9342L42,254@9401L28,257@9533L10,258@9599L11,255@9446L192,260@9655L27,263@9781L10,264@9846L11,261@9699L193:Components.kt#vgzelz");
                TextKt.m2842Text4IGK_g(stylePreset.getEmoji(), (Modifier) null, 0L, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
                SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer, 6);
                TextKt.m2842Text4IGK_g(stylePreset.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 0, 65530);
                SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), $composer, 0);
                TextKt.m2842Text4IGK_g("生成中", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(18)), $composer, 6);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):Components.kt#9igjgp");
                zChanged = $composer.changed(f);
                objRememberedValue = $composer.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function0() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$LoadingCard$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(ComponentsKt.C07201.invoke$lambda$3$lambda$2$lambda$1(f));
                        }
                    };
                    $composer.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                $composer.endReplaceGroup();
                ProgressIndicatorKt.m2520LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, ClipKt.clip(SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(6)), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(3))), 0L, 0L, 0, 0.0f, null, $composer, 0, 124);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            stylePreset = stylePreset2;
            i = 6;
            composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i8 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i9 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1676380744, "C252@9272L634,267@9919L30,269@10014L12,268@9962L237:Components.kt#vgzelz");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer, modifier2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i10 = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function1 = constructor;
                $composer.createNode(function1);
            } else {
                function1 = constructor;
                $composer.useNode();
            }
            composerM3831constructorimpl = Updater.m3831constructorimpl($composer);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3831constructorimpl.getInserting()) {
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = (i10 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            int i12 = ((384 >> 6) & 112) | 6;
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1697418485, "C253@9342L42,254@9401L28,257@9533L10,258@9599L11,255@9446L192,260@9655L27,263@9781L10,264@9846L11,261@9699L193:Components.kt#vgzelz");
            TextKt.m2842Text4IGK_g(stylePreset.getEmoji(), (Modifier) null, 0L, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
            SpacerKt.Spacer(SizeKt.m788width3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer, 6);
            TextKt.m2842Text4IGK_g(stylePreset.getName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 0, 65530);
            SpacerKt.Spacer(RowScope.weight$default(rowScope2, Modifier.INSTANCE, 1.0f, false, 2, null), $composer, 0);
            TextKt.m2842Text4IGK_g("生成中", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(18)), $composer, 6);
            $composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer, "CC(remember):Components.kt#9igjgp");
            zChanged = $composer.changed(f);
            objRememberedValue = $composer.rememberedValue();
            if (!zChanged) {
            }
            Object obj2 = new Function0() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$LoadingCard$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(ComponentsKt.C07201.invoke$lambda$3$lambda$2$lambda$1(f));
                }
            };
            $composer.updateRememberedValue(obj2);
            objRememberedValue = obj2;
            $composer.endReplaceGroup();
            ProgressIndicatorKt.m2520LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue, ClipKt.clip(SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(6)), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(3))), 0L, 0L, 0, 0.0f, null, $composer, 0, 124);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void EmptyState(final String title, String subtitle, Composer $composer, final int $changed) {
        Composer $composer2;
        final String str;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer $composer3 = $composer.startRestartGroup(334013);
        ComposerKt.sourceInformation($composer3, "C(EmptyState)P(1)281@10285L621:Components.kt#vgzelz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(subtitle) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(334013, $dirty, -1, "com.mouthpiece.app.ui.components.EmptyState (Components.kt:280)");
            }
            Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7016constructorimpl(32), Dp.m7016constructorimpl(64));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM737paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1166647298, "C290@10600L10,291@10658L11,288@10534L155,293@10698L29,296@10805L10,297@10862L11,294@10736L164:Components.kt#vgzelz");
            $composer2 = $composer3;
            TextKt.m2842Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, $dirty & 14, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer3, 6);
            str = subtitle;
            TextKt.m2842Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ($dirty >> 3) & 14, 0, 65530);
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
            str = subtitle;
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.EmptyState$lambda$11(title, str, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SectionLabel(final String text, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-354951540);
        ComposerKt.sourceInformation($composer3, "C(SectionLabel)P(1)307@11127L10,308@11220L11,304@10990L260:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (i2 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-354951540, $dirty, -1, "com.mouthpiece.app.ui.components.SectionLabel (Components.kt:303)");
            }
            Modifier modifier3 = modifier2;
            $composer2 = $composer3;
            TextKt.m2842Text4IGK_g(text, PaddingKt.m740paddingqDBjuR0$default(modifier2, Dp.m7016constructorimpl(4), Dp.m7016constructorimpl(20), 0.0f, Dp.m7016constructorimpl(10), 4, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnBackground(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m6470copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), $composer2, $dirty & 14, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.SectionLabel$lambda$12(text, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0090  */
    /* JADX WARN: Code duplicated, block: B:61:0x024a  */
    /* JADX INFO: renamed from: TagPill-iJQMabo, reason: not valid java name */
    public static final void m7504TagPilliJQMabo(final String text, long color, Composer $composer, final int $changed, final int i) {
        long color2;
        long color3;
        Alignment alignment;
        final long color4;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-550326296);
        ComposerKt.sourceInformation($composer3, "C(TagPill)P(1,0:c#ui.graphics.Color)314@11348L332:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            if ((i & 2) == 0) {
                color2 = color;
                int i2 = $composer3.changed(color2) ? 32 : 16;
                $dirty |= i2;
            } else {
                color2 = color;
            }
            $dirty |= i2;
        } else {
            color2 = color;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "313@11321L11");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                    color3 = color2;
                } else {
                    color3 = color2;
                }
            } else if ((i & 2) != 0) {
                $dirty &= -113;
                color3 = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
            } else {
                color3 = color2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-550326296, $dirty, -1, "com.mouthpiece.app.ui.components.TagPill (Components.kt:313)");
            }
            Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(10))), Color.m4387copywmQWz5c(color3, (14 & 1) != 0 ? Color.m4391getAlphaimpl(color3) : 0.12f, (14 & 2) != 0 ? Color.m4395getRedimpl(color3) : 0.0f, (14 & 4) != 0 ? Color.m4394getGreenimpl(color3) : 0.0f, (14 & 8) != 0 ? Color.m4392getBlueimpl(color3) : 0.0f), null, 2, null), Dp.m7016constructorimpl(10), Dp.m7016constructorimpl(5));
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Alignment topStart = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM737paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                alignment = topStart;
            } else {
                alignment = topStart;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = (i3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1736481030, "C322@11616L10,320@11551L123:Components.kt#vgzelz");
                color4 = color3;
                $composer2 = $composer3;
                TextKt.m2842Text4IGK_g(text, (Modifier) null, color4, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, ($dirty & 14) | (($dirty << 3) & 896), 0, 65530);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
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
            int i6 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1736481030, "C322@11616L10,320@11551L123:Components.kt#vgzelz");
            color4 = color3;
            $composer2 = $composer3;
            TextKt.m2842Text4IGK_g(text, (Modifier) null, color4, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, ($dirty & 14) | (($dirty << 3) & 896), 0, 65530);
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
            color4 = color2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.TagPill_iJQMabo$lambda$14(text, color4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FavoriteMark(final boolean active, final int size, Composer $composer, final int $changed, final int i) {
        long outline;
        Composer $composer2 = $composer.startRestartGroup(-2084662695);
        ComposerKt.sourceInformation($composer2, "C(FavoriteMark)331@11773L307:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(active) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(size) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (i2 != 0) {
                size = 20;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2084662695, $dirty, -1, "com.mouthpiece.app.ui.components.FavoriteMark (Components.kt:330)");
            }
            Icons.Filled filled = Icons.INSTANCE.getDefault();
            ImageVector favorite = active ? FavoriteKt.getFavorite(filled) : FavoriteBorderKt.getFavoriteBorder(filled);
            String str = active ? "已收藏" : "未收藏";
            if (active) {
                $composer2.startReplaceGroup(-1906081054);
                ComposerKt.sourceInformation($composer2, "334@11971L11");
                outline = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSecondary();
            } else {
                $composer2.startReplaceGroup(-1906079744);
                ComposerKt.sourceInformation($composer2, "334@12012L11");
                outline = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOutline();
            }
            $composer2.endReplaceGroup();
            IconKt.m2299Iconww6aTOc(favorite, str, SizeKt.m783size3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(size)), outline, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.FavoriteMark$lambda$15(active, size, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void PillToggle(String text, final boolean selected, final Function0<Unit> onClick, Composer $composer, final int $changed) {
        Composer $composer2;
        final String text2 = text;
        Intrinsics.checkNotNullParameter(text2, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer $composer3 = $composer.startRestartGroup(308847437);
        ComposerKt.sourceInformation($composer3, "C(PillToggle)P(2,1)342@12239L11,343@12255L506:Components.kt#vgzelz");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onClick) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(308847437, $dirty2, -1, "com.mouthpiece.app.ui.components.PillToggle (Components.kt:341)");
            }
            ColorScheme scheme = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable);
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(ClickableKt.m279clickableXHw0xAI$default(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(48)), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(14))), selected ? scheme.getPrimary() : scheme.getSurface(), null, 2, null), false, null, null, onClick, 7, null), Dp.m7016constructorimpl(18), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((48 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -759696309, "C354@12643L10,352@12578L177:Components.kt#vgzelz");
            $composer2 = $composer3;
            text2 = text;
            TextKt.m2842Text4IGK_g(text2, (Modifier) null, selected ? scheme.getOnPrimary() : scheme.getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, $dirty2 & 14, 0, 65530);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.PillToggle$lambda$17(text2, selected, onClick, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ConfirmDialog(final String title, final String message, String confirmText, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer $composer, final int $changed, final int i) {
        String str;
        String confirmText2;
        final String confirmText3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-1355692132);
        ComposerKt.sourceInformation($composer3, "C(ConfirmDialog)P(4,1)378@13200L257,388@13483L70,376@13111L22,377@13150L24,374@13044L515:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(message) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            str = confirmText;
        } else if (($changed & 384) == 0) {
            str = confirmText;
            $dirty |= $composer3.changed(str) ? 256 : 128;
        } else {
            str = confirmText;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onConfirm) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(onDismiss) ? 16384 : 8192;
        }
        if (($dirty & 9363) != 9362 || !$composer3.getSkipping()) {
            if (i2 != 0) {
                confirmText2 = "确认清除";
            } else {
                confirmText2 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1355692132, $dirty, -1, "com.mouthpiece.app.ui.components.ConfirmDialog (Components.kt:373)");
            }
            confirmText3 = confirmText2;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1910AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(-203642284, true, new AnonymousClass1(onConfirm, onDismiss, confirmText2), $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(1955441810, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt.ConfirmDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C389@13497L46:Components.kt#vgzelz");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1955441810, $changed2, -1, "com.mouthpiece.app.ui.components.ConfirmDialog.<anonymous> (Components.kt:389)");
                    }
                    ButtonKt.TextButton(onDismiss, null, false, null, null, null, null, null, null, ComposableSingletons$ComponentsKt.INSTANCE.getLambda$1547797941$app_debug(), $composer4, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-180441392, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt.ConfirmDialog.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C376@13113L18:Components.kt#vgzelz");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180441392, $changed2, -1, "com.mouthpiece.app.ui.components.ConfirmDialog.<anonymous> (Components.kt:376)");
                    }
                    TextKt.m2842Text4IGK_g(title, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), ComposableLambdaKt.rememberComposableLambda(899100655, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt.ConfirmDialog.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C377@13152L20:Components.kt#vgzelz");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(899100655, $changed2, -1, "com.mouthpiece.app.ui.components.ConfirmDialog.<anonymous> (Components.kt:377)");
                    }
                    TextKt.m2842Text4IGK_g(message, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 12) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            confirmText3 = str;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.ConfirmDialog$lambda$18(title, message, confirmText3, onConfirm, onDismiss, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.components.ComponentsKt$ConfirmDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: Components.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $confirmText;
        final /* synthetic */ Function0<Unit> $onConfirm;
        final /* synthetic */ Function0<Unit> $onDismiss;

        AnonymousClass1(Function0<Unit> function0, Function0<Unit> function1, String str) {
            this.$onConfirm = function0;
            this.$onDismiss = function1;
            this.$confirmText = str;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C380@13252L83,384@13350L97,379@13214L233:Components.kt#vgzelz");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-203642284, $changed, -1, "com.mouthpiece.app.ui.components.ConfirmDialog.<anonymous> (Components.kt:379)");
            }
            $composer.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation($composer, "CC(remember):Components.kt#9igjgp");
            boolean zChanged = $composer.changed(this.$onConfirm) | $composer.changed(this.$onDismiss);
            final Function0<Unit> function0 = this.$onConfirm;
            final Function0<Unit> function1 = this.$onDismiss;
            Object objRememberedValue = $composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function0() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$ConfirmDialog$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComponentsKt.AnonymousClass1.invoke$lambda$1$lambda$0(function0, function1);
                    }
                };
                $composer.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            $composer.endReplaceGroup();
            final String str = this.$confirmText;
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-611286153, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComponentsKt.ConfirmDialog.1.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer $composer2, int $changed2) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation($composer2, "C385@13415L11,385@13368L65:Components.kt#vgzelz");
                    if (($changed2 & 17) == 16 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611286153, $changed2, -1, "com.mouthpiece.app.ui.components.ConfirmDialog.<anonymous>.<anonymous> (Components.kt:385)");
                    }
                    TextKt.m2842Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131066);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function0 $onConfirm, Function0 $onDismiss) {
            $onConfirm.invoke();
            $onDismiss.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x02cc  */
    public static final void AiFallbackNotice(String reason, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        int i2;
        Composer $composer2;
        final String reason2 = reason;
        Intrinsics.checkNotNullParameter(reason2, "reason");
        Composer $composer3 = $composer.startRestartGroup(1948315865);
        ComposerKt.sourceInformation($composer3, "C(AiFallbackNotice)P(1)403@13841L11,404@13857L857:Components.kt#vgzelz");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(reason2) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) != 18 || !$composer3.getSkipping()) {
            Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1948315865, $dirty, -1, "com.mouthpiece.app.ui.components.AiFallbackNotice (Components.kt:402)");
            }
            ColorScheme scheme = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable);
            Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(14))), scheme.getErrorContainer(), null, 2, null), Dp.m7016constructorimpl(14), Dp.m7016constructorimpl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM737paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                i2 = 6;
            } else {
                i2 = 6;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = (i4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1246677208, "C413@14168L10,411@14088L156,416@14253L29,419@14358L10,417@14291L143,422@14443L29,426@14632L10,423@14481L227:Components.kt#vgzelz");
                TextKt.m2842Text4IGK_g("AI 调用失败，这次用的是离线模板", (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, 6, 0, 65530);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(3)), $composer3, i2);
                Modifier modifier4 = modifier3;
                $composer2 = $composer3;
                reason2 = reason;
                TextKt.m2842Text4IGK_g(reason2, (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, $dirty & 14, 0, 65530);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(5)), $composer3, 6);
                TextKt.m2842Text4IGK_g("自查「设置 → AI 服务」：接口地址填到 /v1 为止，不要带 /chat/completions；模型名要与服务商提供的列表一致。", (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 0, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1246677208, "C413@14168L10,411@14088L156,416@14253L29,419@14358L10,417@14291L143,422@14443L29,426@14632L10,423@14481L227:Components.kt#vgzelz");
            TextKt.m2842Text4IGK_g("AI 调用失败，这次用的是离线模板", (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer3, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(3)), $composer3, i2);
            Modifier modifier5 = modifier3;
            $composer2 = $composer3;
            reason2 = reason;
            TextKt.m2842Text4IGK_g(reason2, (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, $dirty & 14, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(5)), $composer3, 6);
            TextKt.m2842Text4IGK_g("自查「设置 → AI 服务」：接口地址填到 /v1 为止，不要带 /chat/completions；模型名要与服务商提供的列表一致。", (Modifier) null, scheme.getOnErrorContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.components.ComponentsKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComponentsKt.AiFallbackNotice$lambda$20(reason2, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
