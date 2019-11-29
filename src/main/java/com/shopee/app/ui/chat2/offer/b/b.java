package com.shopee.app.ui.chat2.offer.b;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;
import java.util.List;

public final class b implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f20616a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20617b = new g() {
        public void onEvent(a aVar) {
            b.this.f20616a.a((Pair<Integer, List<ItemDetail>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final f f20618c = new f() {
        public void a(a aVar) {
            b.this.f20616a.e();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20619d = new g() {
        public void onEvent(a aVar) {
            b.this.f20616a.a(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final f f20620e = new f() {
        public void a(a aVar) {
            b.this.f20616a.f();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public b(a aVar) {
        this.f20616a = aVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("ITEM_BY_SHOP_LIST_LOCAL_LOAD", (e) this.f20617b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_GET_RECENT_ITEMS_SUCCESS", (e) this.f20618c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ITEM_BY_SHOP_LIST_SAVED", (e) this.f20619d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("BATCH_ITEM_LOAD", (e) this.f20620e, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("ITEM_BY_SHOP_LIST_LOCAL_LOAD", this.f20617b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_GET_RECENT_ITEMS_SUCCESS", this.f20618c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ITEM_BY_SHOP_LIST_SAVED", this.f20619d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("BATCH_ITEM_LOAD", this.f20620e, b.a.NETWORK_BUS);
    }
}
