package com.mouthpiece.app.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.unit.Dp;
import com.mouthpiece.app.AppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$SettingsScreenKt {
    public static final ComposableSingletons$SettingsScreenKt INSTANCE = new ComposableSingletons$SettingsScreenKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$260117774 = ComposableLambdaKt.composableLambdaInstance(260117774, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt$lambda$260117774$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C239@10386L13:SettingsScreen.kt#987w0c");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(260117774, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$260117774.<anonymous> (SettingsScreen.kt:239)");
            }
            TextKt.m2842Text4IGK_g("立即试一条", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1733296153, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f98lambda$1733296153 = ComposableLambdaKt.composableLambdaInstance(-1733296153, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt$lambda$-1733296153$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C271@11697L12:SettingsScreen.kt#987w0c");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1733296153, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1733296153.<anonymous> (SettingsScreen.kt:271)");
            }
            TextKt.m2842Text4IGK_g("清空历史", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1522921808 = ComposableLambdaKt.composableLambdaInstance(1522921808, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt$lambda$1522921808$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C272@11783L14:SettingsScreen.kt#987w0c");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1522921808, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$1522921808.<anonymous> (SettingsScreen.kt:272)");
            }
            TextKt.m2842Text4IGK_g("清空全部数据", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1117047255, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f97lambda$1117047255 = ComposableLambdaKt.composableLambdaInstance(-1117047255, false, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt$lambda$-1117047255$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C288@12440L10,286@12333L147,290@12497L29,293@12648L10,294@12713L11,291@12543L216,296@12776L29,299@12937L10,300@13002L11,297@12822L226:SettingsScreen.kt#987w0c");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117047255, $changed, -1, "com.mouthpiece.app.ui.screens.ComposableSingletons$SettingsScreenKt.lambda$-1117047255.<anonymous> (SettingsScreen.kt:286)");
            }
            TextKt.m2842Text4IGK_g("嘴替 · " + AppInfo.INSTANCE.getVersionLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 0, 0, 65534);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(4)), $composer, 6);
            TextKt.m2842Text4IGK_g("构建号 " + AppInfo.INSTANCE.getBuildNumber(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2055getOnSurfaceVariant0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 0, 0, 65530);
            SpacerKt.Spacer(SizeKt.m769height3ABfNKs(Modifier.INSTANCE, Dp.m7016constructorimpl(6)), $composer, 6);
            TextKt.m2842Text4IGK_g("一个帮你想「怎么回」的文案灵感工具。生成内容仅供参考，发送前请自行判断。", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m2055getOnSurfaceVariant0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 6, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda$-1117047255$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7515getLambda$1117047255$app_debug() {
        return f97lambda$1117047255;
    }

    /* JADX INFO: renamed from: getLambda$-1733296153$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7516getLambda$1733296153$app_debug() {
        return f98lambda$1733296153;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1522921808$app_debug() {
        return lambda$1522921808;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$260117774$app_debug() {
        return lambda$260117774;
    }
}
