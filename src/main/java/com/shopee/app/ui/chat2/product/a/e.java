package com.shopee.app.ui.chat2.product.a;

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
    public final d f20708a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20709b = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.a((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20710c = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.b((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20711d = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20712e = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.a((String) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20713f = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.e();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20714g = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.b((String) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            e.this.f20708a.c((Pair<com.shopee.app.network.d.d.a.a, List<Pair<Integer, Long>>>) (Pair) aVar.data);
        }
    };
    private final f i = new f() {
        public void a(a aVar) {
            e.this.f20708a.f();
        }
    };

    public e(d dVar) {
        this.f20708a = dVar;
    }

    public void a() {
        b.a("ITEM_BY_TYPE_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f20709b, b.a.NETWORK_BUS);
        b.a("ITEM_BY_ID_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f20710c, b.a.NETWORK_BUS);
        b.a("ITEM_BY_TYPE_LIST_SAVED", (com.garena.android.appkit.b.e) this.f20711d, b.a.NETWORK_BUS);
        b.a("ON_SEARCH_PRODUCT_IN_SHOP_RESULT", (com.garena.android.appkit.b.e) this.h, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (com.garena.android.appkit.b.e) this.i, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_BY_TYPE_LIST_LOCAL_LOAD", this.f20709b, b.a.NETWORK_BUS);
        b.b("ITEM_BY_ID_LIST_LOCAL_LOAD", this.f20710c, b.a.NETWORK_BUS);
        b.b("ITEM_BY_TYPE_LIST_SAVED", this.f20711d, b.a.NETWORK_BUS);
        b.b("ON_SEARCH_PRODUCT_IN_SHOP_RESULT", this.h, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.i, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (com.garena.android.appkit.b.e) this.f20712e, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (com.garena.android.appkit.b.e) this.f20713f, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (com.garena.android.appkit.b.e) this.f20714g, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f20712e, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f20713f, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.f20714g, b.a.UI_BUS);
    }
}
