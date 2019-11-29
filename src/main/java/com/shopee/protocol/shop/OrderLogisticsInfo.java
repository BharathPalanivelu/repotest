package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderLogisticsInfo extends Message {
    public static final Integer DEFAULT_CHANNELID = 0;
    public static final String DEFAULT_DELIVERY_STATUS_DESC = "";
    public static final Integer DEFAULT_DELIVERY_STATUS_MTIME = 0;
    public static final String DEFAULT_DELIVER_FAIL_REASON = "";
    public static final Integer DEFAULT_EXPECTED_RECEIVE_TIME = 0;
    public static final f DEFAULT_EXTRA_DATA = f.f32736b;
    public static final Long DEFAULT_LOGISTICSID = 0L;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_DISCOUNT_PROMOTION_RULE_ID = 0;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_DISCOUNT_PROMOTION_RULE_SNAPSHOT_ID = 0;
    public static final Integer DEFAULT_LOGISTICS_CHANNEL_PROMOTION_RULE_ID = 0;
    public static final Long DEFAULT_LOGISTICS_FLAG = 0L;
    public static final Integer DEFAULT_ORIGINAL_EXPECTED_RECEIVE_TIME = 0;
    public static final Integer DEFAULT_PICKUP_ATTEMPTS = 0;
    public static final Integer DEFAULT_PICKUP_CUTOFF_TIME = 0;
    public static final String DEFAULT_PICKUP_DATE_DESCRIPTION = "";
    public static final String DEFAULT_PICKUP_FAIL_REASON = "";
    public static final Integer DEFAULT_POUCH_SIZE_ID = 0;
    public static final Integer DEFAULT_PREFERRED_DELIVERY_OPTION = 0;
    public static final Long DEFAULT_REBATE_SHIPPING_FEE = 0L;
    public static final String DEFAULT_SHIPPING_PROOF = "";
    public static final Integer DEFAULT_SHIPPING_PROOF_STATUS = 0;
    public static final Long DEFAULT_THIRDPARTY_PICKUP_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer channelid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String deliver_fail_reason;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String delivery_status_desc;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer delivery_status_mtime;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer expected_receive_time;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f extra_data;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer logistics_channel_discount_promotion_rule_id;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer logistics_channel_discount_promotion_rule_snapshot_id;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer logistics_channel_promotion_rule_id;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long logistics_flag;
    @ProtoField(tag = 1, type = Message.Datatype.UINT64)
    public final Long logisticsid;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer original_expected_receive_time;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer pickup_attempts;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer pickup_cutoff_time;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String pickup_date_description;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String pickup_fail_reason;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer pouch_size_id;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer preferred_delivery_option;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long rebate_shipping_fee;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String shipping_proof;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer shipping_proof_status;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long thirdparty_pickup_time;

    public OrderLogisticsInfo(Long l, Integer num, String str, String str2, String str3, Integer num2, Long l2, Integer num3, String str4, Integer num4, f fVar, String str5, Integer num5, Integer num6, Long l3, Integer num7, Integer num8, Integer num9, Long l4, Integer num10, Integer num11, Integer num12) {
        this.logisticsid = l;
        this.pickup_cutoff_time = num;
        this.pickup_fail_reason = str;
        this.deliver_fail_reason = str2;
        this.delivery_status_desc = str3;
        this.delivery_status_mtime = num2;
        this.logistics_flag = l2;
        this.pickup_attempts = num3;
        this.pickup_date_description = str4;
        this.channelid = num4;
        this.extra_data = fVar;
        this.shipping_proof = str5;
        this.shipping_proof_status = num5;
        this.logistics_channel_promotion_rule_id = num6;
        this.rebate_shipping_fee = l3;
        this.expected_receive_time = num7;
        this.original_expected_receive_time = num8;
        this.pouch_size_id = num9;
        this.thirdparty_pickup_time = l4;
        this.logistics_channel_discount_promotion_rule_id = num10;
        this.logistics_channel_discount_promotion_rule_snapshot_id = num11;
        this.preferred_delivery_option = num12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderLogisticsInfo(com.shopee.protocol.shop.OrderLogisticsInfo.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.Long r2 = r0.logisticsid
            java.lang.Integer r3 = r0.pickup_cutoff_time
            java.lang.String r4 = r0.pickup_fail_reason
            java.lang.String r5 = r0.deliver_fail_reason
            java.lang.String r6 = r0.delivery_status_desc
            java.lang.Integer r7 = r0.delivery_status_mtime
            java.lang.Long r8 = r0.logistics_flag
            java.lang.Integer r9 = r0.pickup_attempts
            java.lang.String r10 = r0.pickup_date_description
            java.lang.Integer r11 = r0.channelid
            e.f r12 = r0.extra_data
            java.lang.String r13 = r0.shipping_proof
            java.lang.Integer r14 = r0.shipping_proof_status
            java.lang.Integer r15 = r0.logistics_channel_promotion_rule_id
            r24 = r1
            java.lang.Long r1 = r0.rebate_shipping_fee
            r16 = r1
            java.lang.Integer r1 = r0.expected_receive_time
            r17 = r1
            java.lang.Integer r1 = r0.original_expected_receive_time
            r18 = r1
            java.lang.Integer r1 = r0.pouch_size_id
            r19 = r1
            java.lang.Long r1 = r0.thirdparty_pickup_time
            r20 = r1
            java.lang.Integer r1 = r0.logistics_channel_discount_promotion_rule_id
            r21 = r1
            java.lang.Integer r1 = r0.logistics_channel_discount_promotion_rule_snapshot_id
            r22 = r1
            java.lang.Integer r1 = r0.preferred_delivery_option
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderLogisticsInfo.<init>(com.shopee.protocol.shop.OrderLogisticsInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLogisticsInfo)) {
            return false;
        }
        OrderLogisticsInfo orderLogisticsInfo = (OrderLogisticsInfo) obj;
        if (!equals((Object) this.logisticsid, (Object) orderLogisticsInfo.logisticsid) || !equals((Object) this.pickup_cutoff_time, (Object) orderLogisticsInfo.pickup_cutoff_time) || !equals((Object) this.pickup_fail_reason, (Object) orderLogisticsInfo.pickup_fail_reason) || !equals((Object) this.deliver_fail_reason, (Object) orderLogisticsInfo.deliver_fail_reason) || !equals((Object) this.delivery_status_desc, (Object) orderLogisticsInfo.delivery_status_desc) || !equals((Object) this.delivery_status_mtime, (Object) orderLogisticsInfo.delivery_status_mtime) || !equals((Object) this.logistics_flag, (Object) orderLogisticsInfo.logistics_flag) || !equals((Object) this.pickup_attempts, (Object) orderLogisticsInfo.pickup_attempts) || !equals((Object) this.pickup_date_description, (Object) orderLogisticsInfo.pickup_date_description) || !equals((Object) this.channelid, (Object) orderLogisticsInfo.channelid) || !equals((Object) this.extra_data, (Object) orderLogisticsInfo.extra_data) || !equals((Object) this.shipping_proof, (Object) orderLogisticsInfo.shipping_proof) || !equals((Object) this.shipping_proof_status, (Object) orderLogisticsInfo.shipping_proof_status) || !equals((Object) this.logistics_channel_promotion_rule_id, (Object) orderLogisticsInfo.logistics_channel_promotion_rule_id) || !equals((Object) this.rebate_shipping_fee, (Object) orderLogisticsInfo.rebate_shipping_fee) || !equals((Object) this.expected_receive_time, (Object) orderLogisticsInfo.expected_receive_time) || !equals((Object) this.original_expected_receive_time, (Object) orderLogisticsInfo.original_expected_receive_time) || !equals((Object) this.pouch_size_id, (Object) orderLogisticsInfo.pouch_size_id) || !equals((Object) this.thirdparty_pickup_time, (Object) orderLogisticsInfo.thirdparty_pickup_time) || !equals((Object) this.logistics_channel_discount_promotion_rule_id, (Object) orderLogisticsInfo.logistics_channel_discount_promotion_rule_id) || !equals((Object) this.logistics_channel_discount_promotion_rule_snapshot_id, (Object) orderLogisticsInfo.logistics_channel_discount_promotion_rule_snapshot_id) || !equals((Object) this.preferred_delivery_option, (Object) orderLogisticsInfo.preferred_delivery_option)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.logisticsid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.pickup_cutoff_time;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.pickup_fail_reason;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.deliver_fail_reason;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.delivery_status_desc;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.delivery_status_mtime;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.logistics_flag;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.pickup_attempts;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str4 = this.pickup_date_description;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.channelid;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extra_data;
        int hashCode11 = (hashCode10 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str5 = this.shipping_proof;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num5 = this.shipping_proof_status;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.logistics_channel_promotion_rule_id;
        int hashCode14 = (hashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l3 = this.rebate_shipping_fee;
        int hashCode15 = (hashCode14 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num7 = this.expected_receive_time;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.original_expected_receive_time;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.pouch_size_id;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Long l4 = this.thirdparty_pickup_time;
        int hashCode19 = (hashCode18 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num10 = this.logistics_channel_discount_promotion_rule_id;
        int hashCode20 = (hashCode19 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.logistics_channel_discount_promotion_rule_snapshot_id;
        int hashCode21 = (hashCode20 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.preferred_delivery_option;
        if (num12 != null) {
            i2 = num12.hashCode();
        }
        int i3 = hashCode21 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderLogisticsInfo> {
        public Integer channelid;
        public String deliver_fail_reason;
        public String delivery_status_desc;
        public Integer delivery_status_mtime;
        public Integer expected_receive_time;
        public f extra_data;
        public Integer logistics_channel_discount_promotion_rule_id;
        public Integer logistics_channel_discount_promotion_rule_snapshot_id;
        public Integer logistics_channel_promotion_rule_id;
        public Long logistics_flag;
        public Long logisticsid;
        public Integer original_expected_receive_time;
        public Integer pickup_attempts;
        public Integer pickup_cutoff_time;
        public String pickup_date_description;
        public String pickup_fail_reason;
        public Integer pouch_size_id;
        public Integer preferred_delivery_option;
        public Long rebate_shipping_fee;
        public String shipping_proof;
        public Integer shipping_proof_status;
        public Long thirdparty_pickup_time;

        public Builder() {
        }

        public Builder(OrderLogisticsInfo orderLogisticsInfo) {
            super(orderLogisticsInfo);
            if (orderLogisticsInfo != null) {
                this.logisticsid = orderLogisticsInfo.logisticsid;
                this.pickup_cutoff_time = orderLogisticsInfo.pickup_cutoff_time;
                this.pickup_fail_reason = orderLogisticsInfo.pickup_fail_reason;
                this.deliver_fail_reason = orderLogisticsInfo.deliver_fail_reason;
                this.delivery_status_desc = orderLogisticsInfo.delivery_status_desc;
                this.delivery_status_mtime = orderLogisticsInfo.delivery_status_mtime;
                this.logistics_flag = orderLogisticsInfo.logistics_flag;
                this.pickup_attempts = orderLogisticsInfo.pickup_attempts;
                this.pickup_date_description = orderLogisticsInfo.pickup_date_description;
                this.channelid = orderLogisticsInfo.channelid;
                this.extra_data = orderLogisticsInfo.extra_data;
                this.shipping_proof = orderLogisticsInfo.shipping_proof;
                this.shipping_proof_status = orderLogisticsInfo.shipping_proof_status;
                this.logistics_channel_promotion_rule_id = orderLogisticsInfo.logistics_channel_promotion_rule_id;
                this.rebate_shipping_fee = orderLogisticsInfo.rebate_shipping_fee;
                this.expected_receive_time = orderLogisticsInfo.expected_receive_time;
                this.original_expected_receive_time = orderLogisticsInfo.original_expected_receive_time;
                this.pouch_size_id = orderLogisticsInfo.pouch_size_id;
                this.thirdparty_pickup_time = orderLogisticsInfo.thirdparty_pickup_time;
                this.logistics_channel_discount_promotion_rule_id = orderLogisticsInfo.logistics_channel_discount_promotion_rule_id;
                this.logistics_channel_discount_promotion_rule_snapshot_id = orderLogisticsInfo.logistics_channel_discount_promotion_rule_snapshot_id;
                this.preferred_delivery_option = orderLogisticsInfo.preferred_delivery_option;
            }
        }

        public Builder logisticsid(Long l) {
            this.logisticsid = l;
            return this;
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

        public Builder channelid(Integer num) {
            this.channelid = num;
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

        public Builder preferred_delivery_option(Integer num) {
            this.preferred_delivery_option = num;
            return this;
        }

        public OrderLogisticsInfo build() {
            return new OrderLogisticsInfo(this);
        }
    }
}
