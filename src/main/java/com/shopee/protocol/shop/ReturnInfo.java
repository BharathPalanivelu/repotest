package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ReturnInfo extends Message {
    public static final Integer DEFAULT_ACCEPTED_TIME = 0;
    public static final Integer DEFAULT_ACTUAL_DELIVER_TIME = 0;
    public static final Long DEFAULT_ADMIN_FEE = 0L;
    public static final Long DEFAULT_AMOUNT_BEFORE_DISCOUNT = 0L;
    public static final Boolean DEFAULT_AUTO_APPROVE_RETURN_PROCESSING = false;
    public static final String DEFAULT_BUYER_EMAIL = "";
    public static final String DEFAULT_BUYER_IMAGES = "";
    public static final String DEFAULT_BUYER_PHONE_NUMBER = "";
    public static final String DEFAULT_BUYER_REAL_NAME = "";
    public static final Long DEFAULT_BUYER_TXN_FEE = 0L;
    public static final Integer DEFAULT_CANCELLED_TIME = 0;
    public static final Long DEFAULT_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_CLOSED_TIME = 0;
    public static final Long DEFAULT_COIN_EARN_BY_VOUCHER_REFUND = 0L;
    public static final Long DEFAULT_COIN_EARN_REFUND = 0L;
    public static final Long DEFAULT_COIN_SPEND_REFUND = 0L;
    public static final Integer DEFAULT_DISCOUNT_PERCENTAGE = 0;
    public static final Integer DEFAULT_DISPUTE_REASON = 0;
    public static final String DEFAULT_DISPUTE_TEXT_REASON = "";
    public static final String DEFAULT_IMAGES = "";
    public static final Boolean DEFAULT_IS_SHIP_FROM_OVERSEAS = false;
    public static final List<OrderItem> DEFAULT_ITEM = Collections.emptyList();
    public static final List<Long> DEFAULT_ITEMID = Collections.emptyList();
    public static final String DEFAULT_JUDGE_REMARKS = "";
    public static final Integer DEFAULT_JUDGING_TIME = 0;
    public static final Integer DEFAULT_LOGISTICS_ERROR_CODE = 0;
    public static final String DEFAULT_LOGISTICS_REMARKS = "";
    public static final Long DEFAULT_MAX_REFUNDABLE_AMOUNT = 0L;
    public static final List<Long> DEFAULT_MODELID = Collections.emptyList();
    public static final Boolean DEFAULT_NEEDS_LOGISTICS = false;
    public static final Long DEFAULT_ORIGIN_SHIPPING_FEE = 0L;
    public static final Boolean DEFAULT_PHYSICAL_RETURN_ALLOWED = false;
    public static final Integer DEFAULT_PROCESSING_TIME = 0;
    public static final Integer DEFAULT_REFUNDPAID_TIME = 0;
    public static final Boolean DEFAULT_REFUND_AMOUNT_ADJUSTABLE = false;
    public static final Long DEFAULT_REFUND_AMOUNT_FROM_SELLER = 0L;
    public static final Integer DEFAULT_REQUESTED_TIME = 0;
    public static final Integer DEFAULT_RETURN_SELLER_DUE_DATE = 0;
    public static final Integer DEFAULT_RETURN_SHIP_DUE_DATE = 0;
    public static final Integer DEFAULT_RETURN_SOLUTION = 0;
    public static final Integer DEFAULT_SELLER_DISPUTE_TIME = 0;
    public static final Integer DEFAULT_SELLER_DUE_DATE = 0;
    public static final String DEFAULT_SELLER_EMAIL = "";
    public static final Long DEFAULT_SELLER_REFUND_AMOUNT = 0L;
    public static final Integer DEFAULT_SELLER_REPLY_DUE_DATE = 0;
    public static final Long DEFAULT_SERVICE_FEE_AMOUNT = 0L;
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_SHIPPING_METHOD = 0;
    public static final Boolean DEFAULT_SHOPEE_HANDLE = false;
    public static final String DEFAULT_SLS_TRACKING_NUMBER = "";
    public static final String DEFAULT_TEXT_REASON = "";
    public static final String DEFAULT_TRACKING_NUMBER = "";
    public static final Boolean DEFAULT_WAREHOUSE_VALIDATION = false;
    public static final Boolean DEFAULT_WITH_RESOLUTION_CENTER = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer accepted_time;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer actual_deliver_time;
    @ProtoField(tag = 49, type = Message.Datatype.INT64)
    public final Long admin_fee;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long amount_before_discount;
    @ProtoField(tag = 61, type = Message.Datatype.BOOL)
    public final Boolean auto_approve_return_processing;
    @ProtoField(tag = 21)
    public final BankAccountInfo bank_account;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String buyer_email;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String buyer_images;
    @ProtoField(tag = 51, type = Message.Datatype.STRING)
    public final String buyer_phone_number;
    @ProtoField(tag = 50, type = Message.Datatype.STRING)
    public final String buyer_real_name;
    @ProtoField(tag = 46, type = Message.Datatype.INT64)
    public final Long buyer_txn_fee;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer cancelled_time;
    @ProtoField(tag = 26)
    public final CardPromotionOrderInfo card_promotion_info;
    @ProtoField(tag = 34, type = Message.Datatype.INT64)
    public final Long carrier_shipping_fee;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer closed_time;
    @ProtoField(tag = 47, type = Message.Datatype.INT64)
    public final Long coin_earn_by_voucher_refund;
    @ProtoField(tag = 24, type = Message.Datatype.INT64)
    public final Long coin_earn_refund;
    @ProtoField(tag = 23, type = Message.Datatype.INT64)
    public final Long coin_spend_refund;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer discount_percentage;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer dispute_reason;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String dispute_text_reason;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 52, type = Message.Datatype.BOOL)
    public final Boolean is_ship_from_overseas;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItem.class, tag = 4)
    public final List<OrderItem> item;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> itemid;
    @ProtoField(tag = 38, type = Message.Datatype.STRING)
    public final String judge_remarks;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer judging_time;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer logistics_error_code;
    @ProtoField(tag = 31)
    public final OrderLogisticsInfo logistics_info;
    @ProtoField(tag = 41, type = Message.Datatype.STRING)
    public final String logistics_remarks;
    @ProtoField(tag = 56, type = Message.Datatype.INT64)
    public final Long max_refundable_amount;
    @ProtoField(label = Message.Label.REPEATED, tag = 20, type = Message.Datatype.INT64)
    public final List<Long> modelid;
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean needs_logistics;
    @ProtoField(tag = 35, type = Message.Datatype.INT64)
    public final Long origin_shipping_fee;
    @ProtoField(tag = 60, type = Message.Datatype.BOOL)
    public final Boolean physical_return_allowed;
    @ProtoField(tag = 42, type = Message.Datatype.INT32)
    public final Integer processing_time;
    @ProtoField(tag = 18)
    public final PromotionInfo promotion_info;
    @ProtoField(tag = 58, type = Message.Datatype.BOOL)
    public final Boolean refund_amount_adjustable;
    @ProtoField(tag = 57, type = Message.Datatype.INT64)
    public final Long refund_amount_from_seller;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer refundpaid_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer requested_time;
    @ProtoField(tag = 32)
    public final BuyerAddress return_delivery_address;
    @ProtoField(tag = 28)
    public final BuyerAddress return_pickup_address;
    @ProtoField(tag = 44, type = Message.Datatype.INT32)
    public final Integer return_seller_due_date;
    @ProtoField(tag = 43, type = Message.Datatype.INT32)
    public final Integer return_ship_due_date;
    @ProtoField(tag = 55, type = Message.Datatype.INT32)
    public final Integer return_solution;
    @ProtoField(tag = 45)
    public final SecondLegShipment second_leg_shipment;
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer seller_dispute_time;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer seller_due_date;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String seller_email;
    @ProtoField(tag = 25, type = Message.Datatype.INT64)
    public final Long seller_refund_amount;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer seller_reply_due_date;
    @ProtoField(tag = 59, type = Message.Datatype.INT64)
    public final Long service_fee_amount;
    @ProtoField(tag = 40, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long shipping_fee;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer shipping_method;
    @ProtoField(tag = 48, type = Message.Datatype.BOOL)
    public final Boolean shopee_handle;
    @ProtoField(tag = 53, type = Message.Datatype.STRING)
    public final String sls_tracking_number;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String text_reason;
    @ProtoField(tag = 29, type = Message.Datatype.STRING)
    public final String tracking_number;
    @ProtoField(tag = 62, type = Message.Datatype.BOOL)
    public final Boolean warehouse_validation;
    @ProtoField(tag = 54, type = Message.Datatype.BOOL)
    public final Boolean with_resolution_center;

    public ReturnInfo(List<Long> list, String str, String str2, List<OrderItem> list2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str3, Integer num7, Integer num8, String str4, Integer num9, Long l, Integer num10, PromotionInfo promotionInfo, Long l2, List<Long> list3, BankAccountInfo bankAccountInfo, String str5, Long l3, Long l4, Long l5, CardPromotionOrderInfo cardPromotionOrderInfo, String str6, BuyerAddress buyerAddress, String str7, Boolean bool, OrderLogisticsInfo orderLogisticsInfo, BuyerAddress buyerAddress2, Integer num11, Long l6, Long l7, Integer num12, Integer num13, String str8, Integer num14, String str9, String str10, Integer num15, Integer num16, Integer num17, SecondLegShipment secondLegShipment, Long l8, Long l9, Boolean bool2, Long l10, String str11, String str12, Boolean bool3, String str13, Boolean bool4, Integer num18, Long l11, Long l12, Boolean bool5, Long l13, Boolean bool6, Boolean bool7, Boolean bool8) {
        this.itemid = immutableCopyOf(list);
        this.buyer_email = str;
        this.seller_email = str2;
        this.item = immutableCopyOf(list2);
        this.requested_time = num;
        this.accepted_time = num2;
        this.cancelled_time = num3;
        this.judging_time = num4;
        this.refundpaid_time = num5;
        this.closed_time = num6;
        this.text_reason = str3;
        this.seller_due_date = num7;
        this.dispute_reason = num8;
        this.dispute_text_reason = str4;
        this.seller_reply_due_date = num9;
        this.amount_before_discount = l;
        this.discount_percentage = num10;
        this.promotion_info = promotionInfo;
        this.shipping_fee = l2;
        this.modelid = immutableCopyOf(list3);
        this.bank_account = bankAccountInfo;
        this.images = str5;
        this.coin_spend_refund = l3;
        this.coin_earn_refund = l4;
        this.seller_refund_amount = l5;
        this.card_promotion_info = cardPromotionOrderInfo;
        this.buyer_images = str6;
        this.return_pickup_address = buyerAddress;
        this.tracking_number = str7;
        this.needs_logistics = bool;
        this.logistics_info = orderLogisticsInfo;
        this.return_delivery_address = buyerAddress2;
        this.shipping_method = num11;
        this.carrier_shipping_fee = l6;
        this.origin_shipping_fee = l7;
        this.actual_deliver_time = num12;
        this.logistics_error_code = num13;
        this.judge_remarks = str8;
        this.seller_dispute_time = num14;
        this.shipping_carrier = str9;
        this.logistics_remarks = str10;
        this.processing_time = num15;
        this.return_ship_due_date = num16;
        this.return_seller_due_date = num17;
        this.second_leg_shipment = secondLegShipment;
        this.buyer_txn_fee = l8;
        this.coin_earn_by_voucher_refund = l9;
        this.shopee_handle = bool2;
        this.admin_fee = l10;
        this.buyer_real_name = str11;
        this.buyer_phone_number = str12;
        this.is_ship_from_overseas = bool3;
        this.sls_tracking_number = str13;
        this.with_resolution_center = bool4;
        this.return_solution = num18;
        this.max_refundable_amount = l11;
        this.refund_amount_from_seller = l12;
        this.refund_amount_adjustable = bool5;
        this.service_fee_amount = l13;
        this.physical_return_allowed = bool6;
        this.auto_approve_return_processing = bool7;
        this.warehouse_validation = bool8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ReturnInfo(com.shopee.protocol.shop.ReturnInfo.Builder r66) {
        /*
            r65 = this;
            r0 = r66
            r1 = r65
            java.util.List<java.lang.Long> r2 = r0.itemid
            java.lang.String r3 = r0.buyer_email
            java.lang.String r4 = r0.seller_email
            java.util.List<com.shopee.protocol.shop.OrderItem> r5 = r0.item
            java.lang.Integer r6 = r0.requested_time
            java.lang.Integer r7 = r0.accepted_time
            java.lang.Integer r8 = r0.cancelled_time
            java.lang.Integer r9 = r0.judging_time
            java.lang.Integer r10 = r0.refundpaid_time
            java.lang.Integer r11 = r0.closed_time
            java.lang.String r12 = r0.text_reason
            java.lang.Integer r13 = r0.seller_due_date
            java.lang.Integer r14 = r0.dispute_reason
            java.lang.String r15 = r0.dispute_text_reason
            r64 = r1
            java.lang.Integer r1 = r0.seller_reply_due_date
            r16 = r1
            java.lang.Long r1 = r0.amount_before_discount
            r17 = r1
            java.lang.Integer r1 = r0.discount_percentage
            r18 = r1
            com.shopee.protocol.shop.PromotionInfo r1 = r0.promotion_info
            r19 = r1
            java.lang.Long r1 = r0.shipping_fee
            r20 = r1
            java.util.List<java.lang.Long> r1 = r0.modelid
            r21 = r1
            com.shopee.protocol.shop.BankAccountInfo r1 = r0.bank_account
            r22 = r1
            java.lang.String r1 = r0.images
            r23 = r1
            java.lang.Long r1 = r0.coin_spend_refund
            r24 = r1
            java.lang.Long r1 = r0.coin_earn_refund
            r25 = r1
            java.lang.Long r1 = r0.seller_refund_amount
            r26 = r1
            com.shopee.protocol.shop.CardPromotionOrderInfo r1 = r0.card_promotion_info
            r27 = r1
            java.lang.String r1 = r0.buyer_images
            r28 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.return_pickup_address
            r29 = r1
            java.lang.String r1 = r0.tracking_number
            r30 = r1
            java.lang.Boolean r1 = r0.needs_logistics
            r31 = r1
            com.shopee.protocol.shop.OrderLogisticsInfo r1 = r0.logistics_info
            r32 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.return_delivery_address
            r33 = r1
            java.lang.Integer r1 = r0.shipping_method
            r34 = r1
            java.lang.Long r1 = r0.carrier_shipping_fee
            r35 = r1
            java.lang.Long r1 = r0.origin_shipping_fee
            r36 = r1
            java.lang.Integer r1 = r0.actual_deliver_time
            r37 = r1
            java.lang.Integer r1 = r0.logistics_error_code
            r38 = r1
            java.lang.String r1 = r0.judge_remarks
            r39 = r1
            java.lang.Integer r1 = r0.seller_dispute_time
            r40 = r1
            java.lang.String r1 = r0.shipping_carrier
            r41 = r1
            java.lang.String r1 = r0.logistics_remarks
            r42 = r1
            java.lang.Integer r1 = r0.processing_time
            r43 = r1
            java.lang.Integer r1 = r0.return_ship_due_date
            r44 = r1
            java.lang.Integer r1 = r0.return_seller_due_date
            r45 = r1
            com.shopee.protocol.shop.SecondLegShipment r1 = r0.second_leg_shipment
            r46 = r1
            java.lang.Long r1 = r0.buyer_txn_fee
            r47 = r1
            java.lang.Long r1 = r0.coin_earn_by_voucher_refund
            r48 = r1
            java.lang.Boolean r1 = r0.shopee_handle
            r49 = r1
            java.lang.Long r1 = r0.admin_fee
            r50 = r1
            java.lang.String r1 = r0.buyer_real_name
            r51 = r1
            java.lang.String r1 = r0.buyer_phone_number
            r52 = r1
            java.lang.Boolean r1 = r0.is_ship_from_overseas
            r53 = r1
            java.lang.String r1 = r0.sls_tracking_number
            r54 = r1
            java.lang.Boolean r1 = r0.with_resolution_center
            r55 = r1
            java.lang.Integer r1 = r0.return_solution
            r56 = r1
            java.lang.Long r1 = r0.max_refundable_amount
            r57 = r1
            java.lang.Long r1 = r0.refund_amount_from_seller
            r58 = r1
            java.lang.Boolean r1 = r0.refund_amount_adjustable
            r59 = r1
            java.lang.Long r1 = r0.service_fee_amount
            r60 = r1
            java.lang.Boolean r1 = r0.physical_return_allowed
            r61 = r1
            java.lang.Boolean r1 = r0.auto_approve_return_processing
            r62 = r1
            java.lang.Boolean r1 = r0.warehouse_validation
            r63 = r1
            r1 = r64
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63)
            r65.setBuilder(r66)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ReturnInfo.<init>(com.shopee.protocol.shop.ReturnInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReturnInfo)) {
            return false;
        }
        ReturnInfo returnInfo = (ReturnInfo) obj;
        if (!equals((List<?>) this.itemid, (List<?>) returnInfo.itemid) || !equals((Object) this.buyer_email, (Object) returnInfo.buyer_email) || !equals((Object) this.seller_email, (Object) returnInfo.seller_email) || !equals((List<?>) this.item, (List<?>) returnInfo.item) || !equals((Object) this.requested_time, (Object) returnInfo.requested_time) || !equals((Object) this.accepted_time, (Object) returnInfo.accepted_time) || !equals((Object) this.cancelled_time, (Object) returnInfo.cancelled_time) || !equals((Object) this.judging_time, (Object) returnInfo.judging_time) || !equals((Object) this.refundpaid_time, (Object) returnInfo.refundpaid_time) || !equals((Object) this.closed_time, (Object) returnInfo.closed_time) || !equals((Object) this.text_reason, (Object) returnInfo.text_reason) || !equals((Object) this.seller_due_date, (Object) returnInfo.seller_due_date) || !equals((Object) this.dispute_reason, (Object) returnInfo.dispute_reason) || !equals((Object) this.dispute_text_reason, (Object) returnInfo.dispute_text_reason) || !equals((Object) this.seller_reply_due_date, (Object) returnInfo.seller_reply_due_date) || !equals((Object) this.amount_before_discount, (Object) returnInfo.amount_before_discount) || !equals((Object) this.discount_percentage, (Object) returnInfo.discount_percentage) || !equals((Object) this.promotion_info, (Object) returnInfo.promotion_info) || !equals((Object) this.shipping_fee, (Object) returnInfo.shipping_fee) || !equals((List<?>) this.modelid, (List<?>) returnInfo.modelid) || !equals((Object) this.bank_account, (Object) returnInfo.bank_account) || !equals((Object) this.images, (Object) returnInfo.images) || !equals((Object) this.coin_spend_refund, (Object) returnInfo.coin_spend_refund) || !equals((Object) this.coin_earn_refund, (Object) returnInfo.coin_earn_refund) || !equals((Object) this.seller_refund_amount, (Object) returnInfo.seller_refund_amount) || !equals((Object) this.card_promotion_info, (Object) returnInfo.card_promotion_info) || !equals((Object) this.buyer_images, (Object) returnInfo.buyer_images) || !equals((Object) this.return_pickup_address, (Object) returnInfo.return_pickup_address) || !equals((Object) this.tracking_number, (Object) returnInfo.tracking_number) || !equals((Object) this.needs_logistics, (Object) returnInfo.needs_logistics) || !equals((Object) this.logistics_info, (Object) returnInfo.logistics_info) || !equals((Object) this.return_delivery_address, (Object) returnInfo.return_delivery_address) || !equals((Object) this.shipping_method, (Object) returnInfo.shipping_method) || !equals((Object) this.carrier_shipping_fee, (Object) returnInfo.carrier_shipping_fee) || !equals((Object) this.origin_shipping_fee, (Object) returnInfo.origin_shipping_fee) || !equals((Object) this.actual_deliver_time, (Object) returnInfo.actual_deliver_time) || !equals((Object) this.logistics_error_code, (Object) returnInfo.logistics_error_code) || !equals((Object) this.judge_remarks, (Object) returnInfo.judge_remarks) || !equals((Object) this.seller_dispute_time, (Object) returnInfo.seller_dispute_time) || !equals((Object) this.shipping_carrier, (Object) returnInfo.shipping_carrier) || !equals((Object) this.logistics_remarks, (Object) returnInfo.logistics_remarks) || !equals((Object) this.processing_time, (Object) returnInfo.processing_time) || !equals((Object) this.return_ship_due_date, (Object) returnInfo.return_ship_due_date) || !equals((Object) this.return_seller_due_date, (Object) returnInfo.return_seller_due_date) || !equals((Object) this.second_leg_shipment, (Object) returnInfo.second_leg_shipment) || !equals((Object) this.buyer_txn_fee, (Object) returnInfo.buyer_txn_fee) || !equals((Object) this.coin_earn_by_voucher_refund, (Object) returnInfo.coin_earn_by_voucher_refund) || !equals((Object) this.shopee_handle, (Object) returnInfo.shopee_handle) || !equals((Object) this.admin_fee, (Object) returnInfo.admin_fee) || !equals((Object) this.buyer_real_name, (Object) returnInfo.buyer_real_name) || !equals((Object) this.buyer_phone_number, (Object) returnInfo.buyer_phone_number) || !equals((Object) this.is_ship_from_overseas, (Object) returnInfo.is_ship_from_overseas) || !equals((Object) this.sls_tracking_number, (Object) returnInfo.sls_tracking_number) || !equals((Object) this.with_resolution_center, (Object) returnInfo.with_resolution_center) || !equals((Object) this.return_solution, (Object) returnInfo.return_solution) || !equals((Object) this.max_refundable_amount, (Object) returnInfo.max_refundable_amount) || !equals((Object) this.refund_amount_from_seller, (Object) returnInfo.refund_amount_from_seller) || !equals((Object) this.refund_amount_adjustable, (Object) returnInfo.refund_amount_adjustable) || !equals((Object) this.service_fee_amount, (Object) returnInfo.service_fee_amount) || !equals((Object) this.physical_return_allowed, (Object) returnInfo.physical_return_allowed) || !equals((Object) this.auto_approve_return_processing, (Object) returnInfo.auto_approve_return_processing) || !equals((Object) this.warehouse_validation, (Object) returnInfo.warehouse_validation)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.itemid;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.buyer_email;
        int i3 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.seller_email;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<OrderItem> list2 = this.item;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num = this.requested_time;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.accepted_time;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.cancelled_time;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.judging_time;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.refundpaid_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.closed_time;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str3 = this.text_reason;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num7 = this.seller_due_date;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.dispute_reason;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str4 = this.dispute_text_reason;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num9 = this.seller_reply_due_date;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l = this.amount_before_discount;
        int hashCode16 = (hashCode15 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num10 = this.discount_percentage;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        PromotionInfo promotionInfo = this.promotion_info;
        int hashCode18 = (hashCode17 + (promotionInfo != null ? promotionInfo.hashCode() : 0)) * 37;
        Long l2 = this.shipping_fee;
        int hashCode19 = (hashCode18 + (l2 != null ? l2.hashCode() : 0)) * 37;
        List<Long> list3 = this.modelid;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i4 = (hashCode19 + i2) * 37;
        BankAccountInfo bankAccountInfo = this.bank_account;
        int hashCode20 = (i4 + (bankAccountInfo != null ? bankAccountInfo.hashCode() : 0)) * 37;
        String str5 = this.images;
        int hashCode21 = (hashCode20 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l3 = this.coin_spend_refund;
        int hashCode22 = (hashCode21 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.coin_earn_refund;
        int hashCode23 = (hashCode22 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.seller_refund_amount;
        int hashCode24 = (hashCode23 + (l5 != null ? l5.hashCode() : 0)) * 37;
        CardPromotionOrderInfo cardPromotionOrderInfo = this.card_promotion_info;
        int hashCode25 = (hashCode24 + (cardPromotionOrderInfo != null ? cardPromotionOrderInfo.hashCode() : 0)) * 37;
        String str6 = this.buyer_images;
        int hashCode26 = (hashCode25 + (str6 != null ? str6.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.return_pickup_address;
        int hashCode27 = (hashCode26 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        String str7 = this.tracking_number;
        int hashCode28 = (hashCode27 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool = this.needs_logistics;
        int hashCode29 = (hashCode28 + (bool != null ? bool.hashCode() : 0)) * 37;
        OrderLogisticsInfo orderLogisticsInfo = this.logistics_info;
        int hashCode30 = (hashCode29 + (orderLogisticsInfo != null ? orderLogisticsInfo.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress2 = this.return_delivery_address;
        int hashCode31 = (hashCode30 + (buyerAddress2 != null ? buyerAddress2.hashCode() : 0)) * 37;
        Integer num11 = this.shipping_method;
        int hashCode32 = (hashCode31 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Long l6 = this.carrier_shipping_fee;
        int hashCode33 = (hashCode32 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.origin_shipping_fee;
        int hashCode34 = (hashCode33 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num12 = this.actual_deliver_time;
        int hashCode35 = (hashCode34 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.logistics_error_code;
        int hashCode36 = (hashCode35 + (num13 != null ? num13.hashCode() : 0)) * 37;
        String str8 = this.judge_remarks;
        int hashCode37 = (hashCode36 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num14 = this.seller_dispute_time;
        int hashCode38 = (hashCode37 + (num14 != null ? num14.hashCode() : 0)) * 37;
        String str9 = this.shipping_carrier;
        int hashCode39 = (hashCode38 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.logistics_remarks;
        int hashCode40 = (hashCode39 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num15 = this.processing_time;
        int hashCode41 = (hashCode40 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.return_ship_due_date;
        int hashCode42 = (hashCode41 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.return_seller_due_date;
        int hashCode43 = (hashCode42 + (num17 != null ? num17.hashCode() : 0)) * 37;
        SecondLegShipment secondLegShipment = this.second_leg_shipment;
        int hashCode44 = (hashCode43 + (secondLegShipment != null ? secondLegShipment.hashCode() : 0)) * 37;
        Long l8 = this.buyer_txn_fee;
        int hashCode45 = (hashCode44 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.coin_earn_by_voucher_refund;
        int hashCode46 = (hashCode45 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Boolean bool2 = this.shopee_handle;
        int hashCode47 = (hashCode46 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Long l10 = this.admin_fee;
        int hashCode48 = (hashCode47 + (l10 != null ? l10.hashCode() : 0)) * 37;
        String str11 = this.buyer_real_name;
        int hashCode49 = (hashCode48 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.buyer_phone_number;
        int hashCode50 = (hashCode49 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ship_from_overseas;
        int hashCode51 = (hashCode50 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        String str13 = this.sls_tracking_number;
        int hashCode52 = (hashCode51 + (str13 != null ? str13.hashCode() : 0)) * 37;
        Boolean bool4 = this.with_resolution_center;
        int hashCode53 = (hashCode52 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num18 = this.return_solution;
        int hashCode54 = (hashCode53 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Long l11 = this.max_refundable_amount;
        int hashCode55 = (hashCode54 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.refund_amount_from_seller;
        int hashCode56 = (hashCode55 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Boolean bool5 = this.refund_amount_adjustable;
        int hashCode57 = (hashCode56 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Long l13 = this.service_fee_amount;
        int hashCode58 = (hashCode57 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Boolean bool6 = this.physical_return_allowed;
        int hashCode59 = (hashCode58 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.auto_approve_return_processing;
        int hashCode60 = (hashCode59 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.warehouse_validation;
        if (bool8 != null) {
            i3 = bool8.hashCode();
        }
        int i5 = hashCode60 + i3;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<ReturnInfo> {
        public Integer accepted_time;
        public Integer actual_deliver_time;
        public Long admin_fee;
        public Long amount_before_discount;
        public Boolean auto_approve_return_processing;
        public BankAccountInfo bank_account;
        public String buyer_email;
        public String buyer_images;
        public String buyer_phone_number;
        public String buyer_real_name;
        public Long buyer_txn_fee;
        public Integer cancelled_time;
        public CardPromotionOrderInfo card_promotion_info;
        public Long carrier_shipping_fee;
        public Integer closed_time;
        public Long coin_earn_by_voucher_refund;
        public Long coin_earn_refund;
        public Long coin_spend_refund;
        public Integer discount_percentage;
        public Integer dispute_reason;
        public String dispute_text_reason;
        public String images;
        public Boolean is_ship_from_overseas;
        public List<OrderItem> item;
        public List<Long> itemid;
        public String judge_remarks;
        public Integer judging_time;
        public Integer logistics_error_code;
        public OrderLogisticsInfo logistics_info;
        public String logistics_remarks;
        public Long max_refundable_amount;
        public List<Long> modelid;
        public Boolean needs_logistics;
        public Long origin_shipping_fee;
        public Boolean physical_return_allowed;
        public Integer processing_time;
        public PromotionInfo promotion_info;
        public Boolean refund_amount_adjustable;
        public Long refund_amount_from_seller;
        public Integer refundpaid_time;
        public Integer requested_time;
        public BuyerAddress return_delivery_address;
        public BuyerAddress return_pickup_address;
        public Integer return_seller_due_date;
        public Integer return_ship_due_date;
        public Integer return_solution;
        public SecondLegShipment second_leg_shipment;
        public Integer seller_dispute_time;
        public Integer seller_due_date;
        public String seller_email;
        public Long seller_refund_amount;
        public Integer seller_reply_due_date;
        public Long service_fee_amount;
        public String shipping_carrier;
        public Long shipping_fee;
        public Integer shipping_method;
        public Boolean shopee_handle;
        public String sls_tracking_number;
        public String text_reason;
        public String tracking_number;
        public Boolean warehouse_validation;
        public Boolean with_resolution_center;

        public Builder() {
        }

        public Builder(ReturnInfo returnInfo) {
            super(returnInfo);
            if (returnInfo != null) {
                this.itemid = ReturnInfo.copyOf(returnInfo.itemid);
                this.buyer_email = returnInfo.buyer_email;
                this.seller_email = returnInfo.seller_email;
                this.item = ReturnInfo.copyOf(returnInfo.item);
                this.requested_time = returnInfo.requested_time;
                this.accepted_time = returnInfo.accepted_time;
                this.cancelled_time = returnInfo.cancelled_time;
                this.judging_time = returnInfo.judging_time;
                this.refundpaid_time = returnInfo.refundpaid_time;
                this.closed_time = returnInfo.closed_time;
                this.text_reason = returnInfo.text_reason;
                this.seller_due_date = returnInfo.seller_due_date;
                this.dispute_reason = returnInfo.dispute_reason;
                this.dispute_text_reason = returnInfo.dispute_text_reason;
                this.seller_reply_due_date = returnInfo.seller_reply_due_date;
                this.amount_before_discount = returnInfo.amount_before_discount;
                this.discount_percentage = returnInfo.discount_percentage;
                this.promotion_info = returnInfo.promotion_info;
                this.shipping_fee = returnInfo.shipping_fee;
                this.modelid = ReturnInfo.copyOf(returnInfo.modelid);
                this.bank_account = returnInfo.bank_account;
                this.images = returnInfo.images;
                this.coin_spend_refund = returnInfo.coin_spend_refund;
                this.coin_earn_refund = returnInfo.coin_earn_refund;
                this.seller_refund_amount = returnInfo.seller_refund_amount;
                this.card_promotion_info = returnInfo.card_promotion_info;
                this.buyer_images = returnInfo.buyer_images;
                this.return_pickup_address = returnInfo.return_pickup_address;
                this.tracking_number = returnInfo.tracking_number;
                this.needs_logistics = returnInfo.needs_logistics;
                this.logistics_info = returnInfo.logistics_info;
                this.return_delivery_address = returnInfo.return_delivery_address;
                this.shipping_method = returnInfo.shipping_method;
                this.carrier_shipping_fee = returnInfo.carrier_shipping_fee;
                this.origin_shipping_fee = returnInfo.origin_shipping_fee;
                this.actual_deliver_time = returnInfo.actual_deliver_time;
                this.logistics_error_code = returnInfo.logistics_error_code;
                this.judge_remarks = returnInfo.judge_remarks;
                this.seller_dispute_time = returnInfo.seller_dispute_time;
                this.shipping_carrier = returnInfo.shipping_carrier;
                this.logistics_remarks = returnInfo.logistics_remarks;
                this.processing_time = returnInfo.processing_time;
                this.return_ship_due_date = returnInfo.return_ship_due_date;
                this.return_seller_due_date = returnInfo.return_seller_due_date;
                this.second_leg_shipment = returnInfo.second_leg_shipment;
                this.buyer_txn_fee = returnInfo.buyer_txn_fee;
                this.coin_earn_by_voucher_refund = returnInfo.coin_earn_by_voucher_refund;
                this.shopee_handle = returnInfo.shopee_handle;
                this.admin_fee = returnInfo.admin_fee;
                this.buyer_real_name = returnInfo.buyer_real_name;
                this.buyer_phone_number = returnInfo.buyer_phone_number;
                this.is_ship_from_overseas = returnInfo.is_ship_from_overseas;
                this.sls_tracking_number = returnInfo.sls_tracking_number;
                this.with_resolution_center = returnInfo.with_resolution_center;
                this.return_solution = returnInfo.return_solution;
                this.max_refundable_amount = returnInfo.max_refundable_amount;
                this.refund_amount_from_seller = returnInfo.refund_amount_from_seller;
                this.refund_amount_adjustable = returnInfo.refund_amount_adjustable;
                this.service_fee_amount = returnInfo.service_fee_amount;
                this.physical_return_allowed = returnInfo.physical_return_allowed;
                this.auto_approve_return_processing = returnInfo.auto_approve_return_processing;
                this.warehouse_validation = returnInfo.warehouse_validation;
            }
        }

        public Builder itemid(List<Long> list) {
            this.itemid = checkForNulls(list);
            return this;
        }

        public Builder buyer_email(String str) {
            this.buyer_email = str;
            return this;
        }

        public Builder seller_email(String str) {
            this.seller_email = str;
            return this;
        }

        public Builder item(List<OrderItem> list) {
            this.item = checkForNulls(list);
            return this;
        }

        public Builder requested_time(Integer num) {
            this.requested_time = num;
            return this;
        }

        public Builder accepted_time(Integer num) {
            this.accepted_time = num;
            return this;
        }

        public Builder cancelled_time(Integer num) {
            this.cancelled_time = num;
            return this;
        }

        public Builder judging_time(Integer num) {
            this.judging_time = num;
            return this;
        }

        public Builder refundpaid_time(Integer num) {
            this.refundpaid_time = num;
            return this;
        }

        public Builder closed_time(Integer num) {
            this.closed_time = num;
            return this;
        }

        public Builder text_reason(String str) {
            this.text_reason = str;
            return this;
        }

        public Builder seller_due_date(Integer num) {
            this.seller_due_date = num;
            return this;
        }

        public Builder dispute_reason(Integer num) {
            this.dispute_reason = num;
            return this;
        }

        public Builder dispute_text_reason(String str) {
            this.dispute_text_reason = str;
            return this;
        }

        public Builder seller_reply_due_date(Integer num) {
            this.seller_reply_due_date = num;
            return this;
        }

        public Builder amount_before_discount(Long l) {
            this.amount_before_discount = l;
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

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
            return this;
        }

        public Builder modelid(List<Long> list) {
            this.modelid = checkForNulls(list);
            return this;
        }

        public Builder bank_account(BankAccountInfo bankAccountInfo) {
            this.bank_account = bankAccountInfo;
            return this;
        }

        public Builder images(String str) {
            this.images = str;
            return this;
        }

        public Builder coin_spend_refund(Long l) {
            this.coin_spend_refund = l;
            return this;
        }

        public Builder coin_earn_refund(Long l) {
            this.coin_earn_refund = l;
            return this;
        }

        public Builder seller_refund_amount(Long l) {
            this.seller_refund_amount = l;
            return this;
        }

        public Builder card_promotion_info(CardPromotionOrderInfo cardPromotionOrderInfo) {
            this.card_promotion_info = cardPromotionOrderInfo;
            return this;
        }

        public Builder buyer_images(String str) {
            this.buyer_images = str;
            return this;
        }

        public Builder return_pickup_address(BuyerAddress buyerAddress) {
            this.return_pickup_address = buyerAddress;
            return this;
        }

        public Builder tracking_number(String str) {
            this.tracking_number = str;
            return this;
        }

        public Builder needs_logistics(Boolean bool) {
            this.needs_logistics = bool;
            return this;
        }

        public Builder logistics_info(OrderLogisticsInfo orderLogisticsInfo) {
            this.logistics_info = orderLogisticsInfo;
            return this;
        }

        public Builder return_delivery_address(BuyerAddress buyerAddress) {
            this.return_delivery_address = buyerAddress;
            return this;
        }

        public Builder shipping_method(Integer num) {
            this.shipping_method = num;
            return this;
        }

        public Builder carrier_shipping_fee(Long l) {
            this.carrier_shipping_fee = l;
            return this;
        }

        public Builder origin_shipping_fee(Long l) {
            this.origin_shipping_fee = l;
            return this;
        }

        public Builder actual_deliver_time(Integer num) {
            this.actual_deliver_time = num;
            return this;
        }

        public Builder logistics_error_code(Integer num) {
            this.logistics_error_code = num;
            return this;
        }

        public Builder judge_remarks(String str) {
            this.judge_remarks = str;
            return this;
        }

        public Builder seller_dispute_time(Integer num) {
            this.seller_dispute_time = num;
            return this;
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder logistics_remarks(String str) {
            this.logistics_remarks = str;
            return this;
        }

        public Builder processing_time(Integer num) {
            this.processing_time = num;
            return this;
        }

        public Builder return_ship_due_date(Integer num) {
            this.return_ship_due_date = num;
            return this;
        }

        public Builder return_seller_due_date(Integer num) {
            this.return_seller_due_date = num;
            return this;
        }

        public Builder second_leg_shipment(SecondLegShipment secondLegShipment) {
            this.second_leg_shipment = secondLegShipment;
            return this;
        }

        public Builder buyer_txn_fee(Long l) {
            this.buyer_txn_fee = l;
            return this;
        }

        public Builder coin_earn_by_voucher_refund(Long l) {
            this.coin_earn_by_voucher_refund = l;
            return this;
        }

        public Builder shopee_handle(Boolean bool) {
            this.shopee_handle = bool;
            return this;
        }

        public Builder admin_fee(Long l) {
            this.admin_fee = l;
            return this;
        }

        public Builder buyer_real_name(String str) {
            this.buyer_real_name = str;
            return this;
        }

        public Builder buyer_phone_number(String str) {
            this.buyer_phone_number = str;
            return this;
        }

        public Builder is_ship_from_overseas(Boolean bool) {
            this.is_ship_from_overseas = bool;
            return this;
        }

        public Builder sls_tracking_number(String str) {
            this.sls_tracking_number = str;
            return this;
        }

        public Builder with_resolution_center(Boolean bool) {
            this.with_resolution_center = bool;
            return this;
        }

        public Builder return_solution(Integer num) {
            this.return_solution = num;
            return this;
        }

        public Builder max_refundable_amount(Long l) {
            this.max_refundable_amount = l;
            return this;
        }

        public Builder refund_amount_from_seller(Long l) {
            this.refund_amount_from_seller = l;
            return this;
        }

        public Builder refund_amount_adjustable(Boolean bool) {
            this.refund_amount_adjustable = bool;
            return this;
        }

        public Builder service_fee_amount(Long l) {
            this.service_fee_amount = l;
            return this;
        }

        public Builder physical_return_allowed(Boolean bool) {
            this.physical_return_allowed = bool;
            return this;
        }

        public Builder auto_approve_return_processing(Boolean bool) {
            this.auto_approve_return_processing = bool;
            return this;
        }

        public Builder warehouse_validation(Boolean bool) {
            this.warehouse_validation = bool;
            return this;
        }

        public ReturnInfo build() {
            return new ReturnInfo(this);
        }
    }
}
