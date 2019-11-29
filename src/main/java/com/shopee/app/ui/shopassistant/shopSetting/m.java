package com.shopee.app.ui.shopassistant.shopSetting;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.c.d;
import com.shopee.app.ui.home.me.editprofile.e;

public final class m implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l f25593a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25594b = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25595c = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.g();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f25596d = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.h();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f25597e = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.i();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f25598f = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f25599g = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.a((e) aVar);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.a((d) aVar);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            m.this.f25593a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public m(l lVar) {
        this.f25593a = lVar;
    }

    public void a() {
        b.a("SHOP_INFO_FETCHED", (com.garena.android.appkit.b.e) this.f25594b, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED_FAIL", (com.garena.android.appkit.b.e) this.f25595c, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO", (com.garena.android.appkit.b.e) this.f25596d, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO_ERROR", (com.garena.android.appkit.b.e) this.f25598f, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f25599g, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO_ERROR", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SHOP_INFO_FETCHED", this.f25594b, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_FETCHED_FAIL", this.f25595c, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO", this.f25596d, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO_ERROR", this.f25598f, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.f25599g, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO", this.h, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO_ERROR", this.i, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ACTION_BAR_HOME_ACTION", (com.garena.android.appkit.b.e) this.f25597e, b.a.UI_BUS);
    }

    public void d() {
        b.b("ACTION_BAR_HOME_ACTION", this.f25597e, b.a.UI_BUS);
    }
}
