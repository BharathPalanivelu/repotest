package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.b;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import d.d.b.j;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    private final b f24396a;

    public g(b bVar) {
        j.b(bVar, "config");
        this.f24396a = bVar;
    }

    public e.C0408e a() {
        return e.C0408e.CATEGORY;
    }

    public com.shopee.app.util.q.g b() {
        return this.f24396a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        return d.b.f26486a;
    }
}
