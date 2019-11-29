package com.shopee.app.ui.chat2.product;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class d implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f20788a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20789b = new g() {
        public void onEvent(a aVar) {
            d.this.f20788a.e();
        }
    };

    public void a() {
    }

    public void b() {
    }

    public d(c cVar) {
        this.f20788a = cVar;
    }

    public void c() {
        b.a("ON_PRODUCT_CHECK_CHANGE", (e) this.f20789b, b.a.UI_BUS);
    }

    public void d() {
        b.b("ON_PRODUCT_CHECK_CHANGE", this.f20789b, b.a.UI_BUS);
    }
}
