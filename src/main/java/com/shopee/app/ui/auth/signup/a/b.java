package com.shopee.app.ui.auth.signup.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f19803a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19804b = new g() {
        public void onEvent(a aVar) {
            b.this.f19803a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f19803a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("FACEBOOK_LOGIN_FAIL", (e) this.f19804b, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("FACEBOOK_LOGIN_FAIL", this.f19804b, b.a.NETWORK_BUS);
    }
}
