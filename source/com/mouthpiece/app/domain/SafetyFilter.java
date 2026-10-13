package com.mouthpiece.app.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SafetyFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mouthpiece/app/domain/SafetyFilter;", "", "<init>", "()V", "blockedInput", "", "", "blockedOutput", "safePrefixes", "MAX_PREFIX_LENGTH", "", "MAX_INPUT_LENGTH", "HARD_INPUT_LIMIT", "validateInput", "raw", "isOutputSafe", "", "text", "hitsRiskyWord", "word", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SafetyFilter {
    public static final int HARD_INPUT_LIMIT = 6000;
    public static final int MAX_INPUT_LENGTH = 600;
    private static final int MAX_PREFIX_LENGTH = 3;
    public static final SafetyFilter INSTANCE = new SafetyFilter();
    private static final List<String> blockedInput = CollectionsKt.listOf((Object[]) new String[]{"炸药", "枪支", "毒品", "冰毒", "洗钱", "裸聊", "诈骗话术", "骗保", "开票冲账", "伪造证件", "赌博网站", "辱骂模板", "人身攻击模板", "怎么开盒", "如何开盒", "帮我开盒", "开盒教程", "开盒方法", "人肉搜索教程", "帮我人肉", "人肉搜索方法", "怎么网暴", "帮我网暴", "网暴教程"});
    private static final List<String> blockedOutput = CollectionsKt.listOf((Object[]) new String[]{"炸药", "枪支", "毒品", "洗钱", "诈骗", "裸聊", "开盒", "人肉"});
    private static final List<String> safePrefixes = CollectionsKt.listOf((Object[]) new String[]{"不是", "不算", "没有", "不会", "并非", "别", "无需", "不用", "拒绝", "防", "反", "警惕", "小心", "避免", "切勿", "不要"});
    public static final int $stable = 8;

    private SafetyFilter() {
    }

    public final String validateInput(String raw) {
        Object next;
        Intrinsics.checkNotNullParameter(raw, "raw");
        String text = StringsKt.trim((CharSequence) raw).toString();
        if (text.length() == 0) {
            return "先粘贴对方说的话，再让嘴替开工。";
        }
        if (text.length() > 600) {
            return "内容有点长，截取最关键的 600 字以内效果更好。";
        }
        Iterator it = blockedInput.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!INSTANCE.hitsRiskyWord(text, (String) next));
        String hit = (String) next;
        if (hit != null) {
            return "这类内容嘴替帮不上忙，换个场景试试。";
        }
        return null;
    }

    public final boolean isOutputSafe(String text) {
        boolean z;
        Intrinsics.checkNotNullParameter(text, "text");
        if (StringsKt.isBlank(text)) {
            return false;
        }
        Iterable iterable = blockedOutput;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            z = true;
        } else {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (INSTANCE.hitsRiskyWord(text, (String) it.next())) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean hitsRiskyWord(String text, String word) {
        int index = StringsKt.indexOf$default((CharSequence) text, word, 0, false, 6, (Object) null);
        while (true) {
            boolean z = false;
            if (index >= 0) {
                int prefixStart = RangesKt.coerceAtLeast(index - 3, 0);
                String prefix = text.substring(prefixStart, index);
                Intrinsics.checkNotNullExpressionValue(prefix, "substring(...)");
                Iterable iterable = safePrefixes;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it = iterable.iterator();
                    do {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                    } while (!StringsKt.endsWith$default(prefix, (String) it.next(), false, 2, (Object) null));
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
                index = StringsKt.indexOf$default((CharSequence) text, word, index + 1, false, 4, (Object) null);
            } else {
                return false;
            }
        }
    }
}
