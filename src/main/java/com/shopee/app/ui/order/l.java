package com.shopee.app.ui.order;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.OrderDetail;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f23721a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23722b = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.a((OrderDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23723c = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.b((OrderDetail) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23724d = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.c((OrderDetail) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f23725e = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.d((OrderDetail) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f23726f = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.e((OrderDetail) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f23727g = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.f((OrderDetail) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            l.this.f23721a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public l(k kVar) {
        this.f23721a = kVar;
    }

    public void a() {
        b.a("ORDER_UPDATE_ERROR", (e) this.h, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ORDER_UPDATE_ERROR", this.h, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ORDER_SELLER_RATE", (e) this.f23722b, b.a.UI_BUS);
        b.a("ORDER_BUYER_VIEW_RATE", (e) this.f23723c, b.a.UI_BUS);
        b.a("ORDER_SELLER_VIEW_RATE", (e) this.f23724d, b.a.UI_BUS);
        b.a("ORDER_SELLER_CHANGE_RATE", (e) this.f23725e, b.a.UI_BUS);
        b.a("ORDER_SELLER_VIEW_BUYER_RATE_SELLER", (e) this.f23726f, b.a.UI_BUS);
        b.a("ORDER_BUYER_VIEW_SELLER_RATE_BUYER", (e) this.f23727g, b.a.UI_BUS);
    }

    public void d() {
        b.b("ORDER_SELLER_RATE", this.f23722b, b.a.UI_BUS);
        b.b("ORDER_BUYER_VIEW_RATE", this.f23723c, b.a.UI_BUS);
        b.b("ORDER_SELLER_VIEW_RATE", this.f23724d, b.a.UI_BUS);
        b.b("ORDER_SELLER_CHANGE_RATE", this.f23725e, b.a.UI_BUS);
        b.b("ORDER_SELLER_VIEW_BUYER_RATE_SELLER", this.f23726f, b.a.UI_BUS);
        b.b("ORDER_BUYER_VIEW_SELLER_RATE_BUYER", this.f23727g, b.a.UI_BUS);
    }
}
