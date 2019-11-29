package com.appsflyer;

import android.os.Bundle;
import com.appsflyer.internal.b;
import com.appsflyer.internal.v;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.google.android.gms.stats.CodePackage;

public class GcmInstanceIdListener extends InstanceIDListenerService {
    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, com.appsflyer.GcmInstanceIdListener, com.google.android.gms.iid.InstanceIDListenerService] */
    public void onTokenRefresh() {
        GcmInstanceIdListener.super.onTokenRefresh();
        String string = AppsFlyerProperties.getInstance().getString("gcmProjectNumber");
        long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        try {
            str = InstanceID.getInstance(getApplicationContext()).getToken(string, CodePackage.GCM, (Bundle) null);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Error registering for uninstall tracking", th);
        }
        if (str != null) {
            AFLogger.afInfoLog("GCM Refreshed Token = ".concat(String.valueOf(str)));
            b.C0090b.a r0 = b.C0090b.a.m140(AppsFlyerProperties.getInstance().getString("afUninstallToken"));
            b.C0090b.a aVar = new b.C0090b.a(currentTimeMillis, str);
            if (r0.m142(aVar.f152, aVar.f151)) {
                v.m190(getApplicationContext(), aVar);
            }
        }
    }
}
