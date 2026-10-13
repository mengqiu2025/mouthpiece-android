package com.mouthpiece.app.ui.screens;

import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.mouthpiece.app.domain.HistoryItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: HistoryScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class HistoryScreenKt$HistoryScreen$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $confirmClear$delegate;
    final /* synthetic */ List<HistoryItem> $items;

    HistoryScreenKt$HistoryScreen$1$1(List<HistoryItem> list, MutableState<Boolean> mutableState) {
        this.$items = list;
        this.$confirmClear$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState $confirmClear$delegate) {
        HistoryScreenKt.HistoryScreen$lambda$2($confirmClear$delegate, true);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C71@2865L23,71@2844L62:HistoryScreen.kt#987w0c");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1301161539, $changed, -1, "com.mouthpiece.app.ui.screens.HistoryScreen.<anonymous>.<anonymous> (HistoryScreen.kt:70)");
        }
        if (!this.$items.isEmpty()) {
            $composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer, "CC(remember):HistoryScreen.kt#9igjgp");
            final MutableState<Boolean> mutableState = this.$confirmClear$delegate;
            Object objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function0() { // from class: com.mouthpiece.app.ui.screens.HistoryScreenKt$HistoryScreen$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HistoryScreenKt$HistoryScreen$1$1.invoke$lambda$1$lambda$0(mutableState);
                    }
                };
                $composer.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$HistoryScreenKt.INSTANCE.getLambda$176775067$app_debug(), $composer, 805306374, 510);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
