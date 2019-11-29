package com.shopee.app.ui.myproduct.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.i;

public final class g implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f23412a;

    /* renamed from: b  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f23413b = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f23412a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f23414c = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f23412a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public g(f fVar) {
        this.f23412a = fVar;
    }

    public void a() {
        b.a("ITEM_DELETE_ERROR", (e) this.f23413b, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_RESULT_ERROR", (e) this.f23414c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_DELETE_ERROR", this.f23413b, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_RESULT_ERROR", this.f23414c, b.a.NETWORK_BUS);
    }
}
