package com.mouthpiece.app.ui.screens;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mouthpiece.app.data.AiGatewayKt;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.QuotaState;
import com.mouthpiece.app.ui.components.ComponentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aç\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0016\u001aE\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\"H\u0003¢\u0006\u0002\u0010#\u001a9\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\f2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010)¨\u0006*²\u0006\n\u0010+\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\bX\u008a\u0084\u0002²\u0006\u0016\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002"}, d2 = {"SettingsScreen", "", "settings", "Lcom/mouthpiece/app/domain/AppSettings;", "quota", "Lcom/mouthpiece/app/domain/QuotaState;", "onBaseUrlChange", "Lkotlin/Function1;", "", "onApiKeyChange", "onModelChange", "onWatermarkChange", "", "onIncognitoChange", "onProChange", "onNotifyChange", "onNotifyHourChange", "", "onPreviewPush", "Lkotlin/Function0;", "onClearHistory", "onClearEverything", "(Lcom/mouthpiece/app/domain/AppSettings;Lcom/mouthpiece/app/domain/QuotaState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DebouncedSettingField", "value", "onCommit", "label", "modifier", "Landroidx/compose/ui/Modifier;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/runtime/Composer;II)V", "SettingCard", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SwitchRow", "title", "subtitle", "checked", "onChange", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_debug", "confirmClearHistory", "confirmClearAll", "draft", "focused", "currentDraft", "currentValue", "commit"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebouncedSettingField$lambda$33(String str, Function1 function1, String str2, Modifier modifier, VisualTransformation visualTransformation, int i, int i2, Composer composer, int i3) {
        DebouncedSettingField(str, function1, str2, modifier, visualTransformation, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingCard$lambda$34(Function2 function2, int i, Composer composer, int i2) {
        SettingCard(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$14(AppSettings appSettings, QuotaState quotaState, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, Function1 function7, Function1 function8, Function0 function0, Function0 function9, Function0 function10, int i, int i2, Composer composer, int i3) {
        SettingsScreen(appSettings, quotaState, function1, function2, function3, function4, function5, function6, function7, function8, function0, function9, function10, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchRow$lambda$37(String str, String str2, boolean z, Function1 function1, int i, Composer composer, int i2) {
        SwitchRow(str, str2, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SettingsScreen(final AppSettings settings, final QuotaState quota, final Function1<? super String, Unit> onBaseUrlChange, final Function1<? super String, Unit> onApiKeyChange, final Function1<? super String, Unit> onModelChange, Function1<? super Boolean, Unit> onWatermarkChange, Function1<? super Boolean, Unit> onIncognitoChange, final Function1<? super Boolean, Unit> onProChange, final Function1<? super Boolean, Unit> onNotifyChange, final Function1<? super Integer, Unit> onNotifyHourChange, final Function0<Unit> onPreviewPush, final Function0<Unit> onClearHistory, final Function0<Unit> onClearEverything, Composer $composer, final int $changed, final int $changed1) {
        int $dirty;
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Composer composer;
        Function0<ComposeUiNode> function1;
        final Function1<? super Boolean, Unit> function2;
        final Function1<? super Boolean, Unit> function3;
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(quota, "quota");
        Intrinsics.checkNotNullParameter(onBaseUrlChange, "onBaseUrlChange");
        Intrinsics.checkNotNullParameter(onApiKeyChange, "onApiKeyChange");
        Intrinsics.checkNotNullParameter(onModelChange, "onModelChange");
        Intrinsics.checkNotNullParameter(onWatermarkChange, "onWatermarkChange");
        Intrinsics.checkNotNullParameter(onIncognitoChange, "onIncognitoChange");
        Intrinsics.checkNotNullParameter(onProChange, "onProChange");
        Intrinsics.checkNotNullParameter(onNotifyChange, "onNotifyChange");
        Intrinsics.checkNotNullParameter(onNotifyHourChange, "onNotifyHourChange");
        Intrinsics.checkNotNullParameter(onPreviewPush, "onPreviewPush");
        Intrinsics.checkNotNullParameter(onClearHistory, "onClearHistory");
        Intrinsics.checkNotNullParameter(onClearEverything, "onClearEverything");
        Composer $composer3 = $composer.startRestartGroup(-609142355);
        ComposerKt.sourceInformation($composer3, "C(SettingsScreen)P(12,11,1!1,5,10,4,9,6,7,8,3)69@2917L7,72@3047L38,70@2954L131,74@3118L34,75@3180L34,77@3220L9902:SettingsScreen.kt#987w0c");
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty = $changed | ($composer3.changed(settings) ? 4 : 2);
        } else {
            $dirty = $changed;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(quota) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onBaseUrlChange) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onApiKeyChange) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(onModelChange) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onWatermarkChange) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onIncognitoChange) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onProChange) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onNotifyChange) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(onNotifyHourChange) ? 536870912 : 268435456;
        }
        int $dirty2 = $dirty;
        int $dirty3 = $changed1 & 6;
        if ($dirty3 == 0) {
            $dirty1 |= $composer3.changedInstance(onPreviewPush) ? 4 : 2;
        }
        if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changedInstance(onClearHistory) ? 32 : 16;
        }
        if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(onClearEverything) ? 256 : 128;
        }
        int $dirty4 = $dirty1;
        if (($dirty2 & 306783379) != 306783378 || ($dirty4 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-609142355, $dirty2, $dirty4, "com.mouthpiece.app.ui.screens.SettingsScreen (SettingsScreen.kt:68)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Context context = (Context) objConsume;
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            $composer3.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z = ($dirty2 & 234881024) == 67108864;
            Object objRememberedValue = $composer3.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsScreenKt.SettingsScreen$lambda$1$lambda$0(onNotifyChange, ((Boolean) obj).booleanValue());
                    }
                };
                $composer3.updateRememberedValue(objRememberedValue);
            }
            $composer3.endReplaceGroup();
            ManagedActivityResultLauncher permissionLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue, $composer3, 0);
            $composer3.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue2 = $composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(objRememberedValue2);
            }
            final MutableState confirmClearHistory$delegate = (MutableState) objRememberedValue2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue3 = $composer3.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
                objRememberedValue3 = objMutableStateOf$default;
            }
            final MutableState confirmClearAll$delegate = (MutableState) objRememberedValue3;
            $composer3.endReplaceGroup();
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((6 << 3) & 112) << 6) & 896) | 6;
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
            $composer2 = $composer3;
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            int i3 = ((6 >> 6) & 112) | 6;
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1329239604, "C78@3272L53,100@3999L21,97@3899L9217:SettingsScreen.kt#987w0c");
            ComponentsKt.AppHeader("设置", "接上你自己的模型，数据留在本地", null, null, $composer2, 54, 12);
            Composer composer2 = $composer2;
            composer2.startReplaceGroup(-42886260);
            ComposerKt.sourceInformation(composer2, "85@3545L31,81@3374L216");
            if (SettingsScreen$lambda$3(confirmClearHistory$delegate)) {
                composer2.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer2, "CC(remember):SettingsScreen.kt#9igjgp");
                Object objRememberedValue4 = composer2.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt.SettingsScreen$lambda$13$lambda$9$lambda$8(confirmClearHistory$delegate);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceGroup();
                ComponentsKt.ConfirmDialog("清空历史？", "将删除本机保存的全部历史记录，且无法恢复。", null, onClearHistory, (Function0) objRememberedValue4, composer2, (($dirty4 << 6) & 7168) | 24630, 4);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-42877477);
            ComposerKt.sourceInformation(composer2, "93@3838L27,89@3644L235");
            if (!SettingsScreen$lambda$6(confirmClearAll$delegate)) {
                composer = composer2;
            } else {
                composer2.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer2, "CC(remember):SettingsScreen.kt#9igjgp");
                Composer composer3 = composer2;
                Object objRememberedValue5 = composer3.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt.SettingsScreen$lambda$13$lambda$11$lambda$10(confirmClearAll$delegate);
                        }
                    };
                    composer3.updateRememberedValue(obj);
                    objRememberedValue5 = obj;
                }
                composer2.endReplaceGroup();
                Composer composer4 = composer2;
                ComponentsKt.ConfirmDialog("清空全部数据？", "将删除历史、说话对象档案与全部设置（含已填写的 API Key），且无法恢复。", null, onClearEverything, (Function0) objRememberedValue5, composer4, (($dirty4 << 3) & 7168) | 24630, 4);
                composer = composer4;
            }
            composer.endReplaceGroup();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(ColumnScope.weight$default(columnScope, Modifier.INSTANCE, 1.0f, false, 2, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                function1 = constructor2;
                composer.createNode(function1);
            } else {
                function1 = constructor2;
                composer.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl(composer);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            Composer composer5 = composer;
            ComposerKt.sourceInformationMarkerStart(composer5, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer5, 1744193437, "C103@4101L51,104@4177L1175,104@4165L1187,133@5424L54,134@5503L2281,134@5491L2293,188@7853L51,189@7929L2504,189@7917L2516,244@10505L54,245@10584L817,245@10572L829,268@11470L51,269@11546L510,269@11534L522,282@12125L51,283@12189L873,304@13076L30:SettingsScreen.kt#987w0c");
            ComponentsKt.SectionLabel("额度", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            SettingCard(ComposableLambdaKt.rememberComposableLambda(-1411080914, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:43:0x027d  */
                /* JADX WARN: Code duplicated, block: B:44:0x0280  */
                /* JADX WARN: Code duplicated, block: B:47:0x02c0  */
                /* JADX WARN: Code duplicated, block: B:48:0x02c9  */
                /* JADX WARN: Code duplicated, block: B:51:0x035b  */
                /* JADX WARN: Code duplicated, block: B:52:0x035e  */
                /* JADX WARN: Code duplicated, block: B:55:0x03b4  */
                /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function4;
                    Function0<ComposeUiNode> function5;
                    Composer composer6;
                    String str;
                    String str2;
                    String str3;
                    ComposerKt.sourceInformation($composer4, "C105@4195L870,123@5082L30,124@5129L209:SettingsScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1411080914, $changed2, -1, "com.mouthpiece.app.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:105)");
                    }
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    QuotaState quotaState = quota;
                    ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier modifier = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier($composer4, modifier);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i7 = ((((384 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function4 = constructor3;
                        $composer4.createNode(function4);
                    } else {
                        function4 = constructor3;
                        $composer4.useNode();
                    }
                    Composer composerM3831constructorimpl3 = Updater.m3831constructorimpl($composer4);
                    Updater.m3838setimpl(composerM3831constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM3831constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3831constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = (i7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i9 = ((384 >> 6) & 112) | 6;
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1706996241, "C106@4269L714,121@5004L43:SettingsScreen.kt#987w0c");
                    Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = $composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier($composer4, modifierWeight$default);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    int i10 = ((((0 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        function5 = constructor4;
                        $composer4.createNode(function5);
                    } else {
                        function5 = constructor4;
                        $composer4.useNode();
                    }
                    Composer composerM3831constructorimpl4 = Updater.m3831constructorimpl($composer4);
                    Updater.m3838setimpl(composerM3831constructorimpl4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3831constructorimpl4.getInserting()) {
                        composer6 = $composer4;
                        if (!Intrinsics.areEqual(composerM3831constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        }
                        Updater.m3838setimpl(composerM3831constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = (i10 >> 6) & 14;
                        Composer composer7 = composer6;
                        ComposerKt.sourceInformationMarkerStart(composer7, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i12 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer7, 1089265436, "C109@4465L10,107@4334L179,117@4834L10,118@4907L11,111@4538L423:SettingsScreen.kt#987w0c");
                        if (quotaState.isPro()) {
                            str = "会员 · 无限次";
                        } else {
                            str = "免费版";
                        }
                        TextKt.m2842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getTitleMedium(), composer7, 0, 0, 65534);
                        if (quotaState.isPro()) {
                            str2 = "已解锁无限生成与无水印分享";
                        } else {
                            str2 = "今日已用 " + quotaState.getUsed() + "/" + quotaState.getLimit() + " 次";
                        }
                        TextKt.m2842Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelSmall(), composer7, 0, 0, 65530);
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        ComposerKt.sourceInformationMarkerEnd(composer7);
                        composer6.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer6);
                        ComposerKt.sourceInformationMarkerEnd(composer6);
                        ComposerKt.sourceInformationMarkerEnd(composer6);
                        if (quotaState.isPro()) {
                            str3 = "PRO";
                        } else {
                            str3 = "FREE";
                        }
                        Composer composer8 = composer6;
                        ComponentsKt.m7504TagPilliJQMabo(str3, 0L, composer8, 0, 2);
                        ComposerKt.sourceInformationMarkerEnd(composer8);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(12)), $composer4, 6);
                        SettingsScreenKt.SwitchRow("模拟会员状态", "接入支付后由订单回调控制，MVP 用开关演示", quota.isPro(), onProChange, $composer4, 54);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    composer6 = $composer4;
                    composerM3831constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3831constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    Updater.m3838setimpl(composerM3831constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i13 = (i10 >> 6) & 14;
                    Composer composer9 = composer6;
                    ComposerKt.sourceInformationMarkerStart(composer9, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    int i14 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer9, 1089265436, "C109@4465L10,107@4334L179,117@4834L10,118@4907L11,111@4538L423:SettingsScreen.kt#987w0c");
                    if (quotaState.isPro()) {
                        str = "会员 · 无限次";
                    } else {
                        str = "免费版";
                    }
                    TextKt.m2842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer9, MaterialTheme.$stable).getTitleMedium(), composer9, 0, 0, 65534);
                    if (quotaState.isPro()) {
                        str2 = "已解锁无限生成与无水印分享";
                    } else {
                        str2 = "今日已用 " + quotaState.getUsed() + "/" + quotaState.getLimit() + " 次";
                    }
                    TextKt.m2842Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer9, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer9, MaterialTheme.$stable).getLabelSmall(), composer9, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    if (quotaState.isPro()) {
                        str3 = "PRO";
                    } else {
                        str3 = "FREE";
                    }
                    Composer composer10 = composer6;
                    ComponentsKt.m7504TagPilliJQMabo(str3, 0L, composer10, 0, 2);
                    ComposerKt.sourceInformationMarkerEnd(composer10);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(12)), $composer4, 6);
                    SettingsScreenKt.SwitchRow("模拟会员状态", "接入支付后由订单回调控制，MVP 用开关演示", quota.isPro(), onProChange, $composer4, 54);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer5, 54), composer5, 6);
            ComponentsKt.SectionLabel("AI 服务", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            SettingCard(ComposableLambdaKt.rememberComposableLambda(-1319787227, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C137@5631L236,143@5884L30,144@5931L301,151@6249L30,152@6296L220,158@6533L29,165@6839L10,166@6904L11,159@6579L371,171@7088L30,174@7265L10,175@7330L11,172@7135L241,178@7475L29,181@7644L10,182@7713L11,179@7525L227:SettingsScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1319787227, $changed2, -1, "com.mouthpiece.app.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:137)");
                    }
                    SettingsScreenKt.DebouncedSettingField(settings.getBaseUrl(), onBaseUrlChange, "接口地址（OpenAI 兼容）", SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, $composer4, 3456, 16);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(10)), $composer4, 6);
                    SettingsScreenKt.DebouncedSettingField(settings.getApiKey(), onApiKeyChange, "API Key", SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), new PasswordVisualTransformation((char) 0, 1, null), $composer4, 3456, 0);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(10)), $composer4, 6);
                    SettingsScreenKt.DebouncedSettingField(settings.getModel(), onModelChange, "模型名", SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, $composer4, 3456, 16);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer4, 6);
                    TextKt.m2842Text4IGK_g(settings.getAiReady() ? "已配置。若请求失败会自动回退到内置离线模板，不会中断使用。" : "未配置时全部走内置离线模板，功能可用但不够贴合语境。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 0, 0, 65530);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(10)), $composer4, 6);
                    TextKt.m2842Text4IGK_g("实际请求地址：" + AiGatewayKt.chatCompletionsEndpoint(settings.getBaseUrl()), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 0, 0, 65530);
                    if (StringsKt.isBlank(settings.getBaseUrl()) || StringsKt.isBlank(settings.getModel())) {
                        SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer4, 6);
                        TextKt.m2842Text4IGK_g("接口地址与模型名都不能为空，否则请求会失败并直接回退到离线模板。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getError(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 6, 0, 65530);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer5, 54), composer5, 6);
            ComponentsKt.SectionLabel("提醒", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            SettingCard(ComposableLambdaKt.rememberComposableLambda(-1269102234, true, new SettingsScreenKt$SettingsScreen$1$3$3(settings, onNotifyChange, context, permissionLauncher, onPreviewPush, onNotifyHourChange), composer5, 54), composer5, 6);
            ComponentsKt.SectionLabel("隐私与分享", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            function2 = onWatermarkChange;
            function3 = onIncognitoChange;
            SettingCard(ComposableLambdaKt.rememberComposableLambda(-1218417241, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                    invoke(composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C246@10602L216,252@10835L30,253@10882L210,259@11109L29,262@11276L10,263@11341L11,260@11155L232:SettingsScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1218417241, $changed2, -1, "com.mouthpiece.app.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:246)");
                    }
                    SettingsScreenKt.SwitchRow("分享卡片带水印", "关闭后分享图更干净（会员权益）", settings.getWatermark(), function2, $composer4, 54);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(12)), $composer4, 6);
                    SettingsScreenKt.SwitchRow("无痕模式", "开启后不写入任何本地历史", settings.getIncognito(), function3, $composer4, 54);
                    SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer4, 6);
                    TextKt.m2842Text4IGK_g("嘴替不会读取你的通讯录、短信或相册；只有你主动粘贴的文本会被发送给所配置的模型服务。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getLabelSmall(), $composer4, 6, 0, 65530);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer5, 54), composer5, 6);
            ComponentsKt.SectionLabel("数据", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            SettingCard(ComposableLambdaKt.rememberComposableLambda(-1167732248, true, new SettingsScreenKt$SettingsScreen$1$3$5(confirmClearHistory$delegate, confirmClearAll$delegate), composer5, 54), composer5, 6);
            ComponentsKt.SectionLabel("关于", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), composer5, 54, 0);
            SettingCard(ComposableSingletons$SettingsScreenKt.INSTANCE.m7515getLambda$1117047255$app_debug(), composer5, 6);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(36)), composer5, 6);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
            $composer3.skipToGroupEnd();
            function2 = onWatermarkChange;
            $composer2 = $composer3;
            function3 = onIncognitoChange;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super Boolean, Unit> function4 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SettingsScreenKt.SettingsScreen$lambda$14(settings, quota, onBaseUrlChange, onApiKeyChange, onModelChange, function2, function4, onProChange, onNotifyChange, onNotifyHourChange, onPreviewPush, onClearHistory, onClearEverything, $changed, $changed1, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$1$lambda$0(Function1 $onNotifyChange, boolean granted) {
        $onNotifyChange.invoke(Boolean.valueOf(granted));
        return Unit.INSTANCE;
    }

    private static final boolean SettingsScreen$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SettingsScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsScreen$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$13$lambda$9$lambda$8(MutableState $confirmClearHistory$delegate) {
        SettingsScreen$lambda$4($confirmClearHistory$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsScreen$lambda$13$lambda$11$lambda$10(MutableState $confirmClearAll$delegate) {
        SettingsScreen$lambda$7($confirmClearAll$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DebouncedSettingField(final String value, final Function1<? super String, Unit> function1, final String label, Modifier modifier, VisualTransformation visualTransformation, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        VisualTransformation visualTransformation2;
        Composer $composer2;
        final Modifier modifier3;
        final VisualTransformation visualTransformation3;
        Composer $composer3 = $composer.startRestartGroup(1296163733);
        ComposerKt.sourceInformation($composer3, "C(DebouncedSettingField)P(3,2)327@13631L34,328@13685L34,332@13821L27,333@13873L27,334@13919L30,342@14189L61,342@14167L83,347@14294L100,347@14272L122,354@14466L104,354@14443L127,363@14701L207,362@14642L14,369@14926L15,360@14576L494:SettingsScreen.kt#987w0c");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(value) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(label) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            visualTransformation2 = visualTransformation;
        } else if (($changed & 24576) == 0) {
            visualTransformation2 = visualTransformation;
            $dirty |= $composer3.changed(visualTransformation2) ? 16384 : 8192;
        } else {
            visualTransformation2 = visualTransformation;
        }
        if (($dirty & 9363) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier3 = modifier2;
            visualTransformation3 = visualTransformation2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            VisualTransformation visualTransformation4 = i3 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1296163733, $dirty, -1, "com.mouthpiece.app.ui.screens.DebouncedSettingField (SettingsScreen.kt:326)");
            }
            $composer3.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue = $composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(value, null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default);
                objRememberedValue = objMutableStateOf$default;
            }
            final MutableState draft$delegate = (MutableState) objRememberedValue;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue2 = $composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Object objMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(objMutableStateOf$default2);
                objRememberedValue2 = objMutableStateOf$default2;
            }
            final MutableState focused$delegate = (MutableState) objRememberedValue2;
            $composer3.endReplaceGroup();
            final State currentDraft$delegate = SnapshotStateKt.rememberUpdatedState(DebouncedSettingField$lambda$16(draft$delegate), $composer3, 0);
            final State currentValue$delegate = SnapshotStateKt.rememberUpdatedState(value, $composer3, $dirty & 14);
            final State commit$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer3, ($dirty >> 3) & 14);
            $composer3.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z = ($dirty & 14) == 4;
            Object objRememberedValue3 = $composer3.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = (Function2) new SettingsScreenKt$DebouncedSettingField$1$1(value, focused$delegate, draft$delegate, null);
                $composer3.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(value, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, $composer3, $dirty & 14);
            String strDebouncedSettingField$lambda$16 = DebouncedSettingField$lambda$16(draft$delegate);
            $composer3.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z2 = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            SettingsScreenKt$DebouncedSettingField$2$1 settingsScreenKt$DebouncedSettingField$2$1RememberedValue = $composer3.rememberedValue();
            if (z2 || settingsScreenKt$DebouncedSettingField$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                settingsScreenKt$DebouncedSettingField$2$1RememberedValue = new SettingsScreenKt$DebouncedSettingField$2$1(value, function1, draft$delegate, null);
                $composer3.updateRememberedValue(settingsScreenKt$DebouncedSettingField$2$1RememberedValue);
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(strDebouncedSettingField$lambda$16, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) settingsScreenKt$DebouncedSettingField$2$1RememberedValue, $composer3, 0);
            Unit unit = Unit.INSTANCE;
            $composer3.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean zChanged = $composer3.changed(currentDraft$delegate) | $composer3.changed(currentValue$delegate) | $composer3.changed(commit$delegate);
            Object objRememberedValue4 = $composer3.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Object obj2 = new Function1() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SettingsScreenKt.DebouncedSettingField$lambda$28$lambda$27(currentDraft$delegate, currentValue$delegate, commit$delegate, (DisposableEffectScope) obj3);
                    }
                };
                $composer3.updateRememberedValue(obj2);
                objRememberedValue4 = obj2;
            }
            $composer3.endReplaceGroup();
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue4, $composer3, 6);
            String strDebouncedSettingField$lambda$17 = DebouncedSettingField$lambda$16(draft$delegate);
            $composer3.startReplaceGroup(-1224400529);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            boolean z3 = (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object objRememberedValue5 = $composer3.rememberedValue();
            if (z3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Object obj3 = new Function1() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return SettingsScreenKt.DebouncedSettingField$lambda$30$lambda$29(value, function1, focused$delegate, draft$delegate, (FocusState) obj4);
                    }
                };
                $composer3.updateRememberedValue(obj3);
                objRememberedValue5 = obj3;
            }
            $composer3.endReplaceGroup();
            Modifier modifier5 = FocusChangedModifierKt.onFocusChanged(modifier4, (Function1) objRememberedValue5);
            RoundedCornerShape roundedCornerShapeM1030RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(16));
            $composer3.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer3, "CC(remember):SettingsScreen.kt#9igjgp");
            Object objRememberedValue6 = $composer3.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                Object obj4 = new Function1() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return SettingsScreenKt.DebouncedSettingField$lambda$32$lambda$31(draft$delegate, (String) obj5);
                    }
                };
                $composer3.updateRememberedValue(obj4);
                objRememberedValue6 = obj4;
            }
            $composer3.endReplaceGroup();
            Modifier modifier6 = modifier4;
            $composer2 = $composer3;
            OutlinedTextFieldKt.OutlinedTextField(strDebouncedSettingField$lambda$17, (Function1<? super String, Unit>) objRememberedValue6, modifier5, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-319085393, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt.DebouncedSettingField.6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C369@14928L11:SettingsScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-319085393, $changed2, -1, "com.mouthpiece.app.ui.screens.DebouncedSettingField.<anonymous> (SettingsScreen.kt:369)");
                    }
                    TextKt.m2842Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, visualTransformation4, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1030RoundedCornerShape0680j_4, (TextFieldColors) null, $composer2, 1572912, ($dirty & 57344) | 12582912, 0, 6143928);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            visualTransformation3 = visualTransformation4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    return SettingsScreenKt.DebouncedSettingField$lambda$33(value, function1, label, modifier3, visualTransformation3, $changed, i, (Composer) obj5, ((Integer) obj6).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DebouncedSettingField$lambda$16(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DebouncedSettingField$lambda$19(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DebouncedSettingField$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DebouncedSettingField$lambda$21(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String DebouncedSettingField$lambda$22(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<String, Unit> DebouncedSettingField$lambda$23(State<? extends Function1<? super String, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult DebouncedSettingField$lambda$28$lambda$27(final State $currentDraft$delegate, final State $currentValue$delegate, final State $commit$delegate, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$DebouncedSettingField$lambda$28$lambda$27$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                if (!Intrinsics.areEqual(SettingsScreenKt.DebouncedSettingField$lambda$21($currentDraft$delegate), SettingsScreenKt.DebouncedSettingField$lambda$22($currentValue$delegate))) {
                    SettingsScreenKt.DebouncedSettingField$lambda$23($commit$delegate).invoke(SettingsScreenKt.DebouncedSettingField$lambda$21($currentDraft$delegate));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebouncedSettingField$lambda$32$lambda$31(MutableState $draft$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $draft$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DebouncedSettingField$lambda$30$lambda$29(String $value, Function1 $onCommit, MutableState $focused$delegate, MutableState $draft$delegate, FocusState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean wasFocused = DebouncedSettingField$lambda$19($focused$delegate);
        DebouncedSettingField$lambda$20($focused$delegate, state.isFocused());
        if (wasFocused && !DebouncedSettingField$lambda$19($focused$delegate) && !Intrinsics.areEqual(DebouncedSettingField$lambda$16($draft$delegate), $value)) {
            $onCommit.invoke(DebouncedSettingField$lambda$16($draft$delegate));
        }
        return Unit.INSTANCE;
    }

    private static final void SettingCard(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(642049802);
        ComposerKt.sourceInformation($composer3, "C(SettingCard)383@15384L11,383@15334L70,384@15411L72,378@15149L334:SettingsScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(642049802, $dirty2, -1, "com.mouthpiece.app.ui.screens.SettingCard (SettingsScreen.kt:377)");
            }
            $composer2 = $composer3;
            CardKt.ElevatedCard(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(20)), CardDefaults.INSTANCE.m1980elevatedCardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, ComposableLambdaKt.rememberComposableLambda(447750725, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt.SettingCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope ElevatedCard, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
                    ComposerKt.sourceInformation($composer4, "C385@15421L56:SettingsScreen.kt#987w0c");
                    if (($changed2 & 17) == 16 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(447750725, $changed2, -1, "com.mouthpiece.app.ui.screens.SettingCard.<anonymous> (SettingsScreen.kt:385)");
                    }
                    Modifier modifierM736padding3ABfNKs = PaddingKt.m736padding3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(18));
                    Function2<Composer, Integer, Unit> function3 = function2;
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
                    int i2 = (i >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i3 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -281500481, "C385@15466L9:SettingsScreen.kt#987w0c");
                    function3.invoke($composer4, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SettingCard$lambda$34(function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchRow(final String title, final String subtitle, final boolean checked, final Function1<? super Boolean, Unit> function1, Composer $composer, final int $changed) {
        String str;
        Function1<? super Boolean, Unit> function2;
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function3;
        Composer $composer2 = $composer.startRestartGroup(-732749990);
        ComposerKt.sourceInformation($composer2, "C(SwitchRow)P(3,2)396@15625L448:SettingsScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            str = title;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = title;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(subtitle) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(checked) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            function2 = function1;
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if (($dirty & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-732749990, $dirty, -1, "com.mouthpiece.app.ui.screens.SwitchRow (SettingsScreen.kt:395)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((384 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer2);
            int $dirty2 = $dirty;
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            int i3 = ((384 >> 6) & 112) | 6;
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1408918199, "C397@15687L318,405@16014L53:SettingsScreen.kt#987w0c");
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function3 = constructor2;
                $composer2.createNode(function3);
            } else {
                function3 = constructor2;
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = (i4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1085917296, "C398@15781L10,398@15740L62,401@15892L10,402@15953L11,399@15815L180:SettingsScreen.kt#987w0c");
            TextKt.m2842Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodyLarge(), $composer2, $dirty2 & 14, 0, 65534);
            TextKt.m2842Text4IGK_g(subtitle, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getLabelSmall(), $composer2, ($dirty2 >> 3) & 14, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SwitchKt.Switch(checked, function2, null, null, false, null, null, $composer2, (($dirty2 >> 6) & 14) | (($dirty2 >> 6) & 112), 124);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsScreenKt.SwitchRow$lambda$37(title, subtitle, checked, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
