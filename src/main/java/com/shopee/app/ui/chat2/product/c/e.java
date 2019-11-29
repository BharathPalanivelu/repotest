package com.shopee.app.ui.chat2.product.c;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;
import java.util.List;

public final class e implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f20772a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20773b = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.a((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20774c = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.b((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final f f20775d = new f() {
        public void a(a aVar) {
            e.this.f20772a.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20776e = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20777f = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.a((String) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20778g = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.f();
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.b((String) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            e.this.f20772a.c((Pair<com.shopee.app.network.d.d.a.a, List<Pair<Integer, Long>>>) (Pair) aVar.data);
        }
    };
    private final f j = new f() {
        public void a(a aVar) {
            e.this.f20772a.g();
        }
    };

    public e(d dVar) {
        this.f20772a = dVar;
    }

    public void a() {
        b.a("ITEM_BY_SHOP_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f20773b, b.a.NETWORK_BUS);
        b.a("ITEM_BY_ID_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f20774c, b.a.NETWORK_BUS);
        b.a("CMD_GET_RECENT_ITEMS_SUCCESS", (com.garena.android.appkit.b.e) this.f20775d, b.a.NETWORK_BUS);
        b.a("ITEM_BY_SHOP_LIST_SAVED", (com.garena.android.appkit.b.e) this.f20776e, b.a.NETWORK_BUS);
        b.a("ON_SEARCH_PRODUCT_IN_SHOP_RESULT", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (com.garena.android.appkit.b.e) this.j, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_BY_SHOP_LIST_LOCAL_LOAD", this.f20773b, b.a.NETWORK_BUS);
        b.b("ITEM_BY_ID_LIST_LOCAL_LOAD", this.f20774c, b.a.NETWORK_BUS);
        b.b("CMD_GET_RECENT_ITEMS_SUCCESS", this.f20775d, b.a.NETWORK_BUS);
        b.b("ITEM_BY_SHOP_LIST_SAVED", this.f20776e, b.a.NETWORK_BUS);
        b.b("ON_SEARCH_PRODUCT_IN_SHOP_RESULT", this.i, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.j, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (com.garena.android.appkit.b.e) this.f20777f, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (com.garena.android.appkit.b.e) this.f20778g, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (com.garena.android.appkit.b.e) this.h, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f20777f, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f20778g, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.h, b.a.UI_BUS);
    }
}
