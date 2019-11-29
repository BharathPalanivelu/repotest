package com.shopee.app.ui.datapoint;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f21473a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21474b = new g() {
        public void onEvent(a aVar) {
            b.this.f21473a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21475c = new g() {
        public void onEvent(a aVar) {
            b.this.f21473a.a((com.shopee.app.network.c.d.b<Integer>) (com.shopee.app.network.c.d.b) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f21476d = new g() {
        public void onEvent(a aVar) {
            b.this.f21473a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f21477e = new g() {
        public void onEvent(a aVar) {
            b.this.f21473a.b((com.shopee.app.network.c.d.b<Integer>) (com.shopee.app.network.c.d.b) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f21473a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("RESPONSE_CONTACT_SUCCESS", (e) this.f21474b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("RESPONSE_CONTACT_ERROR", (e) this.f21475c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_CONTACT_INTERACTOR_DONE", (e) this.f21476d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_CONTACT_INTERACTOR_ERROR", (e) this.f21477e, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("RESPONSE_CONTACT_SUCCESS", this.f21474b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("RESPONSE_CONTACT_ERROR", this.f21475c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_CONTACT_INTERACTOR_DONE", this.f21476d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_CONTACT_INTERACTOR_ERROR", this.f21477e, b.a.NETWORK_BUS);
    }
}
