package com.mouthpiece.app.vm;

import androidx.lifecycle.ViewModel;
import com.mouthpiece.app.data.PersonaStore;
import com.mouthpiece.app.domain.Persona;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AppViewModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/mouthpiece/app/vm/PersonaViewModel;", "Landroidx/lifecycle/ViewModel;", "personas", "Lcom/mouthpiece/app/data/PersonaStore;", "<init>", "(Lcom/mouthpiece/app/data/PersonaStore;)V", "items", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/mouthpiece/app/domain/Persona;", "getItems", "()Lkotlinx/coroutines/flow/StateFlow;", "save", "", "persona", "delete", "id", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonaViewModel extends ViewModel {
    public static final int $stable = 8;
    private final StateFlow<List<Persona>> items;
    private final PersonaStore personas;

    public PersonaViewModel(PersonaStore personas) {
        Intrinsics.checkNotNullParameter(personas, "personas");
        this.personas = personas;
        this.items = this.personas.getPersonas();
    }

    public final StateFlow<List<Persona>> getItems() {
        return this.items;
    }

    public final void save(Persona persona) {
        Intrinsics.checkNotNullParameter(persona, "persona");
        this.personas.upsert(persona);
    }

    public final void delete(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.personas.delete(id);
    }
}
