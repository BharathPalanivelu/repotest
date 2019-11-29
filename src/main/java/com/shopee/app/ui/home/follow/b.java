package com.shopee.app.ui.home.follow;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f22219a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22220b = new g() {
        public void onEvent(a aVar) {
            b.this.f22219a.a(((Integer) aVar.data).intValue());
        }
    };

    public void a() {
    }

    public void b() {
    }

    public b(a aVar) {
        this.f22219a = aVar;
    }

    public void c() {
        com.garena.android.appkit.b.b.a("TAB_RESELECTED", (e) this.f22220b, b.a.UI_BUS);
    }

    public void d() {
        com.garena.android.appkit.b.b.b("TAB_RESELECTED", this.f22220b, b.a.UI_BUS);
    }
}
