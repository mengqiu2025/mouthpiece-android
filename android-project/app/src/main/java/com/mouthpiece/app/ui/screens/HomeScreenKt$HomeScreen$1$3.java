package com.mouthpiece.app.ui.screens;

import android.content.Context;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class HomeScreenKt$HomeScreen$1$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<String, Unit> $onIncomingChange;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: Multi-variable type inference failed */
    HomeScreenKt$HomeScreen$1$3(CoroutineScope coroutineScope, Context context, Function1<? super String, Unit> function1) {
        this.$scope = coroutineScope;
        this.$context = context;
        this.$onIncomingChange = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C138@5231L364,137@5189L475:HomeScreen.kt#987w0c");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-459805611, $changed, -1, "com.mouthpiece.app.ui.screens.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:137)");
        }
        $composer.startReplaceGroup(-1746271574);
        ComposerKt.sourceInformation($composer, "CC(remember):HomeScreen.kt#9igjgp");
        boolean zChangedInstance = $composer.changedInstance(this.$scope) | $composer.changedInstance(this.$context) | $composer.changed(this.$onIncomingChange);
        final CoroutineScope coroutineScope = this.$scope;
        final Context context = this.$context;
        final Function1<String, Unit> function1 = this.$onIncomingChange;
        Object objRememberedValue = $composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.HomeScreenKt$HomeScreen$1$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeScreenKt$HomeScreen$1$3.invoke$lambda$1$lambda$0(coroutineScope, context, function1);
                }
            };
            $composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        $composer.endReplaceGroup();
        ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$HomeScreenKt.INSTANCE.getLambda$339944632$app_debug(), $composer, 805306368, 510);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(CoroutineScope $scope, Context $context, Function1 $onIncomingChange) {
        BuildersKt__Builders_commonKt.launch$default($scope, null, null, new HomeScreenKt$HomeScreen$1$3$1$1$1($context, $onIncomingChange, null), 3, null);
        return Unit.INSTANCE;
    }
}
