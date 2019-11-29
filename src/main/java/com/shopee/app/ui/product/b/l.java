package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.g;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import d.d.b.j;

public final class l extends f {

    /* renamed from: a  reason: collision with root package name */
    private final g f24401a;

    public l(g gVar) {
        j.b(gVar, "config");
        this.f24401a = gVar;
    }

    public e.C0408e a() {
        return e.C0408e.STOCK;
    }

    public com.shopee.app.util.q.g b() {
        return this.f24401a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        return d.b.f26486a;
    }
}
