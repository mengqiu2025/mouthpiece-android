package com.mouthpiece.app.ui;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationBarItemDefaults;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.profileinstaller.ProfileVerifier;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.domain.HistoryItem;
import com.mouthpiece.app.domain.Persona;
import com.mouthpiece.app.domain.QuotaState;
import com.mouthpiece.app.ui.screens.HistoryScreenKt;
import com.mouthpiece.app.ui.screens.HomeScreenKt;
import com.mouthpiece.app.ui.screens.PersonaScreenKt;
import com.mouthpiece.app.ui.screens.ResultScreenKt;
import com.mouthpiece.app.ui.screens.SettingsScreenKt;
import com.mouthpiece.app.vm.HistoryViewModel;
import com.mouthpiece.app.vm.MainUiState;
import com.mouthpiece.app.vm.MainViewModel;
import com.mouthpiece.app.vm.PersonaViewModel;
import com.mouthpiece.app.vm.SettingsViewModel;
import com.mouthpiece.app.vm.VmFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0005X\u008a\u008e\u0002"}, d2 = {"AppBottomBar", "", "visible", "", "selected", "Lcom/mouthpiece/app/ui/Tab;", "onSelect", "Lkotlin/Function1;", "(ZLcom/mouthpiece/app/ui/Tab;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AppRoot", "sharedText", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlinx/coroutines/flow/Flow;Landroidx/compose/runtime/Composer;I)V", "app_debug", "mainState", "Lcom/mouthpiece/app/vm/MainUiState;", "historyItems", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "query", "onlyFavorite", "personas", "Lcom/mouthpiece/app/domain/Persona;", "settings", "Lcom/mouthpiece/app/domain/AppSettings;", "quota", "Lcom/mouthpiece/app/domain/QuotaState;", "tab"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AppRootKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBottomBar$lambda$0(boolean z, Tab tab, Function1 function1, int i, Composer composer, int i2) {
        AppBottomBar(z, tab, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppRoot$lambda$14(Flow flow, int i, Composer composer, int i2) {
        AppRoot(flow, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AppBottomBar(final boolean visible, final Tab selected, final Function1<? super Tab, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-803647069);
        ComposerKt.sourceInformation($composer2, "C(AppBottomBar)P(2,1)63@2540L11,63@2561L609,63@2495L675:AppRoot.kt#2aogo5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(visible) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selected.ordinal()) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-803647069, $dirty, -1, "com.mouthpiece.app.ui.AppBottomBar (AppRoot.kt:61)");
            }
            if (visible) {
                NavigationBarKt.m2422NavigationBarHsRjFd4(null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface(), 0L, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-713473947, true, new AnonymousClass1(selected, function1), $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 29);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.AppRootKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppRootKt.AppBottomBar$lambda$0(visible, selected, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.AppRootKt$AppBottomBar$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppRoot.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
        final /* synthetic */ Function1<Tab, Unit> $onSelect;
        final /* synthetic */ Tab $selected;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Tab tab, Function1<? super Tab, Unit> function1) {
            this.$selected = tab;
            this.$onSelect = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 $onSelect, Tab $item) {
            $onSelect.invoke($item);
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope $this$NavigationBar, Composer $composer, int $changed) {
            RowScope NavigationBar = $this$NavigationBar;
            Composer composer = $composer;
            Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
            ComposerKt.sourceInformation(composer, "C*67@2719L18,68@2766L52,69@2848L20,71@2991L11,72@3078L11,70@2925L203,65@2621L525:AppRoot.kt#2aogo5");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= composer.changed(NavigationBar) ? 4 : 2;
            }
            if (($dirty & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-713473947, $dirty, -1, "com.mouthpiece.app.ui.AppBottomBar.<anonymous> (AppRoot.kt:64)");
            }
            Iterable<Tab> entries = Tab.getEntries();
            Tab tab = this.$selected;
            final Function1<Tab, Unit> function1 = this.$onSelect;
            for (final Tab tab2 : entries) {
                boolean z = tab == tab2;
                composer.startReplaceGroup(-1633490746);
                ComposerKt.sourceInformation(composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changed(tab2.ordinal());
                Object objRememberedValue = $composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function0() { // from class: com.mouthpiece.app.ui.AppRootKt$AppBottomBar$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppRootKt.AnonymousClass1.invoke$lambda$2$lambda$1$lambda$0(function1, tab2);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                    objRememberedValue = obj;
                }
                composer.endReplaceGroup();
                int $dirty2 = $dirty;
                composer = $composer;
                NavigationBarKt.NavigationBarItem(NavigationBar, z, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(1094886728, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.AppRootKt$AppBottomBar$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C68@2768L48:AppRoot.kt#2aogo5");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1094886728, $changed2, -1, "com.mouthpiece.app.ui.AppBottomBar.<anonymous>.<anonymous>.<anonymous> (AppRoot.kt:68)");
                        }
                        IconKt.m2299Iconww6aTOc(tab2.getIcon(), tab2.getLabel(), (Modifier) null, 0L, $composer2, 0, 12);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), null, false, ComposableLambdaKt.rememberComposableLambda(-1569225883, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.AppRootKt$AppBottomBar$1$1$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C69@2850L16:AppRoot.kt#2aogo5");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1569225883, $changed2, -1, "com.mouthpiece.app.ui.AppBottomBar.<anonymous>.<anonymous>.<anonymous> (AppRoot.kt:69)");
                        }
                        TextKt.m2842Text4IGK_g(tab2.getLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), false, NavigationBarItemDefaults.INSTANCE.m2420colors69fazGs(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer(), 0L, 0L, 0L, 0L, $composer, NavigationBarItemDefaults.$stable << 21, 122), null, composer, ($dirty2 & 14) | 1575936, 344);
                NavigationBar = $this$NavigationBar;
                $dirty = $dirty2;
                tab = tab;
                function1 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final void AppRoot(final Flow<String> sharedText, Composer $composer, final int $changed) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        CreationExtras.Empty defaultViewModelCreationExtras2;
        CreationExtras.Empty defaultViewModelCreationExtras3;
        CreationExtras.Empty defaultViewModelCreationExtras4;
        Intrinsics.checkNotNullParameter(sharedText, "sharedText");
        Composer $composer2 = $composer.startRestartGroup(367272237);
        ComposerKt.sourceInformation($composer2, "C(AppRoot)86@3342L35,87@3423L38,88@3507L38,89@3593L39,91@3672L29,92@3749L29,93@3819L29,94@3903L29,95@3976L29,96@4050L29,97@4121L29,99@4167L41,100@4237L32,104@4382L130,104@4361L151,111@4552L150,111@4518L184,120@4800L11,122@4904L172,121@4847L35,129@5083L3294,118@4708L3669:AppRoot.kt#2aogo5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(sharedText) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(367272237, $dirty2, -1, "com.mouthpiece.app.ui.AppRoot (AppRoot.kt:85)");
            }
            ViewModelProvider.Factory main = VmFactory.INSTANCE.getMain();
            ComposerKt.sourceInformationMarkerStart($composer2, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(MainViewModel.class), current, (String) null, main, defaultViewModelCreationExtras, $composer2, ((0 << 3) & 896) | ((0 << 3) & 112) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            MainViewModel mainViewModel = (MainViewModel) viewModel;
            ViewModelProvider.Factory history = VmFactory.INSTANCE.getHistory();
            ComposerKt.sourceInformationMarkerStart($composer2, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current2 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current2 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current2 instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras2 = ((HasDefaultViewModelProviderFactory) current2).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras2 = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel2 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(HistoryViewModel.class), current2, (String) null, history, defaultViewModelCreationExtras2, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            HistoryViewModel historyViewModel = (HistoryViewModel) viewModel2;
            ViewModelProvider.Factory persona = VmFactory.INSTANCE.getPersona();
            ComposerKt.sourceInformationMarkerStart($composer2, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current3 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current3 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current3 instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras3 = ((HasDefaultViewModelProviderFactory) current3).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras3 = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel3 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PersonaViewModel.class), current3, (String) null, persona, defaultViewModelCreationExtras3, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PersonaViewModel personaViewModel = (PersonaViewModel) viewModel3;
            ViewModelProvider.Factory settings = VmFactory.INSTANCE.getSettings();
            ComposerKt.sourceInformationMarkerStart($composer2, 1729797275, "CC(viewModel)P(3,2,1)56@2573L7,67@2980L63:ViewModel.kt#3tja67");
            ViewModelStoreOwner current4 = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current4 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current4 instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras4 = ((HasDefaultViewModelProviderFactory) current4).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras4 = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel4 = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(SettingsViewModel.class), current4, (String) null, settings, defaultViewModelCreationExtras4, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896) | ((0 << 3) & 7168) | ((0 << 3) & 57344), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SettingsViewModel settingsViewModel = (SettingsViewModel) viewModel4;
            State mainState$delegate = FlowExtKt.collectAsStateWithLifecycle(mainViewModel.getUi(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State historyItems$delegate = FlowExtKt.collectAsStateWithLifecycle(historyViewModel.getItems(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State query$delegate = FlowExtKt.collectAsStateWithLifecycle(historyViewModel.getQuery(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State onlyFavorite$delegate = FlowExtKt.collectAsStateWithLifecycle(historyViewModel.getOnlyFavorite(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State personas$delegate = FlowExtKt.collectAsStateWithLifecycle(personaViewModel.getItems(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State settings$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            State quota$delegate = FlowExtKt.collectAsStateWithLifecycle(settingsViewModel.getQuota(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer2, 0, 7);
            $composer2.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppRoot.kt#9igjgp");
            Object objRememberedValue = $composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Tab.GENERATE, null, 2, null);
                $composer2.updateRememberedValue(objMutableStateOf$default);
                objRememberedValue = objMutableStateOf$default;
            }
            MutableState tab$delegate = (MutableState) objRememberedValue;
            $composer2.endReplaceGroup();
            $composer2.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppRoot.kt#9igjgp");
            Object objRememberedValue2 = $composer2.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Object snackbarHostState = new SnackbarHostState();
                $composer2.updateRememberedValue(snackbarHostState);
                objRememberedValue2 = snackbarHostState;
            }
            final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue2;
            $composer2.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            $composer2.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppRoot.kt#9igjgp");
            boolean zChangedInstance = $composer2.changedInstance(sharedText) | $composer2.changedInstance(mainViewModel);
            Object objRememberedValue3 = $composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                Object obj = (Function2) new AppRootKt$AppRoot$1$1(sharedText, mainViewModel, tab$delegate, null);
                $composer2.updateRememberedValue(obj);
                objRememberedValue3 = obj;
            }
            $composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, $composer2, 6);
            String message = AppRoot$lambda$1(mainState$delegate).getMessage();
            $composer2.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation($composer2, "CC(remember):AppRoot.kt#9igjgp");
            boolean zChanged = $composer2.changed(mainState$delegate) | $composer2.changedInstance(mainViewModel);
            Object objRememberedValue4 = $composer2.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Object obj2 = (Function2) new AppRootKt$AppRoot$2$1(mainState$delegate, snackbarHostState2, mainViewModel, null);
                $composer2.updateRememberedValue(obj2);
                objRememberedValue4 = obj2;
            }
            $composer2.endReplaceGroup();
            EffectsKt.LaunchedEffect(message, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, $composer2, 0);
            ScaffoldKt.m2557ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(-467805902, true, new AnonymousClass3(mainState$delegate, tab$delegate), $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-347686029, true, new Function2<Composer, Integer, Unit>() { // from class: com.mouthpiece.app.ui.AppRootKt.AppRoot.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C121@4849L31:AppRoot.kt#2aogo5");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-347686029, $changed2, -1, "com.mouthpiece.app.ui.AppRoot.<anonymous> (AppRoot.kt:121)");
                    }
                    SnackbarHostKt.SnackbarHost(snackbarHostState2, null, null, $composer3, 6, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, 0, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getBackground(), 0L, null, ComposableLambdaKt.rememberComposableLambda(111207548, true, new AnonymousClass5(mainViewModel, historyViewModel, personaViewModel, settingsViewModel, mainState$delegate, tab$delegate, personas$delegate, historyItems$delegate, query$delegate, onlyFavorite$delegate, settings$delegate, quota$delegate), $composer2, 54), $composer2, 805309830, 434);
            $composer2 = $composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.mouthpiece.app.ui.AppRootKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return AppRootKt.AppRoot$lambda$14(sharedText, $changed, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainUiState AppRoot$lambda$1(State<MainUiState> state) {
        return (MainUiState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<HistoryItem> AppRoot$lambda$2(State<? extends List<HistoryItem>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AppRoot$lambda$3(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AppRoot$lambda$4(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Persona> AppRoot$lambda$5(State<? extends List<Persona>> state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings AppRoot$lambda$6(State<AppSettings> state) {
        return (AppSettings) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuotaState AppRoot$lambda$7(State<QuotaState> state) {
        return (QuotaState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AppRoot$lambda$10(MutableState<Tab> mutableState, Tab tab) {
        mutableState.setValue(tab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tab AppRoot$lambda$9(MutableState<Tab> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.AppRootKt$AppRoot$3, reason: invalid class name */
    /* JADX INFO: compiled from: AppRoot.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ State<MainUiState> $mainState$delegate;
        final /* synthetic */ MutableState<Tab> $tab$delegate;

        AnonymousClass3(State<MainUiState> state, MutableState<Tab> mutableState) {
            this.$mainState$delegate = state;
            this.$tab$delegate = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C126@5040L12,123@4918L148:AppRoot.kt#2aogo5");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-467805902, $changed, -1, "com.mouthpiece.app.ui.AppRoot.<anonymous> (AppRoot.kt:123)");
            }
            boolean z = !AppRootKt.AppRoot$lambda$1(this.$mainState$delegate).getShowResult();
            Tab tabAppRoot$lambda$9 = AppRootKt.AppRoot$lambda$9(this.$tab$delegate);
            $composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
            final MutableState<Tab> mutableState = this.$tab$delegate;
            Object objRememberedValue = $composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object obj = new Function1() { // from class: com.mouthpiece.app.ui.AppRootKt$AppRoot$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AppRootKt.AnonymousClass3.invoke$lambda$1$lambda$0(mutableState, (Tab) obj2);
                    }
                };
                $composer.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            $composer.endReplaceGroup();
            AppRootKt.AppBottomBar(z, tabAppRoot$lambda$9, (Function1) objRememberedValue, $composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(MutableState $tab$delegate, Tab it) {
            Intrinsics.checkNotNullParameter(it, "it");
            AppRootKt.AppRoot$lambda$10($tab$delegate, it);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.ui.AppRootKt$AppRoot$5, reason: invalid class name */
    /* JADX INFO: compiled from: AppRoot.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass5 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ State<List<HistoryItem>> $historyItems$delegate;
        final /* synthetic */ HistoryViewModel $historyViewModel;
        final /* synthetic */ State<MainUiState> $mainState$delegate;
        final /* synthetic */ MainViewModel $mainViewModel;
        final /* synthetic */ State<Boolean> $onlyFavorite$delegate;
        final /* synthetic */ PersonaViewModel $personaViewModel;
        final /* synthetic */ State<List<Persona>> $personas$delegate;
        final /* synthetic */ State<String> $query$delegate;
        final /* synthetic */ State<QuotaState> $quota$delegate;
        final /* synthetic */ State<AppSettings> $settings$delegate;
        final /* synthetic */ SettingsViewModel $settingsViewModel;
        final /* synthetic */ MutableState<Tab> $tab$delegate;

        /* JADX INFO: renamed from: com.mouthpiece.app.ui.AppRootKt$AppRoot$5$WhenMappings */
        /* JADX INFO: compiled from: AppRoot.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Tab.values().length];
                try {
                    iArr[Tab.GENERATE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Tab.HISTORY.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Tab.PERSONA.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Tab.SETTINGS.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(MainViewModel mainViewModel, HistoryViewModel historyViewModel, PersonaViewModel personaViewModel, SettingsViewModel settingsViewModel, State<MainUiState> state, MutableState<Tab> mutableState, State<? extends List<Persona>> state2, State<? extends List<HistoryItem>> state3, State<String> state4, State<Boolean> state5, State<AppSettings> state6, State<QuotaState> state7) {
            this.$mainViewModel = mainViewModel;
            this.$historyViewModel = historyViewModel;
            this.$personaViewModel = personaViewModel;
            this.$settingsViewModel = settingsViewModel;
            this.$mainState$delegate = state;
            this.$tab$delegate = mutableState;
            this.$personas$delegate = state2;
            this.$historyItems$delegate = state3;
            this.$query$delegate = state4;
            this.$onlyFavorite$delegate = state5;
            this.$settings$delegate = state6;
            this.$quota$delegate = state7;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$33$lambda$18$lambda$17(MainViewModel $mainViewModel, MutableState $tab$delegate, HistoryItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            $mainViewModel.onIncomingChange(item.getIncoming());
            AppRootKt.AppRoot$lambda$10($tab$delegate, Tab.GENERATE);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$33$lambda$30$lambda$29(SettingsViewModel $settingsViewModel) {
            SettingsViewModel.previewPush$default($settingsViewModel, null, 1, null);
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues innerPadding, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
            ComposerKt.sourceInformation($composer, "C130@5109L3262:AppRoot.kt#2aogo5");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(innerPadding) ? 4 : 2;
            }
            if (($dirty & 19) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(111207548, $dirty, -1, "com.mouthpiece.app.ui.AppRoot.<anonymous> (AppRoot.kt:130)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding);
            final MainViewModel mainViewModel = this.$mainViewModel;
            Object obj = this.$historyViewModel;
            Object obj2 = this.$personaViewModel;
            final SettingsViewModel settingsViewModel = this.$settingsViewModel;
            State<MainUiState> state = this.$mainState$delegate;
            final MutableState<Tab> mutableState = this.$tab$delegate;
            State<List<Persona>> state2 = this.$personas$delegate;
            State<List<HistoryItem>> state3 = this.$historyItems$delegate;
            State<String> state4 = this.$query$delegate;
            State<Boolean> state5 = this.$onlyFavorite$delegate;
            State<AppSettings> state6 = this.$settings$delegate;
            State<QuotaState> state7 = this.$quota$delegate;
            ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier($composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i = ((((0 << 3) & 112) << 6) & 896) | 6;
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
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -2122870980, "C:AppRoot.kt#2aogo5");
            if (AppRootKt.AppRoot$lambda$1(state).getShowResult()) {
                $composer.startReplaceGroup(-2122929726);
                ComposerKt.sourceInformation($composer, "138@5366L25,139@5422L24,140@5481L28,141@5541L25,142@5603L25,136@5284L362");
                MainUiState mainUiStateAppRoot$lambda$1 = AppRootKt.AppRoot$lambda$1(state);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChangedInstance = $composer.changedInstance(mainViewModel);
                Object objRememberedValue = $composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Object obj3 = (KFunction) new AppRootKt$AppRoot$5$1$1$1(mainViewModel);
                    $composer.updateRememberedValue(obj3);
                    objRememberedValue = obj3;
                }
                $composer.endReplaceGroup();
                Function0 function1 = (Function0) ((KFunction) objRememberedValue);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChangedInstance2 = $composer.changedInstance(mainViewModel);
                Object objRememberedValue2 = $composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    Object obj4 = (KFunction) new AppRootKt$AppRoot$5$1$2$1(mainViewModel);
                    $composer.updateRememberedValue(obj4);
                    objRememberedValue2 = obj4;
                }
                $composer.endReplaceGroup();
                Function1 function2 = (Function1) ((KFunction) objRememberedValue2);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChangedInstance3 = $composer.changedInstance(mainViewModel);
                Object objRememberedValue3 = $composer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    Object obj5 = (KFunction) new AppRootKt$AppRoot$5$1$3$1(mainViewModel);
                    $composer.updateRememberedValue(obj5);
                    objRememberedValue3 = obj5;
                }
                $composer.endReplaceGroup();
                Function1 function3 = (Function1) ((KFunction) objRememberedValue3);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChangedInstance4 = $composer.changedInstance(mainViewModel);
                Object objRememberedValue4 = $composer.rememberedValue();
                if (zChangedInstance4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    Object obj6 = (KFunction) new AppRootKt$AppRoot$5$1$4$1(mainViewModel);
                    $composer.updateRememberedValue(obj6);
                    objRememberedValue4 = obj6;
                }
                $composer.endReplaceGroup();
                Function1 function4 = (Function1) ((KFunction) objRememberedValue4);
                $composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                boolean zChangedInstance5 = $composer.changedInstance(mainViewModel);
                Object objRememberedValue5 = $composer.rememberedValue();
                if (zChangedInstance5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    Object obj7 = (KFunction) new AppRootKt$AppRoot$5$1$5$1(mainViewModel);
                    $composer.updateRememberedValue(obj7);
                    objRememberedValue5 = obj7;
                }
                $composer.endReplaceGroup();
                ResultScreenKt.ResultScreen(mainUiStateAppRoot$lambda$1, function1, function2, function3, function4, (Function0) ((KFunction) objRememberedValue5), $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-2122461595);
                ComposerKt.sourceInformation($composer, "");
                switch (WhenMappings.$EnumSwitchMapping$0[AppRootKt.AppRoot$lambda$9(mutableState).ordinal()]) {
                    case 1:
                        $composer.startReplaceGroup(70080902);
                        ComposerKt.sourceInformation($composer, "149@5876L31,150@5949L28,151@6019L26,152@6090L31,153@6167L32,154@6243L30,155@6312L23,146@5733L624");
                        MainUiState mainUiStateAppRoot$lambda$2 = AppRootKt.AppRoot$lambda$1(state);
                        List listAppRoot$lambda$5 = AppRootKt.AppRoot$lambda$5(state2);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance6 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue6 = $composer.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            Object obj8 = (KFunction) new AppRootKt$AppRoot$5$1$6$1(mainViewModel);
                            $composer.updateRememberedValue(obj8);
                            objRememberedValue6 = obj8;
                        }
                        $composer.endReplaceGroup();
                        Function1 function5 = (Function1) ((KFunction) objRememberedValue6);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance7 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue7 = $composer.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            Object obj9 = (KFunction) new AppRootKt$AppRoot$5$1$7$1(mainViewModel);
                            $composer.updateRememberedValue(obj9);
                            objRememberedValue7 = obj9;
                        }
                        $composer.endReplaceGroup();
                        Function1 function6 = (Function1) ((KFunction) objRememberedValue7);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance8 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue8 = $composer.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            Object obj10 = (KFunction) new AppRootKt$AppRoot$5$1$8$1(mainViewModel);
                            $composer.updateRememberedValue(obj10);
                            objRememberedValue8 = obj10;
                        }
                        $composer.endReplaceGroup();
                        Function1 function7 = (Function1) ((KFunction) objRememberedValue8);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance9 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue9 = $composer.rememberedValue();
                        if (zChangedInstance9 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                            Object obj11 = (KFunction) new AppRootKt$AppRoot$5$1$9$1(mainViewModel);
                            $composer.updateRememberedValue(obj11);
                            objRememberedValue9 = obj11;
                        }
                        $composer.endReplaceGroup();
                        Function1 function8 = (Function1) ((KFunction) objRememberedValue9);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance10 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue10 = $composer.rememberedValue();
                        if (zChangedInstance10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            Object obj12 = (KFunction) new AppRootKt$AppRoot$5$1$10$1(mainViewModel);
                            $composer.updateRememberedValue(obj12);
                            objRememberedValue10 = obj12;
                        }
                        $composer.endReplaceGroup();
                        Function1 function9 = (Function1) ((KFunction) objRememberedValue10);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance11 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue11 = $composer.rememberedValue();
                        if (zChangedInstance11 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            Object obj13 = (KFunction) new AppRootKt$AppRoot$5$1$11$1(mainViewModel);
                            $composer.updateRememberedValue(obj13);
                            objRememberedValue11 = obj13;
                        }
                        $composer.endReplaceGroup();
                        Function1 function10 = (Function1) ((KFunction) objRememberedValue11);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance12 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue12 = $composer.rememberedValue();
                        if (zChangedInstance12 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            Object obj14 = (KFunction) new AppRootKt$AppRoot$5$1$12$1(mainViewModel);
                            $composer.updateRememberedValue(obj14);
                            objRememberedValue12 = obj14;
                        }
                        $composer.endReplaceGroup();
                        HomeScreenKt.HomeScreen(mainUiStateAppRoot$lambda$2, listAppRoot$lambda$5, function5, function6, function7, function8, function9, function10, (Function0) ((KFunction) objRememberedValue12), $composer, 0);
                        $composer.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                        break;
                    case 2:
                        $composer.startReplaceGroup(70102152);
                        ComposerKt.sourceInformation($composer, "162@6587L31,163@6669L36,164@6750L32,165@6819L24,166@6879L23,167@6938L156,158@6394L722");
                        List listAppRoot$lambda$2 = AppRootKt.AppRoot$lambda$2(state3);
                        String strAppRoot$lambda$3 = AppRootKt.AppRoot$lambda$3(state4);
                        boolean zAppRoot$lambda$4 = AppRootKt.AppRoot$lambda$4(state5);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance13 = $composer.changedInstance(obj);
                        Object objRememberedValue13 = $composer.rememberedValue();
                        if (zChangedInstance13 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            Object obj15 = (KFunction) new AppRootKt$AppRoot$5$1$13$1(obj);
                            $composer.updateRememberedValue(obj15);
                            objRememberedValue13 = obj15;
                        }
                        $composer.endReplaceGroup();
                        Function1 function11 = (Function1) ((KFunction) objRememberedValue13);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance14 = $composer.changedInstance(obj);
                        Object objRememberedValue14 = $composer.rememberedValue();
                        if (zChangedInstance14 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                            Object obj16 = (KFunction) new AppRootKt$AppRoot$5$1$14$1(obj);
                            $composer.updateRememberedValue(obj16);
                            objRememberedValue14 = obj16;
                        }
                        $composer.endReplaceGroup();
                        Function0 function12 = (Function0) ((KFunction) objRememberedValue14);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance15 = $composer.changedInstance(obj);
                        Object objRememberedValue15 = $composer.rememberedValue();
                        if (zChangedInstance15 || objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                            Object obj17 = (KFunction) new AppRootKt$AppRoot$5$1$15$1(obj);
                            $composer.updateRememberedValue(obj17);
                            objRememberedValue15 = obj17;
                        }
                        $composer.endReplaceGroup();
                        Function1 function13 = (Function1) ((KFunction) objRememberedValue15);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance16 = $composer.changedInstance(obj);
                        Object objRememberedValue16 = $composer.rememberedValue();
                        if (zChangedInstance16 || objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            Object obj18 = (KFunction) new AppRootKt$AppRoot$5$1$16$1(obj);
                            $composer.updateRememberedValue(obj18);
                            objRememberedValue16 = obj18;
                        }
                        $composer.endReplaceGroup();
                        Function1 function14 = (Function1) ((KFunction) objRememberedValue16);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance17 = $composer.changedInstance(obj);
                        Object objRememberedValue17 = $composer.rememberedValue();
                        if (zChangedInstance17 || objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                            Object obj19 = (KFunction) new AppRootKt$AppRoot$5$1$17$1(obj);
                            $composer.updateRememberedValue(obj19);
                            objRememberedValue17 = obj19;
                        }
                        $composer.endReplaceGroup();
                        Function0 function15 = (Function0) ((KFunction) objRememberedValue17);
                        $composer.startReplaceGroup(-1633490746);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance18 = $composer.changedInstance(mainViewModel);
                        Object objRememberedValue18 = $composer.rememberedValue();
                        if (zChangedInstance18 || objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                            Object obj20 = new Function1() { // from class: com.mouthpiece.app.ui.AppRootKt$AppRoot$5$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj21) {
                                    return AppRootKt.AnonymousClass5.invoke$lambda$33$lambda$18$lambda$17(mainViewModel, mutableState, (HistoryItem) obj21);
                                }
                            };
                            $composer.updateRememberedValue(obj20);
                            objRememberedValue18 = obj20;
                        }
                        $composer.endReplaceGroup();
                        HistoryScreenKt.HistoryScreen(listAppRoot$lambda$2, strAppRoot$lambda$3, zAppRoot$lambda$4, function11, function12, function13, function14, function15, (Function1) objRememberedValue18, $composer, 0);
                        $composer.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                        break;
                    case 3:
                        $composer.startReplaceGroup(70125916);
                        ComposerKt.sourceInformation($composer, "175@7246L22,176@7305L24,173@7153L198");
                        List listAppRoot$lambda$6 = AppRootKt.AppRoot$lambda$5(state2);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance19 = $composer.changedInstance(obj2);
                        Object objRememberedValue19 = $composer.rememberedValue();
                        if (zChangedInstance19 || objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                            Object obj21 = (KFunction) new AppRootKt$AppRoot$5$1$19$1(obj2);
                            $composer.updateRememberedValue(obj21);
                            objRememberedValue19 = obj21;
                        }
                        $composer.endReplaceGroup();
                        Function1 function16 = (Function1) ((KFunction) objRememberedValue19);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance20 = $composer.changedInstance(obj2);
                        Object objRememberedValue20 = $composer.rememberedValue();
                        if (zChangedInstance20 || objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
                            Object obj22 = (KFunction) new AppRootKt$AppRoot$5$1$20$1(obj2);
                            $composer.updateRememberedValue(obj22);
                            objRememberedValue20 = obj22;
                        }
                        $composer.endReplaceGroup();
                        PersonaScreenKt.PersonaScreen(listAppRoot$lambda$6, function16, (Function1) ((KFunction) objRememberedValue20), $composer, 0);
                        $composer.endReplaceGroup();
                        Unit unit3 = Unit.INSTANCE;
                        break;
                    case 4:
                        $composer.startReplaceGroup(70134210);
                        ComposerKt.sourceInformation($composer, "182@7531L29,183@7603L28,184@7673L27,185@7746L31,186@7823L31,187@7894L25,188@7962L35,189@8044L32,190@8118L35,191@8196L31,192@8273L34,179@7389L940");
                        AppSettings appSettingsAppRoot$lambda$6 = AppRootKt.AppRoot$lambda$6(state6);
                        QuotaState quotaStateAppRoot$lambda$7 = AppRootKt.AppRoot$lambda$7(state7);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance21 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue21 = $composer.rememberedValue();
                        if (zChangedInstance21 || objRememberedValue21 == Composer.INSTANCE.getEmpty()) {
                            Object obj23 = (KFunction) new AppRootKt$AppRoot$5$1$21$1(settingsViewModel);
                            $composer.updateRememberedValue(obj23);
                            objRememberedValue21 = obj23;
                        }
                        $composer.endReplaceGroup();
                        Function1 function17 = (Function1) ((KFunction) objRememberedValue21);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance22 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue22 = $composer.rememberedValue();
                        if (zChangedInstance22 || objRememberedValue22 == Composer.INSTANCE.getEmpty()) {
                            Object obj24 = (KFunction) new AppRootKt$AppRoot$5$1$22$1(settingsViewModel);
                            $composer.updateRememberedValue(obj24);
                            objRememberedValue22 = obj24;
                        }
                        $composer.endReplaceGroup();
                        Function1 function18 = (Function1) ((KFunction) objRememberedValue22);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance23 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue23 = $composer.rememberedValue();
                        if (zChangedInstance23 || objRememberedValue23 == Composer.INSTANCE.getEmpty()) {
                            Object obj25 = (KFunction) new AppRootKt$AppRoot$5$1$23$1(settingsViewModel);
                            $composer.updateRememberedValue(obj25);
                            objRememberedValue23 = obj25;
                        }
                        $composer.endReplaceGroup();
                        Function1 function19 = (Function1) ((KFunction) objRememberedValue23);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance24 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue24 = $composer.rememberedValue();
                        if (zChangedInstance24 || objRememberedValue24 == Composer.INSTANCE.getEmpty()) {
                            Object obj26 = (KFunction) new AppRootKt$AppRoot$5$1$24$1(settingsViewModel);
                            $composer.updateRememberedValue(obj26);
                            objRememberedValue24 = obj26;
                        }
                        $composer.endReplaceGroup();
                        Function1 function20 = (Function1) ((KFunction) objRememberedValue24);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance25 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue25 = $composer.rememberedValue();
                        if (zChangedInstance25 || objRememberedValue25 == Composer.INSTANCE.getEmpty()) {
                            Object obj27 = (KFunction) new AppRootKt$AppRoot$5$1$25$1(settingsViewModel);
                            $composer.updateRememberedValue(obj27);
                            objRememberedValue25 = obj27;
                        }
                        $composer.endReplaceGroup();
                        Function1 function21 = (Function1) ((KFunction) objRememberedValue25);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance26 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue26 = $composer.rememberedValue();
                        if (zChangedInstance26 || objRememberedValue26 == Composer.INSTANCE.getEmpty()) {
                            Object obj28 = (KFunction) new AppRootKt$AppRoot$5$1$26$1(settingsViewModel);
                            $composer.updateRememberedValue(obj28);
                            objRememberedValue26 = obj28;
                        }
                        $composer.endReplaceGroup();
                        Function1 function22 = (Function1) ((KFunction) objRememberedValue26);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance27 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue27 = $composer.rememberedValue();
                        if (zChangedInstance27 || objRememberedValue27 == Composer.INSTANCE.getEmpty()) {
                            Object obj29 = (KFunction) new AppRootKt$AppRoot$5$1$27$1(settingsViewModel);
                            $composer.updateRememberedValue(obj29);
                            objRememberedValue27 = obj29;
                        }
                        $composer.endReplaceGroup();
                        Function1 function23 = (Function1) ((KFunction) objRememberedValue27);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance28 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue28 = $composer.rememberedValue();
                        if (zChangedInstance28 || objRememberedValue28 == Composer.INSTANCE.getEmpty()) {
                            Object obj30 = (KFunction) new AppRootKt$AppRoot$5$1$28$1(settingsViewModel);
                            $composer.updateRememberedValue(obj30);
                            objRememberedValue28 = obj30;
                        }
                        $composer.endReplaceGroup();
                        Function1 function24 = (Function1) ((KFunction) objRememberedValue28);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance29 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue29 = $composer.rememberedValue();
                        if (zChangedInstance29 || objRememberedValue29 == Composer.INSTANCE.getEmpty()) {
                            Object obj31 = new Function0() { // from class: com.mouthpiece.app.ui.AppRootKt$AppRoot$5$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AppRootKt.AnonymousClass5.invoke$lambda$33$lambda$30$lambda$29(settingsViewModel);
                                }
                            };
                            $composer.updateRememberedValue(obj31);
                            objRememberedValue29 = obj31;
                        }
                        Function0 function25 = (Function0) objRememberedValue29;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance30 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue30 = $composer.rememberedValue();
                        if (zChangedInstance30 || objRememberedValue30 == Composer.INSTANCE.getEmpty()) {
                            Object obj32 = (KFunction) new AppRootKt$AppRoot$5$1$30$1(settingsViewModel);
                            $composer.updateRememberedValue(obj32);
                            objRememberedValue30 = obj32;
                        }
                        $composer.endReplaceGroup();
                        Function0 function26 = (Function0) ((KFunction) objRememberedValue30);
                        $composer.startReplaceGroup(5004770);
                        ComposerKt.sourceInformation($composer, "CC(remember):AppRoot.kt#9igjgp");
                        boolean zChangedInstance31 = $composer.changedInstance(settingsViewModel);
                        Object objRememberedValue31 = $composer.rememberedValue();
                        if (zChangedInstance31 || objRememberedValue31 == Composer.INSTANCE.getEmpty()) {
                            Object obj33 = (KFunction) new AppRootKt$AppRoot$5$1$31$1(settingsViewModel);
                            $composer.updateRememberedValue(obj33);
                            objRememberedValue31 = obj33;
                        }
                        $composer.endReplaceGroup();
                        SettingsScreenKt.SettingsScreen(appSettingsAppRoot$lambda$6, quotaStateAppRoot$lambda$7, function17, function18, function19, function20, function21, function22, function23, function24, function25, function26, (Function0) ((KFunction) objRememberedValue31), $composer, 0, 0);
                        $composer.endReplaceGroup();
                        Unit unit4 = Unit.INSTANCE;
                        break;
                    default:
                        $composer.startReplaceGroup(70081373);
                        $composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                }
                $composer.endReplaceGroup();
            }
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
    }
}
