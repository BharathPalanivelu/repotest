package com.shopee.app.ui.common.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f21065a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21066b = new g() {
        public void onEvent(a aVar) {
            b.this.f21065a.a((ItemDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21067c = new g() {
        public void onEvent(a aVar) {
            b.this.f21065a.a(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f21065a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("ITEM_DETAIL", (e) this.f21066b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_DETAIL_LOAD", (e) this.f21066b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_GET_CHAT_ITEMS_ERROR", (e) this.f21067c, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("ITEM_DETAIL", this.f21066b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_DETAIL_LOAD", this.f21066b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_GET_CHAT_ITEMS_ERROR", this.f21067c, b.a.NETWORK_BUS);
    }
}
