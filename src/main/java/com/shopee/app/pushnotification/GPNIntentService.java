package com.shopee.app.pushnotification;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.common.util.UriUtil;
import com.garena.android.appkit.tools.b;
import com.shopee.app.application.ar;
import com.shopee.app.util.q;
import com.shopee.id.R;
import org.json.JSONObject;

public class GPNIntentService extends IntentService {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18492a;

        /* renamed from: b  reason: collision with root package name */
        public String f18493b;

        /* renamed from: c  reason: collision with root package name */
        public String f18494c;

        /* renamed from: d  reason: collision with root package name */
        public String f18495d;

        /* renamed from: e  reason: collision with root package name */
        public String f18496e;
    }

    public GPNIntentService() {
        super("MessageIntentService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        try {
            a(intent.getExtras().getString("DATA"));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) throws Exception {
        JSONObject jSONObject;
        String str2;
        String str3;
        a aVar = new a();
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            q fabricClient = ar.f().e().fabricClient();
            fabricClient.a((Throwable) e2, "crash_from:GCMNotification | " + str);
            JSONObject jSONObject2 = new JSONObject();
            com.garena.android.appkit.d.a.a(e2);
            jSONObject = jSONObject2;
        }
        JSONObject jSONObject3 = null;
        try {
            if (jSONObject.has(UriUtil.LOCAL_CONTENT_SCHEME)) {
                jSONObject3 = new JSONObject(jSONObject.getString(UriUtil.LOCAL_CONTENT_SCHEME));
            }
        } catch (Exception e3) {
            q fabricClient2 = ar.f().e().fabricClient();
            fabricClient2.a((Throwable) e3, "crash_from:GCMNotification | " + str);
            com.garena.android.appkit.d.a.a(e3);
        }
        if (jSONObject3 != null) {
            try {
                if (jSONObject3.has(UriUtil.LOCAL_CONTENT_SCHEME)) {
                    str3 = jSONObject3.getString(UriUtil.LOCAL_CONTENT_SCHEME);
                } else {
                    str3 = b.e(R.string.sp_new_notification_default_text);
                }
                aVar.f18492a = str3;
                if (jSONObject3.has("imgid")) {
                    aVar.f18494c = jSONObject3.getString("imgid");
                }
            } catch (Exception e4) {
                q fabricClient3 = ar.f().e().fabricClient();
                fabricClient3.a((Throwable) e4, "crash_from:GCMNotification | " + str);
                aVar.f18492a = b.e(R.string.sp_new_notification_default_text);
                com.garena.android.appkit.d.a.a(e4);
            }
        } else {
            if (jSONObject.has(UriUtil.LOCAL_CONTENT_SCHEME)) {
                str2 = jSONObject.getString(UriUtil.LOCAL_CONTENT_SCHEME);
            } else {
                str2 = b.e(R.string.sp_new_notification_default_text);
            }
            aVar.f18492a = str2;
        }
        if (jSONObject.has("title")) {
            aVar.f18495d = jSONObject.getString("title");
        }
        String str4 = "";
        aVar.f18493b = jSONObject.has("parameter") ? jSONObject.getString("parameter") : str4;
        if (jSONObject.has("apprl")) {
            str4 = jSONObject.getString("apprl");
        }
        aVar.f18496e = str4;
        c.a(aVar);
    }
}
