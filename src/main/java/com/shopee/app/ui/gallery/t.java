package com.shopee.app.ui.gallery;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class t implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final s f22015a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22016b = new g() {
        public void onEvent(a aVar) {
            t.this.f22015a.e();
        }
    };

    public void a() {
    }

    public void b() {
    }

    public t(s sVar) {
        this.f22015a = sVar;
    }

    public void c() {
        b.a("GALLERY_ITEM_SELECTED", (e) this.f22016b, b.a.UI_BUS);
    }

    public void d() {
        b.b("GALLERY_ITEM_SELECTED", this.f22016b, b.a.UI_BUS);
    }
}
