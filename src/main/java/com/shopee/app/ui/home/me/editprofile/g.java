package com.shopee.app.ui.home.me.editprofile;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;

public final class g implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f22372a;

    /* renamed from: b  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f22373b = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f22372a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f22374c = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f22372a.a((UserInfo) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f22375d = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f22372a.a((com.shopee.app.ui.auth.a.a) aVar);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f22376e = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f22372a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public g(f fVar) {
        this.f22372a = fVar;
    }

    public void a() {
        b.a("SET_USER_INFO_ERROR", (e) this.f22373b, b.a.NETWORK_BUS);
        b.a("EMAIL_VERIFIED", (e) this.f22374c, b.a.NETWORK_BUS);
        b.a("UNBIND_ACCOUNT_SUCCESS", (e) this.f22374c, b.a.NETWORK_BUS);
        b.a("LOGIN_USER_INFO_LOAD", (e) this.f22374c, b.a.NETWORK_BUS);
        b.a("BIND_ACCOUNT_SUCCESS", (e) this.f22375d, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO_ERROR", (e) this.f22376e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SET_USER_INFO_ERROR", this.f22373b, b.a.NETWORK_BUS);
        b.b("EMAIL_VERIFIED", this.f22374c, b.a.NETWORK_BUS);
        b.b("UNBIND_ACCOUNT_SUCCESS", this.f22374c, b.a.NETWORK_BUS);
        b.b("LOGIN_USER_INFO_LOAD", this.f22374c, b.a.NETWORK_BUS);
        b.b("BIND_ACCOUNT_SUCCESS", this.f22375d, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO_ERROR", this.f22376e, b.a.NETWORK_BUS);
    }
}
