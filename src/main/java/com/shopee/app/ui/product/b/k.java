package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class k extends f {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.ui.product.b.a.f f24400a;

    public k(com.shopee.app.ui.product.b.a.f fVar) {
        j.b(fVar, "config");
        this.f24400a = fVar;
    }

    public e.C0408e a() {
        return e.C0408e.PRICE;
    }

    public g b() {
        return this.f24400a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        return d.b.f26486a;
    }
}
