package com.appsflyer;

import com.appsflyer.internal.b;
import com.appsflyer.internal.v;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        super.onNewToken(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (str != null) {
            AFLogger.afInfoLog("Firebase Refreshed Token = ".concat(String.valueOf(str)));
            b.C0090b.a r2 = b.C0090b.a.m140(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            b.C0090b.a aVar = new b.C0090b.a(currentTimeMillis, str);
            if (r2.m142(aVar.f152, aVar.f151)) {
                v.m190(getApplicationContext(), aVar);
            }
        }
    }
}
