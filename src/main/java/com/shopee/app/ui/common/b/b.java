package com.shopee.app.ui.common.b;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f21230a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21231b = new g() {
        public void onEvent(a aVar) {
            b.this.f21230a.a((ItemDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f21232c = new g() {
        public void onEvent(a aVar) {
            b.this.f21230a.a(((Integer) aVar.data).intValue());
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f21230a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("ITEM_DETAIL", (e) this.f21231b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_DETAIL_LOAD", (e) this.f21231b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_GET_CHAT_ITEMS_ERROR", (e) this.f21232c, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("ITEM_DETAIL", this.f21231b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_DETAIL_LOAD", this.f21231b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_GET_CHAT_ITEMS_ERROR", this.f21232c, b.a.NETWORK_BUS);
    }
}
