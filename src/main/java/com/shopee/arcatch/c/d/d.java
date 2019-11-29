package com.shopee.arcatch.c.d;

import com.shopee.arcatch.c.f.b;
import com.shopee.sdk.e.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f26777a;

    /* renamed from: b  reason: collision with root package name */
    private a<Boolean> f26778b = new a<>(b.b().a().getSharedPreferences("ArCatch", 0), 50, Boolean.class);

    private d() {
    }

    public static d a() {
        if (f26777a == null) {
            synchronized (d.class) {
                if (f26777a == null) {
                    f26777a = new d();
                }
            }
        }
        return f26777a;
    }

    public void a(String str) {
        String c2 = c(str);
        com.shopee.e.a.a.a((Object) "saveNewbieShowed " + c2);
        this.f26778b.put(c2, true);
    }

    public Boolean b(String str) {
        boolean z;
        String c2 = c(str);
        Boolean bool = this.f26778b.get(c(str));
        if (bool == null) {
            z = false;
        } else {
            z = bool.booleanValue();
        }
        com.shopee.e.a.a.a((Object) "newbieHasShowed key " + c2 + " hasShowed " + z);
        return Boolean.valueOf(z);
    }

    private String c(String str) {
        com.shopee.sdk.modules.app.e.b d2 = com.shopee.sdk.b.a().d();
        int a2 = d2 != null ? d2.a().a() : 0;
        return a2 + "_" + "newbie_showed" + "_" + str;
    }
}
