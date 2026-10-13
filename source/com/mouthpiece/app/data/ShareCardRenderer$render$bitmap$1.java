package com.mouthpiece.app.data;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.mouthpiece.app.domain.Reply;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ShareCardRenderer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00070\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.mouthpiece.app.data.ShareCardRenderer$render$bitmap$1", f = "ShareCardRenderer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ShareCardRenderer$render$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $incoming;
    final /* synthetic */ Reply $reply;
    final /* synthetic */ boolean $watermark;
    int label;
    final /* synthetic */ ShareCardRenderer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShareCardRenderer$render$bitmap$1(ShareCardRenderer shareCardRenderer, String str, Reply reply, boolean z, Continuation<? super ShareCardRenderer$render$bitmap$1> continuation) {
        super(2, continuation);
        this.this$0 = shareCardRenderer;
        this.$incoming = str;
        this.$reply = reply;
        this.$watermark = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareCardRenderer$render$bitmap$1(this.this$0, this.$incoming, this.$reply, this.$watermark, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((ShareCardRenderer$render$bitmap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ShareCardRenderer.OUTPUT_WIDTH, ShareCardRenderer.OUTPUT_HEIGHT, Bitmap.Config.ARGB_8888);
                ShareCardRenderer shareCardRenderer = this.this$0;
                String str = this.$incoming;
                Reply reply = this.$reply;
                boolean z = this.$watermark;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.scale(0.6666667f, 0.6666667f);
                shareCardRenderer.drawBackground(canvas);
                shareCardRenderer.drawCard(canvas, str, reply);
                if (z) {
                    shareCardRenderer.drawFooter(canvas);
                }
                return bitmapCreateBitmap;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
