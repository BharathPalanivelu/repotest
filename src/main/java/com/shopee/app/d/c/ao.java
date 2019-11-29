package com.shopee.app.d.c;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;

public class ao extends a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final bi f16494c;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetFbProfilePhotoInteractor";
    }

    public ao(n nVar, bi biVar) {
        super(nVar);
        this.f16494c = biVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        GraphRequest newMeRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0083 A[Catch:{ Exception -> 0x00e3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x008d A[Catch:{ Exception -> 0x00e3 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCompleted(org.json.JSONObject r13, com.facebook.GraphResponse r14) {
                /*
                    r12 = this;
                    java.lang.String r14 = "birthday"
                    java.lang.String r0 = "gender"
                    java.lang.String r1 = "name"
                    java.lang.String r2 = "email"
                    if (r13 == 0) goto L_0x00e7
                    boolean r3 = r13.has(r2)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r4 = ""
                    if (r3 == 0) goto L_0x0030
                    java.lang.String r3 = "id"
                    java.lang.String r3 = r13.getString(r3)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                    r5.<init>()     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r6 = "https://graph.facebook.com/"
                    r5.append(r6)     // Catch:{ Exception -> 0x00e3 }
                    r5.append(r3)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r6 = "/picture?type=large&redirect=true&width=600&height=600"
                    r5.append(r6)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00e3 }
                    r7 = r5
                    goto L_0x0032
                L_0x0030:
                    r3 = r4
                    r7 = r3
                L_0x0032:
                    boolean r5 = r13.has(r2)     // Catch:{ Exception -> 0x00e3 }
                    if (r5 == 0) goto L_0x003e
                    java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00e3 }
                    r9 = r2
                    goto L_0x003f
                L_0x003e:
                    r9 = r4
                L_0x003f:
                    boolean r2 = r13.has(r1)     // Catch:{ Exception -> 0x00e3 }
                    if (r2 == 0) goto L_0x004a
                    java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00e3 }
                    goto L_0x004b
                L_0x004a:
                    r1 = r4
                L_0x004b:
                    java.lang.String r2 = " "
                    java.lang.String r1 = r1.replace(r2, r4)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r6 = r1.toLowerCase()     // Catch:{ Exception -> 0x00e3 }
                    boolean r1 = r13.has(r0)     // Catch:{ Exception -> 0x00e3 }
                    if (r1 == 0) goto L_0x0060
                    java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00e3 }
                    goto L_0x0061
                L_0x0060:
                    r0 = r4
                L_0x0061:
                    boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00e3 }
                    r2 = 0
                    if (r1 != 0) goto L_0x007c
                    java.lang.String r1 = "male"
                    boolean r1 = r0.equals(r1)     // Catch:{ Exception -> 0x00e3 }
                    if (r1 == 0) goto L_0x0072
                    r0 = 1
                    goto L_0x007d
                L_0x0072:
                    java.lang.String r1 = "female"
                    boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x00e3 }
                    if (r0 == 0) goto L_0x007c
                    r0 = 2
                    goto L_0x007d
                L_0x007c:
                    r0 = 0
                L_0x007d:
                    boolean r1 = r13.has(r14)     // Catch:{ Exception -> 0x00e3 }
                    if (r1 == 0) goto L_0x0087
                    java.lang.String r4 = r13.getString(r14)     // Catch:{ Exception -> 0x00e3 }
                L_0x0087:
                    boolean r13 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x00e3 }
                    if (r13 != 0) goto L_0x00a7
                    java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r14 = "MM/dd/yyyy"
                    java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x00e3 }
                    r13.<init>(r14, r1)     // Catch:{ Exception -> 0x00e3 }
                    java.util.Date r13 = r13.parse(r4)     // Catch:{ ParseException -> 0x00a3 }
                    long r13 = r13.getTime()     // Catch:{ ParseException -> 0x00a3 }
                    r4 = 1000(0x3e8, double:4.94E-321)
                    long r13 = r13 / r4
                    int r14 = (int) r13
                    goto L_0x00a8
                L_0x00a3:
                    r13 = move-exception
                    com.garena.android.appkit.d.a.a(r13)     // Catch:{ Exception -> 0x00e3 }
                L_0x00a7:
                    r14 = 0
                L_0x00a8:
                    com.shopee.app.h.c.a r13 = new com.shopee.app.h.c.a     // Catch:{ Exception -> 0x00e3 }
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                    r1.<init>()     // Catch:{ Exception -> 0x00e3 }
                    r1.append(r3)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r2 = ".jpg"
                    r1.append(r2)     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x00e3 }
                    r5 = r13
                    r10 = r0
                    r11 = r14
                    r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00e3 }
                    com.shopee.app.h.c.b r1 = new com.shopee.app.h.c.b     // Catch:{ Exception -> 0x00e3 }
                    r1.<init>(r0, r14)     // Catch:{ Exception -> 0x00e3 }
                    com.shopee.app.d.c.ao r14 = com.shopee.app.d.c.ao.this     // Catch:{ Exception -> 0x00e3 }
                    com.shopee.app.util.n r14 = r14.f16402a     // Catch:{ Exception -> 0x00e3 }
                    com.garena.a.a.a.a r14 = r14.a()     // Catch:{ Exception -> 0x00e3 }
                    com.garena.android.appkit.b.h<com.shopee.app.h.c.b> r14 = r14.aq     // Catch:{ Exception -> 0x00e3 }
                    com.garena.android.appkit.b.j r14 = r14.a(r1)     // Catch:{ Exception -> 0x00e3 }
                    r14.a()     // Catch:{ Exception -> 0x00e3 }
                    com.shopee.app.d.c.ao r14 = com.shopee.app.d.c.ao.this     // Catch:{ Exception -> 0x00e3 }
                    com.shopee.app.util.bi r14 = r14.f16494c     // Catch:{ Exception -> 0x00e3 }
                    java.lang.String r0 = "FACEBOOK_ME_INFO"
                    r14.a((java.lang.String) r0, (com.garena.android.appkit.b.a) r13)     // Catch:{ Exception -> 0x00e3 }
                    goto L_0x00e7
                L_0x00e3:
                    r13 = move-exception
                    com.garena.android.appkit.d.a.a(r13)
                L_0x00e7:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.c.ao.AnonymousClass1.onCompleted(org.json.JSONObject, com.facebook.GraphResponse):void");
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "email,name,id,gender,birthday");
        newMeRequest.setParameters(bundle);
        newMeRequest.executeAsync();
    }
}
