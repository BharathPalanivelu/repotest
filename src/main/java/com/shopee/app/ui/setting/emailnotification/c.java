package com.shopee.app.ui.setting.emailnotification;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f25222a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25223b = new g() {
        public void onEvent(a aVar) {
            c.this.f25222a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f25222a = bVar;
    }

    public void a() {
        b.a("SET_USER_INFO_ERROR", (e) this.f25223b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SET_USER_INFO_ERROR", this.f25223b, b.a.NETWORK_BUS);
    }
}
