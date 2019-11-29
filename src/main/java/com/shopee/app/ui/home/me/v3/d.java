package com.shopee.app.ui.home.me.v3;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.protocol.shop.Wallet;

public final class d implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f22505a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22506b = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.g();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final g f22507c = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.h();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final g f22508d = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((UserInfo) aVar.data);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final g f22509e = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((com.shopee.app.ui.auth.a.a) aVar);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final g f22510f = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((ShopDetail) aVar.data);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final g f22511g = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((com.shopee.app.h.c.d) aVar);
        }
    };
    private final g h = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((MeTabNoticeItem) aVar.data);
        }
    };
    private final g i = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.b((MeTabNoticeItem) aVar.data);
        }
    };
    private final g j = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.i();
        }
    };
    private final g k = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.j();
        }
    };
    private final g l = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((Pair<Integer, Wallet>) (Pair) aVar.data);
        }
    };
    private final g m = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.c((MeTabNoticeItem) aVar.data);
        }
    };
    private final g n = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((String) aVar.data);
        }
    };
    private final g o = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((com.shopee.app.network.c.d.a) aVar.data);
        }
    };
    private final g p = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a(((Integer) aVar.data).intValue());
        }
    };
    private final g q = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((MeCounter) aVar.data);
        }
    };
    private final g r = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.k();
        }
    };
    private final g s = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.l();
        }
    };
    private final g t = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((ShareMessage) aVar.data);
        }
    };
    private final g u = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((BuyerOrderCountItem) aVar.data);
        }
    };
    private final g v = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.b((Pair<Integer, Integer>) (Pair) aVar.data);
        }
    };
    private final g w = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.m();
        }
    };
    private final g x = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.n();
        }
    };
    private final g y = new g() {
        public void onEvent(a aVar) {
            d.this.f22505a.a((ActionBarTheme) aVar.data);
        }
    };

    public d(c cVar) {
        this.f22505a = cVar;
    }

    public void a() {
        b.a("LOGIN_SUCCESS", (e) this.f22507c, b.a.NETWORK_BUS);
        b.a("FOLLOW_USER_REFRESH", (e) this.f22507c, b.a.NETWORK_BUS);
        b.a("UPDATE_SHOP_INFO", (e) this.f22507c, b.a.NETWORK_BUS);
        b.a("EMAIL_VERIFIED", (e) this.f22508d, b.a.NETWORK_BUS);
        b.a("UNBIND_ACCOUNT_SUCCESS", (e) this.f22508d, b.a.NETWORK_BUS);
        b.a("BIND_ACCOUNT_SUCCESS", (e) this.f22509e, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_LOCAL_LOAD", (e) this.f22510f, b.a.NETWORK_BUS);
        b.a("SHOP_INFO_FETCHED", (e) this.f22510f, b.a.NETWORK_BUS);
        b.a("SET_USER_INFO", (e) this.f22511g, b.a.NETWORK_BUS);
        b.a("CMD_GET_COIN_SUCCESS", (e) this.j, b.a.NETWORK_BUS);
        b.a("CMD_GET_COIN_ERROR", (e) this.k, b.a.NETWORK_BUS);
        b.a("CMD_GET_WALLET_SUCCESS", (e) this.l, b.a.NETWORK_BUS);
        b.a("ON_ME_TAB_NOTICE_DATA", (e) this.m, b.a.NETWORK_BUS);
        b.a("SEND_V_MAIL_SUCCESS", (e) this.n, b.a.NETWORK_BUS);
        b.a("SEND_V_MAIL_FAIL", (e) this.o, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_LOAD", (e) this.p, b.a.NETWORK_BUS);
        b.a("CHAT_BADGE_UPDATE2", (e) this.p, b.a.NETWORK_BUS);
        b.a("ME_TAB_BADGE_UPDATE", (e) this.q, b.a.NETWORK_BUS);
        b.a("GET_BUYER_ORDER_COUNT_INFO", (e) this.u, b.a.NETWORK_BUS);
        b.a("GET_GROUP_BUY_ORDER_COUNT", (e) this.v, b.a.NETWORK_BUS);
        b.a("RN_FEATURE_CONFIG_UPDATE", (e) this.w, b.a.NETWORK_BUS);
        b.a("ME_BUYER_FEATURE_CHANGED", (e) this.x, b.a.NETWORK_BUS);
        b.a("ACTION_BAR_THEME_CHANGED", (e) this.y, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("LOGIN_SUCCESS", this.f22507c, b.a.NETWORK_BUS);
        b.b("FOLLOW_USER_REFRESH", this.f22507c, b.a.NETWORK_BUS);
        b.b("UPDATE_SHOP_INFO", this.f22507c, b.a.NETWORK_BUS);
        b.b("EMAIL_VERIFIED", this.f22508d, b.a.NETWORK_BUS);
        b.b("UNBIND_ACCOUNT_SUCCESS", this.f22508d, b.a.NETWORK_BUS);
        b.b("BIND_ACCOUNT_SUCCESS", this.f22509e, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_LOCAL_LOAD", this.f22510f, b.a.NETWORK_BUS);
        b.b("SHOP_INFO_FETCHED", this.f22510f, b.a.NETWORK_BUS);
        b.b("SET_USER_INFO", this.f22511g, b.a.NETWORK_BUS);
        b.b("CMD_GET_COIN_SUCCESS", this.j, b.a.NETWORK_BUS);
        b.b("CMD_GET_COIN_ERROR", this.k, b.a.NETWORK_BUS);
        b.b("CMD_GET_WALLET_SUCCESS", this.l, b.a.NETWORK_BUS);
        b.b("ON_ME_TAB_NOTICE_DATA", this.m, b.a.NETWORK_BUS);
        b.b("SEND_V_MAIL_SUCCESS", this.n, b.a.NETWORK_BUS);
        b.b("SEND_V_MAIL_FAIL", this.o, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_LOAD", this.p, b.a.NETWORK_BUS);
        b.b("CHAT_BADGE_UPDATE2", this.p, b.a.NETWORK_BUS);
        b.b("ME_TAB_BADGE_UPDATE", this.q, b.a.NETWORK_BUS);
        b.b("GET_BUYER_ORDER_COUNT_INFO", this.u, b.a.NETWORK_BUS);
        b.b("GET_GROUP_BUY_ORDER_COUNT", this.v, b.a.NETWORK_BUS);
        b.b("RN_FEATURE_CONFIG_UPDATE", this.w, b.a.NETWORK_BUS);
        b.b("ME_BUYER_FEATURE_CHANGED", this.x, b.a.NETWORK_BUS);
        b.b("ACTION_BAR_THEME_CHANGED", this.y, b.a.NETWORK_BUS);
    }

    public void c() {
        b.a("WALLET_TOPUP_COMPLETED", (e) this.f22506b, b.a.UI_BUS);
        b.a("ME_TAB_NOTICE_SET_NOW", (e) this.h, b.a.UI_BUS);
        b.a("ME_TAB_NOTICE_CLOSE", (e) this.i, b.a.UI_BUS);
        b.a("PROCESSING_IMAGE", (e) this.r, b.a.UI_BUS);
        b.a("PROCESSING_IMAGE_DONE", (e) this.s, b.a.UI_BUS);
        b.a("FACEBOOK_SHARING_FB", (e) this.t, b.a.UI_BUS);
    }

    public void d() {
        b.b("WALLET_TOPUP_COMPLETED", this.f22506b, b.a.UI_BUS);
        b.b("ME_TAB_NOTICE_SET_NOW", this.h, b.a.UI_BUS);
        b.b("ME_TAB_NOTICE_CLOSE", this.i, b.a.UI_BUS);
        b.b("PROCESSING_IMAGE", this.r, b.a.UI_BUS);
        b.b("PROCESSING_IMAGE_DONE", this.s, b.a.UI_BUS);
        b.b("FACEBOOK_SHARING_FB", this.t, b.a.UI_BUS);
    }
}
