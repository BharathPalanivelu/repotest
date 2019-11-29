package com.garena.a.a.a;

import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.h;
import com.garena.android.appkit.b.j;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.ui.chat2.q;
import com.shopee.app.ui.common.a.c;
import com.shopee.app.ui.common.e;
import com.shopee.app.ui.product.add.t;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.app.web.protocol.ShareMessage;

public final class c {
    private static c ay;
    public final h<Boolean> A = new h() {
        public void a() {
            b.a("ME_TAB_FEED_TAB_SHOW", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<MeTabNoticeItem> B = new h() {
        public void a() {
            b.a("ME_TAB_NOTICE_SET_NOW", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<q> C = new h() {
        public void a() {
            b.a("BUY_NOW_ITEM_VIEW", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Long> D = new h() {
        public void a() {
            b.a("CHAT_TRANSLATION_EXPAND_CLICK", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j E = new j() {
        public void a() {
            b.a("CHAT_GOTO_CART", new a(), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> F = new h() {
        public void a() {
            b.a("ORDER_BUYER_VIEW_SELLER_RATE_BUYER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Pair<String, String>> G = new h() {
        public void a() {
            b.a("MALL_TAB_REDIRECT_PARAM", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<t> H = new h() {
        public void a() {
            b.a("FACEBOOK_PAGE_SELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<String> I = new h() {
        public void a() {
            b.a("SEARCH_TEXT_DONE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<MeTabNoticeItem> J = new h() {
        public void a() {
            b.a("ME_TAB_NOTICE_CLOSE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Pair> K = new h() {
        public void a() {
            b.a("CLICK", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<c.b> L = new h() {
        public void a() {
            b.a("ON_ADD_CART_ANIMATION", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j M = new j() {
        public void a() {
            b.a("ACTION_BAR_DONE", new a(), b.a.UI_BUS);
        }
    };
    public final j N = new j() {
        public void a() {
            b.a("ON_HIDE_CHAT_PANEL", new a(), b.a.UI_BUS);
        }
    };
    public final h<u> O = new h() {
        public void a() {
            b.a("ON_SELF_DEFINE_CLICKED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<ItemDetail> P = new h() {
        public void a() {
            b.a("CHAT_OPTION_BUY_NOW_ITEM", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<u> Q = new h() {
        public void a() {
            b.a("ON_ATTRIBUTE_SELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j R = new j() {
        public void a() {
            b.a("CHAT_OPTION_OFFER", new a(), b.a.UI_BUS);
        }
    };
    public final h<Integer> S = new h() {
        public void a() {
            b.a("MENTION_CLICKED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j T = new j() {
        public void a() {
            b.a("PANEL_CLOSE", new a(), b.a.UI_BUS);
        }
    };
    public final h<Pair<ItemDetail, VMOffer>> U = new h() {
        public void a() {
            b.a("CHAT_OPTION_MAKE_OFFER_ITEM", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j V = new j() {
        public void a() {
            b.a("OPTION_GOTO_PRODUCT_SELECTION", new a(), b.a.UI_BUS);
        }
    };
    public final h<Pair<String, Integer>> W = new h() {
        public void a() {
            b.a("ITEM_COMMENT_REPLY", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<String> X = new h() {
        public void a() {
            b.a("GET_YOUTUBE_URL", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> Y = new h() {
        public void a() {
            b.a("ORDER_SELLER_VIEW_BUYER_RATE_SELLER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<AddCartMessage> Z = new h() {
        public void a() {
            b.a("ON_BUY_PANEL_SELECTION_DONE", new a(this.f7628b), b.a.UI_BUS);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final h<u> f7521a = new h() {
        public void a() {
            b.a("ON_ATTRIBUTE_AUTO_SELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> aa = new h() {
        public void a() {
            b.a("ORDER_SELLER_CHANGE_RATE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Boolean> ab = new h() {
        public void a() {
            b.a("ON_SHOW", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<q> ac = new h() {
        public void a() {
            b.a("MAKE_OFFER_ITEM_VIEW", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<UserBriefInfo> ad = new h() {
        public void a() {
            b.a("BLOCK_USER_CHAT", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j ae = new j() {
        public void a() {
            b.a("ON_ORDER_READ_ALL", new a(), b.a.UI_BUS);
        }
    };
    public final j af = new j() {
        public void a() {
            b.a("WALLET_TOPUP_COMPLETED", new a(), b.a.UI_BUS);
        }
    };
    public final j ag = new j() {
        public void a() {
            b.a("PRODUCT_UPLOAD_SUCCESS", new a(), b.a.UI_BUS);
        }
    };
    public final j ah = new j() {
        public void a() {
            b.a("SHOW_KEYBOARD", new a(), b.a.UI_BUS);
        }
    };
    public final j ai = new j() {
        public void a() {
            b.a("ACTION_BAR_CART_PRIMARY", new a(), b.a.UI_BUS);
        }
    };
    public final j aj = new j() {
        public void a() {
            b.a("OPTION_GOTO_ORDER_SELECTION", new a(), b.a.UI_BUS);
        }
    };
    public final h<String> ak = new h() {
        public void a() {
            b.a("SEARCH_TEXT_CHANGED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<u> al = new h() {
        public void a() {
            b.a("ON_SELF_DEFINE_ATTRIBUTE_SELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Integer> am = new h() {
        public void a() {
            b.a("SHOP_ASSISTANT_SELECT_EVENT", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<com.shopee.app.ui.income.h> an = new h() {
        public void a() {
            b.a("INCOME_TIME_FILTER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<com.shopee.app.ui.income.h> ao = new h() {
        public void a() {
            b.a("ON_WEEK_SELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<Pair<String, e[]>> ap = new h() {
        public void a() {
            b.a("SEND_TEXT_COMMENT", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> aq = new h() {
        public void a() {
            b.a("CHAT_OPTION_SEND_ORDER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<String> ar = new h() {
        public void a() {
            b.a("ON_SEND", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> as = new h() {
        public void a() {
            b.a("ORDER_SELLER_VIEW_RATE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j at = new j() {
        public void a() {
            b.a("CHAT_OPTION_BUY", new a(), b.a.UI_BUS);
        }
    };
    public final j au = new j() {
        public void a() {
            b.a("ON_UNBLOCK_USER", new a(), b.a.UI_BUS);
        }
    };
    public final h<com.shopee.app.ui.product.comment.b> av = new h() {
        public void a() {
            b.a("ITEM_COMMENT_DELETE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<VMOfferHistory> aw = new h() {
        public void a() {
            b.a("ACTION_MENU_REMIND_OFFER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j ax = new j() {
        public void a() {
            b.a("MORE_BTN", new a(), b.a.UI_BUS);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final h<Integer> f7522b = new h() {
        public void a() {
            b.a("TAB_RESELECTED", new a(this.f7628b), b.a.UI_BUS);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final h<ShareMessage> f7523c = new h() {
        public void a() {
            b.a("FACEBOOK_SHARING_FB", new a(this.f7628b), b.a.UI_BUS);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final h<Pair<ItemDetail, VMOffer>> f7524d = new h() {
        public void a() {
            b.a("CHAT_OPTION_EDIT_OFFER_ITEM", new a(this.f7628b), b.a.UI_BUS);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public final j f7525e = new j() {
        public void a() {
            b.a("ON_PRODUCT_CHECK_CHANGE", new a(), b.a.UI_BUS);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public final j f7526f = new j() {
        public void a() {
            b.a("GALLERY_ITEM_SELECTED", new a(), b.a.UI_BUS);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public final j f7527g = new j() {
        public void a() {
            b.a("STICKER_BTN", new a(), b.a.UI_BUS);
        }
    };
    public final j h = new j() {
        public void a() {
            b.a("ACTION_BAR_ACTION_BOX_PRIMARY", new a(), b.a.UI_BUS);
        }
    };
    public final j i = new j() {
        public void a() {
            b.a("ACTION_BAR_HOME_ACTION", new a(), b.a.UI_BUS);
        }
    };
    public final h<String> j = new h() {
        public void a() {
            b.a("INSTALL_REF_ARRIVED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<ItemDetail> k = new h() {
        public void a() {
            b.a("CHAT_OPTION_SEND_PRODUCT", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j l = new j() {
        public void a() {
            b.a("DISMISS_TOOL_TIP_SELL_TAB", new a(), b.a.UI_BUS);
        }
    };
    public final h<String> m = new h() {
        public void a() {
            b.a("DOWNLOAD_PACK", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j n = new j() {
        public void a() {
            b.a("CHAT_SEND_CLICK", new a(), b.a.UI_BUS);
        }
    };
    public final h<Pair<Integer, Float>> o = new h() {
        public void a() {
            b.a("CHAT_OPTION_WEB_VIEW_RESIZED", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j p = new j() {
        public void a() {
            b.a("SEARCH_TEXT_CANCELLED", new a(), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> q = new h() {
        public void a() {
            b.a("ORDER_BUYER_VIEW_RATE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final h<com.garena.sticker.e.b> r = new h() {
        public void a() {
            b.a("SEND_STICKER", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j s = new j() {
        public void a() {
            b.a("ME_TAB_SHOW", new a(), b.a.UI_BUS);
        }
    };
    public final j t = new j() {
        public void a() {
            b.a("SUBMIT_AUTO_REPLY", new a(), b.a.UI_BUS);
        }
    };
    public final j u = new j() {
        public void a() {
            b.a("RATING_FINISH", new a(), b.a.UI_BUS);
        }
    };
    public final j v = new j() {
        public void a() {
            b.a("DISMISS_TOOL_TIP_MALL", new a(), b.a.UI_BUS);
        }
    };
    public final h<OrderDetail> w = new h() {
        public void a() {
            b.a("ORDER_SELLER_RATE", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j x = new j() {
        public void a() {
            b.a("PROCESSING_IMAGE", new a(), b.a.UI_BUS);
        }
    };
    public final h<a> y = new h() {
        public void a() {
            b.a("configureParentTabs", new a(this.f7628b), b.a.UI_BUS);
        }
    };
    public final j z = new j() {
        public void a() {
            b.a("PROCESSING_IMAGE_DONE", new a(), b.a.UI_BUS);
        }
    };

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (ay == null) {
                ay = new c();
            }
            cVar = ay;
        }
        return cVar;
    }
}
