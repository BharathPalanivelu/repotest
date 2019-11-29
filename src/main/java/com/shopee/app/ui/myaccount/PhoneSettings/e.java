package com.shopee.app.ui.myaccount.PhoneSettings;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f23248a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23249b = new g() {
        public void onEvent(a aVar) {
            e.this.f23248a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23250c = new g() {
        public void onEvent(a aVar) {
            e.this.f23248a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23251d = new g() {
        public void onEvent(a aVar) {
            e.this.f23248a.c((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f23248a = dVar;
    }

    public void a() {
        b.a("BIND_ACCOUNT_ERROR", (com.garena.android.appkit.b.e) this.f23249b, b.a.NETWORK_BUS);
        b.a("UNBIND_ACCOUNT_ERROR", (com.garena.android.appkit.b.e) this.f23250c, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO_ERROR", (com.garena.android.appkit.b.e) this.f23251d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("BIND_ACCOUNT_ERROR", this.f23249b, b.a.NETWORK_BUS);
        b.b("UNBIND_ACCOUNT_ERROR", this.f23250c, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO_ERROR", this.f23251d, b.a.NETWORK_BUS);
    }
}
