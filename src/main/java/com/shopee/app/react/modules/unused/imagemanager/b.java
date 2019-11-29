package com.shopee.app.react.modules.unused.imagemanager;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f19004a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19005b = new g() {
        public void onEvent(a aVar) {
            b.this.f19004a.a((Pair) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f19004a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("WEB_IMAGE_SAVE", (e) this.f19005b, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("WEB_IMAGE_SAVE", this.f19005b, b.a.NETWORK_BUS);
    }
}
