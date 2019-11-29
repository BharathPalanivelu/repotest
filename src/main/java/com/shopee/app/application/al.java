package com.shopee.app.application;

import com.shopee.app.b.b.a;
import com.shopee.app.b.b.e;
import com.shopee.app.b.b.f;
import com.shopee.app.b.b.g;
import com.shopee.navigator.c.b;
import com.shopee.navigator.c.c;
import com.shopee.navigator.c.d;

public class al {

    /* renamed from: a  reason: collision with root package name */
    private static d f6909a;

    public static void a() {
        f6909a = d.a();
        b();
        c();
        d();
    }

    private static void b() {
        c cVar = new c("React-Native");
        cVar.a((b) new com.shopee.app.b.b.c());
        f6909a.a(1, cVar);
    }

    private static void c() {
        c cVar = new c("Web");
        cVar.a((b) new g());
        f6909a.a(3, cVar);
    }

    private static void d() {
        c cVar = new c("Native");
        cVar.a((b) new f());
        cVar.a((b) new com.shopee.app.b.b.b());
        cVar.a((b) new a());
        cVar.a((b) new com.shopee.app.b.b.d());
        cVar.a((b) new e());
        f6909a.a(0, cVar);
    }
}
