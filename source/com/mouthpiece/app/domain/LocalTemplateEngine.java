package com.mouthpiece.app.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocalTemplateEngine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/mouthpiece/app/domain/LocalTemplateEngine;", "", "<init>", "()V", "generate", "", "Lcom/mouthpiece/app/domain/Reply;", "request", "Lcom/mouthpiece/app/domain/ReplyRequest;", "seed", "", "Intent", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalTemplateEngine {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: LocalTemplateEngine.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/mouthpiece/app/domain/LocalTemplateEngine$Intent;", "", "<init>", "(Ljava/lang/String;I)V", "REQUEST", "INVITE", "QUESTION", "BLAME", "APOLOGY", "FLIRT", "CHAT", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Intent {
        REQUEST,
        INVITE,
        QUESTION,
        BLAME,
        APOLOGY,
        FLIRT,
        CHAT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final List<Pair<Intent, List<String>>> rules = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(APOLOGY, CollectionsKt.listOf((Object[]) new String[]{"对不起", "抱歉", "我错了", "不好意思"})), TuplesKt.to(BLAME, CollectionsKt.listOf((Object[]) new String[]{"你怎么", "为什么没", "又这样", "说好的", "你明明"})), TuplesKt.to(INVITE, CollectionsKt.listOf((Object[]) new String[]{"一起", "要不要", "来吗", "参加", "有空吗", "约吗", "约个", "约一下", "约饭", "约会", "约你"})), TuplesKt.to(FLIRT, CollectionsKt.listOf((Object[]) new String[]{"想你", "喜欢你", "在干嘛", "晚安", "想见你", "心动"})), TuplesKt.to(REQUEST, CollectionsKt.listOf((Object[]) new String[]{"帮我", "帮忙", "能不能", "可以吗", "麻烦你", "请你", "借我", "加个班", "支持一下"})), TuplesKt.to(QUESTION, CollectionsKt.listOf((Object[]) new String[]{"?", "？", "怎么", "为什么", "多少", "什么", "是不是"}))});
        private static final List<String> yueFalsePositives = CollectionsKt.listOf((Object[]) new String[]{"大约", "预约", "节约", "制约", "签约", "合约", "条约", "违约", "盟约", "履约", "续约", "毁约", "邀约"});

        /* JADX INFO: compiled from: LocalTemplateEngine.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/mouthpiece/app/domain/LocalTemplateEngine$Intent$Companion;", "", "<init>", "()V", "rules", "", "Lkotlin/Pair;", "Lcom/mouthpiece/app/domain/LocalTemplateEngine$Intent;", "", "of", "text", "yueFalsePositives", "matches", "", "key", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Intent of(String text) {
                Object next;
                Intent intent;
                boolean z;
                Intrinsics.checkNotNullParameter(text, "text");
                Iterator it = Intent.rules.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Iterable iterable = (List) ((Pair) next).component2();
                    z = false;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it2 = iterable.iterator();
                        while (it2.hasNext()) {
                            if (Intent.INSTANCE.matches(text, (String) it2.next())) {
                                z = true;
                                break;
                            }
                        }
                    }
                } while (!z);
                Pair pair = (Pair) next;
                return (pair == null || (intent = (Intent) pair.getFirst()) == null) ? Intent.CHAT : intent;
            }

            private final boolean matches(String text, String key) {
                if (!StringsKt.startsWith$default((CharSequence) key, (char) 32422, false, 2, (Object) null)) {
                    return StringsKt.contains$default((CharSequence) text, (CharSequence) key, false, 2, (Object) null);
                }
                int index = StringsKt.indexOf$default((CharSequence) text, key, 0, false, 6, (Object) null);
                while (index >= 0) {
                    int windowStart = RangesKt.coerceAtLeast(index - 1, 0);
                    String window = text.substring(windowStart, index + 1);
                    Intrinsics.checkNotNullExpressionValue(window, "substring(...)");
                    if (!Intent.yueFalsePositives.contains(window)) {
                        return true;
                    }
                    index = StringsKt.indexOf$default((CharSequence) text, key, index + 1, false, 4, (Object) null);
                }
                return false;
            }
        }

        public static EnumEntries<Intent> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ List generate$default(LocalTemplateEngine localTemplateEngine, ReplyRequest replyRequest, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return localTemplateEngine.generate(replyRequest, i);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002c  */
    public final List<Reply> generate(ReplyRequest request, int seed) {
        String name;
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = Intent.INSTANCE.of(request.getIncoming());
        Persona persona = request.getPersona();
        if (persona == null || (name = persona.getName()) == null) {
            name = "你";
        } else {
            if (StringsKt.isBlank(name)) {
                name = null;
            }
            if (name == null) {
                name = "你";
            }
        }
        String speaker = name;
        Iterable<StylePreset> styles = request.getStyles();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(styles, 10));
        for (StylePreset stylePreset : styles) {
            List<String> hints = stylePreset.getHints();
            if (hints.isEmpty()) {
                hints = CollectionsKt.listOf("收到，我想想怎么回。");
            }
            List<String> list = hints;
            arrayList.add(new Reply(stylePreset.getId(), stylePreset.getName(), stylePreset.getEmoji(), StringsKt.replace$default(list.get((((seed + intent.ordinal()) % list.size()) + list.size()) % list.size()), "{他}", speaker, false, 4, (Object) null), ReplySource.LOCAL));
        }
        return (List) arrayList;
    }
}
