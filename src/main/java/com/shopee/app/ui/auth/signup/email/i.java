package com.shopee.app.ui.auth.signup.email;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;

public final class i implements com.garena.android.appkit.b.i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f19865a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19866b = new g() {
        public void onEvent(a aVar) {
            i.this.f19865a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public i(h hVar) {
        this.f19865a = hVar;
    }

    public void a() {
        b.a("REGISTER_ERROR", (e) this.f19866b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("REGISTER_ERROR", this.f19866b, b.a.NETWORK_BUS);
    }
}
