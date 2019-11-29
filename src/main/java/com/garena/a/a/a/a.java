package com.garena.a.a.a;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.h;
import com.garena.android.appkit.b.j;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.af;
import com.shopee.app.d.c.aj;
import com.shopee.app.d.c.bm;
import com.shopee.app.d.c.bn;
import com.shopee.app.d.c.co;
import com.shopee.app.d.c.cu;
import com.shopee.app.d.c.da;
import com.shopee.app.d.c.i.a;
import com.shopee.app.d.c.u;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.data.viewmodel.GalleryAlbumInfo;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.data.viewmodel.ToolTipHomeViewItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.data.viewmodel.chatP2P.VMOfferHistory;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.h.c.d;
import com.shopee.app.ui.chat2.s;
import com.shopee.app.ui.home.me.editprofile.e;
import com.shopee.app.ui.order.search.f;
import com.shopee.app.ui.product.add.af;
import com.shopee.app.ui.product.add.t;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.attributes.v;
import com.shopee.app.ui.product.rating.b;
import com.shopee.app.upload.ProgressState;
import com.shopee.app.upload.VideoState;
import com.shopee.app.web.protocol.AddCartMessage;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.shop.Wallet;
import java.util.List;

public final class a {
    private static a dp;
    public final h<Integer> A = new h() {
        public void a() {
            b.a("FEED_COMMENT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ResponseCommon> B = new h() {
        public void a() {
            b.a("LINE_LOGIN_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j C = new j() {
        public void a() {
            b.a("COVER_SELECTED_FAIL", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j D = new j() {
        public void a() {
            b.a("ME_BUYER_FEATURE_CHANGED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> E = new h() {
        public void a() {
            b.a("COMMENT_LIST_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<MeTabNoticeItem> F = new h() {
        public void a() {
            b.a("ON_ME_TAB_NOTICE_DATA", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> G = new h() {
        public void a() {
            b.a("CANCEL_CHECKOUT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> H = new h() {
        public void a() {
            b.a("CMD_CLEAR_CHAT_MSG_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> I = new h() {
        public void a() {
            b.a("ORDER_RATE_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<cu.c> J = new h() {
        public void a() {
            b.a("ON_IMAGE_SEARCH_PREPARE_PROGRESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<UserInfo> K = new h() {
        public void a() {
            b.a("EMAIL_VERIFIED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> L = new h() {
        public void a() {
            b.a("FACEBOOK_LOGIN_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> M = new h() {
        public void a() {
            b.a("CHAT_DELETE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j N = new j() {
        public void a() {
            b.a("USER_BRIEF_LOAD", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<co.a> O = new h() {
        public void a() {
            b.a("CHAT_MESSAGE_POST_PROCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> P = new h() {
        public void a() {
            b.a("PHONE_VERIFY_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, Wallet>> Q = new h() {
        public void a() {
            b.a("CMD_GET_WALLET_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<com.shopee.app.network.d.d.a.a, List<Pair<Integer, Long>>>> R = new h() {
        public void a() {
            b.a("ON_SEARCH_PRODUCT_IN_SHOP_RESULT", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j S = new j() {
        public void a() {
            b.a("WALLET_TOPUP_COMPLETED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<f>> T = new h() {
        public void a() {
            b.a("CMD_GET_SEARCH_CUSTOMER_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<UserData>> U = new h() {
        public void a() {
            b.a("GET_USER_INFO_LOAD_LIST", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> V = new h() {
        public void a() {
            b.a("CHAT_MSG_RESEND", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> W = new h() {
        public void a() {
            b.a("GET_SHOP_UPDATES_NOTIFICATION_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j X = new j() {
        public void a() {
            b.a("EDIT_ITEM_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j Y = new j() {
        public void a() {
            b.a("FEED_COMMENT_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<ResponseCommon> Z = new h() {
        public void a() {
            b.a("ACCOUNT_FOUND_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final h<ProgressState> f7290a = new h() {
        public void a() {
            b.a("ITEM_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aA = new j() {
        public void a() {
            b.a("CHECKOUT_LIST_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<VideoState> aB = new h() {
        public void a() {
            b.a("VIDEO_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ItemDetail>>> aC = new h() {
        public void a() {
            b.a("ITEM_BY_ID_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> aD = new h() {
        public void a() {
            b.a("ITEM_BY_SHOP_LIST_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aE = new j() {
        public void a() {
            b.a("RN_FEATURE_CONFIG_UPDATE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<UserData>> aF = new h() {
        public void a() {
            b.a("GET_USER_INFO_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<u> aG = new h() {
        public void a() {
            b.a("ON_ATTRIBUTE_SELECTED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> aH = new h() {
        public void a() {
            b.a("CMD_GET_ATTRIBUTE_MODEL_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<UserData> aI = new h() {
        public void a() {
            b.a("GET_USER_INFO_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> aJ = new h() {
        public void a() {
            b.a("ACCOUNT_FOUND_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<af> aK = new h() {
        public void a() {
            b.a("CMD_MATCH_ATTRIBUTE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> aL = new h() {
        public void a() {
            b.a("REGISTER_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<GalleryAlbumInfo>> aM = new h() {
        public void a() {
            b.a("VIDEO_GALLERY_ALBUM_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> aN = new h() {
        public void a() {
            b.a("CHAT_LOCAL_SEND", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ToolTipHomeViewItem> aO = new h() {
        public void a() {
            b.a("TOOL_TIP_HOME_VIEW", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aP = new j() {
        public void a() {
            b.a("ME_SELLER_FEATURE_CHANGED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<ShopDetail> aQ = new h() {
        public void a() {
            b.a("SHOP_INFO_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Boolean, Boolean>> aR = new h() {
        public void a() {
            b.a("WEB_IMAGE_SAVE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> aS = new h() {
        public void a() {
            b.a("ADD_CART_ITEM_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> aT = new h() {
        public void a() {
            b.a("ACTION_REMOVE_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aU = new j() {
        public void a() {
            b.a("FOLLOW_USER_REFRESH", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> aV = new h() {
        public void a() {
            b.a("ITEM_DETAIL_LOAD_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<f>> aW = new h() {
        public void a() {
            b.a("CMD_GET_LOAD_CUSTOMER_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aX = new j() {
        public void a() {
            b.a("LOGIN_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> aY = new h() {
        public void a() {
            b.a("GET_CONTACT_INTERACTOR_DONE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j aZ = new j() {
        public void a() {
            b.a("CMD_GET_OFFER_COUNT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<String> aa = new h() {
        public void a() {
            b.a("ACTIVITY_REMOVE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> ab = new h() {
        public void a() {
            b.a("FOLLOW_ALL_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ac = new j() {
        public void a() {
            b.a("COMMENT_LIST_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ItemDetail>>> ad = new h() {
        public void a() {
            b.a("ITEM_BY_TYPE_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<UserInfo> ae = new h() {
        public void a() {
            b.a("UNBIND_ACCOUNT_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<u> af = new h() {
        public void a() {
            b.a("ON_ATTRIBUTE_AUTO_SELECTED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> ag = new h() {
        public void a() {
            b.a("UPDATE_SHOP_INFO_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> ah = new h() {
        public void a() {
            b.a("SEND_V_MAIL_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> ai = new h() {
        public void a() {
            b.a("ON_CAPTCHA_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<ItemCommentInfo>> aj = new h() {
        public void a() {
            b.a("ITEM_IMAGE_RATING_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ak = new j() {
        public void a() {
            b.a("ITEM_SNAPSHOT_LOAD", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Long, Integer>> al = new h() {
        public void a() {
            b.a("NEW_ACTION_ARRIVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j am = new j() {
        public void a() {
            b.a("CMD_GET_OFFER_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> an = new h() {
        public void a() {
            b.a("ORDER_LIST_FOR_USER_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ao = new j() {
        public void a() {
            b.a("ADD_FEED_COMMENT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<s.a> ap = new h() {
        public void a() {
            b.a("GET_MESSAGE_SHORTCUTS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.h.c.b> aq = new h() {
        public void a() {
            b.a("FB_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ar = new j() {
        public void a() {
            b.a("CMD_GET_SUBCATEGORY_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<VMItemAttribute>> as = new h() {
        public void a() {
            b.a("GET_LOCAL_ATTRIBUTES_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> at = new h() {
        public void a() {
            b.a("CMD_GET_OFFER_LIST_SUCCUSS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> au = new h() {
        public void a() {
            b.a("SET_USER_INFO_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> av = new h() {
        public void a() {
            b.a("ON_CAPTCHA_VERIFY", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> aw = new h() {
        public void a() {
            b.a("CMD_GET_CHAT_ITEMS_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ShopBalance> ax = new h() {
        public void a() {
            b.a("SHOP_BALANCE_GET", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ay = new j() {
        public void a() {
            b.a("CHAT_MARKED_UNREAD", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<VideoState> az = new h() {
        public void a() {
            b.a("VIDEO_UPLOAD_PROGRESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final j f7291b = new j() {
        public void a() {
            b.a("CMD_GET_RECENT_ITEMS_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bA = new h() {
        public void a() {
            b.a("ADD_ITEM_RESULT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<u> bB = new h() {
        public void a() {
            b.a("ON_ATTRIBUTE_SELF_DEFINED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<StickerPack>> bC = new h() {
        public void a() {
            b.a("GET_STICKER_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bD = new h() {
        public void a() {
            b.a("CMD_GET_PCHATLIST_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> bE = new h() {
        public void a() {
            b.a("OTP_RECEIVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bF = new j() {
        public void a() {
            b.a("LINE_LOGIN_REGISTER", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bG = new h() {
        public void a() {
            b.a("CHAT_BADGE_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bH = new h() {
        public void a() {
            b.a("CHAT_BADGE_UPDATE2", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ActionBarTheme> bI = new h() {
        public void a() {
            b.a("ACTION_BAR_THEME_CHANGED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bJ = new j() {
        public void a() {
            b.a("OFFER_CHANGED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bK = new h() {
        public void a() {
            b.a("CHECK_PASSWORD_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<UserInfo> bL = new h() {
        public void a() {
            b.a("LOGIN_USER_INFO_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bM = new h() {
        public void a() {
            b.a("CMD_CHAT_BLOCK_USER_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bN = new h() {
        public void a() {
            b.a("ORDER_LIST_FOR_SHOP_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bO = new h() {
        public void a() {
            b.a("OFFER_ACTION_FAILED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<bn.b> bP = new h() {
        public void a() {
            b.a("ACTION_PROBE_CONTENT_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bQ = new h() {
        public void a() {
            b.a("RESET_PASSWORD_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> bR = new h() {
        public void a() {
            b.a("SEND_V_MAIL_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, Integer>> bS = new h() {
        public void a() {
            b.a("IS_USER_BLOCKED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<b.C0380b> bT = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_IMAGE_RATING_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bU = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_CLEAR_CHAT_MSG_SUCCUSS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j bV = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_NEW_LISTING_VALIDATOR_CONFIG", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<TransactionItem>>> bW = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("TRANSACTION_HISTORY_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<List<ActionContentInfo>, u.a>> bX = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_CONTENT_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> bY = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CATEGORY_NAME_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<MeCounter> bZ = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ME_TAB_BADGE_UPDATE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<UserData>> ba = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_CHAT_SEARCH_DATA_READY", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<bm.b> bb = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ORDER_LIST_FOR_XX_LOCAL_LOAD_PROBE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bc = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("NEW_LOGIN", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j bd = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("APP_UPGRADE_XIAOMI_POPUP", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> be = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("LINE_LOGIN_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ItemDetail>>> bf = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_BY_SHOP_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bg = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("BIND_ACCOUNT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bh = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_BY_TYPE_LIST_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bi = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_ITEM_COMMENT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<ChatItem2>> bj = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_UNREAD_LIST_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<af.b> bk = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MESSAGE_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> bl = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_FEED_COMMENT_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<List<ActionContentInfo>, Long>> bm = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHILD_ACTION_CONTENT_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ActivityCounter> bn = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_BADGE_UPDATE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ProgressState> bo = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_UPLOAD_PROGRESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ItemDetail> bp = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_DETAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.ui.auth.a.a> bq = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("BIND_ACCOUNT_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<t>> br = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("FACEBOOK_PAGE_OBTAINED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> bs = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("COVER_SELECTED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Long, Integer>> bt = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_LIST_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bu = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("FEED_ON_NEW_RED_DOT", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<FeedCommentInfo>> bv = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("FEED_COMMENT_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bw = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("NOTIFY_SIBLINGS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> bx = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_SEARCH_CUSTOMER_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> by = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SEND_V_CODE_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j bz = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_SET_CHAT_LAST_READ_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public final j f7292c = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_COIN_ERROR", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<UserData> cA = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("USER_INFO_UPDATED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<cu.c> cB = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_IMAGE_SEARCH_PREPARE_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ShopDetail> cC = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SHOP_INFO_FETCHED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cD = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("DEL_ITEM_COMMENT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> cE = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_ITEM_RESULT_INVALIDATE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<DBBlockUser> cF = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_CHAT_BLOCK_USER_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<VideoState> cG = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("VIDEO_TRIM_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<String> cH = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_YOUTUBE_INFO_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<ChatItem2>> cI = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SEARCH_CHAT_LOCAL_RESULT", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<BuyerOrderCountItem> cJ = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_BUYER_ORDER_COUNT_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cK = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("UPDATE_SHOP_INFO", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<String> cL = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("AVATAR_SELECTED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<AddCartMessage> cM = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_CART_ITEM_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cN = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_DELETE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cO = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_LIST_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<com.shopee.app.instagram.h>> cP = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("INSTAGRAM_IMAGE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<v>> cQ = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("LOCAL_ATTRIBUTE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cR = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_REMOVED_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cS = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_USER_INFO_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> cT = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_SEND_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<String, Boolean>> cU = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SEND_V_CODE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Long> cV = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHILD_ACTION_LIST_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> cW = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_ITEM_COMMENT_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> cX = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MSG_DELETE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cY = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ORDER_IN_BATCH_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.b<Integer>> cZ = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_CONTACT_INTERACTOR_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j ca = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_SET_CHAT_QUICKREPLY_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, Long>> cb = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("TRANSACTION_HISTORY_SAVED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cc = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("RESPONSE_CONTACT_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ProgressState> cd = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_UPLOAD_END", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<d> ce = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SET_USER_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ProgressState> cf = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_UPLOAD_FAILED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cg = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("RARING_STATUS_CHANGE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<SellerOrderCountItem> ch = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_SELLER_ORDER_COUNT_INFO", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, Pair<Integer, Integer>>> ci = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("LAST_SEEN_SYNCED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cj = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("SHOP_INFO_FETCHED_FAIL", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<ShopBalance, Integer>> ck = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("AMOUNT_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cl = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_COIN_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> cm = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("DEL_ITEM_COMMENT_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: cn  reason: collision with root package name */
    public final h<cu.c> f7293cn = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_IMAGE_SEARCH_PREPARE_DONE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<e> co = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.b<Integer>> cp = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("RESPONSE_CONTACT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ItemDetail> cq = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_DETAIL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cr = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_VIDEO_SELECTED_FAIL", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cs = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("MISS_ORDER_FETCHED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ProgressState> ct = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_UPLOAD_START", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cu = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("BATCH_ITEM_LOAD", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<String> cv = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("YOUTUBE_VIDEO_ADDED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> cw = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_SET_CHAT_QUICKREPLY_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j cx = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j cy = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_CHECK_USER_BLOCKED_SUCCUSS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, Integer>> cz = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_GROUP_BUY_ORDER_COUNT", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public final h<com.shopee.app.network.c.d.a> f7294d = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_REMOVE_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j da = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("REACT_ME_FEEDS_PAGE_UPDATE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> db = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("FOLLOW_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j dc = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_CHAT_ITEMS_SUCCUSS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Long> dd = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_REMOVE_SUCCESS", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> de = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ITEM_DELETE_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j df = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("AVATAR_SELECTED_FAIL", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<String, List<UserBriefInfo>>> dg = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("SEARCH_USER_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<Object>> dh = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED_NO_DATA", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<bm.b> di = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ORDER_LIST_FOR_XX_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<da.a> dj = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ON_VIDEO_SELECTED", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j dk = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MESSAGES_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final j dl = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("OFFERS_IN_CART_SAVED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ItemDetail>>> dm = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_ITEM_BY_USER_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j dn = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("LANG_SELECTION_PROCESSED", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: do  reason: not valid java name */
    public final h<com.shopee.app.network.c.d.a> f343do = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("UNBIND_ACCOUNT_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public final h<aj.b> f7295e = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("COMMENT_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public final h<List<ActivityItemInfo>> f7296f = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_LIST_LOCAL_PROBE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public final h<Pair<Integer, List<VMOfferHistory>>> f7297g = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GET_OFFER_LIST_BY_USER_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<UserBriefInfo>> h = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("BLOCKED_USER_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j i = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("REACT_PAGE_DID_MOUNT", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<a.C0257a> j = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("NOTIFICATION_SOUND_SETTING", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ItemDetail>>> k = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("BUY_ITEM_BY_SHOP_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j l = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ADD_ITEM_RESULT_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> m = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_ATTRIBUTE_MODEL_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<List<ChatItem2>> n = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j o = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_CONTENT_SAVE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<List<GalleryAlbumInfo>> p = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("GALLERY_ALBUM_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ChatMessage> q = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("CHAT_MESSAGE_ARRIVED_DATA", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Long> r = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_CHILD_CONTENT_SAVE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Pair<Integer, List<ActivityItemInfo>>> s = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTIVITY_LIST_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> t = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("LOGIN_FAIL", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<ActionRequiredCounter> u = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ACTION_REQUIRED_BADGE_UPDATE", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j v = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_BLOCK_USER_LIST_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<com.shopee.app.network.c.d.a> w = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("ORDER_UPDATE_ERROR", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final h<Integer> x = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("OFFER_ACTION_ON_VACATION", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };
    public final j y = new j() {
        public void a() {
            com.garena.android.appkit.b.b.a("CMD_GET_CHAT_QUICKREPLY_SUCCESS", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
        }
    };
    public final h<VMOffer> z = new h() {
        public void a() {
            com.garena.android.appkit.b.b.a("P2P_OFFER_LOCAL_LOAD", new com.garena.android.appkit.b.a(this.f7628b), b.a.NETWORK_BUS);
        }
    };

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (dp == null) {
                dp = new a();
            }
            aVar = dp;
        }
        return aVar;
    }
}
