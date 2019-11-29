package com.shopee.app.d.b;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.d.a;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserExtraInfo;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.bb;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.CheckoutItem;
import com.shopee.app.data.viewmodel.CheckoutOrderInfo;
import com.shopee.app.data.viewmodel.CustomerOrderInfo;
import com.shopee.app.data.viewmodel.FeedCommentInfo;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.ItemExtData;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.OrderItemInfo;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.data.viewmodel.UserData;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.data.viewmodel.Variation;
import com.shopee.app.data.viewmodel.chat.ChatMessage;
import com.shopee.app.data.viewmodel.chat.ChatOfferMessage;
import com.shopee.app.data.viewmodel.chat.OfferItem;
import com.shopee.app.data.viewmodel.chat2.ChatItem2;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.data.viewmodel.income.TransactionItem;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.data.viewmodel.order.ReturnItem;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.database.orm.bean.DBActivityItem;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import com.shopee.app.database.orm.bean.DBCheckoutItem;
import com.shopee.app.database.orm.bean.DBCheckoutOrder;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.database.orm.bean.DBItemComment;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBModel;
import com.shopee.app.database.orm.bean.DBModelAttrIdMap;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.database.orm.bean.DBRefund;
import com.shopee.app.database.orm.bean.DBReturnItem;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.database.orm.bean.DBTransaction;
import com.shopee.app.database.orm.bean.DBUserBrief;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import com.shopee.app.g.r;
import com.shopee.app.h.m;
import com.shopee.app.network.f;
import com.shopee.app.ui.common.e;
import com.shopee.app.ui.follow.following.k;
import com.shopee.app.ui.follow.following.t;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.add.wholesale.j;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import com.shopee.protocol.action.ActionContent;
import com.shopee.protocol.action.ActivityInfo;
import com.shopee.protocol.action.ActivityItem;
import com.shopee.protocol.action.Chat;
import com.shopee.protocol.action.ChatMsg;
import com.shopee.protocol.action.ContactBrief;
import com.shopee.protocol.action.FeedComment;
import com.shopee.protocol.action.IdInfo;
import com.shopee.protocol.action.OrderInfo;
import com.shopee.protocol.action.RecUser;
import com.shopee.protocol.action.ResponseCommon;
import com.shopee.protocol.action.ResponseShopBalance;
import com.shopee.protocol.action.ShopCustomer;
import com.shopee.protocol.action.ShopCustomerGroup;
import com.shopee.protocol.action.UserBrief;
import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.AccountExtInfo;
import com.shopee.protocol.shop.AttributeValue;
import com.shopee.protocol.shop.BuyerOrderCntInfo;
import com.shopee.protocol.shop.Category;
import com.shopee.protocol.shop.ChatOfferInfo;
import com.shopee.protocol.shop.ChatTextInfo;
import com.shopee.protocol.shop.Checkout;
import com.shopee.protocol.shop.CheckoutInfo;
import com.shopee.protocol.shop.CheckoutOrder;
import com.shopee.protocol.shop.CmtExtInfo;
import com.shopee.protocol.shop.CoinInfo;
import com.shopee.protocol.shop.CommentTagInfo;
import com.shopee.protocol.shop.CommentTagInfoList;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemAttribute;
import com.shopee.protocol.shop.ItemAttributeData;
import com.shopee.protocol.shop.ItemCmt;
import com.shopee.protocol.shop.ItemExtInfo;
import com.shopee.protocol.shop.ItemModel;
import com.shopee.protocol.shop.ItemModelId;
import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.OrderExtInfo;
import com.shopee.protocol.shop.OrderItem;
import com.shopee.protocol.shop.OrderItemExtInfo;
import com.shopee.protocol.shop.OrderLogisticsInfo;
import com.shopee.protocol.shop.PaymentOption;
import com.shopee.protocol.shop.PaymentOptionList;
import com.shopee.protocol.shop.Refund;
import com.shopee.protocol.shop.RefundExtInfo;
import com.shopee.protocol.shop.Return;
import com.shopee.protocol.shop.ReturnInfo;
import com.shopee.protocol.shop.SellerOrderCntInfo;
import com.shopee.protocol.shop.Shop;
import com.shopee.protocol.shop.ShopCover;
import com.shopee.protocol.shop.ShopExtInfo;
import com.shopee.protocol.shop.TierVariation;
import com.shopee.protocol.shop.TransHisExtInfo;
import com.shopee.protocol.shop.TransHistory;
import com.shopee.protocol.shop.VideoInfo;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class b {
    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static void d(ResponseCommon responseCommon, ak akVar) {
    }

    public static void a(ChatMsg chatMsg, DBChatMessage dBChatMessage) {
        dBChatMessage.a(a(chatMsg.msgid));
        dBChatMessage.c(a(chatMsg.chatid));
        dBChatMessage.b(a(chatMsg.itemid));
        dBChatMessage.b(a(chatMsg.type));
        dBChatMessage.a(a(chatMsg.content));
        dBChatMessage.d(a(chatMsg.from_userid));
        dBChatMessage.e(a(chatMsg.to_userid));
        dBChatMessage.c(a(chatMsg.shopid));
        dBChatMessage.a(a(chatMsg.timestamp));
        dBChatMessage.e(a(chatMsg.modelid));
        dBChatMessage.f(a(chatMsg.pchatid));
        dBChatMessage.b(a(chatMsg.text_content));
        dBChatMessage.d(a(chatMsg.orderid));
        dBChatMessage.g(a(chatMsg.opt));
    }

    public static void a(ContactBrief contactBrief, DBContactInfo dBContactInfo, int i) {
        dBContactInfo.a(a(contactBrief.userid));
        dBContactInfo.b(a(contactBrief.shopid));
        dBContactInfo.a(a(contactBrief.username));
        dBContactInfo.b(a(contactBrief.portrait));
        dBContactInfo.c(a(contactBrief.contact_name));
        dBContactInfo.a(a(contactBrief.followed));
        dBContactInfo.c(a(Integer.valueOf(i)));
    }

    public static void a(Category category, DBCategory dBCategory) {
        dBCategory.a(a(category.catid));
        dBCategory.c(a(category.country));
        dBCategory.b(a(category.image));
        dBCategory.a(a(category.name));
        dBCategory.b(a(category.status));
        dBCategory.c(a(category.usage_sort_weight));
        dBCategory.d(a(category.display_name));
        dBCategory.d(a(category.parent_category));
        dBCategory.e(a(category.is_default_subcat));
    }

    public static void a(Item item, DBItemDetail dBItemDetail) {
        a(item, dBItemDetail, "");
    }

    public static void a(Item item, DBItemDetail dBItemDetail, String str) {
        dBItemDetail.a(a(item.itemid));
        dBItemDetail.a(a(item.shopid));
        dBItemDetail.a(a(item.name));
        dBItemDetail.b(a(item.description));
        dBItemDetail.c(a(item.images));
        dBItemDetail.b(a(item.price));
        dBItemDetail.d(a(item.currency));
        dBItemDetail.b(a(item.stock));
        dBItemDetail.c(a(item.status));
        dBItemDetail.d(a(item.ctime));
        dBItemDetail.e(a(item.mtime));
        dBItemDetail.f(a(item.sold));
        dBItemDetail.c(a(item.price_min));
        dBItemDetail.d(a(item.price_max));
        dBItemDetail.g(a(item.recommend));
        dBItemDetail.h(a(item.catid));
        dBItemDetail.i(a(item.pop));
        dBItemDetail.j(a(item.liked_count, 0));
        dBItemDetail.k(a(item.offer_count, 0));
        dBItemDetail.f(a(item.brand));
        dBItemDetail.l(a(item.condition));
        dBItemDetail.m(a(item.rating_good));
        dBItemDetail.o(a(item.rating_bad));
        dBItemDetail.n(a(item.rating_normal));
        dBItemDetail.p(a(item.cmt_count, 0));
        dBItemDetail.g(a(item.country));
        dBItemDetail.a(a(item.extinfo));
        dBItemDetail.e(-1);
        dBItemDetail.e(WebRegister.GSON.b((Object) new ItemExtData(a(str), a(item.flag))));
    }

    public static void a(DBItemDetail dBItemDetail, List<IModelDetail> list, ItemDetail itemDetail) {
        if (dBItemDetail != null) {
            itemDetail.setShopId(dBItemDetail.b());
            itemDetail.setId(Long.valueOf(dBItemDetail.a()));
            itemDetail.setItemName(dBItemDetail.c());
            itemDetail.setCmtCount(dBItemDetail.r());
            itemDetail.setPrice(dBItemDetail.h());
            itemDetail.setImages(dBItemDetail.f());
            itemDetail.setStatus(dBItemDetail.j());
            itemDetail.setStock(dBItemDetail.i());
            itemDetail.setLikedCount(dBItemDetail.o());
            itemDetail.setSold(dBItemDetail.l());
            itemDetail.setViewCount(dBItemDetail.t());
            itemDetail.setExtendedInfo(dBItemDetail.s());
            if (dBItemDetail.s() != null) {
                try {
                    boolean z = false;
                    ItemExtInfo itemExtInfo = (ItemExtInfo) f.f18486a.parseFrom(dBItemDetail.s(), 0, dBItemDetail.s().length, ItemExtInfo.class);
                    itemDetail.setPriceBeforeDiscount(a(itemExtInfo.price_before_discount));
                    itemDetail.setCanUseWholesale(a(itemExtInfo.can_use_wholesale));
                    itemDetail.setWholesaleTiers(j.b(itemExtInfo.wholesale_tier_list));
                    itemDetail.setPreOder(a(itemExtInfo.is_pre_order));
                    itemDetail.setAttributeStatus(a(itemExtInfo.attr_status));
                    if (a(itemExtInfo.cat_status) == 0) {
                        z = true;
                    }
                    itemDetail.setInvalidCategory(z);
                    itemDetail.setTierVariation(itemExtInfo.tier_variation);
                    itemDetail.setSizeChart(itemExtInfo.size_chart);
                } catch (IOException e2) {
                    a.a(e2);
                }
            }
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (IModelDetail a2 : list) {
                    ModelDetail modelDetail = new ModelDetail();
                    a(a2, modelDetail);
                    arrayList.add(modelDetail);
                }
                itemDetail.setModelDetails(arrayList);
            }
            if (!TextUtils.isEmpty(dBItemDetail.m())) {
                ItemExtData itemExtData = (ItemExtData) WebRegister.GSON.a(dBItemDetail.m(), ItemExtData.class);
                if (itemExtData != null) {
                    itemDetail.setBannedReason(itemExtData.getBannedReason());
                    itemDetail.setFlag(itemExtData.getFlag());
                }
            }
        }
    }

    public static void a(IModelDetail iModelDetail, ModelDetail modelDetail) {
        modelDetail.setStatus(iModelDetail.l());
        modelDetail.setStock(iModelDetail.k());
        modelDetail.setCurrency(iModelDetail.j());
        modelDetail.setPrice(iModelDetail.i());
        modelDetail.setName(iModelDetail.h());
        modelDetail.setModelId(iModelDetail.f());
        modelDetail.setItemId(iModelDetail.g());
        modelDetail.setPriceBeforeDiscount(iModelDetail.m());
        modelDetail.setPromotionid(iModelDetail.n());
        modelDetail.setRebatePrice(iModelDetail.o());
        modelDetail.setSold(iModelDetail.p());
        modelDetail.setTierIndexes(iModelDetail.q());
    }

    public static void a(Account account, DBUserInfo dBUserInfo) {
        dBUserInfo.c(a(account.userid));
        dBUserInfo.a(a(account.username));
        dBUserInfo.b(a(account.phone));
        dBUserInfo.a(a(account.phone_verified));
        dBUserInfo.c(a(account.email));
        dBUserInfo.d(a(account.shopid));
        dBUserInfo.d(a(account.fbid));
        dBUserInfo.e(a(account.status));
        dBUserInfo.f(a(account.bankacc_verified));
        dBUserInfo.e(a(account.remark));
        dBUserInfo.f(a(account.username));
        dBUserInfo.g(a(account.portrait));
        dBUserInfo.h(a(account.machine_code));
        dBUserInfo.a(a(account.deviceid));
        dBUserInfo.a(a(account.pn_option));
        dBUserInfo.i(a(account.language));
        dBUserInfo.g(a(account.appversion));
        dBUserInfo.j(a(account.country));
        dBUserInfo.h(a(account.ctime));
        dBUserInfo.i(a(account.mtime));
        dBUserInfo.j(a(account.following_count));
        dBUserInfo.b(a(account.email_verified));
        dBUserInfo.k(a(account.last_login));
        dBUserInfo.c(a(account.is_seller));
        dBUserInfo.d(a(account.phone_public));
        dBUserInfo.b(a(account.extinfo));
        dBUserInfo.m(a(account.liked_count, 0));
        dBUserInfo.n(a(account.inited));
        dBUserInfo.o(a(account.last_logout));
    }

    public static void a(ActivityItem activityItem, DBActivityItem dBActivityItem) {
        dBActivityItem.b(a(activityItem.activity_id));
        dBActivityItem.c(a(activityItem.type));
        dBActivityItem.d(a(activityItem.createtime));
        if (activityItem.activity_info != null) {
            dBActivityItem.a(activityItem.activity_info.toByteArray());
            dBActivityItem.e(a(activityItem.activity_info.from_userid));
            dBActivityItem.f(a(activityItem.activity_info.shopid));
            dBActivityItem.a(a(activityItem.activity_info.feedid));
            dBActivityItem.b(a(activityItem.activity_info.itemid));
            dBActivityItem.c(a(activityItem.activity_info.commentid));
            dBActivityItem.b(a(activityItem.activity_info.comment_content));
            dBActivityItem.g(a(activityItem.activity_info.update_type));
            dBActivityItem.a(a(activityItem.activity_info.acctype));
            dBActivityItem.a(a(activityItem.activity_info.contact_name));
        }
    }

    public static void a(DBActivityItem dBActivityItem, DBUserInfo dBUserInfo, DBItemDetail dBItemDetail, ActivityItemInfo activityItemInfo, UserBriefInfo userBriefInfo) {
        activityItemInfo.setActivityId(dBActivityItem.d());
        activityItemInfo.setType(dBActivityItem.e());
        activityItemInfo.setCreateTime(dBActivityItem.f());
        activityItemInfo.setFromUserId(dBActivityItem.g());
        activityItemInfo.setShopId(dBActivityItem.h());
        activityItemInfo.setFeedId(dBActivityItem.a());
        activityItemInfo.setItemId(dBActivityItem.i());
        activityItemInfo.setCommentId(dBActivityItem.j());
        activityItemInfo.setComment(dBActivityItem.l());
        activityItemInfo.setUpdateType(dBActivityItem.k());
        int i = 1;
        activityItemInfo.setActivityItemType(1);
        activityItemInfo.setAccType(dBActivityItem.c());
        activityItemInfo.setContactName(dBActivityItem.b());
        if (dBUserInfo != null) {
            activityItemInfo.setUserAvatar(dBUserInfo.j());
            activityItemInfo.setFromUserName(dBUserInfo.i());
        }
        if (userBriefInfo == null) {
            activityItemInfo.setFollowingStatus(0);
        } else {
            if (userBriefInfo.isFollowed()) {
                i = 2;
            }
            activityItemInfo.setFollowingStatus(i);
        }
        if (dBItemDetail != null) {
            activityItemInfo.setItemName(dBItemDetail.c());
            activityItemInfo.setItemImage(dBItemDetail.f());
        }
        if (dBActivityItem.m() != null) {
            try {
                ActivityInfo activityInfo = (ActivityInfo) f.f18486a.parseFrom(dBActivityItem.m(), 0, dBActivityItem.m().length, ActivityInfo.class);
                if (activityInfo.customized_meta != null) {
                    activityItemInfo.setUserAvatar(a(activityInfo.customized_meta.avatar_image));
                    activityItemInfo.setItemImage(a(activityInfo.customized_meta.product_image));
                    activityItemInfo.setRedirectUrl(a(activityInfo.customized_meta.redirect_url));
                    activityItemInfo.setContent(new String(activityInfo.customized_meta.text.i()));
                }
            } catch (IOException e2) {
                a.a(e2);
            }
        }
    }

    public static void a(Chat chat, DBChatToOffer dBChatToOffer) {
        dBChatToOffer.a(a(chat.chatid));
        dBChatToOffer.a(a(chat.userid));
        dBChatToOffer.b(a(chat.shopid));
        dBChatToOffer.b(a(chat.itemid));
        dBChatToOffer.c(a(chat.buy_count));
        dBChatToOffer.c(a(chat.offer_price));
        dBChatToOffer.d(a(chat.offer_status));
        dBChatToOffer.d(a(chat.last_msgid));
        dBChatToOffer.e(a(chat.last_msg_time));
        dBChatToOffer.e(a(chat.orderid));
        dBChatToOffer.f(a(chat.archive));
        dBChatToOffer.f(a(chat.modelid));
    }

    public static long a(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    public static long a(Long l) {
        if (l == null) {
            return -1;
        }
        return l.longValue();
    }

    public static int a(Integer num, int i) {
        return num != null ? num.intValue() : i;
    }

    public static int a(Integer num) {
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private static <T> List<T> a(List<T> list) {
        return list == null ? new ArrayList() : list;
    }

    private static double a(Double d2) {
        if (d2 == null) {
            return 0.0d;
        }
        return d2.doubleValue();
    }

    public static boolean a(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static boolean a(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static byte[] a(e.f fVar) {
        if (fVar == null) {
            return new byte[0];
        }
        return fVar.i();
    }

    public static void a(t tVar, RecUser recUser) {
        UserBrief userBrief = recUser.user;
        tVar.g(a(userBrief.follower_count));
        tVar.a(a(userBrief.userid));
        tVar.c(a(userBrief.nickname));
        tVar.b(a(userBrief.shopid));
        tVar.a(a(userBrief.username));
        tVar.b(a(userBrief.portrait));
        tVar.c(a(userBrief.score));
        tVar.d(a(userBrief.products));
        tVar.a(a(userBrief.followed));
    }

    public static void a(UserBriefInfo userBriefInfo, UserBrief userBrief) {
        userBriefInfo.setUserId(a(userBrief.userid));
        userBriefInfo.setShopId(a(userBrief.shopid));
        userBriefInfo.setUserName(a(userBrief.username));
        userBriefInfo.setPortrait(a(userBrief.portrait));
        userBriefInfo.setScore(a(userBrief.score));
        userBriefInfo.setProductCnt(a(userBrief.products));
        userBriefInfo.setNickName(a(userBrief.nickname));
        userBriefInfo.setFollowed(a(userBrief.followed));
        userBriefInfo.setShopeeVerified(a(userBrief.shopee_verified_flag));
        userBriefInfo.setOfficialShop(a(userBrief.is_official_shop));
        userBriefInfo.setStatus(userBrief.status != null ? userBrief.status.intValue() : 0);
    }

    public static void a(DBChatToOffer dBChatToOffer, OfferItem offerItem) {
        offerItem.setChatId(dBChatToOffer.a());
        offerItem.setItemId(dBChatToOffer.d());
        offerItem.setShopId(dBChatToOffer.c());
        offerItem.setModelId(dBChatToOffer.h());
        offerItem.setOfferPrice(dBChatToOffer.f());
        offerItem.setOfferQuantity(dBChatToOffer.e());
        offerItem.setOfferStatus(dBChatToOffer.g());
        offerItem.setSelling(m.a(dBChatToOffer.c()));
        offerItem.setUserId(dBChatToOffer.b());
    }

    public static void a(DBChatToOffer dBChatToOffer, DBModel dBModel, OfferItem offerItem) {
        a(dBChatToOffer, offerItem);
        if (dBModel != null) {
            offerItem.setModelName(com.garena.android.appkit.tools.b.e(R.string.sp_label_variation) + ": " + dBModel.h());
        }
    }

    public static void a(ItemCmt itemCmt, DBItemComment dBItemComment) {
        dBItemComment.a(a(itemCmt.cmtid));
        dBItemComment.b(a(itemCmt.userid));
        dBItemComment.b(a(itemCmt.orderid));
        dBItemComment.c(a(itemCmt.shopid));
        dBItemComment.c(a(itemCmt.itemid));
        dBItemComment.d(a(itemCmt.modelid));
        dBItemComment.d(a(itemCmt.rating));
        dBItemComment.a(a(itemCmt.comment));
        dBItemComment.e(a(itemCmt.ctime));
        dBItemComment.f(a(itemCmt.status));
        dBItemComment.a(a(itemCmt.mentioned));
        dBItemComment.a(a(itemCmt.rating_star));
        dBItemComment.g(a(itemCmt.mtime));
        dBItemComment.h(a(itemCmt.editable));
        dBItemComment.b(a(itemCmt.extinfo));
    }

    public static void a(FeedComment feedComment, DBUserInfo dBUserInfo, FeedCommentInfo feedCommentInfo) {
        feedCommentInfo.setUserId(feedComment.userid.intValue());
        if (dBUserInfo != null) {
            feedCommentInfo.setUserName(dBUserInfo.i());
            feedCommentInfo.setNickName(dBUserInfo.a());
            feedCommentInfo.setUserPortrait(dBUserInfo.j());
            feedCommentInfo.setCommentingUserShopId(dBUserInfo.e());
        } else {
            feedCommentInfo.setUserName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
            feedCommentInfo.setNickName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
            feedCommentInfo.setCommentingUserShopId(-1);
        }
        feedCommentInfo.setComment(a(feedComment.comment));
        feedCommentInfo.setcTime(a(feedComment.ctime));
        if (feedComment.mentioned != null) {
            feedCommentInfo.setMentioned(a(feedComment.mentioned.i()));
        }
    }

    public static void a(DBItemComment dBItemComment, DBUserInfo dBUserInfo, int i, ItemCommentInfo itemCommentInfo) {
        itemCommentInfo.setCmtId(dBItemComment.c());
        itemCommentInfo.setUserId(dBItemComment.d());
        if (dBUserInfo != null) {
            itemCommentInfo.setUserName(dBUserInfo.i());
            itemCommentInfo.setNickName(dBUserInfo.a());
            itemCommentInfo.setUserPortrait(dBUserInfo.j());
            itemCommentInfo.setCommentingUserShopId(dBUserInfo.e());
        } else {
            itemCommentInfo.setUserName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
            itemCommentInfo.setNickName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
            itemCommentInfo.setCommentingUserShopId(-1);
        }
        itemCommentInfo.setOrderId(dBItemComment.e());
        itemCommentInfo.setShopId(dBItemComment.f());
        itemCommentInfo.setItemId(dBItemComment.g());
        itemCommentInfo.setModelId(dBItemComment.h());
        itemCommentInfo.setRating(dBItemComment.i());
        itemCommentInfo.setComment(dBItemComment.j());
        itemCommentInfo.setCTime(dBItemComment.k());
        itemCommentInfo.setStatus(dBItemComment.l());
        itemCommentInfo.setMentioned(dBItemComment.m());
        itemCommentInfo.setCommentListType(i);
        itemCommentInfo.setRatingStar(dBItemComment.a());
        itemCommentInfo.setEditable(dBItemComment.o());
        ArrayList arrayList = new ArrayList();
        if (dBItemComment.p() != null || dBItemComment.p().length > 0) {
            try {
                CmtExtInfo cmtExtInfo = (CmtExtInfo) f.f18486a.parseFrom(dBItemComment.p(), CmtExtInfo.class);
                arrayList.addAll(cmtExtInfo.image);
                itemCommentInfo.setAnonymous(a(cmtExtInfo.anonymous));
                itemCommentInfo.setEditableDate(a(cmtExtInfo.editable_date));
                itemCommentInfo.setHidden(a(cmtExtInfo.is_hidden));
                if (cmtExtInfo.items != null) {
                    Iterator<ItemModelId> it = cmtExtInfo.items.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ItemModelId next = it.next();
                        if (next.modelid.longValue() == itemCommentInfo.getModelId()) {
                            itemCommentInfo.setSnapshotId(a(next.snapshotid));
                            break;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        itemCommentInfo.setImages(arrayList);
    }

    private static List<e> a(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        try {
            List<CommentTagInfo> list = ((CommentTagInfoList) f.f18486a.parseFrom(bArr, 0, bArr.length, CommentTagInfoList.class)).tags;
            if (list != null && list.size() > 0) {
                for (CommentTagInfo next : list) {
                    if (next.type.intValue() == 0) {
                        e eVar = new e();
                        a(eVar, next);
                        arrayList.add(eVar);
                    }
                }
            }
        } catch (IOException e2) {
            a.a(e2);
        }
        return arrayList;
    }

    public static void a(e eVar, CommentTagInfo commentTagInfo) {
        eVar.b(commentTagInfo.length.intValue());
        eVar.c(commentTagInfo.offset.intValue());
        eVar.a(new BigDecimal(commentTagInfo.infoid.longValue()).intValue());
    }

    public static void a(Order order, OrderInfo orderInfo, DBOrderDetail dBOrderDetail) {
        dBOrderDetail.a(a(order.orderid));
        dBOrderDetail.a(a(order.shopid));
        dBOrderDetail.b(a(order.userid));
        dBOrderDetail.a(a(order.ordersn));
        dBOrderDetail.b(a(order.total_price));
        dBOrderDetail.c(a(order.actual_price));
        dBOrderDetail.d(a(order.paid_amount));
        dBOrderDetail.b(a(order.currency));
        dBOrderDetail.c(a(order.shipping_method));
        dBOrderDetail.c(a(order.shipping_name));
        dBOrderDetail.d(a(order.shipping_phone));
        dBOrderDetail.e(a(order.shipping_address));
        dBOrderDetail.e(a(order.shipping_fee));
        dBOrderDetail.f(a(order.shipping_carrier));
        dBOrderDetail.g(a(order.shipping_traceno));
        dBOrderDetail.h(a(order.actual_carrier));
        dBOrderDetail.d(a(order.order_type));
        dBOrderDetail.e(a(order.payment_method));
        dBOrderDetail.f(a(order.escrow_fee));
        dBOrderDetail.i(a(order.remark));
        dBOrderDetail.f(a(order.status));
        dBOrderDetail.g(a(order.create_time));
        dBOrderDetail.h(a(order.pay_time));
        dBOrderDetail.i(a(order.revise_time));
        dBOrderDetail.j(a(order.delivery_time));
        dBOrderDetail.k(a(order.complete_time));
        dBOrderDetail.l(a(order.cancel_time));
        dBOrderDetail.a(Long.valueOf(a(order.checkoutid)));
        dBOrderDetail.a(Boolean.valueOf(a(order.is_rated)));
        dBOrderDetail.q(a(order.status_ext));
        dBOrderDetail.r(a(order.logistics_status));
        dBOrderDetail.s(a(order.shipping_confirm_time));
        dBOrderDetail.t(a(order.pickup_time));
        dBOrderDetail.u(a(order.list_type));
        if (order.extinfo != null) {
            OrderExtInfo a2 = c.a(order.extinfo.i());
            if (a2 != null) {
                dBOrderDetail.a(a2);
                dBOrderDetail.a((List<String>) a(a2.item_image));
                dBOrderDetail.j(a(a2.item_name));
                dBOrderDetail.g(a(a2.item_price));
                dBOrderDetail.h(a(a2.order_price));
                dBOrderDetail.n(a(a2.buy_count));
                dBOrderDetail.m(a(a2.item_count));
                dBOrderDetail.o(a(a2.total_count));
                dBOrderDetail.p(a(a2.seller_userid));
            }
        }
        if (orderInfo != null) {
            dBOrderDetail.a(orderInfo);
        }
    }

    public static void a(DBOrderDetail dBOrderDetail, DBUserBrief dBUserBrief, OrderDetail orderDetail) {
        a(dBOrderDetail, orderDetail);
        if (dBUserBrief != null) {
            orderDetail.setUsername(dBUserBrief.c());
            orderDetail.setPortrait(dBUserBrief.d());
            return;
        }
        orderDetail.setUsername(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
    }

    public static void a(DBOrderDetail dBOrderDetail, DBUserInfo dBUserInfo, OrderDetail orderDetail) {
        a(dBOrderDetail, orderDetail);
        if (dBUserInfo != null) {
            orderDetail.setUsername(dBUserInfo.i());
            orderDetail.setPortrait(dBUserInfo.j());
            return;
        }
        orderDetail.setUsername(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
    }

    private static void a(DBOrderDetail dBOrderDetail, OrderDetail orderDetail) {
        orderDetail.setOrderId(dBOrderDetail.a());
        orderDetail.setUserId(dBOrderDetail.c());
        orderDetail.setShopId(dBOrderDetail.b());
        orderDetail.setUsername(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
        orderDetail.setShippingPhone(dBOrderDetail.i());
        orderDetail.setShippingAddress(dBOrderDetail.j());
        orderDetail.setOrderStatus(dBOrderDetail.t());
        orderDetail.setFirstItemName(dBOrderDetail.s());
        orderDetail.setFirstItemImage(dBOrderDetail.r());
        orderDetail.setFirstItemPrice(dBOrderDetail.B());
        orderDetail.setFirstOrderPrice(dBOrderDetail.I());
        orderDetail.setFirstBuyCount(dBOrderDetail.C());
        orderDetail.setDistinctItemCount(dBOrderDetail.A());
        orderDetail.setTotalCount(dBOrderDetail.D());
        orderDetail.setShippingName(dBOrderDetail.h());
        orderDetail.setShippingFee(dBOrderDetail.k());
        orderDetail.setSerialNumber(dBOrderDetail.d());
        orderDetail.setCheckoutId(dBOrderDetail.z().longValue());
        orderDetail.setTotalPrice(dBOrderDetail.e());
        orderDetail.setShippingCarrier(dBOrderDetail.l());
        orderDetail.setActualCarrier(dBOrderDetail.n());
        orderDetail.setShippingTraceNo(dBOrderDetail.m());
        orderDetail.setRemark(dBOrderDetail.q());
        orderDetail.setCreateTime(dBOrderDetail.u());
        orderDetail.setSelling(m.a(dBOrderDetail.b()));
        orderDetail.setRated(dBOrderDetail.F().booleanValue());
        orderDetail.setSellerId(dBOrderDetail.E());
        orderDetail.setOrderType(dBOrderDetail.o());
        orderDetail.setStatusExt(dBOrderDetail.J());
        orderDetail.setPaymentMethod(dBOrderDetail.p());
        orderDetail.setLogisticsStatus(dBOrderDetail.K());
        orderDetail.setShippingConfirmTime(dBOrderDetail.L());
        orderDetail.setPickupTime(dBOrderDetail.M());
        orderDetail.setShippingMethod(dBOrderDetail.g());
        orderDetail.setDeliveryTime(dBOrderDetail.w());
        orderDetail.setCompleteTime(dBOrderDetail.x());
        orderDetail.setPayTime(dBOrderDetail.v());
        orderDetail.setCancelTime(dBOrderDetail.y());
        orderDetail.setCurrency(dBOrderDetail.f());
        orderDetail.setListType(dBOrderDetail.N());
        byte[] G = dBOrderDetail.G();
        if (G != null) {
            OrderExtInfo a2 = c.a(G);
            orderDetail.setDaysToShip(a(a2.days_to_ship));
            orderDetail.setDaysToDelivery(a(a2.days_to_delivery));
            orderDetail.setDaysToConfirm(a(a2.days_to_confirm));
            orderDetail.setDaysExtended(a(a2.days_extended));
            orderDetail.setDaysToPay(a(a2.days_to_pay));
            orderDetail.setReleaseTime(a(a2.release_time));
            orderDetail.setFirstItemReturn(a(a2.first_item_return));
            orderDetail.setCancelUserId(a(a2.cancel_userid));
            orderDetail.setPaymentChannelName(a(a2.payment_channel_name));
            orderDetail.setCancelReason(a(a2.cancel_reason));
            orderDetail.setPayByDay(a(a2.payby_date));
            orderDetail.setImages(a(a2.item_image));
            orderDetail.setPriceBeforeDiscount(a(a2.price_before_discount));
            orderDetail.setDiscountPercentage(a(a2.discount_percentage));
            orderDetail.setFirstItemPriceBeforeDiscount(a(a2.item_price_before_discount));
            orderDetail.setArrangePickupByDate(a(a2.arrange_pickup_by_date));
            orderDetail.setShipByDate(a(a2.ship_by_date));
            orderDetail.setDiscountShippingFee(a(a2.discount_shipping_fee));
            orderDetail.setOriginShippingFee(a(a2.origin_shipping_fee));
            orderDetail.setCarrierShippingFee(a(a2.carrier_shipping_fee));
            orderDetail.setCODProcessByDate(a(a2.cod_process_by_date));
            orderDetail.setDaysToShipExtended(a(a2.days_toship_extended));
            orderDetail.setSellerDueDate(a(a2.seller_due_date));
            orderDetail.setPaymentFlag(a(a2.payment_flag));
            orderDetail.setFirstItemVariantName(a(a2.model_name));
            orderDetail.setFirstItemVariantId(a(a2.modelid));
            orderDetail.setFirstItemSnapshotId(a(a2.snapshotid));
            orderDetail.setFirstItemVariantOrderPrice(a(a2.order_price));
            orderDetail.setSellerRated(a(a2.seller_is_rated));
            orderDetail.setSellerRateCmdId(a(a2.seller_rate_cmtid));
            orderDetail.setBuyerRated(a(a2.buyer_is_rated));
            orderDetail.setBuyerRateCmdID(a(a2.buyer_rate_cmtid));
            orderDetail.setRateByDate(a(a2.rate_by_date));
            orderDetail.isFirstItemWholesale(a(a2.first_item_is_wholesale));
            orderDetail.setOfficialShop(a(a2.official_shop));
            orderDetail.setCancelDueDate(a(a2.buyercancel_pending_time));
            orderDetail.setFreeReturnRefundPeriod(a(a2.first_item_free_return_day));
            boolean z = true;
            orderDetail.setBundleItem(a(a2.first_item_is_bundle) && ar.f().e().settingConfigStore().isBundleEnabled());
            if (a(a2.group_buy_groupid) <= 0) {
                z = false;
            }
            orderDetail.setGroupBuyItem(z);
            orderDetail.setAutoCancellationLayer1Date(a(a2.auto_cancel_arrange_ship_date));
            orderDetail.setAutoCancellationLayer2Date(a(a2.auto_cancel_3pl_ack_date));
            OrderLogisticsInfo orderLogisticsInfo = a2.logistics_info;
            if (orderLogisticsInfo != null) {
                orderDetail.setLogisticsID(a(orderLogisticsInfo.logisticsid));
                orderDetail.setPickupCutoffTime(a(orderLogisticsInfo.pickup_cutoff_time));
                orderDetail.setPickupFailReason(a(orderLogisticsInfo.pickup_fail_reason));
                orderDetail.setDeliverFailReason(a(orderLogisticsInfo.deliver_fail_reason));
                orderDetail.setLogisticsStatusDesc(a(orderLogisticsInfo.delivery_status_desc));
                orderDetail.setLogisticsModTime(a(orderLogisticsInfo.delivery_status_mtime));
                orderDetail.setLogisticFlag(a(orderLogisticsInfo.logistics_flag));
                orderDetail.setPickupAttempts(a(orderLogisticsInfo.pickup_attempts));
                orderDetail.setPickupDateDesc(a(orderLogisticsInfo.pickup_date_description));
                orderDetail.setDeliveryStatusDes(a(orderLogisticsInfo.delivery_status_desc));
                orderDetail.setDeliveryStatusModetime(a(orderLogisticsInfo.delivery_status_mtime));
                orderDetail.setExpectedReceiveTime(a(orderLogisticsInfo.expected_receive_time));
            }
            if (a2.promotion_info != null) {
                orderDetail.setPromDescription(a(a2.promotion_info.description));
                orderDetail.setPromUrl(a(a2.promotion_info.url));
            }
            if (a2.cart_price_info != null) {
                orderDetail.setCreditCardPromotionValue(a(a2.cart_price_info.value));
                orderDetail.setCreditCarPromotionDesc(a(a2.cart_price_info.description));
                orderDetail.setCreditCardPercentage(a(a2.cart_price_info.percentage));
            }
            if (a2.coin_info != null) {
                try {
                    orderDetail.setCoinEarn(a(((CoinInfo) f.f18486a.parseFrom(a2.coin_info.toByteArray(), CoinInfo.class)).coin_earn));
                } catch (IOException e2) {
                    a.a(e2);
                }
            }
        }
        if (!TextUtils.isEmpty(orderDetail.getCreditCarPromotionDesc()) && !TextUtils.isEmpty(orderDetail.getPromDescription())) {
            orderDetail.setPromDescription(orderDetail.getPromDescription().replace(orderDetail.getCreditCarPromotionDesc(), ""));
        }
    }

    public static void a(BuyerOrderCntInfo buyerOrderCntInfo, BuyerOrderCountItem buyerOrderCountItem, Integer num) {
        buyerOrderCountItem.setBuyerUnpaid(Integer.valueOf(a(buyerOrderCntInfo.buyer_unpaid)));
        buyerOrderCountItem.setBuyerToShip(Integer.valueOf(a(buyerOrderCntInfo.buyer_toship)));
        buyerOrderCountItem.setBuyerShipping(Integer.valueOf(a(buyerOrderCntInfo.buyer_shipping)));
        buyerOrderCountItem.setBuyerReturn(Integer.valueOf(a(buyerOrderCntInfo.buyer_return)));
        buyerOrderCountItem.setBuyerRate(Integer.valueOf(a(num)));
    }

    public static void a(SellerOrderCntInfo sellerOrderCntInfo, SellerOrderCountItem sellerOrderCountItem) {
        sellerOrderCountItem.setSellerToPay(Integer.valueOf(a(sellerOrderCntInfo.seller_topay)));
        sellerOrderCountItem.setSellerToShip(Integer.valueOf(a(sellerOrderCntInfo.seller_toship)));
        sellerOrderCountItem.setSellerToReceive(Integer.valueOf(a(sellerOrderCntInfo.seller_toreceice)));
        sellerOrderCountItem.setSellerToReturn(Integer.valueOf(a(sellerOrderCntInfo.seller_return)));
    }

    public static void a(Shop shop, int i, boolean z, Integer num, DBShopInfo dBShopInfo) {
        dBShopInfo.a(a(shop.shopid));
        dBShopInfo.b(a(shop.userid));
        dBShopInfo.a(a(shop.name));
        dBShopInfo.b(a(shop.description));
        dBShopInfo.c(a(shop.images));
        dBShopInfo.b(a(shop.contacts));
        dBShopInfo.c(a(shop.ctime));
        dBShopInfo.d(a(shop.mtime));
        dBShopInfo.e(a(shop.status));
        dBShopInfo.d(a(shop.collect_address));
        dBShopInfo.c(a(shop.payment));
        dBShopInfo.d(a(shop.shipment));
        dBShopInfo.f(a(shop.escrow_option));
        dBShopInfo.e(a(shop.escrow_payment));
        dBShopInfo.e(a(shop.cover));
        dBShopInfo.a(a(shop.latitude));
        dBShopInfo.b(a(shop.longitude));
        dBShopInfo.f(a(shop.place));
        dBShopInfo.g(a(shop.pop));
        dBShopInfo.h(a(shop.rating_good));
        dBShopInfo.j(a(shop.rating_bad));
        dBShopInfo.i(a(shop.rating_normal));
        dBShopInfo.k(a(shop.sold_total));
        dBShopInfo.l(a(shop.item_count));
        dBShopInfo.m(a(shop.follower_count));
        dBShopInfo.n(i);
        dBShopInfo.a(z);
        dBShopInfo.a(a(shop.extinfo));
        dBShopInfo.o(a(num));
    }

    public static void a(DBShopInfo dBShopInfo, DBUserInfo dBUserInfo, ShopDetail shopDetail, SettingConfigStore settingConfigStore) {
        shopDetail.setUserId(dBShopInfo.c());
        shopDetail.setShopId(dBShopInfo.b());
        shopDetail.setShopName(dBShopInfo.d());
        shopDetail.setItemCount(dBShopInfo.o());
        shopDetail.setUserInited(dBUserInfo.v());
        shopDetail.setMaxImageCount(dBShopInfo.s());
        byte[] q = dBShopInfo.q();
        boolean z = true;
        if (!(q == null || q.length == 0)) {
            try {
                List<PaymentOption> list = ((PaymentOptionList) f.f18486a.parseFrom(q, 0, q.length, PaymentOptionList.class)).option;
                if (list != null) {
                    HashMap hashMap = new HashMap();
                    for (PaymentOption next : list) {
                        hashMap.put(Integer.valueOf(a(next.payment_method)), Integer.valueOf(a(next.enabled)));
                    }
                    if (!hashMap.containsKey(3)) {
                        shopDetail.setHasOfflinePayment(settingConfigStore.getConfig(0));
                    } else {
                        shopDetail.setHasOfflinePayment(((Integer) hashMap.get(3)).intValue() == 1);
                    }
                }
            } catch (IOException e2) {
                a.a(e2);
            }
        }
        byte[] a2 = dBShopInfo.a();
        if (!(a2 == null || a2.length == 0)) {
            try {
                ShopExtInfo shopExtInfo = (ShopExtInfo) f.f18486a.parseFrom(a2, 0, a2.length, ShopExtInfo.class);
                shopDetail.setOfferStatus(a(shopExtInfo.disable_make_offer));
                shopDetail.setImages(a(shopExtInfo.covers));
                shopDetail.setIsDescriptionBanned(a(shopExtInfo.description_banned));
                shopDetail.setShowFullAddress(a(shopExtInfo.enable_display_unitno));
                shopDetail.setRatingStar(a(shopExtInfo.rating_star));
                if (!af.a(shopExtInfo.shop_covers)) {
                    shopDetail.setShopCovers(shopExtInfo.shop_covers);
                } else if (!af.a(shopDetail.getImages())) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : shopDetail.getImages()) {
                        ShopCover.Builder builder = new ShopCover.Builder();
                        builder.type = 0;
                        builder.image_url = str;
                        arrayList.add(builder.build());
                    }
                    shopDetail.setShopCovers(arrayList);
                }
                if (shopExtInfo.auto_reply_msg == null) {
                    shopDetail.setShopAutoMsg((String) null);
                } else {
                    shopDetail.setShopAutoMsg(a(((ChatTextInfo) f.f18486a.parseFrom(shopExtInfo.auto_reply_msg.i(), 0, shopExtInfo.auto_reply_msg.i().length, ChatTextInfo.class)).text));
                }
                shopDetail.setIsShopAutoMsgOn(a(shopExtInfo.auto_reply_on));
                shopDetail.setIsChatDisabled(a(shopExtInfo.chat_disabled));
                shopDetail.setShopeeVerifiedFlag(a(shopExtInfo.shopee_verified_flag));
                if (shopExtInfo.logistics_info != null) {
                    if (shopExtInfo.default_item_logistics_info != null) {
                        shopDetail.setDefaultItemLogisticInfo(new String(shopExtInfo.default_item_logistics_info.i()));
                    }
                    shopDetail.setDisplayShippingFee(a(shopExtInfo.display_default_shipping_info));
                }
                if (shopExtInfo.admininfo != null) {
                    shopDetail.setMall(a(shopExtInfo.admininfo.official_shop));
                }
            } catch (IOException e3) {
                a.a(e3);
            }
        }
        shopDetail.setPhoneVerified(dBUserInfo.n());
        shopDetail.setSeller(dBUserInfo.q());
        shopDetail.setIsPhonePublic(dBUserInfo.r());
        if (!TextUtils.isEmpty(shopDetail.getShopName())) {
            shopDetail.setShopName(shopDetail.getShopName());
        } else {
            shopDetail.setShopName(dBUserInfo.i());
        }
        shopDetail.setUserName(dBUserInfo.i());
        shopDetail.setPortrait(dBUserInfo.j());
        shopDetail.setCover(dBShopInfo.h());
        shopDetail.setFollowersCount(dBShopInfo.p());
        shopDetail.setFollowingCount(dBUserInfo.m());
        shopDetail.setEmailVerified(dBUserInfo.o());
        shopDetail.setFBId(dBUserInfo.f());
        shopDetail.setPhone(dBUserInfo.b());
        shopDetail.setRating(new int[]{dBShopInfo.l(), dBShopInfo.m(), dBShopInfo.n()});
        shopDetail.setScore(dBShopInfo.r());
        shopDetail.setFollowed(dBShopInfo.t());
        shopDetail.setDescription(dBShopInfo.e());
        shopDetail.setLatitude(dBShopInfo.i());
        shopDetail.setLongitude(dBShopInfo.j());
        shopDetail.setPlace(dBShopInfo.k());
        shopDetail.setCTime(dBShopInfo.g());
        shopDetail.setLikedCount(dBUserInfo.u());
        if (dBUserInfo.t() != null) {
            try {
                AccountExtInfo accountExtInfo = (AccountExtInfo) f.f18486a.parseFrom(dBUserInfo.t(), 0, dBUserInfo.t().length, AccountExtInfo.class);
                if (accountExtInfo.bank_account != null) {
                    shopDetail.setBankAccount(a(accountExtInfo.bank_account.account_name));
                    shopDetail.setBankNo(a(accountExtInfo.bank_account.account_number));
                }
                shopDetail.setIsFeedsPrivate(a(accountExtInfo.feed_private));
                if (accountExtInfo.access != null) {
                    if (a(accountExtInfo.access.hide_likes) != 1) {
                        z = false;
                    }
                    shopDetail.setIsLikesPrivate(z);
                } else {
                    shopDetail.setIsLikesPrivate(false);
                }
                if (accountExtInfo.birth_timestamp != null) {
                    shopDetail.setBirthdayTimeStamp(a(accountExtInfo.birth_timestamp));
                }
                shopDetail.setInvisibleToContact(a(accountExtInfo.hide_from_contact));
                shopDetail.setGender(a(accountExtInfo.gender));
                shopDetail.setHolidayModeOn(a(accountExtInfo.holiday_mode_on, false));
            } catch (Exception e4) {
                a.a(e4);
            }
        }
        shopDetail.setBankStatus(dBUserInfo.h());
    }

    public static void a(OrderItem orderItem, DBOrderItem dBOrderItem) {
        dBOrderItem.a(a(orderItem.orderid));
        dBOrderItem.a(a(orderItem.userid));
        dBOrderItem.b(a(orderItem.shopid));
        dBOrderItem.b(a(orderItem.itemid));
        dBOrderItem.c(a(orderItem.modelid));
        dBOrderItem.c(a(orderItem.amount));
        dBOrderItem.e(a(orderItem.item_price));
        dBOrderItem.f(a(orderItem.order_price));
        dBOrderItem.a(a(orderItem.currency));
        dBOrderItem.d(a(orderItem.status));
        dBOrderItem.d(a(orderItem.chatid));
        dBOrderItem.g(a(orderItem.snapshotid));
    }

    private static void a(DBOrderItem dBOrderItem, ItemSnapshotInfo itemSnapshotInfo, OrderItemInfo orderItemInfo) {
        orderItemInfo.setId(dBOrderItem.j());
        orderItemInfo.setOrderId(dBOrderItem.a());
        orderItemInfo.setUserId(dBOrderItem.b());
        orderItemInfo.setShopId(dBOrderItem.c());
        orderItemInfo.setItemId(dBOrderItem.d());
        orderItemInfo.setModelId(dBOrderItem.e());
        orderItemInfo.setAmount(dBOrderItem.f());
        orderItemInfo.setItemPrice(dBOrderItem.k());
        orderItemInfo.setOrderPrice(dBOrderItem.l());
        orderItemInfo.setCurrency(dBOrderItem.g());
        orderItemInfo.setStatus(dBOrderItem.h());
        orderItemInfo.setChatId(dBOrderItem.i());
        orderItemInfo.setSnapshotId(dBOrderItem.m());
        if (itemSnapshotInfo != null) {
            orderItemInfo.setItemImage(itemSnapshotInfo.getImages());
            orderItemInfo.setItemName(itemSnapshotInfo.getItemName());
            orderItemInfo.setPriceBeforeDiscount(a(Long.valueOf(itemSnapshotInfo.getPriceBeforeDiscount())));
            for (ModelDetail next : itemSnapshotInfo.getModels()) {
                if (next.getModelId() == orderItemInfo.getModelId()) {
                    orderItemInfo.setModelName(next.getName());
                    orderItemInfo.setModelPrice(next.getPrice());
                    orderItemInfo.setModelPriceBeforeDiscount(next.getPriceBeforeDiscount());
                    return;
                }
            }
        }
    }

    public static void a(DBUserInfo dBUserInfo, UserData userData) {
        if (dBUserInfo != null) {
            userData.setUserName(dBUserInfo.i());
            userData.setPortrait(dBUserInfo.j());
            userData.setUserId(dBUserInfo.d());
            userData.setPhoneNumber(dBUserInfo.b());
            userData.setPhonePublic(dBUserInfo.r());
            userData.setLastLogin(dBUserInfo.p());
            userData.setLastLogout(dBUserInfo.w());
            userData.setShopId(dBUserInfo.e());
            userData.setUserStatus(dBUserInfo.g());
            if (dBUserInfo.t() != null) {
                try {
                    AccountExtInfo accountExtInfo = (AccountExtInfo) f.f18486a.parseFrom(dBUserInfo.t(), 0, dBUserInfo.t().length, AccountExtInfo.class);
                    userData.setIsUserActive(!a(accountExtInfo.is_semi_inactive));
                    userData.setHolidayModeOn(a(accountExtInfo.holiday_mode_on, false));
                    if (accountExtInfo.access != null) {
                        userData.setAutoTranslationEnabled(a(accountExtInfo.access.auto_translation_enabled));
                    }
                } catch (Exception e2) {
                    a.a(e2);
                }
            } else {
                userData.setUserName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
            }
        }
    }

    public static void a(DBUserBrief dBUserBrief, UserData userData) {
        if (dBUserBrief != null) {
            userData.setUserName(dBUserBrief.c());
            userData.setPortrait(dBUserBrief.d());
            userData.setUserId(dBUserBrief.a());
            userData.setPhoneNumber(dBUserBrief.i());
            userData.setShopId(dBUserBrief.b());
            userData.setUserStatus(dBUserBrief.j());
            return;
        }
        userData.setUserName(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
    }

    public static void a(ResponseCommon responseCommon, ak akVar, int i) {
        int a2 = a(responseCommon.userid);
        if (((Integer) akVar.d().b(0)).intValue() != a2) {
            akVar.t().a("").v();
            akVar.s().a("").v();
        }
        akVar.d().a(Integer.valueOf(a2)).v();
        akVar.f().a(a(responseCommon.acc.portrait)).v();
        if (r.a(i)) {
            akVar.h().a(a(responseCommon.acc.password)).v();
        }
        if (responseCommon.acc.extinfo != null) {
            try {
                akVar.l().a(a(((AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class)).lineid)).v();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        akVar.p().a(a(responseCommon.vcode_token)).v();
        akVar.k().a(a(responseCommon.acc.fbid)).v();
        akVar.b().a(a(responseCommon.country)).v();
        akVar.e().a(a(responseCommon.acc.phone)).v();
        akVar.c().a(a(responseCommon.token)).v();
        akVar.g().a(a(responseCommon.acc.username)).v();
        akVar.i().a(Integer.valueOf(a(responseCommon.acc.shopid))).v();
        akVar.j().a(a(responseCommon.acc.email)).v();
        akVar.q().a(Boolean.valueOf(a(responseCommon.acc.is_seller))).v();
    }

    public static void a(ResponseCommon responseCommon, ak akVar) {
        akVar.c().a(a(responseCommon.token)).v();
        akVar.h().a(a(responseCommon.acc.password)).v();
    }

    public static void b(ResponseCommon responseCommon, ak akVar) {
        if (!TextUtils.isEmpty(responseCommon.acc.phone)) {
            akVar.e().a(a(responseCommon.acc.phone)).v();
        }
        if (!TextUtils.isEmpty(responseCommon.acc.email)) {
            akVar.j().a(a(responseCommon.acc.email)).v();
        }
        if (!TextUtils.isEmpty(responseCommon.acc.password)) {
            akVar.h().a(a(responseCommon.acc.password)).v();
        }
        if (!TextUtils.isEmpty(responseCommon.acc.fbid)) {
            akVar.k().a(a(responseCommon.acc.fbid)).v();
        }
        if (!TextUtils.isEmpty(responseCommon.token)) {
            akVar.c().a(responseCommon.token).v();
        }
        if (responseCommon.acc.extinfo != null) {
            try {
                a(responseCommon, (AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class), akVar);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    static void a(ResponseCommon responseCommon, AccountExtInfo accountExtInfo, ak akVar) {
        akVar.l().a(a(accountExtInfo.lineid)).v();
    }

    public static void c(ResponseCommon responseCommon, ak akVar) {
        akVar.e().a(a(responseCommon.acc.phone)).v();
        akVar.j().a(a(responseCommon.acc.email)).v();
        akVar.k().a(a(responseCommon.acc.fbid)).v();
        if (responseCommon.acc.extinfo != null) {
            try {
                a(responseCommon, (AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class), akVar);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(ResponseCommon responseCommon, UserInfo userInfo, int i) {
        userInfo.setUserId(a(responseCommon.userid));
        userInfo.setAvatarId(a(responseCommon.acc.portrait));
        if (r.a(i)) {
            userInfo.setPassword(a(responseCommon.acc.password));
        }
        userInfo.setVCodeToken(a(responseCommon.vcode_token));
        userInfo.setHasPassword(!TextUtils.isEmpty(responseCommon.acc.password));
        userInfo.setCountry(a(responseCommon.country));
        userInfo.setPhone(a(responseCommon.acc.phone));
        userInfo.setEmail(a(responseCommon.acc.email));
        userInfo.setUsername(a(responseCommon.acc.username));
        userInfo.setShopId(a(responseCommon.acc.shopid));
        userInfo.setSeller(a(responseCommon.acc.is_seller));
        userInfo.setToken(a(responseCommon.token));
        userInfo.setPhonePublic(a(responseCommon.acc.phone_public));
        userInfo.setEmailVerified(a(responseCommon.acc.email_verified));
        userInfo.setPnOption(a(responseCommon.acc.pn_option));
        userInfo.setCrossBorderOption(a(responseCommon.acc.cb_option));
        if (responseCommon.acc.extinfo != null) {
            try {
                AccountExtInfo accountExtInfo = (AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class);
                a(accountExtInfo, userInfo);
                userInfo.setFeedInfo(accountExtInfo.feed_account_info);
                userInfo.setLiveAccountInfo(accountExtInfo.live_account_info);
            } catch (IOException e2) {
                a.a(e2);
            }
        }
    }

    public static void a(ResponseCommon responseCommon, UserExtraInfo userExtraInfo) {
        if (responseCommon.acc.extinfo != null) {
            try {
                userExtraInfo.setCartItemCount(a(((AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class)).cart_item_count));
            } catch (IOException e2) {
                a.a(e2);
            }
        }
    }

    static void a(AccountExtInfo accountExtInfo, UserInfo userInfo) {
        if (accountExtInfo.holiday_mode_on != null) {
            userInfo.setHolidayMode(a(accountExtInfo.holiday_mode_on));
            userInfo.setHolidayModeTime(accountExtInfo.holiday_mode_mtime != null ? a(accountExtInfo.holiday_mode_mtime) : com.garena.android.appkit.tools.a.a.a());
        }
        if (accountExtInfo.access != null) {
            userInfo.setWalletSetting(a(accountExtInfo.access.wallet_setting));
            userInfo.setBuyerWalletProvider(a(accountExtInfo.access.wallet_provider, 0));
            boolean z = true;
            if (a(accountExtInfo.access.seller_wholesale_setting, 0) != 1) {
                z = false;
            }
            userInfo.setWholesaleEnabled(z);
            userInfo.setAutoTranslationEnabled(a(accountExtInfo.access.auto_translation_enabled));
        }
        userInfo.setBACheckStatus(a(accountExtInfo.ba_check_status, 0));
        userInfo.setNickname(a(accountExtInfo.nickname));
    }

    public static void a(ResponseCommon responseCommon, UserInfo userInfo) {
        if (!TextUtils.isEmpty(responseCommon.acc.phone)) {
            userInfo.setPhone(a(responseCommon.acc.phone));
        }
        if (!TextUtils.isEmpty(responseCommon.acc.email)) {
            userInfo.setEmail(a(responseCommon.acc.email));
            userInfo.setEmailVerified(a(responseCommon.acc.email_verified));
        }
        if (!TextUtils.isEmpty(responseCommon.acc.password)) {
            userInfo.setPassword(a(responseCommon.acc.password));
            userInfo.setHasPassword(!TextUtils.isEmpty(responseCommon.acc.password));
        }
        if (!TextUtils.isEmpty(responseCommon.token)) {
            userInfo.setToken(responseCommon.token);
        }
    }

    public static void b(ResponseCommon responseCommon, UserInfo userInfo) {
        userInfo.setPhone(a(responseCommon.acc.phone));
        userInfo.setEmail(a(responseCommon.acc.email));
    }

    public static void c(ResponseCommon responseCommon, UserInfo userInfo) {
        userInfo.setToken(responseCommon.token);
        userInfo.setPassword(a(responseCommon.acc.password));
        userInfo.setHasPassword(!TextUtils.isEmpty(responseCommon.acc.password));
    }

    public static void d(ResponseCommon responseCommon, UserInfo userInfo) {
        if (responseCommon.acc.phone_public != null) {
            userInfo.setPhonePublic(responseCommon.acc.phone_public.booleanValue());
        }
        if (responseCommon.acc.pn_option != null) {
            userInfo.setPnOption(responseCommon.acc.pn_option.longValue());
        }
        if (responseCommon.acc.extinfo != null) {
            try {
                a((AccountExtInfo) f.f18486a.parseFrom(responseCommon.acc.extinfo.i(), 0, responseCommon.acc.extinfo.h(), AccountExtInfo.class), userInfo);
            } catch (IOException e2) {
                a.a(e2);
            }
        }
    }

    public static void a(DBUserBrief dBUserBrief, DBUserInfo dBUserInfo, List<OrderDetail> list, int i, CustomerOrderInfo customerOrderInfo) {
        if (dBUserInfo != null) {
            customerOrderInfo.setUserNickName(dBUserInfo.a());
            customerOrderInfo.setUserAvatar(dBUserInfo.j());
            customerOrderInfo.setUserName(dBUserInfo.i());
        } else {
            customerOrderInfo.setUserNickName(dBUserBrief.g());
            customerOrderInfo.setUserAvatar(dBUserBrief.d());
            customerOrderInfo.setUserName(dBUserBrief.c());
        }
        customerOrderInfo.setTotalCount(i);
        customerOrderInfo.setOrderDetailList(list);
    }

    public static void a(DBItemDetail dBItemDetail, List<DBCategory> list, AddProductInfo addProductInfo) {
        int i;
        addProductInfo.setName(dBItemDetail.d());
        addProductInfo.setDescription(dBItemDetail.e());
        addProductInfo.setBrand(dBItemDetail.p());
        addProductInfo.setCategoryId(dBItemDetail.n());
        if (!TextUtils.isEmpty(dBItemDetail.m())) {
            ItemExtData itemExtData = (ItemExtData) WebRegister.GSON.a(dBItemDetail.m(), ItemExtData.class);
            if (itemExtData != null) {
                addProductInfo.setBannedReason(itemExtData.getBannedReason());
                addProductInfo.setDeListProduct(ItemExtData.Companion.isDeList(itemExtData.getFlag()));
            }
        }
        if (!af.a(list)) {
            addProductInfo.setCategoryId(list.get(0).a());
            Iterator<DBCategory> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DBCategory next = it.next();
                if (!next.e()) {
                    addProductInfo.setCategory(next.c());
                    break;
                }
            }
        }
        switch (dBItemDetail.q()) {
            case 1:
            case 2:
            case 3:
            case 5:
                addProductInfo.setCondition(com.garena.android.appkit.tools.b.e(R.string.sp_label_new_tag));
                break;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
                addProductInfo.setCondition(com.garena.android.appkit.tools.b.e(R.string.sp_label_used_new));
                break;
            default:
                addProductInfo.setCondition(com.garena.android.appkit.tools.b.e(R.string.sp_label_condition_not_set));
                break;
        }
        addProductInfo.setConditionId(dBItemDetail.q());
        addProductInfo.setPrice(com.shopee.app.g.e.a(dBItemDetail.h(), "IDR", true));
        addProductInfo.setStock(String.valueOf(dBItemDetail.i()));
        addProductInfo.setImages(dBItemDetail.g());
        addProductInfo.setStatus(dBItemDetail.j());
        try {
            ItemExtInfo itemExtInfo = (ItemExtInfo) f.f18486a.parseFrom(dBItemDetail.s(), 0, dBItemDetail.s().length, ItemExtInfo.class);
            if (itemExtInfo != null) {
                if (itemExtInfo.estimated_days != null) {
                    addProductInfo.setShippingDays(itemExtInfo.estimated_days.intValue());
                }
                if (!af.a(itemExtInfo.cats)) {
                    addProductInfo.setCategoryIdPath(itemExtInfo.cats.get(0).catid);
                }
                if (!TextUtils.isEmpty(itemExtInfo.display_shipping_fee)) {
                    addProductInfo.setDisplayLogisticInfo(itemExtInfo.display_shipping_fee);
                }
                addProductInfo.setDisplayWeight(a(itemExtInfo.display_weight));
                addProductInfo.setWeight(a(itemExtInfo.weight, 0));
                addProductInfo.setPreOrder(a(itemExtInfo.is_pre_order));
                if (itemExtInfo.logistics_info != null) {
                    addProductInfo.setLogisticInfo(new String(itemExtInfo.logistics_info.i()));
                }
                if (!af.a(itemExtInfo.video_info_list)) {
                    VideoInfo videoInfo = itemExtInfo.video_info_list.get(0);
                    addProductInfo.setVideo(MediaData.newVideoData(videoInfo.thumb_url, videoInfo.video_id, videoInfo.duration.intValue()));
                }
                boolean z = a(itemExtInfo.cat_status) == 0;
                addProductInfo.setInvalidCategory(z);
                if (itemExtInfo.attributes != null) {
                    addProductInfo.setModelId(a(itemExtInfo.attributes.modelid));
                    if (!af.a(itemExtInfo.attributes.values)) {
                        ArrayList arrayList = new ArrayList(itemExtInfo.attributes.values.size());
                        for (int i2 = 0; i2 < itemExtInfo.attributes.values.size(); i2++) {
                            AttributeValue attributeValue = itemExtInfo.attributes.values.get(i2);
                            int a2 = a(attributeValue.attr_id);
                            String a3 = a(attributeValue.value);
                            if (z) {
                                i = 2;
                            } else {
                                i = a(attributeValue.status);
                            }
                            arrayList.add(new u(a2, a3, 1, i));
                        }
                        addProductInfo.setAttributeValues(arrayList);
                    }
                }
                int a4 = a(itemExtInfo.attr_status);
                if (z) {
                    a4 = 2;
                }
                addProductInfo.setAttributeStatus(a4);
                addProductInfo.setDimension(new com.shopee.app.d.a.b().a(itemExtInfo.dimensions, itemExtInfo.display_dimension));
                if (!af.a(itemExtInfo.tier_variation)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (TierVariation next2 : itemExtInfo.tier_variation) {
                        arrayList2.add(new Variation(next2.name, next2.options, next2.images));
                    }
                    addProductInfo.setTierVariations(arrayList2);
                }
            }
        } catch (IOException e2) {
            a.a(e2);
        }
    }

    public static void a(Item item, long j, DBItemSnapShot dBItemSnapShot) {
        dBItemSnapShot.a(Long.valueOf(a(item.itemid)));
        dBItemSnapShot.a(a(item.shopid));
        dBItemSnapShot.a(a(item.name));
        dBItemSnapShot.b(a(item.description));
        dBItemSnapShot.c(a(item.images));
        dBItemSnapShot.a(a(item.price));
        dBItemSnapShot.d(a(item.currency));
        dBItemSnapShot.b(a(item.stock));
        dBItemSnapShot.c(a(item.status));
        dBItemSnapShot.d(a(item.ctime));
        dBItemSnapShot.e(a(item.mtime));
        dBItemSnapShot.f(a(item.sold));
        dBItemSnapShot.b(a(item.price_min));
        dBItemSnapShot.c(a(item.price_max));
        dBItemSnapShot.g(a(item.recommend));
        dBItemSnapShot.e(a(item.collect_address));
        dBItemSnapShot.h(a(item.catid));
        dBItemSnapShot.i(a(item.pop));
        dBItemSnapShot.j(a(item.liked_count));
        dBItemSnapShot.k(a(item.offer_count));
        dBItemSnapShot.f(a(item.brand));
        dBItemSnapShot.l(a(item.condition));
        dBItemSnapShot.m(a(item.rating_good));
        dBItemSnapShot.o(a(item.rating_bad));
        dBItemSnapShot.n(a(item.rating_normal));
        dBItemSnapShot.p(a(item.cmt_count));
        dBItemSnapShot.g(a(item.country));
        dBItemSnapShot.d(j);
        dBItemSnapShot.a(a(item.extinfo));
    }

    public static void a(ItemSnapshotInfo itemSnapshotInfo, ItemDetail itemDetail) {
        itemDetail.setId(Long.valueOf(itemSnapshotInfo.getId()));
        itemDetail.setShopId(itemSnapshotInfo.getShopId());
        itemDetail.setDescription(itemSnapshotInfo.getDescription());
        itemDetail.setImages(itemSnapshotInfo.getImages());
        itemDetail.setPrice(itemSnapshotInfo.getPrice());
        itemDetail.setCurrency(itemSnapshotInfo.getCurrency());
        itemDetail.setStock(itemSnapshotInfo.getStock());
        itemDetail.setStatus(itemSnapshotInfo.getStatus());
        itemDetail.setcTime(itemSnapshotInfo.getcTime());
        itemDetail.setmTime(itemSnapshotInfo.getmTime());
        itemDetail.setSold(itemSnapshotInfo.getSold());
        itemDetail.setRecommend(itemSnapshotInfo.getRecommend());
        itemDetail.setCatId(itemSnapshotInfo.getCatId());
        itemDetail.setLikedCount(itemSnapshotInfo.getLikedCount());
        itemDetail.setBrand(itemSnapshotInfo.getBrand());
        itemDetail.setCondition(itemSnapshotInfo.getCondition());
        itemDetail.setCmtCount(itemSnapshotInfo.getCmtCount());
        itemDetail.setItemName(itemSnapshotInfo.getItemName());
        itemDetail.setPriceBeforeDiscount(itemSnapshotInfo.getPriceBeforeDiscount());
        itemDetail.setModelDetails(itemSnapshotInfo.getModels());
    }

    public static void a(DBItemSnapShot dBItemSnapShot, List<ModelDetail> list, ItemSnapshotInfo itemSnapshotInfo) {
        if (dBItemSnapShot != null) {
            itemSnapshotInfo.setShopId(dBItemSnapShot.b());
            itemSnapshotInfo.setId(dBItemSnapShot.a());
            itemSnapshotInfo.setItemName(dBItemSnapShot.c());
            itemSnapshotInfo.setPrice(dBItemSnapShot.e());
            itemSnapshotInfo.setImages(dBItemSnapShot.d());
            itemSnapshotInfo.setStatus(dBItemSnapShot.g());
            itemSnapshotInfo.setStock(dBItemSnapShot.f());
            itemSnapshotInfo.setLikedCount(dBItemSnapShot.i());
            itemSnapshotInfo.setSold(dBItemSnapShot.h());
            itemSnapshotInfo.setSnapshotId(dBItemSnapShot.j());
            itemSnapshotInfo.setModels(list);
            if (dBItemSnapShot.k() != null) {
                try {
                    itemSnapshotInfo.setPriceBeforeDiscount(a(((ItemExtInfo) f.f18486a.parseFrom(dBItemSnapShot.k(), 0, dBItemSnapShot.k().length, ItemExtInfo.class)).price_before_discount));
                } catch (IOException e2) {
                    a.a(e2);
                }
            }
        }
    }

    public static void a(DBOrderDetail dBOrderDetail, DBUserInfo dBUserInfo, List<Pair<DBOrderItem, ItemSnapshotInfo>> list, OrderDetail orderDetail) {
        a(dBOrderDetail, dBUserInfo, orderDetail);
        ArrayList arrayList = new ArrayList();
        for (Pair next : list) {
            OrderItemInfo orderItemInfo = new OrderItemInfo();
            a((DBOrderItem) next.first, (ItemSnapshotInfo) next.second, orderItemInfo);
            arrayList.add(orderItemInfo);
        }
        orderDetail.setItems(arrayList);
    }

    public static void a(ActionContent actionContent, DBActionContent dBActionContent) {
        dBActionContent.b(a(actionContent.action_id));
        dBActionContent.a(a(actionContent.content));
        dBActionContent.a(a(actionContent.action_redirect_type));
        dBActionContent.a((List<String>) a(actionContent.images));
        dBActionContent.b(a(actionContent.createtime));
        dBActionContent.a(new String(a(actionContent.title)));
        dBActionContent.c(a(actionContent.item_count));
        dBActionContent.d(a(actionContent.action_type));
        if (actionContent.id_info != null) {
            dBActionContent.b(actionContent.id_info.toByteArray());
        }
        dBActionContent.b(a(actionContent.action_redirect_url));
        dBActionContent.e(a(actionContent.action_cate));
        dBActionContent.c(a(actionContent.action_app_path));
        dBActionContent.d(a(actionContent.action_reactnative_path));
        dBActionContent.a(a(actionContent.groupid));
        dBActionContent.f(a(actionContent.grouped_count));
        dBActionContent.e(a(actionContent.avatar_image));
        dBActionContent.f(a(actionContent.apprl));
    }

    public static void a(DBActionContent dBActionContent, ActionContentInfo actionContentInfo, bb bbVar) {
        actionContentInfo.setId(dBActionContent.b());
        actionContentInfo.setContent(new String(dBActionContent.c()));
        actionContentInfo.setActionRedirectType(dBActionContent.d());
        actionContentInfo.setImages(dBActionContent.e());
        actionContentInfo.setCreateTime(dBActionContent.f());
        actionContentInfo.setTitle(dBActionContent.g());
        actionContentInfo.setActionType(dBActionContent.h());
        actionContentInfo.setActionRedirectUrl(dBActionContent.j());
        actionContentInfo.setActionAppPath(dBActionContent.l());
        actionContentInfo.setActionReactNativePath(dBActionContent.m());
        actionContentInfo.setGroupId(a(Long.valueOf(dBActionContent.a())));
        actionContentInfo.setGroupedCount(a(Integer.valueOf(dBActionContent.o())));
        actionContentInfo.setActionCategory(a(Integer.valueOf(dBActionContent.k())));
        actionContentInfo.setAvatarImage(a(dBActionContent.p()));
        actionContentInfo.setApprl(a(dBActionContent.q()));
        int i = 0;
        if (dBActionContent.i() != null) {
            try {
                IdInfo idInfo = (IdInfo) f.f18486a.parseFrom(dBActionContent.i(), 0, dBActionContent.i().length, IdInfo.class);
                actionContentInfo.setOrderId(a(idInfo.orderid));
                actionContentInfo.setCheckoutId(a(idInfo.checkout_id));
                actionContentInfo.setRefundId(a(idInfo.refund_id));
                actionContentInfo.setReturnId(a(idInfo.return_id));
                actionContentInfo.setShopId(a(idInfo.shopid));
                actionContentInfo.setBuyerId(a(idInfo.buyer_id));
                actionContentInfo.setItemId(a(idInfo.itemid));
                actionContentInfo.setTaskId(a(idInfo.taskid));
                actionContentInfo.setWithdrawalId(a(idInfo.withdrawal_id));
            } catch (Exception e2) {
                a.a(e2);
            }
        }
        if (dBActionContent.h() == 210 || dBActionContent.h() == 146) {
            if (bbVar.g()) {
                bbVar.c(com.garena.android.appkit.tools.a.a.a());
                bbVar.a(dBActionContent.b());
                bbVar.a(0);
            } else if (bbVar.c(dBActionContent.b())) {
                i = bbVar.a();
            } else if (bbVar.i()) {
                bbVar.c(com.garena.android.appkit.tools.a.a.a());
                bbVar.a(dBActionContent.b());
                bbVar.a(0);
            }
            actionContentInfo.setShowRating(i);
        }
        i = -1;
        actionContentInfo.setShowRating(i);
    }

    public static void a(Checkout checkout, DBCheckoutItem dBCheckoutItem) {
        dBCheckoutItem.a(a(checkout.checkoutid));
        dBCheckoutItem.a(a(checkout.userid));
        dBCheckoutItem.a(a(checkout.checkout_info));
        dBCheckoutItem.b(a(checkout.country));
        dBCheckoutItem.c(a(checkout.ctime));
        dBCheckoutItem.a(a(checkout.currency));
        dBCheckoutItem.d(a(checkout.mtime));
        dBCheckoutItem.c(a(checkout.paid_amount));
        dBCheckoutItem.b(a(checkout.status));
        dBCheckoutItem.e(a(checkout.payment_status));
        dBCheckoutItem.b(a(checkout.total_price));
        dBCheckoutItem.c(a(checkout.checkout_sn));
        dBCheckoutItem.d(a(checkout.actual_price));
        dBCheckoutItem.f(a(checkout.payment_type));
        dBCheckoutItem.g(a(checkout.logistics_status));
    }

    public static void a(DBCheckoutItem dBCheckoutItem, List<OrderDetail> list, List<CheckoutOrderInfo> list2, boolean z, CheckoutItem checkoutItem) {
        checkoutItem.setCheckoutId(dBCheckoutItem.a());
        checkoutItem.setUserId(dBCheckoutItem.b());
        checkoutItem.setStatus(dBCheckoutItem.c());
        checkoutItem.setTotalPrice(dBCheckoutItem.d());
        checkoutItem.setPaidAmount(dBCheckoutItem.e());
        checkoutItem.setCurrency(dBCheckoutItem.f());
        checkoutItem.setcTime(dBCheckoutItem.g());
        checkoutItem.setmTime(dBCheckoutItem.h());
        checkoutItem.setCheckoutOrderList(list2);
        checkoutItem.setCountry(dBCheckoutItem.k());
        checkoutItem.setPaymentStatus(dBCheckoutItem.l());
        checkoutItem.setCheckoutSn(dBCheckoutItem.m());
        checkoutItem.setActualPrice(dBCheckoutItem.n());
        checkoutItem.setPaymentType(dBCheckoutItem.o());
        checkoutItem.setLogisticsStatus(dBCheckoutItem.p());
        checkoutItem.setSupportChangePayment(z);
        if (list != null) {
            checkoutItem.setOrderDetailList(list);
        }
        CheckoutInfo j = dBCheckoutItem.j();
        if (j != null) {
            checkoutItem.setPaymentChannelName(a(j.payment_channel_name));
            checkoutItem.setUniqueCode(j.unique_code == null ? 0 : j.unique_code.longValue());
            checkoutItem.setPaymentCard(a(j.payment_card));
            checkoutItem.setPayByDate(a(j.payby_date));
            checkoutItem.setReceiptUploadTime(a(j.receipt_upload_time));
            checkoutItem.setReceiptProcessByDate(a(j.receipt_processby_date));
            checkoutItem.setReceiptRejectTime(a(j.receipt_reject_time));
            checkoutItem.setReceiptProcessWorkDays(a(j.receipt_process_work_days));
            checkoutItem.setCheckoutOrderType(a(j.checkout_order_type));
            checkoutItem.setPriceBeforeDiscount(a(j.price_before_discount));
            checkoutItem.setDiscountPercentage(a(j.discount_percentage));
            if (j.promotion_info != null) {
                checkoutItem.setPromDescription(a(j.promotion_info.description));
                checkoutItem.setPromUrl(a(j.promotion_info.url));
            }
        }
    }

    public static void a(DBCheckoutOrder dBCheckoutOrder, String str, CheckoutOrderInfo checkoutOrderInfo) {
        checkoutOrderInfo.setShopId(dBCheckoutOrder.a());
        checkoutOrderInfo.setOrderId(dBCheckoutOrder.b());
        checkoutOrderInfo.setItemCount(dBCheckoutOrder.c());
        checkoutOrderInfo.setImages(dBCheckoutOrder.d());
        checkoutOrderInfo.setStatus(dBCheckoutOrder.e());
        checkoutOrderInfo.setPrice(dBCheckoutOrder.f());
        checkoutOrderInfo.setCurrency(dBCheckoutOrder.g());
        checkoutOrderInfo.setDaysToPay(dBCheckoutOrder.h());
        if (!TextUtils.isEmpty(str)) {
            checkoutOrderInfo.setSellerAvatar(str);
        }
    }

    public static void a(CheckoutOrder checkoutOrder, DBCheckoutOrder dBCheckoutOrder) {
        dBCheckoutOrder.a(a(checkoutOrder.shopid));
        dBCheckoutOrder.a(a(checkoutOrder.orderid));
        dBCheckoutOrder.b(a(checkoutOrder.item_count));
        dBCheckoutOrder.a((List<String>) checkoutOrder.images != null ? checkoutOrder.images : new ArrayList());
        dBCheckoutOrder.c(a(checkoutOrder.status));
        dBCheckoutOrder.b(a(checkoutOrder.price));
        dBCheckoutOrder.a(a(checkoutOrder.currency));
        dBCheckoutOrder.d(a(checkoutOrder.days_to_pay));
    }

    public static void a(ResponseShopBalance responseShopBalance, ShopBalance shopBalance) {
        com.shopee.protocol.shop.ShopBalance shopBalance2 = responseShopBalance.balance;
        shopBalance.setUserId(a(shopBalance2.userid));
        shopBalance.setShopId(a(shopBalance2.shopid));
        shopBalance.setCurrency(a(shopBalance2.currency));
        shopBalance.setAvailable(a(shopBalance2.available));
        shopBalance.setFrozen(a(shopBalance2.frozen));
        shopBalance.setOther(a(shopBalance2.other));
        shopBalance.setLastWithdrawTime(a(shopBalance2.last_withdraw_time));
        shopBalance.setWithdrawLimit(a(shopBalance2.withdraw_limit));
        shopBalance.setTotalWithdrawn(a(shopBalance2.total_withdrawn));
        shopBalance.setProcessing(a(shopBalance2.processing));
        shopBalance.setCurrentMonth(a(responseShopBalance.lastmonth_income));
        shopBalance.setCurrentWeek(a(responseShopBalance.lastweek_income));
    }

    public static void a(TransHistory transHistory, DBTransaction dBTransaction, int i) {
        dBTransaction.b(a(transHistory.userid));
        dBTransaction.c(a(transHistory.shopid));
        dBTransaction.e(a(transHistory.status));
        dBTransaction.f(a(transHistory.ctime));
        dBTransaction.g(a(transHistory.mtime));
        dBTransaction.a(a(transHistory.transid));
        dBTransaction.d(a(transHistory.trans_type));
        dBTransaction.e(a(transHistory.currency));
        dBTransaction.b(a(transHistory.custom_name));
        dBTransaction.a(a(transHistory.image));
        dBTransaction.h(i);
        dBTransaction.a(a(transHistory.extinfo));
        dBTransaction.b(a(transHistory.amount));
        dBTransaction.a(a(transHistory.orderid));
        dBTransaction.d(a(transHistory.withdraw_bankacc));
        dBTransaction.c(a(transHistory.withdraw_name));
        dBTransaction.c(a(transHistory.withdraw_transfee));
        dBTransaction.i(a(transHistory.release_time));
    }

    public static void a(DBTransaction dBTransaction, DBOrderDetail dBOrderDetail, TransactionItem transactionItem) {
        transactionItem.setCustomerName(dBTransaction.d());
        transactionItem.setOrderTitle(dBOrderDetail.s());
        OrderExtInfo a2 = c.a(dBOrderDetail.G());
        ArrayList arrayList = new ArrayList();
        if (!af.a(a2.item_image)) {
            for (String split : a2.item_image) {
                arrayList.add(split.split(",")[0]);
            }
        }
        transactionItem.setImage(arrayList);
        transactionItem.setAmount(dBTransaction.e());
        transactionItem.setTime(dBTransaction.g());
        if (!(dBTransaction.a() == null || dBTransaction.a().length == 0)) {
            try {
                TransHisExtInfo transHisExtInfo = (TransHisExtInfo) f.f18486a.parseFrom(dBTransaction.a(), 0, dBTransaction.a().length, TransHisExtInfo.class);
                transactionItem.setMinTime(a(transHisExtInfo.mintime));
                transactionItem.setMaxTime(a(transHisExtInfo.maxtime));
                transactionItem.setUsingWallet(a(transHisExtInfo.using_wallet));
            } catch (IOException e2) {
                a.a(e2);
            }
        }
        transactionItem.setReleaseTime(dBTransaction.h());
        transactionItem.setShopId(dBTransaction.b());
        transactionItem.setOrderId(dBTransaction.c());
        transactionItem.setStatus(dBTransaction.f());
    }

    public static void a(Return returnR, DBReturnItem dBReturnItem) {
        dBReturnItem.a(a(returnR.return_id));
        dBReturnItem.a(a(returnR.shopid));
        dBReturnItem.b(a(returnR.userid));
        dBReturnItem.b(a(returnR.orderid));
        dBReturnItem.c(a(returnR.reason));
        dBReturnItem.e(a(returnR.ctime));
        dBReturnItem.f(a(returnR.mtime));
        dBReturnItem.b(a(returnR.currency));
        dBReturnItem.c(a(returnR.refund_amount));
        dBReturnItem.d(a(returnR.status));
        dBReturnItem.a(a(returnR.return_info));
        dBReturnItem.c(a(returnR.return_sn));
    }

    public static void a(DBReturnItem dBReturnItem, DBOrderDetail dBOrderDetail, DBReturnItem.ReturnFirstItem returnFirstItem, ItemSnapshotInfo itemSnapshotInfo, DBUserInfo dBUserInfo, ReturnItem returnItem) {
        returnItem.setReturnId(dBReturnItem.b());
        returnItem.setShopId(dBReturnItem.d());
        returnItem.setUserId(dBReturnItem.d());
        returnItem.setOrderId(dBReturnItem.c());
        returnItem.setRefundAmount(dBReturnItem.f());
        returnItem.setStatus(dBReturnItem.i());
        returnItem.setDistinctItemCount(dBReturnItem.m());
        returnItem.setTotalReturnItemCount(dBReturnItem.o());
        returnItem.setSellerDueDay(dBReturnItem.p());
        returnItem.setSelling(m.a(dBReturnItem.d()));
        returnItem.setCTime(dBReturnItem.j());
        returnItem.setMTime(dBReturnItem.k());
        returnItem.setReturnSN(dBReturnItem.g());
        if (!TextUtils.isEmpty(dBReturnItem.a())) {
            returnItem.setLogisticStatus(a(Integer.valueOf(((o) WebRegister.GSON.a(dBReturnItem.a(), o.class)).c("logistics_status").g())));
        }
        boolean z = true;
        returnItem.setNonReceipt(dBReturnItem.h() == 1);
        returnItem.setIncompleteProduct(dBReturnItem.h() == 103);
        if (!(dBOrderDetail == null || dBOrderDetail.G() == null)) {
            OrderExtInfo a2 = c.a(dBOrderDetail.G());
            returnItem.setOrderPaymentFlag(a(a2.payment_flag));
            returnItem.setOfficialShop(a(a2.official_shop));
            returnItem.setSellerId(dBOrderDetail.E());
            returnItem.setGroupBuyItem(a(a2.group_buy_groupid) > 0);
        }
        try {
            if (dBReturnItem.l() != null) {
                ReturnInfo l = dBReturnItem.l();
                returnItem.setAmountBeforeDiscount(a(l.amount_before_discount));
                List<OrderItem> list = l.item;
                if (a(l.shipping_method) <= 0) {
                    z = false;
                }
                returnItem.setSupportedShippingMethod(z);
                if (!af.a(list)) {
                    OrderItem orderItem = list.get(0);
                    if (orderItem.extinfo != null) {
                        returnItem.setFreeReturnRefundPeriod(a(((OrderItemExtInfo) f.f18486a.parseFrom(orderItem.extinfo.i(), OrderItemExtInfo.class)).free_return_day));
                    }
                }
                returnItem.setAcceptedDate(a(Integer.valueOf(dBReturnItem.k())));
                returnItem.setDeliveryDoneDate(a(l.actual_deliver_time));
                returnItem.setReturnSellerDueDate(a(l.return_seller_due_date));
                returnItem.setReturnShipDueDate(a(l.return_ship_due_date));
                returnItem.setRequestDate(a(l.requested_time));
                returnItem.setJudgingTime(a(l.judging_time));
                returnItem.setShopeeHandle(a(l.shopee_handle));
                returnItem.setTrackingNumber(a(l.tracking_number));
            }
            if (dBReturnItem.r() != null) {
                Refund refund = (Refund) f.f18486a.parseFrom(dBReturnItem.r(), Refund.class);
                if (refund != null) {
                    returnItem.setPaymentMethod(a(refund.payment_method));
                }
            }
            if (dBReturnItem.q() != null) {
                returnItem.setBankInfo(((RefundExtInfo) f.f18486a.parseFrom(dBReturnItem.q(), RefundExtInfo.class)).bank_account);
            }
            if (returnFirstItem != null) {
                returnItem.setItemPrice(returnFirstItem.f());
                returnItem.setOrderPrice(returnFirstItem.g());
                returnItem.setQuantity(returnFirstItem.h());
                returnItem.setFirstItemBundle(returnFirstItem.c());
                returnItem.isFirstItemWholesale(returnFirstItem.d());
            }
        } catch (IOException e2) {
            a.a(e2);
        }
        if (dBUserInfo != null) {
            returnItem.setUserName(dBUserInfo.i());
            returnItem.setUserAvatar(dBUserInfo.j());
        }
        if (itemSnapshotInfo != null) {
            returnItem.setFirstItemName(itemSnapshotInfo.getItemName());
            returnItem.setFirstItemImage(itemSnapshotInfo.getImages());
            returnItem.setAmountBeforeDiscount(itemSnapshotInfo.getPriceBeforeDiscount());
        }
        if (returnFirstItem != null && itemSnapshotInfo != null) {
            for (ModelDetail next : itemSnapshotInfo.getModels()) {
                if (next.getModelId() == a(returnFirstItem.e())) {
                    returnItem.setModelName(next.getName());
                }
            }
        }
    }

    public static void a(UserBrief userBrief, DBUserBrief dBUserBrief) {
        dBUserBrief.c(a(userBrief.userid));
        dBUserBrief.d(a(userBrief.shopid));
        dBUserBrief.a(a(userBrief.username));
        dBUserBrief.b(a(userBrief.portrait));
        dBUserBrief.e(a(userBrief.score));
        dBUserBrief.f(a(userBrief.products));
        dBUserBrief.c(a(userBrief.nickname));
        dBUserBrief.a(a(userBrief.followed));
        dBUserBrief.g(a(userBrief.status));
        dBUserBrief.h(a(userBrief.shopee_verified_flag));
    }

    public static void a(DBUserBrief dBUserBrief, UserBriefInfo userBriefInfo) {
        userBriefInfo.setUserId(dBUserBrief.a());
        userBriefInfo.setShopId(dBUserBrief.b());
        userBriefInfo.setUserName(dBUserBrief.c());
        userBriefInfo.setPortrait(dBUserBrief.d());
        userBriefInfo.setScore(dBUserBrief.e());
        userBriefInfo.setProductCnt(dBUserBrief.f());
        userBriefInfo.setNickName(dBUserBrief.g());
        userBriefInfo.setFollowed(dBUserBrief.h());
        userBriefInfo.setShopeeVerified(dBUserBrief.k());
    }

    public static void a(Return returnR, Refund refund, DBReturnItem dBReturnItem) {
        dBReturnItem.a(a(returnR.return_id));
        dBReturnItem.a(a(returnR.shopid));
        dBReturnItem.b(a(returnR.userid));
        dBReturnItem.b(a(returnR.orderid));
        dBReturnItem.c(a(returnR.reason));
        dBReturnItem.e(a(returnR.ctime));
        dBReturnItem.f(a(returnR.mtime));
        dBReturnItem.b(a(returnR.currency));
        dBReturnItem.c(a(returnR.refund_amount));
        dBReturnItem.d(a(returnR.status));
        dBReturnItem.a(a(returnR.return_info));
        dBReturnItem.c(a(returnR.return_sn));
        o oVar = new o();
        oVar.a("logistics_status", (Number) Integer.valueOf(a(returnR.logistics_status)));
        dBReturnItem.a(WebRegister.GSON.a((l) oVar));
        if (refund != null) {
            dBReturnItem.c(refund.toByteArray());
            dBReturnItem.b(a(refund.extinfo));
        }
    }

    public static void a(Refund refund, DBRefund dBRefund) {
        dBRefund.a(a(refund.refund_id));
        dBRefund.a(a(refund.userid));
        dBRefund.a(a(refund.userid));
        dBRefund.b(a(refund.status));
        dBRefund.b(a(refund.amount));
        dBRefund.a(a(refund.currency));
        dBRefund.b(a(refund.reason));
        dBRefund.c(a(refund.ctime));
        dBRefund.d(a(refund.mtime));
        dBRefund.c(a(refund.orderid));
        dBRefund.e(a(refund.shopid));
        dBRefund.a(a(refund.refund_id));
        dBRefund.c(a(refund.country));
        dBRefund.d(a(refund.refund_sn));
        dBRefund.d(a(refund.checkoutid));
        dBRefund.f(a(refund.payment_method));
        dBRefund.a(a(refund.extinfo));
        dBRefund.g(a(refund.bankaccount_id));
    }

    public static void a(k kVar, DBItemDetail dBItemDetail) {
        kVar.a(Long.valueOf(dBItemDetail.a()));
        kVar.b(com.shopee.app.g.e.a(dBItemDetail.h(), "IDR", true));
        kVar.a(dBItemDetail.f());
    }

    public static void a(DBUserInfo dBUserInfo, UserInfo userInfo) {
        userInfo.setUserId(dBUserInfo.d());
        userInfo.setAvatarId(dBUserInfo.j());
        userInfo.setCountry(dBUserInfo.l());
        userInfo.setPhone(dBUserInfo.b());
        userInfo.setEmail(dBUserInfo.c());
        userInfo.setShopId(dBUserInfo.e());
        userInfo.setSeller(dBUserInfo.q());
        userInfo.setPortrait(dBUserInfo.j());
        userInfo.setPhonePublic(dBUserInfo.r());
        userInfo.setEmailVerified(dBUserInfo.o());
        userInfo.setPnOption(dBUserInfo.k());
    }

    public static void a(ItemModel itemModel, IModelDetail iModelDetail) {
        iModelDetail.b(a(itemModel.currency));
        iModelDetail.b(a(itemModel.itemid));
        iModelDetail.a(a(itemModel.modelid));
        iModelDetail.a(a(itemModel.name));
        iModelDetail.c(a(itemModel.price));
        iModelDetail.a(a(itemModel.stock));
        iModelDetail.b(a(itemModel.status));
        iModelDetail.d(a(itemModel.price_before_discount));
        iModelDetail.e(a(itemModel.promotionid));
        iModelDetail.f(a(itemModel.rebate_price));
        iModelDetail.c(a(itemModel.sold));
        iModelDetail.a(a(itemModel.extinfo));
    }

    public static void a(ChatOfferInfo chatOfferInfo, ChatOfferMessage chatOfferMessage) {
        chatOfferMessage.setOfferStatus(a(chatOfferInfo.offerStatus));
        chatOfferMessage.setPrice(a(chatOfferInfo.price));
        chatOfferMessage.setCurrency(a(chatOfferInfo.currency));
        chatOfferMessage.setQuantity(a(chatOfferInfo.quantity));
        chatOfferMessage.setModelId(a(chatOfferInfo.modelid));
        chatOfferMessage.setOfferId(a(chatOfferInfo.offerid));
        chatOfferMessage.setItemId(a(chatOfferInfo.itemid));
        chatOfferMessage.setItemName(a(chatOfferInfo.item_name));
        chatOfferMessage.setModelName(a(chatOfferInfo.model_name));
        chatOfferMessage.setPriceBeforeDiscount(a(chatOfferInfo.price_before_discount));
        chatOfferMessage.setOriginalPrice(a(chatOfferInfo.original_price));
        chatOfferMessage.setImageUrl(a(chatOfferInfo.imageUrl));
        chatOfferMessage.setShopId(a(chatOfferInfo.shopid));
    }

    public static void a(DBChatMessage dBChatMessage, ChatMessage chatMessage) {
        chatMessage.setShopId(dBChatMessage.h());
        int i = 0;
        chatMessage.setRemote(dBChatMessage.d() != ((Integer) ak.a().d().b(-1)).intValue());
        chatMessage.setSendStatus(dBChatMessage.k());
        chatMessage.setRequestId(dBChatMessage.l());
        chatMessage.setTime(dBChatMessage.f());
        chatMessage.setToUserId(dBChatMessage.e());
        chatMessage.setChatId(dBChatMessage.j());
        chatMessage.setMessageId(dBChatMessage.b());
        chatMessage.setFromUserId(dBChatMessage.d());
        chatMessage.setOrderId(dBChatMessage.m());
        chatMessage.setItemId(dBChatMessage.i());
        chatMessage.setModelId(dBChatMessage.n());
        chatMessage.setPchatId(dBChatMessage.o());
        chatMessage.setTextContent(dBChatMessage.p());
        chatMessage.setGeneratedId(String.valueOf(dBChatMessage.a()));
        chatMessage.setOpt(dBChatMessage.q() < 0 ? 0 : dBChatMessage.q());
        if (dBChatMessage.s() >= 0) {
            i = dBChatMessage.s();
        }
        chatMessage.setScamOption(i);
    }

    public static void a(DBChat dBChat, DBUserBrief dBUserBrief, DBChatMessage dBChatMessage, ChatItem2 chatItem2, DBItemDetail dBItemDetail, DBOrderDetail dBOrderDetail, int i, int i2, boolean z) {
        a(dBChat, dBUserBrief, (DBShopInfo) null, dBChatMessage, chatItem2, dBItemDetail, dBOrderDetail, i, i2, z);
    }

    public static void a(DBChat dBChat, DBUserBrief dBUserBrief, DBShopInfo dBShopInfo, DBChatMessage dBChatMessage, ChatItem2 chatItem2, DBItemDetail dBItemDetail, DBOrderDetail dBOrderDetail, int i, int i2, boolean z) {
        chatItem2.setPChatId(dBChat.m());
        chatItem2.setLastMsgTime(dBChat.i());
        chatItem2.setLastMsgId(dBChat.h());
        chatItem2.setTimestamp(com.garena.android.appkit.tools.a.a.d(dBChat.i(), "ID"));
        chatItem2.setUserId(dBChat.b());
        chatItem2.setOfferCount(i2);
        if (dBUserBrief != null) {
            chatItem2.setPreviewImage("");
            chatItem2.setUserStatus(dBUserBrief.j());
            chatItem2.setUnreadCount(i);
            chatItem2.setUsername(dBUserBrief.c());
            chatItem2.setAvatar(dBUserBrief.d());
            chatItem2.setShopeeVerifiedFlag(dBUserBrief.k());
        } else {
            chatItem2.setUsername(com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder));
        }
        if (dBChatMessage != null) {
            ChatMessage a2 = a.a(dBChatMessage, z);
            chatItem2.setPreviewText(a2.getText());
            chatItem2.setLastMsgTime(a2.getTime());
            chatItem2.setTimestamp(com.garena.android.appkit.tools.a.a.d(a2.getTime(), "ID"));
            chatItem2.setItemId(a2.getItemId());
            chatItem2.setShopId(a2.getShopId());
            chatItem2.setOrderId(a2.getOrderId());
            chatItem2.setPreviewStatus(a2.getSendStatus());
        }
        if (dBItemDetail != null) {
            if (dBItemDetail.j() == 3) {
                chatItem2.setPreviewImage(ChatItem2.BANNED_IMAGE);
            } else {
                chatItem2.setPreviewImage(dBItemDetail.f());
            }
        }
        if (dBOrderDetail != null) {
            OrderDetail orderDetail = new OrderDetail();
            a(dBOrderDetail, dBUserBrief, orderDetail);
            chatItem2.setImages(orderDetail.getImages());
            chatItem2.setPreviewImage(dBOrderDetail.r());
        }
        if (dBShopInfo != null) {
            byte[] a3 = dBShopInfo.a();
            if (a3 != null && a3.length != 0) {
                try {
                    chatItem2.setShopeeVerifiedFlag(a(((ShopExtInfo) f.f18486a.parseFrom(a3, 0, a3.length, ShopExtInfo.class)).shopee_verified_flag));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void a(ShopCustomerGroup shopCustomerGroup, String str, com.shopee.app.ui.order.search.f fVar) {
        fVar.f23810a = com.shopee.app.ui.order.search.f.a(a(shopCustomerGroup.customer_type));
        fVar.f23814e = a(shopCustomerGroup.total);
        fVar.i = str;
        int i = fVar.f23810a;
        fVar.f23811b = com.garena.android.appkit.tools.b.a(i != 5 ? i != 6 ? R.string.sp_recipient_search_title : R.string.sp_order_id_search_title : R.string.sp_customer_search_title, Integer.valueOf(fVar.f23814e));
    }

    public static void a(ShopCustomerGroup shopCustomerGroup, ShopCustomer shopCustomer, String str, com.shopee.app.ui.order.search.f fVar) {
        String str2;
        fVar.f23810a = a(shopCustomerGroup.customer_type);
        if (shopCustomer.order != null) {
            fVar.f23812c = a(shopCustomer.order.orderid);
            fVar.j = a(shopCustomer.order.ordersn);
        }
        fVar.f23813d = a(shopCustomer.shipping_name);
        if (shopCustomer.user != null) {
            fVar.f23816g = a(shopCustomer.user.userid);
            if (TextUtils.isEmpty(shopCustomer.user.username)) {
                str2 = com.garena.android.appkit.tools.b.e(R.string.sp_label_deleted_user);
            } else {
                str2 = a(shopCustomer.user.username);
            }
            fVar.f23811b = str2;
            fVar.f23815f = a(shopCustomer.user.portrait);
            fVar.h = a(shopCustomer.user.shopid);
        }
        fVar.i = str;
    }

    public static void a(ItemAttribute itemAttribute, DBItemAttribute dBItemAttribute) {
        dBItemAttribute.a(a(itemAttribute.attr_id));
        dBItemAttribute.a(a(itemAttribute.name));
        dBItemAttribute.b(a(itemAttribute.input_type));
        dBItemAttribute.c(a(itemAttribute.attr_type));
        dBItemAttribute.d(a(itemAttribute.status));
        dBItemAttribute.e(a(itemAttribute.validate_type));
        dBItemAttribute.a(a(itemAttribute.extinfo));
        dBItemAttribute.f(a(itemAttribute.mandatory));
        dBItemAttribute.b(a(itemAttribute.country));
        dBItemAttribute.g(a(itemAttribute.ctime));
        dBItemAttribute.h(a(itemAttribute.mtime));
        dBItemAttribute.c(a(itemAttribute.display_name));
    }

    public static void a(DBItemAttribute dBItemAttribute, int i, byte[] bArr, VMItemAttribute vMItemAttribute) {
        vMItemAttribute.setAttrId(dBItemAttribute.a());
        vMItemAttribute.setName(dBItemAttribute.b());
        vMItemAttribute.setInputType(dBItemAttribute.c());
        vMItemAttribute.setAttrType(dBItemAttribute.d());
        vMItemAttribute.setStatus(dBItemAttribute.e());
        vMItemAttribute.setValidateType(dBItemAttribute.f());
        vMItemAttribute.setExtinfo(dBItemAttribute.g());
        vMItemAttribute.setMandatory(dBItemAttribute.h());
        vMItemAttribute.setCountry(dBItemAttribute.i());
        vMItemAttribute.setCtime(dBItemAttribute.j());
        vMItemAttribute.setMtime(dBItemAttribute.k());
        vMItemAttribute.setDisplayName(dBItemAttribute.l());
        vMItemAttribute.setSignature(bArr);
        vMItemAttribute.setModelId(i);
        if (dBItemAttribute.g() != null) {
            try {
                ItemAttributeData itemAttributeData = (ItemAttributeData) f.f18486a.parseFrom(dBItemAttribute.g(), 0, dBItemAttribute.g().length, ItemAttributeData.class);
                if (itemAttributeData != null) {
                    vMItemAttribute.setSubAttributes(itemAttributeData.value);
                    vMItemAttribute.setToolTip(a(itemAttributeData.tooltip));
                    vMItemAttribute.setPlaceHolder(a(itemAttributeData.placeholder));
                    boolean z = true;
                    if (a(itemAttributeData.mandatory_mall) != 1) {
                        z = false;
                    }
                    vMItemAttribute.setMallMandatory(z);
                }
            } catch (IOException e2) {
                a.a(e2);
            }
        }
    }

    public static void a(Integer num, List<Integer> list, DBModelAttrIdMap dBModelAttrIdMap) {
        dBModelAttrIdMap.a(a(num));
        dBModelAttrIdMap.a(list);
    }
}
