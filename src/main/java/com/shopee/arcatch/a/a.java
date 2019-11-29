package com.shopee.arcatch.a;

import com.shopee.arcatch.a.a.b;
import com.shopee.arcatch.data.network_bean.CommonBean;
import com.shopee.arcatch.data.network_bean.CommonCallback;
import com.shopee.arcatch.data.network_bean.game.EndBody;
import com.shopee.arcatch.data.network_bean.game.EndGameData;
import f.a.a.h;
import f.c;
import f.e;
import f.m;
import f.n;
import io.b.d.g;
import io.b.j;
import java.io.InputStream;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private OkHttpClient f14307a;

    /* renamed from: b  reason: collision with root package name */
    private b f14308b;

    /* renamed from: c  reason: collision with root package name */
    private com.shopee.arcatch.a.a.a f14309c;

    /* renamed from: com.shopee.arcatch.a.a$a  reason: collision with other inner class name */
    private static class C0237a {

        /* renamed from: a  reason: collision with root package name */
        static final a f14311a = new a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.shopee.arcatch.a.b.a()
            java.lang.String r2 = com.shopee.arcatch.a.b.b()
            int r3 = r1.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1897523141: goto L_0x0036;
                case 115560: goto L_0x002c;
                case 3322092: goto L_0x0022;
                case 3556498: goto L_0x0018;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0040
        L_0x0018:
            java.lang.String r3 = "test"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
            r1 = 0
            goto L_0x0041
        L_0x0022:
            java.lang.String r3 = "live"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
            r1 = 3
            goto L_0x0041
        L_0x002c:
            java.lang.String r3 = "uat"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
            r1 = 2
            goto L_0x0041
        L_0x0036:
            java.lang.String r3 = "staging"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0040
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = -1
        L_0x0041:
            java.lang.String r3 = "/"
            if (r1 == 0) goto L_0x0079
            if (r1 == r6) goto L_0x006d
            if (r1 == r5) goto L_0x0061
            java.lang.String r5 = "https://games.shopee."
            if (r1 == r4) goto L_0x0057
            r0.append(r5)
            r0.append(r2)
            r0.append(r3)
            goto L_0x0084
        L_0x0057:
            r0.append(r5)
            r0.append(r2)
            r0.append(r3)
            goto L_0x0084
        L_0x0061:
            java.lang.String r1 = "https://games.uat.shopee."
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            goto L_0x0084
        L_0x006d:
            java.lang.String r1 = "https://games.staging.shopee."
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
            goto L_0x0084
        L_0x0079:
            java.lang.String r1 = "https://games.test.shopee."
            r0.append(r1)
            r0.append(r2)
            r0.append(r3)
        L_0x0084:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.arcatch.a.a.b():java.lang.String");
    }

    public static a a() {
        return C0237a.f14311a;
    }

    private a() {
        this.f14307a = com.shopee.sdk.b.a().g().a();
        n a2 = new n.a().a(b()).a(this.f14307a).a((e.a) f.b.a.a.a()).a((c.a) h.a()).a();
        this.f14308b = (b) a2.a(b.class);
        this.f14309c = (com.shopee.arcatch.a.a.a) a2.a(com.shopee.arcatch.a.a.a.class);
        if (com.shopee.arcatch.c.c.a.f26749a) {
            c();
        }
    }

    private static void c() {
        String b2 = b();
        com.shopee.sdk.modules.app.c.a g2 = com.shopee.sdk.b.a().g();
        HttpUrl parse = HttpUrl.parse(b2);
        if (parse != null) {
            g2.a(b2, Cookie.parse(parse, com.shopee.arcatch.c.c.a.f26754f), new com.shopee.sdk.f.b<Integer>() {
                public void a(Integer num) {
                    com.garena.android.appkit.d.a.b("Net", num + "");
                }

                public void a(int i, String str) {
                    com.garena.android.appkit.d.a.a("Net", str);
                }
            });
        }
    }

    public void a(String str, String str2, EndBody endBody, CommonCallback<EndGameData> commonCallback) {
        f.b<CommonBean<EndGameData>> a2 = this.f14308b.a(b() + "catch/api/v1/end/events/" + str + "/sessions/" + str2, endBody);
        commonCallback.setCall(a2);
        a2.a(commonCallback);
    }

    public j<InputStream> a(String str) {
        return this.f14309c.a(str).b(new g<m<ResponseBody>, InputStream>() {
            /* renamed from: a */
            public InputStream apply(m<ResponseBody> mVar) {
                if (mVar == null) {
                    io.b.c.b.a(new Throwable("responseBodyResponse is null"));
                }
                if (!mVar.d()) {
                    io.b.c.b.a(new Throwable("responseBodyResponse not successful " + mVar.a()));
                }
                ResponseBody e2 = mVar.e();
                if (e2 == null) {
                    io.b.c.b.a(new Throwable("responseBody is null"));
                }
                return e2.byteStream();
            }
        }).b(io.b.h.a.b());
    }
}
