package com.shopee.app.appuser;

import com.shopee.app.network.c.a.b;
import com.shopee.app.network.c.aa;
import com.shopee.app.network.c.ab;
import com.shopee.app.network.c.ac;
import com.shopee.app.network.c.ad;
import com.shopee.app.network.c.ae;
import com.shopee.app.network.c.af;
import com.shopee.app.network.c.ag;
import com.shopee.app.network.c.ah;
import com.shopee.app.network.c.ai;
import com.shopee.app.network.c.aj;
import com.shopee.app.network.c.ak;
import com.shopee.app.network.c.am;
import com.shopee.app.network.c.an;
import com.shopee.app.network.c.ao;
import com.shopee.app.network.c.ap;
import com.shopee.app.network.c.aq;
import com.shopee.app.network.c.ar;
import com.shopee.app.network.c.at;
import com.shopee.app.network.c.au;
import com.shopee.app.network.c.aw;
import com.shopee.app.network.c.ay;
import com.shopee.app.network.c.b.b;
import com.shopee.app.network.c.b.f;
import com.shopee.app.network.c.ba;
import com.shopee.app.network.c.bb;
import com.shopee.app.network.c.bd;
import com.shopee.app.network.c.be;
import com.shopee.app.network.c.bh;
import com.shopee.app.network.c.bk;
import com.shopee.app.network.c.bl;
import com.shopee.app.network.c.bm;
import com.shopee.app.network.c.bo;
import com.shopee.app.network.c.bp;
import com.shopee.app.network.c.c.a;
import com.shopee.app.network.c.c.b;
import com.shopee.app.network.c.c.c;
import com.shopee.app.network.c.c.d;
import com.shopee.app.network.c.d;
import com.shopee.app.network.c.e;
import com.shopee.app.network.c.f;
import com.shopee.app.network.c.f.a;
import com.shopee.app.network.c.f.b;
import com.shopee.app.network.c.g.a;
import com.shopee.app.network.c.g.b;
import com.shopee.app.network.c.h;
import com.shopee.app.network.c.h.b;
import com.shopee.app.network.c.h.f;
import com.shopee.app.network.c.h.g;
import com.shopee.app.network.c.h.i;
import com.shopee.app.network.c.i;
import com.shopee.app.network.c.i.a;
import com.shopee.app.network.c.i.a.a;
import com.shopee.app.network.c.i.ab;
import com.shopee.app.network.c.i.ac;
import com.shopee.app.network.c.i.b;
import com.shopee.app.network.c.i.b.h;
import com.shopee.app.network.c.i.h;
import com.shopee.app.network.c.i.i;
import com.shopee.app.network.c.i.k;
import com.shopee.app.network.c.i.l;
import com.shopee.app.network.c.i.p;
import com.shopee.app.network.c.i.r;
import com.shopee.app.network.c.i.u;
import com.shopee.app.network.c.j.a;
import com.shopee.app.network.c.j.c;
import com.shopee.app.network.c.j.d;
import com.shopee.app.network.c.k;
import com.shopee.app.network.c.k.f;
import com.shopee.app.network.c.k.i;
import com.shopee.app.network.c.k.j;
import com.shopee.app.network.c.k.l;
import com.shopee.app.network.c.k.m;
import com.shopee.app.network.c.k.n;
import com.shopee.app.network.c.k.o;
import com.shopee.app.network.c.l;
import com.shopee.app.network.c.l.a;
import com.shopee.app.network.c.l.d;
import com.shopee.app.network.c.m;
import com.shopee.app.network.c.n;
import com.shopee.app.network.c.s;
import com.shopee.app.network.c.t;
import com.shopee.app.network.c.u;
import com.shopee.app.network.c.w;
import com.shopee.app.network.c.x;
import com.shopee.app.network.c.y;
import com.shopee.app.network.d;
import com.shopee.app.react.f.a;
import com.shopee.app.react.f.b;
import com.shopee.app.web.processor.WebBAStatusChangedProcessor;
import com.shopee.app.web.processor.WebCancelOrderProcessor;
import com.shopee.app.web.processor.WebCreateNewCheckoutProcessor;
import com.shopee.app.web.processor.WebFollowUserUpdateProcessor;
import com.shopee.app.web.processor.WebOnAddressSetProcessor;
import com.shopee.app.web.processor.WebOnArchiveReturnProcessor;
import com.shopee.app.web.processor.WebPassDataItemShippingProcessor;
import com.shopee.app.web.processor.WebReturnUpdateProcessor;
import com.shopee.app.web.processor.WebSplitCheckoutProcessor;
import com.shopee.app.web.processor.WebUpdateMyShopInfoProcessor;
import com.shopee.app.web.processor.WebUpdateUserAddressProcessor;
import com.shopee.app.web.processor.WebUpdateUserInfoProcessor;

public interface ProcessorAPI {
    a.C0269a actionRequiredDeletedProcessor();

    b.a actionSystemMessageProcessor();

