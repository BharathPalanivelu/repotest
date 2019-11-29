package com.shopee.app.ui.chat2.order;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.bm;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f20652a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20653b = new g() {
        public void onEvent(a aVar) {
            c.this.f20652a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20654c = new g() {
        public void onEvent(a aVar) {
            c.this.f20652a.a((bm.b) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20655d = new g() {
        public void onEvent(a aVar) {
            c.this.f20652a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20656e = new g() {
        public void onEvent(a aVar) {
            c.this.f20652a.b(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f20652a = bVar;
    }

    public void a() {
        b.a("CHECKOUT_LIST_SAVED", (e) this.f20653b, b.a.NETWORK_BUS);
        b.a("ORDER_LIST_FOR_XX_LOCAL_LOAD", (e) this.f20654c, b.a.NETWORK_BUS);
        b.a("ORDER_LIST_FOR_USER_SAVED", (e) this.f20655d, b.a.NETWORK_BUS);
        b.a("ORDER_LIST_FOR_SHOP_SAVED", (e) this.f20656e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CHECKOUT_LIST_SAVED", this.f20653b, b.a.NETWORK_BUS);
        b.b("ORDER_LIST_FOR_XX_LOCAL_LOAD", this.f20654c, b.a.NETWORK_BUS);
        b.b("ORDER_LIST_FOR_USER_SAVED", this.f20655d, b.a.NETWORK_BUS);
        b.b("ORDER_LIST_FOR_SHOP_SAVED", this.f20656e, b.a.NETWORK_BUS);
    }
}
