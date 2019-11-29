package com.shopee.app.ui.image;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.cu;

public final class o implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final n f23045a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23046b = new g() {
        public void onEvent(a aVar) {
            o.this.f23045a.a((cu.c) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23047c = new g() {
        public void onEvent(a aVar) {
            o.this.f23045a.b((cu.c) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23048d = new g() {
        public void onEvent(a aVar) {
            o.this.f23045a.c((cu.c) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public o(n nVar) {
        this.f23045a = nVar;
    }

    public void a() {
        b.a("ON_IMAGE_SEARCH_PREPARE_DONE", (e) this.f23046b, b.a.NETWORK_BUS);
        b.a("ON_IMAGE_SEARCH_PREPARE_FAIL", (e) this.f23047c, b.a.NETWORK_BUS);
        b.a("ON_IMAGE_SEARCH_PREPARE_PROGRESS", (e) this.f23048d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ON_IMAGE_SEARCH_PREPARE_DONE", this.f23046b, b.a.NETWORK_BUS);
        b.b("ON_IMAGE_SEARCH_PREPARE_FAIL", this.f23047c, b.a.NETWORK_BUS);
        b.b("ON_IMAGE_SEARCH_PREPARE_PROGRESS", this.f23048d, b.a.NETWORK_BUS);
    }
}
