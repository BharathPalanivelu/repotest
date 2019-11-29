package com.beetalk.sdk;

import android.os.AsyncTask;
import com.beetalk.sdk.b;
import com.beetalk.sdk.e.f;

public class k extends c {
    /* access modifiers changed from: private */
    public b.a pendingRequest;

    public k(b bVar) {
        super(bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(b.a aVar) {
        this.pendingRequest = aVar;
        new a().execute(new String[]{aVar.h().d()});
        return true;
    }

    /* access modifiers changed from: private */
    public void a(b.c cVar) {
        if (cVar != null) {
            this.client.a(cVar);
        } else {
            this.client.b();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.beetalk.sdk.b.c a(java.lang.String r6, com.beetalk.sdk.b.a r7) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r1 = 3
            r0.<init>(r1)
            java.lang.String r1 = "refresh_token"
            java.lang.String r2 = "grant_type"
            r0.put(r2, r1)
            r0.put(r1, r6)
            com.beetalk.sdk.f.c r6 = com.beetalk.sdk.f.c.a()
            java.lang.String r2 = com.beetalk.sdk.l.e()
            org.json.JSONObject r6 = r6.a(r2, r0)
            if (r6 == 0) goto L_0x0053
            java.lang.String r0 = "open_id"
            boolean r2 = r6.has(r0)
            if (r2 == 0) goto L_0x0053
            java.lang.String r0 = r6.getString(r0)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r2 = "access_token"
            java.lang.String r2 = r6.getString(r2)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r1 = r6.getString(r1)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r3 = "expiry_time"
            int r6 = r6.getInt(r3)     // Catch:{ JSONException -> 0x004f }
            com.beetalk.sdk.data.a r3 = new com.beetalk.sdk.data.a     // Catch:{ JSONException -> 0x004f }
            com.beetalk.sdk.data.d r4 = com.beetalk.sdk.data.d.GARENA_WEB_ANDROID     // Catch:{ JSONException -> 0x004f }
            r3.<init>(r2, r4)     // Catch:{ JSONException -> 0x004f }
            r3.b(r1)     // Catch:{ JSONException -> 0x004f }
            r3.a((int) r6)     // Catch:{ JSONException -> 0x004f }
            r3.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x004f }
            com.beetalk.sdk.b$c r6 = com.beetalk.sdk.b.c.a(r7, r3, r0)     // Catch:{ JSONException -> 0x004f }
            goto L_0x0054
        L_0x004f:
            r6 = move-exception
            com.beetalk.sdk.e.a.a((java.lang.Exception) r6)
        L_0x0053:
            r6 = 0
        L_0x0054:
            if (r6 != 0) goto L_0x0064
            com.garena.pay.android.a r6 = com.garena.pay.android.a.ACCESS_TOKEN_EXCHANGE_FAILED
            java.lang.Integer r6 = r6.getCode()
            int r6 = r6.intValue()
            com.beetalk.sdk.b$c r6 = com.beetalk.sdk.b.c.a(r7, r6)
        L_0x0064:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beetalk.sdk.k.a(java.lang.String, com.beetalk.sdk.b$a):com.beetalk.sdk.b$c");
    }

    private class a extends AsyncTask<String, Void, b.c> {
        private a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public b.c doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || f.a(str)) {
                return b.c.a(k.this.pendingRequest, com.garena.pay.android.a.REFRESH_TOKEN_FAILED.getCode().intValue());
            }
            k kVar = k.this;
            return kVar.a(str, kVar.pendingRequest);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(b.c cVar) {
            k.this.a(cVar);
        }
    }
}
