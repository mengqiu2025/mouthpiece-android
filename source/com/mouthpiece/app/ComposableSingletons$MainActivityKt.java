package com.mouthpiece.app;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.mouthpiece.app.ui.AppRootKt;
import com.mouthpiece.app.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();
    private static Function2<Composer, Integer, Unit> lambda$550601936 = ComposableLambdaKt.composableLambdaInstance(550601936, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ComposableSingletons$MainActivityKt$lambda$550601936$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C36@1086L47:MainActivity.kt#1g3kg7");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(550601936, $changed, -1, "com.mouthpiece.app.ComposableSingletons$MainActivityKt.lambda$550601936.<anonymous> (MainActivity.kt:36)");
            }
            AppRootKt.AppRoot(ServiceLocator.INSTANCE.getSharedText(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1548998213, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f87lambda$1548998213 = ComposableLambdaKt.composableLambdaInstance(-1548998213, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ComposableSingletons$MainActivityKt$lambda$-1548998213$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C35@1052L95:MainActivity.kt#1g3kg7");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1548998213, $changed, -1, "com.mouthpiece.app.ComposableSingletons$MainActivityKt.lambda$-1548998213.<anonymous> (MainActivity.kt:35)");
            }
            ThemeKt.MouthpieceTheme(false, false, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$550601936$app_debug(), $composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda$-1548998213$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7496getLambda$1548998213$app_debug() {
        return f87lambda$1548998213;
    }

    public final Function2<Composer, Integer, Unit> getLambda$550601936$app_debug() {
        return lambda$550601936;
    }
}
