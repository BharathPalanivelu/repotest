package com.shopee.app.ui.income.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.income.h;

public final class g implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final f f23115a;

    /* renamed from: b  reason: collision with root package name */
    private final com.garena.android.appkit.b.g f23116b = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            g.this.f23115a.a((h) aVar.data);
        }
    };

    public void a() {
    }

    public void b() {
    }

    public g(f fVar) {
        this.f23115a = fVar;
    }

    public void c() {
        b.a("ON_WEEK_SELECTED", (e) this.f23116b, b.a.UI_BUS);
    }

    public void d() {
        b.b("ON_WEEK_SELECTED", this.f23116b, b.a.UI_BUS);
    }
}
