package com.mouthpiece.app.vm;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import com.mouthpiece.app.ServiceLocator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AppViewModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/mouthpiece/app/vm/VmFactory;", "", "<init>", "()V", "main", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getMain", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "history", "getHistory", "persona", "getPersona", "settings", "getSettings", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VmFactory {
    public static final int $stable;
    public static final VmFactory INSTANCE = new VmFactory();
    private static final ViewModelProvider.Factory history;
    private static final ViewModelProvider.Factory main;
    private static final ViewModelProvider.Factory persona;
    private static final ViewModelProvider.Factory settings;

    private VmFactory() {
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function1() { // from class: com.mouthpiece.app.vm.VmFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VmFactory.main$lambda$1$lambda$0((CreationExtras) obj);
            }
        });
        main = initializerViewModelFactoryBuilder.build();
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder2 = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder2.addInitializer(Reflection.getOrCreateKotlinClass(HistoryViewModel.class), new Function1() { // from class: com.mouthpiece.app.vm.VmFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VmFactory.history$lambda$3$lambda$2((CreationExtras) obj);
            }
        });
        history = initializerViewModelFactoryBuilder2.build();
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder3 = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder3.addInitializer(Reflection.getOrCreateKotlinClass(PersonaViewModel.class), new Function1() { // from class: com.mouthpiece.app.vm.VmFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VmFactory.persona$lambda$5$lambda$4((CreationExtras) obj);
            }
        });
        persona = initializerViewModelFactoryBuilder3.build();
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder4 = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder4.addInitializer(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function1() { // from class: com.mouthpiece.app.vm.VmFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VmFactory.settings$lambda$7$lambda$6((CreationExtras) obj);
            }
        });
        settings = initializerViewModelFactoryBuilder4.build();
        $stable = 8;
    }

    public final ViewModelProvider.Factory getMain() {
        return main;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainViewModel main$lambda$1$lambda$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new MainViewModel(ServiceLocator.INSTANCE.getRepository(), ServiceLocator.INSTANCE.getSettings(), ServiceLocator.INSTANCE.getPersonas(), ServiceLocator.INSTANCE.getHistory(), ServiceLocator.INSTANCE.getCardRenderer(), ServiceLocator.INSTANCE.context());
    }

    public final ViewModelProvider.Factory getHistory() {
        return history;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HistoryViewModel history$lambda$3$lambda$2(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new HistoryViewModel(ServiceLocator.INSTANCE.getHistory());
    }

    public final ViewModelProvider.Factory getPersona() {
        return persona;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PersonaViewModel persona$lambda$5$lambda$4(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new PersonaViewModel(ServiceLocator.INSTANCE.getPersonas());
    }

    public final ViewModelProvider.Factory getSettings() {
        return settings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsViewModel settings$lambda$7$lambda$6(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        return new SettingsViewModel(ServiceLocator.INSTANCE.getSettings(), ServiceLocator.INSTANCE.getHistory(), ServiceLocator.INSTANCE.getPersonas());
    }
}
