package com.shopee.app.ui.home.me.v3;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.h.c.d;
import com.shopee.protocol.shop.Wallet;

public final class i implements com.garena.android.appkit.b.i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final h f22651a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22652b = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f22653c = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.g();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f22654d = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((Pair<Integer, Wallet>) (Pair) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f22655e = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.h();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f22656f = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((SellerOrderCountItem) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f22657g = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((d) aVar);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((UserInfo) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((com.shopee.app.ui.auth.a.a) aVar);
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((MeTabNoticeItem) aVar.data);
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.b((MeTabNoticeItem) aVar.data);
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.c((MeTabNoticeItem) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.i();
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.j();
        }
    };
    private final g o = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((String) aVar.data);
        }
    };
    private final g p = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g q = new g() {
        public void onEvent(a aVar) {
            i.this.f22651a.k();
        }
    };

    public i(h hVar) {
        this.f22651a = hVar;
    }

    public void a() {
        b.a("SHOP_INFO_LOCAL_LOAD", (e) this.f22652b, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED", (e) this.f22652b, b.a.NETWORK_BUS);
        b.a("WALLET_TOPUP_COMPLETED", (e) this.f22653c, b.a.NETWORK_BUS);
        b.a("CMD_GET_WALLET_SUCCESS", (e) this.f22654d, b.a.NETWORK_BUS);
        b.a("ADD_ITEM_RESULT_SUCCESS", (e) this.f22655e, b.a.NETWORK_BUS);
        b.a("EDIT_ITEM_SUCCESS", (e) this.f22655e, b.a.NETWORK_BUS);
        b.a("ITEM_DELETE", (e) this.f22655e, b.a.NETWORK_BUS);
        b.a("GET_SELLER_ORDER_COUNT_INFO", (e) this.f22656f, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO", (e) this.f22657g, b.a.NETWORK_BUS);
        b.a("EMAIL_VERIFIED", (e) this.h, b.a.NETWORK_BUS);
        b.a("UNBIND_ACCOUNT_SUCCESS", (e) this.h, b.a.NETWORK_BUS);
        b.a("BIND_ACCOUNT_SUCCESS", (e) this.i, b.a.NETWORK_BUS);
        b.a("ON_ME_TAB_NOTICE_DATA", (e) this.j, b.a.NETWORK_BUS);
        b.a("RN_FEATURE_CONFIG_UPDATE", (e) this.m, b.a.NETWORK_BUS);
        b.a("SEND_V_MAIL_SUCCESS", (e) this.o, b.a.NETWORK_BUS);
        b.a("SEND_V_MAIL_FAIL", (e) this.p, b.a.NETWORK_BUS);
        b.a("ME_SELLER_FEATURE_CHANGED", (e) this.q, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("SHOP_INFO_LOCAL_LOAD", this.f22652b, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_FETCHED", this.f22652b, b.a.NETWORK_BUS);
        b.b("WALLET_TOPUP_COMPLETED", this.f22653c, b.a.NETWORK_BUS);
        b.b("CMD_GET_WALLET_SUCCESS", this.f22654d, b.a.NETWORK_BUS);
        b.b("ADD_ITEM_RESULT_SUCCESS", this.f22655e, b.a.NETWORK_BUS);
        b.b("EDIT_ITEM_SUCCESS", this.f22655e, b.a.NETWORK_BUS);
        b.b("ITEM_DELETE", this.f22655e, b.a.NETWORK_BUS);
        b.b("GET_SELLER_ORDER_COUNT_INFO", this.f22656f, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO", this.f22657g, b.a.NETWORK_BUS);
        b.b("EMAIL_VERIFIED", this.h, b.a.NETWORK_BUS);
        b.b("UNBIND_ACCOUNT_SUCCESS", this.h, b.a.NETWORK_BUS);
        b.b("BIND_ACCOUNT_SUCCESS", this.i, b.a.NETWORK_BUS);
        b.b("ON_ME_TAB_NOTICE_DATA", this.j, b.a.NETWORK_BUS);
        b.b("RN_FEATURE_CONFIG_UPDATE", this.m, b.a.NETWORK_BUS);
        b.b("SEND_V_MAIL_SUCCESS", this.o, b.a.NETWORK_BUS);
        b.b("SEND_V_MAIL_FAIL", this.p, b.a.NETWORK_BUS);
        b.b("ME_SELLER_FEATURE_CHANGED", this.q, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("ME_TAB_NOTICE_SET_NOW", (e) this.k, b.a.UI_BUS);
        b.a("ME_TAB_NOTICE_CLOSE", (e) this.l, b.a.UI_BUS);
        b.a("PRODUCT_UPLOAD_SUCCESS", (e) this.n, b.a.UI_BUS);
    }

    public void d() {
        b.b("ME_TAB_NOTICE_SET_NOW", this.k, b.a.UI_BUS);
        b.b("ME_TAB_NOTICE_CLOSE", this.l, b.a.UI_BUS);
        b.b("PRODUCT_UPLOAD_SUCCESS", this.n, b.a.UI_BUS);
    }
}
