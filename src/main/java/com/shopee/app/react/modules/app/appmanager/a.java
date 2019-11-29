package com.shopee.app.react.modules.app.appmanager;

import android.os.Build;
import com.appsflyer.AppsFlyerLib;
import com.facebook.appevents.AppEventsConstants;
import com.shopee.app.application.ar;
import com.shopee.app.util.c;
import com.shopee.react.sdk.bridge.modules.app.application.a;
import com.shopee.react.sdk.bridge.modules.base.d;

public class a extends d {
    public static String f() {
        return "live";
    }

    public static String l() {
        return "";
    }

    public static com.shopee.react.sdk.bridge.modules.app.application.a a() {
        return new a.C0465a().a(b()).b(e()).c(h()).d(f()).e("ID").f(g()).g(j()).h(k()).i(l()).j(Build.MANUFACTURER).k(Build.MODEL).l(AppsFlyerLib.getInstance().getAppsFlyerUID(ar.f())).a(false).a(m()).a();
    }

    public static String b() {
        String[] split = c().split("\\.");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : split) {
            if (str.length() < 2 && i > 0) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO + str;
            }
            sb.append(str);
            i++;
        }
        return sb.toString();
    }

    public static String c() {
        return "2.46.06".split("@")[0];
    }

    public static String d() {
        return c().replace(".0", ".");
    }

    public static String e() {
        return ar.f().e().deviceStore().d();
    }

    public static String g() {
        return ar.f().e().deviceStore().b();
    }

    public static String h() {
        return ar.f().e().deviceStore().g();
    }

    public static String i() {
        return ar.f().e().deviceStore().c();
    }

    public static String j() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String k() {
        return c.a().c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003b A[SYNTHETIC, Splitter:B:19:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0055 A[SYNTHETIC, Splitter:B:32:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0042=Splitter:B:23:0x0042, B:16:0x0036=Splitter:B:16:0x0036} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x0033, all -> 0x002f }
            java.lang.String r2 = "/proc/meminfo"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x0033, all -> 0x002f }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x0033, all -> 0x002f }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003f, IOException -> 0x0033, all -> 0x002f }
            java.lang.String r0 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b }
            java.lang.String r1 = "\\s+"
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b }
            r1 = 1
            r0 = r0[r1]     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b }
            long r0 = r0.longValue()     // Catch:{ FileNotFoundException -> 0x002d, IOException -> 0x002b }
            r2.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002a:
            return r0
        L_0x002b:
            r0 = move-exception
            goto L_0x0036
        L_0x002d:
            r0 = move-exception
            goto L_0x0042
        L_0x002f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0053
        L_0x0033:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0036:
            r0.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x003f:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0042:
            r0.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            r0 = -1
            return r0
        L_0x0052:
            r0 = move-exception
        L_0x0053:
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.modules.app.appmanager.a.m():long");
    }
}
