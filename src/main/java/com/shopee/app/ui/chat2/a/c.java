package com.shopee.app.ui.chat2.a;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;

public final class c implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f20230a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20231b = new g() {
        public void onEvent(a aVar) {
            c.this.f20230a.a((ItemDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20232c = new g() {
        public void onEvent(a aVar) {
            c.this.f20230a.a((VMOffer) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final f f20233d = new f() {
        public void a(a aVar) {
            c.this.f20230a.e();
        }
    };

    public void c() {
    }

    public void d() {
    }

    public c(b bVar) {
        this.f20230a = bVar;
    }

    public void a() {
        b.a("ITEM_DETAIL_LOAD", (e) this.f20231b, b.a.NETWORK_BUS);
        b.a("ITEM_DETAIL_LOAD", (e) this.f20231b, b.a.NETWORK_BUS);
        b.a("P2P_OFFER_LOCAL_LOAD", (e) this.f20232c, b.a.NETWORK_BUS);
        b.a("CMD_GET_OFFER_SUCCESS", (e) this.f20233d, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("ITEM_DETAIL_LOAD", this.f20231b, b.a.NETWORK_BUS);
        b.b("ITEM_DETAIL_LOAD", this.f20231b, b.a.NETWORK_BUS);
        b.b("P2P_OFFER_LOCAL_LOAD", this.f20232c, b.a.NETWORK_BUS);
        b.b("CMD_GET_OFFER_SUCCESS", this.f20233d, b.a.NETWORK_BUS);
    }
}
