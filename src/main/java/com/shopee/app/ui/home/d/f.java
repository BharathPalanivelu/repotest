package com.shopee.app.ui.home.d;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f22164a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22165b = new g() {
        public void onEvent(a aVar) {
            f.this.f22164a.b((String) aVar.data);
        }
    };

    public void a() {
    }

    public void b() {
    }

    public f(e eVar) {
        this.f22164a = eVar;
    }

    public void c() {
        b.a("INSTALL_REF_ARRIVED", (e) this.f22165b, b.a.UI_BUS);
    }

    public void d() {
        b.b("INSTALL_REF_ARRIVED", this.f22165b, b.a.UI_BUS);
    }
}
