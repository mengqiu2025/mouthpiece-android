package com.mouthpiece.app.ui.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.ShareKt;
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

/* JADX INFO: compiled from: Components.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$ComponentsKt {
    public static final ComposableSingletons$ComponentsKt INSTANCE = new ComposableSingletons$ComponentsKt();
    private static Function2<Composer, Integer, Unit> lambda$1578118600 = ComposableLambdaKt.composableLambdaInstance(1578118600, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt$lambda$1578118600$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C81@3295L11,78@3146L195:Components.kt#vgzelz");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1578118600, $changed, -1, "com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt.lambda$1578118600.<anonymous> (Components.kt:78)");
            }
            IconKt.m2299Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "返回", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2055getOnSurfaceVariant0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1366598407, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f88lambda$1366598407 = ComposableLambdaKt.composableLambdaInstance(-1366598407, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt$lambda$-1366598407$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope FilledTonalButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
            ComposerKt.sourceInformation($composer, "C185@6721L10:Components.kt#vgzelz");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1366598407, $changed, -1, "com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt.lambda$-1366598407.<anonymous> (Components.kt:185)");
            }
            TextKt.m2842Text4IGK_g("复制", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$596680910 = ComposableLambdaKt.composableLambdaInstance(596680910, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt$lambda$596680910$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C191@7035L11,188@6871L214:Components.kt#vgzelz");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(596680910, $changed, -1, "com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt.lambda$596680910.<anonymous> (Components.kt:188)");
            }
            IconKt.m2299Iconww6aTOc(ShareKt.getShare(Icons.INSTANCE.getDefault()), "分享为卡片", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2055getOnSurfaceVariant0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1573451158 = ComposableLambdaKt.composableLambdaInstance(1573451158, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt$lambda$1573451158$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C216@8157L11,213@7993L205:Components.kt#vgzelz");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1573451158, $changed, -1, "com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt.lambda$1573451158.<anonymous> (Components.kt:213)");
            }
            IconKt.m2299Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), "换一批", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2060getPrimary0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1547797941 = ComposableLambdaKt.composableLambdaInstance(1547797941, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt$lambda$1547797941$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C389@13531L10:Components.kt#vgzelz");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1547797941, $changed, -1, "com.mouthpiece.app.ui.components.ComposableSingletons$ComponentsKt.lambda$1547797941.<anonymous> (Components.kt:389)");
            }
            TextKt.m2842Text4IGK_g("取消", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda$-1366598407$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7506getLambda$1366598407$app_debug() {
        return f88lambda$1366598407;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1547797941$app_debug() {
        return lambda$1547797941;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1573451158$app_debug() {
        return lambda$1573451158;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1578118600$app_debug() {
        return lambda$1578118600;
    }

    public final Function2<Composer, Integer, Unit> getLambda$596680910$app_debug() {
        return lambda$596680910;
    }
}
