package com.mouthpiece.app.domain.style

import com.mouthpiece.app.model.Scene
import com.mouthpiece.app.model.StylePreset

/**
 * 风格目录（12 种）。
 *
 * 所有文案、system prompt、temperature、离线话术均为从 APK 中提取的**原文**。
 *
 * temperature 说明：`high_eq` / `soft_no` / `subtle` / `opener` 在原源码里
 * 没有显式传 temperature，走 [StylePreset] 的默认值 0.8。反编译输出在这四处
 * 会显示 `0.0f`，那是默认参数掩码造成的假值，已按真实值填写。
 */
object StyleCatalog {

    val all: List<StylePreset> = listOf(
        StylePreset(
            id = "high_eq",
            name = "高情商",
            emoji = "🌤",
            scene = Scene.GENERAL,
            tagline = "给足台阶，把话说圆",
            systemPrompt = "你是高情商沟通教练。回复要照顾对方情绪、先共情再表达立场，语气自然口语化，不使用书面语与说教腔。",
            // temperature 未显式指定 → 默认 0.8
            hints = listOf(
                "我懂你的意思，换我可能也会这么想。不过说实话，{他}要是方便的话，我这边确实想再商量一下。",
                "谢谢你愿意直接跟我说，这点我挺珍惜的。我的想法是先把眼前这步走稳，剩下的咱们慢慢来。",
                "这事我没觉得是问题，反而挺理解{他}的处境。要不这样，我先把能做的做了，剩下的再看情况？",
            ),
        ),
        StylePreset(
            id = "pro",
            name = "职场得体",
            emoji = "💼",
            scene = Scene.WORKPLACE,
            tagline = "专业、简洁、有边界",
            systemPrompt = "你是职场沟通顾问。回复要专业克制、结论先行、给出明确下一步动作，不使用网络流行语和感叹号。",
            temperature = 0.7f,
            hints = listOf(
                "收到，我先同步一下目前的进度：手上的部分今天能给出初稿。{他}这边如果有更明确的优先级，我按新优先级调整。",
                "理解。为了保证质量，我建议把范围收敛到最关键的一到两项，我先出一版方案，明天同步给{他}确认。",
                "感谢同步。这块我评估下来需要额外的时间，我先按现有节奏推进，有风险会提前告知{他}。",
            ),
        ),
        StylePreset(
            id = "soft_no",
            name = "温柔拒绝",
            emoji = "🙅",
            scene = Scene.WORKPLACE,
            tagline = "拒绝，但不伤和气",
            systemPrompt = "你是沟通顾问。要在明确拒绝的同时保住关系：先肯定对方、再说明自己的限制、最后给出替代方案。绝不阴阳怪气。",
            // temperature 未显式指定 → 默认 0.8
            hints = listOf(
                "真的谢谢你想到我，这份心意我收到了。不过这次我确实排不开，怕答应了反而耽误{他}，就不硬接了。",
                "我特别理解这件事对{他}很重要，只是我这段时间精力确实有限，做不到我满意的程度，与其将就不如这次先放一放。",
                "谢谢{他}的邀请，我很开心。但我这边时间上真的冲突了，这次只能错过，下次有机会一定第一个答应。",
            ),
        ),
        StylePreset(
            id = "hard_no",
            name = "硬核拒绝",
            emoji = "🛑",
            scene = Scene.WORKPLACE,
            tagline = "不解释，不内耗",
            systemPrompt = "你是边界感教练。回复要简短、明确、不留回旋余地，不需要道歉也不需要解释，礼貌但坚定。",
            temperature = 0.5f,
            hints = listOf(
                "这次不行。",
                "抱歉，这件事我帮不上。",
                "不参加，谢谢。",
            ),
        ),
        StylePreset(
            id = "subtle",
            name = "绵里藏针",
            emoji = "🗡",
            scene = Scene.SOCIAL,
            tagline = "字面客气，态度明确",
            systemPrompt = "你是语言高手。回复表面礼貌客气，但立场清晰、暗含回击，用词克制不带脏字与人身攻击，读完让人无法反驳。",
            // temperature 未显式指定 → 默认 0.8
            hints = listOf(
                "说得挺好的，就是有个小问题：按这个逻辑，好像谁都不用负责了。",
                "我记下了，{他}的说法我尊重。不过事实摆在这儿，咱们还是看结果说话。",
                "感谢建议，很有参考价值。等我需要有人替我做决定的时候，第一个想到{他}。",
            ),
        ),
        StylePreset(
            id = "coquettish",
            name = "撒娇",
            emoji = "🥺",
            scene = Scene.LOVE,
            tagline = "软一点，事情就好办",
            systemPrompt = "你是恋爱沟通助手。回复要撒娇、可爱、带点小任性，多用语气词和叠词，但不油腻不做作。",
            temperature = 0.9f,
            hints = listOf(
                "哼，{他}这样说人家会难过的嘛，就不能哄哄我一下下？",
                "好啦好啦，我知道错了还不行嘛～那{他}要不要抱抱我，抱了就不许生气了哦。",
                "我不管，这件事我就是要赖上{他}了，谁让{他}最好说话呀。",
            ),
        ),
        StylePreset(
            id = "aloof",
            name = "高冷",
            emoji = "🧊",
            scene = Scene.LOVE,
            tagline = "话少，留白，有距离感",
            systemPrompt = "你是沟通高手。回复要极简、克制、不主动示好，用最少的字表达完整态度，留出想象空间。",
            temperature = 0.6f,
            hints = listOf(
                "嗯，知道了。",
                "随便，都行。",
                "看到了。",
            ),
        ),
        StylePreset(
            id = "flirty",
            name = "甜蜜撩人",
            emoji = "💗",
            scene = Scene.LOVE,
            tagline = "暧昧升温，进退有度",
            systemPrompt = "你是恋爱沟通助手。回复要甜而不腻、有来有回，带一点试探和调侃，尺度把握在暧昧而非越界。",
            temperature = 0.9f,
            hints = listOf(
                "这话我可得记下来，以后{他}赖账的时候我就翻出来念给{他}听。",
                "本来今天心情挺一般的，看到{他}这句话，忽然就好起来了，这算不算{他}的责任？",
                "巧了，我刚刚也想到{他}。所以现在，我们俩算不算想到一块儿去了？",
            ),
        ),
        StylePreset(
            id = "funny",
            name = "幽默接梗",
            emoji = "🤣",
            scene = Scene.SOCIAL,
            tagline = "把天聊活，不冷场",
            systemPrompt = "你是脱口秀编剧。回复要幽默、有梗、能自嘲，短句为主，避免解释笑点，不冒犯任何人。",
            temperature = 1.0f,
            hints = listOf(
                "收到，已阅，精神上全力支持，行动上我先撤。",
                "这题超纲了，但我可以试着瞎答：问题不大，反正大不了从头再来。",
                "我宣布，{他}这句话今天在群里排名第一，我甘拜下风。",
            ),
        ),
        StylePreset(
            id = "opener",
            name = "破冰开场",
            emoji = "👋",
            scene = Scene.SOCIAL,
            tagline = "第一句不尴尬",
            systemPrompt = "你是社交破冰教练。回复要自然、低压力、给对方容易接话的钩子，避免查户口式提问。",
            // temperature 未显式指定 → 默认 0.8
            hints = listOf(
                "嗨，冒昧打扰一下～刚看到{他}的动态，感觉挺有意思的，就顺手来搭个话。",
                "你好呀，我是从群里看到{他}的。有个小问题想请教一下，不知道方不方便？",
                "打扰啦，先自我介绍一下，我最近在做一件跟{他}有点类似的事，想听听{他}的经验。",
            ),
        ),
        StylePreset(
            id = "classical",
            name = "古风文言",
            emoji = "📜",
            scene = Scene.GENERAL,
            tagline = "一开口就是文化人",
            systemPrompt = "你是文言文写手。用浅白文言回复，句式短、可读性强，不堆砌生僻字，不引用真实史实人名。",
            temperature = 0.8f,
            hints = listOf(
                "承蒙相告，感激不尽。此事容我细思，三日之内必有回音。",
                "所言甚是，然吾意已决。非不近人情，实为力有不逮耳。",
                "谢君盛情，奈何分身乏术。来日方长，愿君见谅。",
            ),
        ),
        StylePreset(
            id = "service",
            name = "客服腔",
            emoji = "🎧",
            scene = Scene.GENERAL,
            tagline = "官方话术，滴水不漏",
            systemPrompt = "你是资深客服培训师。回复要使用标准服务话术：致歉—共情—说明—给方案—致谢，措辞客气周全，不承诺无法兑现的事。",
            temperature = 0.6f,
            hints = listOf(
                "非常抱歉给您带来困扰，您反馈的情况我们已经记录。我们会尽快核实，并在第一时间同步进展，感谢您的理解与支持。",
                "您好，已收到您的反馈。为便于我们进一步跟进，麻烦您补充一下相关信息，我们会优先为您处理，感谢配合。",
                "感谢您的耐心等待。关于您提到的问题，我们已安排专人跟进，预计近期会有结论，后续会及时向您同步。",
            ),
        ),
    )

