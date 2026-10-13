package com.mouthpiece.app.domain.prompt

import com.mouthpiece.app.model.ReplyRequest

/**
 * 提示词组装。
 *
 * 设计要点：
 * - 每次只生成**一条**回复（prompt 里明确要求「只输出一条」），
 *   UI 上的「多个版本」是靠多选风格实现的，不是一次要 N 条。
 * - 80 字上限写在提示词里，不是硬截断。
 * - 明确禁止模型暴露 AI 身份和产品名。
 */
object PromptBuilder {

    /** 表达强度 1–5 → 注入 system 的规则文本。 */
    private val strengthRules: Map<Int, String> = mapOf(
        1 to "表达要非常含蓄委婉，多用缓冲词，把态度藏在客气话里，绝不直接下结论。",
        2 to "表达偏含蓄，先照顾对方感受，再轻描淡写地带出自己的态度。",
        3 to "表达自然平衡，既说清态度也不让对方难堪。",
        4 to "表达偏直接，先给结论再补一句缓冲，不含糊、不绕弯。",
        5 to "表达非常直接，开门见山给出明确态度，不解释、不铺垫、不留余地。",
    )

    /** 强度越界时的回退值。 */
    private const val FALLBACK_STRENGTH = 3

    fun system(request: ReplyRequest): String = buildString {
        append(request.styles.firstOrNull()?.systemPrompt.orEmpty())

        append("\n\n【表达强度】")
        append(strengthRules[request.strength] ?: strengthRules.getValue(FALLBACK_STRENGTH))

        request.persona?.let { persona ->
            append("\n\n【说话对象】")
            append("对方是你的")
            append(persona.relation.ifBlank { "沟通对象" })
            append("，称呼「").append(persona.name).append("」。")
            if (persona.tone.isNotBlank()) {
                append("语气要求：").append(persona.tone).append("。")
            }
            if (persona.taboo.isNotBlank()) {
                append("绝对不要出现：").append(persona.taboo).append("。")
            }
        }

        append("\n\n【输出要求】")
        append("只输出一条可以直接发送的回复正文，不要任何解释、标题、序号或引号；")
        append("口语化、可读性强，控制在 80 字以内；")
        append("不要提及自己是 AI，也不要提及「嘴替」。")
    }

    fun user(request: ReplyRequest): String = buildString {
        append("对方对我说：\n")
        append(request.incoming.trim())
        if (request.extraHint.isNotBlank()) {
            append("\n\n补充要求：").append(request.extraHint.trim())
        }
        append("\n\n请给出你的回复。")
    }
}
