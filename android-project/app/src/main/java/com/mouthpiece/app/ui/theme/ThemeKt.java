package com.mouthpiece.app.ui.theme;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.DynamicTonalPaletteKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"LightScheme", "Landroidx/compose/material3/ColorScheme;", "DarkScheme", "MouthpieceTypography", "Landroidx/compose/material3/Typography;", "MouthpieceTheme", "", "darkTheme", "", "dynamicColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme LightScheme = ColorSchemeKt.m2085lightColorSchemeCXl9yA$default(ColorKt.Color(4284169184L), ColorKt.Color(4294967295L), ColorKt.Color(4293386751L), ColorKt.Color(4279962206L), 0, ColorKt.Color(4294929239L), ColorKt.Color(4294967295L), ColorKt.Color(4294959579L), ColorKt.Color(4282322437L), 0, 0, 0, 0, ColorKt.Color(4294440699L), ColorKt.Color(4279703327L), ColorKt.Color(4294967295L), ColorKt.Color(4279703327L), ColorKt.Color(4293914103L), ColorKt.Color(4284111470L), 0, 0, 0, ColorKt.Color(4290386458L), 0, 0, 0, ColorKt.Color(4292269028L), 0, 0, 0, 0, 0, 0, 0, 0, 0, -71819760, 15, null);
    private static final ColorScheme DarkScheme = ColorSchemeKt.m2081darkColorSchemeCXl9yA$default(ColorKt.Color(4290356991L), ColorKt.Color(4280488058L), ColorKt.Color(4282067624L), ColorKt.Color(4293386751L), 0, ColorKt.Color(4294941836L), ColorKt.Color(4283044104L), ColorKt.Color(4285211670L), ColorKt.Color(4294959579L), 0, 0, 0, 0, ColorKt.Color(4279242772L), ColorKt.Color(4293716978L), ColorKt.Color(4279834914L), ColorKt.Color(4293716978L), ColorKt.Color(4280690227L), ColorKt.Color(4290163910L), 0, 0, 0, ColorKt.Color(4294948011L), 0, 0, 0, ColorKt.Color(4282203212L), 0, 0, 0, 0, 0, 0, 0, 0, 0, -71819760, 15, null);
    private static final Typography MouthpieceTypography = new Typography(null, null, null, null, null, new TextStyle(0, TextUnitKt.getSp(24), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(32), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), new TextStyle(0, TextUnitKt.getSp(20), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(28), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), new TextStyle(0, TextUnitKt.getSp(16), FontWeight.INSTANCE.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(24), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), null, new TextStyle(0, TextUnitKt.getSp(16), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(26), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null), new TextStyle(0, TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(22), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646141, (DefaultConstructorMarker) null), null, new TextStyle(0, TextUnitKt.getSp(14), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), null, new TextStyle(0, TextUnitKt.getSp(11), FontWeight.INSTANCE.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(16), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), 10527, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MouthpieceTheme$lambda$0(boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        MouthpieceTheme(z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MouthpieceTheme(boolean darkTheme, boolean dynamicColor, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        boolean darkTheme2;
        boolean dynamicColor2;
        int $dirty;
        boolean darkTheme3;
        ColorScheme scheme;
        final boolean darkTheme4;
        final boolean dynamicColor3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(23871156);
        ComposerKt.sourceInformation($composer2, "C(MouthpieceTheme)P(1,2)87@3224L119:Theme.kt#stgksq");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= ((i & 1) == 0 && $composer2.changed(darkTheme)) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(dynamicColor) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(content) ? 256 : 128;
        }
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            dynamicColor3 = dynamicColor;
            darkTheme4 = darkTheme;
        } else {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "73@2812L21");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    darkTheme2 = DarkThemeKt.isSystemInDarkTheme($composer2, 0);
                    $dirty2 &= -15;
                } else {
                    darkTheme2 = darkTheme;
                }
                if (i2 != 0) {
                    $dirty = $dirty2;
                    darkTheme3 = darkTheme2;
                    dynamicColor2 = false;
                } else {
                    dynamicColor2 = dynamicColor;
                    $dirty = $dirty2;
                    darkTheme3 = darkTheme2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                darkTheme3 = darkTheme;
                dynamicColor2 = dynamicColor;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(23871156, $dirty, -1, "com.mouthpiece.app.ui.theme.MouthpieceTheme (Theme.kt:76)");
            }
            $composer2.startReplaceGroup(1465350263);
            ComposerKt.sourceInformation($composer2, "79@3045L7");
            if (!dynamicColor2 || Build.VERSION.SDK_INT < 31) {
                scheme = darkTheme3 ? DarkScheme : LightScheme;
            } else {
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = $composer2.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Context ctx = (Context) objConsume;
                scheme = darkTheme3 ? DynamicTonalPaletteKt.dynamicDarkColorScheme(ctx) : DynamicTonalPaletteKt.dynamicLightColorScheme(ctx);
            }
            $composer2.endReplaceGroup();
            MaterialThemeKt.MaterialTheme(scheme, null, MouthpieceTypography, content, $composer2, (($dirty << 3) & 7168) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            darkTheme4 = darkTheme3;
            dynamicColor3 = dynamicColor2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.MouthpieceTheme$lambda$0(darkTheme4, dynamicColor3, content, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
