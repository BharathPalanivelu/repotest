package com.shopee.app.util;

import android.os.Build;
import android.text.TextUtils;
import d.d.b.j;
import d.h.m;
import java.util.HashSet;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f26530a = new t();

    /* renamed from: b  reason: collision with root package name */
    private static final HashSet<String> f26531b = new HashSet<>();

    static {
        int i = 0;
        String[] strArr = {"Redmi Note 5A", "Redmi Note 4", "SM-G532G", "Lenovo A7700", "Galaxy J2 Prime", "Redmi Note 5A Prime", "dtacPhoneT3", "dtacPhoneS3", "SM-G960F", "SM-N9600", "Lenovo A7700", "PAFM00", "PACM00", "PBET00", "MI 8 SE", "vivo NEX S", "Redmi 5A", "R11s", "R11", "Xperia XZ3", "Redmi 6", "PACM00", "Find X", "PADM00", "SM-G532G", "8 Plus", "MI 5X", "Mi 5", "Redmi 4A", "8 Plus", "R15", "A5", "R17", "A3", "PAFM00", "PACM00"};
        int length = strArr.length;
        while (i < length) {
            String str = strArr[i];
            HashSet<String> hashSet = f26531b;
            if (str != null) {
                String obj = m.b(str).toString();
                if (obj != null) {
                    String lowerCase = obj.toLowerCase();
                    j.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    hashSet.add(lowerCase);
                    i++;
                } else {
                    throw new d.m("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new d.m("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }

    private t() {
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        j.a((Object) str, "model");
        return a(str);
    }

    private final boolean a(String str) {
        HashSet<String> hashSet = f26531b;
        if (str != null) {
            String obj = m.b(str).toString();
            if (obj != null) {
                String lowerCase = obj.toLowerCase();
                j.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                return hashSet.contains(lowerCase);
            }
            throw new d.m("null cannot be cast to non-null type java.lang.String");
        }
        throw new d.m("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
