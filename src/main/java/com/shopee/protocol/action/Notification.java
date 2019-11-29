package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerOrderCntInfo;
import com.shopee.protocol.shop.SellerOrderCntInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class Notification extends Message {
    public static final Integer DEFAULT_ACTION_CATE = 0;
    public static final Long DEFAULT_ACTION_ID = 0L;
    public static final Integer DEFAULT_ACTIVITY_ID = 0;
    public static final Integer DEFAULT_ACTIVITY_TYPE = 0;
    public static final String DEFAULT_AVATAR_IMAGE = "";
    public static final String DEFAULT_BUYER_PHONE_NUMBER = "";
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Integer DEFAULT_CART_ITEM_COUNT = 0;
    public static final String DEFAULT_CHANNEL_NAME = "";
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CHAT_CLEAR_TIME = 0;
    public static final Long DEFAULT_CHAT_CLEAR_TIME_NANO = 0L;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Long DEFAULT_COIN_AMOUNT = 0L;
    public static final Integer DEFAULT_COIN_COUNT = 0;
    public static final String DEFAULT_CONSIGNMENT_ID = "";
    public static final String DEFAULT_CONTENT_IMAGE = "";
    public static final String DEFAULT_CS_PHONE = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final String DEFAULT_CUSTOM_DATA = "";
    public static final String DEFAULT_EMAIL_EXTDATA = "";
    public static final String DEFAULT_FBID = "";
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_GROUP_TYPE = 0L;
    public static final Boolean DEFAULT_HAS_MORE = false;
    public static final Integer DEFAULT_HIGH_LIGHT = 0;
    public static final String DEFAULT_HILIFE_VOUCHER = "";
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_INVOICE_ACCOUNT = "";
    public static final Long DEFAULT_INVOICE_AMOUNT = 0L;
    public static final Integer DEFAULT_INVOICE_DATE = 0;
    public static final String DEFAULT_INVOICE_NUMBER = "";
    public static final String DEFAULT_INVOICE_PIN = "";
    public static final Boolean DEFAULT_IS_GROUP_BUY = false;
    public static final Boolean DEFAULT_IS_SYS_CALL = false;
    public static final Boolean DEFAULT_IS_UNSUB = false;
    public static final Boolean DEFAULT_IS_WALLET = false;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_ITEM_NAME = "";
    public static final Integer DEFAULT_ITEM_SHOPID = 0;
    public static final String DEFAULT_JKO_BUYER_PHONE = "";
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_MODEL_NAME = "";
    public static final Integer DEFAULT_MORE_COUNT = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_NOTICODE = 0;
    public static final Integer DEFAULT_NOTIFICATION_TIME = 0;
    public static final Integer DEFAULT_NOTI_LINK_PAGE = 0;
    public static final Integer DEFAULT_NOTI_METHOD = 0;
    public static final List<Integer> DEFAULT_OFFENCE_TYPE = Collections.emptyList();
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Long DEFAULT_OFFER_PRICE = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERIDS = "";
    public static final String DEFAULT_PAYMENT_CHANNEL_NAME = "";
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_POINT = 0;
    public static final Integer DEFAULT_PROMO_TYPE = 0;
    public static final String DEFAULT_PUSH_CONTENT = "";
    public static final String DEFAULT_PUSH_REDIRECT = "";
    public static final String DEFAULT_PUSH_TITLE = "";
    public static final String DEFAULT_REACTNAIVE_VERSION = "";
    public static final List<Integer> DEFAULT_REASONS = Collections.emptyList();
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final Integer DEFAULT_SCORE = 0;
    public static final Integer DEFAULT_SENDOUT_TIME = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SIMPLE_NAV_STR = "";
    public static final Integer DEFAULT_SPECIFIED_ACTION_CATE = 0;
    public static final String DEFAULT_STORE_NAME = "";
    public static final Integer DEFAULT_TARGET_SHOPID = 0;
    public static final Integer DEFAULT_TARGET_USERID = 0;
    public static final Integer DEFAULT_TASKID = 0;
    public static final Integer DEFAULT_TIER = 0;
    public static final Long DEFAULT_TOPUP_ID = 0L;
    public static final Integer DEFAULT_TO_RATE_COUNT = 0;
    public static final String DEFAULT_TXT_MSG = "";
    public static final Integer DEFAULT_UNREG_DAYS = 0;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VOUCHER_CODE = "";
    public static final Integer DEFAULT_VOUCHER_COIN_CASHBACK_PERCENT = 0;
    public static final Integer DEFAULT_VOUCHER_DISCOUNT_PERCENT = 0;
    public static final Long DEFAULT_VOUCHER_DISCOUNT_VALUE = 0L;
    public static final Long DEFAULT_VOUCHER_MIN_SPEND = 0L;
    public static final String DEFAULT_WEB_TITLE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 38, type = Message.Datatype.INT32)
    public final Integer action_cate;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long action_id;
    @ProtoField(tag = 20)
    public final ActionInfo action_info;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer activity_id;
    @ProtoField(tag = 18)
    public final ActivityInfo activity_info;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer activity_type;
    @ProtoField(tag = 88, type = Message.Datatype.STRING)
    public final String avatar_image;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(tag = 68)
    public final BuyerOrderCntInfo buyer_ordercnt_info;
    @ProtoField(tag = 42, type = Message.Datatype.STRING)
    public final String buyer_phone_number;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer cart_item_count;
    @ProtoField(tag = 95, type = Message.Datatype.STRING)
    public final String channel_name;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer chat_clear_time;
    @ProtoField(tag = 90, type = Message.Datatype.UINT64)
    public final Long chat_clear_time_nano;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 81, type = Message.Datatype.INT64)
    public final Long coin_amount;
    @ProtoField(tag = 50, type = Message.Datatype.INT32)
    public final Integer coin_count;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String consignment_id;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String content_image;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String cs_phone;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 79, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 96, type = Message.Datatype.STRING)
    public final String custom_data;
    @ProtoField(tag = 91)
    public final DRCNotiParam drc_noti_param;
    @ProtoField(tag = 49, type = Message.Datatype.STRING)
    public final String email_extdata;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String fbid;
    @ProtoField(tag = 36, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 83, type = Message.Datatype.INT64)
    public final Long group_type;
    @ProtoField(tag = 54, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 23, type = Message.Datatype.BOOL)
    public final Boolean has_more;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer high_light;
    @ProtoField(tag = 69, type = Message.Datatype.STRING)
    public final String hilife_voucher;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 61, type = Message.Datatype.STRING)
    public final String invoice_account;
    @ProtoField(tag = 60, type = Message.Datatype.INT64)
    public final Long invoice_amount;
    @ProtoField(tag = 58, type = Message.Datatype.INT32)
    public final Integer invoice_date;
    @ProtoField(tag = 59, type = Message.Datatype.STRING)
    public final String invoice_number;
    @ProtoField(tag = 62, type = Message.Datatype.STRING)
    public final String invoice_pin;
    @ProtoField(tag = 82, type = Message.Datatype.BOOL)
    public final Boolean is_group_buy;
    @ProtoField(tag = 66, type = Message.Datatype.BOOL)
    public final Boolean is_sys_call;
    @ProtoField(tag = 55, type = Message.Datatype.BOOL)
    public final Boolean is_unsub;
    @ProtoField(tag = 51, type = Message.Datatype.BOOL)
    public final Boolean is_wallet;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String item_name;
    @ProtoField(tag = 56, type = Message.Datatype.INT32)
    public final Integer item_shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 98, type = Message.Datatype.STRING)
    public final String jko_buyer_phone;
    @ProtoField(tag = 37, type = Message.Datatype.STRING)
    public final String model_name;
    @ProtoField(tag = 32, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer more_count;
    @ProtoField(tag = 44, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 84, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer noti_link_page;
    @ProtoField(tag = 47, type = Message.Datatype.INT32)
    public final Integer noti_method;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer noticode;
    @ProtoField(tag = 70, type = Message.Datatype.INT32)
    public final Integer notification_time;
    @ProtoField(label = Message.Label.REPEATED, tag = 74, type = Message.Datatype.INT32)
    public final List<Integer> offence_type;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long offer_price;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 39, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 48, type = Message.Datatype.STRING)
    public final String orderids;
    @ProtoField(tag = 80, type = Message.Datatype.STRING)
    public final String payment_channel_name;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 71, type = Message.Datatype.INT32)
    public final Integer point;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer promo_type;
    @ProtoField(tag = 97, type = Message.Datatype.STRING)
    public final String push_content;
    @ProtoField(tag = 93, type = Message.Datatype.STRING)
    public final String push_redirect;
    @ProtoField(tag = 92, type = Message.Datatype.STRING)
    public final String push_title;
    @ProtoField(tag = 65, type = Message.Datatype.STRING)
    public final String reactnaive_version;
    @ProtoField(label = Message.Label.REPEATED, tag = 87, type = Message.Datatype.INT32)
    public final List<Integer> reasons;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 72, type = Message.Datatype.INT32)
    public final Integer score;
    @ProtoField(tag = 67)
    public final SellerOrderCntInfo seller_ordercnt_info;
    @ProtoField(tag = 30, type = Message.Datatype.INT32)
    public final Integer sendout_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String simple_nav_str;
    @ProtoField(tag = 43, type = Message.Datatype.INT32)
    public final Integer specified_action_cate;
    @ProtoField(tag = 94, type = Message.Datatype.STRING)
    public final String store_name;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer target_shopid;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer target_userid;
    @ProtoField(tag = 41, type = Message.Datatype.INT32)
    public final Integer taskid;
    @ProtoField(tag = 75, type = Message.Datatype.INT32)
    public final Integer tier;
    @ProtoField(tag = 89, type = Message.Datatype.INT32)
    public final Integer to_rate_count;
    @ProtoField(tag = 64, type = Message.Datatype.INT64)
    public final Long topup_id;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String txt_msg;
    @ProtoField(tag = 57, type = Message.Datatype.INT32)
    public final Integer unreg_days;
    @ProtoField(tag = 63, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 78, type = Message.Datatype.STRING)
    public final String voucher_code;
    @ProtoField(tag = 86, type = Message.Datatype.INT32)
    public final Integer voucher_coin_cashback_percent;
    @ProtoField(tag = 85, type = Message.Datatype.INT32)
    public final Integer voucher_discount_percent;
    @ProtoField(tag = 77, type = Message.Datatype.INT64)
    public final Long voucher_discount_value;
    @ProtoField(tag = 76, type = Message.Datatype.INT64)
    public final Long voucher_min_spend;
    @ProtoField(tag = 73, type = Message.Datatype.STRING)
    public final String web_title;

    public Notification(Long l, Integer num, Long l2, Long l3, String str, Integer num2, Integer num3, Long l4, Integer num4, Long l5, Integer num5, String str2, Integer num6, String str3, String str4, Integer num7, Integer num8, ActivityInfo activityInfo, Long l6, ActionInfo actionInfo, Long l7, Long l8, Boolean bool, Integer num9, Integer num10, Integer num11, String str5, Integer num12, String str6, Long l9, String str7, String str8, Integer num13, Long l10, String str9, Integer num14, Long l11, Integer num15, Integer num16, String str10, Integer num17, Long l12, Integer num18, Integer num19, Integer num20, String str11, String str12, Integer num21, Boolean bool2, Integer num22, Integer num23, Long l13, Boolean bool3, Integer num24, Integer num25, Integer num26, String str13, Long l14, String str14, String str15, String str16, Long l15, String str17, Boolean bool4, SellerOrderCntInfo sellerOrderCntInfo, BuyerOrderCntInfo buyerOrderCntInfo, String str18, Integer num27, Integer num28, Integer num29, String str19, List<Integer> list, Integer num30, Long l16, Long l17, String str20, String str21, String str22, Long l18, Boolean bool5, Long l19, String str23, Integer num31, Integer num32, List<Integer> list2, String str24, Integer num33, Long l20, DRCNotiParam dRCNotiParam, String str25, String str26, String str27, String str28, String str29, String str30, String str31) {
        this.id = l;
        this.noticode = num;
        this.itemid = l2;
        this.orderid = l3;
        this.item_name = str;
        this.shopid = num2;
        this.userid = num3;
        this.chatid = l4;
        this.offer_status = num4;
        this.offer_price = l5;
        this.buy_count = num5;
        this.txt_msg = str2;
        this.activity_id = num6;
        this.phone = str3;
        this.fbid = str4;
        this.high_light = num7;
        this.activity_type = num8;
        this.activity_info = activityInfo;
        this.action_id = l6;
        this.action_info = actionInfo;
        this.checkoutid = l7;
        this.return_id = l8;
        this.has_more = bool;
        this.more_count = num9;
        this.payment_method = num10;
        this.noti_link_page = num11;
        this.simple_nav_str = str5;
        this.sendout_time = num12;
        this.content_image = str6;
        this.modelid = l9;
        this.cs_phone = str7;
        this.consignment_id = str8;
        this.ctime = num13;
        this.feedid = l10;
        this.model_name = str9;
        this.action_cate = num14;
        this.offerid = l11;
        this.promo_type = num15;
        this.taskid = num16;
        this.buyer_phone_number = str10;
        this.specified_action_cate = num17;
        this.msgid = l12;
        this.cart_item_count = num18;
        this.chat_clear_time = num19;
        this.noti_method = num20;
        this.orderids = str11;
        this.email_extdata = str12;
        this.coin_count = num21;
        this.is_wallet = bool2;
        this.target_userid = num22;
        this.target_shopid = num23;
        this.groupid = l13;
        this.is_unsub = bool3;
        this.item_shopid = num24;
        this.unreg_days = num25;
        this.invoice_date = num26;
        this.invoice_number = str13;
        this.invoice_amount = l14;
        this.invoice_account = str14;
        this.invoice_pin = str15;
        this.url = str16;
        this.topup_id = l15;
        this.reactnaive_version = str17;
        this.is_sys_call = bool4;
        this.seller_ordercnt_info = sellerOrderCntInfo;
        this.buyer_ordercnt_info = buyerOrderCntInfo;
        this.hilife_voucher = str18;
        this.notification_time = num27;
        this.point = num28;
        this.score = num29;
        this.web_title = str19;
        this.offence_type = immutableCopyOf(list);
        this.tier = num30;
        this.voucher_min_spend = l16;
        this.voucher_discount_value = l17;
        this.voucher_code = str20;
        this.currency = str21;
        this.payment_channel_name = str22;
        this.coin_amount = l18;
        this.is_group_buy = bool5;
        this.group_type = l19;
        this.name = str23;
        this.voucher_discount_percent = num31;
        this.voucher_coin_cashback_percent = num32;
        this.reasons = immutableCopyOf(list2);
        this.avatar_image = str24;
        this.to_rate_count = num33;
        this.chat_clear_time_nano = l20;
        this.drc_noti_param = dRCNotiParam;
        this.push_title = str25;
        this.push_redirect = str26;
        this.store_name = str27;
        this.channel_name = str28;
        this.custom_data = str29;
        this.push_content = str30;
        this.jko_buyer_phone = str31;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Notification(com.shopee.protocol.action.Notification.Builder r100) {
        /*
            r99 = this;
            r0 = r100
            r1 = r99
            java.lang.Long r2 = r0.id
            java.lang.Integer r3 = r0.noticode
            java.lang.Long r4 = r0.itemid
            java.lang.Long r5 = r0.orderid
            java.lang.String r6 = r0.item_name
            java.lang.Integer r7 = r0.shopid
            java.lang.Integer r8 = r0.userid
            java.lang.Long r9 = r0.chatid
            java.lang.Integer r10 = r0.offer_status
            java.lang.Long r11 = r0.offer_price
            java.lang.Integer r12 = r0.buy_count
            java.lang.String r13 = r0.txt_msg
            java.lang.Integer r14 = r0.activity_id
            java.lang.String r15 = r0.phone
            r98 = r1
            java.lang.String r1 = r0.fbid
            r16 = r1
            java.lang.Integer r1 = r0.high_light
            r17 = r1
            java.lang.Integer r1 = r0.activity_type
            r18 = r1
            com.shopee.protocol.action.ActivityInfo r1 = r0.activity_info
            r19 = r1
            java.lang.Long r1 = r0.action_id
            r20 = r1
            com.shopee.protocol.action.ActionInfo r1 = r0.action_info
            r21 = r1
            java.lang.Long r1 = r0.checkoutid
            r22 = r1
            java.lang.Long r1 = r0.return_id
            r23 = r1
            java.lang.Boolean r1 = r0.has_more
            r24 = r1
            java.lang.Integer r1 = r0.more_count
            r25 = r1
            java.lang.Integer r1 = r0.payment_method
            r26 = r1
            java.lang.Integer r1 = r0.noti_link_page
            r27 = r1
            java.lang.String r1 = r0.simple_nav_str
            r28 = r1
            java.lang.Integer r1 = r0.sendout_time
            r29 = r1
            java.lang.String r1 = r0.content_image
            r30 = r1
            java.lang.Long r1 = r0.modelid
            r31 = r1
            java.lang.String r1 = r0.cs_phone
            r32 = r1
            java.lang.String r1 = r0.consignment_id
            r33 = r1
            java.lang.Integer r1 = r0.ctime
            r34 = r1
            java.lang.Long r1 = r0.feedid
            r35 = r1
            java.lang.String r1 = r0.model_name
            r36 = r1
            java.lang.Integer r1 = r0.action_cate
            r37 = r1
            java.lang.Long r1 = r0.offerid
            r38 = r1
            java.lang.Integer r1 = r0.promo_type
            r39 = r1
            java.lang.Integer r1 = r0.taskid
            r40 = r1
            java.lang.String r1 = r0.buyer_phone_number
            r41 = r1
            java.lang.Integer r1 = r0.specified_action_cate
            r42 = r1
            java.lang.Long r1 = r0.msgid
            r43 = r1
            java.lang.Integer r1 = r0.cart_item_count
            r44 = r1
            java.lang.Integer r1 = r0.chat_clear_time
            r45 = r1
            java.lang.Integer r1 = r0.noti_method
            r46 = r1
            java.lang.String r1 = r0.orderids
            r47 = r1
            java.lang.String r1 = r0.email_extdata
            r48 = r1
            java.lang.Integer r1 = r0.coin_count
            r49 = r1
            java.lang.Boolean r1 = r0.is_wallet
            r50 = r1
            java.lang.Integer r1 = r0.target_userid
            r51 = r1
            java.lang.Integer r1 = r0.target_shopid
            r52 = r1
            java.lang.Long r1 = r0.groupid
            r53 = r1
            java.lang.Boolean r1 = r0.is_unsub
            r54 = r1
            java.lang.Integer r1 = r0.item_shopid
            r55 = r1
            java.lang.Integer r1 = r0.unreg_days
            r56 = r1
            java.lang.Integer r1 = r0.invoice_date
            r57 = r1
            java.lang.String r1 = r0.invoice_number
            r58 = r1
            java.lang.Long r1 = r0.invoice_amount
            r59 = r1
            java.lang.String r1 = r0.invoice_account
            r60 = r1
            java.lang.String r1 = r0.invoice_pin
            r61 = r1
            java.lang.String r1 = r0.url
            r62 = r1
            java.lang.Long r1 = r0.topup_id
            r63 = r1
            java.lang.String r1 = r0.reactnaive_version
            r64 = r1
            java.lang.Boolean r1 = r0.is_sys_call
            r65 = r1
            com.shopee.protocol.shop.SellerOrderCntInfo r1 = r0.seller_ordercnt_info
            r66 = r1
            com.shopee.protocol.shop.BuyerOrderCntInfo r1 = r0.buyer_ordercnt_info
            r67 = r1
            java.lang.String r1 = r0.hilife_voucher
            r68 = r1
            java.lang.Integer r1 = r0.notification_time
            r69 = r1
            java.lang.Integer r1 = r0.point
            r70 = r1
            java.lang.Integer r1 = r0.score
            r71 = r1
            java.lang.String r1 = r0.web_title
            r72 = r1
            java.util.List<java.lang.Integer> r1 = r0.offence_type
            r73 = r1
            java.lang.Integer r1 = r0.tier
            r74 = r1
            java.lang.Long r1 = r0.voucher_min_spend
            r75 = r1
            java.lang.Long r1 = r0.voucher_discount_value
            r76 = r1
            java.lang.String r1 = r0.voucher_code
            r77 = r1
            java.lang.String r1 = r0.currency
            r78 = r1
            java.lang.String r1 = r0.payment_channel_name
            r79 = r1
            java.lang.Long r1 = r0.coin_amount
            r80 = r1
            java.lang.Boolean r1 = r0.is_group_buy
            r81 = r1
            java.lang.Long r1 = r0.group_type
            r82 = r1
            java.lang.String r1 = r0.name
            r83 = r1
            java.lang.Integer r1 = r0.voucher_discount_percent
            r84 = r1
            java.lang.Integer r1 = r0.voucher_coin_cashback_percent
            r85 = r1
            java.util.List<java.lang.Integer> r1 = r0.reasons
            r86 = r1
            java.lang.String r1 = r0.avatar_image
            r87 = r1
            java.lang.Integer r1 = r0.to_rate_count
            r88 = r1
            java.lang.Long r1 = r0.chat_clear_time_nano
            r89 = r1
            com.shopee.protocol.action.DRCNotiParam r1 = r0.drc_noti_param
            r90 = r1
            java.lang.String r1 = r0.push_title
            r91 = r1
            java.lang.String r1 = r0.push_redirect
            r92 = r1
            java.lang.String r1 = r0.store_name
            r93 = r1
            java.lang.String r1 = r0.channel_name
            r94 = r1
            java.lang.String r1 = r0.custom_data
            r95 = r1
            java.lang.String r1 = r0.push_content
            r96 = r1
            java.lang.String r1 = r0.jko_buyer_phone
            r97 = r1
            r1 = r98
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97)
            r99.setBuilder(r100)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.Notification.<init>(com.shopee.protocol.action.Notification$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Notification)) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (!equals((Object) this.id, (Object) notification.id) || !equals((Object) this.noticode, (Object) notification.noticode) || !equals((Object) this.itemid, (Object) notification.itemid) || !equals((Object) this.orderid, (Object) notification.orderid) || !equals((Object) this.item_name, (Object) notification.item_name) || !equals((Object) this.shopid, (Object) notification.shopid) || !equals((Object) this.userid, (Object) notification.userid) || !equals((Object) this.chatid, (Object) notification.chatid) || !equals((Object) this.offer_status, (Object) notification.offer_status) || !equals((Object) this.offer_price, (Object) notification.offer_price) || !equals((Object) this.buy_count, (Object) notification.buy_count) || !equals((Object) this.txt_msg, (Object) notification.txt_msg) || !equals((Object) this.activity_id, (Object) notification.activity_id) || !equals((Object) this.phone, (Object) notification.phone) || !equals((Object) this.fbid, (Object) notification.fbid) || !equals((Object) this.high_light, (Object) notification.high_light) || !equals((Object) this.activity_type, (Object) notification.activity_type) || !equals((Object) this.activity_info, (Object) notification.activity_info) || !equals((Object) this.action_id, (Object) notification.action_id) || !equals((Object) this.action_info, (Object) notification.action_info) || !equals((Object) this.checkoutid, (Object) notification.checkoutid) || !equals((Object) this.return_id, (Object) notification.return_id) || !equals((Object) this.has_more, (Object) notification.has_more) || !equals((Object) this.more_count, (Object) notification.more_count) || !equals((Object) this.payment_method, (Object) notification.payment_method) || !equals((Object) this.noti_link_page, (Object) notification.noti_link_page) || !equals((Object) this.simple_nav_str, (Object) notification.simple_nav_str) || !equals((Object) this.sendout_time, (Object) notification.sendout_time) || !equals((Object) this.content_image, (Object) notification.content_image) || !equals((Object) this.modelid, (Object) notification.modelid) || !equals((Object) this.cs_phone, (Object) notification.cs_phone) || !equals((Object) this.consignment_id, (Object) notification.consignment_id) || !equals((Object) this.ctime, (Object) notification.ctime) || !equals((Object) this.feedid, (Object) notification.feedid) || !equals((Object) this.model_name, (Object) notification.model_name) || !equals((Object) this.action_cate, (Object) notification.action_cate) || !equals((Object) this.offerid, (Object) notification.offerid) || !equals((Object) this.promo_type, (Object) notification.promo_type) || !equals((Object) this.taskid, (Object) notification.taskid) || !equals((Object) this.buyer_phone_number, (Object) notification.buyer_phone_number) || !equals((Object) this.specified_action_cate, (Object) notification.specified_action_cate) || !equals((Object) this.msgid, (Object) notification.msgid) || !equals((Object) this.cart_item_count, (Object) notification.cart_item_count) || !equals((Object) this.chat_clear_time, (Object) notification.chat_clear_time) || !equals((Object) this.noti_method, (Object) notification.noti_method) || !equals((Object) this.orderids, (Object) notification.orderids) || !equals((Object) this.email_extdata, (Object) notification.email_extdata) || !equals((Object) this.coin_count, (Object) notification.coin_count) || !equals((Object) this.is_wallet, (Object) notification.is_wallet) || !equals((Object) this.target_userid, (Object) notification.target_userid) || !equals((Object) this.target_shopid, (Object) notification.target_shopid) || !equals((Object) this.groupid, (Object) notification.groupid) || !equals((Object) this.is_unsub, (Object) notification.is_unsub) || !equals((Object) this.item_shopid, (Object) notification.item_shopid) || !equals((Object) this.unreg_days, (Object) notification.unreg_days) || !equals((Object) this.invoice_date, (Object) notification.invoice_date) || !equals((Object) this.invoice_number, (Object) notification.invoice_number) || !equals((Object) this.invoice_amount, (Object) notification.invoice_amount) || !equals((Object) this.invoice_account, (Object) notification.invoice_account) || !equals((Object) this.invoice_pin, (Object) notification.invoice_pin) || !equals((Object) this.url, (Object) notification.url) || !equals((Object) this.topup_id, (Object) notification.topup_id) || !equals((Object) this.reactnaive_version, (Object) notification.reactnaive_version) || !equals((Object) this.is_sys_call, (Object) notification.is_sys_call) || !equals((Object) this.seller_ordercnt_info, (Object) notification.seller_ordercnt_info) || !equals((Object) this.buyer_ordercnt_info, (Object) notification.buyer_ordercnt_info) || !equals((Object) this.hilife_voucher, (Object) notification.hilife_voucher) || !equals((Object) this.notification_time, (Object) notification.notification_time) || !equals((Object) this.point, (Object) notification.point) || !equals((Object) this.score, (Object) notification.score) || !equals((Object) this.web_title, (Object) notification.web_title) || !equals((List<?>) this.offence_type, (List<?>) notification.offence_type) || !equals((Object) this.tier, (Object) notification.tier) || !equals((Object) this.voucher_min_spend, (Object) notification.voucher_min_spend) || !equals((Object) this.voucher_discount_value, (Object) notification.voucher_discount_value) || !equals((Object) this.voucher_code, (Object) notification.voucher_code) || !equals((Object) this.currency, (Object) notification.currency) || !equals((Object) this.payment_channel_name, (Object) notification.payment_channel_name) || !equals((Object) this.coin_amount, (Object) notification.coin_amount) || !equals((Object) this.is_group_buy, (Object) notification.is_group_buy) || !equals((Object) this.group_type, (Object) notification.group_type) || !equals((Object) this.name, (Object) notification.name) || !equals((Object) this.voucher_discount_percent, (Object) notification.voucher_discount_percent) || !equals((Object) this.voucher_coin_cashback_percent, (Object) notification.voucher_coin_cashback_percent) || !equals((List<?>) this.reasons, (List<?>) notification.reasons) || !equals((Object) this.avatar_image, (Object) notification.avatar_image) || !equals((Object) this.to_rate_count, (Object) notification.to_rate_count) || !equals((Object) this.chat_clear_time_nano, (Object) notification.chat_clear_time_nano) || !equals((Object) this.drc_noti_param, (Object) notification.drc_noti_param) || !equals((Object) this.push_title, (Object) notification.push_title) || !equals((Object) this.push_redirect, (Object) notification.push_redirect) || !equals((Object) this.store_name, (Object) notification.store_name) || !equals((Object) this.channel_name, (Object) notification.channel_name) || !equals((Object) this.custom_data, (Object) notification.custom_data) || !equals((Object) this.push_content, (Object) notification.push_content) || !equals((Object) this.jko_buyer_phone, (Object) notification.jko_buyer_phone)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.noticode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.orderid;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str = this.item_name;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.chatid;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num4 = this.offer_status;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l5 = this.offer_price;
        int hashCode10 = (hashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num5 = this.buy_count;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.txt_msg;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num6 = this.activity_id;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str3 = this.phone;
        int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.fbid;
        int hashCode15 = (hashCode14 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num7 = this.high_light;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.activity_type;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        ActivityInfo activityInfo = this.activity_info;
        int hashCode18 = (hashCode17 + (activityInfo != null ? activityInfo.hashCode() : 0)) * 37;
        Long l6 = this.action_id;
        int hashCode19 = (hashCode18 + (l6 != null ? l6.hashCode() : 0)) * 37;
        ActionInfo actionInfo = this.action_info;
        int hashCode20 = (hashCode19 + (actionInfo != null ? actionInfo.hashCode() : 0)) * 37;
        Long l7 = this.checkoutid;
        int hashCode21 = (hashCode20 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.return_id;
        int hashCode22 = (hashCode21 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Boolean bool = this.has_more;
        int hashCode23 = (hashCode22 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num9 = this.more_count;
        int hashCode24 = (hashCode23 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.payment_method;
        int hashCode25 = (hashCode24 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.noti_link_page;
        int hashCode26 = (hashCode25 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str5 = this.simple_nav_str;
        int hashCode27 = (hashCode26 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num12 = this.sendout_time;
        int hashCode28 = (hashCode27 + (num12 != null ? num12.hashCode() : 0)) * 37;
        String str6 = this.content_image;
        int hashCode29 = (hashCode28 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Long l9 = this.modelid;
        int hashCode30 = (hashCode29 + (l9 != null ? l9.hashCode() : 0)) * 37;
        String str7 = this.cs_phone;
        int hashCode31 = (hashCode30 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.consignment_id;
        int hashCode32 = (hashCode31 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num13 = this.ctime;
        int hashCode33 = (hashCode32 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Long l10 = this.feedid;
        int hashCode34 = (hashCode33 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str9 = this.model_name;
        int hashCode35 = (hashCode34 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num14 = this.action_cate;
        int hashCode36 = (hashCode35 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Long l11 = this.offerid;
        int hashCode37 = (hashCode36 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Integer num15 = this.promo_type;
        int hashCode38 = (hashCode37 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.taskid;
        int hashCode39 = (hashCode38 + (num16 != null ? num16.hashCode() : 0)) * 37;
        String str10 = this.buyer_phone_number;
        int hashCode40 = (hashCode39 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num17 = this.specified_action_cate;
        int hashCode41 = (hashCode40 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Long l12 = this.msgid;
        int hashCode42 = (hashCode41 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Integer num18 = this.cart_item_count;
        int hashCode43 = (hashCode42 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.chat_clear_time;
        int hashCode44 = (hashCode43 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.noti_method;
        int hashCode45 = (hashCode44 + (num20 != null ? num20.hashCode() : 0)) * 37;
        String str11 = this.orderids;
        int hashCode46 = (hashCode45 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.email_extdata;
        int hashCode47 = (hashCode46 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num21 = this.coin_count;
        int hashCode48 = (hashCode47 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_wallet;
        int hashCode49 = (hashCode48 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num22 = this.target_userid;
        int hashCode50 = (hashCode49 + (num22 != null ? num22.hashCode() : 0)) * 37;
        Integer num23 = this.target_shopid;
        int hashCode51 = (hashCode50 + (num23 != null ? num23.hashCode() : 0)) * 37;
        Long l13 = this.groupid;
        int hashCode52 = (hashCode51 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_unsub;
        int hashCode53 = (hashCode52 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num24 = this.item_shopid;
        int hashCode54 = (hashCode53 + (num24 != null ? num24.hashCode() : 0)) * 37;
        Integer num25 = this.unreg_days;
        int hashCode55 = (hashCode54 + (num25 != null ? num25.hashCode() : 0)) * 37;
        Integer num26 = this.invoice_date;
        int hashCode56 = (hashCode55 + (num26 != null ? num26.hashCode() : 0)) * 37;
        String str13 = this.invoice_number;
        int hashCode57 = (hashCode56 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Long l14 = this.invoice_amount;
        int hashCode58 = (hashCode57 + (l14 != null ? l14.hashCode() : 0)) * 37;
        String str14 = this.invoice_account;
        int hashCode59 = (hashCode58 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.invoice_pin;
        int hashCode60 = (hashCode59 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.url;
        int hashCode61 = (hashCode60 + (str16 != null ? str16.hashCode() : 0)) * 37;
        Long l15 = this.topup_id;
        int hashCode62 = (hashCode61 + (l15 != null ? l15.hashCode() : 0)) * 37;
        String str17 = this.reactnaive_version;
        int hashCode63 = (hashCode62 + (str17 != null ? str17.hashCode() : 0)) * 37;
        Boolean bool4 = this.is_sys_call;
        int hashCode64 = (hashCode63 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        SellerOrderCntInfo sellerOrderCntInfo = this.seller_ordercnt_info;
        int hashCode65 = (hashCode64 + (sellerOrderCntInfo != null ? sellerOrderCntInfo.hashCode() : 0)) * 37;
        BuyerOrderCntInfo buyerOrderCntInfo = this.buyer_ordercnt_info;
        int hashCode66 = (hashCode65 + (buyerOrderCntInfo != null ? buyerOrderCntInfo.hashCode() : 0)) * 37;
        String str18 = this.hilife_voucher;
        int hashCode67 = (hashCode66 + (str18 != null ? str18.hashCode() : 0)) * 37;
        Integer num27 = this.notification_time;
        int hashCode68 = (hashCode67 + (num27 != null ? num27.hashCode() : 0)) * 37;
        Integer num28 = this.point;
        int hashCode69 = (hashCode68 + (num28 != null ? num28.hashCode() : 0)) * 37;
        Integer num29 = this.score;
        int hashCode70 = (hashCode69 + (num29 != null ? num29.hashCode() : 0)) * 37;
        String str19 = this.web_title;
        int hashCode71 = (hashCode70 + (str19 != null ? str19.hashCode() : 0)) * 37;
        List<Integer> list = this.offence_type;
        int i3 = 1;
        int hashCode72 = (hashCode71 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num30 = this.tier;
        int hashCode73 = (hashCode72 + (num30 != null ? num30.hashCode() : 0)) * 37;
        Long l16 = this.voucher_min_spend;
        int hashCode74 = (hashCode73 + (l16 != null ? l16.hashCode() : 0)) * 37;
        Long l17 = this.voucher_discount_value;
        int hashCode75 = (hashCode74 + (l17 != null ? l17.hashCode() : 0)) * 37;
        String str20 = this.voucher_code;
        int hashCode76 = (hashCode75 + (str20 != null ? str20.hashCode() : 0)) * 37;
        String str21 = this.currency;
        int hashCode77 = (hashCode76 + (str21 != null ? str21.hashCode() : 0)) * 37;
        String str22 = this.payment_channel_name;
        int hashCode78 = (hashCode77 + (str22 != null ? str22.hashCode() : 0)) * 37;
        Long l18 = this.coin_amount;
        int hashCode79 = (hashCode78 + (l18 != null ? l18.hashCode() : 0)) * 37;
        Boolean bool5 = this.is_group_buy;
        int hashCode80 = (hashCode79 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Long l19 = this.group_type;
        int hashCode81 = (hashCode80 + (l19 != null ? l19.hashCode() : 0)) * 37;
        String str23 = this.name;
        int hashCode82 = (hashCode81 + (str23 != null ? str23.hashCode() : 0)) * 37;
        Integer num31 = this.voucher_discount_percent;
        int hashCode83 = (hashCode82 + (num31 != null ? num31.hashCode() : 0)) * 37;
        Integer num32 = this.voucher_coin_cashback_percent;
        int hashCode84 = (hashCode83 + (num32 != null ? num32.hashCode() : 0)) * 37;
        List<Integer> list2 = this.reasons;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode84 + i3) * 37;
        String str24 = this.avatar_image;
        int hashCode85 = (i4 + (str24 != null ? str24.hashCode() : 0)) * 37;
        Integer num33 = this.to_rate_count;
        int hashCode86 = (hashCode85 + (num33 != null ? num33.hashCode() : 0)) * 37;
        Long l20 = this.chat_clear_time_nano;
        int hashCode87 = (hashCode86 + (l20 != null ? l20.hashCode() : 0)) * 37;
        DRCNotiParam dRCNotiParam = this.drc_noti_param;
        int hashCode88 = (hashCode87 + (dRCNotiParam != null ? dRCNotiParam.hashCode() : 0)) * 37;
        String str25 = this.push_title;
        int hashCode89 = (hashCode88 + (str25 != null ? str25.hashCode() : 0)) * 37;
        String str26 = this.push_redirect;
        int hashCode90 = (hashCode89 + (str26 != null ? str26.hashCode() : 0)) * 37;
        String str27 = this.store_name;
        int hashCode91 = (hashCode90 + (str27 != null ? str27.hashCode() : 0)) * 37;
        String str28 = this.channel_name;
        int hashCode92 = (hashCode91 + (str28 != null ? str28.hashCode() : 0)) * 37;
        String str29 = this.custom_data;
        int hashCode93 = (hashCode92 + (str29 != null ? str29.hashCode() : 0)) * 37;
        String str30 = this.push_content;
        int hashCode94 = (hashCode93 + (str30 != null ? str30.hashCode() : 0)) * 37;
        String str31 = this.jko_buyer_phone;
        if (str31 != null) {
            i2 = str31.hashCode();
        }
        int i5 = hashCode94 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<Notification> {
        public Integer action_cate;
        public Long action_id;
        public ActionInfo action_info;
        public Integer activity_id;
        public ActivityInfo activity_info;
        public Integer activity_type;
        public String avatar_image;
        public Integer buy_count;
        public BuyerOrderCntInfo buyer_ordercnt_info;
        public String buyer_phone_number;
        public Integer cart_item_count;
        public String channel_name;
        public Integer chat_clear_time;
        public Long chat_clear_time_nano;
        public Long chatid;
        public Long checkoutid;
        public Long coin_amount;
        public Integer coin_count;
        public String consignment_id;
        public String content_image;
        public String cs_phone;
        public Integer ctime;
        public String currency;
        public String custom_data;
        public DRCNotiParam drc_noti_param;
        public String email_extdata;
        public String fbid;
        public Long feedid;
        public Long group_type;
        public Long groupid;
        public Boolean has_more;
        public Integer high_light;
        public String hilife_voucher;
        public Long id;
        public String invoice_account;
        public Long invoice_amount;
        public Integer invoice_date;
        public String invoice_number;
        public String invoice_pin;
        public Boolean is_group_buy;
        public Boolean is_sys_call;
        public Boolean is_unsub;
        public Boolean is_wallet;
        public String item_name;
        public Integer item_shopid;
        public Long itemid;
        public String jko_buyer_phone;
        public String model_name;
        public Long modelid;
        public Integer more_count;
        public Long msgid;
        public String name;
        public Integer noti_link_page;
        public Integer noti_method;
        public Integer noticode;
        public Integer notification_time;
        public List<Integer> offence_type;
        public Long offer_price;
        public Integer offer_status;
        public Long offerid;
        public Long orderid;
        public String orderids;
        public String payment_channel_name;
        public Integer payment_method;
        public String phone;
        public Integer point;
        public Integer promo_type;
        public String push_content;
        public String push_redirect;
        public String push_title;
        public String reactnaive_version;
        public List<Integer> reasons;
        public Long return_id;
        public Integer score;
        public SellerOrderCntInfo seller_ordercnt_info;
        public Integer sendout_time;
        public Integer shopid;
        public String simple_nav_str;
        public Integer specified_action_cate;
        public String store_name;
        public Integer target_shopid;
        public Integer target_userid;
        public Integer taskid;
        public Integer tier;
        public Integer to_rate_count;
        public Long topup_id;
        public String txt_msg;
        public Integer unreg_days;
        public String url;
        public Integer userid;
        public String voucher_code;
        public Integer voucher_coin_cashback_percent;
        public Integer voucher_discount_percent;
        public Long voucher_discount_value;
        public Long voucher_min_spend;
        public String web_title;

        public Builder() {
        }

        public Builder(Notification notification) {
            super(notification);
            if (notification != null) {
                this.id = notification.id;
                this.noticode = notification.noticode;
                this.itemid = notification.itemid;
                this.orderid = notification.orderid;
                this.item_name = notification.item_name;
                this.shopid = notification.shopid;
                this.userid = notification.userid;
                this.chatid = notification.chatid;
                this.offer_status = notification.offer_status;
                this.offer_price = notification.offer_price;
                this.buy_count = notification.buy_count;
                this.txt_msg = notification.txt_msg;
                this.activity_id = notification.activity_id;
                this.phone = notification.phone;
                this.fbid = notification.fbid;
                this.high_light = notification.high_light;
                this.activity_type = notification.activity_type;
                this.activity_info = notification.activity_info;
                this.action_id = notification.action_id;
                this.action_info = notification.action_info;
                this.checkoutid = notification.checkoutid;
                this.return_id = notification.return_id;
                this.has_more = notification.has_more;
                this.more_count = notification.more_count;
                this.payment_method = notification.payment_method;
                this.noti_link_page = notification.noti_link_page;
                this.simple_nav_str = notification.simple_nav_str;
                this.sendout_time = notification.sendout_time;
                this.content_image = notification.content_image;
                this.modelid = notification.modelid;
                this.cs_phone = notification.cs_phone;
                this.consignment_id = notification.consignment_id;
                this.ctime = notification.ctime;
                this.feedid = notification.feedid;
                this.model_name = notification.model_name;
                this.action_cate = notification.action_cate;
                this.offerid = notification.offerid;
                this.promo_type = notification.promo_type;
                this.taskid = notification.taskid;
                this.buyer_phone_number = notification.buyer_phone_number;
                this.specified_action_cate = notification.specified_action_cate;
                this.msgid = notification.msgid;
                this.cart_item_count = notification.cart_item_count;
                this.chat_clear_time = notification.chat_clear_time;
                this.noti_method = notification.noti_method;
                this.orderids = notification.orderids;
                this.email_extdata = notification.email_extdata;
                this.coin_count = notification.coin_count;
                this.is_wallet = notification.is_wallet;
                this.target_userid = notification.target_userid;
                this.target_shopid = notification.target_shopid;
                this.groupid = notification.groupid;
                this.is_unsub = notification.is_unsub;
                this.item_shopid = notification.item_shopid;
                this.unreg_days = notification.unreg_days;
                this.invoice_date = notification.invoice_date;
                this.invoice_number = notification.invoice_number;
                this.invoice_amount = notification.invoice_amount;
                this.invoice_account = notification.invoice_account;
                this.invoice_pin = notification.invoice_pin;
                this.url = notification.url;
                this.topup_id = notification.topup_id;
                this.reactnaive_version = notification.reactnaive_version;
                this.is_sys_call = notification.is_sys_call;
                this.seller_ordercnt_info = notification.seller_ordercnt_info;
                this.buyer_ordercnt_info = notification.buyer_ordercnt_info;
                this.hilife_voucher = notification.hilife_voucher;
                this.notification_time = notification.notification_time;
                this.point = notification.point;
                this.score = notification.score;
                this.web_title = notification.web_title;
                this.offence_type = Notification.copyOf(notification.offence_type);
                this.tier = notification.tier;
                this.voucher_min_spend = notification.voucher_min_spend;
                this.voucher_discount_value = notification.voucher_discount_value;
                this.voucher_code = notification.voucher_code;
                this.currency = notification.currency;
                this.payment_channel_name = notification.payment_channel_name;
                this.coin_amount = notification.coin_amount;
                this.is_group_buy = notification.is_group_buy;
                this.group_type = notification.group_type;
                this.name = notification.name;
                this.voucher_discount_percent = notification.voucher_discount_percent;
                this.voucher_coin_cashback_percent = notification.voucher_coin_cashback_percent;
                this.reasons = Notification.copyOf(notification.reasons);
                this.avatar_image = notification.avatar_image;
                this.to_rate_count = notification.to_rate_count;
                this.chat_clear_time_nano = notification.chat_clear_time_nano;
                this.drc_noti_param = notification.drc_noti_param;
                this.push_title = notification.push_title;
                this.push_redirect = notification.push_redirect;
                this.store_name = notification.store_name;
                this.channel_name = notification.channel_name;
                this.custom_data = notification.custom_data;
                this.push_content = notification.push_content;
                this.jko_buyer_phone = notification.jko_buyer_phone;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder noticode(Integer num) {
            this.noticode = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder item_name(String str) {
            this.item_name = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder offer_status(Integer num) {
            this.offer_status = num;
            return this;
        }

        public Builder offer_price(Long l) {
            this.offer_price = l;
            return this;
        }

        public Builder buy_count(Integer num) {
            this.buy_count = num;
            return this;
        }

        public Builder txt_msg(String str) {
            this.txt_msg = str;
            return this;
        }

        public Builder activity_id(Integer num) {
            this.activity_id = num;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder fbid(String str) {
            this.fbid = str;
            return this;
        }

        public Builder high_light(Integer num) {
            this.high_light = num;
            return this;
        }

        public Builder activity_type(Integer num) {
            this.activity_type = num;
            return this;
        }

        public Builder activity_info(ActivityInfo activityInfo) {
            this.activity_info = activityInfo;
            return this;
        }

        public Builder action_id(Long l) {
            this.action_id = l;
            return this;
        }

        public Builder action_info(ActionInfo actionInfo) {
            this.action_info = actionInfo;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder has_more(Boolean bool) {
            this.has_more = bool;
            return this;
        }

        public Builder more_count(Integer num) {
            this.more_count = num;
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder noti_link_page(Integer num) {
            this.noti_link_page = num;
            return this;
        }

        public Builder simple_nav_str(String str) {
            this.simple_nav_str = str;
            return this;
        }

        public Builder sendout_time(Integer num) {
            this.sendout_time = num;
            return this;
        }

        public Builder content_image(String str) {
            this.content_image = str;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder cs_phone(String str) {
            this.cs_phone = str;
            return this;
        }

        public Builder consignment_id(String str) {
            this.consignment_id = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder model_name(String str) {
            this.model_name = str;
            return this;
        }

        public Builder action_cate(Integer num) {
            this.action_cate = num;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder promo_type(Integer num) {
            this.promo_type = num;
            return this;
        }

        public Builder taskid(Integer num) {
            this.taskid = num;
            return this;
        }

        public Builder buyer_phone_number(String str) {
            this.buyer_phone_number = str;
            return this;
        }

        public Builder specified_action_cate(Integer num) {
            this.specified_action_cate = num;
            return this;
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder cart_item_count(Integer num) {
            this.cart_item_count = num;
            return this;
        }

        public Builder chat_clear_time(Integer num) {
            this.chat_clear_time = num;
            return this;
        }

        public Builder noti_method(Integer num) {
            this.noti_method = num;
            return this;
        }

        public Builder orderids(String str) {
            this.orderids = str;
            return this;
        }

        public Builder email_extdata(String str) {
            this.email_extdata = str;
            return this;
        }

        public Builder coin_count(Integer num) {
            this.coin_count = num;
            return this;
        }

        public Builder is_wallet(Boolean bool) {
            this.is_wallet = bool;
            return this;
        }

        public Builder target_userid(Integer num) {
            this.target_userid = num;
            return this;
        }

        public Builder target_shopid(Integer num) {
            this.target_shopid = num;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder is_unsub(Boolean bool) {
            this.is_unsub = bool;
            return this;
        }

        public Builder item_shopid(Integer num) {
            this.item_shopid = num;
            return this;
        }

        public Builder unreg_days(Integer num) {
            this.unreg_days = num;
            return this;
        }

        public Builder invoice_date(Integer num) {
            this.invoice_date = num;
            return this;
        }

        public Builder invoice_number(String str) {
            this.invoice_number = str;
            return this;
        }

        public Builder invoice_amount(Long l) {
            this.invoice_amount = l;
            return this;
        }

        public Builder invoice_account(String str) {
            this.invoice_account = str;
            return this;
        }

        public Builder invoice_pin(String str) {
            this.invoice_pin = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder topup_id(Long l) {
            this.topup_id = l;
            return this;
        }

        public Builder reactnaive_version(String str) {
            this.reactnaive_version = str;
            return this;
        }

        public Builder is_sys_call(Boolean bool) {
            this.is_sys_call = bool;
            return this;
        }

        public Builder seller_ordercnt_info(SellerOrderCntInfo sellerOrderCntInfo) {
            this.seller_ordercnt_info = sellerOrderCntInfo;
            return this;
        }

        public Builder buyer_ordercnt_info(BuyerOrderCntInfo buyerOrderCntInfo) {
            this.buyer_ordercnt_info = buyerOrderCntInfo;
            return this;
        }

        public Builder hilife_voucher(String str) {
            this.hilife_voucher = str;
            return this;
        }

        public Builder notification_time(Integer num) {
            this.notification_time = num;
            return this;
        }

        public Builder point(Integer num) {
            this.point = num;
            return this;
        }

        public Builder score(Integer num) {
            this.score = num;
            return this;
        }

        public Builder web_title(String str) {
            this.web_title = str;
            return this;
        }

        public Builder offence_type(List<Integer> list) {
            this.offence_type = checkForNulls(list);
            return this;
        }

        public Builder tier(Integer num) {
            this.tier = num;
            return this;
        }

        public Builder voucher_min_spend(Long l) {
            this.voucher_min_spend = l;
            return this;
        }

        public Builder voucher_discount_value(Long l) {
            this.voucher_discount_value = l;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder payment_channel_name(String str) {
            this.payment_channel_name = str;
            return this;
        }

        public Builder coin_amount(Long l) {
            this.coin_amount = l;
            return this;
        }

        public Builder is_group_buy(Boolean bool) {
            this.is_group_buy = bool;
            return this;
        }

        public Builder group_type(Long l) {
            this.group_type = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder voucher_discount_percent(Integer num) {
            this.voucher_discount_percent = num;
            return this;
        }

        public Builder voucher_coin_cashback_percent(Integer num) {
            this.voucher_coin_cashback_percent = num;
            return this;
        }

        public Builder reasons(List<Integer> list) {
            this.reasons = checkForNulls(list);
            return this;
        }

        public Builder avatar_image(String str) {
            this.avatar_image = str;
            return this;
        }

        public Builder to_rate_count(Integer num) {
            this.to_rate_count = num;
            return this;
        }

        public Builder chat_clear_time_nano(Long l) {
            this.chat_clear_time_nano = l;
            return this;
        }

        public Builder drc_noti_param(DRCNotiParam dRCNotiParam) {
            this.drc_noti_param = dRCNotiParam;
            return this;
        }

        public Builder push_title(String str) {
            this.push_title = str;
            return this;
        }

        public Builder push_redirect(String str) {
            this.push_redirect = str;
            return this;
        }

        public Builder store_name(String str) {
            this.store_name = str;
            return this;
        }

        public Builder channel_name(String str) {
            this.channel_name = str;
            return this;
        }

        public Builder custom_data(String str) {
            this.custom_data = str;
            return this;
        }

        public Builder push_content(String str) {
            this.push_content = str;
            return this;
        }

        public Builder jko_buyer_phone(String str) {
            this.jko_buyer_phone = str;
            return this;
        }

        public Notification build() {
            checkRequiredFields();
            return new Notification(this);
        }
    }
}
