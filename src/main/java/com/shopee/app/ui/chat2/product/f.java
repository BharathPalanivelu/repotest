package com.shopee.app.ui.chat2.product;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f20793a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20794b = new g() {
        public void onEvent(a aVar) {
            f.this.f20793a.e();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public f(e eVar) {
        this.f20793a = eVar;
    }

    public void a() {
        b.a("NOTIFY_SIBLINGS", (e) this.f20794b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("NOTIFY_SIBLINGS", this.f20794b, b.a.NETWORK_BUS);
    }
}
