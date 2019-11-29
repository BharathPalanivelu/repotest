package com.shopee.app.ui.shopassistant.shopSetting;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f25557a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25558b = new g() {
        public void onEvent(a aVar) {
            e.this.f25557a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25559c = new g() {
        public void onEvent(a aVar) {
            e.this.f25557a.f();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f25560d = new g() {
        public void onEvent(a aVar) {
            e.this.f25557a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public e(d dVar) {
        this.f25557a = dVar;
    }

    public void a() {
        b.a("UPDATE_SHOP_INFO", (com.garena.android.appkit.b.e) this.f25559c, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO_ERROR", (com.garena.android.appkit.b.e) this.f25560d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("UPDATE_SHOP_INFO", this.f25559c, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO_ERROR", this.f25560d, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SUBMIT_AUTO_REPLY", (com.garena.android.appkit.b.e) this.f25558b, b.a.UI_BUS);
    }

    public void d() {
        b.b("SUBMIT_AUTO_REPLY", this.f25558b, b.a.UI_BUS);
    }
}
