package com.shopee.app.ui.chat2.offer.a;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import java.util.List;

public final class f implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f20581a;

    /* renamed from: b  reason: collision with root package name */
    private final g f20582b = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.a((Pair<Integer, List<VMOfferHistory>>) (Pair) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20583c = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.b(((Integer) aVar.data).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final com.garena.android.appkit.b.f f20584d = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f20581a.e();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final com.garena.android.appkit.b.f f20585e = new com.garena.android.appkit.b.f() {
        public void a(a aVar) {
            f.this.f20581a.f();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20586f = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.a((ChatMessage) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20587g = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.b((Pair<ItemDetail, VMOffer>) (Pair) aVar.data);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.c((Pair) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            f.this.f20581a.a((VMOfferHistory) aVar.data);
        }
    };

    public f(e eVar) {
        this.f20581a = eVar;
    }

    public void a() {
        b.a("GET_OFFER_LIST_BY_USER_LOAD", (e) this.f20582b, b.a.NETWORK_BUS);
        b.a("CMD_GET_OFFER_LIST_SUCCUSS", (e) this.f20583c, b.a.NETWORK_BUS);
        b.a("BATCH_ITEM_LOAD", (e) this.f20584d, b.a.NETWORK_BUS);
        b.a("ITEM_SNAPSHOT_LOAD", (e) this.f20585e, b.a.NETWORK_BUS);
        b.a("CHAT_LOCAL_SEND", (e) this.f20586f, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("GET_OFFER_LIST_BY_USER_LOAD", this.f20582b, b.a.NETWORK_BUS);
        b.b("CMD_GET_OFFER_LIST_SUCCUSS", this.f20583c, b.a.NETWORK_BUS);
        b.b("BATCH_ITEM_LOAD", this.f20584d, b.a.NETWORK_BUS);
        b.b("ITEM_SNAPSHOT_LOAD", this.f20585e, b.a.NETWORK_BUS);
        b.b("CHAT_LOCAL_SEND", this.f20586f, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("CHAT_OPTION_MAKE_OFFER_ITEM", (e) this.f20587g, b.a.UI_BUS);
        b.a("CHAT_OPTION_EDIT_OFFER_ITEM", (e) this.h, b.a.UI_BUS);
        b.a("ACTION_MENU_REMIND_OFFER", (e) this.i, b.a.UI_BUS);
    }

    public void d() {
        b.b("CHAT_OPTION_MAKE_OFFER_ITEM", this.f20587g, b.a.UI_BUS);
        b.b("CHAT_OPTION_EDIT_OFFER_ITEM", this.h, b.a.UI_BUS);
        b.b("ACTION_MENU_REMIND_OFFER", this.i, b.a.UI_BUS);
    }
}
