package com.shopee.app.ui.chat2.product.b;

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
    public final d f20741a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20742b = new g() {
        public void onEvent(a aVar) {
            e.this.f20741a.a((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final f f20743c = new f() {
        public void a(a aVar) {
            e.this.f20741a.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20744d = new g() {
        public void onEvent(a aVar) {
            e.this.f20741a.a((String) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20745e = new g() {
        public void onEvent(a aVar) {
            e.this.f20741a.f();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20746f = new g() {
        public void onEvent(a aVar) {
            e.this.f20741a.b((String) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final f f20747g = new f() {
        public void a(a aVar) {
            e.this.f20741a.g();
        }
    };

    public e(d dVar) {
        this.f20741a = dVar;
    }

    public void a() {
        b.a("CHAT_ITEM_BY_USER_LIST_LOCAL_LOAD", (com.garena.android.appkit.b.e) this.f20742b, b.a.NETWORK_BUS);
        b.a("CMD_GET_CHAT_ITEMS_SUCCUSS", (com.garena.android.appkit.b.e) this.f20743c, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (com.garena.android.appkit.b.e) this.f20747g, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("CHAT_ITEM_BY_USER_LIST_LOCAL_LOAD", this.f20742b, b.a.NETWORK_BUS);
        b.b("CMD_GET_CHAT_ITEMS_SUCCUSS", this.f20743c, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.f20747g, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("SEARCH_TEXT_CHANGED", (com.garena.android.appkit.b.e) this.f20744d, b.a.UI_BUS);
        b.a("SEARCH_TEXT_CANCELLED", (com.garena.android.appkit.b.e) this.f20745e, b.a.UI_BUS);
        b.a("SEARCH_TEXT_DONE", (com.garena.android.appkit.b.e) this.f20746f, b.a.UI_BUS);
    }

    public void d() {
        b.b("SEARCH_TEXT_CHANGED", this.f20744d, b.a.UI_BUS);
        b.b("SEARCH_TEXT_CANCELLED", this.f20745e, b.a.UI_BUS);
        b.b("SEARCH_TEXT_DONE", this.f20746f, b.a.UI_BUS);
    }
}
