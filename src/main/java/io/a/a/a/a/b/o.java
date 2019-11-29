package io.a.a.a.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.android.chat.core.model.PreChatField;
import io.a.a.a.c;

public class o {
    /* access modifiers changed from: protected */
    public String a(Context context) {
        int a2 = i.a(context, "google_app_id", PreChatField.STRING);
        if (a2 == 0) {
            return null;
        }
        c.h().a("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(a2));
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        return i.b(str).substring(0, 40);
    }

    public boolean b(Context context) {
        if (i.a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        boolean z = i.a(context, "google_app_id", PreChatField.STRING) != 0;
        boolean z2 = !TextUtils.isEmpty(new g().c(context)) || !TextUtils.isEmpty(new g().d(context));
        if (!z || z2) {
            return false;
        }
        return true;
    }
}
