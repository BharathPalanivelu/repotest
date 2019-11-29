package com.appsflyer;

import com.appsflyer.internal.b;
import com.appsflyer.internal.v;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

@Deprecated
public class FirebaseInstanceIdListener extends FirebaseInstanceIdService {
    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.google.firebase.iid.FirebaseInstanceIdService, com.appsflyer.FirebaseInstanceIdListener] */
    public void onTokenRefresh() {
        String str;
        FirebaseInstanceIdListener.super.onTokenRefresh();
        AFLogger.afInfoLog("FirebaseInstanceIdService is deprecated in firebase-messaging:v17.1.0 .");
        AFLogger.afInfoLog("When using v17.1.0 or newer, please use com.appsflyer.FirebaseMessagingServiceListener instead of FirebaseInstanceIdListener");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = FirebaseInstanceId.getInstance().getToken();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Error registering for uninstall tracking", th);
            str = null;
        }
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            b.C0090b.a r3 = b.C0090b.a.m140(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            b.C0090b.a aVar = new b.C0090b.a(currentTimeMillis, str);
            if (r3.m142(aVar.f152, aVar.f151)) {
                v.m190(getApplicationContext(), aVar);
            }
        }
    }
}
