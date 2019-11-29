package com.shopee.app.ui.myaccount.SocialAccounts;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.c.b;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f23294a;

    /* renamed from: b  reason: collision with root package name */
    private final g f23295b = new g() {
        public void onEvent(a aVar) {
            e.this.f23294a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f23296c = new g() {
        public void onEvent(a aVar) {
            e.this.f23294a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f23297d = new g() {
        public void onEvent(a aVar) {
            e.this.f23294a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f23298e = new g() {
        public void onEvent(a aVar) {
            e.this.f23294a.a((b) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f23299f = new g() {
        public void onEvent(a aVar) {
            e.this.f23294a.c((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f23294a = dVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("BIND_ACCOUNT_ERROR", (com.garena.android.appkit.b.e) this.f23295b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("UNBIND_ACCOUNT_ERROR", (com.garena.android.appkit.b.e) this.f23296c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("SHOP_INFO_FETCHED", (com.garena.android.appkit.b.e) this.f23297d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("SHOP_INFO_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f23297d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("FB_INFO", (com.garena.android.appkit.b.e) this.f23298e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("SET_USER_INFO_ERROR", (com.garena.android.appkit.b.e) this.f23299f, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("BIND_ACCOUNT_ERROR", this.f23295b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("UNBIND_ACCOUNT_ERROR", this.f23296c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("SHOP_INFO_FETCHED", this.f23297d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("SHOP_INFO_LOCAL_LOAD", this.f23297d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("FB_INFO", this.f23298e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("SET_USER_INFO_ERROR", this.f23299f, b.a.NETWORK_BUS);
    }
}
