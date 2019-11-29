package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    private final c f24397a;

    public h(c cVar) {
        j.b(cVar, "config");
        this.f24397a = cVar;
    }

    public e.C0408e a() {
        return e.C0408e.DESCRIPTION;
    }

    public g b() {
        return this.f24397a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, com.shopee.app.util.q.c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        String b2 = ((e.a) eVar).b();
        if (z) {
            return a(b2, cVar);
        }
        return b(b2, cVar);
    }

    private final d a(String str, com.shopee.app.util.q.c cVar) {
        if (str.length() < this.f24397a.a()) {
            return new d.a(cVar.g());
        }
        if (str.length() > this.f24397a.b()) {
            return new d.a(cVar.h());
        }
        return d.b.f26486a;
    }

    private final d b(String str, com.shopee.app.util.q.c cVar) {
        if (str.length() < this.f24397a.a()) {
            return new d.c(cVar.b(str.length(), this.f24397a.a()));
        }
        if (str.length() > this.f24397a.b()) {
            return new d.c(cVar.f());
        }
        return d.b.f26486a;
    }
}
