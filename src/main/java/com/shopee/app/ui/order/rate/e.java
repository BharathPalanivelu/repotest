package com.shopee.app.ui.order.rate;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f23782a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23783b = new g() {
        public void onEvent(a aVar) {
            e.this.f23782a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23784c = new g() {
        public void onEvent(a aVar) {
            e.this.f23782a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public e(d dVar) {
        this.f23782a = dVar;
    }

    public void a() {
        b.a("ORDER_RATE_ERROR", (com.garena.android.appkit.b.e) this.f23784c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ORDER_RATE_ERROR", this.f23784c, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("RATING_FINISH", (com.garena.android.appkit.b.e) this.f23783b, b.a.UI_BUS);
    }

    public void d() {
        b.b("RATING_FINISH", this.f23783b, b.a.UI_BUS);
    }
}
