package com.shopee.app.ui.setting.language;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f25251a;

    /* renamed from: b  reason: collision with root package name */
    private final g f25252b = new g() {
        public void onEvent(a aVar) {
            c.this.f25251a.e();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f25253c = new g() {
        public void onEvent(a aVar) {
            c.this.f25251a.f();
        }
    };

    public c(b bVar) {
        this.f25251a = bVar;
    }

    public void a() {
        b.a("LANG_SELECTION_PROCESSED", (e) this.f25253c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("LANG_SELECTION_PROCESSED", this.f25253c, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ACTION_BAR_DONE", (e) this.f25252b, b.a.UI_BUS);
    }

    public void d() {
        b.b("ACTION_BAR_DONE", this.f25252b, b.a.UI_BUS);
    }
}
