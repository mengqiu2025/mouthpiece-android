package com.mouthpiece.app.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HistoryScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$HistoryScreenKt {
    public static final ComposableSingletons$HistoryScreenKt INSTANCE = new ComposableSingletons$HistoryScreenKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$176775067 = ComposableLambdaKt.composableLambdaInstance(176775067, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt$lambda$176775067$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C71@2892L12:HistoryScreen.kt#987w0c");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(176775067, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt.lambda$176775067.<anonymous> (HistoryScreen.kt:71)");
            }
            TextKt.m2842Text4IGK_g("清空全部", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$711786217 = ComposableLambdaKt.composableLambdaInstance(711786217, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt$lambda$711786217$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C92@3479L15:HistoryScreen.kt#987w0c");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(711786217, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt.lambda$711786217.<anonymous> (HistoryScreen.kt:92)");
            }
            TextKt.m2842Text4IGK_g("搜索原话或回复", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$998004616 = ComposableLambdaKt.composableLambdaInstance(998004616, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt$lambda$998004616$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C166@6082L11,163@5920L212:HistoryScreen.kt#987w0c");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(998004616, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt.lambda$998004616.<anonymous> (HistoryScreen.kt:163)");
            }
            IconKt.m2299Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "删除", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2055getOnSurfaceVariant0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$388110307 = ComposableLambdaKt.composableLambdaInstance(388110307, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt$lambda$388110307$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C186@6819L14:HistoryScreen.kt#987w0c");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(388110307, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$HistoryScreenKt.lambda$388110307.<anonymous> (HistoryScreen.kt:186)");
            }
            TextKt.m2842Text4IGK_g("再次生成同款", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$176775067$app_debug() {
        return lambda$176775067;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$388110307$app_debug() {
        return lambda$388110307;
    }

    public final Function2<Composer, Integer, Unit> getLambda$711786217$app_debug() {
        return lambda$711786217;
    }

    public final Function2<Composer, Integer, Unit> getLambda$998004616$app_debug() {
        return lambda$998004616;
    }
}
