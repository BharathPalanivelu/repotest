package com.shopee.app.ui.shopassistant.chatSetting;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ShopDetail;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f25404a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25405b = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25406c = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.g();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f25407d = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.h();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f25408e = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.i();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f25409f = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f25410g = new g() {
        public void onEvent(a aVar) {
            e.this.f25404a.a((com.shopee.app.ui.home.me.editprofile.e) aVar);
        }
    };

    public e(d dVar) {
        this.f25404a = dVar;
    }

    public void a() {
        b.a("SHOP_INFO_FETCHED", (com.garena.android.appkit.b.e) this.f25405b, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED_FAIL", (com.garena.android.appkit.b.e) this.f25406c, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO", (com.garena.android.appkit.b.e) this.f25407d, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO_ERROR", (com.garena.android.appkit.b.e) this.f25409f, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f25410g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SHOP_INFO_FETCHED", this.f25405b, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_FETCHED_FAIL", this.f25406c, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO", this.f25407d, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO_ERROR", this.f25409f, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.f25410g, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ACTION_BAR_HOME_ACTION", (com.garena.android.appkit.b.e) this.f25408e, b.a.UI_BUS);
    }

    public void d() {
        b.b("ACTION_BAR_HOME_ACTION", this.f25408e, b.a.UI_BUS);
    }
}
