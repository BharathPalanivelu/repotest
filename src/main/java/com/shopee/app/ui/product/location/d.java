package com.shopee.app.ui.product.location;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;

public class d extends q<e> {

    /* renamed from: a  reason: collision with root package name */
    private final bi f24630a;

    /* renamed from: c  reason: collision with root package name */
    private final n f24631c;

    /* renamed from: d  reason: collision with root package name */
    private e f24632d = new g() {
        public void onEvent(a aVar) {
            ((e) d.this.f19220b).f();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private e f24633e = new g() {
        public void onEvent(a aVar) {
            ((e) d.this.f19220b).e();
        }
    };

    public d(n nVar, bi biVar) {
        this.f24631c = nVar;
        this.f24630a = biVar;
    }

    public void b() {
        this.f24631c.b("UPDATE_SHOP_INFO", this.f24633e);
    }

    public void a() {
        this.f24631c.a("UPDATE_SHOP_INFO", this.f24633e);
    }

    public void d() {
        this.f24630a.b("LOCATION_NOTICE_SUBMIT_LOCATION", this.f24632d);
    }

    public void c() {
        this.f24630a.a("LOCATION_NOTICE_SUBMIT_LOCATION", this.f24632d);
    }
}
