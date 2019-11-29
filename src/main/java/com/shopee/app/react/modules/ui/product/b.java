package com.shopee.app.react.modules.ui.product;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.ShareMessage;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f18947a;

    /* renamed from: b  reason: collision with root package name */
    private final g f18948b = new g() {
        public void onEvent(a aVar) {
            b.this.f18947a.b((AddCartMessage) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f18949c = new g() {
        public void onEvent(a aVar) {
            b.this.f18947a.c((AddCartMessage) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f18950d = new g() {
        public void onEvent(a aVar) {
            b.this.f18947a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f18951e = new g() {
        public void onEvent(a aVar) {
            b.this.f18947a.b((c.b) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f18952f = new g() {
        public void onEvent(a aVar) {
            b.this.f18947a.a((ShareMessage) aVar.data);
        }
    };

    public b(a aVar) {
        this.f18947a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("ADD_CART_ITEM_SUCCESS", (e) this.f18949c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ADD_CART_ITEM_FAIL", (e) this.f18950d, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("ADD_CART_ITEM_SUCCESS", this.f18949c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ADD_CART_ITEM_FAIL", this.f18950d, b.a.NETWORK_BUS);
    }

    public void c() {
        com.garena.android.appkit.b.b.a("ON_BUY_PANEL_SELECTION_DONE", (e) this.f18948b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_ADD_CART_ANIMATION", (e) this.f18951e, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("FACEBOOK_SHARING_FB", (e) this.f18952f, b.a.UI_BUS);
    }

    public void d() {
        com.garena.android.appkit.b.b.b("ON_BUY_PANEL_SELECTION_DONE", this.f18948b, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_ADD_CART_ANIMATION", this.f18951e, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("FACEBOOK_SHARING_FB", this.f18952f, b.a.UI_BUS);
    }
}
