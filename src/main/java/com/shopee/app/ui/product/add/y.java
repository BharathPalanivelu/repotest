package com.shopee.app.ui.product.add;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import java.util.List;

public final class y implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final x f24222a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24223b = new g() {
        public void onEvent(a aVar) {
            y.this.f24222a.a((t) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f24224c = new g() {
        public void onEvent(a aVar) {
            y.this.f24222a.a((List<t>) (List) aVar.data);
        }
    };

    public y(x xVar) {
        this.f24222a = xVar;
    }

    public void a() {
        b.a("FACEBOOK_PAGE_OBTAINED", (e) this.f24224c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("FACEBOOK_PAGE_OBTAINED", this.f24224c, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("FACEBOOK_PAGE_SELECTED", (e) this.f24223b, b.a.UI_BUS);
    }

    public void d() {
        b.b("FACEBOOK_PAGE_SELECTED", this.f24223b, b.a.UI_BUS);
    }
}
