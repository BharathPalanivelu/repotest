package com.crashlytics.android.b;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import io.a.a.a.a.a.b;
import io.a.a.a.a.b.m;
import io.a.a.a.a.b.p;
import io.a.a.a.a.b.t;
import io.a.a.a.a.f.d;
import io.a.a.a.a.g.f;
import io.a.a.a.a.g.q;
import io.a.a.a.i;
import io.a.a.a.l;
import java.util.HashMap;
import java.util.Map;

public class c extends i<Boolean> implements m {

    /* renamed from: a  reason: collision with root package name */
    private final b<String> f6383a = new b<>();

    /* renamed from: b  reason: collision with root package name */
    private final h f6384b = new h();

    /* renamed from: c  reason: collision with root package name */
    private j f6385c;

    public String a() {
        return "1.2.7.19";
    }

    public String b() {
        return "com.crashlytics.sdk.android:beta";
    }

    /* access modifiers changed from: protected */
    @TargetApi(14)
    public boolean h_() {
        this.f6385c = a(Build.VERSION.SDK_INT, (Application) r().getApplicationContext());
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Boolean f() {
        io.a.a.a.c.h().a("Beta", "Beta kit initializing...");
        Context r = r();
        p q = q();
        if (TextUtils.isEmpty(a(r, q.i()))) {
            io.a.a.a.c.h().a("Beta", "A Beta device token was not found for this app");
            return false;
        }
        io.a.a.a.c.h().a("Beta", "Beta device token is present, checking for app updates.");
        f h = h();
        d a2 = a(r);
        if (a(h, a2)) {
            this.f6385c.a(r, this, q, h, a2, new d(this), new t(), new io.a.a.a.a.e.b(io.a.a.a.c.h()));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public j a(int i, Application application) {
        if (i >= 14) {
            return new b(s().e(), s().f());
        }
        return new i();
    }

    public Map<p.a, String> e() {
        String a2 = a(r(), q().i());
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put(p.a.FONT_TOKEN, a2);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public boolean a(f fVar, d dVar) {
        return (fVar == null || TextUtils.isEmpty(fVar.f33225a) || dVar == null) ? false : true;
    }

    private String a(Context context, String str) {
        String str2 = null;
        try {
            String a2 = this.f6383a.a(context, this.f6384b);
            if (!"".equals(a2)) {
                str2 = a2;
            }
        } catch (Exception e2) {
            io.a.a.a.c.h().e("Beta", "Failed to load the Beta device token", e2);
        }
        l h = io.a.a.a.c.h();
        StringBuilder sb = new StringBuilder();
        sb.append("Beta device token present: ");
        sb.append(!TextUtils.isEmpty(str2));
        h.a("Beta", sb.toString());
        return str2;
    }

    private f h() {
        io.a.a.a.a.g.t b2 = q.a().b();
        if (b2 != null) {
            return b2.f33267f;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.crashlytics.android.b.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: com.crashlytics.android.b.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.crashlytics.android.b.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.crashlytics.android.b.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.crashlytics.android.b.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC, Splitter:B:27:0x0081] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.crashlytics.android.b.d a(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Error closing Beta build properties asset"
            java.lang.String r1 = "Beta"
            r2 = 0
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "crashlytics-build.properties"
            java.io.InputStream r8 = r8.open(r3)     // Catch:{ Exception -> 0x0065 }
            if (r8 == 0) goto L_0x0050
            com.crashlytics.android.b.d r2 = com.crashlytics.android.b.d.a((java.io.InputStream) r8)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            io.a.a.a.l r3 = io.a.a.a.c.h()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r4.<init>()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = r2.f6389d     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = " build properties: "
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = r2.f6387b     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = " ("
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = r2.f6386a     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = ") - "
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r5 = r2.f6388c     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r4.append(r5)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r3.a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            goto L_0x0050
        L_0x0049:
            r2 = move-exception
            goto L_0x007f
        L_0x004b:
            r3 = move-exception
            r6 = r2
            r2 = r8
            r8 = r6
            goto L_0x0067
        L_0x0050:
            if (r8 == 0) goto L_0x005e
            r8.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005e
        L_0x0056:
            r8 = move-exception
            io.a.a.a.l r3 = io.a.a.a.c.h()
            r3.e(r1, r0, r8)
        L_0x005e:
            r8 = r2
            goto L_0x007e
        L_0x0060:
            r8 = move-exception
            r6 = r2
            r2 = r8
            r8 = r6
            goto L_0x007f
        L_0x0065:
            r3 = move-exception
            r8 = r2
        L_0x0067:
            io.a.a.a.l r4 = io.a.a.a.c.h()     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = "Error reading Beta build properties"
            r4.e(r1, r5, r3)     // Catch:{ all -> 0x0060 }
            if (r2 == 0) goto L_0x007e
            r2.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007e
        L_0x0076:
            r2 = move-exception
            io.a.a.a.l r3 = io.a.a.a.c.h()
            r3.e(r1, r0, r2)
        L_0x007e:
            return r8
        L_0x007f:
            if (r8 == 0) goto L_0x008d
            r8.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            r8 = move-exception
            io.a.a.a.l r3 = io.a.a.a.c.h()
            r3.e(r1, r0, r8)
        L_0x008d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.b.c.a(android.content.Context):com.crashlytics.android.b.d");
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return io.a.a.a.a.b.i.b(r(), "com.crashlytics.ApiEndpoint");
    }
}
