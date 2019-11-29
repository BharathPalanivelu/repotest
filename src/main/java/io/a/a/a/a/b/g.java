package io.a.a.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.salesforce.android.chat.core.model.PreChatField;
import io.a.a.a.c;
import io.a.a.a.l;

public class g {
    /* access modifiers changed from: protected */
    public String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        String c2 = c(context);
        if (TextUtils.isEmpty(c2)) {
            c2 = d(context);
        }
        if (TextUtils.isEmpty(c2)) {
            c2 = b(context);
        }
        if (TextUtils.isEmpty(c2)) {
            e(context);
        }
        return c2;
    }

    /* access modifiers changed from: protected */
    public String b(Context context) {
        return new o().a(context);
    }

    /* access modifiers changed from: protected */
    public String c(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    c.h().a("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                c.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e2) {
                e = e2;
                str = string;
                l h = c.h();
                h.a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            l h2 = c.h();
            h2.a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    public String d(Context context) {
        int a2 = i.a(context, "io.fabric.ApiKey", PreChatField.STRING);
        if (a2 == 0) {
            c.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a2 = i.a(context, "com.crashlytics.ApiKey", PreChatField.STRING);
        }
        if (a2 != 0) {
            return context.getResources().getString(a2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void e(Context context) {
        if (c.i() || i.i(context)) {
            throw new IllegalArgumentException(a());
        }
        c.h().e("Fabric", a());
    }
}
