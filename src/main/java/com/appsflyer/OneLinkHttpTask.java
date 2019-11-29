package com.appsflyer;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;

public abstract class OneLinkHttpTask implements Runnable {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AppsFlyerLibCore f108;

    /* renamed from: ˎ  reason: contains not printable characters */
    private HttpsUrlConnectionProvider f109;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected String f110;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract String m113();

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void m114(String str);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void m115(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void m116();

    protected OneLinkHttpTask(AppsFlyerLibCore appsFlyerLibCore) {
        this.f108 = appsFlyerLibCore;
    }

    public void setConnProvider(HttpsUrlConnectionProvider httpsUrlConnectionProvider) {
        this.f109 = httpsUrlConnectionProvider;
    }

    public static class HttpsUrlConnectionProvider {
        /* renamed from: ˏ  reason: contains not printable characters */
        static HttpsURLConnection m117(String str) throws IOException {
            return (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            java.lang.String r3 = r9.m113()
            java.lang.String r4 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "oneLinkUrl: "
            java.lang.String r4 = r5.concat(r4)
            com.appsflyer.AFLogger.afRDLog(r4)
            javax.net.ssl.HttpsURLConnection r4 = com.appsflyer.OneLinkHttpTask.HttpsUrlConnectionProvider.m117(r3)     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r5 = "content-type"
            java.lang.String r6 = "application/json"
            r4.addRequestProperty(r5, r6)     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r5 = "authorization"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0087 }
            r6.<init>()     // Catch:{ Throwable -> 0x0087 }
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r8 = "AppsFlyerKey"
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Throwable -> 0x0087 }
            r6.append(r7)     // Catch:{ Throwable -> 0x0087 }
            r6.append(r1)     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r6 = com.appsflyer.internal.y.m213(r6)     // Catch:{ Throwable -> 0x0087 }
            r4.addRequestProperty(r5, r6)     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r5 = "af-timestamp"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0087 }
            r4.addRequestProperty(r5, r1)     // Catch:{ Throwable -> 0x0087 }
            r1 = 3000(0xbb8, float:4.204E-42)
            r4.setReadTimeout(r1)     // Catch:{ Throwable -> 0x0087 }
            r4.setConnectTimeout(r1)     // Catch:{ Throwable -> 0x0087 }
            r9.m115((javax.net.ssl.HttpsURLConnection) r4)     // Catch:{ Throwable -> 0x0087 }
            int r1 = r4.getResponseCode()     // Catch:{ Throwable -> 0x0087 }
            java.lang.String r2 = com.appsflyer.AppsFlyerLibCore.m81((java.net.HttpURLConnection) r4)     // Catch:{ Throwable -> 0x0087 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r1 != r4) goto L_0x006d
            java.lang.String r1 = "Status 200 ok"
            com.appsflyer.AFLogger.afInfoLog(r1)     // Catch:{ Throwable -> 0x0084 }
            goto L_0x00ae
        L_0x006d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0084 }
            java.lang.String r4 = "Response code = "
            r0.<init>(r4)     // Catch:{ Throwable -> 0x0084 }
            r0.append(r1)     // Catch:{ Throwable -> 0x0084 }
            java.lang.String r1 = " content = "
            r0.append(r1)     // Catch:{ Throwable -> 0x0084 }
            r0.append(r2)     // Catch:{ Throwable -> 0x0084 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0084 }
            goto L_0x00ae
        L_0x0084:
            r0 = move-exception
            r1 = r0
            goto L_0x0089
        L_0x0087:
            r1 = move-exception
            r2 = r0
        L_0x0089:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r0 = r4.concat(r0)
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r3)
            java.lang.String r3 = " stacktrace: "
            r0.append(r3)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x00ae:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00c5
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r1 = "Connection call succeeded: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            r9.m114((java.lang.String) r2)
            return
        L_0x00c5:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afWarnLog(r0)
            r9.m116()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.OneLinkHttpTask.run():void");
    }
}
