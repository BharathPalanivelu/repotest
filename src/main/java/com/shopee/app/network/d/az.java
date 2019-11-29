package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.h.o;
import com.shopee.app.network.a.b;
import com.shopee.app.network.e;
import com.shopee.app.network.g;
import com.squareup.wire.Message;

public abstract class az {

    /* renamed from: a  reason: collision with root package name */
    private final g f18138a;

    /* access modifiers changed from: protected */
    @Deprecated
    public f a() {
        return null;
    }

    protected az() {
        this.f18138a = new g();
    }

    protected az(g gVar) {
        this.f18138a = gVar;
    }

    public final void g() {
        f();
    }

    public void h() {
        o.a().a(this);
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this instanceof b) {
            b bVar = (b) this;
            Message q_ = bVar.q_();
            e.c().a(new f(bVar.b(), q_.toByteArray()), getClass().getSimpleName(), i().a(), q_);
            return;
        }
        f a2 = a();
        if (a2 != null) {
            e.c().a(a2, getClass().getSimpleName(), i().a(), (Message) null);
        }
    }

    public g i() {
        return this.f18138a;
    }
}
