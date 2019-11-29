package com.shopee.app.ui.product.attributes;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f24241a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24242b = new g() {
        public void onEvent(a aVar) {
            b.this.f24241a.a((u) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24243c = new g() {
        public void onEvent(a aVar) {
            b.this.f24241a.b((u) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24244d = new g() {
        public void onEvent(a aVar) {
            b.this.f24241a.c((u) aVar.data);
        }
    };

    public void a() {
    }

    public void b() {
    }

    public b(a aVar) {
        this.f24241a = aVar;
    }

    public void c() {
        com.garena.android.appkit.b.b.a("ON_ATTRIBUTE_SELECTED", (e) this.f24242b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_ATTRIBUTE_AUTO_SELECTED", (e) this.f24243c, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_SELF_DEFINE_CLICKED", (e) this.f24244d, b.a.UI_BUS);
    }

    public void d() {
        com.garena.android.appkit.b.b.b("ON_ATTRIBUTE_SELECTED", this.f24242b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_ATTRIBUTE_AUTO_SELECTED", this.f24243c, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_SELF_DEFINE_CLICKED", this.f24244d, b.a.UI_BUS);
    }
}
