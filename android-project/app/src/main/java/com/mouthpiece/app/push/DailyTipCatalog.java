package com.mouthpiece.app.push;

import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: DailyTipCatalog.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/mouthpiece/app/push/DailyTipCatalog;", "", "<init>", "()V", "all", "", "Lcom/mouthpiece/app/push/DailyTip;", "getAll", "()Ljava/util/List;", "forDayOfYear", "dayOfYear", "", "today", "now", "", "STREAK_TITLE", "", "STREAK_BODY", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DailyTipCatalog {
    public static final String STREAK_BODY = "有句话不知道怎么回？粘过来，三秒给你几个版本。";
    public static final String STREAK_TITLE = "今天还没让嘴替开工";
    public static final DailyTipCatalog INSTANCE = new DailyTipCatalog();
    private static final List<DailyTip> all = CollectionsKt.listOf((Object[]) new DailyTip[]{new DailyTip("拒绝的三段式", "先肯定对方，再说明自己的限制，最后给一个替代方案。比直接说「不行」更容易被接受。"), new DailyTip("催进度别用「你怎么还没」", "换成「我这边卡在这一步，需要你周三前给个结果」，把指责变成协作，对方更容易动。"), new DailyTip("被夸的时候别急着否认", "说「谢谢，这话我收下了」就够了。急着谦虚，反而让夸奖的人尴尬。"), new DailyTip("道歉只讲两件事", "承认具体做了什么，再说怎么补。不要加「但是」，那会毁掉前半句。"), new DailyTip("拒绝邀约的标准句式", "「谢谢想到我，这次时间冲突了，下次有机会我第一个答应。」不解释、不找理由。"), new DailyTip("要资源前先给结论", "先说「我需要 X，因为 Y，最晚 Z 前要」，再补背景。上级没耐心听铺垫。"), new DailyTip("冷场时接话的技巧", "别问「你怎么看」，改问「如果是你会选哪个」。给选项比给开放题更好接。"), new DailyTip("被阴阳时的体面回应", "「我记下了，咱们还是看结果说话。」不接情绪，只接事实。"), new DailyTip("道歉要趁早", "拖延不会让事情变小，只会让对方把「你不重视」也一起算进去。"), new DailyTip("别在气头上发消息", "先写好，存草稿，十分钟后再看一遍。想删掉的那句，通常就是该删的。"), new DailyTip("提需求带上方案", "「这里有问题，我建议这样改，你看行不行？」带方案的人很少被拒绝。"), new DailyTip("拒绝闲聊式加班", "「今天我有安排，明早九点前给你。」给明确时间，比「尽量」更有边界感。")});
    public static final int $stable = 8;

    private DailyTipCatalog() {
    }

    public final List<DailyTip> getAll() {
        return all;
    }

    public final DailyTip forDayOfYear(int dayOfYear) {
        int size = all.size();
        int index = (((dayOfYear - 1) % size) + size) % size;
        return all.get(index);
    }

    public static /* synthetic */ DailyTip today$default(DailyTipCatalog dailyTipCatalog, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return dailyTipCatalog.today(j);
    }

    public final DailyTip today(long now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        return forDayOfYear(calendar.get(6));
    }
}
