package com.shopee.app.i;

import com.shopee.app.application.ar;
import com.shopee.app.i.a.b;
import com.shopee.app.i.a.c;

public class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f6974c;

    /* renamed from: a  reason: collision with root package name */
    com.shopee.sdk.modules.a f6975a;

    /* renamed from: b  reason: collision with root package name */
    ar f6976b;

    /* renamed from: d  reason: collision with root package name */
    private b f6977d = com.shopee.app.i.a.a.a().a(ar.f().e()).a(new c(ar.f())).a();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f6974c == null) {
                f6974c = new a();
            }
            aVar = f6974c;
        }
        return aVar;
    }

    private a() {
        this.f6977d.a(this);
        com.shopee.sdk.b.a(this.f6975a);
    }

    public void b() {
        d();
    }

    private void d() {
        if (com.shopee.app.util.c.h()) {
            com.shopee.sdk.b.a(com.shopee.app.i.c.a.a());
        } else {
            com.shopee.livequiz.b.a(this.f6976b);
            com.shopee.sdk.b.a(com.shopee.livequiz.b.b());
        }
        com.shopee.feeds.feedlibrary.b.a(this.f6976b);
        com.shopee.sdk.b.a(com.shopee.feeds.feedlibrary.b.a());
        if (com.shopee.app.util.c.h()) {
            com.shopee.sdk.b.a(com.shopee.app.i.c.b.a());
        } else {
            com.shopee.live.livestreaming.b.a(this.f6976b);
            com.shopee.sdk.b.a(com.shopee.live.livestreaming.b.a());
        }
        com.shopee.arcatch.c.f.b.a(this.f6976b);
        com.shopee.sdk.b.a(com.shopee.arcatch.c.f.b.c());
    }

    public void c() {
        this.f6977d = com.shopee.app.i.a.a.a().a(ar.f().e()).a(new c(ar.f())).a();
        this.f6977d.a(this);
        com.shopee.sdk.b.a(this.f6975a);
    }
}
