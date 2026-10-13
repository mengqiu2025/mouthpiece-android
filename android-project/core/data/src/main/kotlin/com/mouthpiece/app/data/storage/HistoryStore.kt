package com.mouthpiece.app.data.storage

import android.content.Context
import com.mouthpiece.app.model.HistoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import java.io.File
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * 历史记录持久化。
 *
 * 为什么不放 SharedPreferences：条数多、单条大，且需要「不能丢」的保障。
 * 具体策略：
 * 1. 主文件 `history.json`，备份 `history.json.bak`
 * 2. 写入走「写临时文件 → 备份旧文件 → 改名替换」的原子流程
 * 3. 500 ms 防抖合并写请求，避免连续操作频繁落盘
 * 4. 主动 [flush] 由 `Application.onTrimMemory(TRIM_MEMORY_UI_HIDDEN)` 触发
 *
 * 编解码见 [HistoryCodec]，纯函数变换见 [HistoryMutations]。
 */
class HistoryStore(context: Context) {

    private val file = File(context.filesDir, "history.json")
    private val backup = File(context.filesDir, "history.json.bak")

    private val io = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val writeLock = ReentrantLock()
    private val pendingWrite = MutableStateFlow<List<HistoryItem>?>(null)

    private val _items = MutableStateFlow(read())
    val items: StateFlow<List<HistoryItem>> = _items.asStateFlow()

    /** 从已加载数据里的最大 id 起步，保证单调递增。 */
    private val idCounter = AtomicLong(_items.value.maxOfOrNull { it.id } ?: 0L)

    init {
        io.launch {
            pendingWrite.filterNotNull().collectLatest { list ->
                delay(WRITE_DEBOUNCE_MS)
                val persisted = runCatching { writeAtomically(HistoryCodec.encode(list)) }.isSuccess
                // 只有「确实写成功」且「期间没有新的写请求」才清空待写队列
                if (persisted && pendingWrite.value === list) {
                    pendingWrite.value = null
                }
            }
        }
    }

    private fun nextId(): Long = idCounter.incrementAndGet()

    // -----------------------------------------------------------------------
    // 读取
    // -----------------------------------------------------------------------

    private fun read(): List<HistoryItem> {
        // 清掉上次写入中断残留的临时文件
        runCatching { File(file.parentFile, file.name + ".tmp").delete() }

        val raw = runCatching {
            if (file.exists()) file.readText(Charsets.UTF_8) else null
        }.getOrNull() ?: return readBackup()

        return HistoryCodec.decodeOrNull(raw) ?: recoverFromBackup()
    }

    /** 主文件坏了 → 用备份恢复，并把备份内容写回主文件。 */
    private fun recoverFromBackup(): List<HistoryItem> {
        val fromBackup = readBackup()
        if (fromBackup.isNotEmpty()) {
            runCatching { writeAtomically(HistoryCodec.encode(fromBackup)) }
        }
        return fromBackup
    }

    private fun readBackup(): List<HistoryItem> = runCatching {
        if (!backup.exists()) return@runCatching emptyList()
        HistoryCodec.decodeOrNull(backup.readText(Charsets.UTF_8)) ?: emptyList()
    }.getOrElse { emptyList() }

    // -----------------------------------------------------------------------
    // 写入
    // -----------------------------------------------------------------------

    /** 只更新内存态 + 投递写请求，实际落盘由防抖协程完成。 */
    private fun write(list: List<HistoryItem>) {
        val trimmed = list.take(MAX_ITEMS)
        _items.value = trimmed
        pendingWrite.value = trimmed
    }

    /** 原子写：临时文件 → 备份旧文件 → 改名替换；改名失败则直接覆盖写。 */
    private fun writeAtomically(content: String) {
        writeLock.withLock {
            val dir = file.parentFile ?: return
            if (!dir.exists()) dir.mkdirs()

            val tmp = File(dir, file.name + ".tmp")
            tmp.writeText(content, Charsets.UTF_8)

            if (file.exists()) {
                runCatching { file.copyTo(backup, overwrite = true) }
            }

            if (!tmp.renameTo(file)) {
                file.writeText(content, Charsets.UTF_8)
                runCatching { tmp.delete() }
            }
        }
    }

    /** 立即落盘（如果还有待写内容）。由 `Application` 在退到后台时调用。 */
    fun flush() {
        val value = pendingWrite.value ?: return

        val acquired = runCatching {
            writeLock.tryLock(FLUSH_LOCK_TIMEOUT_MS, TimeUnit.MILLISECONDS)
        }.getOrDefault(false)

        // 拿不到锁就放弃 —— 防抖写入器稍后会处理，不要在这里阻塞
        if (!acquired) return

        try {
            runCatching { writeAtomically(HistoryCodec.encode(value)) }
            if (pendingWrite.value === value) {
                pendingWrite.value = null
            }
        } finally {
            writeLock.unlock()
        }
    }

    // -----------------------------------------------------------------------
    // 变更
    // -----------------------------------------------------------------------

    /** 新增一条历史（新条目排在最前）。 */
    fun add(incoming: String, reply: String, styleName: String) {
        val item = HistoryItem(
            id = nextId(),
            incoming = incoming,
            reply = reply,
            styleName = styleName,
            createdAt = System.currentTimeMillis(),
            favorite = false,
        )
        write(listOf(item) + _items.value)
    }

    fun exists(incoming: String, reply: String): Boolean =
        _items.value.any { it.incoming == incoming && it.reply == reply }

    /**
     * 按内容切换收藏。
     *
     * @return 切换**之后**的收藏状态
     */
    fun toggleFavorite(incoming: String, reply: String, styleName: String): Boolean {
        val next = HistoryMutations.toggleFavorite(
            items = _items.value,
            incoming = incoming,
            reply = reply,
            styleName = styleName,
            newId = ::nextId,
            now = System.currentTimeMillis(),
        )
        write(next)
        return next.firstOrNull { it.incoming == incoming && it.reply == reply }?.favorite == true
    }

    /** 按 id 切换收藏（历史列表页用）。 */
    fun toggleFavorite(id: Long) {
        write(_items.value.map { if (it.id == id) it.copy(favorite = !it.favorite) else it })
    }

    fun delete(id: Long) {
        write(_items.value.filterNot { it.id == id })
    }

    fun clear() = write(emptyList())

    companion object {
        const val MAX_ITEMS = 500
        const val WRITE_DEBOUNCE_MS = 500L
        const val FLUSH_LOCK_TIMEOUT_MS = 50L
    }
}
