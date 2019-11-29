package com.shopee.app.camera;

import com.shopee.app.application.ar;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15960a = "image_search_hint";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15961b = "hint";

    /* renamed from: c  reason: collision with root package name */
    private static final String f15962c = "image_search_photo";

    /* renamed from: d  reason: collision with root package name */
    private static final String f15963d = "photo";

    public static final String a() {
        String string = ar.a(f15960a).getString(f15961b, "");
        j.a((Object) string, "ShopeeApplication.getPre…HINT).getString(HINT, \"\")");
        return string;
    }

    public static final void a(String str) {
        j.b(str, "showed");
        ar.a(f15960a).edit().putString(f15961b, str).commit();
    }

    public static final String b() {
        String string = ar.a(f15962c).getString(f15963d, "");
        j.a((Object) string, "ShopeeApplication.getPre…OTO).getString(PHOTO, \"\")");
        return string;
    }

    public static final void b(String str) {
        j.b(str, "photo");
        com.garena.android.appkit.d.a.b("mage_search image search hint this " + str + " will be ignored from search hint", new Object[0]);
        ar.a(f15962c).edit().putString(f15963d, str).commit();
    }
}
