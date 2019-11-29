package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.a;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class f extends com.shopee.app.util.q.f {

    /* renamed from: a  reason: collision with root package name */
    private final a f24395a;

    public f(a aVar) {
        j.b(aVar, "config");
        this.f24395a = aVar;
    }

    public e.C0408e a() {
        return e.C0408e.BRAND;
    }

    public g b() {
        return this.f24395a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        return d.b.f26486a;
    }
}
