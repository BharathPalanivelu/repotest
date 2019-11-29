package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderLogisticsExtInfo extends Message {
    public static final Long DEFAULT_ACTUAL_BUYER_PAID_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_ARRANGE_PICKUP_BY_DATE = 0;
    public static final Integer DEFAULT_AUTO_CANCEL_3PL_ACK_DATE = 0;
    public static final Integer DEFAULT_AUTO_CANCEL_ARRANGE_SHIP_DATE = 0;
    public static final Long DEFAULT_BUYER_USER_LOCATION_SNAPSHOT_ID = 0L;
    public static final Long DEFAULT_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_CDT_WITH_EXT = 0;
    public static final Integer DEFAULT_CHANNEL_ID = 0;
    public static final Long DEFAULT_CONTRACTUAL_CARRIER_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_DAYS_CAN_EXTEND = 0;
    public static final Integer DEFAULT_DAYS_TOSHIP_EXTENDED = 0;
    public static final Integer DEFAULT_DAYS_TO_SHIP = 0;
    public static final String DEFAULT_DELIVERY_STATUS_DESC = "";
    public static final Integer DEFAULT_DELIVERY_STATUS_MTIME = 0;
    public static final String DEFAULT_DELIVER_FAIL_REASON = "";
    public static final Long DEFAULT_DISCOUNT_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_ESCROW_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_EXPECTED_RECEIVE_TIME = 0;
    public static final f DEFAULT_EXTRA_DATA = f.f32736b;
    public static final Integer DEFAULT_FE_RECEIVE_TIME = 0;
    public static final Long DEFAULT_GROUP_SHIPPING_ID = 0L;
    public static final Integer DEFAULT_LAST_CHANGE_ADDRESS_TIME = 0;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_DISCOUNT_PROMOTION_RULE_ID = 0;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_DISCOUNT_PROMOTION_RULE_SNAPSHOT_ID = 0;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_PROMOTION_RULE_ID = 0;
    public static final Long DEFAULT_LOGISTICS_FLAG = 0L;
    public static final Integer DEFAULT_ORIGINAL_EXPECTED_RECEIVE_TIME = 0;
    public static final Long DEFAULT_ORIGIN_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_PICKUP_ATTEMPTS = 0;
    public static final Integer DEFAULT_PICKUP_CUTOFF_TIME = 0;
    public static final String DEFAULT_PICKUP_DATE_DESCRIPTION = "";
    public static final String DEFAULT_PICKUP_FAIL_REASON = "";
    public static final Integer DEFAULT_POUCH_SIZE_ID = 0;
    public static final Integer DEFAULT_PREFERRED_DELIVERY_OPTION = 0;
    public static final Long DEFAULT_REBATE_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_SELLER_USER_LOCATION_SNAPSHOT_ID = 0L;
    public static final Long DEFAULT_SHIPPING_FEE_MAX_DISCOUNT = 0L;
    public static final String DEFAULT_SHIPPING_PROOF = "";
    public static final Integer DEFAULT_SHIPPING_PROOF_STATUS = 0;
    public static final Integer DEFAULT_SHIP_BY_DATE = 0;
    public static final Long DEFAULT_THIRDPARTY_PICKUP_TIME = 0L;
    public static final f DEFAULT_TRANS_DETAIL_SHIPPING_FEE = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 43, type = Message.Datatype.INT64)
    public final Long actual_buyer_paid_shipping_fee;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer arrange_pickup_by_date;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer auto_cancel_3pl_ack_date;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer auto_cancel_arrange_ship_date;
    @ProtoField(tag = 22)
    public final BuyerAddress buyer_address;
    @ProtoField(tag = 41, type = Message.Datatype.UINT64)
    public final Long buyer_user_location_snapshot_id;
    @ProtoField(tag = 28, type = Message.Datatype.INT64)
    public final Long carrier_shipping_fee;
    @ProtoField(tag = 45, type = Message.Datatype.INT32)
    public final Integer cdt_with_ext;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer channel_id;
    @ProtoField(tag = 34, type = Message.Datatype.INT64)
    public final Long contractual_carrier_shipping_fee;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer days_can_extend;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer days_to_ship;
    @ProtoField(tag = 29, type = Message.Datatype.INT32)
    public final Integer days_toship_extended;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String deliver_fail_reason;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String delivery_status_desc;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer delivery_status_mtime;
    @ProtoField(tag = 26, type = Message.Datatype.INT64)
    public final Long discount_shipping_fee;
    @ProtoField(tag = 35)
    public final OrderDropshippingInfo dropshipping_info;
    @ProtoField(tag = 30, type = Message.Datatype.INT64)
    public final Long escrow_shipping_fee;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer expected_receive_time;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extra_data;
    @ProtoField(tag = 46, type = Message.Datatype.INT32)
    public final Integer fe_receive_time;
    @ProtoField(tag = 39)
    public final LogisticsVoucherInfo free_shipping_voucher;
    @ProtoField(tag = 38, type = Message.Datatype.INT64)
    public final Long group_shipping_id;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer last_change_address_time;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer logistics_channel_discount_promotion_rule_id;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer logistics_channel_discount_promotion_rule_snapshot_id;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer logistics_channel_promotion_rule_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long logistics_flag;
    @ProtoField(tag = 27, type = Message.Datatype.INT64)
    public final Long origin_shipping_fee;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer original_expected_receive_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer pickup_attempts;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer pickup_cutoff_time;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String pickup_date_description;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String pickup_fail_reason;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer pouch_size_id;
    @ProtoField(tag = 44, type = Message.Datatype.INT32)
    public final Integer preferred_delivery_option;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long rebate_shipping_fee;
    @ProtoField(tag = 23)
    public final BuyerAddress seller_address;
    @ProtoField(tag = 42, type = Message.Datatype.UINT64)
    public final Long seller_user_location_snapshot_id;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer ship_by_date;
    @ProtoField(tag = 31, type = Message.Datatype.INT64)
    public final Long shipping_fee_max_discount;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String shipping_proof;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer shipping_proof_status;
    @ProtoField(tag = 18, type = Message.Datatype.INT64)
    public final Long thirdparty_pickup_time;
    @ProtoField(tag = 32, type = Message.Datatype.BYTES)
    public final f trans_detail_shipping_fee;

    public OrderLogisticsExtInfo(Integer num, String str, String str2, String str3, Integer num2, Long l, Integer num3, String str4, Integer num4, f fVar, String str5, Integer num5, Integer num6, Long l2, Integer num7, Integer num8, Integer num9, Long l3, Integer num10, Integer num11, Integer num12, BuyerAddress buyerAddress, BuyerAddress buyerAddress2, Integer num13, Integer num14, Long l4, Long l5, Long l6, Integer num15, Long l7, Long l8, f fVar2, Integer num16, Long l9, OrderDropshippingInfo orderDropshippingInfo, Integer num17, Integer num18, Long l10, LogisticsVoucherInfo logisticsVoucherInfo, Integer num19, Long l11, Long l12, Long l13, Integer num20, Integer num21, Integer num22) {
        this.pickup_cutoff_time = num;
        this.pickup_fail_reason = str;
        this.deliver_fail_reason = str2;
        this.delivery_status_desc = str3;
        this.delivery_status_mtime = num2;
        this.logistics_flag = l;
        this.pickup_attempts = num3;
        this.pickup_date_description = str4;
        this.channel_id = num4;
        this.extra_data = fVar;
        this.shipping_proof = str5;
        this.shipping_proof_status = num5;
        this.logistics_channel_promotion_rule_id = num6;
        this.rebate_shipping_fee = l2;
        this.expected_receive_time = num7;
        this.original_expected_receive_time = num8;
        this.pouch_size_id = num9;
        this.thirdparty_pickup_time = l3;
        this.logistics_channel_discount_promotion_rule_id = num10;
        this.logistics_channel_discount_promotion_rule_snapshot_id = num11;
        this.days_to_ship = num12;
        this.buyer_address = buyerAddress;
        this.seller_address = buyerAddress2;
        this.arrange_pickup_by_date = num13;
        this.ship_by_date = num14;
        this.discount_shipping_fee = l4;
        this.origin_shipping_fee = l5;
        this.carrier_shipping_fee = l6;
        this.days_toship_extended = num15;
        this.escrow_shipping_fee = l7;
        this.shipping_fee_max_discount = l8;
        this.trans_detail_shipping_fee = fVar2;
        this.days_can_extend = num16;
        this.contractual_carrier_shipping_fee = l9;
        this.dropshipping_info = orderDropshippingInfo;
        this.auto_cancel_arrange_ship_date = num17;
        this.auto_cancel_3pl_ack_date = num18;
        this.group_shipping_id = l10;
        this.free_shipping_voucher = logisticsVoucherInfo;
        this.last_change_address_time = num19;
        this.buyer_user_location_snapshot_id = l11;
        this.seller_user_location_snapshot_id = l12;
        this.actual_buyer_paid_shipping_fee = l13;
        this.preferred_delivery_option = num20;
        this.cdt_with_ext = num21;
        this.fe_receive_time = num22;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderLogisticsExtInfo(com.shopee.protocol.shop.OrderLogisticsExtInfo.Builder r50) {
        /*
            r49 = this;
            r0 = r50
            r1 = r49
            java.lang.Integer r2 = r0.pickup_cutoff_time
            java.lang.String r3 = r0.pickup_fail_reason
            java.lang.String r4 = r0.deliver_fail_reason
            java.lang.String r5 = r0.delivery_status_desc
            java.lang.Integer r6 = r0.delivery_status_mtime
            java.lang.Long r7 = r0.logistics_flag
            java.lang.Integer r8 = r0.pickup_attempts
            java.lang.String r9 = r0.pickup_date_description
            java.lang.Integer r10 = r0.channel_id
            e.f r11 = r0.extra_data
            java.lang.String r12 = r0.shipping_proof
            java.lang.Integer r13 = r0.shipping_proof_status
            java.lang.Integer r14 = r0.logistics_channel_promotion_rule_id
            java.lang.Long r15 = r0.rebate_shipping_fee
            r48 = r1
            java.lang.Integer r1 = r0.expected_receive_time
            r16 = r1
            java.lang.Integer r1 = r0.original_expected_receive_time
            r17 = r1
            java.lang.Integer r1 = r0.pouch_size_id
            r18 = r1
            java.lang.Long r1 = r0.thirdparty_pickup_time
            r19 = r1
            java.lang.Integer r1 = r0.logistics_channel_discount_promotion_rule_id
            r20 = r1
            java.lang.Integer r1 = r0.logistics_channel_discount_promotion_rule_snapshot_id
            r21 = r1
            java.lang.Integer r1 = r0.days_to_ship
            r22 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.buyer_address
            r23 = r1
            com.shopee.protocol.shop.BuyerAddress r1 = r0.seller_address
            r24 = r1
            java.lang.Integer r1 = r0.arrange_pickup_by_date
            r25 = r1
            java.lang.Integer r1 = r0.ship_by_date
            r26 = r1
            java.lang.Long r1 = r0.discount_shipping_fee
            r27 = r1
            java.lang.Long r1 = r0.origin_shipping_fee
            r28 = r1
            java.lang.Long r1 = r0.carrier_shipping_fee
            r29 = r1
            java.lang.Integer r1 = r0.days_toship_extended
            r30 = r1
            java.lang.Long r1 = r0.escrow_shipping_fee
            r31 = r1
            java.lang.Long r1 = r0.shipping_fee_max_discount
            r32 = r1
            e.f r1 = r0.trans_detail_shipping_fee
            r33 = r1
            java.lang.Integer r1 = r0.days_can_extend
            r34 = r1
            java.lang.Long r1 = r0.contractual_carrier_shipping_fee
            r35 = r1
            com.shopee.protocol.shop.OrderDropshippingInfo r1 = r0.dropshipping_info
            r36 = r1
            java.lang.Integer r1 = r0.auto_cancel_arrange_ship_date
            r37 = r1
            java.lang.Integer r1 = r0.auto_cancel_3pl_ack_date
            r38 = r1
            java.lang.Long r1 = r0.group_shipping_id
            r39 = r1
            com.shopee.protocol.shop.LogisticsVoucherInfo r1 = r0.free_shipping_voucher
            r40 = r1
            java.lang.Integer r1 = r0.last_change_address_time
            r41 = r1
            java.lang.Long r1 = r0.buyer_user_location_snapshot_id
            r42 = r1
            java.lang.Long r1 = r0.seller_user_location_snapshot_id
            r43 = r1
            java.lang.Long r1 = r0.actual_buyer_paid_shipping_fee
            r44 = r1
            java.lang.Integer r1 = r0.preferred_delivery_option
            r45 = r1
            java.lang.Integer r1 = r0.cdt_with_ext
            r46 = r1
            java.lang.Integer r1 = r0.fe_receive_time
            r47 = r1
            r1 = r48
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47)
            r49.setBuilder(r50)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderLogisticsExtInfo.<init>(com.shopee.protocol.shop.OrderLogisticsExtInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLogisticsExtInfo)) {
            return false;
        }
        OrderLogisticsExtInfo orderLogisticsExtInfo = (OrderLogisticsExtInfo) obj;
        if (!equals((Object) this.pickup_cutoff_time, (Object) orderLogisticsExtInfo.pickup_cutoff_time) || !equals((Object) this.pickup_fail_reason, (Object) orderLogisticsExtInfo.pickup_fail_reason) || !equals((Object) this.deliver_fail_reason, (Object) orderLogisticsExtInfo.deliver_fail_reason) || !equals((Object) this.delivery_status_desc, (Object) orderLogisticsExtInfo.delivery_status_desc) || !equals((Object) this.delivery_status_mtime, (Object) orderLogisticsExtInfo.delivery_status_mtime) || !equals((Object) this.logistics_flag, (Object) orderLogisticsExtInfo.logistics_flag) || !equals((Object) this.pickup_attempts, (Object) orderLogisticsExtInfo.pickup_attempts) || !equals((Object) this.pickup_date_description, (Object) orderLogisticsExtInfo.pickup_date_description) || !equals((Object) this.channel_id, (Object) orderLogisticsExtInfo.channel_id) || !equals((Object) this.extra_data, (Object) orderLogisticsExtInfo.extra_data) || !equals((Object) this.shipping_proof, (Object) orderLogisticsExtInfo.shipping_proof) || !equals((Object) this.shipping_proof_status, (Object) orderLogisticsExtInfo.shipping_proof_status) || !equals((Object) this.logistics_channel_promotion_rule_id, (Object) orderLogisticsExtInfo.logistics_channel_promotion_rule_id) || !equals((Object) this.rebate_shipping_fee, (Object) orderLogisticsExtInfo.rebate_shipping_fee) || !equals((Object) this.expected_receive_time, (Object) orderLogisticsExtInfo.expected_receive_time) || !equals((Object) this.original_expected_receive_time, (Object) orderLogisticsExtInfo.original_expected_receive_time) || !equals((Object) this.pouch_size_id, (Object) orderLogisticsExtInfo.pouch_size_id) || !equals((Object) this.thirdparty_pickup_time, (Object) orderLogisticsExtInfo.thirdparty_pickup_time) || !equals((Object) this.logistics_channel_discount_promotion_rule_id, (Object) orderLogisticsExtInfo.logistics_channel_discount_promotion_rule_id) || !equals((Object) this.logistics_channel_discount_promotion_rule_snapshot_id, (Object) orderLogisticsExtInfo.logistics_channel_discount_promotion_rule_snapshot_id) || !equals((Object) this.days_to_ship, (Object) orderLogisticsExtInfo.days_to_ship) || !equals((Object) this.buyer_address, (Object) orderLogisticsExtInfo.buyer_address) || !equals((Object) this.seller_address, (Object) orderLogisticsExtInfo.seller_address) || !equals((Object) this.arrange_pickup_by_date, (Object) orderLogisticsExtInfo.arrange_pickup_by_date) || !equals((Object) this.ship_by_date, (Object) orderLogisticsExtInfo.ship_by_date) || !equals((Object) this.discount_shipping_fee, (Object) orderLogisticsExtInfo.discount_shipping_fee) || !equals((Object) this.origin_shipping_fee, (Object) orderLogisticsExtInfo.origin_shipping_fee) || !equals((Object) this.carrier_shipping_fee, (Object) orderLogisticsExtInfo.carrier_shipping_fee) || !equals((Object) this.days_toship_extended, (Object) orderLogisticsExtInfo.days_toship_extended) || !equals((Object) this.escrow_shipping_fee, (Object) orderLogisticsExtInfo.escrow_shipping_fee) || !equals((Object) this.shipping_fee_max_discount, (Object) orderLogisticsExtInfo.shipping_fee_max_discount) || !equals((Object) this.trans_detail_shipping_fee, (Object) orderLogisticsExtInfo.trans_detail_shipping_fee) || !equals((Object) this.days_can_extend, (Object) orderLogisticsExtInfo.days_can_extend) || !equals((Object) this.contractual_carrier_shipping_fee, (Object) orderLogisticsExtInfo.contractual_carrier_shipping_fee) || !equals((Object) this.dropshipping_info, (Object) orderLogisticsExtInfo.dropshipping_info) || !equals((Object) this.auto_cancel_arrange_ship_date, (Object) orderLogisticsExtInfo.auto_cancel_arrange_ship_date) || !equals((Object) this.auto_cancel_3pl_ack_date, (Object) orderLogisticsExtInfo.auto_cancel_3pl_ack_date) || !equals((Object) this.group_shipping_id, (Object) orderLogisticsExtInfo.group_shipping_id) || !equals((Object) this.free_shipping_voucher, (Object) orderLogisticsExtInfo.free_shipping_voucher) || !equals((Object) this.last_change_address_time, (Object) orderLogisticsExtInfo.last_change_address_time) || !equals((Object) this.buyer_user_location_snapshot_id, (Object) orderLogisticsExtInfo.buyer_user_location_snapshot_id) || !equals((Object) this.seller_user_location_snapshot_id, (Object) orderLogisticsExtInfo.seller_user_location_snapshot_id) || !equals((Object) this.actual_buyer_paid_shipping_fee, (Object) orderLogisticsExtInfo.actual_buyer_paid_shipping_fee) || !equals((Object) this.preferred_delivery_option, (Object) orderLogisticsExtInfo.preferred_delivery_option) || !equals((Object) this.cdt_with_ext, (Object) orderLogisticsExtInfo.cdt_with_ext) || !equals((Object) this.fe_receive_time, (Object) orderLogisticsExtInfo.fe_receive_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.pickup_cutoff_time;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.pickup_fail_reason;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.deliver_fail_reason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.delivery_status_desc;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.delivery_status_mtime;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.logistics_flag;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.pickup_attempts;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.pickup_date_description;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.channel_id;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extra_data;
        int hashCode10 = (hashCode9 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str5 = this.shipping_proof;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num5 = this.shipping_proof_status;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.logistics_channel_promotion_rule_id;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l2 = this.rebate_shipping_fee;
        int hashCode14 = (hashCode13 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num7 = this.expected_receive_time;
        int hashCode15 = (hashCode14 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.original_expected_receive_time;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.pouch_size_id;
        int hashCode17 = (hashCode16 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l3 = this.thirdparty_pickup_time;
        int hashCode18 = (hashCode17 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num10 = this.logistics_channel_discount_promotion_rule_id;
        int hashCode19 = (hashCode18 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.logistics_channel_discount_promotion_rule_snapshot_id;
        int hashCode20 = (hashCode19 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.days_to_ship;
        int hashCode21 = (hashCode20 + (num12 != null ? num12.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.buyer_address;
        int hashCode22 = (hashCode21 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress2 = this.seller_address;
        int hashCode23 = (hashCode22 + (buyerAddress2 != null ? buyerAddress2.hashCode() : 0)) * 37;
        Integer num13 = this.arrange_pickup_by_date;
        int hashCode24 = (hashCode23 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.ship_by_date;
        int hashCode25 = (hashCode24 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Long l4 = this.discount_shipping_fee;
        int hashCode26 = (hashCode25 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.origin_shipping_fee;
        int hashCode27 = (hashCode26 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.carrier_shipping_fee;
        int hashCode28 = (hashCode27 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num15 = this.days_toship_extended;
        int hashCode29 = (hashCode28 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Long l7 = this.escrow_shipping_fee;
        int hashCode30 = (hashCode29 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.shipping_fee_max_discount;
        int hashCode31 = (hashCode30 + (l8 != null ? l8.hashCode() : 0)) * 37;
        f fVar2 = this.trans_detail_shipping_fee;
        int hashCode32 = (hashCode31 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num16 = this.days_can_extend;
        int hashCode33 = (hashCode32 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Long l9 = this.contractual_carrier_shipping_fee;
        int hashCode34 = (hashCode33 + (l9 != null ? l9.hashCode() : 0)) * 37;
        OrderDropshippingInfo orderDropshippingInfo = this.dropshipping_info;
        int hashCode35 = (hashCode34 + (orderDropshippingInfo != null ? orderDropshippingInfo.hashCode() : 0)) * 37;
        Integer num17 = this.auto_cancel_arrange_ship_date;
        int hashCode36 = (hashCode35 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.auto_cancel_3pl_ack_date;
        int hashCode37 = (hashCode36 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Long l10 = this.group_shipping_id;
        int hashCode38 = (hashCode37 + (l10 != null ? l10.hashCode() : 0)) * 37;
        LogisticsVoucherInfo logisticsVoucherInfo = this.free_shipping_voucher;
        int hashCode39 = (hashCode38 + (logisticsVoucherInfo != null ? logisticsVoucherInfo.hashCode() : 0)) * 37;
        Integer num19 = this.last_change_address_time;
        int hashCode40 = (hashCode39 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Long l11 = this.buyer_user_location_snapshot_id;
        int hashCode41 = (hashCode40 + (l11 != null ? l11.hashCode() : 0)) * 37;
        Long l12 = this.seller_user_location_snapshot_id;
        int hashCode42 = (hashCode41 + (l12 != null ? l12.hashCode() : 0)) * 37;
        Long l13 = this.actual_buyer_paid_shipping_fee;
        int hashCode43 = (hashCode42 + (l13 != null ? l13.hashCode() : 0)) * 37;
        Integer num20 = this.preferred_delivery_option;
        int hashCode44 = (hashCode43 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.cdt_with_ext;
        int hashCode45 = (hashCode44 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Integer num22 = this.fe_receive_time;
        if (num22 != null) {
            i2 = num22.hashCode();
        }
        int i3 = hashCode45 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderLogisticsExtInfo> {
        public Long actual_buyer_paid_shipping_fee;
        public Integer arrange_pickup_by_date;
        public Integer auto_cancel_3pl_ack_date;
        public Integer auto_cancel_arrange_ship_date;
        public BuyerAddress buyer_address;
        public Long buyer_user_location_snapshot_id;
        public Long carrier_shipping_fee;
        public Integer cdt_with_ext;
        public Integer channel_id;
        public Long contractual_carrier_shipping_fee;
        public Integer days_can_extend;
        public Integer days_to_ship;
        public Integer days_toship_extended;
        public String deliver_fail_reason;
        public String delivery_status_desc;
        public Integer delivery_status_mtime;
        public Long discount_shipping_fee;
        public OrderDropshippingInfo dropshipping_info;
        public Long escrow_shipping_fee;
        public Integer expected_receive_time;
        public f extra_data;
        public Integer fe_receive_time;
        public LogisticsVoucherInfo free_shipping_voucher;
        public Long group_shipping_id;
        public Integer last_change_address_time;
        public Integer logistics_channel_discount_promotion_rule_id;
        public Integer logistics_channel_discount_promotion_rule_snapshot_id;
        public Integer logistics_channel_promotion_rule_id;
        public Long logistics_flag;
        public Long origin_shipping_fee;
        public Integer original_expected_receive_time;
        public Integer pickup_attempts;
        public Integer pickup_cutoff_time;
        public String pickup_date_description;
        public String pickup_fail_reason;
        public Integer pouch_size_id;
        public Integer preferred_delivery_option;
        public Long rebate_shipping_fee;
        public BuyerAddress seller_address;
        public Long seller_user_location_snapshot_id;
        public Integer ship_by_date;
        public Long shipping_fee_max_discount;
        public String shipping_proof;
        public Integer shipping_proof_status;
        public Long thirdparty_pickup_time;
        public f trans_detail_shipping_fee;

        public Builder() {
        }

        public Builder(OrderLogisticsExtInfo orderLogisticsExtInfo) {
            super(orderLogisticsExtInfo);
            if (orderLogisticsExtInfo != null) {
                this.pickup_cutoff_time = orderLogisticsExtInfo.pickup_cutoff_time;
                this.pickup_fail_reason = orderLogisticsExtInfo.pickup_fail_reason;
                this.deliver_fail_reason = orderLogisticsExtInfo.deliver_fail_reason;
                this.delivery_status_desc = orderLogisticsExtInfo.delivery_status_desc;
                this.delivery_status_mtime = orderLogisticsExtInfo.delivery_status_mtime;
                this.logistics_flag = orderLogisticsExtInfo.logistics_flag;
                this.pickup_attempts = orderLogisticsExtInfo.pickup_attempts;
                this.pickup_date_description = orderLogisticsExtInfo.pickup_date_description;
                this.channel_id = orderLogisticsExtInfo.channel_id;
                this.extra_data = orderLogisticsExtInfo.extra_data;
                this.shipping_proof = orderLogisticsExtInfo.shipping_proof;
                this.shipping_proof_status = orderLogisticsExtInfo.shipping_proof_status;
                this.logistics_channel_promotion_rule_id = orderLogisticsExtInfo.logistics_channel_promotion_rule_id;
                this.rebate_shipping_fee = orderLogisticsExtInfo.rebate_shipping_fee;
                this.expected_receive_time = orderLogisticsExtInfo.expected_receive_time;
                this.original_expected_receive_time = orderLogisticsExtInfo.original_expected_receive_time;
                this.pouch_size_id = orderLogisticsExtInfo.pouch_size_id;
                this.thirdparty_pickup_time = orderLogisticsExtInfo.thirdparty_pickup_time;
                this.logistics_channel_discount_promotion_rule_id = orderLogisticsExtInfo.logistics_channel_discount_promotion_rule_id;
                this.logistics_channel_discount_promotion_rule_snapshot_id = orderLogisticsExtInfo.logistics_channel_discount_promotion_rule_snapshot_id;
                this.days_to_ship = orderLogisticsExtInfo.days_to_ship;
                this.buyer_address = orderLogisticsExtInfo.buyer_address;
                this.seller_address = orderLogisticsExtInfo.seller_address;
                this.arrange_pickup_by_date = orderLogisticsExtInfo.arrange_pickup_by_date;
                this.ship_by_date = orderLogisticsExtInfo.ship_by_date;
                this.discount_shipping_fee = orderLogisticsExtInfo.discount_shipping_fee;
                this.origin_shipping_fee = orderLogisticsExtInfo.origin_shipping_fee;
                this.carrier_shipping_fee = orderLogisticsExtInfo.carrier_shipping_fee;
                this.days_toship_extended = orderLogisticsExtInfo.days_toship_extended;
                this.escrow_shipping_fee = orderLogisticsExtInfo.escrow_shipping_fee;
                this.shipping_fee_max_discount = orderLogisticsExtInfo.shipping_fee_max_discount;
                this.trans_detail_shipping_fee = orderLogisticsExtInfo.trans_detail_shipping_fee;
                this.days_can_extend = orderLogisticsExtInfo.days_can_extend;
                this.contractual_carrier_shipping_fee = orderLogisticsExtInfo.contractual_carrier_shipping_fee;
                this.dropshipping_info = orderLogisticsExtInfo.dropshipping_info;
                this.auto_cancel_arrange_ship_date = orderLogisticsExtInfo.auto_cancel_arrange_ship_date;
                this.auto_cancel_3pl_ack_date = orderLogisticsExtInfo.auto_cancel_3pl_ack_date;
                this.group_shipping_id = orderLogisticsExtInfo.group_shipping_id;
                this.free_shipping_voucher = orderLogisticsExtInfo.free_shipping_voucher;
                this.last_change_address_time = orderLogisticsExtInfo.last_change_address_time;
                this.buyer_user_location_snapshot_id = orderLogisticsExtInfo.buyer_user_location_snapshot_id;
                this.seller_user_location_snapshot_id = orderLogisticsExtInfo.seller_user_location_snapshot_id;
                this.actual_buyer_paid_shipping_fee = orderLogisticsExtInfo.actual_buyer_paid_shipping_fee;
                this.preferred_delivery_option = orderLogisticsExtInfo.preferred_delivery_option;
                this.cdt_with_ext = orderLogisticsExtInfo.cdt_with_ext;
                this.fe_receive_time = orderLogisticsExtInfo.fe_receive_time;
            }
        }

        public Builder pickup_cutoff_time(Integer num) {
            this.pickup_cutoff_time = num;
            return this;
        }

        public Builder pickup_fail_reason(String str) {
            this.pickup_fail_reason = str;
            return this;
        }

        public Builder deliver_fail_reason(String str) {
            this.deliver_fail_reason = str;
            return this;
        }

        public Builder delivery_status_desc(String str) {
            this.delivery_status_desc = str;
            return this;
        }

        public Builder delivery_status_mtime(Integer num) {
            this.delivery_status_mtime = num;
            return this;
        }

        public Builder logistics_flag(Long l) {
            this.logistics_flag = l;
            return this;
        }

        public Builder pickup_attempts(Integer num) {
            this.pickup_attempts = num;
            return this;
        }

        public Builder pickup_date_description(String str) {
            this.pickup_date_description = str;
            return this;
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder extra_data(f fVar) {
            this.extra_data = fVar;
            return this;
        }

        public Builder shipping_proof(String str) {
            this.shipping_proof = str;
            return this;
        }

        public Builder shipping_proof_status(Integer num) {
            this.shipping_proof_status = num;
            return this;
        }

        public Builder logistics_channel_promotion_rule_id(Integer num) {
            this.logistics_channel_promotion_rule_id = num;
            return this;
        }

        public Builder rebate_shipping_fee(Long l) {
            this.rebate_shipping_fee = l;
            return this;
        }

        public Builder expected_receive_time(Integer num) {
            this.expected_receive_time = num;
            return this;
        }

        public Builder original_expected_receive_time(Integer num) {
            this.original_expected_receive_time = num;
            return this;
        }

        public Builder pouch_size_id(Integer num) {
            this.pouch_size_id = num;
            return this;
        }

        public Builder thirdparty_pickup_time(Long l) {
            this.thirdparty_pickup_time = l;
            return this;
        }

        public Builder logistics_channel_discount_promotion_rule_id(Integer num) {
            this.logistics_channel_discount_promotion_rule_id = num;
            return this;
        }

        public Builder logistics_channel_discount_promotion_rule_snapshot_id(Integer num) {
            this.logistics_channel_discount_promotion_rule_snapshot_id = num;
            return this;
        }

        public Builder days_to_ship(Integer num) {
            this.days_to_ship = num;
            return this;
        }

        public Builder buyer_address(BuyerAddress buyerAddress) {
            this.buyer_address = buyerAddress;
            return this;
        }

        public Builder seller_address(BuyerAddress buyerAddress) {
            this.seller_address = buyerAddress;
            return this;
        }

        public Builder arrange_pickup_by_date(Integer num) {
            this.arrange_pickup_by_date = num;
            return this;
        }

        public Builder ship_by_date(Integer num) {
            this.ship_by_date = num;
            return this;
        }

        public Builder discount_shipping_fee(Long l) {
            this.discount_shipping_fee = l;
            return this;
        }

        public Builder origin_shipping_fee(Long l) {
            this.origin_shipping_fee = l;
            return this;
        }

        public Builder carrier_shipping_fee(Long l) {
            this.carrier_shipping_fee = l;
            return this;
        }

        public Builder days_toship_extended(Integer num) {
            this.days_toship_extended = num;
            return this;
        }

        public Builder escrow_shipping_fee(Long l) {
            this.escrow_shipping_fee = l;
            return this;
        }

        public Builder shipping_fee_max_discount(Long l) {
            this.shipping_fee_max_discount = l;
            return this;
        }

        public Builder trans_detail_shipping_fee(f fVar) {
            this.trans_detail_shipping_fee = fVar;
            return this;
        }

        public Builder days_can_extend(Integer num) {
            this.days_can_extend = num;
            return this;
        }

        public Builder contractual_carrier_shipping_fee(Long l) {
            this.contractual_carrier_shipping_fee = l;
            return this;
        }

        public Builder dropshipping_info(OrderDropshippingInfo orderDropshippingInfo) {
            this.dropshipping_info = orderDropshippingInfo;
            return this;
        }

        public Builder auto_cancel_arrange_ship_date(Integer num) {
            this.auto_cancel_arrange_ship_date = num;
            return this;
        }

        public Builder auto_cancel_3pl_ack_date(Integer num) {
            this.auto_cancel_3pl_ack_date = num;
            return this;
        }

        public Builder group_shipping_id(Long l) {
            this.group_shipping_id = l;
            return this;
        }

        public Builder free_shipping_voucher(LogisticsVoucherInfo logisticsVoucherInfo) {
            this.free_shipping_voucher = logisticsVoucherInfo;
            return this;
        }

        public Builder last_change_address_time(Integer num) {
            this.last_change_address_time = num;
            return this;
        }

        public Builder buyer_user_location_snapshot_id(Long l) {
            this.buyer_user_location_snapshot_id = l;
            return this;
        }

        public Builder seller_user_location_snapshot_id(Long l) {
            this.seller_user_location_snapshot_id = l;
            return this;
        }

        public Builder actual_buyer_paid_shipping_fee(Long l) {
            this.actual_buyer_paid_shipping_fee = l;
            return this;
        }

        public Builder preferred_delivery_option(Integer num) {
            this.preferred_delivery_option = num;
            return this;
        }

        public Builder cdt_with_ext(Integer num) {
            this.cdt_with_ext = num;
            return this;
        }

        public Builder fe_receive_time(Integer num) {
            this.fe_receive_time = num;
            return this;
        }

        public OrderLogisticsExtInfo build() {
            return new OrderLogisticsExtInfo(this);
        }
    }
}
