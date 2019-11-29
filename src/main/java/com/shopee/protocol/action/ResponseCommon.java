package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.shopee.protocol.shop.FbAccountInfo;
import com.shopee.protocol.shop.ItemModel;
import com.shopee.protocol.shop.ShopBoost;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCommon extends Message {
    public static final Integer DEFAULT_ADDRID = 0;
    public static final Integer DEFAULT_AUDITID = 0;
    public static final Integer DEFAULT_BEHAVIOR_CHECK_ERRCODE = 0;
    public static final Long DEFAULT_CHATID = 0L;
    public static final Long DEFAULT_CMTID = 0L;
    public static final List<CmtidCoin> DEFAULT_CMTIDCOINLIST = Collections.emptyList();
    public static final Long DEFAULT_COIN_BALANCE = 0L;
    public static final Integer DEFAULT_COIN_RULE_ID = 0;
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Integer DEFAULT_COUNT = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_DAYS = 0;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final List<DistributeVoucherError> DEFAULT_DISTRIBUTE_VOUCHER_ERROR = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Integer DEFAULT_EXPIRE_TIME = 0;
    public static final Integer DEFAULT_IS_USERINFO_COMPLETE = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_ITEM_LIMIT = 0;
    public static final Integer DEFAULT_MINAPPVERSION = 0;
    public static final List<Long> DEFAULT_MODELID = Collections.emptyList();
    public static final List<ItemModel> DEFAULT_MODELS = Collections.emptyList();
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_MSG_OPT = 0;
    public static final String DEFAULT_M_TOKEN = "";
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    public static final Integer DEFAULT_ORDER_STATUS = 0;
    public static final List<Integer> DEFAULT_OTP_AVAILABLE_CHANNELS = Collections.emptyList();
    public static final Integer DEFAULT_OTP_DELIVERY_CHANNEL = 0;
    public static final String DEFAULT_OTP_TOKEN = "";
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Boolean DEFAULT_PHONE_AUTO_CONVERTED = false;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final List<SellerPromotionFailedItem> DEFAULT_PROMOTION_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REDIRECT_URL = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_RETRY_LEFT = 0;
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_RISK_CONTROL_PASSWORD_TOKEN = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SHOP_COLLECTION_ID = 0L;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final String DEFAULT_TAX_ADDRESS = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_VCODE_TOKEN = "";
    public static final Integer DEFAULT_WELCOME_PACKAGE_ERR = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12)
    public final Account acc;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer addrid;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer auditid;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer behavior_check_errcode;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(label = Message.Label.REPEATED, messageType = CmtidCoin.class, tag = 46)
    public final List<CmtidCoin> cmtidCoinList;
    @ProtoField(tag = 43, type = Message.Datatype.INT64)
    public final Long coin_balance;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer coin_rule_id;
    @ProtoField(tag = 50, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer days;
    @ProtoField(tag = 41, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(label = Message.Label.REPEATED, messageType = DistributeVoucherError.class, tag = 40)
    public final List<DistributeVoucherError> distribute_voucher_error;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer expire_time;
    @ProtoField(tag = 31)
    public final FbAccountInfo fbacc;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer is_userinfo_complete;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer item_limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 38, type = Message.Datatype.STRING)
    public final String m_token;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer minappversion;
    @ProtoField(label = Message.Label.REPEATED, tag = 8, type = Message.Datatype.INT64)
    public final List<Long> modelid;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemModel.class, tag = 13)
    public final List<ItemModel> models;
    @ProtoField(tag = 47, type = Message.Datatype.INT32)
    public final Integer msg_opt;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 32, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 27)
    public final OrderWithInfo order;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer order_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(label = Message.Label.REPEATED, tag = 54, type = Message.Datatype.INT32)
    public final List<Integer> otp_available_channels;
    @ProtoField(tag = 53, type = Message.Datatype.INT32)
    public final Integer otp_delivery_channel;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String otp_token;
    @ProtoField(tag = 33, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 48, type = Message.Datatype.BOOL)
    public final Boolean phone_auto_converted;
    @ProtoField(label = Message.Label.REPEATED, messageType = SellerPromotionFailedItem.class, tag = 51)
    public final List<SellerPromotionFailedItem> promotion_items;
    @ProtoField(tag = 25, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String redirect_url;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer retry_left;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 49, type = Message.Datatype.STRING)
    public final String risk_control_password_token;
    @ProtoField(tag = 37)
    public final ShopBoost shop_boost;
    @ProtoField(tag = 34, type = Message.Datatype.INT64)
    public final Long shop_collection_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 20, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 42, type = Message.Datatype.STRING)
    public final String tax_address;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 30, type = Message.Datatype.STRING)
    public final String vcode_token;
    @ProtoField(tag = 44, type = Message.Datatype.INT32)
    public final Integer welcome_package_err;

    public ResponseCommon(String str, Integer num, Long l, Integer num2, Long l2, Integer num3, String str2, List<Long> list, Long l3, Integer num4, String str3, Account account, List<ItemModel> list2, Integer num5, String str4, Integer num6, Integer num7, Long l4, Long l5, Long l6, Integer num8, Long l7, Integer num9, Integer num10, Long l8, String str5, OrderWithInfo orderWithInfo, Integer num11, String str6, String str7, FbAccountInfo fbAccountInfo, Long l9, Long l10, Long l11, Integer num12, Integer num13, ShopBoost shopBoost, String str8, String str9, List<DistributeVoucherError> list3, String str10, String str11, Long l12, Integer num14, Integer num15, List<CmtidCoin> list4, Integer num16, Boolean bool, String str12, Integer num17, List<SellerPromotionFailedItem> list5, Integer num18, Integer num19, List<Integer> list6, Integer num20) {
        this.requestid = str;
        this.errcode = num;
        this.itemid = l;
        this.shopid = num2;
        this.orderid = l2;
        this.userid = num3;
        this.ordersn = str2;
        this.modelid = immutableCopyOf(list);
        this.chatid = l3;
        this.minappversion = num4;
        this.country = str3;
        this.acc = account;
        this.models = immutableCopyOf(list2);
        this.timestamp = num5;
        this.token = str4;
        this.order_status = num6;
        this.addrid = num7;
        this.msgid = l4;
        this.cmtid = l5;
        this.snapshotid = l6;
        this.count = num8;
        this.return_id = l7;
        this.days = num9;
        this.auditid = num10;
        this.promotionid = l8;
        this.err_message = str5;
        this.order = orderWithInfo;
        this.is_userinfo_complete = num11;
        this.redirect_url = str6;
        this.vcode_token = str7;
        this.fbacc = fbAccountInfo;
        this.offerid = l9;
        this.pchatid = l10;
        this.shop_collection_id = l11;
        this.coin_rule_id = num12;
        this.behavior_check_errcode = num13;
        this.shop_boost = shopBoost;
        this.m_token = str8;
        this.otp_token = str9;
        this.distribute_voucher_error = immutableCopyOf(list3);
        this.debug_msg = str10;
        this.tax_address = str11;
        this.coin_balance = l12;
        this.welcome_package_err = num14;
        this.item_limit = num15;
        this.cmtidCoinList = immutableCopyOf(list4);
        this.msg_opt = num16;
        this.phone_auto_converted = bool;
        this.risk_control_password_token = str12;
        this.collection_id = num17;
        this.promotion_items = immutableCopyOf(list5);
        this.retry_left = num18;
        this.otp_delivery_channel = num19;
        this.otp_available_channels = immutableCopyOf(list6);
        this.expire_time = num20;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ResponseCommon(com.shopee.protocol.action.ResponseCommon.Builder r59) {
        /*
            r58 = this;
            r0 = r59
            r1 = r58
            java.lang.String r2 = r0.requestid
            java.lang.Integer r3 = r0.errcode
            java.lang.Long r4 = r0.itemid
            java.lang.Integer r5 = r0.shopid
            java.lang.Long r6 = r0.orderid
            java.lang.Integer r7 = r0.userid
            java.lang.String r8 = r0.ordersn
            java.util.List<java.lang.Long> r9 = r0.modelid
            java.lang.Long r10 = r0.chatid
            java.lang.Integer r11 = r0.minappversion
            java.lang.String r12 = r0.country
            com.shopee.protocol.shop.Account r13 = r0.acc
            java.util.List<com.shopee.protocol.shop.ItemModel> r14 = r0.models
            java.lang.Integer r15 = r0.timestamp
            r57 = r1
            java.lang.String r1 = r0.token
            r16 = r1
            java.lang.Integer r1 = r0.order_status
            r17 = r1
            java.lang.Integer r1 = r0.addrid
            r18 = r1
            java.lang.Long r1 = r0.msgid
            r19 = r1
            java.lang.Long r1 = r0.cmtid
            r20 = r1
            java.lang.Long r1 = r0.snapshotid
            r21 = r1
            java.lang.Integer r1 = r0.count
            r22 = r1
            java.lang.Long r1 = r0.return_id
            r23 = r1
            java.lang.Integer r1 = r0.days
            r24 = r1
            java.lang.Integer r1 = r0.auditid
            r25 = r1
            java.lang.Long r1 = r0.promotionid
            r26 = r1
            java.lang.String r1 = r0.err_message
            r27 = r1
            com.shopee.protocol.action.OrderWithInfo r1 = r0.order
            r28 = r1
            java.lang.Integer r1 = r0.is_userinfo_complete
            r29 = r1
            java.lang.String r1 = r0.redirect_url
            r30 = r1
            java.lang.String r1 = r0.vcode_token
            r31 = r1
            com.shopee.protocol.shop.FbAccountInfo r1 = r0.fbacc
            r32 = r1
            java.lang.Long r1 = r0.offerid
            r33 = r1
            java.lang.Long r1 = r0.pchatid
            r34 = r1
            java.lang.Long r1 = r0.shop_collection_id
            r35 = r1
            java.lang.Integer r1 = r0.coin_rule_id
            r36 = r1
            java.lang.Integer r1 = r0.behavior_check_errcode
            r37 = r1
            com.shopee.protocol.shop.ShopBoost r1 = r0.shop_boost
            r38 = r1
            java.lang.String r1 = r0.m_token
            r39 = r1
            java.lang.String r1 = r0.otp_token
            r40 = r1
            java.util.List<com.shopee.protocol.action.DistributeVoucherError> r1 = r0.distribute_voucher_error
            r41 = r1
            java.lang.String r1 = r0.debug_msg
            r42 = r1
            java.lang.String r1 = r0.tax_address
            r43 = r1
            java.lang.Long r1 = r0.coin_balance
            r44 = r1
            java.lang.Integer r1 = r0.welcome_package_err
            r45 = r1
            java.lang.Integer r1 = r0.item_limit
            r46 = r1
            java.util.List<com.shopee.protocol.action.CmtidCoin> r1 = r0.cmtidCoinList
            r47 = r1
            java.lang.Integer r1 = r0.msg_opt
            r48 = r1
            java.lang.Boolean r1 = r0.phone_auto_converted
            r49 = r1
            java.lang.String r1 = r0.risk_control_password_token
            r50 = r1
            java.lang.Integer r1 = r0.collection_id
            r51 = r1
            java.util.List<com.shopee.protocol.action.SellerPromotionFailedItem> r1 = r0.promotion_items
            r52 = r1
            java.lang.Integer r1 = r0.retry_left
            r53 = r1
            java.lang.Integer r1 = r0.otp_delivery_channel
            r54 = r1
            java.util.List<java.lang.Integer> r1 = r0.otp_available_channels
            r55 = r1
            java.lang.Integer r1 = r0.expire_time
            r56 = r1
            r1 = r57
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56)
            r58.setBuilder(r59)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ResponseCommon.<init>(com.shopee.protocol.action.ResponseCommon$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCommon)) {
            return false;
        }
        ResponseCommon responseCommon = (ResponseCommon) obj;
        if (!equals((Object) this.requestid, (Object) responseCommon.requestid) || !equals((Object) this.errcode, (Object) responseCommon.errcode) || !equals((Object) this.itemid, (Object) responseCommon.itemid) || !equals((Object) this.shopid, (Object) responseCommon.shopid) || !equals((Object) this.orderid, (Object) responseCommon.orderid) || !equals((Object) this.userid, (Object) responseCommon.userid) || !equals((Object) this.ordersn, (Object) responseCommon.ordersn) || !equals((List<?>) this.modelid, (List<?>) responseCommon.modelid) || !equals((Object) this.chatid, (Object) responseCommon.chatid) || !equals((Object) this.minappversion, (Object) responseCommon.minappversion) || !equals((Object) this.country, (Object) responseCommon.country) || !equals((Object) this.acc, (Object) responseCommon.acc) || !equals((List<?>) this.models, (List<?>) responseCommon.models) || !equals((Object) this.timestamp, (Object) responseCommon.timestamp) || !equals((Object) this.token, (Object) responseCommon.token) || !equals((Object) this.order_status, (Object) responseCommon.order_status) || !equals((Object) this.addrid, (Object) responseCommon.addrid) || !equals((Object) this.msgid, (Object) responseCommon.msgid) || !equals((Object) this.cmtid, (Object) responseCommon.cmtid) || !equals((Object) this.snapshotid, (Object) responseCommon.snapshotid) || !equals((Object) this.count, (Object) responseCommon.count) || !equals((Object) this.return_id, (Object) responseCommon.return_id) || !equals((Object) this.days, (Object) responseCommon.days) || !equals((Object) this.auditid, (Object) responseCommon.auditid) || !equals((Object) this.promotionid, (Object) responseCommon.promotionid) || !equals((Object) this.err_message, (Object) responseCommon.err_message) || !equals((Object) this.order, (Object) responseCommon.order) || !equals((Object) this.is_userinfo_complete, (Object) responseCommon.is_userinfo_complete) || !equals((Object) this.redirect_url, (Object) responseCommon.redirect_url) || !equals((Object) this.vcode_token, (Object) responseCommon.vcode_token) || !equals((Object) this.fbacc, (Object) responseCommon.fbacc) || !equals((Object) this.offerid, (Object) responseCommon.offerid) || !equals((Object) this.pchatid, (Object) responseCommon.pchatid) || !equals((Object) this.shop_collection_id, (Object) responseCommon.shop_collection_id) || !equals((Object) this.coin_rule_id, (Object) responseCommon.coin_rule_id) || !equals((Object) this.behavior_check_errcode, (Object) responseCommon.behavior_check_errcode) || !equals((Object) this.shop_boost, (Object) responseCommon.shop_boost) || !equals((Object) this.m_token, (Object) responseCommon.m_token) || !equals((Object) this.otp_token, (Object) responseCommon.otp_token) || !equals((List<?>) this.distribute_voucher_error, (List<?>) responseCommon.distribute_voucher_error) || !equals((Object) this.debug_msg, (Object) responseCommon.debug_msg) || !equals((Object) this.tax_address, (Object) responseCommon.tax_address) || !equals((Object) this.coin_balance, (Object) responseCommon.coin_balance) || !equals((Object) this.welcome_package_err, (Object) responseCommon.welcome_package_err) || !equals((Object) this.item_limit, (Object) responseCommon.item_limit) || !equals((List<?>) this.cmtidCoinList, (List<?>) responseCommon.cmtidCoinList) || !equals((Object) this.msg_opt, (Object) responseCommon.msg_opt) || !equals((Object) this.phone_auto_converted, (Object) responseCommon.phone_auto_converted) || !equals((Object) this.risk_control_password_token, (Object) responseCommon.risk_control_password_token) || !equals((Object) this.collection_id, (Object) responseCommon.collection_id) || !equals((List<?>) this.promotion_items, (List<?>) responseCommon.promotion_items) || !equals((Object) this.retry_left, (Object) responseCommon.retry_left) || !equals((Object) this.otp_delivery_channel, (Object) responseCommon.otp_delivery_channel) || !equals((List<?>) this.otp_available_channels, (List<?>) responseCommon.otp_available_channels) || !equals((Object) this.expire_time, (Object) responseCommon.expire_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.ordersn;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Long> list = this.modelid;
        int i3 = 1;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        Long l3 = this.chatid;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.minappversion;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Account account = this.acc;
        int hashCode12 = (hashCode11 + (account != null ? account.hashCode() : 0)) * 37;
        List<ItemModel> list2 = this.models;
        int hashCode13 = (hashCode12 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num5 = this.timestamp;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.token;
        int hashCode15 = (hashCode14 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num6 = this.order_status;
        int hashCode16 = (hashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.addrid;
        int hashCode17 = (hashCode16 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l4 = this.msgid;
        int hashCode18 = (hashCode17 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.cmtid;
        int hashCode19 = (hashCode18 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.snapshotid;
        int hashCode20 = (hashCode19 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num8 = this.count;
        int hashCode21 = (hashCode20 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l7 = this.return_id;
        int hashCode22 = (hashCode21 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num9 = this.days;
        int hashCode23 = (hashCode22 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.auditid;
        int hashCode24 = (hashCode23 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Long l8 = this.promotionid;
        int hashCode25 = (hashCode24 + (l8 != null ? l8.hashCode() : 0)) * 37;
        String str5 = this.err_message;
        int hashCode26 = (hashCode25 + (str5 != null ? str5.hashCode() : 0)) * 37;
        OrderWithInfo orderWithInfo = this.order;
        int hashCode27 = (hashCode26 + (orderWithInfo != null ? orderWithInfo.hashCode() : 0)) * 37;
        Integer num11 = this.is_userinfo_complete;
        int hashCode28 = (hashCode27 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str6 = this.redirect_url;
        int hashCode29 = (hashCode28 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.vcode_token;
        int hashCode30 = (hashCode29 + (str7 != null ? str7.hashCode() : 0)) * 37;
        FbAccountInfo fbAccountInfo = this.fbacc;
        int hashCode31 = (hashCode30 + (fbAccountInfo != null ? fbAccountInfo.hashCode() : 0)) * 37;
        Long l9 = this.offerid;
        int hashCode32 = (hashCode31 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.pchatid;
        int hashCode33 = (hashCode32 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.shop_collection_id;
        int hashCode34 = (hashCode33 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Integer num12 = this.coin_rule_id;
        int hashCode35 = (hashCode34 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.behavior_check_errcode;
        int hashCode36 = (hashCode35 + (num13 != null ? num13.hashCode() : 0)) * 37;
        ShopBoost shopBoost = this.shop_boost;
        int hashCode37 = (hashCode36 + (shopBoost != null ? shopBoost.hashCode() : 0)) * 37;
        String str8 = this.m_token;
        int hashCode38 = (hashCode37 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.otp_token;
        int hashCode39 = (hashCode38 + (str9 != null ? str9.hashCode() : 0)) * 37;
        List<DistributeVoucherError> list3 = this.distribute_voucher_error;
        int hashCode40 = (hashCode39 + (list3 != null ? list3.hashCode() : 1)) * 37;
        String str10 = this.debug_msg;
        int hashCode41 = (hashCode40 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.tax_address;
        int hashCode42 = (hashCode41 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Long l12 = this.coin_balance;
        int hashCode43 = (hashCode42 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Integer num14 = this.welcome_package_err;
        int hashCode44 = (hashCode43 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.item_limit;
        int hashCode45 = (hashCode44 + (num15 != null ? num15.hashCode() : 0)) * 37;
        List<CmtidCoin> list4 = this.cmtidCoinList;
        int hashCode46 = (hashCode45 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Integer num16 = this.msg_opt;
        int hashCode47 = (hashCode46 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Boolean bool = this.phone_auto_converted;
        int hashCode48 = (hashCode47 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str12 = this.risk_control_password_token;
        int hashCode49 = (hashCode48 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num17 = this.collection_id;
        int hashCode50 = (hashCode49 + (num17 != null ? num17.hashCode() : 0)) * 37;
        List<SellerPromotionFailedItem> list5 = this.promotion_items;
        int hashCode51 = (hashCode50 + (list5 != null ? list5.hashCode() : 1)) * 37;
        Integer num18 = this.retry_left;
        int hashCode52 = (hashCode51 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.otp_delivery_channel;
        int hashCode53 = (hashCode52 + (num19 != null ? num19.hashCode() : 0)) * 37;
        List<Integer> list6 = this.otp_available_channels;
        if (list6 != null) {
            i3 = list6.hashCode();
        }
        int i4 = (hashCode53 + i3) * 37;
        Integer num20 = this.expire_time;
        if (num20 != null) {
            i2 = num20.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ResponseCommon> {
        public Account acc;
        public Integer addrid;
        public Integer auditid;
        public Integer behavior_check_errcode;
        public Long chatid;
        public Long cmtid;
        public List<CmtidCoin> cmtidCoinList;
        public Long coin_balance;
        public Integer coin_rule_id;
        public Integer collection_id;
        public Integer count;
        public String country;
        public Integer days;
        public String debug_msg;
        public List<DistributeVoucherError> distribute_voucher_error;
        public String err_message;
        public Integer errcode;
        public Integer expire_time;
        public FbAccountInfo fbacc;
        public Integer is_userinfo_complete;
        public Integer item_limit;
        public Long itemid;
        public String m_token;
        public Integer minappversion;
        public List<Long> modelid;
        public List<ItemModel> models;
        public Integer msg_opt;
        public Long msgid;
        public Long offerid;
        public OrderWithInfo order;
        public Integer order_status;
        public Long orderid;
        public String ordersn;
        public List<Integer> otp_available_channels;
        public Integer otp_delivery_channel;
        public String otp_token;
        public Long pchatid;
        public Boolean phone_auto_converted;
        public List<SellerPromotionFailedItem> promotion_items;
        public Long promotionid;
        public String redirect_url;
        public String requestid;
        public Integer retry_left;
        public Long return_id;
        public String risk_control_password_token;
        public ShopBoost shop_boost;
        public Long shop_collection_id;
        public Integer shopid;
        public Long snapshotid;
        public String tax_address;
        public Integer timestamp;
        public String token;
        public Integer userid;
        public String vcode_token;
        public Integer welcome_package_err;

        public Builder() {
        }

        public Builder(ResponseCommon responseCommon) {
            super(responseCommon);
            if (responseCommon != null) {
                this.requestid = responseCommon.requestid;
                this.errcode = responseCommon.errcode;
                this.itemid = responseCommon.itemid;
                this.shopid = responseCommon.shopid;
                this.orderid = responseCommon.orderid;
                this.userid = responseCommon.userid;
                this.ordersn = responseCommon.ordersn;
                this.modelid = ResponseCommon.copyOf(responseCommon.modelid);
                this.chatid = responseCommon.chatid;
                this.minappversion = responseCommon.minappversion;
                this.country = responseCommon.country;
                this.acc = responseCommon.acc;
                this.models = ResponseCommon.copyOf(responseCommon.models);
                this.timestamp = responseCommon.timestamp;
                this.token = responseCommon.token;
                this.order_status = responseCommon.order_status;
                this.addrid = responseCommon.addrid;
                this.msgid = responseCommon.msgid;
                this.cmtid = responseCommon.cmtid;
                this.snapshotid = responseCommon.snapshotid;
                this.count = responseCommon.count;
                this.return_id = responseCommon.return_id;
                this.days = responseCommon.days;
                this.auditid = responseCommon.auditid;
                this.promotionid = responseCommon.promotionid;
                this.err_message = responseCommon.err_message;
                this.order = responseCommon.order;
                this.is_userinfo_complete = responseCommon.is_userinfo_complete;
                this.redirect_url = responseCommon.redirect_url;
                this.vcode_token = responseCommon.vcode_token;
                this.fbacc = responseCommon.fbacc;
                this.offerid = responseCommon.offerid;
                this.pchatid = responseCommon.pchatid;
                this.shop_collection_id = responseCommon.shop_collection_id;
                this.coin_rule_id = responseCommon.coin_rule_id;
                this.behavior_check_errcode = responseCommon.behavior_check_errcode;
                this.shop_boost = responseCommon.shop_boost;
                this.m_token = responseCommon.m_token;
                this.otp_token = responseCommon.otp_token;
                this.distribute_voucher_error = ResponseCommon.copyOf(responseCommon.distribute_voucher_error);
                this.debug_msg = responseCommon.debug_msg;
                this.tax_address = responseCommon.tax_address;
                this.coin_balance = responseCommon.coin_balance;
                this.welcome_package_err = responseCommon.welcome_package_err;
                this.item_limit = responseCommon.item_limit;
                this.cmtidCoinList = ResponseCommon.copyOf(responseCommon.cmtidCoinList);
                this.msg_opt = responseCommon.msg_opt;
                this.phone_auto_converted = responseCommon.phone_auto_converted;
                this.risk_control_password_token = responseCommon.risk_control_password_token;
                this.collection_id = responseCommon.collection_id;
                this.promotion_items = ResponseCommon.copyOf(responseCommon.promotion_items);
                this.retry_left = responseCommon.retry_left;
                this.otp_delivery_channel = responseCommon.otp_delivery_channel;
                this.otp_available_channels = ResponseCommon.copyOf(responseCommon.otp_available_channels);
                this.expire_time = responseCommon.expire_time;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public Builder modelid(List<Long> list) {
            this.modelid = checkForNulls(list);
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder minappversion(Integer num) {
            this.minappversion = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder acc(Account account) {
            this.acc = account;
            return this;
        }

        public Builder models(List<ItemModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder order_status(Integer num) {
            this.order_status = num;
            return this;
        }

        public Builder addrid(Integer num) {
            this.addrid = num;
            return this;
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder days(Integer num) {
            this.days = num;
            return this;
        }

        public Builder auditid(Integer num) {
            this.auditid = num;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder order(OrderWithInfo orderWithInfo) {
            this.order = orderWithInfo;
            return this;
        }

        public Builder is_userinfo_complete(Integer num) {
            this.is_userinfo_complete = num;
            return this;
        }

        public Builder redirect_url(String str) {
            this.redirect_url = str;
            return this;
        }

        public Builder vcode_token(String str) {
            this.vcode_token = str;
            return this;
        }

        public Builder fbacc(FbAccountInfo fbAccountInfo) {
            this.fbacc = fbAccountInfo;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder shop_collection_id(Long l) {
            this.shop_collection_id = l;
            return this;
        }

        public Builder coin_rule_id(Integer num) {
            this.coin_rule_id = num;
            return this;
        }

        public Builder behavior_check_errcode(Integer num) {
            this.behavior_check_errcode = num;
            return this;
        }

        public Builder shop_boost(ShopBoost shopBoost) {
            this.shop_boost = shopBoost;
            return this;
        }

        public Builder m_token(String str) {
            this.m_token = str;
            return this;
        }

        public Builder otp_token(String str) {
            this.otp_token = str;
            return this;
        }

        public Builder distribute_voucher_error(List<DistributeVoucherError> list) {
            this.distribute_voucher_error = checkForNulls(list);
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder tax_address(String str) {
            this.tax_address = str;
            return this;
        }

        public Builder coin_balance(Long l) {
            this.coin_balance = l;
            return this;
        }

        public Builder welcome_package_err(Integer num) {
            this.welcome_package_err = num;
            return this;
        }

        public Builder item_limit(Integer num) {
            this.item_limit = num;
            return this;
        }

        public Builder cmtidCoinList(List<CmtidCoin> list) {
            this.cmtidCoinList = checkForNulls(list);
            return this;
        }

        public Builder msg_opt(Integer num) {
            this.msg_opt = num;
            return this;
        }

        public Builder phone_auto_converted(Boolean bool) {
            this.phone_auto_converted = bool;
            return this;
        }

        public Builder risk_control_password_token(String str) {
            this.risk_control_password_token = str;
            return this;
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
            return this;
        }

        public Builder promotion_items(List<SellerPromotionFailedItem> list) {
            this.promotion_items = checkForNulls(list);
            return this;
        }

        public Builder retry_left(Integer num) {
            this.retry_left = num;
            return this;
        }

        public Builder otp_delivery_channel(Integer num) {
            this.otp_delivery_channel = num;
            return this;
        }

        public Builder otp_available_channels(List<Integer> list) {
            this.otp_available_channels = checkForNulls(list);
            return this;
        }

        public Builder expire_time(Integer num) {
            this.expire_time = num;
            return this;
        }

        public ResponseCommon build() {
            checkRequiredFields();
            return new ResponseCommon(this);
        }
    }
}
