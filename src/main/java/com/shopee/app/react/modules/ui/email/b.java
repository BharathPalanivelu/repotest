package com.shopee.app.react.modules.ui.email;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f18843a;

    /* renamed from: b  reason: collision with root package name */
    private final g f18844b = new g() {
        public void onEvent(a aVar) {
            b.this.f18843a.a((Pair<Boolean, Boolean>) (Pair) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f18843a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("WEB_IMAGE_SAVE", (e) this.f18844b, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("WEB_IMAGE_SAVE", this.f18844b, b.a.NETWORK_BUS);
    }
}
