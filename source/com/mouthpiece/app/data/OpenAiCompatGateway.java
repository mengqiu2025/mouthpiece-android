package com.mouthpiece.app.data;

import androidx.core.app.NotificationCompat;
import com.mouthpiece.app.domain.AppSettings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AiGateway.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ&\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\bH\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/mouthpiece/app/data/OpenAiCompatGateway;", "Lcom/mouthpiece/app/data/AiGateway;", "settingsProvider", "Lkotlin/Function0;", "Lcom/mouthpiece/app/domain/AppSettings;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "complete", "", "system", "user", "temperature", "", "(Ljava/lang/String;Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "parse", "Lcom/mouthpiece/app/data/OpenAiCompatGateway$Parsed;", "body", "httpErrorMessage", "code", "", "looksLikeUnsupportedReasoningParam", "", NotificationCompat.CATEGORY_CALL, "Lcom/mouthpiece/app/data/OpenAiCompatGateway$Response;", "endpoint", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "friendlyNetworkError", "", "error", "execute", "connection", "Ljava/net/HttpURLConnection;", "open", "Response", "Parsed", "Companion", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenAiCompatGateway implements AiGateway {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int MAX_TOKENS = 2048;

    @Deprecated
    public static final int MAX_TOKENS_RETRY = 4096;

    @Deprecated
    public static final String REASONING_EFFORT = "max";
    private final Function0<AppSettings> settingsProvider;

    /* JADX INFO: renamed from: com.mouthpiece.app.data.OpenAiCompatGateway$request$1, reason: invalid class name */
    /* JADX INFO: compiled from: AiGateway.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.OpenAiCompatGateway", f = "AiGateway.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {142, 148, 159}, m = "request", n = {"config", "endpoint", "messages", "temperature", "config", "endpoint", "messages", "temperature"}, s = {"L$0", "L$1", "L$2", "F$0", "L$0", "L$1", "L$2", "F$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenAiCompatGateway.this.request(null, null, 0.0f, this);
        }
    }

    public OpenAiCompatGateway(Function0<AppSettings> settingsProvider) {
        Intrinsics.checkNotNullParameter(settingsProvider, "settingsProvider");
        this.settingsProvider = settingsProvider;
    }

    /* JADX INFO: compiled from: AiGateway.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/mouthpiece/app/data/OpenAiCompatGateway$Response;", "", "code", "", "body", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getBody", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class Response {
        private final String body;
        private final int code;

        public static /* synthetic */ Response copy$default(Response response, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = response.code;
            }
            if ((i2 & 2) != 0) {
                str = response.body;
            }
            return response.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final Response copy(int code, String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return new Response(code, body);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Response)) {
                return false;
            }
            Response response = (Response) other;
            return this.code == response.code && Intrinsics.areEqual(this.body, response.body);
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.body.hashCode();
        }

        public String toString() {
            return "Response(code=" + this.code + ", body=" + this.body + ")";
        }

        public Response(int code, String body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.code = code;
            this.body = body;
        }

        public final String getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }
    }

    /* JADX INFO: renamed from: com.mouthpiece.app.data.OpenAiCompatGateway$complete$2, reason: invalid class name */
    /* JADX INFO: compiled from: AiGateway.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.mouthpiece.app.data.OpenAiCompatGateway$complete$2", f = "AiGateway.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $system;
        final /* synthetic */ float $temperature;
        final /* synthetic */ String $user;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, float f, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$system = str;
            this.$user = str2;
            this.$temperature = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OpenAiCompatGateway.this.new AnonymousClass2(this.$system, this.$user, this.$temperature, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws IOException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        Object objWithTimeout = TimeoutKt.withTimeout(AiTimeouts.TOTAL_MS, new AnonymousClass1(OpenAiCompatGateway.this, this.$system, this.$user, this.$temperature, null), this);
                        if (objWithTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = objWithTimeout;
                        break;
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    return (String) $result;
                } catch (TimeoutCancellationException e) {
                    throw new IOException("请求超时（40 秒），请检查网络后重试");
                }
            } catch (TimeoutCancellationException e2) {
            }
        }

        /* JADX INFO: renamed from: com.mouthpiece.app.data.OpenAiCompatGateway$complete$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: AiGateway.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.mouthpiece.app.data.OpenAiCompatGateway$complete$2$1", f = "AiGateway.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            final /* synthetic */ String $system;
            final /* synthetic */ float $temperature;
            final /* synthetic */ String $user;
            int label;
            final /* synthetic */ OpenAiCompatGateway this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(OpenAiCompatGateway openAiCompatGateway, String str, String str2, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = openAiCompatGateway;
                this.$system = str;
                this.$user = str2;
                this.$temperature = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$system, this.$user, this.$temperature, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) throws JSONException, IOException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        Object objRequest = this.this$0.request(this.$system, this.$user, this.$temperature, this);
                        return objRequest == coroutine_suspended ? coroutine_suspended : objRequest;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @Override // com.mouthpiece.app.data.AiGateway
    public Object complete(String system, String user, float temperature, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(system, user, temperature, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0139  */
    /* JADX WARN: Code duplicated, block: B:38:0x013f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0142  */
    /* JADX WARN: Code duplicated, block: B:42:0x0156  */
    /* JADX WARN: Code duplicated, block: B:43:0x0158  */
    /* JADX WARN: Code duplicated, block: B:45:0x015b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0181 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0182  */
    /* JADX WARN: Code duplicated, block: B:53:0x018e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0194  */
    /* JADX WARN: Code duplicated, block: B:58:0x0197  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x01be  */
    /* JADX WARN: Code duplicated, block: B:68:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object request(String system, String user, float temperature, Continuation<? super String> continuation) throws JSONException, IOException {
        AnonymousClass1 anonymousClass1;
        OpenAiCompatGateway openAiCompatGateway;
        String endpoint;
        boolean z;
        Object objCall;
        JSONArray messages;
        float temperature2;
        AppSettings config;
        Response response;
        Object objCall2;
        int code;
        boolean z2;
        Parsed parsed;
        boolean z3;
        Object objCall3;
        OpenAiCompatGateway openAiCompatGateway2;
        Response retry;
        int code2;
        boolean z4;
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
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                openAiCompatGateway = this;
                AppSettings config2 = openAiCompatGateway.settingsProvider.invoke();
                if (StringsKt.isBlank(config2.getApiKey())) {
                    throw new IOException("未配置 API Key");
                }
                if (StringsKt.isBlank(config2.getBaseUrl())) {
                    throw new IOException("未配置接口地址");
                }
                if (StringsKt.isBlank(config2.getModel())) {
                    throw new IOException("未配置模型名");
                }
                endpoint = AiGatewayKt.chatCompletionsEndpoint(config2.getBaseUrl());
                JSONArray messages2 = new JSONArray().put(new JSONObject().put("role", "system").put("content", system)).put(new JSONObject().put("role", "user").put("content", user));
                String apiKey = config2.getApiKey();
                String strRequest$body = request$body(config2, temperature, messages2, 2048, REASONING_EFFORT);
                anonymousClass1.L$0 = config2;
                anonymousClass1.L$1 = endpoint;
                anonymousClass1.L$2 = messages2;
                anonymousClass1.F$0 = temperature;
                z = true;
                anonymousClass1.label = 1;
                objCall = openAiCompatGateway.call(endpoint, apiKey, strRequest$body, anonymousClass1);
                if (objCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                messages = messages2;
                temperature2 = temperature;
                config = config2;
                response = (Response) objCall;
                if (response.getCode() == 400 || !openAiCompatGateway.looksLikeUnsupportedReasoningParam(response.getBody())) {
                    code = response.getCode();
                    if (200 <= code || code >= 300) {
                        z2 = false;
                    } else {
                        z2 = z;
                    }
                    if (z2) {
                        throw new IOException(openAiCompatGateway.httpErrorMessage(response.getCode()));
                    }
                    parsed = openAiCompatGateway.parse(response.getBody());
                    if (parsed.getContent().length() == 0) {
                        z3 = z;
                    } else {
                        z3 = false;
                    }
                    if (z3 && Intrinsics.areEqual(parsed.getFinishReason(), "length")) {
                        String apiKey2 = config.getApiKey();
                        String strRequest$body2 = request$body(config, temperature2, messages, 4096, null);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 3;
                        objCall3 = openAiCompatGateway.call(endpoint, apiKey2, strRequest$body2, anonymousClass1);
                        if (objCall3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        openAiCompatGateway2 = openAiCompatGateway;
                        retry = (Response) objCall3;
                        code2 = retry.getCode();
                        if (200 <= code2 || code2 >= 300) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (!z4) {
                            throw new IOException(openAiCompatGateway2.httpErrorMessage(retry.getCode()));
                        }
                        parsed = openAiCompatGateway2.parse(retry.getBody());
                    }
                } else {
                    String apiKey3 = config.getApiKey();
                    String strRequest$body3 = request$body(config, temperature2, messages, 2048, null);
                    anonymousClass1.L$0 = config;
                    anonymousClass1.L$1 = endpoint;
                    anonymousClass1.L$2 = messages;
                    anonymousClass1.F$0 = temperature2;
                    anonymousClass1.label = 2;
                    objCall2 = openAiCompatGateway.call(endpoint, apiKey3, strRequest$body3, anonymousClass1);
                    if (objCall2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    response = (Response) objCall2;
                    code = response.getCode();
                    if (200 <= code) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        throw new IOException(openAiCompatGateway.httpErrorMessage(response.getCode()));
                    }
                    parsed = openAiCompatGateway.parse(response.getBody());
                    if (parsed.getContent().length() == 0) {
                        z3 = z;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        String apiKey4 = config.getApiKey();
                        String strRequest$body4 = request$body(config, temperature2, messages, 4096, null);
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 3;
                        objCall3 = openAiCompatGateway.call(endpoint, apiKey4, strRequest$body4, anonymousClass1);
                        if (objCall3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        openAiCompatGateway2 = openAiCompatGateway;
                        retry = (Response) objCall3;
                        code2 = retry.getCode();
                        if (200 <= code2) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            throw new IOException(openAiCompatGateway2.httpErrorMessage(retry.getCode()));
                        }
                        parsed = openAiCompatGateway2.parse(retry.getBody());
                    }
                }
                if (parsed.getContent().length() != 0) {
                    z = false;
                }
                if (z) {
                    throw new IOException("模型返回空内容");
                }
                return StringsKt.trim(parsed.getContent(), Typography.quote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, '\n', ' ', '\t');
            case 1:
                openAiCompatGateway = this;
                temperature2 = anonymousClass1.F$0;
                messages = (JSONArray) anonymousClass1.L$2;
                String endpoint2 = (String) anonymousClass1.L$1;
                AppSettings config3 = (AppSettings) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                objCall = $result;
                endpoint = endpoint2;
                z = true;
                config = config3;
                response = (Response) objCall;
                if (response.getCode() == 400) {
                    break;
                }
                code = response.getCode();
                if (200 <= code) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    throw new IOException(openAiCompatGateway.httpErrorMessage(response.getCode()));
                }
                parsed = openAiCompatGateway.parse(response.getBody());
                if (parsed.getContent().length() == 0) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    String apiKey5 = config.getApiKey();
                    String strRequest$body5 = request$body(config, temperature2, messages, 4096, null);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.label = 3;
                    objCall3 = openAiCompatGateway.call(endpoint, apiKey5, strRequest$body5, anonymousClass1);
                    if (objCall3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    openAiCompatGateway2 = openAiCompatGateway;
                    retry = (Response) objCall3;
                    code2 = retry.getCode();
                    if (200 <= code2) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        throw new IOException(openAiCompatGateway2.httpErrorMessage(retry.getCode()));
                    }
                    parsed = openAiCompatGateway2.parse(retry.getBody());
                }
                if (parsed.getContent().length() != 0) {
                    z = false;
                }
                if (z) {
                    return StringsKt.trim(parsed.getContent(), Typography.quote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, '\n', ' ', '\t');
                }
                throw new IOException("模型返回空内容");
            case 2:
                openAiCompatGateway = this;
                float temperature3 = anonymousClass1.F$0;
                JSONArray messages3 = (JSONArray) anonymousClass1.L$2;
                String endpoint3 = (String) anonymousClass1.L$1;
                config = (AppSettings) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                endpoint = endpoint3;
                z = true;
                messages = messages3;
                temperature2 = temperature3;
                objCall2 = $result;
                response = (Response) objCall2;
                code = response.getCode();
                if (200 <= code) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (z2) {
                    throw new IOException(openAiCompatGateway.httpErrorMessage(response.getCode()));
                }
                parsed = openAiCompatGateway.parse(response.getBody());
                if (parsed.getContent().length() == 0) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    String apiKey6 = config.getApiKey();
                    String strRequest$body6 = request$body(config, temperature2, messages, 4096, null);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.label = 3;
                    objCall3 = openAiCompatGateway.call(endpoint, apiKey6, strRequest$body6, anonymousClass1);
                    if (objCall3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    openAiCompatGateway2 = openAiCompatGateway;
                    retry = (Response) objCall3;
                    code2 = retry.getCode();
                    if (200 <= code2) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        throw new IOException(openAiCompatGateway2.httpErrorMessage(retry.getCode()));
                    }
                    parsed = openAiCompatGateway2.parse(retry.getBody());
                }
                if (parsed.getContent().length() != 0) {
                    z = false;
                }
                if (z) {
                    return StringsKt.trim(parsed.getContent(), Typography.quote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, '\n', ' ', '\t');
                }
                throw new IOException("模型返回空内容");
            case 3:
                openAiCompatGateway2 = this;
                ResultKt.throwOnFailure($result);
                objCall3 = $result;
                z = true;
                retry = (Response) objCall3;
                code2 = retry.getCode();
                if (200 <= code2) {
                    z4 = false;
                } else {
                    z4 = false;
                }
                if (!z4) {
                    throw new IOException(openAiCompatGateway2.httpErrorMessage(retry.getCode()));
                }
                parsed = openAiCompatGateway2.parse(retry.getBody());
                if (parsed.getContent().length() != 0) {
                    z = false;
                }
                if (z) {
                    return StringsKt.trim(parsed.getContent(), Typography.quote, Typography.leftDoubleQuote, Typography.rightDoubleQuote, '\n', ' ', '\t');
                }
                throw new IOException("模型返回空内容");
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String request$body(AppSettings config, float $temperature, JSONArray messages, int maxTokens, String effort) throws JSONException {
        JSONObject json = new JSONObject().put(SettingsStore.KEY_MODEL, config.getModel()).put("temperature", $temperature).put("max_tokens", maxTokens).put("messages", messages);
        if (effort != null) {
            json.put("reasoning_effort", effort);
        }
        String string = json.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: AiGateway.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/mouthpiece/app/data/OpenAiCompatGateway$Parsed;", "", "content", "", "finishReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getFinishReason", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class Parsed {
        private final String content;
        private final String finishReason;

        public static /* synthetic */ Parsed copy$default(Parsed parsed, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parsed.content;
            }
            if ((i & 2) != 0) {
                str2 = parsed.finishReason;
            }
            return parsed.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFinishReason() {
            return this.finishReason;
        }

        public final Parsed copy(String content, String finishReason) {
            Intrinsics.checkNotNullParameter(content, "content");
            return new Parsed(content, finishReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) other;
            return Intrinsics.areEqual(this.content, parsed.content) && Intrinsics.areEqual(this.finishReason, parsed.finishReason);
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + (this.finishReason == null ? 0 : this.finishReason.hashCode());
        }

        public String toString() {
            return "Parsed(content=" + this.content + ", finishReason=" + this.finishReason + ")";
        }

        public Parsed(String content, String finishReason) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.finishReason = finishReason;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getFinishReason() {
            return this.finishReason;
        }
    }

    private final Parsed parse(String body) throws IOException {
        Object objM7545constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            OpenAiCompatGateway openAiCompatGateway = this;
            objM7545constructorimpl = Result.m7545constructorimpl(new JSONObject(body));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7545constructorimpl = Result.m7545constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7548exceptionOrNullimpl(objM7545constructorimpl) != null) {
            throw new IOException("服务端返回的不是合法 JSON");
        }
        JSONObject root = (JSONObject) objM7545constructorimpl;
        JSONArray choices = root.optJSONArray("choices");
        if (choices == null) {
            throw new IOException("服务端返回缺少 choices 字段");
        }
        if (choices.length() == 0) {
            throw new IOException("模型没有返回任何候选结果");
        }
        JSONObject choice = choices.optJSONObject(0);
        if (choice == null) {
            throw new IOException("模型返回结构异常");
        }
        JSONObject message = choice.optJSONObject("message");
        if (message == null) {
            throw new IOException("模型返回结构异常");
        }
        String content = AiGatewayKt.optNullableString(message, "content");
        if (content == null) {
            content = "";
        }
        String finishReason = AiGatewayKt.optNullableString(choice, "finish_reason");
        return new Parsed(content, finishReason);
    }

    private final String httpErrorMessage(int code) {
        if (code == 400) {
            return "HTTP 400：请求被拒绝，通常是模型名或参数不被支持";
        }
        if (code == 401 || code == 403) {
            return "HTTP " + code + "：API Key 无效或没有权限";
        }
        if (code == 404) {
            return "HTTP 404：接口地址不存在，请检查是否填到 /v1 为止";
        }
        if (code == 408) {
            return "HTTP 408：服务端等待超时";
        }
        if (code == 413) {
            return "HTTP 413：请求体过大";
        }
        if (code == 429) {
            return "HTTP 429：请求过于频繁或余额/额度不足";
        }
        boolean z = false;
        if (500 <= code && code < 600) {
            z = true;
        }
        return z ? "HTTP " + code + "：服务端暂时不可用，请稍后重试" : "HTTP " + code;
    }

    private final boolean looksLikeUnsupportedReasoningParam(String body) {
        String lower = body.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lower, (CharSequence) "reasoning", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lower, (CharSequence) "effort", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object call(String endpoint, String apiKey, String body, Continuation<? super Response> continuation) throws IOException {
        final HttpURLConnection connection = open(endpoint, apiKey);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.mouthpiece.app.data.OpenAiCompatGateway$call$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                connection.disconnect();
            }
        });
        try {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m7545constructorimpl(execute(connection, body)));
        } catch (Throwable th) {
            connection.disconnect();
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m7545constructorimpl(ResultKt.createFailure(friendlyNetworkError(th))));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable friendlyNetworkError(Throwable error) {
        if (error instanceof SocketTimeoutException) {
            return new IOException("服务端响应超时（单次请求 25 秒），请稍后重试");
        }
        if (error instanceof UnknownHostException) {
            return new IOException("无法解析接口地址，请检查网络与「设置 → AI 服务」里的地址");
        }
        if (error instanceof ConnectException) {
            return new IOException("无法连接接口地址，请检查地址是否正确、网络是否可用");
        }
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response execute(HttpURLConnection connection, String body) throws IOException {
        OutputStream outputStream = connection.getOutputStream();
        try {
            byte[] bytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            String text = null;
            CloseableKt.closeFinally(outputStream, null);
            int code = connection.getResponseCode();
            InputStream stream = 200 <= code && code < 300 ? connection.getInputStream() : connection.getErrorStream();
            if (stream != null) {
                Reader inputStreamReader = new InputStreamReader(stream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text2 = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    text = text2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            }
            if (text == null) {
                text = "";
            }
            if (!(200 <= code && code < 300)) {
                connection.disconnect();
            }
            return new Response(code, text);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(outputStream, th3);
                throw th4;
            }
        }
    }

    private final HttpURLConnection open(String endpoint, String apiKey) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(endpoint).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(8000);
        httpURLConnection.setReadTimeout(AiTimeouts.READ_MS);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + apiKey);
        return httpURLConnection;
    }

    /* JADX INFO: compiled from: AiGateway.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mouthpiece/app/data/OpenAiCompatGateway$Companion;", "", "<init>", "()V", "MAX_TOKENS", "", "MAX_TOKENS_RETRY", "REASONING_EFFORT", "", "app_debug"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
