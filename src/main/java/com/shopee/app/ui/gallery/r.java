package com.shopee.app.ui.gallery;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import java.util.List;

public final class r implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final q f21997a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21998b = new g() {
        public void onEvent(a aVar) {
            r.this.f21997a.b((List) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public r(q qVar) {
        this.f21997a = qVar;
    }

    public void a() {
        b.a("GALLERY_ALBUM_LOCAL_LOAD", (e) this.f21998b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("GALLERY_ALBUM_LOCAL_LOAD", this.f21998b, b.a.NETWORK_BUS);
    }
}
