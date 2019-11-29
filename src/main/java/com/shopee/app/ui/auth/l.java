package com.shopee.app.ui.auth;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.protocol.action.ResponseCommon;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f19554a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19555b = new g() {
        public void onEvent(a aVar) {
            l.this.f19554a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19556c = new g() {
        public void onEvent(a aVar) {
            l.this.f19554a.a((ResponseCommon) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19557d = new g() {
        public void onEvent(a aVar) {
            l.this.f19554a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19558e = new g() {
        public void onEvent(a aVar) {
            l.this.f19554a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public l(k kVar) {
        this.f19554a = kVar;
    }

    public void a() {
        b.a("LINE_LOGIN_REGISTER", (e) this.f19555b, b.a.NETWORK_BUS);
        b.a("LINE_LOGIN_SUCCESS", (e) this.f19556c, b.a.NETWORK_BUS);
        b.a("LINE_LOGIN_FAIL", (e) this.f19557d, b.a.NETWORK_BUS);
        b.a("LOGIN_FAIL", (e) this.f19558e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("LINE_LOGIN_REGISTER", this.f19555b, b.a.NETWORK_BUS);
        b.b("LINE_LOGIN_SUCCESS", this.f19556c, b.a.NETWORK_BUS);
        b.b("LINE_LOGIN_FAIL", this.f19557d, b.a.NETWORK_BUS);
        b.b("LOGIN_FAIL", this.f19558e, b.a.NETWORK_BUS);
    }
}
