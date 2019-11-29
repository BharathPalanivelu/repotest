package com.shopee.app.ui.chat2.product;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;

public final class l implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f20816a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20817b = new g() {
        public void onEvent(a aVar) {
            l.this.f20816a.a((Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20818c = new g() {
        public void onEvent(a aVar) {
            l.this.f20816a.b((Pair) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public l(k kVar) {
        this.f20816a = kVar;
    }

    public void a() {
        b.a("ITEM_BY_TYPE_LIST_LOCAL_LOAD", (e) this.f20817b, b.a.NETWORK_BUS);
        b.a("ITEM_BY_SHOP_LIST_LOCAL_LOAD", (e) this.f20818c, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_BY_TYPE_LIST_LOCAL_LOAD", this.f20817b, b.a.NETWORK_BUS);
        b.b("ITEM_BY_SHOP_LIST_LOCAL_LOAD", this.f20818c, b.a.NETWORK_BUS);
    }
}
