package com.mouthpiece.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import com.mouthpiece.app.domain.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Stores.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001b\u001a\u00020\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/mouthpiece/app/data/PersonaStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "_personas", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/mouthpiece/app/domain/Persona;", "personas", "Lkotlinx/coroutines/flow/StateFlow;", "getPersonas", "()Lkotlinx/coroutines/flow/StateFlow;", "read", "write", "", "list", "upsert", "persona", "delete", "id", "", "find", "clear", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonaStore {

    @Deprecated
    public static final String KEY = "personas_json";
    private final MutableStateFlow<List<Persona>> _personas;
    private final StateFlow<List<Persona>> personas;
    private final SharedPreferences prefs;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PersonaStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences("mouthpiece_personas", 0);
        this._personas = StateFlowKt.MutableStateFlow(read());
        this.personas = FlowKt.asStateFlow(this._personas);
    }

    public final StateFlow<List<Persona>> getPersonas() {
        return this.personas;
    }

    private final List<Persona> read() {
        Object objM7545constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            PersonaStore personaStore = this;
            String string = personaStore.prefs.getString(KEY, null);
            if (string == null) {
                return CollectionsKt.emptyList();
            }
            JSONArray jSONArray = new JSONArray(string);
            Iterable iterableUntil = RangesKt.until(0, jSONArray.length());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableUntil, 10));
            Iterator<Integer> it = iterableUntil.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                PersonaStore personaStore2 = personaStore;
                String strOptString = jSONObject.optString("id");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = jSONObject.optString(HintConstants.AUTOFILL_HINT_NAME);
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strOptString3 = jSONObject.optString("relation");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                String strOptString4 = jSONObject.optString("tone");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                String strOptString5 = jSONObject.optString("taboo");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                arrayList.add(new Persona(strOptString, strOptString2, strOptString3, strOptString4, strOptString5));
                personaStore = personaStore2;
            }
            objM7545constructorimpl = Result.m7545constructorimpl((List) arrayList);
            List listEmptyList = CollectionsKt.emptyList();
            if (Result.m7551isFailureimpl(objM7545constructorimpl)) {
                objM7545constructorimpl = listEmptyList;
            }
            return (List) objM7545constructorimpl;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void write(List<Persona> list) {
        JSONArray array = new JSONArray();
        for (Persona persona : list) {
            array.put(new JSONObject().put("id", persona.getId()).put(HintConstants.AUTOFILL_HINT_NAME, persona.getName()).put("relation", persona.getRelation()).put("tone", persona.getTone()).put("taboo", persona.getTaboo()));
        }
        this.prefs.edit().putString(KEY, array.toString()).apply();
        this._personas.setValue(list);
    }

    public final void upsert(Persona persona) {
        Intrinsics.checkNotNullParameter(persona, "persona");
        List<Persona> mutableList = CollectionsKt.toMutableList((Collection) this._personas.getValue());
        int index = 0;
        Iterator<Persona> it = mutableList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(((Persona) it.next()).getId(), persona.getId())) {
                    break;
                } else {
                    index++;
                }
            } else {
                index = -1;
                break;
            }
        }
        if (index >= 0) {
            mutableList.set(index, persona);
        } else {
            mutableList.add(persona);
        }
        write(mutableList);
    }

    public final void delete(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Iterable value = this._personas.getValue();
        Collection arrayList = new ArrayList();
        for (Object obj : value) {
            if (!Intrinsics.areEqual(((Persona) obj).getId(), id)) {
                arrayList.add(obj);
            }
        }
        write((List) arrayList);
    }

    public final Persona find(String id) {
        Object obj = null;
        if (id == null) {
            return null;
        }
        for (Object obj2 : this._personas.getValue()) {
            if (Intrinsics.areEqual(((Persona) obj2).getId(), id)) {
                obj = obj2;
                break;
            }
        }
        return (Persona) obj;
    }

    public final void clear() {
        write(CollectionsKt.emptyList());
    }

    /* JADX INFO: compiled from: Stores.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/mouthpiece/app/data/PersonaStore$Companion;", "", "<init>", "()V", "KEY", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
