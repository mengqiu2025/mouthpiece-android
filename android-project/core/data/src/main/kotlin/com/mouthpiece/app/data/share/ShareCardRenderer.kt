package com.mouthpiece.app.data.share

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.Typeface
import androidx.core.content.FileProvider
import com.mouthpiece.app.model.Reply
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.concurrent.atomic.AtomicInteger

/**
 * 分享卡片渲染。
 *
 * 纯 [Canvas] 手绘，**没有任何布局文件** —— 所有元素坐标都写在代码里。
 *
 * 坐标系：设计稿是 1080×1440，输出位图是 720×960，
 * 靠 `canvas.scale(2/3, 2/3)` 缩放，所以下面所有绘制坐标都用设计稿数值。
 */
class ShareCardRenderer(private val context: Context) {

    private val cardSeq = AtomicInteger(0)

    private val boldTypeface: Typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
    private val normalTypeface: Typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)

    // ---- 背景：对角线性渐变 ----
    private val backgroundPaint = Paint().apply {
        shader = LinearGradient(
            0f, 0f, DESIGN_WIDTH, DESIGN_HEIGHT,
            intArrayOf(COLOR_BG_START, COLOR_BG_MID, COLOR_BG_END),
            floatArrayOf(0f, 0.55f, 1f),
            Shader.TileMode.CLAMP,
        )
    }

    private val cardShadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = COLOR_CARD_SHADOW }
    private val cardPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.WHITE }
    private val chipBackgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = COLOR_CHIP_BG }
    private val quoteBarPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = COLOR_QUOTE_BAR }
    private val dividerPaint = Paint().apply { color = COLOR_DIVIDER }
    private val badgeBackgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = COLOR_BADGE_BG }

    private val chipTextPaint = textPaint(34f, COLOR_PRIMARY, boldTypeface)

    private val tagPaint = textPaint(28f, COLOR_MUTED, normalTypeface).apply {
        textAlign = Paint.Align.RIGHT
    }
    private val quoteLabelPaint = textPaint(30f, COLOR_MUTED, normalTypeface)
    private val incomingPaint = textPaint(36f, COLOR_BODY_MUTED, normalTypeface)
    private val replyPaint = textPaint(54f, COLOR_TITLE, boldTypeface)
    private val footerPaint = textPaint(30f, COLOR_FOOTER, normalTypeface)

    private val badgeTextPaint = textPaint(40f, Color.WHITE, boldTypeface).apply {
        textAlign = Paint.Align.CENTER
    }

    // -----------------------------------------------------------------------
    // 对外入口
    // -----------------------------------------------------------------------

    /**
     * 渲染并保存一张分享卡片。
     *
     * 绘制在 [Dispatchers.Default] 上做（CPU 密集），写文件在 [Dispatchers.IO] 上做。
     *
     * @return 生成的 PNG 文件，可直接交给 [shareIntent]
     */
    suspend fun render(incoming: String, reply: Reply, watermark: Boolean): File {
        val bitmap = withContext(Dispatchers.Default) { renderBitmap(incoming, reply, watermark) }
        return try {
            withContext(Dispatchers.IO) { save(bitmap) }
        } catch (e: Throwable) {
            bitmap.recycle()
            throw e
        }
    }

    /** 构造系统分享 Intent（通过 FileProvider 授权读权限）。 */
    fun shareIntent(file: File): Intent {
        val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
        return Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    // -----------------------------------------------------------------------
    // 绘制
    // -----------------------------------------------------------------------

    private fun renderBitmap(incoming: String, reply: Reply, watermark: Boolean): Bitmap {
        val bitmap = Bitmap.createBitmap(OUTPUT_WIDTH, OUTPUT_HEIGHT, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.scale(SCALE, SCALE)

        drawBackground(canvas)
        drawCard(canvas, incoming, reply)
        if (watermark) drawFooter(canvas)

        return bitmap
    }

    private fun drawBackground(canvas: Canvas) {
        canvas.drawRect(0f, 0f, DESIGN_WIDTH, DESIGN_HEIGHT, backgroundPaint)
    }

    private fun drawCard(canvas: Canvas, incoming: String, reply: Reply) {
        val card = RectF(72f, 150f, 1008f, 1230f)

        // 卡片 + 下移 14 的投影
        canvas.drawRoundRect(
            RectF(card.left, card.top + 14f, card.right, card.bottom + 14f),
            56f, 56f, cardShadowPaint,
        )
        canvas.drawRoundRect(card, 56f, 56f, cardPaint)

        val contentLeft = card.left + CONTENT_PADDING
        val contentRight = card.right - CONTENT_PADDING
        val contentWidth = contentRight - contentLeft

        // ---- 风格 chip ----
        val chipText = "${reply.emoji} ${reply.styleName}"
        val chipWidth = chipTextPaint.measureText(chipText) + 56f
        val chipTop = card.top + CONTENT_PADDING
        val chipBottom = chipTop + 64f
        val chip = RectF(contentLeft, chipTop, contentLeft + chipWidth, chipBottom)
        canvas.drawRoundRect(chip, 32f, 32f, chipBackgroundPaint)
        canvas.drawText(
            chipText,
            chip.left + 28f,
            chip.centerY() - (chipTextPaint.descent() + chipTextPaint.ascent()) / 2f,
            chipTextPaint,
        )

        // ---- 右侧来源标记 ----
        canvas.drawText(
            "嘴替 · ${reply.source.label}回复",
            contentRight,
            chip.centerY() - (tagPaint.descent() + tagPaint.ascent()) / 2f,
            tagPaint,
        )

        // ---- 对方说 ----
        var cursor = chip.bottom + 76f
        canvas.drawText("对方说", contentLeft, cursor, quoteLabelPaint)
        cursor += 56f

        val incomingLines = wrap(incoming, incomingPaint, contentWidth - 40f, MAX_INCOMING_LINES)
        canvas.drawRoundRect(
            RectF(contentLeft, cursor - 34f, contentLeft + 8f, cursor + incomingLines.size * 52f),
            4f, 4f, quoteBarPaint,
        )
        for (line in incomingLines) {
            canvas.drawText(line, contentLeft + 28f, cursor, incomingPaint)
            cursor += 52f
        }

        // ---- 分割线 ----
        cursor += 24f
        canvas.drawRect(contentLeft, cursor, contentRight, cursor + 2f, dividerPaint)

        // ---- 回复正文 ----
        cursor += 84f
        val replyLines = wrap(reply.text, replyPaint, contentWidth, MAX_REPLY_LINES)
        for (line in replyLines) {
            canvas.drawText(line, contentLeft, cursor, replyPaint)
            cursor += 82f
        }
    }

    private fun drawFooter(canvas: Canvas) {
        canvas.drawText("由「嘴替」生成 · 不知道怎么回，交给嘴替", 96f, 1332f, footerPaint)
        drawBrandBadge(canvas, 776f, 1282f, 208f, 96f)
    }

    private fun drawBrandBadge(canvas: Canvas, left: Float, top: Float, width: Float, height: Float) {
        canvas.drawRoundRect(
            RectF(left, top, left + width, top + height),
            height / 2f, height / 2f, badgeBackgroundPaint,
        )
        val centerY = (height / 2f + top) - (badgeTextPaint.descent() + badgeTextPaint.ascent()) / 2f
        canvas.drawText("嘴替", width / 2f + left, centerY, badgeTextPaint)
    }

    // -----------------------------------------------------------------------
    // 保存与清理
    // -----------------------------------------------------------------------

    private fun save(bitmap: Bitmap): File {
        val dir = File(context.cacheDir, "cards")
        dir.mkdirs()

        val name = "$SHARE_FILE_PREFIX${System.currentTimeMillis()}_${cardSeq.incrementAndGet()}.png"
        val file = File(dir, name)

        try {
            file.outputStream().use { out ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            bitmap.recycle()
            pruneOldCards(dir)
            return file
        } catch (e: Throwable) {
            bitmap.recycle()
            throw e
        }
    }

    /**
     * 只保留最新的 [MAX_KEPT_CARDS] 张，但**60 秒内生成的不删** ——
     * 避免用户刚点分享、图就被清掉。
     */
    private fun pruneOldCards(dir: File) {
        runCatching {
            val now = System.currentTimeMillis()
            val files = dir.listFiles { _, name -> name.endsWith(".png") } ?: return@runCatching
            if (files.isEmpty()) return@runCatching

            val entries = files.map { it to it.lastModified() }
            val keep = entries
                .sortedByDescending { it.second }
                .take(MAX_KEPT_CARDS)
                .map { it.first }
                .toHashSet()

            for ((file, modified) in entries) {
                val isRecent = now - modified < RECENT_CARD_PROTECT_MS
                if (file !in keep && !isRecent) file.delete()
            }
        }
    }

    // -----------------------------------------------------------------------
    // 工具
    // -----------------------------------------------------------------------

    private fun textPaint(size: Float, color: Int, typeface: Typeface): Paint =
        Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = size
            this.color = color
            this.typeface = typeface
        }

    /**
     * 逐字符折行（中文没有空格，不能按词折）。
     *
     * 超出行数上限时，最后一行末尾用 `…` 截断。
     */
    private fun wrap(text: String, paint: Paint, maxWidth: Float, maxLines: Int): List<String> {
        val normalized = text.replace("\r", "").trim()
        if (normalized.isEmpty()) return emptyList()

        val widthCache = HashMap<Char, Float>(64)
        val lines = mutableListOf<String>()
        val current = StringBuilder()
        var currentWidth = 0f

        fun flush() {
            lines.add(current.toString())
            current.clear()
            currentWidth = 0f
        }

        for (ch in normalized) {
            if (ch == '\n') {
                flush()
                continue
            }
            val charWidth = widthCache.getOrPut(ch) { paint.measureText(ch.toString()) }
            if (current.isNotEmpty() &&
                currentWidth + charWidth > maxWidth &&
                paint.measureText(current.toString() + ch) > maxWidth
            ) {
                flush()
            }
            current.append(ch)
            currentWidth += charWidth
        }
        if (current.isNotEmpty()) flush()

        if (lines.size <= maxLines) return lines

        val result = lines.take(maxLines).toMutableList()
        var last = result.last()
        while (last.isNotEmpty() && paint.measureText(last + "…") > maxWidth) {
            last = last.dropLast(1)
        }
        result[result.lastIndex] = last + "…"
        return result
    }

    companion object {
        const val DESIGN_WIDTH = 1080f
        const val DESIGN_HEIGHT = 1440f
        const val OUTPUT_WIDTH = 720
        const val OUTPUT_HEIGHT = 960

        const val MAX_KEPT_CARDS = 5
        const val RECENT_CARD_PROTECT_MS = 60_000L
        const val SHARE_FILE_PREFIX = "share_card_"

        private const val SCALE = 2f / 3f
        private const val CONTENT_PADDING = 64f
        private const val MAX_INCOMING_LINES = 3
        private const val MAX_REPLY_LINES = 9

        private val COLOR_BG_START = Color.parseColor("#8B6BFF")
        private val COLOR_BG_MID = Color.parseColor("#5B3BE0")
        private val COLOR_BG_END = Color.parseColor("#33209B")
        private val COLOR_PRIMARY = Color.parseColor("#5B3BE0")
        private val COLOR_CHIP_BG = Color.parseColor("#EFEBFF")
        private val COLOR_MUTED = Color.parseColor("#A0A0B4")
        private val COLOR_BODY_MUTED = Color.parseColor("#4A4A5C")
        private val COLOR_QUOTE_BAR = Color.parseColor("#E4DEFB")
        private val COLOR_DIVIDER = Color.parseColor("#EFEFF6")
        private val COLOR_TITLE = Color.parseColor("#17171F")
        private val COLOR_FOOTER = Color.parseColor("#D9D2FF")
        private val COLOR_CARD_SHADOW = Color.parseColor("#26000000")
        private val COLOR_BADGE_BG = Color.parseColor("#26FFFFFF")
    }
}
