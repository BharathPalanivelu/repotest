package com.shopee.app.react.modules.app.sms;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f18788a;

    /* renamed from: b  reason: collision with root package name */
    private final g f18789b = new g() {
        public void onEvent(a aVar) {
            b.this.f18788a.a((String) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f18788a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("OTP_RECEIVED", (e) this.f18789b, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("OTP_RECEIVED", this.f18789b, b.a.NETWORK_BUS);
    }
}
