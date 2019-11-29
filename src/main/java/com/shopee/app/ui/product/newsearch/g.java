package com.shopee.app.ui.product.newsearch;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.i;

public final class g implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f24705a;

    /* renamed from: b  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f24706b = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f24705a.a((String) aVar.data);
        }
    };

    public void a() {
    }

    public void b() {
    }

    public g(f fVar) {
        this.f24705a = fVar;
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (e) this.f24706b, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f24706b, b.a.UI_BUS);
    }
}
