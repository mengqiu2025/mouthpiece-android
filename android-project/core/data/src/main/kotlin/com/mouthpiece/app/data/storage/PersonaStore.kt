package com.mouthpiece.app.data.storage

import android.content.Context
import com.mouthpiece.app.model.Persona
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.json.JSONArray
import org.json.JSONObject

/**
 * 说话对象档案持久化（SharedPreferences，单键存 JSON 数组）。
 *
 * 任何解析异常都退化为空列表 —— 档案丢了不影响主流程。
 */
class PersonaStore(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _personas = MutableStateFlow(read())
    val personas: StateFlow<List<Persona>> = _personas.asStateFlow()

    /** 单键存 JSON 数组。任何解析异常都退化为空列表。 */
    private fun read(): List<Persona> {
        val raw = prefs.getString(KEY, null) ?: return emptyList()
        return runCatching {
            val array = JSONArray(raw)
            (0 until array.length()).map { index ->
                val json = array.getJSONObject(index)
                Persona(
                    id = json.optString("id"),
                    name = json.optString("name"),
                    relation = json.optString("relation"),
                    tone = json.optString("tone"),
                    taboo = json.optString("taboo"),
                )
            }
        }.getOrElse { emptyList() }
    }

    private fun write(list: List<Persona>) {
        val array = JSONArray()
        for (persona in list) {
            array.put(
                JSONObject()
                    .put("id", persona.id)
                    .put("name", persona.name)
                    .put("relation", persona.relation)
                    .put("tone", persona.tone)
                    .put("taboo", persona.taboo),
            )
        }
        prefs.edit().putString(KEY, array.toString()).apply()
        _personas.value = list
    }

    /** 有则替换、无则追加（按 id 匹配）。 */
    fun upsert(persona: Persona) {
        val list = _personas.value.toMutableList()
        val index = list.indexOfFirst { it.id == persona.id }
        if (index >= 0) list[index] = persona else list.add(persona)
        write(list)
    }

    fun delete(id: String) {
        write(_personas.value.filterNot { it.id == id })
    }

    fun find(id: String?): Persona? {
        if (id == null) return null
        return _personas.value.firstOrNull { it.id == id }
    }

    fun clear() = write(emptyList())

    companion object {
        private const val PREFS_NAME = "mouthpiece_personas"
        const val KEY = "personas_json"
    }
}
