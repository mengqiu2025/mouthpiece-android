package com.mouthpiece.app.ui.screens;

import android.content.Context;
import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.core.content.ContextCompat;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.ui.components.ComponentsKt;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SettingsScreenKt$SettingsScreen$1$3$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Boolean, Unit> $onNotifyChange;
    final /* synthetic */ Function1<Integer, Unit> $onNotifyHourChange;
    final /* synthetic */ Function0<Unit> $onPreviewPush;
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $permissionLauncher;
    final /* synthetic */ AppSettings $settings;

    /* JADX WARN: Multi-variable type inference failed */
    SettingsScreenKt$SettingsScreen$1$3$3(AppSettings appSettings, Function1<? super Boolean, Unit> function1, Context context, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, Function0<Unit> function0, Function1<? super Integer, Unit> function2) {
        this.$settings = appSettings;
        this.$onNotifyChange = function1;
        this.$context = context;
        this.$permissionLauncher = managedActivityResultLauncher;
        this.$onPreviewPush = function0;
        this.$onNotifyHourChange = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 $onNotifyChange, Context $context, ManagedActivityResultLauncher $permissionLauncher, boolean checked) {
        if (!checked) {
            $onNotifyChange.invoke(false);
        } else if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission($context, "android.permission.POST_NOTIFICATIONS") == 0) {
            $onNotifyChange.invoke(true);
        } else {
            $permissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4$lambda$3$lambda$2(Function1 $onNotifyHourChange, int $hour) {
        $onNotifyHourChange.invoke(Integer.valueOf($hour));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x024e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0280  */
    /* JADX WARN: Code duplicated, block: B:41:0x0282  */
    /* JADX WARN: Code duplicated, block: B:44:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:47:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:48:0x02b6  */
    public final void invoke(Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        AppSettings appSettings;
        int i;
        Iterable notify_hours;
        int i2;
        Iterator it;
        final int iIntValue;
        boolean z;
        boolean zChanged;
        Object objRememberedValue;
        int i3;
        ComposerKt.sourceInformation($composer, "C194@8130L627,190@7947L828,209@8843L30,212@8985L10,210@8894L133,214@9048L29,215@9098L448,224@9567L29,229@9845L10,230@9914L11,227@9725L239,232@9985L29,235@10158L10,236@10227L11,233@10035L242,238@10298L29,239@10348L53:SettingsScreen.kt#987w0c");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1269102234, $changed, -1, "com.mouthpiece.app.ui.screens.SettingsScreen.<anonymous>.<anonymous>.<anonymous> (SettingsScreen.kt:190)");
        }
        boolean notifyEnabled = this.$settings.getNotifyEnabled();
        $composer.startReplaceGroup(-1746271574);
        ComposerKt.sourceInformation($composer, "CC(remember):SettingsScreen.kt#9igjgp");
        boolean zChanged2 = $composer.changed(this.$onNotifyChange) | $composer.changedInstance(this.$context) | $composer.changedInstance(this.$permissionLauncher);
        final Function1<Boolean, Unit> function1 = this.$onNotifyChange;
        final Context context = this.$context;
        final ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher = this.$permissionLauncher;
        Object objRememberedValue2 = $composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function1() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SettingsScreenKt$SettingsScreen$1$3$3.invoke$lambda$1$lambda$0(function1, context, managedActivityResultLauncher, ((Boolean) obj2).booleanValue());
                }
            };
            $composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        $composer.endReplaceGroup();
        SettingsScreenKt.SwitchRow("每日话术", "每天早上推一条能直接用的沟通技巧", notifyEnabled, (Function1) objRememberedValue2, $composer, 54);
        if (this.$settings.getNotifyEnabled()) {
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(14)), $composer, 6);
            String str = "CC(remember):SettingsScreen.kt#9igjgp";
            TextKt.m2842Text4IGK_g("推送时间", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 6, 0, 65534);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(8)), $composer, 6);
            Arrangement.Horizontal horizontalM617spacedBy0680j_4 = Arrangement.INSTANCE.m617spacedBy0680j_4(Dp.m7016constructorimpl(8));
            AppSettings appSettings2 = this.$settings;
            final Function1<Integer, Unit> function2 = this.$onNotifyHourChange;
            int i4 = 48;
            int i5 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM617spacedBy0680j_4, Alignment.INSTANCE.getTop(), $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((((48 << 3) & 112) << 6) & 896) | 6;
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
            if (composerM3831constructorimpl.getInserting()) {
                appSettings = appSettings2;
            } else {
                appSettings = appSettings2;
                if (!Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                }
                Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = (i6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                i = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -980181948, "C:SettingsScreen.kt#987w0c");
                $composer.startReplaceGroup(-447259994);
                ComposerKt.sourceInformation($composer, "*220@9440L28,217@9251L247");
                notify_hours = AppSettings.INSTANCE.getNOTIFY_HOURS();
                i2 = 0;
                it = notify_hours.iterator();
                while (it.hasNext()) {
                    Iterable iterable = notify_hours;
                    iIntValue = ((Number) it.next()).intValue();
                    int i8 = i2;
                    int i9 = i;
                    String str2 = String.format("%02d:00", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    if (appSettings.getNotifyHour() == iIntValue) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i10 = i4;
                    $composer.startReplaceGroup(-1633490746);
                    String str3 = str;
                    ComposerKt.sourceInformation($composer, str3);
                    zChanged = $composer.changed(function2) | $composer.changed(iIntValue);
                    objRememberedValue = $composer.rememberedValue();
                    if (zChanged) {
                        i3 = i5;
                    } else {
                        i3 = i5;
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        $composer.endReplaceGroup();
                        ComponentsKt.PillToggle(str2, z, (Function0) objRememberedValue, $composer, 0);
                        notify_hours = iterable;
                        i = i9;
                        i2 = i8;
                        i4 = i10;
                        str = str3;
                        i5 = i3;
                    }
                    objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$3$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsScreenKt$SettingsScreen$1$3$3.invoke$lambda$5$lambda$4$lambda$3$lambda$2(function2, iIntValue);
                        }
                    };
                    $composer.updateRememberedValue(objRememberedValue);
                    $composer.endReplaceGroup();
                    ComponentsKt.PillToggle(str2, z, (Function0) objRememberedValue, $composer, 0);
                    notify_hours = iterable;
                    i = i9;
                    i2 = i8;
                    i4 = i10;
                    str = str3;
                    i5 = i3;
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(6)), $composer, 6);
                TextKt.m2842Text4IGK_g("约在所选时间推送；受系统省电策略影响可能延后几十分钟，属正常现象。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(6)), $composer, 6);
                TextKt.m2842Text4IGK_g("晚上 21:00 还会有一条断签提醒——如果那天你一次都没用过，才会发。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
                SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer, 6);
                ButtonKt.TextButton(this.$onPreviewPush, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$260117774$app_debug(), $composer, 805306368, 510);
            }
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = (i6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            i = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -980181948, "C:SettingsScreen.kt#987w0c");
            $composer.startReplaceGroup(-447259994);
            ComposerKt.sourceInformation($composer, "*220@9440L28,217@9251L247");
            notify_hours = AppSettings.INSTANCE.getNOTIFY_HOURS();
            i2 = 0;
            it = notify_hours.iterator();
            while (it.hasNext()) {
                Iterable iterable2 = notify_hours;
                iIntValue = ((Number) it.next()).intValue();
                int i12 = i2;
                int i13 = i;
                String str4 = String.format("%02d:00", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                if (appSettings.getNotifyHour() == iIntValue) {
                    z = true;
                } else {
                    z = false;
                }
                int i14 = i4;
                $composer.startReplaceGroup(-1633490746);
                String str5 = str;
                ComposerKt.sourceInformation($composer, str5);
                zChanged = $composer.changed(function2) | $composer.changed(iIntValue);
                objRememberedValue = $composer.rememberedValue();
                if (zChanged) {
                    i3 = i5;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceGroup();
                    ComponentsKt.PillToggle(str4, z, (Function0) objRememberedValue, $composer, 0);
                    notify_hours = iterable2;
                    i = i13;
                    i2 = i12;
                    i4 = i14;
                    str = str5;
                    i5 = i3;
                } else {
                    i3 = i5;
                }
                objRememberedValue = new Function0() { // from class: com.mouthpiece.app.ui.screens.SettingsScreenKt$SettingsScreen$1$3$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsScreenKt$SettingsScreen$1$3$3.invoke$lambda$5$lambda$4$lambda$3$lambda$2(function2, iIntValue);
                    }
                };
                $composer.updateRememberedValue(objRememberedValue);
                $composer.endReplaceGroup();
                ComponentsKt.PillToggle(str4, z, (Function0) objRememberedValue, $composer, 0);
                notify_hours = iterable2;
                i = i13;
                i2 = i12;
                i4 = i14;
                str = str5;
                i5 = i3;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(6)), $composer, 6);
            TextKt.m2842Text4IGK_g("约在所选时间推送；受系统省电策略影响可能延后几十分钟，属正常现象。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(6)), $composer, 6);
            TextKt.m2842Text4IGK_g("晚上 21:00 还会有一条断签提醒——如果那天你一次都没用过，才会发。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer, 6);
            ButtonKt.TextButton(this.$onPreviewPush, null, false, null, null, null, null, null, null, ComposableSingletons$SettingsScreenKt.INSTANCE.getLambda$260117774$app_debug(), $composer, 805306368, 510);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
