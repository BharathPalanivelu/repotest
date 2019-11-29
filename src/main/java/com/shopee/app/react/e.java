package com.shopee.app.react;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f18651a;

    /* renamed from: b  reason: collision with root package name */
    private final g f18652b = new g() {
        public void onEvent(a aVar) {
            e.this.f18651a.q();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f18651a = dVar;
    }

    public void a() {
        b.a("REACT_PAGE_DID_MOUNT", (com.garena.android.appkit.b.e) this.f18652b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("REACT_PAGE_DID_MOUNT", this.f18652b, b.a.NETWORK_BUS);
    }
}
