package com.mouthpiece.app.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SettingsScreenKt$SettingsScreen$1$3$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $confirmClearAll$delegate;
    final /* synthetic */ MutableState<Boolean> $confirmClearHistory$delegate;

    SettingsScreenKt$SettingsScreen$1$3$5(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        this.$confirmClearHistory$delegate = mutableState;
        this.$confirmClearAll$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(MutableState $confirmClearHistory$delegate) {
        SettingsScreenKt.SettingsScreen$lambda$4($confirmClearHistory$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(MutableState $confirmClearAll$delegate) {
        SettingsScreenKt.SettingsScreen$lambda$7($confirmClearAll$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x016a  */
    /* JADX WARN: Code duplicated, block: B:29:0x017a  */
    /* JADX WARN: Code duplicated, block: B:32:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x0254  */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    public final void invoke(Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        int i;
        Object objRememberedValue;
        Object objRememberedValue2;
        ComposerKt.sourceInformation($composer, "C270@11564L253,276@11931L10,277@11996L11,274@11834L208:SettingsScreen.kt#987w0c");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1167732248, $changed, -1, "com.mouthpiece.app.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:270)");
        }
        Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
        final MutableState<Boolean> mutableState = this.$confirmClearHistory$delegate;
        final MutableState<Boolean> mutableState2 = this.$confirmClearAll$delegate;
        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        Modifier modifier = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, Alignment.INSTANCE.getTop(), $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i2 = ((((48 << 3) & 112) << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            function0 = constructor;
            $composer.createNode(function0);
        } else {
            function0 = constructor;
            $composer.useNode();
        }
        Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer);
        Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (!composerM3831constructorimpl.getInserting()) {
            i = 48;
            if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = (i2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 24498882, "C271@11663L30,271@11642L69,272@11753L26,272@11732L67:SettingsScreen.kt#987w0c");
            $composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer, "CC(remember):SettingsScreen.kt#9igjgp");
            objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt$SettingsScreen$1$3$5.invoke$lambda$4$lambda$1$lambda$0(mutableState);
                    }
                };
                $composer.updateRememberedValue(objRememberedValue);
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7516getLambda$1733296153$app_debug(), $composer, 805306374, 510);
            $composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer, "CC(remember):SettingsScreen.kt#9igjgp");
            objRememberedValue2 = $composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$5$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt$SettingsScreen$1$3$5.invoke$lambda$4$lambda$3$lambda$2(mutableState2);
                    }
                };
                $composer.updateRememberedValue(obj);
                objRememberedValue2 = obj;
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$1522921808$app_debug(), $composer, 805306374, 510);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.m2842Text4IGK_g("所有数据保存在本机，卸载即彻底删除。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        i = 48;
        composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        int i5 = (i2 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        int i6 = ((i >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 24498882, "C271@11663L30,271@11642L69,272@11753L26,272@11732L67:SettingsScreen.kt#987w0c");
        $composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation($composer, "CC(remember):SettingsScreen.kt#9igjgp");
        objRememberedValue = $composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SettingsScreenKt$SettingsScreen$1$3$5.invoke$lambda$4$lambda$1$lambda$0(mutableState);
                }
            };
            $composer.updateRememberedValue(objRememberedValue);
        }
        $composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.m7516getLambda$1733296153$app_debug(), $composer, 805306374, 510);
        $composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation($composer, "CC(remember):SettingsScreen.kt#9igjgp");
        objRememberedValue2 = $composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object obj2 = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$5$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SettingsScreenKt$SettingsScreen$1$3$5.invoke$lambda$4$lambda$3$lambda$2(mutableState2);
                }
            };
            $composer.updateRememberedValue(obj2);
            objRememberedValue2 = obj2;
        }
        $composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$1522921808$app_debug(), $composer, 805306374, 510);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        TextKt.m2842Text4IGK_g("所有数据保存在本机，卸载即彻底删除。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
