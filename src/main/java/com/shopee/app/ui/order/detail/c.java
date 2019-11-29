package com.shopee.app.ui.order.detail;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f23600a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23601b = new g() {
        public void onEvent(a aVar) {
            c.this.f23600a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f23600a = bVar;
    }

    public void a() {
        b.a("CANCEL_CHECKOUT_ERROR", (e) this.f23601b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CANCEL_CHECKOUT_ERROR", this.f23601b, b.a.NETWORK_BUS);
    }
}
