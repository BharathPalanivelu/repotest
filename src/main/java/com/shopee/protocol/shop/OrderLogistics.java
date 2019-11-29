package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderLogistics extends Message {
    public static final String DEFAULT_ACTUAL_CARRIER = "";
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final Integer DEFAULT_DB_VERSION = 0;
    public static final Integer DEFAULT_DELIVERY_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_LOGISTICS_ID = 0L;
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final Integer DEFAULT_PICKUP_TIME = 0;
    public static final Integer DEFAULT_RECEIVE_TIME = 0;
    public static final String DEFAULT_REGION = "";
    public static final Integer DEFAULT_REVISE_TIME = 0;
    public static final String DEFAULT_SHIPPING_ADDRESS = "";
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Integer DEFAULT_SHIPPING_CONFIRM_TIME = 0;
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_SHIPPING_METHOD = 0;
    public static final String DEFAULT_SHIPPING_NAME = "";
    public static final String DEFAULT_SHIPPING_PHONE = "";
    public static final String DEFAULT_SHIPPING_TRACENO = "";
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Integer DEFAULT_UPDATE_TIME = 0;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String actual_carrier;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer create_time;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer db_version;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer delivery_time;
    @ProtoField(tag = 20, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long logistics_id;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long order_id;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer pickup_time;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer receive_time;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String region;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer revise_time;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String shipping_address;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer shipping_confirm_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long shipping_fee;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shipping_method;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String shipping_phone;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String shipping_traceno;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer update_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer user_id;

    public OrderLogistics(Long l, Integer num, Integer num2, Long l2, Integer num3, String str, String str2, String str3, Long l3, String str4, String str5, String str6, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, f fVar, String str7, Integer num11, Integer num12, Integer num13) {
        this.order_id = l;
        this.user_id = num;
        this.shop_id = num2;
        this.logistics_id = l2;
        this.shipping_method = num3;
        this.shipping_name = str;
        this.shipping_phone = str2;
        this.shipping_address = str3;
        this.shipping_fee = l3;
        this.shipping_carrier = str4;
        this.shipping_traceno = str5;
        this.actual_carrier = str6;
        this.revise_time = num4;
        this.delivery_time = num5;
        this.logistics_status = num6;
        this.pickup_time = num7;
        this.shipping_confirm_time = num8;
        this.receive_time = num9;
        this.cb_option = num10;
        this.extinfo = fVar;
        this.region = str7;
        this.update_time = num11;
        this.create_time = num12;
        this.db_version = num13;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderLogistics(com.shopee.protocol.shop.OrderLogistics.Builder r28) {
        /*
            r27 = this;
            r0 = r28
            r1 = r27
            java.lang.Long r2 = r0.order_id
            java.lang.Integer r3 = r0.user_id
            java.lang.Integer r4 = r0.shop_id
            java.lang.Long r5 = r0.logistics_id
            java.lang.Integer r6 = r0.shipping_method
            java.lang.String r7 = r0.shipping_name
            java.lang.String r8 = r0.shipping_phone
            java.lang.String r9 = r0.shipping_address
            java.lang.Long r10 = r0.shipping_fee
            java.lang.String r11 = r0.shipping_carrier
            java.lang.String r12 = r0.shipping_traceno
            java.lang.String r13 = r0.actual_carrier
            java.lang.Integer r14 = r0.revise_time
            java.lang.Integer r15 = r0.delivery_time
            r26 = r1
            java.lang.Integer r1 = r0.logistics_status
            r16 = r1
            java.lang.Integer r1 = r0.pickup_time
            r17 = r1
            java.lang.Integer r1 = r0.shipping_confirm_time
            r18 = r1
            java.lang.Integer r1 = r0.receive_time
            r19 = r1
            java.lang.Integer r1 = r0.cb_option
            r20 = r1
            e.f r1 = r0.extinfo
            r21 = r1
            java.lang.String r1 = r0.region
            r22 = r1
            java.lang.Integer r1 = r0.update_time
            r23 = r1
            java.lang.Integer r1 = r0.create_time
            r24 = r1
            java.lang.Integer r1 = r0.db_version
            r25 = r1
            r1 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r27.setBuilder(r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderLogistics.<init>(com.shopee.protocol.shop.OrderLogistics$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderLogistics)) {
            return false;
        }
        OrderLogistics orderLogistics = (OrderLogistics) obj;
        if (!equals((Object) this.order_id, (Object) orderLogistics.order_id) || !equals((Object) this.user_id, (Object) orderLogistics.user_id) || !equals((Object) this.shop_id, (Object) orderLogistics.shop_id) || !equals((Object) this.logistics_id, (Object) orderLogistics.logistics_id) || !equals((Object) this.shipping_method, (Object) orderLogistics.shipping_method) || !equals((Object) this.shipping_name, (Object) orderLogistics.shipping_name) || !equals((Object) this.shipping_phone, (Object) orderLogistics.shipping_phone) || !equals((Object) this.shipping_address, (Object) orderLogistics.shipping_address) || !equals((Object) this.shipping_fee, (Object) orderLogistics.shipping_fee) || !equals((Object) this.shipping_carrier, (Object) orderLogistics.shipping_carrier) || !equals((Object) this.shipping_traceno, (Object) orderLogistics.shipping_traceno) || !equals((Object) this.actual_carrier, (Object) orderLogistics.actual_carrier) || !equals((Object) this.revise_time, (Object) orderLogistics.revise_time) || !equals((Object) this.delivery_time, (Object) orderLogistics.delivery_time) || !equals((Object) this.logistics_status, (Object) orderLogistics.logistics_status) || !equals((Object) this.pickup_time, (Object) orderLogistics.pickup_time) || !equals((Object) this.shipping_confirm_time, (Object) orderLogistics.shipping_confirm_time) || !equals((Object) this.receive_time, (Object) orderLogistics.receive_time) || !equals((Object) this.cb_option, (Object) orderLogistics.cb_option) || !equals((Object) this.extinfo, (Object) orderLogistics.extinfo) || !equals((Object) this.region, (Object) orderLogistics.region) || !equals((Object) this.update_time, (Object) orderLogistics.update_time) || !equals((Object) this.create_time, (Object) orderLogistics.create_time) || !equals((Object) this.db_version, (Object) orderLogistics.db_version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.order_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.user_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shop_id;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.logistics_id;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.shipping_method;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.shipping_name;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.shipping_phone;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.shipping_address;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l3 = this.shipping_fee;
        int hashCode9 = (hashCode8 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str4 = this.shipping_carrier;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.shipping_traceno;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.actual_carrier;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num4 = this.revise_time;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.delivery_time;
        int hashCode14 = (hashCode13 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.logistics_status;
        int hashCode15 = (hashCode14 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.pickup_time;
        int hashCode16 = (hashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.shipping_confirm_time;
        int hashCode17 = (hashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.receive_time;
        int hashCode18 = (hashCode17 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.cb_option;
        int hashCode19 = (hashCode18 + (num10 != null ? num10.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode20 = (hashCode19 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str7 = this.region;
        int hashCode21 = (hashCode20 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num11 = this.update_time;
        int hashCode22 = (hashCode21 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.create_time;
        int hashCode23 = (hashCode22 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.db_version;
        if (num13 != null) {
            i2 = num13.hashCode();
        }
        int i3 = hashCode23 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderLogistics> {
        public String actual_carrier;
        public Integer cb_option;
        public Integer create_time;
        public Integer db_version;
        public Integer delivery_time;
        public f extinfo;
        public Long logistics_id;
        public Integer logistics_status;
        public Long order_id;
        public Integer pickup_time;
        public Integer receive_time;
        public String region;
        public Integer revise_time;
        public String shipping_address;
        public String shipping_carrier;
        public Integer shipping_confirm_time;
        public Long shipping_fee;
        public Integer shipping_method;
        public String shipping_name;
        public String shipping_phone;
        public String shipping_traceno;
        public Integer shop_id;
        public Integer update_time;
        public Integer user_id;

        public Builder() {
        }

        public Builder(OrderLogistics orderLogistics) {
            super(orderLogistics);
            if (orderLogistics != null) {
                this.order_id = orderLogistics.order_id;
                this.user_id = orderLogistics.user_id;
                this.shop_id = orderLogistics.shop_id;
                this.logistics_id = orderLogistics.logistics_id;
                this.shipping_method = orderLogistics.shipping_method;
                this.shipping_name = orderLogistics.shipping_name;
                this.shipping_phone = orderLogistics.shipping_phone;
                this.shipping_address = orderLogistics.shipping_address;
                this.shipping_fee = orderLogistics.shipping_fee;
                this.shipping_carrier = orderLogistics.shipping_carrier;
                this.shipping_traceno = orderLogistics.shipping_traceno;
                this.actual_carrier = orderLogistics.actual_carrier;
                this.revise_time = orderLogistics.revise_time;
                this.delivery_time = orderLogistics.delivery_time;
                this.logistics_status = orderLogistics.logistics_status;
                this.pickup_time = orderLogistics.pickup_time;
                this.shipping_confirm_time = orderLogistics.shipping_confirm_time;
                this.receive_time = orderLogistics.receive_time;
                this.cb_option = orderLogistics.cb_option;
                this.extinfo = orderLogistics.extinfo;
                this.region = orderLogistics.region;
                this.update_time = orderLogistics.update_time;
                this.create_time = orderLogistics.create_time;
                this.db_version = orderLogistics.db_version;
            }
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public Builder logistics_id(Long l) {
            this.logistics_id = l;
            return this;
        }

        public Builder shipping_method(Integer num) {
            this.shipping_method = num;
            return this;
        }

        public Builder shipping_name(String str) {
            this.shipping_name = str;
            return this;
        }

        public Builder shipping_phone(String str) {
            this.shipping_phone = str;
            return this;
        }

        public Builder shipping_address(String str) {
            this.shipping_address = str;
            return this;
        }

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
            return this;
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder shipping_traceno(String str) {
            this.shipping_traceno = str;
            return this;
        }

        public Builder actual_carrier(String str) {
            this.actual_carrier = str;
            return this;
        }

        public Builder revise_time(Integer num) {
            this.revise_time = num;
            return this;
        }

        public Builder delivery_time(Integer num) {
            this.delivery_time = num;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Builder pickup_time(Integer num) {
            this.pickup_time = num;
            return this;
        }

        public Builder shipping_confirm_time(Integer num) {
            this.shipping_confirm_time = num;
            return this;
        }

        public Builder receive_time(Integer num) {
            this.receive_time = num;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public Builder update_time(Integer num) {
            this.update_time = num;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder db_version(Integer num) {
            this.db_version = num;
            return this;
        }

        public OrderLogistics build() {
            return new OrderLogistics(this);
        }
    }
}
