package com.mouthpiece.app.domain.safety

/**
 * 输入 / 输出安全过滤。
 *
 * 三层机制：
 * 1. [blockedInput]  —— 24 条输入黑名单，命中直接拒绝生成
 * 2. [blockedOutput] —— 8 条输出黑名单，命中则丢弃该条结果
 * 3. [safePrefixes]  —— 16 条否定前缀白名单：命中黑名单词时回看**前 3 个字符**，
 *    若以这些词结尾则**不算命中**。
 *
 * 两个容易误解的地方（已由 `SafetyFilterTest` 固化为断言）：
 *
 * - **输入黑名单是精确短语，不是关键词。** 列表里只有「怎么开盒」「开盒教程」
 *   这类具体问法，**没有裸的「开盒」**，所以单说「开盒」不会被拦。
 *   输出黑名单反而更宽 —— 有裸的「开盒」和「人肉」。
 * - **否定前缀必须紧贴命中词，窗口只有 3 个字符。** 所以「防诈骗话术」放行，
 *   但「如何防范诈骗话术」会被拦（窗口取到的是「何防范」而非「防」）。
 *
 * 注意 [isOutputSafe] 的语义：**安全返回 true**。
 * （反编译工具在这两处的分支判断上是错的，本实现按字节码还原。）
 */
object SafetyFilter {

    /** 输入硬截断长度（超出直接 take）。 */
    const val HARD_INPUT_LIMIT = 6000

    /** 输入软提示长度（超出直接拦截并提示）。 */
    const val MAX_INPUT_LENGTH = 600

    /** 回看前缀的最大字符数。 */
    private const val MAX_PREFIX_LENGTH = 3

    private val blockedInput = listOf(
        "炸药", "枪支", "毒品", "冰毒", "洗钱", "裸聊",
        "诈骗话术", "骗保", "开票冲账", "伪造证件", "赌博网站",
        "辱骂模板", "人身攻击模板",
        "怎么开盒", "如何开盒", "帮我开盒", "开盒教程", "开盒方法",
        "人肉搜索教程", "帮我人肉", "人肉搜索方法",
        "怎么网暴", "帮我网暴", "网暴教程",
    )

    private val blockedOutput = listOf(
        "炸药", "枪支", "毒品", "洗钱", "诈骗", "裸聊", "开盒", "人肉",
    )

    private val safePrefixes = listOf(
        "不是", "不算", "没有", "不会", "并非", "别", "无需", "不用",
        "拒绝", "防", "反", "警惕", "小心", "避免", "切勿", "不要",
    )

    /**
     * 校验用户输入。
     *
     * @return 不通过时返回给用户看的提示文案；通过返回 `null`。
     */
    fun validateInput(raw: String): String? {
        val text = raw.trim()
        if (text.isEmpty()) {
            return "先粘贴对方说的话，再让嘴替开工。"
        }
        if (text.length > MAX_INPUT_LENGTH) {
            return "内容有点长，截取最关键的 600 字以内效果更好。"
        }
        if (blockedInput.any { hitsRiskyWord(text, it) }) {
            return "这类内容嘴替帮不上忙，换个场景试试。"
        }
        return null
    }

    /** 输出是否安全。空白文本视为**不安全**。 */
    fun isOutputSafe(text: String): Boolean {
        if (text.isBlank()) return false
        return blockedOutput.none { hitsRiskyWord(text, it) }
    }

    /**
     * [text] 中是否出现了「未被安全前缀豁免」的 [word]。
     *
     * 会遍历该词的**所有出现位置**：只要有一处没被安全前缀豁免，就算命中。
     */
    private fun hitsRiskyWord(text: String, word: String): Boolean {
        var index = text.indexOf(word)
        while (index >= 0) {
            val prefixStart = maxOf(index - MAX_PREFIX_LENGTH, 0)
            val prefix = text.substring(prefixStart, index)
            val hasSafePrefix = safePrefixes.any { prefix.endsWith(it) }
            if (!hasSafePrefix) return true
            index = text.indexOf(word, index + 1)
        }
        return false
    }
}
