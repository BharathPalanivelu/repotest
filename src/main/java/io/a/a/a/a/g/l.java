package io.a.a.a.a.g;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.tencent.qcloud.core.http.HttpConstants;
import io.a.a.a.a.b.a;
import io.a.a.a.a.e.c;
import io.a.a.a.a.e.d;
import io.a.a.a.a.e.e;
import io.a.a.a.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l extends a implements x {
    /* access modifiers changed from: package-private */
    public boolean a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    public l(i iVar, String str, String str2, e eVar) {
        this(iVar, str, str2, eVar, c.GET);
    }

    l(i iVar, String str, String str2, e eVar, c cVar) {
        super(iVar, str, str2, eVar, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject a(io.a.a.a.a.g.w r10) {
        /*
            r9 = this;
            java.lang.String r0 = "X-REQUEST-ID"
            java.lang.String r1 = "Settings request ID: "
            java.lang.String r2 = "Fabric"
            r3 = 0
            java.util.Map r4 = r9.b(r10)     // Catch:{ c -> 0x0075, all -> 0x0070 }
            io.a.a.a.a.e.d r5 = r9.a((java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ c -> 0x0075, all -> 0x0070 }
            io.a.a.a.a.e.d r10 = r9.a(r5, r10)     // Catch:{ c -> 0x006d, all -> 0x006a }
            io.a.a.a.l r5 = io.a.a.a.c.h()     // Catch:{ c -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ c -> 0x0068 }
            r6.<init>()     // Catch:{ c -> 0x0068 }
            java.lang.String r7 = "Requesting settings from "
            r6.append(r7)     // Catch:{ c -> 0x0068 }
            java.lang.String r7 = r9.a()     // Catch:{ c -> 0x0068 }
            r6.append(r7)     // Catch:{ c -> 0x0068 }
            java.lang.String r6 = r6.toString()     // Catch:{ c -> 0x0068 }
            r5.a((java.lang.String) r2, (java.lang.String) r6)     // Catch:{ c -> 0x0068 }
            io.a.a.a.l r5 = io.a.a.a.c.h()     // Catch:{ c -> 0x0068 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ c -> 0x0068 }
            r6.<init>()     // Catch:{ c -> 0x0068 }
            java.lang.String r7 = "Settings query params were: "
            r6.append(r7)     // Catch:{ c -> 0x0068 }
            r6.append(r4)     // Catch:{ c -> 0x0068 }
            java.lang.String r4 = r6.toString()     // Catch:{ c -> 0x0068 }
            r5.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ c -> 0x0068 }
            org.json.JSONObject r3 = r9.a((io.a.a.a.a.e.d) r10)     // Catch:{ c -> 0x0068 }
            if (r10 == 0) goto L_0x008c
            io.a.a.a.l r4 = io.a.a.a.c.h()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
        L_0x0056:
            r5.append(r1)
            java.lang.String r10 = r10.b((java.lang.String) r0)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r4.a((java.lang.String) r2, (java.lang.String) r10)
            goto L_0x008c
        L_0x0068:
            r4 = move-exception
            goto L_0x0077
        L_0x006a:
            r3 = move-exception
            r10 = r5
            goto L_0x008e
        L_0x006d:
            r4 = move-exception
            r10 = r5
            goto L_0x0077
        L_0x0070:
            r10 = move-exception
            r8 = r3
            r3 = r10
            r10 = r8
            goto L_0x008e
        L_0x0075:
            r4 = move-exception
            r10 = r3
        L_0x0077:
            io.a.a.a.l r5 = io.a.a.a.c.h()     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Settings request failed."
            r5.e(r2, r6, r4)     // Catch:{ all -> 0x008d }
            if (r10 == 0) goto L_0x008c
            io.a.a.a.l r4 = io.a.a.a.c.h()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            goto L_0x0056
        L_0x008c:
            return r3
        L_0x008d:
            r3 = move-exception
        L_0x008e:
            if (r10 == 0) goto L_0x00aa
            io.a.a.a.l r4 = io.a.a.a.c.h()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r10 = r10.b((java.lang.String) r0)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            r4.a((java.lang.String) r2, (java.lang.String) r10)
        L_0x00aa:
            goto L_0x00ac
        L_0x00ab:
            throw r3
        L_0x00ac:
            goto L_0x00ab
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.g.l.a(io.a.a.a.a.g.w):org.json.JSONObject");
    }

    /* access modifiers changed from: package-private */
    public JSONObject a(d dVar) {
        int b2 = dVar.b();
        io.a.a.a.l h = io.a.a.a.c.h();
        h.a("Fabric", "Settings result was: " + b2);
        if (a(b2)) {
            return a(dVar.e());
        }
        io.a.a.a.l h2 = io.a.a.a.c.h();
        h2.e("Fabric", "Failed to retrieve settings from " + a());
        return null;
    }

    private JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e2) {
            io.a.a.a.l h = io.a.a.a.c.h();
            h.a("Fabric", "Failed to parse settings JSON from " + a(), (Throwable) e2);
            io.a.a.a.l h2 = io.a.a.a.c.h();
            h2.a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> b(w wVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", wVar.j);
        hashMap.put("display_version", wVar.i);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(wVar.k));
        if (wVar.l != null) {
            hashMap.put("icon_hash", wVar.l);
        }
        String str = wVar.h;
        if (!io.a.a.a.a.b.i.d(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private d a(d dVar, w wVar) {
        a(dVar, "X-CRASHLYTICS-API-KEY", wVar.f33270a);
        a(dVar, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(dVar, "X-CRASHLYTICS-API-CLIENT-VERSION", this.f33052a.a());
        a(dVar, LiveAgentRequest.HEADER_ACCEPT, HttpConstants.ContentType.JSON);
        a(dVar, "X-CRASHLYTICS-DEVICE-MODEL", wVar.f33271b);
        a(dVar, "X-CRASHLYTICS-OS-BUILD-VERSION", wVar.f33272c);
        a(dVar, "X-CRASHLYTICS-OS-DISPLAY-VERSION", wVar.f33273d);
        a(dVar, "X-CRASHLYTICS-INSTALLATION-ID", wVar.f33275f);
        if (TextUtils.isEmpty(wVar.f33274e)) {
            a(dVar, "X-CRASHLYTICS-ANDROID-ID", wVar.f33276g);
        } else {
            a(dVar, "X-CRASHLYTICS-ADVERTISING-TOKEN", wVar.f33274e);
        }
        return dVar;
    }

    private void a(d dVar, String str, String str2) {
        if (str2 != null) {
            dVar.a(str, str2);
        }
    }
}
