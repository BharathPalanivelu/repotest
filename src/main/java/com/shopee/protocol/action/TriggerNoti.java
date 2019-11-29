package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TriggerNoti extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final String DEFAULT_AMOUNT_CURRENCY = "";
    public static final String DEFAULT_BUYER_PHONE_NUMBER = "";
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_CHECKOUT_SN = "";
    public static final String DEFAULT_COFFEEVOUCHER = "";
    public static final Integer DEFAULT_COIN_COUNT = 0;
    public static final String DEFAULT_CONSIGNMENT_ID = "";
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_COUNT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_CS_PHONE = "";
    public static final Integer DEFAULT_DUE_DATE = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final String DEFAULT_IMAGE_INFO = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_NONFULFILLRATE = "";
    public static final Integer DEFAULT_NOTICODE = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDER_SN = "";
    public static final String DEFAULT_PICKUP_COUNTER = "";
    public static final String DEFAULT_PROMO_CODE = "";
    public static final Integer DEFAULT_REASON_CODE = 0;
    public static final String DEFAULT_REDIRECT_URL = "";
    public static final Long DEFAULT_REFUND_ID = 0L;
    public static final String DEFAULT_REFUND_SN = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_RETURN_SN = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_SPECIFIED_ACTION_CATE = 0;
    public static final Integer DEFAULT_TO_USERID = 0;
    public static final List<Integer> DEFAULT_TO_USERID_LIST = Collections.emptyList();
    public static final String DEFAULT_TXT_TITLE = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final Long DEFAULT_WITHDRAWAL_ID = 0L;
    public static final String DEFAULT_WITHDRAWAL_SN = "";
    public static final String DEFAULT_WITHDRAW_BANKDAYS = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 32, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 34, type = Message.Datatype.STRING)
    public final String amount_currency;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 26, type = Message.Datatype.STRING)
    public final String buyer_phone_number;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String checkout_sn;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 25, type = Message.Datatype.STRING)
    public final String coffeevoucher;
    @ProtoField(tag = 28, type = Message.Datatype.INT32)
    public final Integer coin_count;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String consignment_id;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 38, type = Message.Datatype.INT64)
    public final Long count;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String cs_phone;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer due_date;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String image_info;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 35, type = Message.Datatype.STRING)
    public final String nonfulfillrate;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer noticode;
    @ProtoField(tag = 36)
    public final Notification notify;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String order_sn;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 24, type = Message.Datatype.STRING)
    public final String pickup_counter;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String promo_code;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer reason_code;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String redirect_url;
    @ProtoField(tag = 17, type = Message.Datatype.INT64)
    public final Long refund_id;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String refund_sn;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String return_sn;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer specified_action_cate;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(label = Message.Label.REPEATED, tag = 40, type = Message.Datatype.INT32)
    public final List<Integer> to_userid_list;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String txt_title;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 33, type = Message.Datatype.STRING)
    public final String withdraw_bankdays;
    @ProtoField(tag = 30, type = Message.Datatype.INT64)
    public final Long withdrawal_id;
    @ProtoField(tag = 39, type = Message.Datatype.STRING)
    public final String withdrawal_sn;

    public TriggerNoti(String str, BackendParam backendParam, Integer num, Integer num2, Integer num3, Long l, Long l2, Long l3, String str2, String str3, String str4, String str5, String str6, Long l4, Integer num4, String str7, Long l5, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Integer num5, Integer num6, Integer num7, Long l6, Integer num8, Long l7, String str17, String str18, String str19, Notification notification, Integer num9, Long l8, String str20, List<Integer> list) {
        this.requestid = str;
        this.bparam = backendParam;
        this.noticode = num;
        this.to_userid = num2;
        this.shopid = num3;
        this.itemid = l;
        this.orderid = l2;
        this.checkoutid = l3;
        this.content = str2;
        this.order_sn = str3;
        this.checkout_sn = str4;
        this.return_sn = str5;
        this.refund_sn = str6;
        this.return_id = l4;
        this.due_date = num4;
        this.country = str7;
        this.refund_id = l5;
        this.promo_code = str8;
        this.redirect_url = str9;
        this.image_info = str10;
        this.txt_title = str11;
        this.cs_phone = str12;
        this.consignment_id = str13;
        this.pickup_counter = str14;
        this.coffeevoucher = str15;
        this.buyer_phone_number = str16;
        this.reason_code = num5;
        this.coin_count = num6;
        this.specified_action_cate = num7;
        this.withdrawal_id = l6;
        this.end_time = num8;
        this.amount = l7;
        this.withdraw_bankdays = str17;
        this.amount_currency = str18;
        this.nonfulfillrate = str19;
        this.notify = notification;
        this.userid = num9;
        this.count = l8;
        this.withdrawal_sn = str20;
        this.to_userid_list = immutableCopyOf(list);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TriggerNoti(com.shopee.protocol.action.TriggerNoti.Builder r44) {
        /*
            r43 = this;
            r0 = r44
            r1 = r43
            java.lang.String r2 = r0.requestid
            com.shopee.protocol.action.BackendParam r3 = r0.bparam
            java.lang.Integer r4 = r0.noticode
            java.lang.Integer r5 = r0.to_userid
            java.lang.Integer r6 = r0.shopid
            java.lang.Long r7 = r0.itemid
            java.lang.Long r8 = r0.orderid
            java.lang.Long r9 = r0.checkoutid
            java.lang.String r10 = r0.content
            java.lang.String r11 = r0.order_sn
            java.lang.String r12 = r0.checkout_sn
            java.lang.String r13 = r0.return_sn
            java.lang.String r14 = r0.refund_sn
            java.lang.Long r15 = r0.return_id
            r42 = r1
            java.lang.Integer r1 = r0.due_date
            r16 = r1
            java.lang.String r1 = r0.country
            r17 = r1
            java.lang.Long r1 = r0.refund_id
            r18 = r1
            java.lang.String r1 = r0.promo_code
            r19 = r1
            java.lang.String r1 = r0.redirect_url
            r20 = r1
            java.lang.String r1 = r0.image_info
            r21 = r1
            java.lang.String r1 = r0.txt_title
            r22 = r1
            java.lang.String r1 = r0.cs_phone
            r23 = r1
            java.lang.String r1 = r0.consignment_id
            r24 = r1
            java.lang.String r1 = r0.pickup_counter
            r25 = r1
            java.lang.String r1 = r0.coffeevoucher
            r26 = r1
            java.lang.String r1 = r0.buyer_phone_number
            r27 = r1
            java.lang.Integer r1 = r0.reason_code
            r28 = r1
            java.lang.Integer r1 = r0.coin_count
            r29 = r1
            java.lang.Integer r1 = r0.specified_action_cate
            r30 = r1
            java.lang.Long r1 = r0.withdrawal_id
            r31 = r1
            java.lang.Integer r1 = r0.end_time
            r32 = r1
            java.lang.Long r1 = r0.amount
            r33 = r1
            java.lang.String r1 = r0.withdraw_bankdays
            r34 = r1
            java.lang.String r1 = r0.amount_currency
            r35 = r1
            java.lang.String r1 = r0.nonfulfillrate
            r36 = r1
            com.shopee.protocol.action.Notification r1 = r0.notify
            r37 = r1
            java.lang.Integer r1 = r0.userid
            r38 = r1
            java.lang.Long r1 = r0.count
            r39 = r1
            java.lang.String r1 = r0.withdrawal_sn
            r40 = r1
            java.util.List<java.lang.Integer> r1 = r0.to_userid_list
            r41 = r1
            r1 = r42
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r43.setBuilder(r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.TriggerNoti.<init>(com.shopee.protocol.action.TriggerNoti$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TriggerNoti)) {
            return false;
        }
        TriggerNoti triggerNoti = (TriggerNoti) obj;
        if (!equals((Object) this.requestid, (Object) triggerNoti.requestid) || !equals((Object) this.bparam, (Object) triggerNoti.bparam) || !equals((Object) this.noticode, (Object) triggerNoti.noticode) || !equals((Object) this.to_userid, (Object) triggerNoti.to_userid) || !equals((Object) this.shopid, (Object) triggerNoti.shopid) || !equals((Object) this.itemid, (Object) triggerNoti.itemid) || !equals((Object) this.orderid, (Object) triggerNoti.orderid) || !equals((Object) this.checkoutid, (Object) triggerNoti.checkoutid) || !equals((Object) this.content, (Object) triggerNoti.content) || !equals((Object) this.order_sn, (Object) triggerNoti.order_sn) || !equals((Object) this.checkout_sn, (Object) triggerNoti.checkout_sn) || !equals((Object) this.return_sn, (Object) triggerNoti.return_sn) || !equals((Object) this.refund_sn, (Object) triggerNoti.refund_sn) || !equals((Object) this.return_id, (Object) triggerNoti.return_id) || !equals((Object) this.due_date, (Object) triggerNoti.due_date) || !equals((Object) this.country, (Object) triggerNoti.country) || !equals((Object) this.refund_id, (Object) triggerNoti.refund_id) || !equals((Object) this.promo_code, (Object) triggerNoti.promo_code) || !equals((Object) this.redirect_url, (Object) triggerNoti.redirect_url) || !equals((Object) this.image_info, (Object) triggerNoti.image_info) || !equals((Object) this.txt_title, (Object) triggerNoti.txt_title) || !equals((Object) this.cs_phone, (Object) triggerNoti.cs_phone) || !equals((Object) this.consignment_id, (Object) triggerNoti.consignment_id) || !equals((Object) this.pickup_counter, (Object) triggerNoti.pickup_counter) || !equals((Object) this.coffeevoucher, (Object) triggerNoti.coffeevoucher) || !equals((Object) this.buyer_phone_number, (Object) triggerNoti.buyer_phone_number) || !equals((Object) this.reason_code, (Object) triggerNoti.reason_code) || !equals((Object) this.coin_count, (Object) triggerNoti.coin_count) || !equals((Object) this.specified_action_cate, (Object) triggerNoti.specified_action_cate) || !equals((Object) this.withdrawal_id, (Object) triggerNoti.withdrawal_id) || !equals((Object) this.end_time, (Object) triggerNoti.end_time) || !equals((Object) this.amount, (Object) triggerNoti.amount) || !equals((Object) this.withdraw_bankdays, (Object) triggerNoti.withdraw_bankdays) || !equals((Object) this.amount_currency, (Object) triggerNoti.amount_currency) || !equals((Object) this.nonfulfillrate, (Object) triggerNoti.nonfulfillrate) || !equals((Object) this.notify, (Object) triggerNoti.notify) || !equals((Object) this.userid, (Object) triggerNoti.userid) || !equals((Object) this.count, (Object) triggerNoti.count) || !equals((Object) this.withdrawal_sn, (Object) triggerNoti.withdrawal_sn) || !equals((List<?>) this.to_userid_list, (List<?>) triggerNoti.to_userid_list)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.noticode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.to_userid;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.orderid;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.checkoutid;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.content;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.order_sn;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.checkout_sn;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.return_sn;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.refund_sn;
        int hashCode13 = (hashCode12 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Long l4 = this.return_id;
        int hashCode14 = (hashCode13 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num4 = this.due_date;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str7 = this.country;
        int hashCode16 = (hashCode15 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Long l5 = this.refund_id;
        int hashCode17 = (hashCode16 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str8 = this.promo_code;
        int hashCode18 = (hashCode17 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.redirect_url;
        int hashCode19 = (hashCode18 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.image_info;
        int hashCode20 = (hashCode19 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.txt_title;
        int hashCode21 = (hashCode20 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.cs_phone;
        int hashCode22 = (hashCode21 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.consignment_id;
        int hashCode23 = (hashCode22 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.pickup_counter;
        int hashCode24 = (hashCode23 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.coffeevoucher;
        int hashCode25 = (hashCode24 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.buyer_phone_number;
        int hashCode26 = (hashCode25 + (str16 != null ? str16.hashCode() : 0)) * 37;
        Integer num5 = this.reason_code;
        int hashCode27 = (hashCode26 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.coin_count;
        int hashCode28 = (hashCode27 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.specified_action_cate;
        int hashCode29 = (hashCode28 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l6 = this.withdrawal_id;
        int hashCode30 = (hashCode29 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num8 = this.end_time;
        int hashCode31 = (hashCode30 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l7 = this.amount;
        int hashCode32 = (hashCode31 + (l7 != null ? l7.hashCode() : 0)) * 37;
        String str17 = this.withdraw_bankdays;
        int hashCode33 = (hashCode32 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.amount_currency;
        int hashCode34 = (hashCode33 + (str18 != null ? str18.hashCode() : 0)) * 37;
        String str19 = this.nonfulfillrate;
        int hashCode35 = (hashCode34 + (str19 != null ? str19.hashCode() : 0)) * 37;
        Notification notification = this.notify;
        int hashCode36 = (hashCode35 + (notification != null ? notification.hashCode() : 0)) * 37;
        Integer num9 = this.userid;
        int hashCode37 = (hashCode36 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l8 = this.count;
        int hashCode38 = (hashCode37 + (l8 != null ? l8.hashCode() : 0)) * 37;
        String str20 = this.withdrawal_sn;
        if (str20 != null) {
            i2 = str20.hashCode();
        }
        int i3 = (hashCode38 + i2) * 37;
        List<Integer> list = this.to_userid_list;
        int hashCode39 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode39;
        return hashCode39;
    }

    public static final class Builder extends Message.Builder<TriggerNoti> {
        public Long amount;
        public String amount_currency;
        public BackendParam bparam;
        public String buyer_phone_number;
        public String checkout_sn;
        public Long checkoutid;
        public String coffeevoucher;
        public Integer coin_count;
        public String consignment_id;
        public String content;
        public Long count;
        public String country;
        public String cs_phone;
        public Integer due_date;
        public Integer end_time;
        public String image_info;
        public Long itemid;
        public String nonfulfillrate;
        public Integer noticode;
        public Notification notify;
        public String order_sn;
        public Long orderid;
        public String pickup_counter;
        public String promo_code;
        public Integer reason_code;
        public String redirect_url;
        public Long refund_id;
        public String refund_sn;
        public String requestid;
        public Long return_id;
        public String return_sn;
        public Integer shopid;
        public Integer specified_action_cate;
        public Integer to_userid;
        public List<Integer> to_userid_list;
        public String txt_title;
        public Integer userid;
        public String withdraw_bankdays;
        public Long withdrawal_id;
        public String withdrawal_sn;

        public Builder() {
        }

        public Builder(TriggerNoti triggerNoti) {
            super(triggerNoti);
            if (triggerNoti != null) {
                this.requestid = triggerNoti.requestid;
                this.bparam = triggerNoti.bparam;
                this.noticode = triggerNoti.noticode;
                this.to_userid = triggerNoti.to_userid;
                this.shopid = triggerNoti.shopid;
                this.itemid = triggerNoti.itemid;
                this.orderid = triggerNoti.orderid;
                this.checkoutid = triggerNoti.checkoutid;
                this.content = triggerNoti.content;
                this.order_sn = triggerNoti.order_sn;
                this.checkout_sn = triggerNoti.checkout_sn;
                this.return_sn = triggerNoti.return_sn;
                this.refund_sn = triggerNoti.refund_sn;
                this.return_id = triggerNoti.return_id;
                this.due_date = triggerNoti.due_date;
                this.country = triggerNoti.country;
                this.refund_id = triggerNoti.refund_id;
                this.promo_code = triggerNoti.promo_code;
                this.redirect_url = triggerNoti.redirect_url;
                this.image_info = triggerNoti.image_info;
                this.txt_title = triggerNoti.txt_title;
                this.cs_phone = triggerNoti.cs_phone;
                this.consignment_id = triggerNoti.consignment_id;
                this.pickup_counter = triggerNoti.pickup_counter;
                this.coffeevoucher = triggerNoti.coffeevoucher;
                this.buyer_phone_number = triggerNoti.buyer_phone_number;
                this.reason_code = triggerNoti.reason_code;
                this.coin_count = triggerNoti.coin_count;
                this.specified_action_cate = triggerNoti.specified_action_cate;
                this.withdrawal_id = triggerNoti.withdrawal_id;
                this.end_time = triggerNoti.end_time;
                this.amount = triggerNoti.amount;
                this.withdraw_bankdays = triggerNoti.withdraw_bankdays;
                this.amount_currency = triggerNoti.amount_currency;
                this.nonfulfillrate = triggerNoti.nonfulfillrate;
                this.notify = triggerNoti.notify;
                this.userid = triggerNoti.userid;
                this.count = triggerNoti.count;
                this.withdrawal_sn = triggerNoti.withdrawal_sn;
                this.to_userid_list = TriggerNoti.copyOf(triggerNoti.to_userid_list);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder noticode(Integer num) {
            this.noticode = num;
            return this;
        }

        public Builder to_userid(Integer num) {
            this.to_userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
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

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
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

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder due_date(Integer num) {
            this.due_date = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder refund_id(Long l) {
            this.refund_id = l;
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

        public Builder cs_phone(String str) {
            this.cs_phone = str;
            return this;
        }

        public Builder consignment_id(String str) {
            this.consignment_id = str;
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

        public Builder buyer_phone_number(String str) {
            this.buyer_phone_number = str;
            return this;
        }

        public Builder reason_code(Integer num) {
            this.reason_code = num;
            return this;
        }

        public Builder coin_count(Integer num) {
            this.coin_count = num;
            return this;
        }

        public Builder specified_action_cate(Integer num) {
            this.specified_action_cate = num;
            return this;
        }

        public Builder withdrawal_id(Long l) {
            this.withdrawal_id = l;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public Builder withdraw_bankdays(String str) {
            this.withdraw_bankdays = str;
            return this;
        }

        public Builder amount_currency(String str) {
            this.amount_currency = str;
            return this;
        }

        public Builder nonfulfillrate(String str) {
            this.nonfulfillrate = str;
            return this;
        }

        public Builder notify(Notification notification) {
            this.notify = notification;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder count(Long l) {
            this.count = l;
            return this;
        }

        public Builder withdrawal_sn(String str) {
            this.withdrawal_sn = str;
            return this;
        }

        public Builder to_userid_list(List<Integer> list) {
            this.to_userid_list = checkForNulls(list);
            return this;
        }

        public TriggerNoti build() {
            checkRequiredFields();
            return new TriggerNoti(this);
        }
    }
}
