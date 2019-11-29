package com.shopee.app.ui.auth.signup.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.protocol.action.ResponseCommon;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f19813a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19814b = new g() {
        public void onEvent(a aVar) {
            b.this.f19813a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19815c = new g() {
        public void onEvent(a aVar) {
            b.this.f19813a.a((ResponseCommon) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f19813a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("LINE_LOGIN_FAIL", (e) this.f19814b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("LINE_LOGIN_SUCCESS", (e) this.f19815c, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("LINE_LOGIN_FAIL", this.f19814b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("LINE_LOGIN_SUCCESS", this.f19815c, b.a.NETWORK_BUS);
    }
}
