package com.shopee.app.ui.follow.following.recommend;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f21692a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21693b = new g() {
        public void onEvent(a aVar) {
            e.this.f21692a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21694c = new g() {
        public void onEvent(a aVar) {
            e.this.f21692a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f21692a = dVar;
    }

    public void a() {
        b.a("FOLLOW_ALL_FAIL", (com.garena.android.appkit.b.e) this.f21693b, b.a.NETWORK_BUS);
        b.a("FOLLOW_ERROR", (com.garena.android.appkit.b.e) this.f21694c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("FOLLOW_ALL_FAIL", this.f21693b, b.a.NETWORK_BUS);
        b.b("FOLLOW_ERROR", this.f21694c, b.a.NETWORK_BUS);
    }
}
