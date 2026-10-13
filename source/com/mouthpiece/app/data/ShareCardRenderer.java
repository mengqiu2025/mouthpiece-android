package com.mouthpiece.app.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.mouthpiece.app.domain.Reply;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ShareCardRenderer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J0\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020\u001cH\u0002J \u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\tH\u0002J.\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e0>2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020;H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/mouthpiece/app/data/ShareCardRenderer;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cardSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "boldTypeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "normalTypeface", "backgroundPaint", "Landroid/graphics/Paint;", "cardShadowPaint", "cardPaint", "chipBackgroundPaint", "quoteBarPaint", "dividerPaint", "badgeBackgroundPaint", "chipTextPaint", "tagPaint", "quoteLabelPaint", "incomingPaint", "replyPaint", "footerPaint", "badgeTextPaint", "render", "Ljava/io/File;", "incoming", "", "reply", "Lcom/mouthpiece/app/domain/Reply;", SettingsStore.KEY_WATERMARK, "", "(Ljava/lang/String;Lcom/mouthpiece/app/domain/Reply;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareIntent", "Landroid/content/Intent;", "file", "drawBackground", "", "canvas", "Landroid/graphics/Canvas;", "drawCard", "drawFooter", "drawBrandBadge", "left", "", "top", "width", "height", "save", "bitmap", "Landroid/graphics/Bitmap;", "pruneOldCards", "dir", "textPaint", "size", "color", "", "typeface", "wrap", "", "text", "paint", "maxWidth", "maxLines", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareCardRenderer {
    public static final float DESIGN_HEIGHT = 1440.0f;
    public static final float DESIGN_WIDTH = 1080.0f;
    public static final int MAX_KEPT_CARDS = 5;
    public static final int OUTPUT_HEIGHT = 960;
    public static final float OUTPUT_SCALE = 0.6666667f;
    public static final int OUTPUT_WIDTH = 720;
    public static final long RECENT_CARD_PROTECT_MS = 60000;
    public static final String SHARE_FILE_PREFIX = "share_card_";
    private final Paint backgroundPaint;
    private final Paint badgeBackgroundPaint;
    private final Paint badgeTextPaint;
    private final Typeface boldTypeface;
    private final Paint cardPaint;
    private final AtomicInteger cardSeq;
    private final Paint cardShadowPaint;
    private final Paint chipBackgroundPaint;
    private final Paint chipTextPaint;
    private final Context context;
    private final Paint dividerPaint;
    private final Paint footerPaint;
    private final Paint incomingPaint;
    private final Typeface normalTypeface;
    private final Paint quoteBarPaint;
    private final Paint quoteLabelPaint;
    private final Paint replyPaint;
    private final Paint tagPaint;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final int COLOR_BG_START = Color.parseColor("#8B6BFF");
    private static final int COLOR_BG_MID = Color.parseColor("#5B3BE0");
    private static final int COLOR_BG_END = Color.parseColor("#33209B");
    private static final int COLOR_PRIMARY = Color.parseColor("#5B3BE0");
    private static final int COLOR_CHIP_BG = Color.parseColor("#EFEBFF");
    private static final int COLOR_MUTED = Color.parseColor("#A0A0B4");
    private static final int COLOR_BODY_MUTED = Color.parseColor("#4A4A5C");
    private static final int COLOR_QUOTE_BAR = Color.parseColor("#E4DEFB");
    private static final int COLOR_DIVIDER = Color.parseColor("#EFEFF6");
    private static final int COLOR_TITLE = Color.parseColor("#17171F");
    private static final int COLOR_FOOTER = Color.parseColor("#D9D2FF");
    private static final int COLOR_CARD_SHADOW = Color.parseColor("#26000000");
    private static final int COLOR_BADGE_BG = Color.parseColor("#26FFFFFF");

    /* JADX INFO: renamed from: com.mouthpiece.app.data.ShareCardRenderer$render$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShareCardRenderer.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.ShareCardRenderer", f = "ShareCardRenderer.kt", i = {1}, l = {78, 90}, m = "render", n = {"bitmap"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShareCardRenderer.this.render(null, null, false, this);
        }
    }

    public ShareCardRenderer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.cardSeq = new AtomicInteger(0);
        this.boldTypeface = Typeface.create(Typeface.DEFAULT, 1);
        this.normalTypeface = Typeface.create(Typeface.DEFAULT, 0);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 1080.0f, 1440.0f, new int[]{COLOR_BG_START, COLOR_BG_MID, COLOR_BG_END}, new float[]{0.0f, 0.55f, 1.0f}, Shader.TileMode.CLAMP));
        this.backgroundPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(COLOR_CARD_SHADOW);
        this.cardShadowPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        this.cardPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setColor(COLOR_CHIP_BG);
        this.chipBackgroundPaint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setColor(COLOR_QUOTE_BAR);
        this.quoteBarPaint = paint5;
        Paint paint6 = new Paint();
        paint6.setColor(COLOR_DIVIDER);
        this.dividerPaint = paint6;
        Paint paint7 = new Paint(1);
        paint7.setColor(COLOR_BADGE_BG);
        this.badgeBackgroundPaint = paint7;
        int i = COLOR_PRIMARY;
        Typeface boldTypeface = this.boldTypeface;
        Intrinsics.checkNotNullExpressionValue(boldTypeface, "boldTypeface");
        this.chipTextPaint = textPaint(34.0f, i, boldTypeface);
        int i2 = COLOR_MUTED;
        Typeface normalTypeface = this.normalTypeface;
        Intrinsics.checkNotNullExpressionValue(normalTypeface, "normalTypeface");
        Paint paintTextPaint = textPaint(28.0f, i2, normalTypeface);
        paintTextPaint.setTextAlign(Paint.Align.RIGHT);
        this.tagPaint = paintTextPaint;
        int i3 = COLOR_MUTED;
        Typeface normalTypeface2 = this.normalTypeface;
        Intrinsics.checkNotNullExpressionValue(normalTypeface2, "normalTypeface");
        this.quoteLabelPaint = textPaint(30.0f, i3, normalTypeface2);
        int i4 = COLOR_BODY_MUTED;
        Typeface normalTypeface3 = this.normalTypeface;
        Intrinsics.checkNotNullExpressionValue(normalTypeface3, "normalTypeface");
        this.incomingPaint = textPaint(36.0f, i4, normalTypeface3);
        int i5 = COLOR_TITLE;
        Typeface boldTypeface2 = this.boldTypeface;
        Intrinsics.checkNotNullExpressionValue(boldTypeface2, "boldTypeface");
        this.replyPaint = textPaint(54.0f, i5, boldTypeface2);
        int i6 = COLOR_FOOTER;
        Typeface normalTypeface4 = this.normalTypeface;
        Intrinsics.checkNotNullExpressionValue(normalTypeface4, "normalTypeface");
        this.footerPaint = textPaint(30.0f, i6, normalTypeface4);
        Typeface boldTypeface3 = this.boldTypeface;
        Intrinsics.checkNotNullExpressionValue(boldTypeface3, "boldTypeface");
        Paint paintTextPaint2 = textPaint(40.0f, -1, boldTypeface3);
        paintTextPaint2.setTextAlign(Paint.Align.CENTER);
        this.badgeTextPaint = paintTextPaint2;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v9 */
    public final Object render(String str, Reply reply, boolean z, Continuation<? super File> continuation) {
        AnonymousClass1 anonymousClass1;
        ShareCardRenderer shareCardRenderer;
        Object objWithContext;
        Object objWithContext2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass2.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    shareCardRenderer = this;
                    CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
                    ShareCardRenderer$render$bitmap$1 shareCardRenderer$render$bitmap$1 = new ShareCardRenderer$render$bitmap$1(shareCardRenderer, str, reply, z, null);
                    anonymousClass2.label = 1;
                    objWithContext = BuildersKt.withContext(coroutineDispatcher, shareCardRenderer$render$bitmap$1, anonymousClass2);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
                    Bitmap bitmap = (Bitmap) objWithContext;
                    CoroutineDispatcher io = Dispatchers.getIO();
                    AnonymousClass2 anonymousClass3 = shareCardRenderer.new AnonymousClass2(bitmap, null);
                    anonymousClass2.L$0 = bitmap;
                    anonymousClass2.label = 2;
                    objWithContext2 = BuildersKt.withContext(io, anonymousClass3, anonymousClass2);
                    str = bitmap;
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (File) objWithContext2;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    shareCardRenderer = this;
                    objWithContext = obj;
                    Intrinsics.checkNotNullExpressionValue(objWithContext, "withContext(...)");
                    Bitmap bitmap2 = (Bitmap) objWithContext;
                    CoroutineDispatcher io2 = Dispatchers.getIO();
                    AnonymousClass2 anonymousClass4 = shareCardRenderer.new AnonymousClass2(bitmap2, null);
                    anonymousClass2.L$0 = bitmap2;
                    anonymousClass2.label = 2;
                    objWithContext2 = BuildersKt.withContext(io2, anonymousClass4, anonymousClass2);
                    str = bitmap2;
                    if (objWithContext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return (File) objWithContext2;
                case 2:
                    Bitmap bitmap3 = (Bitmap) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(obj);
                    objWithContext2 = obj;
                    str = bitmap3;
                    return (File) objWithContext2;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th) {
            str.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.data.ShareCardRenderer$render$2, reason: invalid class name */
    /* JADX INFO: compiled from: ShareCardRenderer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.ShareCardRenderer$render$2", f = "ShareCardRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Bitmap bitmap, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ShareCardRenderer.this.new AnonymousClass2(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return ShareCardRenderer.this.save(this.$bitmap);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Intent shareIntent(File file) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Uri uri = FileProvider.getUriForFile(this.context, this.context.getPackageName() + ".fileprovider", file);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.addFlags(1);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawBackground(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, 1080.0f, 1440.0f, this.backgroundPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawCard(Canvas canvas, String incoming, Reply reply) {
        RectF card = new RectF(72.0f, 150.0f, 1008.0f, 1230.0f);
        canvas.drawRoundRect(new RectF(card.left, card.top + 14.0f, card.right, card.bottom + 14.0f), 56.0f, 56.0f, this.cardShadowPaint);
        canvas.drawRoundRect(card, 56.0f, 56.0f, this.cardPaint);
        float contentLeft = 72.0f + 64.0f;
        float contentRight = 1008.0f - 64.0f;
        float contentWidth = contentRight - contentLeft;
        String chipText = reply.getEmoji() + " " + reply.getStyleName();
        float chipWidth = this.chipTextPaint.measureText(chipText) + 56.0f;
        float cardLeft = 150.0f + 64.0f + 64.0f;
        RectF chip = new RectF(contentLeft, 150.0f + 64.0f, contentLeft + chipWidth, cardLeft);
        canvas.drawRoundRect(chip, 32.0f, 32.0f, this.chipBackgroundPaint);
        canvas.drawText(chipText, chip.left + 28.0f, chip.centerY() - ((this.chipTextPaint.descent() + this.chipTextPaint.ascent()) / 2.0f), this.chipTextPaint);
        canvas.drawText("嘴替 · " + reply.getSource().getLabel() + "回复", contentRight, chip.centerY() - ((this.tagPaint.descent() + this.tagPaint.ascent()) / 2.0f), this.tagPaint);
        float cursor = chip.bottom + 76.0f;
        canvas.drawText("对方说", contentLeft, cursor, this.quoteLabelPaint);
        float cursor2 = cursor + 56.0f;
        List<String> listWrap = wrap(incoming, this.incomingPaint, contentWidth - 40.0f, 3);
        canvas.drawRoundRect(new RectF(contentLeft, cursor2 - 34.0f, 8.0f + contentLeft, cursor2 + (listWrap.size() * 52.0f)), 4.0f, 4.0f, this.quoteBarPaint);
        List<String> list = listWrap;
        int i = 0;
        Iterator it = list.iterator();
        float cursor3 = cursor2;
        while (it.hasNext()) {
            float contentLeft2 = contentLeft;
            canvas.drawText((String) it.next(), contentLeft2 + 28.0f, cursor3, this.incomingPaint);
            cursor3 += 52.0f;
            contentLeft = contentLeft2;
            list = list;
            i = i;
        }
        float contentLeft3 = contentLeft;
        float cursor4 = cursor3 + 24.0f;
        canvas.drawRect(contentLeft3, cursor4, contentRight, cursor4 + 2.0f, this.dividerPaint);
        float cursor5 = cursor4 + 84.0f;
        Iterable iterableWrap = wrap(reply.getText(), this.replyPaint, contentWidth, 9);
        int i2 = 0;
        Iterator it2 = iterableWrap.iterator();
        while (it2.hasNext()) {
            canvas.drawText((String) it2.next(), contentLeft3, cursor5, this.replyPaint);
            cursor5 += 82.0f;
            iterableWrap = iterableWrap;
            i2 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawFooter(Canvas canvas) {
        canvas.drawText("由「嘴替」生成 · 不知道怎么回，交给嘴替", 96.0f, 1332.0f, this.footerPaint);
        drawBrandBadge(canvas, 776.0f, 1282.0f, 208.0f, 96.0f);
    }

    private final void drawBrandBadge(Canvas canvas, float left, float top, float width, float height) {
        canvas.drawRoundRect(new RectF(left, top, left + width, top + height), height / 2.0f, height / 2.0f, this.badgeBackgroundPaint);
        float centerY = ((height / 2.0f) + top) - ((this.badgeTextPaint.descent() + this.badgeTextPaint.ascent()) / 2.0f);
        canvas.drawText("嘴替", (width / 2.0f) + left, centerY, this.badgeTextPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File save(Bitmap bitmap) {
        File dir = new File(this.context.getCacheDir(), "cards");
        dir.mkdirs();
        String name = SHARE_FILE_PREFIX + System.currentTimeMillis() + "_" + this.cardSeq.incrementAndGet() + ".png";
        File file = new File(dir, name);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                bitmap.recycle();
                pruneOldCards(dir);
                return file;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            bitmap.recycle();
            throw th3;
        }
    }

    private final void pruneOldCards(File dir) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ShareCardRenderer shareCardRenderer = this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                File[] fileArrListFiles = dir.listFiles(new FilenameFilter() { // from class: com.mouthpiece.app.data.ShareCardRenderer$$ExternalSyntheticLambda0
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file, String str) {
                        return ShareCardRenderer.pruneOldCards$lambda$19$lambda$14(file, str);
                    }
                });
                if (fileArrListFiles == null) {
                    fileArrListFiles = new File[0];
                }
                Collection arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    arrayList.add(TuplesKt.to(file, Long.valueOf(file.lastModified())));
                }
                List<Pair> list = (List) arrayList;
                if (list.isEmpty()) {
                    return;
                }
                Iterable iterableTake = CollectionsKt.take(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.mouthpiece.app.data.ShareCardRenderer$pruneOldCards$lambda$19$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((Number) ((Pair) t2).component2()).longValue()), Long.valueOf(((Number) ((Pair) t).component2()).longValue()));
                    }
                }), 5);
                Collection hashSet = new HashSet();
                Iterator it = iterableTake.iterator();
                while (it.hasNext()) {
                    hashSet.add((File) ((Pair) it.next()).component1());
                }
                HashSet hashSet2 = (HashSet) hashSet;
                for (Pair pair : list) {
                    File file2 = (File) pair.component1();
                    boolean z = jCurrentTimeMillis - ((Number) pair.component2()).longValue() < RECENT_CARD_PROTECT_MS;
                    if (!hashSet2.contains(file2) && !z) {
                        file2.delete();
                    }
                }
                Result.m7545constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7545constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pruneOldCards$lambda$19$lambda$14(File file, String name) {
        Intrinsics.checkNotNull(name);
        return StringsKt.endsWith$default(name, ".png", false, 2, (Object) null);
    }

    private final Paint textPaint(float size, int color, Typeface typeface) {
        Paint paint = new Paint(1);
        paint.setTextSize(size);
        paint.setColor(color);
        paint.setTypeface(typeface);
        return paint;
    }

    private final List<String> wrap(String text, Paint paint, float maxWidth, int maxLines) {
        String normalized = StringsKt.trim((CharSequence) StringsKt.replace$default(text, "\r", "", false, 4, (Object) null)).toString();
        if (normalized.length() == 0) {
            return CollectionsKt.emptyList();
        }
        HashMap widthCache = new HashMap(64);
        List lines = new ArrayList();
        StringBuilder current = new StringBuilder();
        Ref.FloatRef currentWidth = new Ref.FloatRef();
        int length = normalized.length();
        for (int i = 0; i < length; i++) {
            char ch = normalized.charAt(i);
            if (ch == '\n') {
                wrap$flush(lines, current, currentWidth);
            } else {
                if ((current.length() > 0) && currentWidth.element + wrap$charWidth(widthCache, paint, ch) > maxWidth && paint.measureText(new StringBuilder().append((Object) current).append(ch).toString()) > maxWidth) {
                    wrap$flush(lines, current, currentWidth);
                }
                current.append(ch);
                currentWidth.element += wrap$charWidth(widthCache, paint, ch);
            }
        }
        if (current.length() > 0) {
            wrap$flush(lines, current, currentWidth);
        }
        if (lines.size() <= maxLines) {
            return lines;
        }
        List<String> mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.take(lines, maxLines));
        String last = (String) CollectionsKt.last((List) mutableList);
        while (true) {
            if (!(last.length() > 0) || paint.measureText(last + "…") <= maxWidth) {
                break;
            }
            last = StringsKt.dropLast(last, 1);
        }
        mutableList.set(CollectionsKt.getLastIndex(mutableList), last + "…");
        return mutableList;
    }

    private static final float wrap$charWidth(HashMap<Character, Float> map, Paint $paint, char ch) {
        Float fValueOf;
        HashMap<Character, Float> map2 = map;
        Character chValueOf = Character.valueOf(ch);
        Float f = map2.get(chValueOf);
        if (f == null) {
            fValueOf = Float.valueOf($paint.measureText(String.valueOf(ch)));
            map2.put(chValueOf, fValueOf);
        } else {
            fValueOf = f;
        }
        return fValueOf.floatValue();
    }

    private static final void wrap$flush(List<String> list, StringBuilder current, Ref.FloatRef currentWidth) {
        String string = current.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        list.add(string);
        StringsKt.clear(current);
        currentWidth.element = 0.0f;
    }

    /* JADX INFO: compiled from: ShareCardRenderer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010!\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010#\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u0011\u0010'\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u0011\u0010)\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0012¨\u0006+"}, d2 = {"Lcom/mouthpiece/app/data/ShareCardRenderer$Companion;", "", "<init>", "()V", "DESIGN_WIDTH", "", "DESIGN_HEIGHT", "OUTPUT_WIDTH", "", "OUTPUT_HEIGHT", "OUTPUT_SCALE", "SHARE_FILE_PREFIX", "", "MAX_KEPT_CARDS", "RECENT_CARD_PROTECT_MS", "", "COLOR_BG_START", "getCOLOR_BG_START", "()I", "COLOR_BG_MID", "getCOLOR_BG_MID", "COLOR_BG_END", "getCOLOR_BG_END", "COLOR_PRIMARY", "getCOLOR_PRIMARY", "COLOR_CHIP_BG", "getCOLOR_CHIP_BG", "COLOR_MUTED", "getCOLOR_MUTED", "COLOR_BODY_MUTED", "getCOLOR_BODY_MUTED", "COLOR_QUOTE_BAR", "getCOLOR_QUOTE_BAR", "COLOR_DIVIDER", "getCOLOR_DIVIDER", "COLOR_TITLE", "getCOLOR_TITLE", "COLOR_FOOTER", "getCOLOR_FOOTER", "COLOR_CARD_SHADOW", "getCOLOR_CARD_SHADOW", "COLOR_BADGE_BG", "getCOLOR_BADGE_BG", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCOLOR_BG_START() {
            return ShareCardRenderer.COLOR_BG_START;
        }

        public final int getCOLOR_BG_MID() {
            return ShareCardRenderer.COLOR_BG_MID;
        }

        public final int getCOLOR_BG_END() {
            return ShareCardRenderer.COLOR_BG_END;
        }

        public final int getCOLOR_PRIMARY() {
            return ShareCardRenderer.COLOR_PRIMARY;
        }

        public final int getCOLOR_CHIP_BG() {
            return ShareCardRenderer.COLOR_CHIP_BG;
        }

        public final int getCOLOR_MUTED() {
            return ShareCardRenderer.COLOR_MUTED;
        }

        public final int getCOLOR_BODY_MUTED() {
            return ShareCardRenderer.COLOR_BODY_MUTED;
        }

        public final int getCOLOR_QUOTE_BAR() {
            return ShareCardRenderer.COLOR_QUOTE_BAR;
        }

        public final int getCOLOR_DIVIDER() {
            return ShareCardRenderer.COLOR_DIVIDER;
        }

        public final int getCOLOR_TITLE() {
            return ShareCardRenderer.COLOR_TITLE;
        }

        public final int getCOLOR_FOOTER() {
            return ShareCardRenderer.COLOR_FOOTER;
        }

        public final int getCOLOR_CARD_SHADOW() {
            return ShareCardRenderer.COLOR_CARD_SHADOW;
        }

        public final int getCOLOR_BADGE_BG() {
            return ShareCardRenderer.COLOR_BADGE_BG;
        }
    }
}
