package com.shopee.navigator.c;

import android.net.Uri;
import com.appsflyer.share.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.google.a.o;
import java.util.List;
import java.util.Set;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f30120a;

    /* renamed from: b  reason: collision with root package name */
    private int f30121b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f30122c;

    /* renamed from: d  reason: collision with root package name */
    private String f30123d;

    /* renamed from: e  reason: collision with root package name */
    private o f30124e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30125f;

    private void g() {
    }

    public a(String str) {
        this.f30120a = str;
        f();
    }

    public String a() {
        return this.f30120a;
    }

    public int b() {
        return this.f30121b;
    }

    public String c() {
        return this.f30123d;
    }

    public o d() {
        return this.f30124e;
    }

    public boolean e() {
        return this.f30125f && this.f30121b != -1;
    }

    private void f() {
        try {
            Uri parse = Uri.parse(this.f30120a);
            this.f30122c = parse;
            if (!"http".equals(parse.getScheme())) {
                if (!"https".equals(parse.getScheme())) {
                    this.f30121b = -1;
                    List<String> pathSegments = parse.getPathSegments();
                    if (pathSegments.size() >= 2) {
                        String str = pathSegments.get(0);
                        if (!AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str)) {
                            if (!"n".equals(str)) {
                                if ("react-native".equals(str) || "rn".equals(str)) {
                                    this.f30121b = 1;
                                }
                            }
                        }
                        this.f30121b = 0;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = this.f30121b == -1 ? 0 : 1; i < pathSegments.size(); i++) {
                        sb.append(pathSegments.get(i));
                        if (i < pathSegments.size() - 1) {
                            sb.append(Constants.URL_PATH_DELIMITER);
                        }
                    }
                    this.f30123d = sb.toString();
                    this.f30124e = a(parse);
                    this.f30125f = true;
                    return;
                }
            }
            this.f30121b = 3;
            this.f30124e = new o();
            this.f30123d = this.f30120a;
            this.f30125f = true;
        } catch (Exception unused) {
            this.f30125f = false;
            g();
        }
    }

    private o a(Uri uri) {
        o oVar = new o();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null) {
            for (String next : queryParameterNames) {
                a(oVar, next, uri.getQueryParameter(next));
            }
        }
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092 A[Catch:{ Exception -> 0x009e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.a.o r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            int r0 = r10.length()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 <= r2) goto L_0x009e
            int r0 = r10.length()
            int r0 = r0 - r2
            java.lang.String r0 = r10.substring(r0)
            int r4 = r10.length()
            int r4 = r4 - r2
            java.lang.String r4 = r10.substring(r1, r4)
            java.lang.String r5 = "."
            boolean r5 = r0.startsWith(r5)
            if (r5 == 0) goto L_0x009e
            r5 = -1
            int r6 = r0.hashCode()
            r7 = 1524(0x5f4, float:2.136E-42)
            if (r6 == r7) goto L_0x0065
            r7 = 1526(0x5f6, float:2.138E-42)
            if (r6 == r7) goto L_0x005b
            r7 = 1541(0x605, float:2.16E-42)
            if (r6 == r7) goto L_0x0051
            r7 = 1531(0x5fb, float:2.145E-42)
            if (r6 == r7) goto L_0x0047
            r7 = 1532(0x5fc, float:2.147E-42)
            if (r6 == r7) goto L_0x003d
            goto L_0x006f
        L_0x003d:
            java.lang.String r6 = ".j"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x006f
            r0 = 3
            goto L_0x0070
        L_0x0047:
            java.lang.String r6 = ".i"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
        L_0x0051:
            java.lang.String r6 = ".s"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x006f
            r0 = 4
            goto L_0x0070
        L_0x005b:
            java.lang.String r6 = ".d"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x006f
            r0 = 0
            goto L_0x0070
        L_0x0065:
            java.lang.String r6 = ".b"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x006f
            r0 = 2
            goto L_0x0070
        L_0x006f:
            r0 = -1
        L_0x0070:
            if (r0 == 0) goto L_0x0092
            if (r0 == r3) goto L_0x0086
            if (r0 == r2) goto L_0x007a
            r9.a((java.lang.String) r4, (java.lang.String) r11)
            goto L_0x009f
        L_0x007a:
            boolean r0 = java.lang.Boolean.parseBoolean(r11)     // Catch:{ Exception -> 0x009e }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x009e }
            r9.a((java.lang.String) r4, (java.lang.Boolean) r0)     // Catch:{ Exception -> 0x009e }
            goto L_0x009f
        L_0x0086:
            int r0 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x009e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x009e }
            r9.a((java.lang.String) r4, (java.lang.Number) r0)     // Catch:{ Exception -> 0x009e }
            goto L_0x009f
        L_0x0092:
            double r5 = java.lang.Double.parseDouble(r11)     // Catch:{ Exception -> 0x009e }
            java.lang.Double r0 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x009e }
            r9.a((java.lang.String) r4, (java.lang.Number) r0)     // Catch:{ Exception -> 0x009e }
            goto L_0x009f
        L_0x009e:
            r3 = 0
        L_0x009f:
            if (r3 != 0) goto L_0x00a4
            r9.a((java.lang.String) r10, (java.lang.String) r11)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.navigator.c.a.a(com.google.a.o, java.lang.String, java.lang.String):void");
    }
}
