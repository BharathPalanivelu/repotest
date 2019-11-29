package com.shopee.app.util.k;

import com.shopee.app.g.e;

public class i {
    public static boolean a(String str, String str2) {
        Long a2 = e.a(str, "IDR");
        Long a3 = e.a(str2, "IDR");
        return (a2 == null || a3 == null || a2.longValue() >= a3.longValue()) ? false : true;
    }

    public static boolean b(String str, String str2) {
        Long a2 = e.a(str, "IDR");
        Long a3 = e.a(str2, "IDR");
        if (a2 == null) {
            return a3 == null;
        }
        return a2.equals(a3);
    }

    public static boolean c(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }
}
