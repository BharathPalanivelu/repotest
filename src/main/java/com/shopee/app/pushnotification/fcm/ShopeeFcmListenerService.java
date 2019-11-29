package com.shopee.app.pushnotification.fcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.i;
import com.appsflyer.AppsFlyerLib;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.tools.b;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.shopee.app.application.ar;
import com.shopee.app.h.o;
import com.shopee.app.network.e;
import com.shopee.app.pushnotification.GPNIntentService;
import com.shopee.app.pushnotification.c;
import com.shopee.app.pushnotification.d;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.util.g.a;
import com.shopee.app.util.q;
import com.shopee.id.R;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ShopeeFcmListenerService extends FirebaseMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f18541a = "";

    /* renamed from: b  reason: collision with root package name */
    private a f18542b = new a() {
        public void a(com.shopee.app.network.c.d.a aVar) {
        }

        public void a() {
            o.a().a("UpdateGcmIDRegisterDeviceCallback", ShopeeFcmListenerService.this.f18543c);
            ShopeeFcmListenerService shopeeFcmListenerService = ShopeeFcmListenerService.this;
            shopeeFcmListenerService.c(shopeeFcmListenerService.f18541a);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f18543c = new a() {
        public void a(com.shopee.app.network.c.d.a aVar) {
        }

        public void a() {
            if (ar.f().e().appLifeCycleManager().a()) {
                e.c().a(false);
            }
        }
    };

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> a2 = remoteMessage.a();
        String str = a2.get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        com.garena.android.appkit.d.a.b("FCM notification data" + a2.toString(), new Object[0]);
        if (str != null) {
            try {
                a(str);
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        } else {
            a(a2);
        }
    }

    private void a(String str) {
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, HomeActivity_.class), 1073741824);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        i.d a2 = new i.d(this, "SHOPEE_NOTIFY_ID").a((int) R.drawable.default_icon).a((CharSequence) "com.shopee.id");
        ((NotificationManager) getSystemService("notification")).notify(0, a2.b((CharSequence) "test from gcm server:" + str).e(true).a(defaultUri).a(activity).b());
    }

    private void a(Map<String, String> map) throws JSONException {
        com.garena.android.appkit.d.a.b("FCM notification bundle " + map.toString(), new Object[0]);
        if (map.containsKey(UriUtil.LOCAL_CONTENT_SCHEME)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = null;
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, map.get(next));
                }
                com.garena.android.appkit.d.a.b("pushJSON " + jSONObject.toString(), new Object[0]);
                if (jSONObject.has(UriUtil.LOCAL_CONTENT_SCHEME)) {
                    jSONObject2 = new JSONObject(jSONObject.getString(UriUtil.LOCAL_CONTENT_SCHEME));
                }
            } catch (Exception e2) {
                q fabricClient = ar.f().e().fabricClient();
                fabricClient.a((Throwable) e2, "crash_from:GCMNotification | " + map.toString());
                com.garena.android.appkit.d.a.a(e2);
            }
            GPNIntentService.a aVar = new GPNIntentService.a();
            if (jSONObject2 != null) {
                try {
                    aVar.f18492a = jSONObject2.getString(UriUtil.LOCAL_CONTENT_SCHEME);
                    if (jSONObject2.has("imgid")) {
                        aVar.f18494c = jSONObject2.getString("imgid");
                    }
                } catch (Exception e3) {
                    q fabricClient2 = ar.f().e().fabricClient();
                    fabricClient2.a((Throwable) e3, "crash_from:GCMNotification | " + jSONObject.toString());
                    aVar.f18492a = b.e(R.string.sp_new_notification_default_text);
                    return;
                }
            } else {
                aVar.f18492a = jSONObject.getString(UriUtil.LOCAL_CONTENT_SCHEME);
            }
            aVar.f18493b = jSONObject.getString("parameter");
            if (jSONObject.has("title")) {
                aVar.f18495d = jSONObject.getString("title");
            }
            aVar.f18496e = jSONObject.has("apprl") ? jSONObject.getString("apprl") : "";
            c.a(aVar);
        }
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        this.f18541a = str;
        b(this.f18541a);
        a();
        AppsFlyerLib.getInstance().updateServerUninstallToken(ar.f(), this.f18541a);
    }

    private void a() {
        com.google.firebase.messaging.a.a().a("global");
    }

    private void b(String str) {
        if (e.c().f()) {
            c(str);
        } else {
            d(str);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (ar.f() != null) {
            d.a(str, ar.f().e().loggedInUser(), ar.f().e().deviceStore());
        }
    }

    private void d(String str) {
        o.a().a("UpdateGcmIDNetworkConnectCallback", this.f18542b);
        e.c().d();
    }
}
