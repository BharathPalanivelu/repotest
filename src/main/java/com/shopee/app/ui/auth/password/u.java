package com.shopee.app.ui.auth.password;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class u implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f19660a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19661b = new g() {
        public void onEvent(a aVar) {
            u.this.f19660a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public u(t tVar) {
        this.f19660a = tVar;
    }

    public void a() {
        b.a("BIND_ACCOUNT_ERROR", (e) this.f19661b, b.a.NETWORK_BUS);
        b.a("RESET_PASSWORD_FAIL", (e) this.f19661b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("BIND_ACCOUNT_ERROR", this.f19661b, b.a.NETWORK_BUS);
        b.b("RESET_PASSWORD_FAIL", this.f19661b, b.a.NETWORK_BUS);
    }
}
