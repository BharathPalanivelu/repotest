package com.shopee.app.ui.chat2.buy;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.web.protocol.AddCartMessage;
import java.util.List;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f20376a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20377b = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.a((AddCartMessage) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20378c = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20379d = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.a((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20380e = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.e();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20381f = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final f f20382g = new f() {
        public void a(a aVar) {
            c.this.f20376a.f();
        }
    };
    private final f h = new f() {
        public void a(a aVar) {
            c.this.f20376a.g();
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            c.this.f20376a.h();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f20376a = bVar;
    }

    public void a() {
        b.a("ADD_CART_ITEM_SUCCESS", (e) this.f20377b, b.a.NETWORK_BUS);
        b.a("ADD_CART_ITEM_FAIL", (e) this.f20378c, b.a.NETWORK_BUS);
        b.a("BUY_ITEM_BY_SHOP_LIST_LOCAL_LOAD", (e) this.f20379d, b.a.NETWORK_BUS);
        b.a("CMD_GET_OFFER_SUCCESS", (e) this.f20380e, b.a.NETWORK_BUS);
        b.a("ITEM_BY_SHOP_LIST_SAVED", (e) this.f20381f, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (e) this.f20382g, b.a.NETWORK_BUS);
        b.a("ITEM_SNAPSHOT_LOAD", (e) this.h, b.a.NETWORK_BUS);
        b.a("OFFERS_IN_CART_SAVED", (e) this.i, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ADD_CART_ITEM_SUCCESS", this.f20377b, b.a.NETWORK_BUS);
        b.b("ADD_CART_ITEM_FAIL", this.f20378c, b.a.NETWORK_BUS);
        b.b("BUY_ITEM_BY_SHOP_LIST_LOCAL_LOAD", this.f20379d, b.a.NETWORK_BUS);
        b.b("CMD_GET_OFFER_SUCCESS", this.f20380e, b.a.NETWORK_BUS);
        b.b("ITEM_BY_SHOP_LIST_SAVED", this.f20381f, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.f20382g, b.a.NETWORK_BUS);
        b.b("ITEM_SNAPSHOT_LOAD", this.h, b.a.NETWORK_BUS);
        b.b("OFFERS_IN_CART_SAVED", this.i, b.a.NETWORK_BUS);
    }
}
