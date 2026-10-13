package com.mouthpiece.app.model

/** 说话对象档案。 */
data class Persona(
    val id: String,
    val name: String,
    val relation: String,
    val tone: String,
    val taboo: String,
) {
    /** 列表展示用：`名字（关系）`；关系为空时只显示名字。 */
    val displayName: String
        get() = if (relation.isBlank()) name else "$name（$relation）"
}
