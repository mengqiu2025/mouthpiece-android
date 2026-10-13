package com.mouthpiece.app.vm;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mouthpiece.app.data.HistoryStore;
import com.mouthpiece.app.domain.HistoryItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AppViewModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/mouthpiece/app/vm/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "history", "Lcom/mouthpiece/app/data/HistoryStore;", "<init>", "(Lcom/mouthpiece/app/data/HistoryStore;)V", "_query", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "query", "Lkotlinx/coroutines/flow/StateFlow;", "getQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "_onlyFavorite", "", "onlyFavorite", "getOnlyFavorite", "items", "", "Lcom/mouthpiece/app/domain/HistoryItem;", "getItems", "onQueryChange", "", "value", "toggleOnlyFavorite", "toggleFavorite", "id", "", "delete", "clear", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HistoryViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _onlyFavorite;
    private final MutableStateFlow<String> _query;
    private final HistoryStore history;
    private final StateFlow<List<HistoryItem>> items;
    private final StateFlow<Boolean> onlyFavorite;
    private final StateFlow<String> query;

    public HistoryViewModel(HistoryStore history) {
        Intrinsics.checkNotNullParameter(history, "history");
        this.history = history;
        this._query = StateFlowKt.MutableStateFlow("");
        this.query = FlowKt.asStateFlow(this._query);
        this._onlyFavorite = StateFlowKt.MutableStateFlow(false);
        this.onlyFavorite = FlowKt.asStateFlow(this._onlyFavorite);
        this.items = FlowKt.stateIn(FlowKt.combine(this.history.getItems(), this._query, this._onlyFavorite, new HistoryViewModel$items$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, CoroutineLiveDataKt.DEFAULT_TIMEOUT, 0L, 2, null), CollectionsKt.emptyList());
    }

    public final StateFlow<String> getQuery() {
        return this.query;
    }

    public final StateFlow<Boolean> getOnlyFavorite() {
        return this.onlyFavorite;
    }

    public final StateFlow<List<HistoryItem>> getItems() {
        return this.items;
    }

    public final void onQueryChange(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._query.setValue(value);
    }

    public final void toggleOnlyFavorite() {
        this._onlyFavorite.setValue(Boolean.valueOf(!this._onlyFavorite.getValue().booleanValue()));
    }

    public final void toggleFavorite(long id) {
        this.history.toggleFavorite(id);
    }

    public final void delete(long id) {
        this.history.delete(id);
    }

    public final void clear() {
        this.history.clear();
    }
}
