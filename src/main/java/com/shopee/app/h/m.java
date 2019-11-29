package com.shopee.app.h;

import com.shopee.app.application.ar;
import com.shopee.app.data.store.ak;

@Deprecated
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static ak f17680a = ak.a();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f17681b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f17682c = false;

    public boolean a() {
        return ((Integer) f17680a.d().b(-1)).intValue() != -1;
    }

    public int b() {
        return ((Integer) f17680a.d().b(0)).intValue();
    }

    public static void c() {
        f17680a = new ak(ar.a().getSharedPreferences("login", 0));
    }

    public static boolean a(int i) {
        return ((Integer) f17680a.i().b(-1)).equals(Integer.valueOf(i));
    }

    public String d() {
        return (String) f17680a.g().b("");
    }

    public String e() {
        return (String) f17680a.k().b("");
    }

    public static void a(boolean z) {
        f17681b = z;
    }

    public static boolean f() {
        return f17681b;
    }

    public Integer g() {
        return (Integer) f17680a.i().b(0);
    }

    public String h() {
        return (String) f17680a.l().b("");
    }
}
