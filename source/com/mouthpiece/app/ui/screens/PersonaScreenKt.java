package com.mouthpiece.app.ui.screens;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import androidx.profileinstaller.ProfileVerifier;
import com.mouthpiece.app.domain.Persona;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PersonaScreen.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001aC\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t\u001a1\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\f\u0010\u0010\u001a\u0004\u0018\u00010\bX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\bX\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\bX\u008a\u008e\u0002²\u0006\f\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u008a\u008e\u0002"}, d2 = {"PersonaScreen", "", "personas", "", "Lcom/mouthpiece/app/domain/Persona;", "onSave", "Lkotlin/Function1;", "onDelete", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "PersonaCard", "persona", "onEdit", "Lkotlin/Function0;", "(Lcom/mouthpiece/app/domain/Persona;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "editingId", HintConstants.AUTOFILL_HINT_NAME, "relation", "tone", "taboo", "pendingDelete"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PersonaScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaCard$lambda$45(Persona persona, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        PersonaCard(persona, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$44(List list, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        PersonaScreen(list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34271. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static final void PersonaScreen(java.util.List<com.mouthpiece.app.domain.Persona> r112, kotlin.jvm.functions.Function1<? super com.mouthpiece.app.domain.Persona, kotlin.Unit> r113, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r114, androidx.compose.runtime.Composer r115, int r116) {
        /*
            Method dump skipped, instruction units count: 3427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mouthpiece.app.ui.screens.PersonaScreenKt.PersonaScreen(java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PersonaScreen$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PersonaScreen$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PersonaScreen$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PersonaScreen$lambda$10(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String PersonaScreen$lambda$13(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final Persona PersonaScreen$lambda$16(MutableState<Persona> mutableState) {
        return mutableState.getValue();
    }

    private static final void PersonaScreen$reset(MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5) {
        mutableState.setValue(null);
        mutableState2.setValue("");
        mutableState3.setValue("");
        mutableState4.setValue("");
        mutableState5.setValue("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$19$lambda$18(MutableState $name$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $name$delegate.setValue(StringsKt.take(it, 12));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$21$lambda$20(MutableState $relation$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $relation$delegate.setValue(StringsKt.take(it, 12));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$23$lambda$22(MutableState $tone$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $tone$delegate.setValue(StringsKt.take(it, 30));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$25$lambda$24(MutableState $taboo$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $taboo$delegate.setValue(StringsKt.take(it, 30));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$30$lambda$27$lambda$26(Function1 $onSave, MutableState $name$delegate, MutableState $editingId$delegate, MutableState $relation$delegate, MutableState $tone$delegate, MutableState $taboo$delegate) {
        if (!StringsKt.isBlank(PersonaScreen$lambda$4($name$delegate))) {
            String strPersonaScreen$lambda$1 = PersonaScreen$lambda$1($editingId$delegate);
            if (strPersonaScreen$lambda$1 == null) {
                strPersonaScreen$lambda$1 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(strPersonaScreen$lambda$1, "toString(...)");
            }
            $onSave.invoke(new Persona(strPersonaScreen$lambda$1, StringsKt.trim((CharSequence) PersonaScreen$lambda$4($name$delegate)).toString(), StringsKt.trim((CharSequence) PersonaScreen$lambda$7($relation$delegate)).toString(), StringsKt.trim((CharSequence) PersonaScreen$lambda$10($tone$delegate)).toString(), StringsKt.trim((CharSequence) PersonaScreen$lambda$13($taboo$delegate)).toString()));
            PersonaScreen$reset($editingId$delegate, $name$delegate, $relation$delegate, $tone$delegate, $taboo$delegate);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$30$lambda$29$lambda$28(MutableState $editingId$delegate, MutableState $name$delegate, MutableState $relation$delegate, MutableState $tone$delegate, MutableState $taboo$delegate) {
        PersonaScreen$reset($editingId$delegate, $name$delegate, $relation$delegate, $tone$delegate, $taboo$delegate);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$36$lambda$35$lambda$32$lambda$31(Persona $persona, MutableState $editingId$delegate, MutableState $name$delegate, MutableState $relation$delegate, MutableState $tone$delegate, MutableState $taboo$delegate) {
        $editingId$delegate.setValue($persona.getId());
        $name$delegate.setValue($persona.getName());
        $relation$delegate.setValue($persona.getRelation());
        $tone$delegate.setValue($persona.getTone());
        $taboo$delegate.setValue($persona.getTaboo());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$36$lambda$35$lambda$34$lambda$33(Persona $persona, MutableState $pendingDelete$delegate) {
        $pendingDelete$delegate.setValue($persona);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$41$lambda$38$lambda$37(Function1 $onDelete, Persona $target) {
        $onDelete.invoke($target.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonaScreen$lambda$43$lambda$42$lambda$41$lambda$40$lambda$39(MutableState $pendingDelete$delegate) {
        $pendingDelete$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    private static final void PersonaCard(final Persona persona, final Function0<Unit> function0, final Function0<Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-588493912);
        ComposerKt.sourceInformation($composer2, "C(PersonaCard)P(2,1)205@7859L11,205@7809L70,206@7886L1439,202@7678L1647:PersonaScreen.kt#987w0c");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(persona) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-588493912, $dirty, -1, "com.mouthpiece.app.ui.screens.PersonaCard (PersonaScreen.kt:201)");
            }
            CardKt.ElevatedCard(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1030RoundedCornerShape0680j_4(Dp.m7016constructorimpl(20)), CardDefaults.INSTANCE.m1980elevatedCardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, ComposableLambdaKt.rememberComposableLambda(6162445, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.screens.PersonaScreenKt.PersonaCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope ElevatedCard, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function2;
                    Function0<ComposeUiNode> function3;
                    Intrinsics.checkNotNullParameter(ElevatedCard, "$this$ElevatedCard");
                    ComposerKt.sourceInformation($composer3, "C207@7896L1423:PersonaScreen.kt#987w0c");
                    if (($changed2 & 17) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(6162445, $changed2, -1, "com.mouthpiece.app.ui.screens.PersonaCard.<anonymous> (PersonaScreen.kt:207)");
                    }
                    Modifier modifierM739paddingqDBjuR0 = PaddingKt.m739paddingqDBjuR0(Modifier.INSTANCE, Dp.m7016constructorimpl(18), Dp.m7016constructorimpl(12), Dp.m7016constructorimpl(8), Dp.m7016constructorimpl(12));
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function0<Unit> function4 = function0;
                    Function0<Unit> function5 = function1;
                    Persona persona2 = persona;
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer3, modifierM739paddingqDBjuR0);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int i = ((((390 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function2 = constructor;
                        $composer3.createNode(function2);
                    } else {
                        function2 = constructor;
                        $composer3.useNode();
                    }
                    Composer composerM3831constructorimpl = Updater.m3831constructorimpl($composer3);
                    Updater.m3838setimpl(composerM3831constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3831constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3831constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = (i >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    int i3 = ((390 >> 6) & 112) | 6;
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -75293138, "C211@8081L898,232@8992L43,233@9048L261:PersonaScreen.kt#987w0c");
                    Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier($composer3, modifierWeight$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    int i4 = ((((0 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function3 = constructor2;
                        $composer3.createNode(function3);
                    } else {
                        function3 = constructor2;
                        $composer3.useNode();
                    }
                    Composer composerM3831constructorimpl2 = Updater.m3831constructorimpl($composer3);
                    Updater.m3838setimpl(composerM3831constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3838setimpl(composerM3831constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3831constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3831constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3831constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3831constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3838setimpl(composerM3831constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i5 = (i4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i6 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 180680469, "C214@8234L10,215@8300L11,212@8138L201:PersonaScreen.kt#987w0c");
                    TextKt.m2842Text4IGK_g(persona2.getDisplayName(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getTitleMedium(), $composer3, 0, 0, 65530);
                    $composer3.startReplaceGroup(-132712486);
                    ComposerKt.sourceInformation($composer3, "220@8514L10,221@8583L11,218@8409L224");
                    if (!StringsKt.isBlank(persona2.getTone())) {
                        TextKt.m2842Text4IGK_g("语气：" + persona2.getTone(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 0, 0, 65530);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-132702500);
                    ComposerKt.sourceInformation($composer3, "227@8828L10,228@8897L11,225@8722L225");
                    if (!StringsKt.isBlank(persona2.getTaboo())) {
                        TextKt.m2842Text4IGK_g("禁忌：" + persona2.getTaboo(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurfaceVariant(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelSmall(), $composer3, 0, 0, 65530);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ButtonKt.TextButton(function4, null, false, null, null, null, null, null, null, ComposableSingletons$PersonaScreenKt.INSTANCE.m7511getLambda$1573175092$app_debug(), $composer3, 805306368, 510);
                    IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$PersonaScreenKt.INSTANCE.m7513getLambda$2131432916$app_debug(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 24582, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.screens.PersonaScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PersonaScreenKt.PersonaCard$lambda$45(persona, function0, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
