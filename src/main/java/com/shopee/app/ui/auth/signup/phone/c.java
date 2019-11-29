package com.shopee.app.ui.auth.signup.phone;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f19904a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19905b = new g() {
        public void onEvent(a aVar) {
            c.this.f19904a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f19904a = bVar;
    }

    public void a() {
        b.a("REGISTER_ERROR", (e) this.f19905b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("REGISTER_ERROR", this.f19905b, b.a.NETWORK_BUS);
    }
}
