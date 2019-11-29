package com.shopee.app.ui.auth.password;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.protocol.action.ResponseCommon;
import java.util.List;

public final class n implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f19629a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19630b = new g() {
        public void onEvent(a aVar) {
            n.this.f19629a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19631c = new g() {
        public void onEvent(a aVar) {
            n.this.f19629a.a((ResponseCommon) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19632d = new g() {
        public void onEvent(a aVar) {
            n.this.f19629a.a((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19633e = new g() {
        public void onEvent(a aVar) {
            n.this.f19629a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f19634f = new g() {
        public void onEvent(a aVar) {
            n.this.f19629a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public n(m mVar) {
        this.f19629a = mVar;
    }

    public void a() {
        b.a("SEND_V_MAIL_FAIL", (e) this.f19630b, b.a.NETWORK_BUS);
        b.a("ACCOUNT_FOUND_SUCCESS", (e) this.f19631c, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_LOAD", (e) this.f19632d, b.a.NETWORK_BUS);
        b.a("GET_USER_INFO_ERROR", (e) this.f19633e, b.a.NETWORK_BUS);
        b.a("ACCOUNT_FOUND_FAIL", (e) this.f19634f, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SEND_V_MAIL_FAIL", this.f19630b, b.a.NETWORK_BUS);
        b.b("ACCOUNT_FOUND_SUCCESS", this.f19631c, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_LOAD", this.f19632d, b.a.NETWORK_BUS);
        b.b("GET_USER_INFO_ERROR", this.f19633e, b.a.NETWORK_BUS);
        b.b("ACCOUNT_FOUND_FAIL", this.f19634f, b.a.NETWORK_BUS);
    }
}
