package com.shopee.app.ui.activity;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f19467a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19468b = new g() {
        public void onEvent(a aVar) {
            e.this.f19467a.a((ActivityCounter) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f19469c = new g() {
        public void onEvent(a aVar) {
            e.this.f19467a.a((ActionRequiredCounter) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public e(d dVar) {
        this.f19467a = dVar;
    }

    public void a() {
        b.a("ACTIVITY_BADGE_UPDATE", (com.garena.android.appkit.b.e) this.f19468b, b.a.NETWORK_BUS);
        b.a("ACTION_REQUIRED_BADGE_UPDATE", (com.garena.android.appkit.b.e) this.f19469c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ACTIVITY_BADGE_UPDATE", this.f19468b, b.a.NETWORK_BUS);
        b.b("ACTION_REQUIRED_BADGE_UPDATE", this.f19469c, b.a.NETWORK_BUS);
    }
}
