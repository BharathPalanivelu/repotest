package com.appsflyer.internal;

import android.content.Context;
import com.android.a.a.a;
import com.android.a.a.c;
import com.android.a.a.d;
import com.appsflyer.AFLogger;
import java.util.HashMap;

public final class g implements c {

    /* renamed from: ˊ  reason: contains not printable characters */
    private h f173;

    /* renamed from: ˎ  reason: contains not printable characters */
    private a f174;

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m150(Context context, h hVar) {
        this.f173 = hVar;
        try {
            this.f174 = a.a(context).a();
            this.f174.a((c) this);
        } catch (Throwable th) {
            AFLogger.afErrorLog("referrerClient -> startConnection", th);
        }
    }

    public final void onInstallReferrerSetupFinished(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(i));
        d dVar = null;
        if (i == 0) {
            try {
                AFLogger.afDebugLog("InstallReferrer connected");
                if (this.f174.a()) {
                    dVar = this.f174.c();
                    this.f174.b();
                } else {
                    AFLogger.afWarnLog("ReferrerClient: InstallReferrer is not ready");
                    hashMap.put("err", "ReferrerClient: InstallReferrer is not ready");
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("Failed to get install referrer: ");
                sb.append(th.getMessage());
                AFLogger.afWarnLog(sb.toString());
                hashMap.put("err", th.getMessage());
            }
        } else if (i == 1) {
            AFLogger.afWarnLog("InstallReferrer not supported");
        } else if (i != 2) {
            AFLogger.afWarnLog("responseCode not found.");
        } else {
            AFLogger.afWarnLog("InstallReferrer not supported");
        }
        if (dVar != null) {
            try {
                if (dVar.a() != null) {
                    hashMap.put("val", dVar.a());
                }
                hashMap.put("clk", Long.toString(dVar.b()));
                hashMap.put("install", Long.toString(dVar.c()));
            } catch (Exception e2) {
                e2.printStackTrace();
                hashMap.put("val", "-1");
                hashMap.put("clk", "-1");
                hashMap.put("install", "-1");
            }
        }
        h hVar = this.f173;
        if (hVar != null) {
            hVar.onHandleReferrer(hashMap);
        }
    }

    public final void onInstallReferrerServiceDisconnected() {
        AFLogger.afDebugLog("Install Referrer service disconnected");
    }
}
