package com.shopee.app.ui.product.comment;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.aj;

public final class j implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f24521a;

    /* renamed from: b  reason: collision with root package name */
    private final g f24522b = new g() {
        public void onEvent(a aVar) {
            j.this.f24521a.a((aj.b) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public j(i iVar) {
        this.f24521a = iVar;
    }

    public void a() {
        b.a("COMMENT_LIST_LOCAL_LOAD", (e) this.f24522b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("COMMENT_LIST_LOCAL_LOAD", this.f24522b, b.a.NETWORK_BUS);
    }
}
