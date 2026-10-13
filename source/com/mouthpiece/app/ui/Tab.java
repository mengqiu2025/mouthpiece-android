package com.mouthpiece.app.ui;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ListKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.PersonKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: AppRoot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/mouthpiece/app/ui/Tab;", "", "label", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getLabel", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "GENERATE", "HISTORY", "PERSONA", "SETTINGS", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
enum Tab {
    GENERATE("生成", HomeKt.getHome(Icons.INSTANCE.getDefault())),
    HISTORY("历史", ListKt.getList(Icons.AutoMirrored.Filled.INSTANCE)),
    PERSONA("对象", PersonKt.getPerson(Icons.INSTANCE.getDefault())),
    SETTINGS("设置", SettingsKt.getSettings(Icons.INSTANCE.getDefault()));

    private final ImageVector icon;
    private final String label;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    Tab(String label, ImageVector icon) {
        this.label = label;
        this.icon = icon;
    }

    public final ImageVector getIcon() {
        return this.icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public static EnumEntries<Tab> getEntries() {
        return $ENTRIES;
    }
}
