package com.mouthpiece.app.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AiGateway.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0006"}, d2 = {"chatCompletionsEndpoint", "", "baseUrl", "optNullableString", "Lorg/json/JSONObject;", "key", "app_debug"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AiGatewayKt {
    public static final String chatCompletionsEndpoint(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        String trimmed = StringsKt.trimEnd(StringsKt.trim((CharSequence) baseUrl).toString(), '/');
        if (trimmed.length() == 0) {
            return "";
        }
        return StringsKt.endsWith$default(trimmed, "/chat/completions", false, 2, (Object) null) ? trimmed : trimmed + "/chat/completions";
    }

    public static final String optNullableString(JSONObject $this$optNullableString, String key) {
        Intrinsics.checkNotNullParameter($this$optNullableString, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if ($this$optNullableString.isNull(key)) {
            return null;
        }
        String strOptString = $this$optNullableString.optString(key);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String raw = StringsKt.trim((CharSequence) strOptString).toString();
        if ((raw.length() == 0) || Intrinsics.areEqual(raw, "null") || Intrinsics.areEqual(raw, "undefined")) {
            return null;
        }
        return raw;
    }
}
