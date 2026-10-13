package com.mouthpiece.app.model

/**
 * 一种回复风格。
 *
 * [temperature] 的默认值是 **0.8**（不是 0.7）。
 * 反编译输出里对未显式传值的风格会打印 `0.0f` 占位，那是假的 —— 字节码里的
 * 默认参数掩码为 64，运行时取的就是这个 0.8。
 *
 * [hints] 里的 `{他}` 会被替换成当前人设的称呼（无人设时用「你」）。
 */
data class StylePreset(
    val id: String,
    val name: String,
    val emoji: String,
    val scene: Scene,
    val tagline: String,
    val systemPrompt: String,
    val temperature: Float = 0.8f,
    val hints: List<String> = emptyList(),
)
