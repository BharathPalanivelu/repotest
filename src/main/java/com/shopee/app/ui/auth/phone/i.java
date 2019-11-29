package com.shopee.app.ui.auth.phone;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;

public final class i implements com.garena.android.appkit.b.i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f19730a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19731b = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19732c = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f19733d = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.c((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f19734e = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.a((Pair<String, Boolean>) (Pair) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f19735f = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.d((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f19736g = new g() {
        public void onEvent(a aVar) {
            i.this.f19730a.a((String) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public i(h hVar) {
        this.f19730a = hVar;
    }

    public void a() {
        b.a("PHONE_VERIFY_ERROR", (e) this.f19731b, b.a.NETWORK_BUS);
        b.a("LOGIN_FAIL", (e) this.f19732c, b.a.NETWORK_BUS);
        b.a("BIND_ACCOUNT_ERROR", (e) this.f19733d, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_SUCCESS", (e) this.f19734e, b.a.NETWORK_BUS);
        b.a("SEND_V_CODE_FAIL", (e) this.f19735f, b.a.NETWORK_BUS);
        b.a("OTP_RECEIVED", (e) this.f19736g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("PHONE_VERIFY_ERROR", this.f19731b, b.a.NETWORK_BUS);
        b.b("LOGIN_FAIL", this.f19732c, b.a.NETWORK_BUS);
        b.b("BIND_ACCOUNT_ERROR", this.f19733d, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_SUCCESS", this.f19734e, b.a.NETWORK_BUS);
        b.b("SEND_V_CODE_FAIL", this.f19735f, b.a.NETWORK_BUS);
        b.b("OTP_RECEIVED", this.f19736g, b.a.NETWORK_BUS);
    }
}
