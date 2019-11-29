package com.shopee.app.ui.chat2;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.garena.sticker.e.b;
import com.shopee.app.d.c.af;
import com.shopee.app.d.c.bm;
import com.shopee.app.d.c.co;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.ui.chat2.s;
import com.shopee.app.web.protocol.AddCartMessage;
import java.util.List;

public final class k implements i {
    private final g A = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((DBBlockUser) aVar.data);
        }
    };
    private final g B = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g C = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((Pair<Integer, Integer>) (Pair) aVar.data);
        }
    };
    private final g D = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((Pair<Integer, Pair<Integer, Integer>>) (Pair) aVar.data);
        }
    };
    private final g E = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a(((Boolean) aVar.data).booleanValue());
        }
    };
    private final g F = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.c((Pair) aVar.data);
        }
    };
    private final g G = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.d((Pair<Integer, Float>) (Pair) aVar.data);
        }
    };
    private final g H = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.e((ChatMessage) aVar.data);
        }
    };
    private final g I = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.f((ChatMessage) aVar.data);
        }
    };
    private final g J = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((b) aVar.data);
        }
    };
    private final g K = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((String) aVar.data);
        }
    };
    private final g L = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.w();
        }
    };
    private final g M = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((ItemDetail) aVar.data);
        }
    };
    private final g N = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((OrderDetail) aVar.data);
        }
    };
    private final g O = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.x();
        }
    };
    private final g P = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.y();
        }
    };
    private final g Q = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.z();
        }
    };
    private final g R = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.A();
        }
    };
    private final g S = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((ItemDetail) aVar.data);
        }
    };
    private final g T = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((q) aVar.data);
        }
    };
    private final g U = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a(((Long) aVar.data).longValue());
        }
    };
    private final g V = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((AddCartMessage) aVar.data);
        }
    };
    private final g W = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g X = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.e((Pair<ItemDetail, VMOffer>) (Pair) aVar.data);
        }
    };
    private final g Y = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.f((Pair<ItemDetail, VMOffer>) (Pair) aVar.data);
        }
    };
    private final g Z = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((q) aVar.data);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final j f20463a;
    private final g aa = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.B();
        }
    };
    private final g ab = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.c((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g ac = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a(((Integer) aVar.data).intValue());
        }
    };
    private final g ad = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b(((Integer) aVar.data).intValue());
        }
    };
    private final g ae = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.c(((Integer) aVar.data).intValue());
        }
    };
    private final g af = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((bm.b) aVar.data);
        }
    };
    private final g ag = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((s.a) aVar.data);
        }
    };
    private final g ah = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.E();
        }
    };
    private final g ai = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.e((List<StickerPack>) (List) aVar.data);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final g f20464b = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.i();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f20465c = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f20466d = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((UserData) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f20467e = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((List<UserData>) (List) aVar.data);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f20468f = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.j();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f20469g = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.k();
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.l();
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.m();
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.n();
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.o();
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((String) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((ChatMessage) aVar.data);
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((ChatMessage) aVar.data);
        }
    };
    private final g o = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.c((ChatMessage) aVar.data);
        }
    };
    private final g p = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.d((ChatMessage) aVar.data);
        }
    };
    private final g q = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.b((List<Object>) (List) aVar.data);
        }
    };
    private final f r = new f() {
        public void a(a aVar) {
            k.this.f20463a.p();
        }
    };
    private final f s = new f() {
        public void a(a aVar) {
            k.this.f20463a.q();
        }
    };
    private final g t = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((af.b) aVar.data);
        }
    };
    private final g u = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.a((co.a) aVar.data);
        }
    };
    private final g v = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.r();
        }
    };
    private final f w = new f() {
        public void a(a aVar) {
            k.this.f20463a.s();
        }
    };
    private final f x = new f() {
        public void a(a aVar) {
            k.this.f20463a.t();
        }
    };
    private final g y = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.u();
        }
    };
    private final g z = new g() {
        public void onEvent(a aVar) {
            k.this.f20463a.v();
        }
    };

    public k(j jVar) {
        this.f20463a = jVar;
    }

    public void a() {
        com.garena.android.appkit.b.b.a("LOGIN_SUCCESS", (e) this.f20464b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("SHOP_INFO_FETCHED", (e) this.f20465c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_USER_INFO_LOCAL_LOAD", (e) this.f20466d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("USER_INFO_UPDATED", (e) this.f20466d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_USER_INFO_LOAD", (e) this.f20467e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_LOCAL_SEND", (e) this.m, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_SEND_SUCCESS", (e) this.n, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_DELETE_SUCCESS", (e) this.o, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED_DATA", (e) this.p, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED_NO_DATA", (e) this.q, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED", (e) this.r, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGES_SAVED", (e) this.s, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGE_LOAD", (e) this.t, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MESSAGE_POST_PROCESS", (e) this.u, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_GET_OFFER_SUCCESS", (e) this.v, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("BATCH_ITEM_LOAD", (e) this.w, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ORDER_IN_BATCH_SAVED", (e) this.x, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_CHECK_USER_BLOCKED_SUCCUSS", (e) this.z, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_CHAT_BLOCK_USER_SUCCESS", (e) this.A, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_CHAT_BLOCK_USER_ERROR", (e) this.B, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("IS_USER_BLOCKED", (e) this.C, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("LAST_SEEN_SYNCED", (e) this.D, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MSG_RESEND", (e) this.H, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CHAT_MSG_DELETE", (e) this.I, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ADD_CART_ITEM_SUCCESS", (e) this.V, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ADD_CART_ITEM_FAIL", (e) this.W, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("OFFER_CHANGED", (e) this.aa, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("OFFER_ACTION_FAILED", (e) this.ab, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("OFFER_ACTION_ON_VACATION", (e) this.ac, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ORDER_LIST_FOR_USER_SAVED", (e) this.ad, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ORDER_LIST_FOR_SHOP_SAVED", (e) this.ae, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("ORDER_LIST_FOR_XX_LOCAL_LOAD_PROBE", (e) this.af, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_MESSAGE_SHORTCUTS", (e) this.ag, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_GET_CHAT_QUICKREPLY_SUCCESS", (e) this.ah, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("CMD_SET_CHAT_QUICKREPLY_SUCCESS", (e) this.ah, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.a("GET_STICKER_INFO", (e) this.ai, b.a.NETWORK_BUS);
    }

    public void b() {
        com.garena.android.appkit.b.b.b("LOGIN_SUCCESS", this.f20464b, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("SHOP_INFO_FETCHED", this.f20465c, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_USER_INFO_LOCAL_LOAD", this.f20466d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("USER_INFO_UPDATED", this.f20466d, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_USER_INFO_LOAD", this.f20467e, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_LOCAL_SEND", this.m, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_SEND_SUCCESS", this.n, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_DELETE_SUCCESS", this.o, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGE_ARRIVED_DATA", this.p, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGE_ARRIVED_NO_DATA", this.q, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGE_ARRIVED", this.r, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGES_SAVED", this.s, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGE_LOAD", this.t, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MESSAGE_POST_PROCESS", this.u, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_GET_OFFER_SUCCESS", this.v, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("BATCH_ITEM_LOAD", this.w, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ORDER_IN_BATCH_SAVED", this.x, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_CHECK_USER_BLOCKED_SUCCUSS", this.z, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_CHAT_BLOCK_USER_SUCCESS", this.A, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_CHAT_BLOCK_USER_ERROR", this.B, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("IS_USER_BLOCKED", this.C, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("LAST_SEEN_SYNCED", this.D, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MSG_RESEND", this.H, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CHAT_MSG_DELETE", this.I, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ADD_CART_ITEM_SUCCESS", this.V, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ADD_CART_ITEM_FAIL", this.W, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("OFFER_CHANGED", this.aa, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("OFFER_ACTION_FAILED", this.ab, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("OFFER_ACTION_ON_VACATION", this.ac, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ORDER_LIST_FOR_USER_SAVED", this.ad, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ORDER_LIST_FOR_SHOP_SAVED", this.ae, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("ORDER_LIST_FOR_XX_LOCAL_LOAD_PROBE", this.af, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_MESSAGE_SHORTCUTS", this.ag, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_GET_CHAT_QUICKREPLY_SUCCESS", this.ah, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("CMD_SET_CHAT_QUICKREPLY_SUCCESS", this.ah, b.a.NETWORK_BUS);
        com.garena.android.appkit.b.b.b("GET_STICKER_INFO", this.ai, b.a.NETWORK_BUS);
    }

    public void c() {
        com.garena.android.appkit.b.b.a("CHAT_SEND_CLICK", (e) this.f20468f, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_HIDE_CHAT_PANEL", (e) this.f20469g, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("MORE_BTN", (e) this.h, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("STICKER_BTN", (e) this.i, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("PANEL_CLOSE", (e) this.j, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("SHOW_KEYBOARD", (e) this.k, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_SEND", (e) this.l, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_UNBLOCK_USER", (e) this.y, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("ON_SHOW", (e) this.E, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CLICK", (e) this.F, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_WEB_VIEW_RESIZED", (e) this.G, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("SEND_STICKER", (e) this.J, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("DOWNLOAD_PACK", (e) this.K, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_GOTO_CART", (e) this.L, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_SEND_PRODUCT", (e) this.M, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_SEND_ORDER", (e) this.N, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("OPTION_GOTO_PRODUCT_SELECTION", (e) this.O, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("OPTION_GOTO_ORDER_SELECTION", (e) this.P, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_OFFER", (e) this.Q, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_BUY", (e) this.R, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_BUY_NOW_ITEM", (e) this.S, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("BUY_NOW_ITEM_VIEW", (e) this.T, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_TRANSLATION_EXPAND_CLICK", (e) this.U, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_MAKE_OFFER_ITEM", (e) this.X, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("CHAT_OPTION_EDIT_OFFER_ITEM", (e) this.Y, b.a.UI_BUS);
        com.garena.android.appkit.b.b.a("MAKE_OFFER_ITEM_VIEW", (e) this.Z, b.a.UI_BUS);
    }

    public void d() {
        com.garena.android.appkit.b.b.b("CHAT_SEND_CLICK", this.f20468f, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_HIDE_CHAT_PANEL", this.f20469g, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("MORE_BTN", this.h, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("STICKER_BTN", this.i, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("PANEL_CLOSE", this.j, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("SHOW_KEYBOARD", this.k, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_SEND", this.l, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_UNBLOCK_USER", this.y, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("ON_SHOW", this.E, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CLICK", this.F, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_WEB_VIEW_RESIZED", this.G, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("SEND_STICKER", this.J, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("DOWNLOAD_PACK", this.K, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_GOTO_CART", this.L, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_SEND_PRODUCT", this.M, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_SEND_ORDER", this.N, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("OPTION_GOTO_PRODUCT_SELECTION", this.O, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("OPTION_GOTO_ORDER_SELECTION", this.P, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_OFFER", this.Q, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_BUY", this.R, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_BUY_NOW_ITEM", this.S, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("BUY_NOW_ITEM_VIEW", this.T, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_TRANSLATION_EXPAND_CLICK", this.U, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_MAKE_OFFER_ITEM", this.X, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("CHAT_OPTION_EDIT_OFFER_ITEM", this.Y, b.a.UI_BUS);
        com.garena.android.appkit.b.b.b("MAKE_OFFER_ITEM_VIEW", this.Z, b.a.UI_BUS);
    }
}
