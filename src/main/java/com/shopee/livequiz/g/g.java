package com.shopee.livequiz.g;

import com.shopee.sdk.modules.app.e.a;
import com.shopee.sdk.modules.app.e.b;

public class g {
    public static b a() {
        return com.shopee.sdk.b.a().d();
    }

    public static a b() {
        if (a() == null) {
            return null;
        }
        return a().a();
    }

    public static boolean c() {
        b a2 = a();
        return a2 != null && a2.b();
    }

    public static boolean d() {
        b a2 = a();
        return a2 != null && !a2.b();
    }

    public static String e() {
        a b2 = b();
        if (b2 == null) {
            return "";
        }
        return b2.c();
    }

    public static int f() {
        a b2 = b();
        if (b2 == null) {
            return 0;
        }
        return b2.a();
    }

    public static String g() {
        a b2 = b();
        if (b2 == null) {
            return "";
        }
        return b2.d();
    }
}
