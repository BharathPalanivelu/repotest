package com.shopee.app.ui.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f19957a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19958b = new g() {
        public void onEvent(a aVar) {
            b.this.f19957a.a((com.shopee.app.ui.auth.a.a) aVar);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19959c = new g() {
        public void onEvent(a aVar) {
            b.this.f19957a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f19957a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("BIND_ACCOUNT_SUCCESS", (e) this.f19958b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("BIND_ACCOUNT_ERROR", (e) this.f19959c, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("BIND_ACCOUNT_SUCCESS", this.f19958b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("BIND_ACCOUNT_ERROR", this.f19959c, b.a.NETWORK_BUS);
    }
}
