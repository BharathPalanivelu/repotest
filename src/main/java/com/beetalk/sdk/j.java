package com.beetalk.sdk;

import com.beetalk.sdk.a.d;
import com.beetalk.sdk.b;
import com.beetalk.sdk.e.e;
import com.beetalk.sdk.e.f;
import com.beetalk.sdk.h.a;
import com.garena.e.a;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends c {
    b.a mAuthClientRequest;

    public j(b bVar) {
        super(bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(b.a aVar) {
        this.mAuthClientRequest = aVar;
        String d2 = d.a().d();
        if (f.a(d2)) {
            final com.beetalk.sdk.data.b bVar = new com.beetalk.sdk.data.b();
            bVar.f5393a = e.a();
            bVar.f5394b = "";
            bVar.f5395c = 0;
            bVar.f5396d = aVar.e();
            bVar.f5397e = f.b().f().intValue();
            new a(bVar).a(new a.b() {
                public void a(Exception exc, com.garena.e.b bVar, JSONObject jSONObject) {
                    if (exc != null || j.this.b(jSONObject)) {
                        j.this.client.a((b.c) null);
                        return;
                    }
                    try {
                        long j = jSONObject.getLong("uid");
                        d.a().a(j);
                        d.a().b(bVar.f5393a);
                        j.this.a(j, bVar.f5393a);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            });
            return true;
        }
        a(Long.valueOf(d2).longValue(), d.a().e());
        return true;
    }

    /* access modifiers changed from: private */
    public void a(long j, String str) {
        new com.beetalk.sdk.h.b(j, str, com.beetalk.sdk.h.d.TOKEN, this.mAuthClientRequest.e()).a(new a.b() {
            public void a(Exception exc, com.garena.e.b bVar, JSONObject jSONObject) {
                if (exc != null || j.this.b(jSONObject)) {
                    com.beetalk.sdk.e.a.a(exc);
                    j.this.client.a((b.c) null);
                    return;
                }
                j.this.client.a(j.this.a(jSONObject));
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.beetalk.sdk.b.c a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "error"
            java.lang.String r1 = "open_id"
            com.garena.pay.android.a r2 = com.garena.pay.android.a.UNKNOWN_ERROR
            java.lang.Integer r2 = r2.getCode()
            int r2 = r2.intValue()
            r3 = 0
            if (r8 != 0) goto L_0x001f
            com.garena.pay.android.a r8 = com.garena.pay.android.a.NETWORK_EXCEPTION     // Catch:{ JSONException -> 0x001d }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x001d }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x001d }
        L_0x001b:
            r2 = r8
            goto L_0x007b
        L_0x001d:
            r8 = move-exception
            goto L_0x0078
        L_0x001f:
            boolean r4 = r8.has(r1)     // Catch:{ JSONException -> 0x001d }
            if (r4 == 0) goto L_0x0050
            java.lang.String r0 = r8.getString(r1)     // Catch:{ JSONException -> 0x001d }
            java.lang.String r1 = "access_token"
            java.lang.String r1 = r8.getString(r1)     // Catch:{ JSONException -> 0x001d }
            java.lang.String r4 = "refresh_token"
            java.lang.String r4 = r8.getString(r4)     // Catch:{ JSONException -> 0x001d }
            java.lang.String r5 = "expiry_time"
            int r8 = r8.getInt(r5)     // Catch:{ JSONException -> 0x001d }
            com.beetalk.sdk.data.a r5 = new com.beetalk.sdk.data.a     // Catch:{ JSONException -> 0x001d }
            com.beetalk.sdk.data.d r6 = com.beetalk.sdk.data.d.GUEST     // Catch:{ JSONException -> 0x001d }
            r5.<init>(r1, r6)     // Catch:{ JSONException -> 0x001d }
            r5.b(r4)     // Catch:{ JSONException -> 0x001d }
            r5.a((int) r8)     // Catch:{ JSONException -> 0x001d }
            com.beetalk.sdk.b$a r8 = r7.mAuthClientRequest     // Catch:{ JSONException -> 0x001d }
            com.beetalk.sdk.b$c r8 = com.beetalk.sdk.b.c.a(r8, r5, r0)     // Catch:{ JSONException -> 0x001d }
            r3 = r8
            goto L_0x007b
        L_0x0050:
            boolean r1 = r8.has(r0)     // Catch:{ JSONException -> 0x001d }
            if (r1 == 0) goto L_0x006d
            java.lang.String r8 = r8.getString(r0)     // Catch:{ JSONException -> 0x001d }
            java.lang.String r0 = "invalid_grant"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x001d }
            if (r8 == 0) goto L_0x006d
            com.garena.pay.android.a r8 = com.garena.pay.android.a.ACCESS_TOKEN_INVALID_GRANT     // Catch:{ JSONException -> 0x001d }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x001d }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x001d }
            goto L_0x001b
        L_0x006d:
            com.garena.pay.android.a r8 = com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED     // Catch:{ JSONException -> 0x001d }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JSONException -> 0x001d }
            int r8 = r8.intValue()     // Catch:{ JSONException -> 0x001d }
            goto L_0x001b
        L_0x0078:
            com.beetalk.sdk.e.a.a((java.lang.Exception) r8)
        L_0x007b:
            if (r3 != 0) goto L_0x0083
            com.beetalk.sdk.b$a r8 = r7.mAuthClientRequest
            com.beetalk.sdk.b$c r3 = com.beetalk.sdk.b.c.a(r8, r2)
        L_0x0083:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.j.a(org.json.JSONObject):com.beetalk.sdk.b$c");
    }

    /* access modifiers changed from: private */
    public boolean b(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.has("error");
    }
}
