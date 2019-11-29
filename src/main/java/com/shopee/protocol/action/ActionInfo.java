package com.shopee.protocol.action;

import com.shopee.protocol.shop.JkoAccountBuyer;
import com.shopee.protocol.shop.JkoAccountSeller;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ActionInfo extends Message {
    public static final String DEFAULT_ACTION_APP_PATH = "";
    public static final String DEFAULT_ACTION_CONTENT = "";
    public static final String DEFAULT_ACTION_REACTNATIVE_PATH = "";
    public static final Integer DEFAULT_ACTION_REDIRECT_TYPE = 0;
    public static final Long DEFAULT_BALANCE = 0L;
    public static final Long DEFAULT_BILL_AMOUNT = 0L;
    public static final Integer DEFAULT_BUYER_ID = 0;
    public static final String DEFAULT_BUYER_NAME = "";
    public static final String DEFAULT_CARRIER_NAME = "";
    public static final Long DEFAULT_CHECKOUT_ID = 0L;
    public static final String DEFAULT_CHECKOUT_SN = "";
    public static final String DEFAULT_COFFEEVOUCHER = "";
    public static final Long DEFAULT_COUNT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_DAYS_TO_CONFIRM = 0;
    public static final Integer DEFAULT_DUE_DATE = 0;
    public static final Integer DEFAULT_DUE_DATE2 = 0;
    public static final String DEFAULT_GROUP_CODE = "";
    public static final Long DEFAULT_GROUP_ID = 0L;
    public static final String DEFAULT_IMAGE_INFO = "";
    public static final List<String> DEFAULT_IMAGE_INFO_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ITEM_COUNT = 0;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_NEW_BUYER_ADDRESS = "";
    public static final String DEFAULT_NONFULFILLRATE = "";
    public static final String DEFAULT_OFFER_PRICE_CURRENCY = "";
    public static final Boolean DEFAULT_ORDER_IS_B2C = false;
    public static final String DEFAULT_ORDER_SN = "";
    public static final Long DEFAULT_OUTSTANDING_AMOUNT = 0L;
    public static final String DEFAULT_OUTSTANDING_AMOUNT_CURRENCY = "";
    public static final Long DEFAULT_PAID_AMOUNT = 0L;
    public static final String DEFAULT_PAID_AMOUNT_CURRENCY = "";
    public static final Long DEFAULT_PAYMENT_TRANSACTION_ID = 0L;
    public static final String DEFAULT_PICKUP_COUNTER = "";
    public static final Long DEFAULT_PRICE = 0L;
    public static final String DEFAULT_PROMO_CODE = "";
    public static final Integer DEFAULT_REASON_CODE = 0;
    public static final String DEFAULT_REDIRECT_URL = "";
    public static final Long DEFAULT_REFUND_AMOUNT = 0L;
    public static final String DEFAULT_REFUND_AMOUNT_CURRENCY = "";
    public static final Integer DEFAULT_REFUND_DAYS = 0;
    public static final Integer DEFAULT_REFUND_DAYS_MAX = 0;
    public static final Integer DEFAULT_REFUND_DAYS_MIN = 0;
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REFUND_REASON = "";
    public static final String DEFAULT_REFUND_SN = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_RETURN_SN = "";
    public static final String DEFAULT_SELLER_NAME = "";
    public static final Integer DEFAULT_SELLER_USERID = 0;
    public static final String DEFAULT_STATS_INFO = "";
    public static final String DEFAULT_THREEPL_NAME = "";
    public static final String DEFAULT_THREEPL_PHONE = "";
    public static final String DEFAULT_TOPUP_SN = "";
    public static final Long DEFAULT_TRACE_ID = 0L;
    public static final String DEFAULT_TRACK_NO = "";
    public static final Long DEFAULT_TRANSACTION_ID = 0L;
    public static final String DEFAULT_TXT_TITLE = "";
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_WALLET_TYPE = 0;
    public static final String DEFAULT_WARN_RATE = "";
    public static final String DEFAULT_WITHDRAWAL_BANKDAYS = "";
    public static final Long DEFAULT_WITHDRAWAL_ID = 0L;
    public static final String DEFAULT_WITHDRAWAL_SN = "";
    public static final Integer DEFAULT_WITHDRAWAL_SOURCE = 0;
    public static final String DEFAULT_WITHDRAWAL_TYPE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 50, type = Message.Datatype.STRING)
    public final String action_app_path;
    @ProtoField(tag = 42, type = Message.Datatype.STRING)
    public final String action_content;
    @ProtoField(tag = 59, type = Message.Datatype.STRING)
    public final String action_reactnative_path;
    @ProtoField(tag = 48, type = Message.Datatype.INT32)
    public final Integer action_redirect_type;
    @ProtoField(tag = 61, type = Message.Datatype.INT64)
    public final Long balance;
    @ProtoField(tag = 78, type = Message.Datatype.INT64)
    public final Long bill_amount;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer buyer_id;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String buyer_name;
    @ProtoField(tag = 43, type = Message.Datatype.STRING)
    public final String carrier_name;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long checkout_id;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String checkout_sn;
    @ProtoField(tag = 47, type = Message.Datatype.STRING)
    public final String coffeevoucher;
    @ProtoField(tag = 81, type = Message.Datatype.INT64)
    public final Long count;
    @ProtoField(tag = 28, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 74, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 68, type = Message.Datatype.INT32)
    public final Integer days_to_confirm;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer due_date;
    @ProtoField(tag = 66, type = Message.Datatype.INT32)
    public final Integer due_date2;
    @ProtoField(tag = 75, type = Message.Datatype.STRING)
    public final String group_code;
    @ProtoField(tag = 76, type = Message.Datatype.INT64)
    public final Long group_id;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String image_info;
    @ProtoField(label = Message.Label.REPEATED, tag = 58, type = Message.Datatype.STRING)
    public final List<String> image_info_list;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer item_count;
    @ProtoField(tag = 83)
    public final JkoAccountBuyer jko_buyer;
    @ProtoField(tag = 84)
    public final JkoAccountSeller jko_seller;
    @ProtoField(tag = 57, type = Message.Datatype.STRING)
    public final String language;
    @ProtoField(tag = 80, type = Message.Datatype.STRING)
    public final String new_buyer_address;
    @ProtoField(tag = 69, type = Message.Datatype.STRING)
    public final String nonfulfillrate;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String offer_price_currency;
    @ProtoField(tag = 65, type = Message.Datatype.BOOL)
    public final Boolean order_is_b2c;
    @ProtoField(tag = 32, type = Message.Datatype.STRING)
    public final String order_sn;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long outstanding_amount;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String outstanding_amount_currency;
    @ProtoField(tag = 30, type = Message.Datatype.INT64)
    public final Long paid_amount;
    @ProtoField(tag = 31, type = Message.Datatype.STRING)
    public final String paid_amount_currency;
    @ProtoField(tag = 71, type = Message.Datatype.INT64)
    public final Long payment_transaction_id;
    @ProtoField(tag = 46, type = Message.Datatype.STRING)
    public final String pickup_counter;
    @ProtoField(tag = 79, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 38, type = Message.Datatype.STRING)
    public final String promo_code;
    @ProtoField(tag = 56, type = Message.Datatype.INT32)
    public final Integer reason_code;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String redirect_url;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long refund_amount;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String refund_amount_currency;
    @ProtoField(tag = 52, type = Message.Datatype.INT32)
    public final Integer refund_days;
    @ProtoField(tag = 51, type = Message.Datatype.INT32)
    public final Integer refund_days_max;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer refund_days_min;
    @ProtoField(tag = 22, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 36, type = Message.Datatype.STRING)
    public final String refund_reason;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String refund_sn;
    @ProtoField(tag = 29, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String return_sn;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String seller_name;
    @ProtoField(tag = 49, type = Message.Datatype.INT32)
    public final Integer seller_userid;
    @ProtoField(tag = 70, type = Message.Datatype.STRING)
    public final String stats_info;
    @ProtoField(tag = 53, type = Message.Datatype.STRING)
    public final String threepl_name;
    @ProtoField(tag = 54, type = Message.Datatype.STRING)
    public final String threepl_phone;
    @ProtoField(tag = 82, type = Message.Datatype.STRING)
    public final String topup_sn;
    @ProtoField(tag = 77, type = Message.Datatype.INT64)
    public final Long trace_id;
    @ProtoField(tag = 44, type = Message.Datatype.STRING)
    public final String track_no;
    @ProtoField(tag = 64, type = Message.Datatype.INT64)
    public final Long transaction_id;
    @ProtoField(tag = 41, type = Message.Datatype.STRING)
    public final String txt_title;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 73, type = Message.Datatype.INT32)
    public final Integer wallet_type;
    @ProtoField(tag = 72, type = Message.Datatype.STRING)
    public final String warn_rate;
    @ProtoField(tag = 67, type = Message.Datatype.STRING)
    public final String withdrawal_bankdays;
    @ProtoField(tag = 60, type = Message.Datatype.INT64)
    public final Long withdrawal_id;
    @ProtoField(tag = 85, type = Message.Datatype.STRING)
    public final String withdrawal_sn;
    @ProtoField(tag = 63, type = Message.Datatype.INT32)
    public final Integer withdrawal_source;
    @ProtoField(tag = 62, type = Message.Datatype.STRING)
    public final String withdrawal_type;

    public ActionInfo(String str, String str2, Long l, Long l2, Integer num, Long l3, Long l4, String str3, String str4, String str5, String str6, String str7, Long l5, Long l6, String str8, String str9, String str10, String str11, String str12, String str13, Integer num2, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num3, String str21, String str22, Integer num4, Integer num5, String str23, Integer num6, Integer num7, String str24, String str25, Integer num8, Integer num9, String str26, List<String> list, String str27, Long l7, Long l8, String str28, Integer num10, Long l9, Boolean bool, Integer num11, String str29, Integer num12, String str30, String str31, Long l10, String str32, Integer num13, String str33, String str34, Long l11, Long l12, Long l13, Long l14, String str35, Long l15, String str36, JkoAccountBuyer jkoAccountBuyer, JkoAccountSeller jkoAccountSeller, String str37) {
        this.seller_name = str;
        this.buyer_name = str2;
        this.outstanding_amount = l;
        this.checkout_id = l2;
        this.due_date = num;
        this.refund_amount = l3;
        this.refund_id = l4;
        this.username = str3;
        this.offer_price_currency = str4;
        this.outstanding_amount_currency = str5;
        this.refund_amount_currency = str6;
        this.country = str7;
        this.return_id = l5;
        this.paid_amount = l6;
        this.paid_amount_currency = str8;
        this.order_sn = str9;
        this.checkout_sn = str10;
        this.return_sn = str11;
        this.refund_sn = str12;
        this.refund_reason = str13;
        this.buyer_id = num2;
        this.promo_code = str14;
        this.redirect_url = str15;
        this.image_info = str16;
        this.txt_title = str17;
        this.action_content = str18;
        this.carrier_name = str19;
        this.track_no = str20;
        this.item_count = num3;
        this.pickup_counter = str21;
        this.coffeevoucher = str22;
        this.action_redirect_type = num4;
        this.seller_userid = num5;
        this.action_app_path = str23;
        this.refund_days_max = num6;
        this.refund_days = num7;
        this.threepl_name = str24;
        this.threepl_phone = str25;
        this.refund_days_min = num8;
        this.reason_code = num9;
        this.language = str26;
        this.image_info_list = immutableCopyOf(list);
        this.action_reactnative_path = str27;
        this.withdrawal_id = l7;
        this.balance = l8;
        this.withdrawal_type = str28;
        this.withdrawal_source = num10;
        this.transaction_id = l9;
        this.order_is_b2c = bool;
        this.due_date2 = num11;
        this.withdrawal_bankdays = str29;
        this.days_to_confirm = num12;
        this.nonfulfillrate = str30;
        this.stats_info = str31;
        this.payment_transaction_id = l10;
        this.warn_rate = str32;
        this.wallet_type = num13;
        this.currency = str33;
        this.group_code = str34;
        this.group_id = l11;
        this.trace_id = l12;
        this.bill_amount = l13;
        this.price = l14;
        this.new_buyer_address = str35;
        this.count = l15;
        this.topup_sn = str36;
        this.jko_buyer = jkoAccountBuyer;
        this.jko_seller = jkoAccountSeller;
        this.withdrawal_sn = str37;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ActionInfo(com.shopee.protocol.action.ActionInfo.Builder r73) {
        /*
            r72 = this;
            r0 = r73
            r1 = r72
            java.lang.String r2 = r0.seller_name
            java.lang.String r3 = r0.buyer_name
            java.lang.Long r4 = r0.outstanding_amount
            java.lang.Long r5 = r0.checkout_id
            java.lang.Integer r6 = r0.due_date
            java.lang.Long r7 = r0.refund_amount
            java.lang.Long r8 = r0.refund_id
            java.lang.String r9 = r0.username
            java.lang.String r10 = r0.offer_price_currency
            java.lang.String r11 = r0.outstanding_amount_currency
            java.lang.String r12 = r0.refund_amount_currency
            java.lang.String r13 = r0.country
            java.lang.Long r14 = r0.return_id
            java.lang.Long r15 = r0.paid_amount
            r71 = r1
            java.lang.String r1 = r0.paid_amount_currency
            r16 = r1
            java.lang.String r1 = r0.order_sn
            r17 = r1
            java.lang.String r1 = r0.checkout_sn
            r18 = r1
            java.lang.String r1 = r0.return_sn
            r19 = r1
            java.lang.String r1 = r0.refund_sn
            r20 = r1
            java.lang.String r1 = r0.refund_reason
            r21 = r1
            java.lang.Integer r1 = r0.buyer_id
            r22 = r1
            java.lang.String r1 = r0.promo_code
            r23 = r1
            java.lang.String r1 = r0.redirect_url
            r24 = r1
            java.lang.String r1 = r0.image_info
            r25 = r1
            java.lang.String r1 = r0.txt_title
            r26 = r1
            java.lang.String r1 = r0.action_content
            r27 = r1
            java.lang.String r1 = r0.carrier_name
            r28 = r1
            java.lang.String r1 = r0.track_no
            r29 = r1
            java.lang.Integer r1 = r0.item_count
            r30 = r1
            java.lang.String r1 = r0.pickup_counter
            r31 = r1
            java.lang.String r1 = r0.coffeevoucher
            r32 = r1
            java.lang.Integer r1 = r0.action_redirect_type
            r33 = r1
            java.lang.Integer r1 = r0.seller_userid
            r34 = r1
            java.lang.String r1 = r0.action_app_path
            r35 = r1
            java.lang.Integer r1 = r0.refund_days_max
            r36 = r1
            java.lang.Integer r1 = r0.refund_days
            r37 = r1
            java.lang.String r1 = r0.threepl_name
            r38 = r1
            java.lang.String r1 = r0.threepl_phone
            r39 = r1
            java.lang.Integer r1 = r0.refund_days_min
            r40 = r1
            java.lang.Integer r1 = r0.reason_code
            r41 = r1
            java.lang.String r1 = r0.language
            r42 = r1
            java.util.List<java.lang.String> r1 = r0.image_info_list
            r43 = r1
            java.lang.String r1 = r0.action_reactnative_path
            r44 = r1
            java.lang.Long r1 = r0.withdrawal_id
            r45 = r1
            java.lang.Long r1 = r0.balance
            r46 = r1
            java.lang.String r1 = r0.withdrawal_type
            r47 = r1
            java.lang.Integer r1 = r0.withdrawal_source
            r48 = r1
            java.lang.Long r1 = r0.transaction_id
            r49 = r1
            java.lang.Boolean r1 = r0.order_is_b2c
            r50 = r1
            java.lang.Integer r1 = r0.due_date2
            r51 = r1
            java.lang.String r1 = r0.withdrawal_bankdays
            r52 = r1
            java.lang.Integer r1 = r0.days_to_confirm
            r53 = r1
            java.lang.String r1 = r0.nonfulfillrate
            r54 = r1
            java.lang.String r1 = r0.stats_info
            r55 = r1
            java.lang.Long r1 = r0.payment_transaction_id
            r56 = r1
            java.lang.String r1 = r0.warn_rate
            r57 = r1
            java.lang.Integer r1 = r0.wallet_type
            r58 = r1
            java.lang.String r1 = r0.currency
            r59 = r1
            java.lang.String r1 = r0.group_code
            r60 = r1
            java.lang.Long r1 = r0.group_id
            r61 = r1
            java.lang.Long r1 = r0.trace_id
            r62 = r1
            java.lang.Long r1 = r0.bill_amount
            r63 = r1
            java.lang.Long r1 = r0.price
            r64 = r1
            java.lang.String r1 = r0.new_buyer_address
            r65 = r1
            java.lang.Long r1 = r0.count
            r66 = r1
            java.lang.String r1 = r0.topup_sn
            r67 = r1
            com.shopee.protocol.shop.JkoAccountBuyer r1 = r0.jko_buyer
            r68 = r1
            com.shopee.protocol.shop.JkoAccountSeller r1 = r0.jko_seller
            r69 = r1
            java.lang.String r1 = r0.withdrawal_sn
            r70 = r1
            r1 = r71
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)
            r72.setBuilder(r73)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.ActionInfo.<init>(com.shopee.protocol.action.ActionInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionInfo)) {
            return false;
        }
        ActionInfo actionInfo = (ActionInfo) obj;
        if (!equals((Object) this.seller_name, (Object) actionInfo.seller_name) || !equals((Object) this.buyer_name, (Object) actionInfo.buyer_name) || !equals((Object) this.outstanding_amount, (Object) actionInfo.outstanding_amount) || !equals((Object) this.checkout_id, (Object) actionInfo.checkout_id) || !equals((Object) this.due_date, (Object) actionInfo.due_date) || !equals((Object) this.refund_amount, (Object) actionInfo.refund_amount) || !equals((Object) this.refund_id, (Object) actionInfo.refund_id) || !equals((Object) this.username, (Object) actionInfo.username) || !equals((Object) this.offer_price_currency, (Object) actionInfo.offer_price_currency) || !equals((Object) this.outstanding_amount_currency, (Object) actionInfo.outstanding_amount_currency) || !equals((Object) this.refund_amount_currency, (Object) actionInfo.refund_amount_currency) || !equals((Object) this.country, (Object) actionInfo.country) || !equals((Object) this.return_id, (Object) actionInfo.return_id) || !equals((Object) this.paid_amount, (Object) actionInfo.paid_amount) || !equals((Object) this.paid_amount_currency, (Object) actionInfo.paid_amount_currency) || !equals((Object) this.order_sn, (Object) actionInfo.order_sn) || !equals((Object) this.checkout_sn, (Object) actionInfo.checkout_sn) || !equals((Object) this.return_sn, (Object) actionInfo.return_sn) || !equals((Object) this.refund_sn, (Object) actionInfo.refund_sn) || !equals((Object) this.refund_reason, (Object) actionInfo.refund_reason) || !equals((Object) this.buyer_id, (Object) actionInfo.buyer_id) || !equals((Object) this.promo_code, (Object) actionInfo.promo_code) || !equals((Object) this.redirect_url, (Object) actionInfo.redirect_url) || !equals((Object) this.image_info, (Object) actionInfo.image_info) || !equals((Object) this.txt_title, (Object) actionInfo.txt_title) || !equals((Object) this.action_content, (Object) actionInfo.action_content) || !equals((Object) this.carrier_name, (Object) actionInfo.carrier_name) || !equals((Object) this.track_no, (Object) actionInfo.track_no) || !equals((Object) this.item_count, (Object) actionInfo.item_count) || !equals((Object) this.pickup_counter, (Object) actionInfo.pickup_counter) || !equals((Object) this.coffeevoucher, (Object) actionInfo.coffeevoucher) || !equals((Object) this.action_redirect_type, (Object) actionInfo.action_redirect_type) || !equals((Object) this.seller_userid, (Object) actionInfo.seller_userid) || !equals((Object) this.action_app_path, (Object) actionInfo.action_app_path) || !equals((Object) this.refund_days_max, (Object) actionInfo.refund_days_max) || !equals((Object) this.refund_days, (Object) actionInfo.refund_days) || !equals((Object) this.threepl_name, (Object) actionInfo.threepl_name) || !equals((Object) this.threepl_phone, (Object) actionInfo.threepl_phone) || !equals((Object) this.refund_days_min, (Object) actionInfo.refund_days_min) || !equals((Object) this.reason_code, (Object) actionInfo.reason_code) || !equals((Object) this.language, (Object) actionInfo.language) || !equals((List<?>) this.image_info_list, (List<?>) actionInfo.image_info_list) || !equals((Object) this.action_reactnative_path, (Object) actionInfo.action_reactnative_path) || !equals((Object) this.withdrawal_id, (Object) actionInfo.withdrawal_id) || !equals((Object) this.balance, (Object) actionInfo.balance) || !equals((Object) this.withdrawal_type, (Object) actionInfo.withdrawal_type) || !equals((Object) this.withdrawal_source, (Object) actionInfo.withdrawal_source) || !equals((Object) this.transaction_id, (Object) actionInfo.transaction_id) || !equals((Object) this.order_is_b2c, (Object) actionInfo.order_is_b2c) || !equals((Object) this.due_date2, (Object) actionInfo.due_date2) || !equals((Object) this.withdrawal_bankdays, (Object) actionInfo.withdrawal_bankdays) || !equals((Object) this.days_to_confirm, (Object) actionInfo.days_to_confirm) || !equals((Object) this.nonfulfillrate, (Object) actionInfo.nonfulfillrate) || !equals((Object) this.stats_info, (Object) actionInfo.stats_info) || !equals((Object) this.payment_transaction_id, (Object) actionInfo.payment_transaction_id) || !equals((Object) this.warn_rate, (Object) actionInfo.warn_rate) || !equals((Object) this.wallet_type, (Object) actionInfo.wallet_type) || !equals((Object) this.currency, (Object) actionInfo.currency) || !equals((Object) this.group_code, (Object) actionInfo.group_code) || !equals((Object) this.group_id, (Object) actionInfo.group_id) || !equals((Object) this.trace_id, (Object) actionInfo.trace_id) || !equals((Object) this.bill_amount, (Object) actionInfo.bill_amount) || !equals((Object) this.price, (Object) actionInfo.price) || !equals((Object) this.new_buyer_address, (Object) actionInfo.new_buyer_address) || !equals((Object) this.count, (Object) actionInfo.count) || !equals((Object) this.topup_sn, (Object) actionInfo.topup_sn) || !equals((Object) this.jko_buyer, (Object) actionInfo.jko_buyer) || !equals((Object) this.jko_seller, (Object) actionInfo.jko_seller) || !equals((Object) this.withdrawal_sn, (Object) actionInfo.withdrawal_sn)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.seller_name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.buyer_name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.outstanding_amount;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.checkout_id;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.due_date;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.refund_amount;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.refund_id;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str3 = this.username;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.offer_price_currency;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.outstanding_amount_currency;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.refund_amount_currency;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.country;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l5 = this.return_id;
        int hashCode13 = (hashCode12 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.paid_amount;
        int hashCode14 = (hashCode13 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str8 = this.paid_amount_currency;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.order_sn;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.checkout_sn;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.return_sn;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.refund_sn;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.refund_reason;
        int hashCode20 = (hashCode19 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Integer num2 = this.buyer_id;
        int hashCode21 = (hashCode20 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str14 = this.promo_code;
        int hashCode22 = (hashCode21 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.redirect_url;
        int hashCode23 = (hashCode22 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.image_info;
        int hashCode24 = (hashCode23 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.txt_title;
        int hashCode25 = (hashCode24 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.action_content;
        int hashCode26 = (hashCode25 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.carrier_name;
        int hashCode27 = (hashCode26 + (str19 != null ? str19.hashCode() : 0)) * 37;
        String str20 = this.track_no;
        int hashCode28 = (hashCode27 + (str20 != null ? str20.hashCode() : 0)) * 37;
        Integer num3 = this.item_count;
        int hashCode29 = (hashCode28 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str21 = this.pickup_counter;
        int hashCode30 = (hashCode29 + (str21 != null ? str21.hashCode() : 0)) * 37;
        String str22 = this.coffeevoucher;
        int hashCode31 = (hashCode30 + (str22 != null ? str22.hashCode() : 0)) * 37;
        Integer num4 = this.action_redirect_type;
        int hashCode32 = (hashCode31 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.seller_userid;
        int hashCode33 = (hashCode32 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str23 = this.action_app_path;
        int hashCode34 = (hashCode33 + (str23 != null ? str23.hashCode() : 0)) * 37;
        Integer num6 = this.refund_days_max;
        int hashCode35 = (hashCode34 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.refund_days;
        int hashCode36 = (hashCode35 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str24 = this.threepl_name;
        int hashCode37 = (hashCode36 + (str24 != null ? str24.hashCode() : 0)) * 37;
        String str25 = this.threepl_phone;
        int hashCode38 = (hashCode37 + (str25 != null ? str25.hashCode() : 0)) * 37;
        Integer num8 = this.refund_days_min;
        int hashCode39 = (hashCode38 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.reason_code;
        int hashCode40 = (hashCode39 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str26 = this.language;
        int hashCode41 = (hashCode40 + (str26 != null ? str26.hashCode() : 0)) * 37;
        List<String> list = this.image_info_list;
        int hashCode42 = (hashCode41 + (list != null ? list.hashCode() : 1)) * 37;
        String str27 = this.action_reactnative_path;
        int hashCode43 = (hashCode42 + (str27 != null ? str27.hashCode() : 0)) * 37;
        Long l7 = this.withdrawal_id;
        int hashCode44 = (hashCode43 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.balance;
        int hashCode45 = (hashCode44 + (l8 != null ? l8.hashCode() : 0)) * 37;
        String str28 = this.withdrawal_type;
        int hashCode46 = (hashCode45 + (str28 != null ? str28.hashCode() : 0)) * 37;
        Integer num10 = this.withdrawal_source;
        int hashCode47 = (hashCode46 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Long l9 = this.transaction_id;
        int hashCode48 = (hashCode47 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Boolean bool = this.order_is_b2c;
        int hashCode49 = (hashCode48 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num11 = this.due_date2;
        int hashCode50 = (hashCode49 + (num11 != null ? num11.hashCode() : 0)) * 37;
        String str29 = this.withdrawal_bankdays;
        int hashCode51 = (hashCode50 + (str29 != null ? str29.hashCode() : 0)) * 37;
        Integer num12 = this.days_to_confirm;
        int hashCode52 = (hashCode51 + (num12 != null ? num12.hashCode() : 0)) * 37;
        String str30 = this.nonfulfillrate;
        int hashCode53 = (hashCode52 + (str30 != null ? str30.hashCode() : 0)) * 37;
        String str31 = this.stats_info;
        int hashCode54 = (hashCode53 + (str31 != null ? str31.hashCode() : 0)) * 37;
        Long l10 = this.payment_transaction_id;
        int hashCode55 = (hashCode54 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str32 = this.warn_rate;
        int hashCode56 = (hashCode55 + (str32 != null ? str32.hashCode() : 0)) * 37;
        Integer num13 = this.wallet_type;
        int hashCode57 = (hashCode56 + (num13 != null ? num13.hashCode() : 0)) * 37;
        String str33 = this.currency;
        int hashCode58 = (hashCode57 + (str33 != null ? str33.hashCode() : 0)) * 37;
        String str34 = this.group_code;
        int hashCode59 = (hashCode58 + (str34 != null ? str34.hashCode() : 0)) * 37;
        Long l11 = this.group_id;
        int hashCode60 = (hashCode59 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.trace_id;
        int hashCode61 = (hashCode60 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Long l13 = this.bill_amount;
        int hashCode62 = (hashCode61 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Long l14 = this.price;
        int hashCode63 = (hashCode62 + (l14 != null ? l14.hashCode() : 0)) * 37;
        String str35 = this.new_buyer_address;
        int hashCode64 = (hashCode63 + (str35 != null ? str35.hashCode() : 0)) * 37;
        Long l15 = this.count;
        int hashCode65 = (hashCode64 + (l15 != null ? l15.hashCode() : 0)) * 37;
        String str36 = this.topup_sn;
        int hashCode66 = (hashCode65 + (str36 != null ? str36.hashCode() : 0)) * 37;
        JkoAccountBuyer jkoAccountBuyer = this.jko_buyer;
        int hashCode67 = (hashCode66 + (jkoAccountBuyer != null ? jkoAccountBuyer.hashCode() : 0)) * 37;
        JkoAccountSeller jkoAccountSeller = this.jko_seller;
        int hashCode68 = (hashCode67 + (jkoAccountSeller != null ? jkoAccountSeller.hashCode() : 0)) * 37;
        String str37 = this.withdrawal_sn;
        if (str37 != null) {
            i2 = str37.hashCode();
        }
        int i3 = hashCode68 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActionInfo> {
        public String action_app_path;
        public String action_content;
        public String action_reactnative_path;
        public Integer action_redirect_type;
        public Long balance;
        public Long bill_amount;
        public Integer buyer_id;
        public String buyer_name;
        public String carrier_name;
        public Long checkout_id;
        public String checkout_sn;
        public String coffeevoucher;
        public Long count;
        public String country;
        public String currency;
        public Integer days_to_confirm;
        public Integer due_date;
        public Integer due_date2;
        public String group_code;
        public Long group_id;
        public String image_info;
        public List<String> image_info_list;
        public Integer item_count;
        public JkoAccountBuyer jko_buyer;
        public JkoAccountSeller jko_seller;
        public String language;
        public String new_buyer_address;
        public String nonfulfillrate;
        public String offer_price_currency;
        public Boolean order_is_b2c;
        public String order_sn;
        public Long outstanding_amount;
        public String outstanding_amount_currency;
        public Long paid_amount;
        public String paid_amount_currency;
        public Long payment_transaction_id;
        public String pickup_counter;
        public Long price;
        public String promo_code;
        public Integer reason_code;
        public String redirect_url;
        public Long refund_amount;
        public String refund_amount_currency;
        public Integer refund_days;
        public Integer refund_days_max;
        public Integer refund_days_min;
        public Long refund_id;
        public String refund_reason;
        public String refund_sn;
        public Long return_id;
        public String return_sn;
        public String seller_name;
        public Integer seller_userid;
        public String stats_info;
        public String threepl_name;
        public String threepl_phone;
        public String topup_sn;
        public Long trace_id;
        public String track_no;
        public Long transaction_id;
        public String txt_title;
        public String username;
        public Integer wallet_type;
        public String warn_rate;
        public String withdrawal_bankdays;
        public Long withdrawal_id;
        public String withdrawal_sn;
        public Integer withdrawal_source;
        public String withdrawal_type;

        public Builder() {
        }

        public Builder(ActionInfo actionInfo) {
            super(actionInfo);
            if (actionInfo != null) {
                this.seller_name = actionInfo.seller_name;
                this.buyer_name = actionInfo.buyer_name;
                this.outstanding_amount = actionInfo.outstanding_amount;
                this.checkout_id = actionInfo.checkout_id;
                this.due_date = actionInfo.due_date;
                this.refund_amount = actionInfo.refund_amount;
                this.refund_id = actionInfo.refund_id;
                this.username = actionInfo.username;
                this.offer_price_currency = actionInfo.offer_price_currency;
                this.outstanding_amount_currency = actionInfo.outstanding_amount_currency;
                this.refund_amount_currency = actionInfo.refund_amount_currency;
                this.country = actionInfo.country;
                this.return_id = actionInfo.return_id;
                this.paid_amount = actionInfo.paid_amount;
                this.paid_amount_currency = actionInfo.paid_amount_currency;
                this.order_sn = actionInfo.order_sn;
                this.checkout_sn = actionInfo.checkout_sn;
                this.return_sn = actionInfo.return_sn;
                this.refund_sn = actionInfo.refund_sn;
                this.refund_reason = actionInfo.refund_reason;
                this.buyer_id = actionInfo.buyer_id;
                this.promo_code = actionInfo.promo_code;
                this.redirect_url = actionInfo.redirect_url;
                this.image_info = actionInfo.image_info;
                this.txt_title = actionInfo.txt_title;
                this.action_content = actionInfo.action_content;
                this.carrier_name = actionInfo.carrier_name;
                this.track_no = actionInfo.track_no;
                this.item_count = actionInfo.item_count;
                this.pickup_counter = actionInfo.pickup_counter;
                this.coffeevoucher = actionInfo.coffeevoucher;
                this.action_redirect_type = actionInfo.action_redirect_type;
                this.seller_userid = actionInfo.seller_userid;
                this.action_app_path = actionInfo.action_app_path;
                this.refund_days_max = actionInfo.refund_days_max;
                this.refund_days = actionInfo.refund_days;
                this.threepl_name = actionInfo.threepl_name;
                this.threepl_phone = actionInfo.threepl_phone;
                this.refund_days_min = actionInfo.refund_days_min;
                this.reason_code = actionInfo.reason_code;
                this.language = actionInfo.language;
                this.image_info_list = ActionInfo.copyOf(actionInfo.image_info_list);
                this.action_reactnative_path = actionInfo.action_reactnative_path;
                this.withdrawal_id = actionInfo.withdrawal_id;
                this.balance = actionInfo.balance;
                this.withdrawal_type = actionInfo.withdrawal_type;
                this.withdrawal_source = actionInfo.withdrawal_source;
                this.transaction_id = actionInfo.transaction_id;
                this.order_is_b2c = actionInfo.order_is_b2c;
                this.due_date2 = actionInfo.due_date2;
                this.withdrawal_bankdays = actionInfo.withdrawal_bankdays;
                this.days_to_confirm = actionInfo.days_to_confirm;
                this.nonfulfillrate = actionInfo.nonfulfillrate;
                this.stats_info = actionInfo.stats_info;
                this.payment_transaction_id = actionInfo.payment_transaction_id;
                this.warn_rate = actionInfo.warn_rate;
                this.wallet_type = actionInfo.wallet_type;
                this.currency = actionInfo.currency;
                this.group_code = actionInfo.group_code;
                this.group_id = actionInfo.group_id;
                this.trace_id = actionInfo.trace_id;
                this.bill_amount = actionInfo.bill_amount;
                this.price = actionInfo.price;
                this.new_buyer_address = actionInfo.new_buyer_address;
                this.count = actionInfo.count;
                this.topup_sn = actionInfo.topup_sn;
                this.jko_buyer = actionInfo.jko_buyer;
                this.jko_seller = actionInfo.jko_seller;
                this.withdrawal_sn = actionInfo.withdrawal_sn;
            }
        }

        public Builder seller_name(String str) {
            this.seller_name = str;
            return this;
        }

        public Builder buyer_name(String str) {
            this.buyer_name = str;
            return this;
        }

        public Builder outstanding_amount(Long l) {
            this.outstanding_amount = l;
            return this;
        }

        public Builder checkout_id(Long l) {
            this.checkout_id = l;
            return this;
        }

        public Builder due_date(Integer num) {
            this.due_date = num;
            return this;
        }

        public Builder refund_amount(Long l) {
            this.refund_amount = l;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder offer_price_currency(String str) {
            this.offer_price_currency = str;
            return this;
        }

        public Builder outstanding_amount_currency(String str) {
            this.outstanding_amount_currency = str;
            return this;
        }

        public Builder refund_amount_currency(String str) {
            this.refund_amount_currency = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder paid_amount(Long l) {
            this.paid_amount = l;
            return this;
        }

        public Builder paid_amount_currency(String str) {
            this.paid_amount_currency = str;
            return this;
        }

        public Builder order_sn(String str) {
            this.order_sn = str;
            return this;
        }

        public Builder checkout_sn(String str) {
            this.checkout_sn = str;
            return this;
        }

        public Builder return_sn(String str) {
            this.return_sn = str;
            return this;
        }

        public Builder refund_sn(String str) {
            this.refund_sn = str;
            return this;
        }

        public Builder refund_reason(String str) {
            this.refund_reason = str;
            return this;
        }

        public Builder buyer_id(Integer num) {
            this.buyer_id = num;
            return this;
        }

        public Builder promo_code(String str) {
            this.promo_code = str;
            return this;
        }

        public Builder redirect_url(String str) {
            this.redirect_url = str;
            return this;
        }

        public Builder image_info(String str) {
            this.image_info = str;
            return this;
        }

        public Builder txt_title(String str) {
            this.txt_title = str;
            return this;
        }

        public Builder action_content(String str) {
            this.action_content = str;
            return this;
        }

        public Builder carrier_name(String str) {
            this.carrier_name = str;
            return this;
        }

        public Builder track_no(String str) {
            this.track_no = str;
            return this;
        }

        public Builder item_count(Integer num) {
            this.item_count = num;
            return this;
        }

        public Builder pickup_counter(String str) {
            this.pickup_counter = str;
            return this;
        }

        public Builder coffeevoucher(String str) {
            this.coffeevoucher = str;
            return this;
        }

        public Builder action_redirect_type(Integer num) {
            this.action_redirect_type = num;
            return this;
        }

        public Builder seller_userid(Integer num) {
            this.seller_userid = num;
            return this;
        }

        public Builder action_app_path(String str) {
            this.action_app_path = str;
            return this;
        }

        public Builder refund_days_max(Integer num) {
            this.refund_days_max = num;
            return this;
        }

        public Builder refund_days(Integer num) {
            this.refund_days = num;
            return this;
        }

        public Builder threepl_name(String str) {
            this.threepl_name = str;
            return this;
        }

        public Builder threepl_phone(String str) {
            this.threepl_phone = str;
            return this;
        }

        public Builder refund_days_min(Integer num) {
            this.refund_days_min = num;
            return this;
        }

        public Builder reason_code(Integer num) {
            this.reason_code = num;
            return this;
        }

        public Builder language(String str) {
            this.language = str;
            return this;
        }

        public Builder image_info_list(List<String> list) {
            this.image_info_list = checkForNulls(list);
            return this;
        }

        public Builder action_reactnative_path(String str) {
            this.action_reactnative_path = str;
            return this;
        }

        public Builder withdrawal_id(Long l) {
            this.withdrawal_id = l;
            return this;
        }

        public Builder balance(Long l) {
            this.balance = l;
            return this;
        }

        public Builder withdrawal_type(String str) {
            this.withdrawal_type = str;
            return this;
        }

        public Builder withdrawal_source(Integer num) {
            this.withdrawal_source = num;
            return this;
        }

        public Builder transaction_id(Long l) {
            this.transaction_id = l;
            return this;
        }

        public Builder order_is_b2c(Boolean bool) {
            this.order_is_b2c = bool;
            return this;
        }

        public Builder due_date2(Integer num) {
            this.due_date2 = num;
            return this;
        }

        public Builder withdrawal_bankdays(String str) {
            this.withdrawal_bankdays = str;
            return this;
        }

        public Builder days_to_confirm(Integer num) {
            this.days_to_confirm = num;
            return this;
        }

        public Builder nonfulfillrate(String str) {
            this.nonfulfillrate = str;
            return this;
        }

        public Builder stats_info(String str) {
            this.stats_info = str;
            return this;
        }

        public Builder payment_transaction_id(Long l) {
            this.payment_transaction_id = l;
            return this;
        }

        public Builder warn_rate(String str) {
            this.warn_rate = str;
            return this;
        }

        public Builder wallet_type(Integer num) {
            this.wallet_type = num;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder group_code(String str) {
            this.group_code = str;
            return this;
        }

        public Builder group_id(Long l) {
            this.group_id = l;
            return this;
        }

        public Builder trace_id(Long l) {
            this.trace_id = l;
            return this;
        }

        public Builder bill_amount(Long l) {
            this.bill_amount = l;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder new_buyer_address(String str) {
            this.new_buyer_address = str;
            return this;
        }

        public Builder count(Long l) {
            this.count = l;
            return this;
        }

        public Builder topup_sn(String str) {
            this.topup_sn = str;
            return this;
        }

        public Builder jko_buyer(JkoAccountBuyer jkoAccountBuyer) {
            this.jko_buyer = jkoAccountBuyer;
            return this;
        }

        public Builder jko_seller(JkoAccountSeller jkoAccountSeller) {
            this.jko_seller = jkoAccountSeller;
            return this;
        }

        public Builder withdrawal_sn(String str) {
            this.withdrawal_sn = str;
            return this;
        }

        public ActionInfo build() {
            return new ActionInfo(this);
        }
    }
}
