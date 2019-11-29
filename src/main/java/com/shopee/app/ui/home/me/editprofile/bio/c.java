package com.shopee.app.ui.home.me.editprofile.bio;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f22336a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22337b = new g() {
        public void onEvent(a aVar) {
            c.this.f22336a.e();
        }
    };

    public void a() {
    }

    public void b() {
    }

    public c(b bVar) {
        this.f22336a = bVar;
    }

    public void c() {
        b.a("ACTION_BAR_DONE", (e) this.f22337b, b.a.UI_BUS);
    }

    public void d() {
        b.b("ACTION_BAR_DONE", this.f22337b, b.a.UI_BUS);
    }
}
