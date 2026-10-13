package com.mouthpiece.app;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mouthpiece.app.data.HistoryStore;
import com.mouthpiece.app.data.OpenAiCompatGateway;
import com.mouthpiece.app.data.PersonaStore;
import com.mouthpiece.app.data.ReplyRepository;
import com.mouthpiece.app.data.SettingsStore;
import com.mouthpiece.app.data.ShareCardRenderer;
import com.mouthpiece.app.domain.AppSettings;
import com.mouthpiece.app.push.DailyPushWorker;
import com.mouthpiece.app.push.PushNotifier;
import com.mouthpiece.app.push.PushScheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MouthpieceApp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020%J\u0010\u0010*\u001a\u00020%2\b\b\u0002\u0010+\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0017@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/mouthpiece/app/ServiceLocator;", "", "<init>", "()V", "ready", "", "value", "Lcom/mouthpiece/app/data/SettingsStore;", "settings", "getSettings", "()Lcom/mouthpiece/app/data/SettingsStore;", "Lcom/mouthpiece/app/data/PersonaStore;", "personas", "getPersonas", "()Lcom/mouthpiece/app/data/PersonaStore;", "Lcom/mouthpiece/app/data/HistoryStore;", "history", "getHistory", "()Lcom/mouthpiece/app/data/HistoryStore;", "Lcom/mouthpiece/app/data/ReplyRepository;", "repository", "getRepository", "()Lcom/mouthpiece/app/data/ReplyRepository;", "Lcom/mouthpiece/app/data/ShareCardRenderer;", "cardRenderer", "getCardRenderer", "()Lcom/mouthpiece/app/data/ShareCardRenderer;", "appContext", "Landroid/content/Context;", "sharedTextChannel", "Lkotlinx/coroutines/channels/Channel;", "", "sharedText", "Lkotlinx/coroutines/flow/Flow;", "getSharedText", "()Lkotlinx/coroutines/flow/Flow;", "init", "", "context", "emitSharedText", "text", "flushHistory", "syncPushSchedule", "force", "previewPush", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ServiceLocator {
    private static Context appContext;
    private static ShareCardRenderer cardRenderer;
    private static HistoryStore history;
    private static PersonaStore personas;
    private static boolean ready;
    private static ReplyRepository repository;
    private static SettingsStore settings;
    public static final ServiceLocator INSTANCE = new ServiceLocator();
    private static final Channel<String> sharedTextChannel = ChannelKt.Channel$default(-2, null, null, 6, null);
    private static final Flow<String> sharedText = FlowKt.receiveAsFlow(sharedTextChannel);
    public static final int $stable = 8;

    private ServiceLocator() {
    }

    public final SettingsStore getSettings() {
        SettingsStore settingsStore = settings;
        if (settingsStore != null) {
            return settingsStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settings");
        return null;
    }

    public final PersonaStore getPersonas() {
        PersonaStore personaStore = personas;
        if (personaStore != null) {
            return personaStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("personas");
        return null;
    }

    public final HistoryStore getHistory() {
        HistoryStore historyStore = history;
        if (historyStore != null) {
            return historyStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("history");
        return null;
    }

    public final ReplyRepository getRepository() {
        ReplyRepository replyRepository = repository;
        if (replyRepository != null) {
            return replyRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("repository");
        return null;
    }

    public final ShareCardRenderer getCardRenderer() {
        ShareCardRenderer shareCardRenderer = cardRenderer;
        if (shareCardRenderer != null) {
            return shareCardRenderer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardRenderer");
        return null;
    }

    public final Flow<String> getSharedText() {
        return sharedText;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (ready) {
            return;
        }
        Context ctx = context.getApplicationContext();
        appContext = ctx;
        Intrinsics.checkNotNull(ctx);
        settings = new SettingsStore(ctx);
        personas = new PersonaStore(ctx);
        history = new HistoryStore(ctx);
        repository = new ReplyRepository(new Function0() { // from class: com.mouthpiece.app.ServiceLocator$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ServiceLocator.init$lambda$0();
            }
        }, new OpenAiCompatGateway(new Function0() { // from class: com.mouthpiece.app.ServiceLocator$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ServiceLocator.init$lambda$1();
            }
        }), null, 4, null);
        cardRenderer = new ShareCardRenderer(ctx);
        ready = true;
        PushNotifier.INSTANCE.ensureChannel(ctx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings init$lambda$0() {
        return INSTANCE.getSettings().getSettings().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings init$lambda$1() {
        return INSTANCE.getSettings().getSettings().getValue();
    }

    public final Context context() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void emitSharedText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        sharedTextChannel.mo9045trySendJP2dKIU(text);
    }

    public final void flushHistory() {
        if (ready) {
            getHistory().flush();
        }
    }

    public static /* synthetic */ void syncPushSchedule$default(ServiceLocator serviceLocator, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        serviceLocator.syncPushSchedule(z);
    }

    public final void syncPushSchedule(boolean force) {
        AppSettings config = getSettings().getSettings().getValue();
        PushScheduler pushScheduler = PushScheduler.INSTANCE;
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            context = null;
        }
        pushScheduler.sync(context, config.getNotifyEnabled(), config.getNotifyHour(), force);
    }

    public static /* synthetic */ void previewPush$default(ServiceLocator serviceLocator, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = DailyPushWorker.TYPE_TIP;
        }
        serviceLocator.previewPush(str);
    }

    public final void previewPush(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        PushScheduler pushScheduler = PushScheduler.INSTANCE;
        Context context = appContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            context = null;
        }
        pushScheduler.previewNow(context, type);
    }
}
