package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CheckoutInfo extends Message {
    public static final Integer DEFAULT_CARD_PROMOTION_ID = 0;
    public static final Integer DEFAULT_CHECKOUT_ORDER_TYPE = 0;
    public static final List<Long> DEFAULT_CHECKOUT_SPLIT_IDS = Collections.emptyList();
    public static final Integer DEFAULT_DB_VERSION = 0;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Integer DEFAULT_FRAUD_CHECK_SKIP_REASON = 0;
    public static final Long DEFAULT_GROUP_BUY_GROUPID = 0L;
    public static final List<CheckoutOrder> DEFAULT_ORDER = Collections.emptyList();
    public static final Integer DEFAULT_PAYBY_DATE = 0;
    public static final String DEFAULT_PAYER_VERI_FAIL_REASON = "";
    public static final Integer DEFAULT_PAYMENT_CARD = 0;
    public static final String DEFAULT_PAYMENT_CHANNEL_NAME = "";
    public static final Long DEFAULT_PRICE_BEFORE_DISCOUNT = 0L;
    public static final Integer DEFAULT_RECEIPT_PROCESSBY_DATE = 0;
    public static final Integer DEFAULT_RECEIPT_PROCESS_WORK_DAYS = 0;
    public static final Integer DEFAULT_RECEIPT_REJECT_TIME = 0;
    public static final Integer DEFAULT_RECEIPT_UPLOAD_TIME = 0;
    public static final Long DEFAULT_TOTAL_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_UNIQUE_CODE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 22)
    public final TxnFeeCheckoutInfo admin_fee;
    @ProtoField(tag = 20)
    public final TxnFeeCheckoutInfo buyer_txn_fee_info;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer card_promotion_id;
    @ProtoField(tag = 16)
    public final CartPriceInfo cart_price_info;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer checkout_order_type;
    @ProtoField(tag = 15)
    public final CheckoutPaymentInfo checkout_payment_info;
    @ProtoField(label = Message.Label.REPEATED, tag = 18, type = Message.Datatype.INT64)
    public final List<Long> checkout_split_ids;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer db_version;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer fraud_check_skip_reason;
    @ProtoField(tag = 21, type = Message.Datatype.INT64)
    public final Long group_buy_groupid;
    @ProtoField(label = Message.Label.REPEATED, messageType = CheckoutOrder.class, tag = 1)
    public final List<CheckoutOrder> order;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer payby_date;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String payer_veri_fail_reason;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer payment_card;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String payment_channel_name;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long price_before_discount;
    @ProtoField(tag = 13)
    public final PromotionInfo promotion_info;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer receipt_process_work_days;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer receipt_processby_date;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer receipt_reject_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer receipt_upload_time;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long total_shipping_fee;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long unique_code;

    public CheckoutInfo(List<CheckoutOrder> list, String str, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Long l2, Integer num8, PromotionInfo promotionInfo, Long l3, CheckoutPaymentInfo checkoutPaymentInfo, CartPriceInfo cartPriceInfo, String str2, List<Long> list2, Integer num9, TxnFeeCheckoutInfo txnFeeCheckoutInfo, Long l4, TxnFeeCheckoutInfo txnFeeCheckoutInfo2, Integer num10, Integer num11) {
        this.order = immutableCopyOf(list);
        this.payment_channel_name = str;
        this.unique_code = l;
        this.payment_card = num;
        this.payby_date = num2;
        this.receipt_upload_time = num3;
        this.receipt_processby_date = num4;
        this.receipt_reject_time = num5;
        this.receipt_process_work_days = num6;
        this.checkout_order_type = num7;
        this.price_before_discount = l2;
        this.discount_percentage = num8;
        this.promotion_info = promotionInfo;
        this.total_shipping_fee = l3;
        this.checkout_payment_info = checkoutPaymentInfo;
        this.cart_price_info = cartPriceInfo;
        this.payer_veri_fail_reason = str2;
        this.checkout_split_ids = immutableCopyOf(list2);
        this.card_promotion_id = num9;
        this.buyer_txn_fee_info = txnFeeCheckoutInfo;
        this.group_buy_groupid = l4;
        this.admin_fee = txnFeeCheckoutInfo2;
        this.db_version = num10;
        this.fraud_check_skip_reason = num11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CheckoutInfo(com.shopee.protocol.shop.CheckoutInfo.Builder r28) {
        /*
            r27 = this;
            r0 = r28
            r1 = r27
            java.util.List<com.shopee.protocol.shop.CheckoutOrder> r2 = r0.order
            java.lang.String r3 = r0.payment_channel_name
            java.lang.Long r4 = r0.unique_code
            java.lang.Integer r5 = r0.payment_card
            java.lang.Integer r6 = r0.payby_date
            java.lang.Integer r7 = r0.receipt_upload_time
            java.lang.Integer r8 = r0.receipt_processby_date
            java.lang.Integer r9 = r0.receipt_reject_time
            java.lang.Integer r10 = r0.receipt_process_work_days
            java.lang.Integer r11 = r0.checkout_order_type
            java.lang.Long r12 = r0.price_before_discount
            java.lang.Integer r13 = r0.discount_percentage
            com.shopee.protocol.shop.PromotionInfo r14 = r0.promotion_info
            java.lang.Long r15 = r0.total_shipping_fee
            r26 = r1
            com.shopee.protocol.shop.CheckoutPaymentInfo r1 = r0.checkout_payment_info
            r16 = r1
            com.shopee.protocol.shop.CartPriceInfo r1 = r0.cart_price_info
            r17 = r1
            java.lang.String r1 = r0.payer_veri_fail_reason
            r18 = r1
            java.util.List<java.lang.Long> r1 = r0.checkout_split_ids
            r19 = r1
            java.lang.Integer r1 = r0.card_promotion_id
            r20 = r1
            com.shopee.protocol.shop.TxnFeeCheckoutInfo r1 = r0.buyer_txn_fee_info
            r21 = r1
            java.lang.Long r1 = r0.group_buy_groupid
            r22 = r1
            com.shopee.protocol.shop.TxnFeeCheckoutInfo r1 = r0.admin_fee
            r23 = r1
            java.lang.Integer r1 = r0.db_version
            r24 = r1
            java.lang.Integer r1 = r0.fraud_check_skip_reason
            r25 = r1
            r1 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r27.setBuilder(r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CheckoutInfo.<init>(com.shopee.protocol.shop.CheckoutInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutInfo)) {
            return false;
        }
        CheckoutInfo checkoutInfo = (CheckoutInfo) obj;
        if (!equals((List<?>) this.order, (List<?>) checkoutInfo.order) || !equals((Object) this.payment_channel_name, (Object) checkoutInfo.payment_channel_name) || !equals((Object) this.unique_code, (Object) checkoutInfo.unique_code) || !equals((Object) this.payment_card, (Object) checkoutInfo.payment_card) || !equals((Object) this.payby_date, (Object) checkoutInfo.payby_date) || !equals((Object) this.receipt_upload_time, (Object) checkoutInfo.receipt_upload_time) || !equals((Object) this.receipt_processby_date, (Object) checkoutInfo.receipt_processby_date) || !equals((Object) this.receipt_reject_time, (Object) checkoutInfo.receipt_reject_time) || !equals((Object) this.receipt_process_work_days, (Object) checkoutInfo.receipt_process_work_days) || !equals((Object) this.checkout_order_type, (Object) checkoutInfo.checkout_order_type) || !equals((Object) this.price_before_discount, (Object) checkoutInfo.price_before_discount) || !equals((Object) this.discount_percentage, (Object) checkoutInfo.discount_percentage) || !equals((Object) this.promotion_info, (Object) checkoutInfo.promotion_info) || !equals((Object) this.total_shipping_fee, (Object) checkoutInfo.total_shipping_fee) || !equals((Object) this.checkout_payment_info, (Object) checkoutInfo.checkout_payment_info) || !equals((Object) this.cart_price_info, (Object) checkoutInfo.cart_price_info) || !equals((Object) this.payer_veri_fail_reason, (Object) checkoutInfo.payer_veri_fail_reason) || !equals((List<?>) this.checkout_split_ids, (List<?>) checkoutInfo.checkout_split_ids) || !equals((Object) this.card_promotion_id, (Object) checkoutInfo.card_promotion_id) || !equals((Object) this.buyer_txn_fee_info, (Object) checkoutInfo.buyer_txn_fee_info) || !equals((Object) this.group_buy_groupid, (Object) checkoutInfo.group_buy_groupid) || !equals((Object) this.admin_fee, (Object) checkoutInfo.admin_fee) || !equals((Object) this.db_version, (Object) checkoutInfo.db_version) || !equals((Object) this.fraud_check_skip_reason, (Object) checkoutInfo.fraud_check_skip_reason)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<CheckoutOrder> list = this.order;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.payment_channel_name;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.unique_code;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.payment_card;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.payby_date;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.receipt_upload_time;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.receipt_processby_date;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.receipt_reject_time;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.receipt_process_work_days;
        int hashCode9 = (hashCode8 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.checkout_order_type;
        int hashCode10 = (hashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l2 = this.price_before_discount;
        int hashCode11 = (hashCode10 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num8 = this.discount_percentage;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        PromotionInfo promotionInfo = this.promotion_info;
        int hashCode13 = (hashCode12 + (promotionInfo != null ? promotionInfo.hashCode() : 0)) * 37;
        Long l3 = this.total_shipping_fee;
        int hashCode14 = (hashCode13 + (l3 != null ? l3.hashCode() : 0)) * 37;
        CheckoutPaymentInfo checkoutPaymentInfo = this.checkout_payment_info;
        int hashCode15 = (hashCode14 + (checkoutPaymentInfo != null ? checkoutPaymentInfo.hashCode() : 0)) * 37;
        CartPriceInfo cartPriceInfo = this.cart_price_info;
        int hashCode16 = (hashCode15 + (cartPriceInfo != null ? cartPriceInfo.hashCode() : 0)) * 37;
        String str2 = this.payer_veri_fail_reason;
        int hashCode17 = (hashCode16 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Long> list2 = this.checkout_split_ids;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i4 = (hashCode17 + i2) * 37;
        Integer num9 = this.card_promotion_id;
        int hashCode18 = (i4 + (num9 != null ? num9.hashCode() : 0)) * 37;
        TxnFeeCheckoutInfo txnFeeCheckoutInfo = this.buyer_txn_fee_info;
        int hashCode19 = (hashCode18 + (txnFeeCheckoutInfo != null ? txnFeeCheckoutInfo.hashCode() : 0)) * 37;
        Long l4 = this.group_buy_groupid;
        int hashCode20 = (hashCode19 + (l4 != null ? l4.hashCode() : 0)) * 37;
        TxnFeeCheckoutInfo txnFeeCheckoutInfo2 = this.admin_fee;
        int hashCode21 = (hashCode20 + (txnFeeCheckoutInfo2 != null ? txnFeeCheckoutInfo2.hashCode() : 0)) * 37;
        Integer num10 = this.db_version;
        int hashCode22 = (hashCode21 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.fraud_check_skip_reason;
        if (num11 != null) {
            i3 = num11.hashCode();
        }
        int i5 = hashCode22 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CheckoutInfo> {
        public TxnFeeCheckoutInfo admin_fee;
        public TxnFeeCheckoutInfo buyer_txn_fee_info;
        public Integer card_promotion_id;
        public CartPriceInfo cart_price_info;
        public Integer checkout_order_type;
        public CheckoutPaymentInfo checkout_payment_info;
        public List<Long> checkout_split_ids;
        public Integer db_version;
        public Integer discount_percentage;
        public Integer fraud_check_skip_reason;
        public Long group_buy_groupid;
        public List<CheckoutOrder> order;
        public Integer payby_date;
        public String payer_veri_fail_reason;
        public Integer payment_card;
        public String payment_channel_name;
        public Long price_before_discount;
        public PromotionInfo promotion_info;
        public Integer receipt_process_work_days;
        public Integer receipt_processby_date;
        public Integer receipt_reject_time;
        public Integer receipt_upload_time;
        public Long total_shipping_fee;
        public Long unique_code;

        public Builder() {
        }

        public Builder(CheckoutInfo checkoutInfo) {
            super(checkoutInfo);
            if (checkoutInfo != null) {
                this.order = CheckoutInfo.copyOf(checkoutInfo.order);
                this.payment_channel_name = checkoutInfo.payment_channel_name;
                this.unique_code = checkoutInfo.unique_code;
                this.payment_card = checkoutInfo.payment_card;
                this.payby_date = checkoutInfo.payby_date;
                this.receipt_upload_time = checkoutInfo.receipt_upload_time;
                this.receipt_processby_date = checkoutInfo.receipt_processby_date;
                this.receipt_reject_time = checkoutInfo.receipt_reject_time;
                this.receipt_process_work_days = checkoutInfo.receipt_process_work_days;
                this.checkout_order_type = checkoutInfo.checkout_order_type;
                this.price_before_discount = checkoutInfo.price_before_discount;
                this.discount_percentage = checkoutInfo.discount_percentage;
                this.promotion_info = checkoutInfo.promotion_info;
                this.total_shipping_fee = checkoutInfo.total_shipping_fee;
                this.checkout_payment_info = checkoutInfo.checkout_payment_info;
                this.cart_price_info = checkoutInfo.cart_price_info;
                this.payer_veri_fail_reason = checkoutInfo.payer_veri_fail_reason;
                this.checkout_split_ids = CheckoutInfo.copyOf(checkoutInfo.checkout_split_ids);
                this.card_promotion_id = checkoutInfo.card_promotion_id;
                this.buyer_txn_fee_info = checkoutInfo.buyer_txn_fee_info;
                this.group_buy_groupid = checkoutInfo.group_buy_groupid;
                this.admin_fee = checkoutInfo.admin_fee;
                this.db_version = checkoutInfo.db_version;
                this.fraud_check_skip_reason = checkoutInfo.fraud_check_skip_reason;
            }
        }

        public Builder order(List<CheckoutOrder> list) {
            this.order = checkForNulls(list);
            return this;
        }

        public Builder payment_channel_name(String str) {
            this.payment_channel_name = str;
            return this;
        }

        public Builder unique_code(Long l) {
            this.unique_code = l;
            return this;
        }

        public Builder payment_card(Integer num) {
            this.payment_card = num;
            return this;
        }

        public Builder payby_date(Integer num) {
            this.payby_date = num;
            return this;
        }

        public Builder receipt_upload_time(Integer num) {
            this.receipt_upload_time = num;
            return this;
        }

        public Builder receipt_processby_date(Integer num) {
            this.receipt_processby_date = num;
            return this;
        }

        public Builder receipt_reject_time(Integer num) {
            this.receipt_reject_time = num;
            return this;
        }

        public Builder receipt_process_work_days(Integer num) {
            this.receipt_process_work_days = num;
            return this;
        }

        public Builder checkout_order_type(Integer num) {
            this.checkout_order_type = num;
            return this;
        }

        public Builder price_before_discount(Long l) {
            this.price_before_discount = l;
            return this;
        }

        public Builder discount_percentage(Integer num) {
            this.discount_percentage = num;
            return this;
        }

        public Builder promotion_info(PromotionInfo promotionInfo) {
            this.promotion_info = promotionInfo;
            return this;
        }

        public Builder total_shipping_fee(Long l) {
            this.total_shipping_fee = l;
            return this;
        }

        public Builder checkout_payment_info(CheckoutPaymentInfo checkoutPaymentInfo) {
            this.checkout_payment_info = checkoutPaymentInfo;
            return this;
        }

        public Builder cart_price_info(CartPriceInfo cartPriceInfo) {
            this.cart_price_info = cartPriceInfo;
            return this;
        }

        public Builder payer_veri_fail_reason(String str) {
            this.payer_veri_fail_reason = str;
            return this;
        }

        public Builder checkout_split_ids(List<Long> list) {
            this.checkout_split_ids = checkForNulls(list);
            return this;
        }

        public Builder card_promotion_id(Integer num) {
            this.card_promotion_id = num;
            return this;
        }

        public Builder buyer_txn_fee_info(TxnFeeCheckoutInfo txnFeeCheckoutInfo) {
            this.buyer_txn_fee_info = txnFeeCheckoutInfo;
            return this;
        }

        public Builder group_buy_groupid(Long l) {
            this.group_buy_groupid = l;
            return this;
        }

        public Builder admin_fee(TxnFeeCheckoutInfo txnFeeCheckoutInfo) {
            this.admin_fee = txnFeeCheckoutInfo;
            return this;
        }

        public Builder db_version(Integer num) {
            this.db_version = num;
            return this;
        }

        public Builder fraud_check_skip_reason(Integer num) {
            this.fraud_check_skip_reason = num;
            return this;
        }

        public CheckoutInfo build() {
            return new CheckoutInfo(this);
        }
    }
}