    a.C0268a addItemProcessor();

    f.a cancelCheckoutProcess();

    a.C0271a cancelOfferProcessor();

    h.a cartAddItemProcessor();

    b.a chatArrivedProcessor();

    h.a chatDeletedProcessor();

    i.a chatMarkedUnreadProcessor();

    b.a checkCaptchaProcessor();

    k.a checkoutCancelProcessor();

    f.a checkoutListProcessor();

    l.a checkoutPaidProcessor();

    m.a connectedProcessor();

    ad.a customerOrdersProcessor();

    n.a delItemCommentProcessor();

    b.a editItemProcessor();

    p.a emailVerifiedProcessor();

    ae.a extractedHashTagProcessor();

    i.a getCartGetAllOrdersProcessor();

    ac.a getContactProcessor();

    ag.a getHotHashTagProcessor();

    ah.a getItemBatchProcessor();

    bb.a getItemDetailProcessor();

    ai.a getItemListByTypeProcessor();

    aj.a getMinAppProcessor();

    ao.a getOrdersnHintProcessor();

    aq.a getRecommendFriendProcessor();

    au.a getUserBriefProcessor();

    aw.a getUserInfoProcessor();

    ay.a getUserLastSeenProcessor();

    g.a logoutProcessor();

    c.a makeOfferProcessor();

    ak.a myCustomerProcessor();

    b.a newActionGetIDListProcessor();

    r.a newActivityProcessor();

    d.a newBindAccountProcessor();

    e.a newCallBackendProcessor();

    a.C0265a newChatBlockUserProcessor();

    k.a newCheckUserBlockedProcessor();

    y.a newCheckoutOrderProcessor();

    l.a newClearChatMsgProcessor();

    s.a newGetActivityListProcessor();

    t.a newGetAttributeModelProcessor();

    u.a newGetBatchItemScoreProcessor();

    b.a newGetBlockUserListProcessor();

    w.a newGetChatItemsProcessor();

    x.a newGetChatQuickReplyProcessor();

    d.a newGetCheckoutProcessor();

    aa.a newGetCoinProcessor();

    af.a newGetFeedsProcessor();

    ab.a newGetItemCmtListProcessor();

    am.a newGetOfferCountProcessor();

    an.a newGetOfferListProcessor();

    c.a newGetOfferProcessor();

    d.a newGetPchatListProcessor();

    ap.a newGetRecentItemsProcessor();

    at.a newGetSubCategoryProcessor();

    ba.a newGetWalletProcessor();

    u.a newItemProcessor();

    f.a newLoginProcessor();

    f.b newLoginSubProcessor();

    bd.a newMatchItemAttributeProcessor();

    i.a newRegisterProcessor();

    ar.a newReqSearchShopCustomerProcessor();

    bh.a newResetPasswordProcess();

    d.a newSearchUserProcessor();

    bk.a newSetChatLastReadProcessor();

    bl.a newSetChatQuickReplyProcessor();

    bm.a newSetUserInfoProcessor();

    bo.a newUnbindAccountProcessor();

    a.C0270a offerChangedProcessor();

    d.a operateOfferProcessor();

    i.a orderListProcessor();

    o.a orderRateProcessor();

    j.a orderReturnProcessor();

    h.a orderUpdateProcessor();

    ab.a promotionCodeProcessor();

    a.C0278a reactMeFeedsPageUpdateProcessor();

    b.a reactPageDidMountProcessor();

    be.a removeActivityProcessor();

    l.a returnListProcessor();

    m.a returnRefundListProcessor();

    ac.a returnUpdateProcessor();

    a.C0272a searchHintProcessor();

    com.shopee.app.network.c.e.b.b searchProductInShopProcessor();

    f.a sendChatProcessor();

    a.C0267a shopBalanceProcessor();

    b.a transactionProcessor();

    n.a unpaidOrdersProcessor();

    bp.a updateContactProcessor();

    WebBAStatusChangedProcessor.Processor webBAStatusChangedProcessor();

    WebCancelOrderProcessor.Processor webCancelOrderProcessor();

    WebCreateNewCheckoutProcessor.Processor webCreateNewCheckoutProcessor();

    WebFollowUserUpdateProcessor.Processor webFollowUserUpdate();

    WebOnAddressSetProcessor.Processor webOnAddressSetProcessor();

    WebOnArchiveReturnProcessor.Processor webOnArchiveReturnProcessor();

    WebPassDataItemShippingProcessor.Processor webPassDataItemShippingProcessor();

    WebReturnUpdateProcessor.Processor webReturnUpdateProcessor();

    WebSplitCheckoutProcessor.Processor webSplitCheckoutProcessor();

    WebUpdateMyShopInfoProcessor.Processor webUpdateMyShopInfoProcessor();

    WebUpdateUserAddressProcessor.Processor webUpdateUserAddressProcessor();

    WebUpdateUserInfoProcessor.Processor webUpdateUserInfoProcessor();
}
