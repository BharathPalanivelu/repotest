package com.shopee.app.ui.follow.search;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f21815a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21816b = new g() {
        public void onEvent(a aVar) {
            l.this.f21815a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public l(k kVar) {
        this.f21815a = kVar;
    }

    public void a() {
        b.a("FOLLOW_ERROR", (e) this.f21816b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("FOLLOW_ERROR", this.f21816b, b.a.NETWORK_BUS);
    }
}
