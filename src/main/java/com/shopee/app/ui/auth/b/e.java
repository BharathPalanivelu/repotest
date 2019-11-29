package com.shopee.app.ui.auth.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f19510a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19511b = new g() {
        public void onEvent(a aVar) {
            e.this.f19510a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19512c = new g() {
        public void onEvent(a aVar) {
            e.this.f19510a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f19510a = dVar;
    }

    public void a() {
        b.a("NEW_LOGIN", (com.garena.android.appkit.b.e) this.f19511b, b.a.NETWORK_BUS);
        b.a("LOGIN_FAIL", (com.garena.android.appkit.b.e) this.f19512c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("NEW_LOGIN", this.f19511b, b.a.NETWORK_BUS);
        b.b("LOGIN_FAIL", this.f19512c, b.a.NETWORK_BUS);
    }
}
