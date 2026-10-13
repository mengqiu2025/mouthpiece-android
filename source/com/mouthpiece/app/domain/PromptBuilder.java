package com.mouthpiece.app.domain;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromptBuilder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/mouthpiece/app/domain/PromptBuilder;", "", "<init>", "()V", "strengthRules", "", "", "", "system", "request", "Lcom/mouthpiece/app/domain/ReplyRequest;", "user", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptBuilder {
    public static final PromptBuilder INSTANCE = new PromptBuilder();
    private static final Map<Integer, String> strengthRules = MapsKt.mapOf(TuplesKt.to(1, "表达要非常含蓄委婉，多用缓冲词，把态度藏在客气话里，绝不直接下结论。"), TuplesKt.to(2, "表达偏含蓄，先照顾对方感受，再轻描淡写地带出自己的态度。"), TuplesKt.to(3, "表达自然平衡，既说清态度也不让对方难堪。"), TuplesKt.to(4, "表达偏直接，先给结论再补一句缓冲，不含糊、不绕弯。"), TuplesKt.to(5, "表达非常直接，开门见山给出明确态度，不解释、不铺垫、不留余地。"));
    public static final int $stable = 8;

    private PromptBuilder() {
    }

    public final String system(ReplyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sb = new StringBuilder();
        StylePreset stylePreset = (StylePreset) CollectionsKt.firstOrNull((List) request.getStyles());
        String systemPrompt = stylePreset != null ? stylePreset.getSystemPrompt() : null;
        if (systemPrompt == null) {
            systemPrompt = "";
        }
        sb.append(systemPrompt);
        sb.append("\n\n【表达强度】");
        String str = strengthRules.get(Integer.valueOf(request.getStrength()));
        if (str == null) {
            str = (String) MapsKt.getValue(strengthRules, 3);
        }
        sb.append(str);
        Persona persona = request.getPersona();
        if (persona != null) {
            sb.append("\n\n【说话对象】");
            StringBuilder sbAppend = sb.append("对方是你的");
            String relation = persona.getRelation();
            if (StringsKt.isBlank(relation)) {
                relation = "沟通对象";
            }
            sbAppend.append(relation);
            sb.append("，称呼「").append(persona.getName()).append("」。");
            if (!StringsKt.isBlank(persona.getTone())) {
                sb.append("语气要求：").append(persona.getTone()).append("。");
            }
            if (!StringsKt.isBlank(persona.getTaboo())) {
                sb.append("绝对不要出现：").append(persona.getTaboo()).append("。");
            }
        }
        sb.append("\n\n【输出要求】");
        sb.append("只输出一条可以直接发送的回复正文，不要任何解释、标题、序号或引号；");
        sb.append("口语化、可读性强，控制在 80 字以内；");
        sb.append("不要提及自己是 AI，也不要提及「嘴替」。");
        return sb.toString();
    }

    public final String user(ReplyRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("对方对我说：\n");
        sb.append(StringsKt.trim((CharSequence) request.getIncoming()).toString());
        if (!StringsKt.isBlank(request.getExtraHint())) {
            sb.append("\n\n补充要求：").append(StringsKt.trim((CharSequence) request.getExtraHint()).toString());
        }
        sb.append("\n\n请给出你的回复。");
        return sb.toString();
    }
}
