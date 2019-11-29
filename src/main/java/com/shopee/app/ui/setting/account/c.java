package com.shopee.app.ui.setting.account;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.protocol.action.ResponseCommon;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f25162a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25163b = new g() {
        public void onEvent(a aVar) {
            c.this.f25162a.a((ResponseCommon) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25164c = new g() {
        public void onEvent(a aVar) {
            c.this.f25162a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f25165d = new g() {
        public void onEvent(a aVar) {
            c.this.f25162a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f25162a = bVar;
    }

    public void a() {
        b.a("ACCOUNT_FOUND_SUCCESS", (e) this.f25163b, b.a.NETWORK_BUS);
        b.a("ACCOUNT_FOUND_FAIL", (e) this.f25164c, b.a.NETWORK_BUS);
        b.a("BIND_ACCOUNT_ERROR", (e) this.f25165d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ACCOUNT_FOUND_SUCCESS", this.f25163b, b.a.NETWORK_BUS);
        b.b("ACCOUNT_FOUND_FAIL", this.f25164c, b.a.NETWORK_BUS);
        b.b("BIND_ACCOUNT_ERROR", this.f25165d, b.a.NETWORK_BUS);
    }
}
