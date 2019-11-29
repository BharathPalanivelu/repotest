package com.shopee.app.ui.auth;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.protocol.action.ResponseCommon;

public final class q implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final p f19760a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19761b = new g() {
        public void onEvent(a aVar) {
            q.this.f19760a.a((ResponseCommon) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19762c = new g() {
        public void onEvent(a aVar) {
            q.this.f19760a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19763d = new g() {
        public void onEvent(a aVar) {
            q.this.f19760a.a((Pair<String, Boolean>) (Pair) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19764e = new g() {
        public void onEvent(a aVar) {
            q.this.f19760a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public q(p pVar) {
        this.f19760a = pVar;
    }

    public void a() {
        b.a("ACCOUNT_FOUND_SUCCESS", (e) this.f19761b, b.a.NETWORK_BUS);
        b.a("ACCOUNT_FOUND_FAIL", (e) this.f19762c, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_SUCCESS", (e) this.f19763d, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_FAIL", (e) this.f19764e, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ACCOUNT_FOUND_SUCCESS", this.f19761b, b.a.NETWORK_BUS);
        b.b("ACCOUNT_FOUND_FAIL", this.f19762c, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_SUCCESS", this.f19763d, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_FAIL", this.f19764e, b.a.NETWORK_BUS);
    }
}
