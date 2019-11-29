package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.e;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;

public final class j extends f {

    /* renamed from: a  reason: collision with root package name */
    private final e f24399a;

    public j(e eVar) {
        d.d.b.j.b(eVar, "config");
        this.f24399a = eVar;
    }

    public e.C0408e a() {
        return e.C0408e.IMAGE_COUNT;
    }

    public g b() {
        return this.f24399a;
    }

    /* access modifiers changed from: protected */
    public d a(com.shopee.app.util.q.e eVar, c cVar, boolean z) {
        d.d.b.j.b(eVar, TouchesHelper.TARGET_KEY);
        d.d.b.j.b(cVar, "messageSupplier");
        int b2 = ((e.c) eVar).b();
        if (z) {
            return b(b2, cVar);
        }
        return a(b2, cVar);
    }

    private final d a(int i, c cVar) {
        if (i < this.f24399a.a()) {
            return new d.c(cVar.c(i, this.f24399a.a()));
        }
        return d.b.f26486a;
    }

    private final d b(int i, c cVar) {
        if (i < this.f24399a.a()) {
            return new d.a(cVar.c(i, this.f24399a.a()));
        }
        return d.b.f26486a;
    }
}
