package com.linecorp.linesdk.auth;

import android.content.Context;
import android.content.Intent;
import com.linecorp.linesdk.LineApiError;
import com.linecorp.linesdk.a.c;
import com.linecorp.linesdk.auth.LineAuthenticationConfig;
import com.linecorp.linesdk.auth.internal.LineAuthenticationActivity;
import com.linecorp.linesdk.b;
import java.util.Collections;
import java.util.List;

public class a {
    public static Intent a(Context context, String str) {
        return a(context, new LineAuthenticationConfig.a(str).a(), Collections.emptyList());
    }

    public static Intent a(Context context, LineAuthenticationConfig lineAuthenticationConfig, List<String> list) {
        if (!lineAuthenticationConfig.e()) {
            c.a(context);
        }
        return LineAuthenticationActivity.a(context, lineAuthenticationConfig, list);
    }

    public static LineLoginResult a(Intent intent) {
        if (intent == null) {
            return new LineLoginResult(b.INTERNAL_ERROR, new LineApiError("Callback intent is null"));
        }
        return LineAuthenticationActivity.a(intent);
    }
}
