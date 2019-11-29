package com.crashlytics.android.b;

import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.tencent.qcloud.core.http.HttpConstants;
import io.a.a.a.a.b.a;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.i;
import java.util.HashMap;
import java.util.Map;

class e extends a {

    /* renamed from: b  reason: collision with root package name */
    private final g f6390b;

    static String a(String str) {
        return "3:" + str;
    }

    public e(i iVar, String str, String str2, io.a.a.a.a.e.e eVar, g gVar) {
        super(iVar, str, str2, eVar, c.GET);
        this.f6390b = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.crashlytics.android.b.f a(java.lang.String r8, java.lang.String r9, com.crashlytics.android.b.d r10) {
        /*
            r7 = this;
            java.lang.String r0 = "Checking for updates request ID: "
            java.lang.String r1 = "Fabric"
            java.lang.String r2 = "X-REQUEST-ID"
            java.lang.String r3 = "Beta"
            r4 = 0
            java.util.Map r10 = r7.a((com.crashlytics.android.b.d) r10)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            io.a.a.a.a.e.d r5 = r7.a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Exception -> 0x00bb, all -> 0x00b8 }
            io.a.a.a.a.e.d r8 = r7.a((io.a.a.a.a.e.d) r5, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            io.a.a.a.l r9 = io.a.a.a.c.h()     // Catch:{ Exception -> 0x00b0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r5.<init>()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r6 = "Checking for updates from "
            r5.append(r6)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r6 = r7.a()     // Catch:{ Exception -> 0x00b0 }
            r5.append(r6)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b0 }
            r9.a((java.lang.String) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x00b0 }
            io.a.a.a.l r9 = io.a.a.a.c.h()     // Catch:{ Exception -> 0x00b0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r5.<init>()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r6 = "Checking for updates query params are: "
            r5.append(r6)     // Catch:{ Exception -> 0x00b0 }
            r5.append(r10)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r10 = r5.toString()     // Catch:{ Exception -> 0x00b0 }
            r9.a((java.lang.String) r3, (java.lang.String) r10)     // Catch:{ Exception -> 0x00b0 }
            boolean r9 = r8.c()     // Catch:{ Exception -> 0x00b0 }
            if (r9 == 0) goto L_0x0084
            io.a.a.a.l r9 = io.a.a.a.c.h()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r10 = "Checking for updates was successful"
            r9.a((java.lang.String) r3, (java.lang.String) r10)     // Catch:{ Exception -> 0x00b0 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r10 = r8.e()     // Catch:{ Exception -> 0x00b0 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00b0 }
            com.crashlytics.android.b.g r10 = r7.f6390b     // Catch:{ Exception -> 0x00b0 }
            com.crashlytics.android.b.f r9 = r10.a(r9)     // Catch:{ Exception -> 0x00b0 }
            if (r8 == 0) goto L_0x0083
            java.lang.String r8 = r8.b((java.lang.String) r2)
            io.a.a.a.l r10 = io.a.a.a.c.h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r10.a((java.lang.String) r1, (java.lang.String) r8)
        L_0x0083:
            return r9
        L_0x0084:
            io.a.a.a.l r9 = io.a.a.a.c.h()     // Catch:{ Exception -> 0x00b0 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r10.<init>()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r5 = "Checking for updates failed. Response code: "
            r10.append(r5)     // Catch:{ Exception -> 0x00b0 }
            int r5 = r8.b()     // Catch:{ Exception -> 0x00b0 }
            r10.append(r5)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00b0 }
            r9.e(r3, r10)     // Catch:{ Exception -> 0x00b0 }
            if (r8 == 0) goto L_0x00f5
            java.lang.String r8 = r8.b((java.lang.String) r2)
            io.a.a.a.l r9 = io.a.a.a.c.h()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            goto L_0x00e8
        L_0x00b0:
            r9 = move-exception
            goto L_0x00bd
        L_0x00b2:
            r9 = move-exception
            r8 = r5
            goto L_0x00f7
        L_0x00b5:
            r9 = move-exception
            r8 = r5
            goto L_0x00bd
        L_0x00b8:
            r9 = move-exception
            r8 = r4
            goto L_0x00f7
        L_0x00bb:
            r9 = move-exception
            r8 = r4
        L_0x00bd:
            io.a.a.a.l r10 = io.a.a.a.c.h()     // Catch:{ all -> 0x00f6 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f6 }
            r5.<init>()     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = "Error while checking for updates from "
            r5.append(r6)     // Catch:{ all -> 0x00f6 }
            java.lang.String r6 = r7.a()     // Catch:{ all -> 0x00f6 }
            r5.append(r6)     // Catch:{ all -> 0x00f6 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00f6 }
            r10.e(r3, r5, r9)     // Catch:{ all -> 0x00f6 }
            if (r8 == 0) goto L_0x00f5
            java.lang.String r8 = r8.b((java.lang.String) r2)
            io.a.a.a.l r9 = io.a.a.a.c.h()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
        L_0x00e8:
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.a((java.lang.String) r1, (java.lang.String) r8)
        L_0x00f5:
            return r4
        L_0x00f6:
            r9 = move-exception
        L_0x00f7:
            if (r8 == 0) goto L_0x0113
            java.lang.String r8 = r8.b((java.lang.String) r2)
            io.a.a.a.l r10 = io.a.a.a.c.h()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r10.a((java.lang.String) r1, (java.lang.String) r8)
        L_0x0113:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.b.e.a(java.lang.String, java.lang.String, com.crashlytics.android.b.d):com.crashlytics.android.b.f");
    }

    private d a(d dVar, String str, String str2) {
        d a2 = dVar.a(LiveAgentRequest.HEADER_ACCEPT, HttpConstants.ContentType.JSON);
        return a2.a(HttpConstants.Header.USER_AGENT, "Crashlytics Android SDK/" + this.f33052a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a()).a("X-CRASHLYTICS-API-KEY", str).a("X-CRASHLYTICS-BETA-TOKEN", a(str2));
    }

    private Map<String, String> a(d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", dVar.f6386a);
        hashMap.put("display_version", dVar.f6387b);
        hashMap.put("instance", dVar.f6388c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, "3");
        return hashMap;
    }
}
