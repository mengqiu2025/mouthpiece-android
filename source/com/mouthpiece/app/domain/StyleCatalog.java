package com.mouthpiece.app.domain;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: StyleCatalog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000bJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0012\u001a\u00020\rJ\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0012\u001a\u00020\rJ\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0012\u001a\u00020\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/mouthpiece/app/domain/StyleCatalog;", "", "<init>", "()V", "all", "", "Lcom/mouthpiece/app/domain/StylePreset;", "getAll", "()Ljava/util/List;", "byId", "", "", "byScene", "Lcom/mouthpiece/app/domain/Scene;", "id", "byIds", "ids", "ofScene", "scene", "selectedInScene", "selectedIds", "hasSelectionInScene", "", "defaultSelection", "getDefaultSelection", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StyleCatalog {
    public static final int $stable;
    public static final StyleCatalog INSTANCE = new StyleCatalog();
    private static final List<StylePreset> all = CollectionsKt.listOf((Object[]) new StylePreset[]{new StylePreset("high_eq", "高情商", "🌤", Scene.GENERAL, "给足台阶，把话说圆", "你是高情商沟通教练。回复要照顾对方情绪、先共情再表达立场，语气自然口语化，不使用书面语与说教腔。", 0.0f, CollectionsKt.listOf((Object[]) new String[]{"我懂你的意思，换我可能也会这么想。不过说实话，{他}要是方便的话，我这边确实想再商量一下。", "谢谢你愿意直接跟我说，这点我挺珍惜的。我的想法是先把眼前这步走稳，剩下的咱们慢慢来。", "这事我没觉得是问题，反而挺理解{他}的处境。要不这样，我先把能做的做了，剩下的再看情况？"}), 64, null), new StylePreset("pro", "职场得体", "💼", Scene.WORKPLACE, "专业、简洁、有边界", "你是职场沟通顾问。回复要专业克制、结论先行、给出明确下一步动作，不使用网络流行语和感叹号。", 0.7f, CollectionsKt.listOf((Object[]) new String[]{"收到，我先同步一下目前的进度：手上的部分今天能给出初稿。{他}这边如果有更明确的优先级，我按新优先级调整。", "理解。为了保证质量，我建议把范围收敛到最关键的一到两项，我先出一版方案，明天同步给{他}确认。", "感谢同步。这块我评估下来需要额外的时间，我先按现有节奏推进，有风险会提前告知{他}。"})), new StylePreset("soft_no", "温柔拒绝", "🙅", Scene.WORKPLACE, "拒绝，但不伤和气", "你是沟通顾问。要在明确拒绝的同时保住关系：先肯定对方、再说明自己的限制、最后给出替代方案。绝不阴阳怪气。", 0.0f, CollectionsKt.listOf((Object[]) new String[]{"真的谢谢你想到我，这份心意我收到了。不过这次我确实排不开，怕答应了反而耽误{他}，就不硬接了。", "我特别理解这件事对{他}很重要，只是我这段时间精力确实有限，做不到我满意的程度，与其将就不如这次先放一放。", "谢谢{他}的邀请，我很开心。但我这边时间上真的冲突了，这次只能错过，下次有机会一定第一个答应。"}), 64, null), new StylePreset("hard_no", "硬核拒绝", "🛑", Scene.WORKPLACE, "不解释，不内耗", "你是边界感教练。回复要简短、明确、不留回旋余地，不需要道歉也不需要解释，礼貌但坚定。", 0.5f, CollectionsKt.listOf((Object[]) new String[]{"这次不行。", "抱歉，这件事我帮不上。", "不参加，谢谢。"})), new StylePreset("subtle", "绵里藏针", "🗡", Scene.SOCIAL, "字面客气，态度明确", "你是语言高手。回复表面礼貌客气，但立场清晰、暗含回击，用词克制不带脏字与人身攻击，读完让人无法反驳。", 0.0f, CollectionsKt.listOf((Object[]) new String[]{"说得挺好的，就是有个小问题：按这个逻辑，好像谁都不用负责了。", "我记下了，{他}的说法我尊重。不过事实摆在这儿，咱们还是看结果说话。", "感谢建议，很有参考价值。等我需要有人替我做决定的时候，第一个想到{他}。"}), 64, null), new StylePreset("coquettish", "撒娇", "🥺", Scene.LOVE, "软一点，事情就好办", "你是恋爱沟通助手。回复要撒娇、可爱、带点小任性，多用语气词和叠词，但不油腻不做作。", 0.9f, CollectionsKt.listOf((Object[]) new String[]{"哼，{他}这样说人家会难过的嘛，就不能哄哄我一下下？", "好啦好啦，我知道错了还不行嘛～那{他}要不要抱抱我，抱了就不许生气了哦。", "我不管，这件事我就是要赖上{他}了，谁让{他}最好说话呀。"})), new StylePreset("aloof", "高冷", "🧊", Scene.LOVE, "话少，留白，有距离感", "你是沟通高手。回复要极简、克制、不主动示好，用最少的字表达完整态度，留出想象空间。", 0.6f, CollectionsKt.listOf((Object[]) new String[]{"嗯，知道了。", "随便，都行。", "看到了。"})), new StylePreset("flirty", "甜蜜撩人", "💗", Scene.LOVE, "暧昧升温，进退有度", "你是恋爱沟通助手。回复要甜而不腻、有来有回，带一点试探和调侃，尺度把握在暧昧而非越界。", 0.9f, CollectionsKt.listOf((Object[]) new String[]{"这话我可得记下来，以后{他}赖账的时候我就翻出来念给{他}听。", "本来今天心情挺一般的，看到{他}这句话，忽然就好起来了，这算不算{他}的责任？", "巧了，我刚刚也想到{他}。所以现在，我们俩算不算想到一块儿去了？"})), new StylePreset("funny", "幽默接梗", "🤣", Scene.SOCIAL, "把天聊活，不冷场", "你是脱口秀编剧。回复要幽默、有梗、能自嘲，短句为主，避免解释笑点，不冒犯任何人。", 1.0f, CollectionsKt.listOf((Object[]) new String[]{"收到，已阅，精神上全力支持，行动上我先撤。", "这题超纲了，但我可以试着瞎答：问题不大，反正大不了从头再来。", "我宣布，{他}这句话今天在群里排名第一，我甘拜下风。"})), new StylePreset("opener", "破冰开场", "👋", Scene.SOCIAL, "第一句不尴尬", "你是社交破冰教练。回复要自然、低压力、给对方容易接话的钩子，避免查户口式提问。", 0.0f, CollectionsKt.listOf((Object[]) new String[]{"嗨，冒昧打扰一下～刚看到{他}的动态，感觉挺有意思的，就顺手来搭个话。", "你好呀，我是从群里看到{他}的。有个小问题想请教一下，不知道方不方便？", "打扰啦，先自我介绍一下，我最近在做一件跟{他}有点像的事，想听听{他}的经验。"}), 64, null), new StylePreset("classical", "古风文言", "📜", Scene.GENERAL, "一开口就是文化人", "你是文言文写手。用浅白文言回复，句式短、可读性强，不堆砌生僻字，不引用真实史实人名。", 0.8f, CollectionsKt.listOf((Object[]) new String[]{"承蒙相告，感激不尽。此事容我细思，三日之内必有回音。", "所言甚是，然吾意已决。非不近人情，实为力有不逮耳。", "谢君盛情，奈何分身乏术。来日方长，愿君见谅。"})), new StylePreset(NotificationCompat.CATEGORY_SERVICE, "客服腔", "🎧", Scene.GENERAL, "官方话术，滴水不漏", "你是资深客服培训师。回复要使用标准服务话术：致歉—共情—说明—给方案—致谢，措辞客气周全，不承诺无法兑现的事。", 0.6f, CollectionsKt.listOf((Object[]) new String[]{"非常抱歉给您带来困扰，您反馈的情况我们已经记录。我们会尽快核实，并在第一时间同步进展，感谢您的理解与支持。", "您好，已收到您的反馈。为便于我们进一步跟进，麻烦您补充一下相关信息，我们会优先为您处理，感谢配合。", "感谢您的耐心等待。关于您提到的问题，我们已安排专人跟进，预计近期会有结论，后续会及时向您同步。"}))});
    private static final Map<String, StylePreset> byId;
    private static final Map<Scene, List<StylePreset>> byScene;
    private static final List<String> defaultSelection;

    private StyleCatalog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r21v11 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r24v10 */
    static {
        Object obj;
        boolean z;
        List<StylePreset> list;
        Object obj2 = null;
        boolean z2 = true;
        int i = 8;
        List<StylePreset> list2 = all;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
        for (Object obj3 : list2) {
            linkedHashMap.put(((StylePreset) obj3).getId(), obj3);
        }
        byId = linkedHashMap;
        EnumEntries<Scene> entries = Scene.getEntries();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (Scene scene : entries) {
            LinkedHashMap linkedHashMap3 = linkedHashMap2;
            Scene scene2 = scene;
            if (scene2 == Scene.ALL) {
                list = all;
                obj = obj2;
                z = z2;
            } else {
                List<StylePreset> list3 = all;
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : list3) {
                    Object obj5 = obj2;
                    boolean z3 = z2;
                    if ((((StylePreset) obj4).getScene() == scene2 ? z3 : obj5) != 0) {
                        arrayList.add(obj4);
                    }
                    obj2 = obj5;
                    z2 = z3;
                }
                obj = obj2;
                z = z2;
                list = arrayList;
            }
            linkedHashMap3.put(scene, list);
            i = i;
            obj2 = obj;
            z2 = z;
        }
        byScene = linkedHashMap2;
        String[] strArr = new String[3];
        strArr[obj2 == true ? 1 : 0] = "high_eq";
        strArr[z2 ? 1 : 0] = "pro";
        strArr[2] = "funny";
        defaultSelection = CollectionsKt.listOf((Object[]) strArr);
        $stable = i;
    }

    public final List<StylePreset> getAll() {
        return all;
    }

    public final StylePreset byId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return byId.get(id);
    }

    public final List<StylePreset> byIds(List<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Collection arrayList = new ArrayList();
        Iterator it = ids.iterator();
        while (it.hasNext()) {
            StylePreset stylePreset = byId.get((String) it.next());
            if (stylePreset != null) {
                arrayList.add(stylePreset);
            }
        }
        return (List) arrayList;
    }

    public final List<StylePreset> ofScene(Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return (List) MapsKt.getValue(byScene, scene);
    }

    public final List<StylePreset> selectedInScene(List<String> selectedIds, Scene scene) {
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Iterable iterableByIds = byIds(selectedIds);
        Collection arrayList = new ArrayList();
        for (Object obj : iterableByIds) {
            if (scene == Scene.ALL || ((StylePreset) obj).getScene() == scene) {
                arrayList.add(obj);
            }
        }
        return (List) arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    public final boolean hasSelectionInScene(List<String> selectedIds, Scene scene) {
        boolean z;
        Intrinsics.checkNotNullParameter(selectedIds, "selectedIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        List<String> list = selectedIds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StylePreset stylePreset = byId.get((String) it.next());
            if (stylePreset == null) {
                z = false;
            } else {
                if (scene == Scene.ALL || stylePreset.getScene() == scene) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final List<String> getDefaultSelection() {
        return defaultSelection;
    }
}
