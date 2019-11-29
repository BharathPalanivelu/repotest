package com.shopee.app.ui.gallery.instagram;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.instagram.h;
import java.util.List;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f21943a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21944b = new g() {
        public void onEvent(a aVar) {
            e.this.f21943a.a((List<h>) (List) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f21943a = dVar;
    }

    public void a() {
        b.a("INSTAGRAM_IMAGE", (com.garena.android.appkit.b.e) this.f21944b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("INSTAGRAM_IMAGE", this.f21944b, b.a.NETWORK_BUS);
    }
}
