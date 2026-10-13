package com.mouthpiece.app.ui.screens;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerScope;
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
import com.mouthpiece.app.domain.Reply;
import com.mouthpiece.app.ui.components.ComponentsKt;
import com.mouthpiece.app.vm.ReplyKey;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ResultScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class ResultScreenKt$DoneContent$3$1 implements Function4<PagerScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ Set<ReplyKey> $favoriteKeys;
    final /* synthetic */ String $incoming;
    final /* synthetic */ Function1<Reply, Unit> $onCopy;
    final /* synthetic */ Function1<Reply, Unit> $onFavorite;
    final /* synthetic */ Function0<Unit> $onRegenerate;
    final /* synthetic */ Function1<Reply, Unit> $onShare;
    final /* synthetic */ List<Reply> $replies;
    final /* synthetic */ boolean $sharing;

    /* JADX WARN: Multi-variable type inference failed */
    ResultScreenKt$DoneContent$3$1(List<Reply> list, boolean z, Set<ReplyKey> set, String str, Function1<? super Reply, Unit> function1, Function1<? super Reply, Unit> function2, Function1<? super Reply, Unit> function3, Function0<Unit> function0) {
        this.$replies = list;
        this.$sharing = z;
        this.$favoriteKeys = set;
        this.$incoming = str;
        this.$onCopy = function1;
        this.$onFavorite = function2;
        this.$onShare = function3;
        this.$onRegenerate = function0;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer, Integer num2) {
        invoke(pagerScope, num.intValue(), composer, num2.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x027e  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    public final void invoke(PagerScope HorizontalPager, int page, Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        String str;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        ComposerKt.sourceInformation($composer, "C138@4709L532:ResultScreen.kt#987w0c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(447283618, $changed, -1, "com.mouthpiece.app.ui.screens.DoneContent.<anonymous>.<anonymous> (ResultScreen.kt:137)");
        }
        final Reply reply = this.$replies.get(page);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        List<Reply> list = this.$replies;
        boolean z = this.$sharing;
        Set<ReplyKey> set = this.$favoriteKeys;
        String str2 = this.$incoming;
        final Function1<Reply, Unit> function1 = this.$onCopy;
        final Function1<Reply, Unit> function2 = this.$onFavorite;
        final Function1<Reply, Unit> function3 = this.$onShare;
        Function0<Unit> function4 = this.$onRegenerate;
        ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i = ((((6 << 3) & 112) << 6) & 896) | 6;
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
        Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        int i2 = (i >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        int i3 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1630091675, "C144@5037L17,145@5089L21,146@5142L18,139@4767L460:ResultScreen.kt#987w0c");
        String str3 = (page + 1) + "/" + list.size();
        boolean z2 = !z;
        boolean zContains = set.contains(new ReplyKey(StringsKt.trim((CharSequence) str2).toString(), reply.getText()));
        $composer.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation($composer, "CC(remember):ResultScreen.kt#9igjgp");
        boolean zChanged3 = $composer.changed(function1) | $composer.changed(reply);
        Object objRememberedValue3 = $composer.rememberedValue();
        if (!zChanged3) {
            str = str3;
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            }
            Function0 function5 = (Function0) objRememberedValue3;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation($composer, "CC(remember):ResultScreen.kt#9igjgp");
            zChanged = $composer.changed(function2) | $composer.changed(reply);
            objRememberedValue = $composer.rememberedValue();
            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$DoneContent$3$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ResultScreenKt$DoneContent$3$1.invoke$lambda$6$lambda$3$lambda$2(function2, reply);
                    }
                };
                $composer.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            Function0 function6 = (Function0) objRememberedValue;
            $composer.endReplaceGroup();
            $composer.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation($composer, "CC(remember):ResultScreen.kt#9igjgp");
            zChanged2 = $composer.changed(function3) | $composer.changed(reply);
            objRememberedValue2 = $composer.rememberedValue();
            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Object obj2 = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$DoneContent$3$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ResultScreenKt$DoneContent$3$1.invoke$lambda$6$lambda$5$lambda$4(function3, reply);
                    }
                };
                $composer.updateRememberedValue(obj2);
                objRememberedValue2 = obj2;
            }
            $composer.endReplaceGroup();
            ComponentsKt.ReplyCard(reply, str, function5, function6, (Function0) objRememberedValue2, function4, null, z2, zContains, $composer, 0, 64);
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
        str = str3;
        Object obj3 = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$DoneContent$3$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResultScreenKt$DoneContent$3$1.invoke$lambda$6$lambda$1$lambda$0(function1, reply);
            }
        };
        $composer.updateRememberedValue(obj3);
        objRememberedValue3 = obj3;
        Function0 function7 = (Function0) objRememberedValue3;
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation($composer, "CC(remember):ResultScreen.kt#9igjgp");
        zChanged = $composer.changed(function2) | $composer.changed(reply);
        objRememberedValue = $composer.rememberedValue();
        if (!zChanged) {
        }
        Object obj4 = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$DoneContent$3$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResultScreenKt$DoneContent$3$1.invoke$lambda$6$lambda$3$lambda$2(function2, reply);
            }
        };
        $composer.updateRememberedValue(obj4);
        objRememberedValue = obj4;
        Function0 function8 = (Function0) objRememberedValue;
        $composer.endReplaceGroup();
        $composer.startReplaceGroup(-1633490746);
        ComposerKt.sourceInformation($composer, "CC(remember):ResultScreen.kt#9igjgp");
        zChanged2 = $composer.changed(function3) | $composer.changed(reply);
        objRememberedValue2 = $composer.rememberedValue();
        if (!zChanged2) {
        }
        Object obj5 = new Function0() { // from class: com.mouthpiece.app.ui.screens.ResultScreenKt$DoneContent$3$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResultScreenKt$DoneContent$3$1.invoke$lambda$6$lambda$5$lambda$4(function3, reply);
            }
        };
        $composer.updateRememberedValue(obj5);
        objRememberedValue2 = obj5;
        $composer.endReplaceGroup();
        ComponentsKt.ReplyCard(reply, str, function7, function8, (Function0) objRememberedValue2, function4, null, z2, zContains, $composer, 0, 64);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$1$lambda$0(Function1 $onCopy, Reply $reply) {
        $onCopy.invoke($reply);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$3$lambda$2(Function1 $onFavorite, Reply $reply) {
        $onFavorite.invoke($reply);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4(Function1 $onShare, Reply $reply) {
        $onShare.invoke($reply);
        return Unit.INSTANCE;
    }
}
