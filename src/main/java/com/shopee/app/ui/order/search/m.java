package com.shopee.app.ui.order.search;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import java.util.List;

public final class m implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f23835a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23836b = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.a((String) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23837c = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23838d = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.b((String) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f23839e = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.a((List<f>) (List) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f23840f = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f23841g = new g() {
        public void onEvent(a aVar) {
            m.this.f23835a.c((List<f>) (List) aVar.data);
        }
    };

    public m(l lVar) {
        this.f23835a = lVar;
    }

    public void a() {
        b.a("CMD_GET_SEARCH_CUSTOMER_SUCCESS", (e) this.f23839e, b.a.NETWORK_BUS);
        b.a("CMD_GET_SEARCH_CUSTOMER_ERROR", (e) this.f23840f, b.a.NETWORK_BUS);
        b.a("CMD_GET_LOAD_CUSTOMER_SUCCESS", (e) this.f23841g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CMD_GET_SEARCH_CUSTOMER_SUCCESS", this.f23839e, b.a.NETWORK_BUS);
        b.b("CMD_GET_SEARCH_CUSTOMER_ERROR", this.f23840f, b.a.NETWORK_BUS);
        b.b("CMD_GET_LOAD_CUSTOMER_SUCCESS", this.f23841g, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (e) this.f23836b, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (e) this.f23837c, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (e) this.f23838d, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f23836b, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f23837c, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.f23838d, b.a.UI_BUS);
    }
}
