package com.mouthpiece.app.ui.screens;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.mouthpiece.app.domain.Persona;
import com.mouthpiece.app.domain.Scene;
import com.mouthpiece.app.domain.StyleCatalog;
import com.mouthpiece.app.domain.StylePreset;
import com.mouthpiece.app.ui.components.ComponentsKt;
import com.mouthpiece.app.vm.MainUiState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a«\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001au\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\nH\u0003¢\u0006\u0002\u0010\u001b\u001a;\u0010\u001c\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\nH\u0003¢\u0006\u0002\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nH\u0003¢\u0006\u0002\u0010!\u001a\u0016\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"strengthLabels", "", "", "HomeScreen", "", "state", "Lcom/mouthpiece/app/vm/MainUiState;", "personas", "Lcom/mouthpiece/app/domain/Persona;", "onIncomingChange", "Lkotlin/Function1;", "onSceneChange", "Lcom/mouthpiece/app/domain/Scene;", "onToggleStyle", "onStrengthChange", "", "onExtraHintChange", "onPersonaChange", "onGenerate", "Lkotlin/Function0;", "(Lcom/mouthpiece/app/vm/MainUiState;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StylePickerSection", "scene", "styles", "Lcom/mouthpiece/app/domain/StylePreset;", "selectedIds", "strength", "(Lcom/mouthpiece/app/domain/Scene;Ljava/util/List;Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PersonaSection", "selectedId", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "StyleGrid", "onToggle", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "readClipboard", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HomeScreenKt {
    private static final List<String> strengthLabels = CollectionsKt.listOf((Object[]) new String[]{"很含蓄", "偏含蓄", "刚刚好", "偏直接", "很直接"});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$2(MainUiState mainUiState, List list, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, Function0 function0, int i, Composer composer, int i2) {
        HomeScreen(mainUiState, list, function1, function2, function3, function4, function5, function6, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSection$lambda$18(List list, String str, Function1 function1, int i, Composer composer, int i2) {
        PersonaSection(list, str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyleGrid$lambda$25(List list, List list2, Function1 function1, int i, Composer composer, int i2) {
        StyleGrid(list, list2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StylePickerSection$lambda$11(Scene scene, List list, List list2, int i, Function1 function1, Function1 function2, Function1 function3, int i2, Composer composer, int i3) {
        StylePickerSection(scene, list, list2, i, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0306  */
    /* JADX WARN: Code duplicated, block: B:108:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:111:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:112:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:122:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:124:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:125:0x0504  */
    /* JADX WARN: Code duplicated, block: B:132:0x054e  */
    /* JADX WARN: Code duplicated, block: B:135:0x0744  */
    public static final void HomeScreen(final MainUiState state, final List<Persona> personas, final Function1<? super String, Unit> onIncomingChange, final Function1<? super Scene, Unit> onSceneChange, final Function1<? super String, Unit> onToggleStyle, final Function1<? super Integer, Unit> onStrengthChange, final Function1<? super String, Unit> onExtraHintChange, final Function1<? super String, Unit> onPersonaChange, final Function0<Unit> onGenerate, Composer $composer, final int $changed) {
        final String inputHintText;
        Function0<ComposeUiNode> function0;
        MeasurePolicy measurePolicy;
        Composer $composer2;
        Composer composer;
        Modifier modifier;
        boolean z;
        boolean z2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function1;
        Composer composerM3831constructorimpl;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(personas, "personas");
        Intrinsics.checkNotNullParameter(onIncomingChange, "onIncomingChange");
        Intrinsics.checkNotNullParameter(onSceneChange, "onSceneChange");
        Intrinsics.checkNotNullParameter(onToggleStyle, "onToggleStyle");
        Intrinsics.checkNotNullParameter(onStrengthChange, "onStrengthChange");
        Intrinsics.checkNotNullParameter(onExtraHintChange, "onExtraHintChange");
        Intrinsics.checkNotNullParameter(onPersonaChange, "onPersonaChange");
        Intrinsics.checkNotNullParameter(onGenerate, "onGenerate");
        Composer $composer3 = $composer.startRestartGroup(326420904);
        ComposerKt.sourceInformation($composer3, "C(HomeScreen)P(8,7,2,4,6,5!1,3)69@2757L7,70@2781L24,91@3424L21,88@3332L4033:HomeScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(personas) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onIncomingChange) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onSceneChange) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(onToggleStyle) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onStrengthChange) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onExtraHintChange) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onPersonaChange) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onGenerate) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((38347923 & $dirty) == 38347922 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(326420904, $dirty, -1, "com.mouthpiece.app.ui.screens.HomeScreen (HomeScreen.kt:68)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = $composer3.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, -954203484, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = $composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope scope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (state.getInputTruncated()) {
                inputHintText = "内容过长，已截断到 6000 字；建议精简到 600 字以内效果更好";
            } else {
                inputHintText = state.getInputOverLimit() ? "已超出 600 字上限，请精简到 600 字以内再生成" : null;
            }
            $composer3.startReplaceGroup(157903460);
            ComposerKt.sourceInformation($composer3, "83@3271L23");
            Function2 inputHint = inputHintText != null ? ComposableLambdaKt.rememberComposableLambda(1460444988, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$HomeScreen$inputHint$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C83@3273L19:HomeScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1460444988, $changed2, -1, "com.mouthpiece.app.ui.screens.HomeScreen.<anonymous> (HomeScreen.kt:83)");
                    }
                    TextKt.m2842Text4IGK_g(inputHintText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54) : null;
            $composer3.endReplaceGroup();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer3, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierVerticalScroll$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((0 << 3) & 112) << 6) & 896) | 6;
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
                measurePolicy = measurePolicyColumnMeasurePolicy;
                $composer2 = $composer3;
            } else {
                measurePolicy = measurePolicyColumnMeasurePolicy;
                $composer2 = $composer3;
                if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = (i >> 6) & 14;
                composer = $composer2;
                ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, -456106195, "C96@3569L28,93@3463L144,136@5171L507,122@4536L1152,152@5698L395,170@6412L341,180@6763L146,186@6919L30,187@6958L362,198@7329L30:HomeScreen.kt#987w0c");
                ComponentsKt.AppHeader("嘴替", "粘贴对方的话，挑几个风格，3 秒出回复", null, ComposableLambdaKt.rememberComposableLambda(983870494, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$HomeScreen$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C96@3571L24:HomeScreen.kt#987w0c");
                        if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(983870494, $changed2, -1, "com.mouthpiece.app.ui.screens.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:96)");
                        }
                        ComponentsKt.m7504TagPilliJQMabo(state.getQuotaText(), 0L, $composer4, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 3126, 4);
                if (state.getAiReady()) {
                    modifier = modifierMaterializeModifier;
                    if (state.getAiError() != null) {
                        composer.startReplaceGroup(-455379091);
                        ComposerKt.sourceInformation(composer, "116@4381L135");
                        z = false;
                        ComponentsKt.AiFallbackNotice(state.getAiError(), PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), composer, 48, 0);
                        composer.endReplaceGroup();
                    } else {
                        z = false;
                        composer.startReplaceGroup(-455172476);
                        composer.endReplaceGroup();
                    }
                } else {
                    composer.startReplaceGroup(-456034493);
                    ComposerKt.sourceInformation(composer, "105@3876L11,100@3651L617");
                    modifier = modifierMaterializeModifier;
                    Modifier modifierM737paddingVpY3zN4 = PaddingKt.m737paddingVpY3zN4(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(14))), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondaryContainer(), null, 2, null), Dp.m7016constructorimpl(14), Dp.m7016constructorimpl(10));
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM737paddingVpY3zN4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        function1 = constructor;
                        composer.createNode(function1);
                    } else {
                        function1 = constructor;
                        composer.useNode();
                    }
                    composerM3831constructorimpl = Updater.m3831constructorimpl(composer);
                    Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i5 = (i4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i6 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer, 722109325, "C110@4139L10,111@4204L11,108@4007L247:HomeScreen.kt#987w0c");
                    TextKt.m2842Text4IGK_g("还没配置 API Key，当前使用内置离线模板。到「设置」填入任意 OpenAI 兼容服务即可启用 AI。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondaryContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 6, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                    z = false;
                }
                String incoming = state.getIncoming();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m737paddingVpY3zN4(Modifier.INSTANCE, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(16)), 0.0f, 1, null);
                RoundedCornerShape roundedCornerShapeM1030RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18));
                if (!state.getInputOverLimit() || state.getInputTruncated()) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                int $dirty2 = $dirty;
                OutlinedTextFieldKt.OutlinedTextField(incoming, onIncomingChange, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.m7507getLambda$106895304$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.m7509getLambda$224532073$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-459805611, true, new HomeScreenKt$HomeScreen$1$3(scope, context, onIncomingChange), composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) inputHint, z2, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6637getDefaulteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), (KeyboardActions) null, false, 8, 4, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1030RoundedCornerShape0680j_4, (TextFieldColors) null, composer, (($dirty >> 3) & 112) | 819462528, 906166272, 0, 5459256);
                OutlinedTextFieldKt.OutlinedTextField(state.getExtraHint(), onExtraHintChange, SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1631887279$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$252101966$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), (TextFieldColors) null, composer, (($dirty2 >> 15) & 112) | 14156160, 12582912, 0, 6160184);
                StylePickerSection(state.getScene(), StyleCatalog.INSTANCE.ofScene(state.getScene()), state.getSelectedStyleIds(), state.getStrength(), onSceneChange, onToggleStyle, onStrengthChange, composer, (($dirty2 << 3) & 57344) | (($dirty2 << 3) & 458752) | (($dirty2 << 3) & 3670016));
                PersonaSection(personas, state.getPersonaId(), onPersonaChange, composer, (($dirty2 >> 3) & 14) | (($dirty2 >> 15) & 896));
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(28)), composer, 6);
                ButtonKt.Button(onGenerate, SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), Dp.m7016constructorimpl(56)), state.getCanGenerate(), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.m7508getLambda$1584238962$app_debug(), composer, (($dirty2 >> 24) & 14) | 805306416, 496);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(32)), composer, 6);
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
            composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = (i >> 6) & 14;
            composer = $composer2;
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer, -456106195, "C96@3569L28,93@3463L144,136@5171L507,122@4536L1152,152@5698L395,170@6412L341,180@6763L146,186@6919L30,187@6958L362,198@7329L30:HomeScreen.kt#987w0c");
            ComponentsKt.AppHeader("嘴替", "粘贴对方的话，挑几个风格，3 秒出回复", null, ComposableLambdaKt.rememberComposableLambda(983870494, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$HomeScreen$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C96@3571L24:HomeScreen.kt#987w0c");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(983870494, $changed2, -1, "com.mouthpiece.app.ui.screens.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:96)");
                    }
                    ComponentsKt.m7504TagPilliJQMabo(state.getQuotaText(), 0L, $composer4, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 3126, 4);
            if (state.getAiReady()) {
                composer.startReplaceGroup(-456034493);
                ComposerKt.sourceInformation(composer, "105@3876L11,100@3651L617");
                modifier = modifierMaterializeModifier;
                Modifier modifierM737paddingVpY3zN5 = PaddingKt.m737paddingVpY3zN4(BackgroundKt.m245backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(14))), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSecondaryContainer(), null, 2, null), Dp.m7016constructorimpl(14), Dp.m7016constructorimpl(10));
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM737paddingVpY3zN5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i9 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    function1 = constructor;
                    composer.createNode(function1);
                } else {
                    function1 = constructor;
                    composer.useNode();
                }
                composerM3831constructorimpl = Updater.m3831constructorimpl(composer);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3831constructorimpl.getInserting()) {
                }
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = (i9 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer, 722109325, "C110@4139L10,111@4204L11,108@4007L247:HomeScreen.kt#987w0c");
                TextKt.m2842Text4IGK_g("还没配置 API Key，当前使用内置离线模板。到「设置」填入任意 OpenAI 兼容服务即可启用 AI。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSecondaryContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 6, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                z = false;
            } else {
                modifier = modifierMaterializeModifier;
                if (state.getAiError() != null) {
                    composer.startReplaceGroup(-455379091);
                    ComposerKt.sourceInformation(composer, "116@4381L135");
                    z = false;
                    ComponentsKt.AiFallbackNotice(state.getAiError(), PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), composer, 48, 0);
                    composer.endReplaceGroup();
                } else {
                    z = false;
                    composer.startReplaceGroup(-455172476);
                    composer.endReplaceGroup();
                }
            }
            String incoming2 = state.getIncoming();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m737paddingVpY3zN4(Modifier.INSTANCE, Dp.m7016constructorimpl(20), Dp.m7016constructorimpl(16)), 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM1030RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18));
            if (state.getInputOverLimit()) {
                z2 = true;
            } else {
                z2 = true;
            }
            int $dirty3 = $dirty;
            OutlinedTextFieldKt.OutlinedTextField(incoming2, onIncomingChange, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.m7507getLambda$106895304$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.m7509getLambda$224532073$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-459805611, true, new HomeScreenKt$HomeScreen$1$3(scope, context, onIncomingChange), composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) inputHint, z2, (VisualTransformation) null, new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6637getDefaulteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null), (KeyboardActions) null, false, 8, 4, (MutableInteractionSource) null, (Shape) roundedCornerShapeM1030RoundedCornerShape0680j_5, (TextFieldColors) null, composer, (($dirty >> 3) & 112) | 819462528, 906166272, 0, 5459256);
            OutlinedTextFieldKt.OutlinedTextField(state.getExtraHint(), onExtraHintChange, SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$1631887279$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$252101966$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), (TextFieldColors) null, composer, (($dirty3 >> 15) & 112) | 14156160, 12582912, 0, 6160184);
            StylePickerSection(state.getScene(), StyleCatalog.INSTANCE.ofScene(state.getScene()), state.getSelectedStyleIds(), state.getStrength(), onSceneChange, onToggleStyle, onStrengthChange, composer, (($dirty3 << 3) & 57344) | (($dirty3 << 3) & 458752) | (($dirty3 << 3) & 3670016));
            PersonaSection(personas, state.getPersonaId(), onPersonaChange, composer, (($dirty3 >> 3) & 14) | (($dirty3 >> 15) & 896));
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(28)), composer, 6);
            ButtonKt.Button(onGenerate, SizeKt.m769height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null), 0.0f, 1, null), Dp.m7016constructorimpl(56)), state.getCanGenerate(), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(18)), null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.m7508getLambda$1584238962$app_debug(), composer, (($dirty3 >> 24) & 14) | 805306416, 496);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(32)), composer, 6);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.HomeScreen$lambda$2(state, personas, onIncomingChange, onSceneChange, onToggleStyle, onStrengthChange, onExtraHintChange, onPersonaChange, onGenerate, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0541  */
    /* JADX WARN: Code duplicated, block: B:127:0x054d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0553  */
    /* JADX WARN: Code duplicated, block: B:131:0x0584  */
    /* JADX WARN: Code duplicated, block: B:134:0x0597  */
    /* JADX WARN: Code duplicated, block: B:135:0x059a  */
    /* JADX WARN: Code duplicated, block: B:139:0x06bc  */
    private static final void StylePickerSection(final Scene scene, final List<StylePreset> list, final List<String> list2, final int strength, final Function1<? super Scene, Unit> function1, final Function1<? super String, Unit> function2, final Function1<? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Function0<ComposeUiNode> function4;
        Composer composer;
        Composer composer2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function5;
        Composer composerM3831constructorimpl;
        Composer composer3;
        String str;
        Scene scene2 = scene;
        Composer $composer2 = $composer.startRestartGroup(1808135611);
        ComposerKt.sourceInformation($composer2, "C(StylePickerSection)P(3,6,4,5!1,2)219@7785L51,222@7904L21,220@7841L419,235@8266L63,236@8334L79,238@8419L53,239@8477L978:HomeScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(scene2.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(list2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(strength) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((599187 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808135611, $dirty, -1, "com.mouthpiece.app.ui.screens.StylePickerSection (HomeScreen.kt:218)");
            }
            ComponentsKt.SectionLabel("场景", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), $composer2, 54, 0);
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, null, false, 14, null), Dp.m7016constructorimpl(20), 0.0f, 2, null);
            Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
            String str2 = "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, Alignment.INSTANCE.getTop(), $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $dirty2 = $dirty;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer2, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((48 << 3) & 112) << 6) & 896) | 6;
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
            if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            int i3 = 0;
            ComposerKt.sourceInformationMarkerStart($composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2131308282, "C:HomeScreen.kt#987w0c");
            $composer2.startReplaceGroup(1177130971);
            ComposerKt.sourceInformation($composer2, "*230@8206L24,227@8089L155");
            Iterable<Scene> entries = Scene.getEntries();
            int i5 = 0;
            for (final Scene scene3 : entries) {
                Iterable iterable = entries;
                int i6 = i3;
                String label = scene3.getLabel();
                boolean z = scene3 == scene2;
                Modifier modifier = modifierMaterializeModifier;
                $composer2.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation($composer2, "CC(remember):HomeScreen.kt#9igjgp");
                int i7 = i5;
                boolean zChanged = (($dirty2 & 57344) == 16384) | $composer2.changed(scene3.ordinal());
                Object objRememberedValue = $composer2.rememberedValue();
                if (!zChanged) {
                    str = str2;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    $composer2.endReplaceGroup();
                    ComponentsKt.PillToggle(label, z, (Function0) objRememberedValue, $composer2, 0);
                    scene2 = scene;
                    entries = iterable;
                    i3 = i6;
                    modifierMaterializeModifier = modifier;
                    i5 = i7;
                    str2 = str;
                } else {
                    str = str2;
                }
                objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.StylePickerSection$lambda$6$lambda$5$lambda$4$lambda$3(function1, scene3);
                    }
                };
                $composer2.updateRememberedValue(objRememberedValue);
                $composer2.endReplaceGroup();
                ComponentsKt.PillToggle(label, z, (Function0) objRememberedValue, $composer2, 0);
                scene2 = scene;
                entries = iterable;
                i3 = i6;
                modifierMaterializeModifier = modifier;
                i5 = i7;
                str2 = str;
            }
            String str3 = str2;
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComponentsKt.SectionLabel("风格（最多 5 个横向对比）", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), $composer2, 54, 0);
            StyleGrid(list, list2, function2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 9) & 896));
            ComponentsKt.SectionLabel("表达强度", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), $composer2, 54, 0);
            Modifier modifierM738paddingVpY3zN4$default2 = PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = $composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer2, modifierM738paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int i8 = ((((6 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function4 = constructor3;
                $composer2.createNode(function4);
            } else {
                function4 = constructor3;
                $composer2.useNode();
            }
            Composer composerM3831constructorimpl3 = Updater.m3831constructorimpl($composer2);
            Updater.m3838setimpl(composerM3831constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl3, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3831constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3831constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash2);
            }
            Updater.m3838setimpl(composerM3831constructorimpl3, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            int i9 = (i8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i10 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1466773844, "C242@8619L37,240@8543L179,246@8731L718:HomeScreen.kt#987w0c");
            float f = strength;
            $composer2.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer2, "CC(remember):HomeScreen.kt#9igjgp");
            boolean z2 = ($dirty2 & 3670016) == 1048576;
            Object objRememberedValue2 = $composer2.rememberedValue();
            if (!z2) {
                composer = $composer2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                composer.endReplaceGroup();
                SliderKt.Slider(f, (Function1) objRememberedValue2, null, false, RangesKt.rangeTo(1.0f, 5.0f), 3, null, null, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 460);
                composer2 = composer;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str3);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int i11 = ((((54 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function5 = constructor;
                    composer2.createNode(function5);
                } else {
                    function5 = constructor;
                    composer2.useNode();
                }
                composerM3831constructorimpl = Updater.m3831constructorimpl(composer2);
                Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM3831constructorimpl.getInserting()) {
                    composer3 = composer2;
                } else {
                    composer3 = composer2;
                    if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    int i12 = (i11 >> 6) & 14;
                    Composer composer4 = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    int i13 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart(composer4, 2079814822, "C249@8926L10,250@8987L11,247@8835L194,254@9139L10,255@9200L11,252@9042L191,259@9336L10,260@9397L11,257@9246L193:HomeScreen.kt#987w0c");
                    TextKt.m2842Text4IGK_g((String) CollectionsKt.first((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall(), composer4, 0, 0, 65530);
                    TextKt.m2842Text4IGK_g(strengthLabels.get(strength - 1), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall(), composer4, 0, 0, 65530);
                    TextKt.m2842Text4IGK_g((String) CollectionsKt.last((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer4, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer4, MaterialTheme.$stable).getLabelSmall(), composer4, 0, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                int i14 = (i11 >> 6) & 14;
                Composer composer5 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer5, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                int i15 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer5, 2079814822, "C249@8926L10,250@8987L11,247@8835L194,254@9139L10,255@9200L11,252@9042L191,259@9336L10,260@9397L11,257@9246L193:HomeScreen.kt#987w0c");
                TextKt.m2842Text4IGK_g((String) CollectionsKt.first((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getLabelSmall(), composer5, 0, 0, 65530);
                TextKt.m2842Text4IGK_g(strengthLabels.get(strength - 1), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getLabelSmall(), composer5, 0, 0, 65530);
                TextKt.m2842Text4IGK_g((String) CollectionsKt.last((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer5, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer5, MaterialTheme.$stable).getLabelSmall(), composer5, 0, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer = $composer2;
            }
            objRememberedValue2 = new Function1() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HomeScreenKt.StylePickerSection$lambda$10$lambda$8$lambda$7(function3, ((Float) obj).floatValue());
                }
            };
            $composer2.updateRememberedValue(objRememberedValue2);
            composer.endReplaceGroup();
            SliderKt.Slider(f, (Function1) objRememberedValue2, null, false, RangesKt.rangeTo(1.0f, 5.0f), 3, null, null, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 460);
            composer2 = composer;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, str3);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween2, Alignment.INSTANCE.getTop(), composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i16 = ((((54 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                function5 = constructor;
                composer2.createNode(function5);
            } else {
                function5 = constructor;
                composer2.useNode();
            }
            composerM3831constructorimpl = Updater.m3831constructorimpl(composer2);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                composer3 = composer2;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                int i17 = (i16 >> 6) & 14;
                Composer composer6 = composer3;
                ComposerKt.sourceInformationMarkerStart(composer6, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                int i18 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer6, 2079814822, "C249@8926L10,250@8987L11,247@8835L194,254@9139L10,255@9200L11,252@9042L191,259@9336L10,260@9397L11,257@9246L193:HomeScreen.kt#987w0c");
                TextKt.m2842Text4IGK_g((String) CollectionsKt.first((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getLabelSmall(), composer6, 0, 0, 65530);
                TextKt.m2842Text4IGK_g(strengthLabels.get(strength - 1), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getLabelSmall(), composer6, 0, 0, 65530);
                TextKt.m2842Text4IGK_g((String) CollectionsKt.last((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer6, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer6, MaterialTheme.$stable).getLabelSmall(), composer6, 0, 0, 65530);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer3 = composer2;
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            int i19 = (i16 >> 6) & 14;
            Composer composer7 = composer3;
            ComposerKt.sourceInformationMarkerStart(composer7, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
            int i110 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart(composer7, 2079814822, "C249@8926L10,250@8987L11,247@8835L194,254@9139L10,255@9200L11,252@9042L191,259@9336L10,260@9397L11,257@9246L193:HomeScreen.kt#987w0c");
            TextKt.m2842Text4IGK_g((String) CollectionsKt.first((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelSmall(), composer7, 0, 0, 65530);
            TextKt.m2842Text4IGK_g(strengthLabels.get(strength - 1), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelSmall(), composer7, 0, 0, 65530);
            TextKt.m2842Text4IGK_g((String) CollectionsKt.last((List) strengthLabels), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer7, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer7, MaterialTheme.$stable).getLabelSmall(), composer7, 0, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            ComposerKt.sourceInformationMarkerEnd(composer7);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.StylePickerSection$lambda$11(scene, list, list2, strength, function1, function2, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StylePickerSection$lambda$6$lambda$5$lambda$4$lambda$3(Function1 $onSceneChange, Scene $entry) {
        $onSceneChange.invoke($entry);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StylePickerSection$lambda$10$lambda$8$lambda$7(Function1 $onStrengthChange, float it) {
        $onStrengthChange.invoke(Integer.valueOf(MathKt.roundToInt(it)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:50:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:53:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:54:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:66:0x023a  */
    /* JADX WARN: Code duplicated, block: B:68:0x0268  */
    /* JADX WARN: Code duplicated, block: B:69:0x026a  */
    /* JADX WARN: Code duplicated, block: B:72:0x027d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0288  */
    /* JADX WARN: Code duplicated, block: B:76:0x028d  */
    /* JADX WARN: Code duplicated, block: B:81:0x02df  */
    private static final void PersonaSection(final List<Persona> list, final String selectedId, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        List<Persona> list2;
        int i2;
        Iterator it;
        Composer $composer2;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue2;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(-1113321788);
        ComposerKt.sourceInformation($composer4, "C(PersonaSection)P(1,2)273@9649L57,276@9774L21,274@9711L588:HomeScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(selectedId) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer4.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1113321788, $dirty, -1, "com.mouthpiece.app.ui.screens.PersonaSection (HomeScreen.kt:272)");
            }
            ComponentsKt.SectionLabel("说话对象（可选）", PaddingKt.m740paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 0.0f, 0.0f, 14, null), $composer4, 54, 0);
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(ScrollKt.horizontalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, $composer4, 0, 1), false, null, false, 14, null), Dp.m7016constructorimpl(20), 0.0f, 2, null);
            Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, Alignment.INSTANCE.getTop(), $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer4, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = ((((48 << 3) & 112) << 6) & 896) | 6;
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
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting()) {
                i = 48;
            } else {
                i = 48;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = (i3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i5 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1112486344, "C283@10017L25,280@9914L138:HomeScreen.kt#987w0c");
                if (selectedId == null) {
                    z = true;
                } else {
                    z = false;
                }
                $composer4.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer4, "CC(remember):HomeScreen.kt#9igjgp");
                if (($dirty & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2;
                objRememberedValue = $composer4.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.PersonaSection$lambda$17$lambda$13$lambda$12(function1);
                        }
                    };
                    $composer4.updateRememberedValue(objRememberedValue);
                }
                $composer4.endReplaceGroup();
                ComponentsKt.PillToggle("不指定", z, (Function0) objRememberedValue, $composer4, 6);
                $composer4.startReplaceGroup(-1211034497);
                ComposerKt.sourceInformation($composer4, "*289@10238L31,286@10103L180");
                list2 = list;
                i2 = 0;
                it = list2.iterator();
                while (it.hasNext()) {
                    Iterable iterable = list2;
                    final Persona persona = (Persona) it.next();
                    int i6 = i2;
                    String displayName = persona.getDisplayName();
                    Iterator it2 = it;
                    boolean zAreEqual = Intrinsics.areEqual(selectedId, persona.getId());
                    $composer4.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation($composer4, "CC(remember):HomeScreen.kt#9igjgp");
                    int $dirty2 = $dirty;
                    if (($dirty & 896) == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zChanged = z4 | $composer4.changed(persona);
                    objRememberedValue2 = $composer4.rememberedValue();
                    if (!zChanged) {
                        $composer3 = $composer4;
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        $composer4.endReplaceGroup();
                        ComponentsKt.PillToggle(displayName, zAreEqual, (Function0) objRememberedValue2, $composer4, 0);
                        list2 = iterable;
                        i2 = i6;
                        it = it2;
                        $dirty = $dirty2;
                        $composer4 = $composer3;
                    } else {
                        $composer3 = $composer4;
                    }
                    Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.PersonaSection$lambda$17$lambda$16$lambda$15$lambda$14(function1, persona);
                        }
                    };
                    $composer4.updateRememberedValue(obj);
                    objRememberedValue2 = obj;
                    $composer4.endReplaceGroup();
                    ComponentsKt.PillToggle(displayName, zAreEqual, (Function0) objRememberedValue2, $composer4, 0);
                    list2 = iterable;
                    i2 = i6;
                    it = it2;
                    $dirty = $dirty2;
                    $composer4 = $composer3;
                }
                $composer2 = $composer4;
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
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
            int i7 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i8 = ((i >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1112486344, "C283@10017L25,280@9914L138:HomeScreen.kt#987w0c");
            if (selectedId == null) {
                z = true;
            } else {
                z = false;
            }
            $composer4.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer4, "CC(remember):HomeScreen.kt#9igjgp");
            if (($dirty & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2;
            objRememberedValue = $composer4.rememberedValue();
            if (!z3) {
            }
            objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeScreenKt.PersonaSection$lambda$17$lambda$13$lambda$12(function1);
                }
            };
            $composer4.updateRememberedValue(objRememberedValue);
            $composer4.endReplaceGroup();
            ComponentsKt.PillToggle("不指定", z, (Function0) objRememberedValue, $composer4, 6);
            $composer4.startReplaceGroup(-1211034497);
            ComposerKt.sourceInformation($composer4, "*289@10238L31,286@10103L180");
            list2 = list;
            i2 = 0;
            it = list2.iterator();
            while (it.hasNext()) {
                Iterable iterable2 = list2;
                final Persona persona2 = (Persona) it.next();
                int i9 = i2;
                String displayName2 = persona2.getDisplayName();
                Iterator it3 = it;
                boolean zAreEqual2 = Intrinsics.areEqual(selectedId, persona2.getId());
                $composer4.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation($composer4, "CC(remember):HomeScreen.kt#9igjgp");
                int $dirty3 = $dirty;
                if (($dirty & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                zChanged = z4 | $composer4.changed(persona2);
                objRememberedValue2 = $composer4.rememberedValue();
                if (!zChanged) {
                    $composer3 = $composer4;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    $composer4.endReplaceGroup();
                    ComponentsKt.PillToggle(displayName2, zAreEqual2, (Function0) objRememberedValue2, $composer4, 0);
                    list2 = iterable2;
                    i2 = i9;
                    it = it3;
                    $dirty = $dirty3;
                    $composer4 = $composer3;
                } else {
                    $composer3 = $composer4;
                }
                Object obj2 = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HomeScreenKt.PersonaSection$lambda$17$lambda$16$lambda$15$lambda$14(function1, persona2);
                    }
                };
                $composer4.updateRememberedValue(obj2);
                objRememberedValue2 = obj2;
                $composer4.endReplaceGroup();
                ComponentsKt.PillToggle(displayName2, zAreEqual2, (Function0) objRememberedValue2, $composer4, 0);
                list2 = iterable2;
                i2 = i9;
                it = it3;
                $dirty = $dirty3;
                $composer4 = $composer3;
            }
            $composer2 = $composer4;
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer4.skipToGroupEnd();
            $composer2 = $composer4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return HomeScreenKt.PersonaSection$lambda$18(list, selectedId, function1, $changed, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSection$lambda$17$lambda$13$lambda$12(Function1 $onPersonaChange) {
        $onPersonaChange.invoke(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaSection$lambda$17$lambda$16$lambda$15$lambda$14(Function1 $onPersonaChange, Persona $persona) {
        $onPersonaChange.invoke($persona.getId());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x030b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0335  */
    /* JADX WARN: Code duplicated, block: B:71:0x0338  */
    /* JADX WARN: Code duplicated, block: B:74:0x034d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0358  */
    /* JADX WARN: Code duplicated, block: B:78:0x035b  */
    /* JADX WARN: Code duplicated, block: B:83:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:84:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:96:0x039e A[EDGE_INSN: B:96:0x039e->B:81:0x039e BREAK  A[LOOP:1: B:66:0x0303->B:80:0x036c], SYNTHETIC] */
    private static final void StyleGrid(final List<StylePreset> list, final List<String> list2, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2;
        Function0<ComposeUiNode> function2;
        String str;
        RowScope rowScope;
        Composer composer;
        List list3;
        Iterator it;
        String str2;
        Composer $composer3;
        boolean z;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer $composer4;
        Composer $composer5 = $composer.startRestartGroup(-571798925);
        ComposerKt.sourceInformation($composer5, "C(StyleGrid)P(2,1)301@10439L682:HomeScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changedInstance(list2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer5.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer5.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-571798925, $dirty, -1, "com.mouthpiece.app.ui.screens.StyleGrid (HomeScreen.kt:300)");
            }
            Modifier modifierM738paddingVpY3zN4$default = PaddingKt.m738paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7016constructorimpl(20), 0.0f, 2, null);
            Arrangement.Vertical verticalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(verticalM617spacedBy0680j_4, Alignment.INSTANCE.getStart(), $composer5, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            String str3 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer5.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer5, modifierM738paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((54 << 3) & 112) << 6) & 896) | 6;
            String str4 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                function0 = constructor;
                $composer5.createNode(function0);
            } else {
                function0 = constructor;
                $composer5.useNode();
            }
            Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer5);
            Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i2 = (i >> 6) & 14;
            Composer composer2 = $composer5;
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((54 >> 6) & 112) | 6;
            String str5 = "C:HomeScreen.kt#987w0c";
            ComposerKt.sourceInformationMarkerStart(composer2, 1903252704, "C:HomeScreen.kt#987w0c");
            composer2.startReplaceGroup(-1462624847);
            ComposerKt.sourceInformation(composer2, "*306@10630L475");
            Iterable<List> iterableChunked = CollectionsKt.chunked(list, 2);
            int i4 = 0;
            for (List list4 : iterableChunked) {
                Iterable iterable = iterableChunked;
                int i5 = i4;
                int i6 = i3;
                Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Modifier modifier = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                String str6 = str3;
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifier);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int i7 = ((((48 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    function2 = constructor2;
                    composer2.createNode(function2);
                } else {
                    function2 = constructor2;
                    composer2.useNode();
                }
                Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl(composer2);
                Composer composer3 = composer2;
                Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM3831constructorimpl2.getInserting()) {
                    str = str4;
                } else {
                    str = str4;
                    if (!Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i8 = (i7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i9 = ((48 >> 6) & 112) | 6;
                    rowScope = RowScopeInstance.INSTANCE;
                    composer = composer3;
                    ComposerKt.sourceInformationMarkerStart(composer, -1946253506, str5);
                    composer.startReplaceGroup(214312534);
                    ComposerKt.sourceInformation(composer, "*311@10904L22,308@10753L251");
                    list3 = list4;
                    it = list3.iterator();
                    while (true) {
                        str2 = str5;
                        if (it.hasNext()) {
                            break;
                        }
                        final StylePreset stylePreset = (StylePreset) it.next();
                        Iterable iterable2 = list3;
                        boolean zContains = list2.contains(stylePreset.getId());
                        composer.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation(composer, "CC(remember):HomeScreen.kt#9igjgp");
                        Composer composer4 = composer;
                        if (($dirty & 896) == 256) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChangedInstance = z | $composer5.changedInstance(stylePreset);
                        objRememberedValue = composer4.rememberedValue();
                        if (!zChangedInstance) {
                            $composer4 = $composer5;
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            }
                            composer4.endReplaceGroup();
                            ComponentsKt.StyleChip(stylePreset, zContains, (Function0) objRememberedValue, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, StylePreset.$stable, 0);
                            composer = composer4;
                            str5 = str2;
                            list3 = iterable2;
                            $composer5 = $composer4;
                        } else {
                            $composer4 = $composer5;
                        }
                        objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return HomeScreenKt.StyleGrid$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(function1, stylePreset);
                            }
                        };
                        composer4.updateRememberedValue(objRememberedValue);
                        composer4.endReplaceGroup();
                        ComponentsKt.StyleChip(stylePreset, zContains, (Function0) objRememberedValue, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, StylePreset.$stable, 0);
                        composer = composer4;
                        str5 = str2;
                        list3 = iterable2;
                        $composer5 = $composer4;
                    }
                    Composer $composer6 = $composer5;
                    $composer3 = composer;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(214322678);
                    ComposerKt.sourceInformation($composer3, "315@11064L27");
                    if (list4.size() == 1) {
                        SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), $composer3, 0);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    iterableChunked = iterable;
                    i4 = i5;
                    i3 = i6;
                    str3 = str6;
                    composer2 = composer3;
                    str4 = str;
                    str5 = str2;
                    $composer5 = $composer6;
                }
                composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                int i10 = (i7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                int i11 = ((48 >> 6) & 112) | 6;
                rowScope = RowScopeInstance.INSTANCE;
                composer = composer3;
                ComposerKt.sourceInformationMarkerStart(composer, -1946253506, str5);
                composer.startReplaceGroup(214312534);
                ComposerKt.sourceInformation(composer, "*311@10904L22,308@10753L251");
                list3 = list4;
                it = list3.iterator();
                while (true) {
                    str2 = str5;
                    if (it.hasNext()) {
                        break;
                        break;
                    }
                    final StylePreset stylePreset2 = (StylePreset) it.next();
                    Iterable iterable3 = list3;
                    boolean zContains2 = list2.contains(stylePreset2.getId());
                    composer.startReplaceGroup(-1633490746);
                    ComposerKt.sourceInformation(composer, "CC(remember):HomeScreen.kt#9igjgp");
                    Composer composer5 = composer;
                    if (($dirty & 896) == 256) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zChangedInstance = z | $composer5.changedInstance(stylePreset2);
                    objRememberedValue = composer5.rememberedValue();
                    if (!zChangedInstance) {
                        $composer4 = $composer5;
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        composer5.endReplaceGroup();
                        ComponentsKt.StyleChip(stylePreset2, zContains2, (Function0) objRememberedValue, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), composer5, StylePreset.$stable, 0);
                        composer = composer5;
                        str5 = str2;
                        list3 = iterable3;
                        $composer5 = $composer4;
                    } else {
                        $composer4 = $composer5;
                    }
                    objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenKt.StyleGrid$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(function1, stylePreset2);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue);
                    composer5.endReplaceGroup();
                    ComponentsKt.StyleChip(stylePreset2, zContains2, (Function0) objRememberedValue, RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), composer5, StylePreset.$stable, 0);
                    composer = composer5;
                    str5 = str2;
                    list3 = iterable3;
                    $composer5 = $composer4;
                }
                Composer $composer7 = $composer5;
                $composer3 = composer;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(214322678);
                ComposerKt.sourceInformation($composer3, "315@11064L27");
                if (list4.size() == 1) {
                    SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), $composer3, 0);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                iterableChunked = iterable;
                i4 = i5;
                i3 = i6;
                str3 = str6;
                composer2 = composer3;
                str4 = str;
                str5 = str2;
                $composer5 = $composer7;
            }
            $composer2 = $composer5;
            Composer composer6 = composer2;
            composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer5.skipToGroupEnd();
            $composer2 = $composer5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.StyleGrid$lambda$25(list, list2, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyleGrid$lambda$24$lambda$23$lambda$22$lambda$21$lambda$20$lambda$19(Function1 $onToggle, StylePreset $style) {
        $onToggle.invoke($style.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object readClipboard(Context context, Continuation<? super String> continuation) {
        ClipData clip;
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager manager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        return (manager == null || (clip = manager.getPrimaryClip()) == null || clip.getItemCount() == 0) ? "" : BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(clip, context, null), continuation);
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.screens.HomeScreenKt$readClipboard$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomeScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.ui.screens.HomeScreenKt$readClipboard$2", f = "HomeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ ClipData $clip;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClipData clipData, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$clip = clipData;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$clip, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CharSequence charSequenceCoerceToText = this.$clip.getItemAt(0).coerceToText(this.$context);
                    String string = charSequenceCoerceToText != null ? charSequenceCoerceToText.toString() : null;
                    return string == null ? "" : string;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