    private val byIdMap: Map<String, StylePreset> = all.associateBy { it.id }

    private val byScene: Map<Scene, List<StylePreset>> =
        Scene.entries.associateWith { scene ->
            if (scene == Scene.ALL) all else all.filter { it.scene == scene }
        }

    /** 首页默认勾选的三种风格。 */
    val defaultSelection: List<String> = listOf("high_eq", "pro", "funny")

    fun byId(id: String): StylePreset? = byIdMap[id]

    fun byIds(ids: List<String>): List<StylePreset> = ids.mapNotNull { byIdMap[it] }

    fun ofScene(scene: Scene): List<StylePreset> = byScene.getValue(scene)

    /**
     * 在指定场景下已选中的风格。
     *
     * 注意 [Scene.ALL] 会放行全部风格；其他场景只保留 scene 匹配的。
     * 生成前的「至少选一种风格」校验用的就是这个方法 ——
     * 所以切换场景后可能出现「明明选了风格却提示至少选一种」。
     */
    fun selectedInScene(selectedIds: List<String>, scene: Scene): List<StylePreset> =
        byIds(selectedIds).filter { scene == Scene.ALL || it.scene == scene }

    fun hasSelectionInScene(selectedIds: List<String>, scene: Scene): Boolean =
        selectedIds.any { id ->
            val preset = byIdMap[id] ?: return@any false
            scene == Scene.ALL || preset.scene == scene
        }
}
