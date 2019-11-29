package com.shopee.app.ui.auth.signup.email;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f19836a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19837b = new g() {
        public void onEvent(a aVar) {
            c.this.f19836a.a((String) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19838c = new g() {
        public void onEvent(a aVar) {
            c.this.f19836a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f19836a = bVar;
    }

    public void a() {
        b.a("ON_CAPTCHA_VERIFY", (e) this.f19837b, b.a.NETWORK_BUS);
        b.a("ON_CAPTCHA_ERROR", (e) this.f19838c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ON_CAPTCHA_VERIFY", this.f19837b, b.a.NETWORK_BUS);
        b.b("ON_CAPTCHA_ERROR", this.f19838c, b.a.NETWORK_BUS);
    }
}
