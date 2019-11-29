package com.shopee.app.ui.product.attributes;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import java.util.List;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f24303a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24304b = new g() {
        public void onEvent(a aVar) {
            l.this.f24303a.a((String) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24305c = new g() {
        public void onEvent(a aVar) {
            l.this.f24303a.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f24306d = new g() {
        public void onEvent(a aVar) {
            l.this.f24303a.b((String) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f24307e = new g() {
        public void onEvent(a aVar) {
            l.this.f24303a.a((List<v>) (List) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f24308f = new g() {
        public void onEvent(a aVar) {
            l.this.f24303a.a((u) aVar.data);
        }
    };

    public l(k kVar) {
        this.f24303a = kVar;
    }

    public void a() {
        b.a("LOCAL_ATTRIBUTE_SUCCESS", (e) this.f24307e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("LOCAL_ATTRIBUTE_SUCCESS", this.f24307e, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (e) this.f24304b, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (e) this.f24305c, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (e) this.f24306d, b.a.UI_BUS);
        b.a("ON_SELF_DEFINE_ATTRIBUTE_SELECTED", (e) this.f24308f, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f24304b, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f24305c, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.f24306d, b.a.UI_BUS);
        b.b("ON_SELF_DEFINE_ATTRIBUTE_SELECTED", this.f24308f, b.a.UI_BUS);
    }
}
