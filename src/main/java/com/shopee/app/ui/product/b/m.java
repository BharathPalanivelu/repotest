package com.shopee.app.ui.product.b;

import com.facebook.react.uimanager.events.TouchesHelper;
import com.shopee.app.ui.product.b.a.h;
import com.shopee.app.util.q.c;
import com.shopee.app.util.q.d;
import com.shopee.app.util.q.e;
import com.shopee.app.util.q.f;
import com.shopee.app.util.q.g;
import d.d.b.j;

public final class m extends f {

    /* renamed from: a  reason: collision with root package name */
    private final h f24402a;

    public m(h hVar) {
        j.b(hVar, "config");
        this.f24402a = hVar;
    }

    public e.C0408e a() {
        return e.C0408e.TITLE;
    }

    public g b() {
        return this.f24402a;
    }

    /* access modifiers changed from: protected */
    public d a(e eVar, c cVar, boolean z) {
        j.b(eVar, TouchesHelper.TARGET_KEY);
        j.b(cVar, "messageSupplier");
        String b2 = ((e.d) eVar).b();
        if (z) {
            return a(b2, cVar);
        }
        return b(b2, cVar);
    }

    private final d a(String str, c cVar) {
        if (a(str)) {
            return new d.a(cVar.e());
        }
        if (str.length() < this.f24402a.a()) {
            return new d.a(cVar.c());
        }
        if (str.length() > this.f24402a.b()) {
            return new d.a(cVar.d());
        }
        return d.b.f26486a;
    }

    private final d b(String str, c cVar) {
        if (a(str)) {
            return new d.c(cVar.b());
        }
        if (str.length() < this.f24402a.a()) {
            return new d.c(cVar.a(str.length(), this.f24402a.a()));
        }
        if (str.length() > this.f24402a.b()) {
            return new d.c(cVar.a());
        }
        return d.b.f26486a;
    }

    private final boolean a(String str) {
        for (String c2 : this.f24402a.c()) {
            if (d.h.m.c(str, c2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
