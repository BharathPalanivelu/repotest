package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Order extends Message {
    public static final String DEFAULT_ACTUAL_CARRIER = "";
    public static final Long DEFAULT_ACTUAL_PRICE = 0L;
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Integer DEFAULT_BANKACCOUNT_ID = 0;
    public static final Integer DEFAULT_CANCEL_TIME = 0;
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_COMPLETE_TIME = 0;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_DELIVERY_TIME = 0;
    public static final Long DEFAULT_ESCROW_FEE = 0L;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Boolean DEFAULT_IS_RATED = false;
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    public static final Integer DEFAULT_ORDER_TYPE = 0;
    public static final Long DEFAULT_PAID_AMOUNT = 0L;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final Integer DEFAULT_PAY_TIME = 0;
    public static final Integer DEFAULT_PICKUP_TIME = 0;
    public static final Integer DEFAULT_RECEIVE_TIME = 0;
    public static final String DEFAULT_REMARK = "";
    public static final Integer DEFAULT_REVISE_TIME = 0;
    public static final String DEFAULT_SHIPPING_ADDRESS = "";
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Integer DEFAULT_SHIPPING_CONFIRM_TIME = 0;
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    public static final Integer DEFAULT_SHIPPING_METHOD = 0;
    public static final String DEFAULT_SHIPPING_NAME = "";
    public static final String DEFAULT_SHIPPING_PHONE = "";
    public static final String DEFAULT_SHIPPING_TRACENO = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STATUS_EXT = 0;
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String actual_carrier;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long actual_price;
    @ProtoField(tag = 32, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 34, type = Message.Datatype.INT32)
    public final Integer bankaccount_id;
    @ProtoField(tag = 27, type = Message.Datatype.INT32)
    public final Integer cancel_time;
    @ProtoField(tag = 41, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 28, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 26, type = Message.Datatype.INT32)
    public final Integer complete_time;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer create_time;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 25, type = Message.Datatype.INT32)
    public final Integer delivery_time;
    @ProtoField(tag = 19, type = Message.Datatype.INT64)
    public final Long escrow_fee;
    @ProtoField(tag = 29, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 30, type = Message.Datatype.BOOL)
    public final Boolean is_rated;
    @ProtoField(tag = 39, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 35, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 33, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer order_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long paid_amount;
    @ProtoField(tag = 23, type = Message.Datatype.INT32)
    public final Integer pay_time;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 36, type = Message.Datatype.INT32)
    public final Integer pickup_time;
    @ProtoField(tag = 40, type = Message.Datatype.INT32)
    public final Integer receive_time;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String remark;
    @ProtoField(tag = 24, type = Message.Datatype.INT32)
    public final Integer revise_time;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String shipping_address;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 37, type = Message.Datatype.INT32)
    public final Integer shipping_confirm_time;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long shipping_fee;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer shipping_method;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String shipping_name;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String shipping_phone;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String shipping_traceno;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 31, type = Message.Datatype.INT32)
    public final Integer status_ext;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long total_price;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public Order(Long l, Integer num, Integer num2, String str, Long l2, Long l3, Long l4, String str2, Integer num3, String str3, String str4, String str5, Long l5, String str6, String str7, String str8, Integer num4, Integer num5, Long l6, String str9, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Long l7, f fVar, Boolean bool, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22) {
        this.orderid = l;
        this.shopid = num;
        this.userid = num2;
        this.ordersn = str;
        this.total_price = l2;
        this.actual_price = l3;
        this.paid_amount = l4;
        this.currency = str2;
        this.shipping_method = num3;
        this.shipping_name = str3;
        this.shipping_phone = str4;
        this.shipping_address = str5;
        this.shipping_fee = l5;
        this.shipping_carrier = str6;
        this.shipping_traceno = str7;
        this.actual_carrier = str8;
        this.order_type = num4;
        this.payment_method = num5;
        this.escrow_fee = l6;
        this.remark = str9;
        this.status = num6;
        this.create_time = num7;
        this.pay_time = num8;
        this.revise_time = num9;
        this.delivery_time = num10;
        this.complete_time = num11;
        this.cancel_time = num12;
        this.checkoutid = l7;
        this.extinfo = fVar;
        this.is_rated = bool;
        this.status_ext = num13;
        this.archive = num14;
        this.mtime = num15;
        this.bankaccount_id = num16;
        this.logistics_status = num17;
        this.pickup_time = num18;
        this.shipping_confirm_time = num19;
        this.list_type = num20;
        this.receive_time = num21;
        this.cb_option = num22;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Order(com.shopee.protocol.shop.Order.Builder r44) {
        /*
            r43 = this;
            r0 = r44
            r1 = r43
            java.lang.Long r2 = r0.orderid
            java.lang.Integer r3 = r0.shopid
            java.lang.Integer r4 = r0.userid
            java.lang.String r5 = r0.ordersn
            java.lang.Long r6 = r0.total_price
            java.lang.Long r7 = r0.actual_price
            java.lang.Long r8 = r0.paid_amount
            java.lang.String r9 = r0.currency
            java.lang.Integer r10 = r0.shipping_method
            java.lang.String r11 = r0.shipping_name
            java.lang.String r12 = r0.shipping_phone
            java.lang.String r13 = r0.shipping_address
            java.lang.Long r14 = r0.shipping_fee
            java.lang.String r15 = r0.shipping_carrier
            r42 = r1
            java.lang.String r1 = r0.shipping_traceno
            r16 = r1
            java.lang.String r1 = r0.actual_carrier
            r17 = r1
            java.lang.Integer r1 = r0.order_type
            r18 = r1
            java.lang.Integer r1 = r0.payment_method
            r19 = r1
            java.lang.Long r1 = r0.escrow_fee
            r20 = r1
            java.lang.String r1 = r0.remark
            r21 = r1
            java.lang.Integer r1 = r0.status
            r22 = r1
            java.lang.Integer r1 = r0.create_time
            r23 = r1
            java.lang.Integer r1 = r0.pay_time
            r24 = r1
            java.lang.Integer r1 = r0.revise_time
            r25 = r1
            java.lang.Integer r1 = r0.delivery_time
            r26 = r1
            java.lang.Integer r1 = r0.complete_time
            r27 = r1
            java.lang.Integer r1 = r0.cancel_time
            r28 = r1
            java.lang.Long r1 = r0.checkoutid
            r29 = r1
            e.f r1 = r0.extinfo
            r30 = r1
            java.lang.Boolean r1 = r0.is_rated
            r31 = r1
            java.lang.Integer r1 = r0.status_ext
            r32 = r1
            java.lang.Integer r1 = r0.archive
            r33 = r1
            java.lang.Integer r1 = r0.mtime
            r34 = r1
            java.lang.Integer r1 = r0.bankaccount_id
            r35 = r1
            java.lang.Integer r1 = r0.logistics_status
            r36 = r1
            java.lang.Integer r1 = r0.pickup_time
            r37 = r1
            java.lang.Integer r1 = r0.shipping_confirm_time
            r38 = r1
            java.lang.Integer r1 = r0.list_type
            r39 = r1
            java.lang.Integer r1 = r0.receive_time
            r40 = r1
            java.lang.Integer r1 = r0.cb_option
            r41 = r1
            r1 = r42
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r43.setBuilder(r44)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.Order.<init>(com.shopee.protocol.shop.Order$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order order = (Order) obj;
        if (!equals((Object) this.orderid, (Object) order.orderid) || !equals((Object) this.shopid, (Object) order.shopid) || !equals((Object) this.userid, (Object) order.userid) || !equals((Object) this.ordersn, (Object) order.ordersn) || !equals((Object) this.total_price, (Object) order.total_price) || !equals((Object) this.actual_price, (Object) order.actual_price) || !equals((Object) this.paid_amount, (Object) order.paid_amount) || !equals((Object) this.currency, (Object) order.currency) || !equals((Object) this.shipping_method, (Object) order.shipping_method) || !equals((Object) this.shipping_name, (Object) order.shipping_name) || !equals((Object) this.shipping_phone, (Object) order.shipping_phone) || !equals((Object) this.shipping_address, (Object) order.shipping_address) || !equals((Object) this.shipping_fee, (Object) order.shipping_fee) || !equals((Object) this.shipping_carrier, (Object) order.shipping_carrier) || !equals((Object) this.shipping_traceno, (Object) order.shipping_traceno) || !equals((Object) this.actual_carrier, (Object) order.actual_carrier) || !equals((Object) this.order_type, (Object) order.order_type) || !equals((Object) this.payment_method, (Object) order.payment_method) || !equals((Object) this.escrow_fee, (Object) order.escrow_fee) || !equals((Object) this.remark, (Object) order.remark) || !equals((Object) this.status, (Object) order.status) || !equals((Object) this.create_time, (Object) order.create_time) || !equals((Object) this.pay_time, (Object) order.pay_time) || !equals((Object) this.revise_time, (Object) order.revise_time) || !equals((Object) this.delivery_time, (Object) order.delivery_time) || !equals((Object) this.complete_time, (Object) order.complete_time) || !equals((Object) this.cancel_time, (Object) order.cancel_time) || !equals((Object) this.checkoutid, (Object) order.checkoutid) || !equals((Object) this.extinfo, (Object) order.extinfo) || !equals((Object) this.is_rated, (Object) order.is_rated) || !equals((Object) this.status_ext, (Object) order.status_ext) || !equals((Object) this.archive, (Object) order.archive) || !equals((Object) this.mtime, (Object) order.mtime) || !equals((Object) this.bankaccount_id, (Object) order.bankaccount_id) || !equals((Object) this.logistics_status, (Object) order.logistics_status) || !equals((Object) this.pickup_time, (Object) order.pickup_time) || !equals((Object) this.shipping_confirm_time, (Object) order.shipping_confirm_time) || !equals((Object) this.list_type, (Object) order.list_type) || !equals((Object) this.receive_time, (Object) order.receive_time) || !equals((Object) this.cb_option, (Object) order.cb_option)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.orderid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.ordersn;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Long l2 = this.total_price;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.actual_price;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.paid_amount;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str2 = this.currency;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.shipping_method;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.shipping_name;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.shipping_phone;
        int hashCode11 = (hashCode10 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.shipping_address;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l5 = this.shipping_fee;
        int hashCode13 = (hashCode12 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str6 = this.shipping_carrier;
        int hashCode14 = (hashCode13 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.shipping_traceno;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.actual_carrier;
        int hashCode16 = (hashCode15 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num4 = this.order_type;
        int hashCode17 = (hashCode16 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.payment_method;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l6 = this.escrow_fee;
        int hashCode19 = (hashCode18 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str9 = this.remark;
        int hashCode20 = (hashCode19 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num6 = this.status;
        int hashCode21 = (hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.create_time;
        int hashCode22 = (hashCode21 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.pay_time;
        int hashCode23 = (hashCode22 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.revise_time;
        int hashCode24 = (hashCode23 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.delivery_time;
        int hashCode25 = (hashCode24 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.complete_time;
        int hashCode26 = (hashCode25 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.cancel_time;
        int hashCode27 = (hashCode26 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Long l7 = this.checkoutid;
        int hashCode28 = (hashCode27 + (l7 != null ? l7.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode29 = (hashCode28 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Boolean bool = this.is_rated;
        int hashCode30 = (hashCode29 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num13 = this.status_ext;
        int hashCode31 = (hashCode30 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.archive;
        int hashCode32 = (hashCode31 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.mtime;
        int hashCode33 = (hashCode32 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.bankaccount_id;
        int hashCode34 = (hashCode33 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Integer num17 = this.logistics_status;
        int hashCode35 = (hashCode34 + (num17 != null ? num17.hashCode() : 0)) * 37;
        Integer num18 = this.pickup_time;
        int hashCode36 = (hashCode35 + (num18 != null ? num18.hashCode() : 0)) * 37;
        Integer num19 = this.shipping_confirm_time;
        int hashCode37 = (hashCode36 + (num19 != null ? num19.hashCode() : 0)) * 37;
        Integer num20 = this.list_type;
        int hashCode38 = (hashCode37 + (num20 != null ? num20.hashCode() : 0)) * 37;
        Integer num21 = this.receive_time;
        int hashCode39 = (hashCode38 + (num21 != null ? num21.hashCode() : 0)) * 37;
        Integer num22 = this.cb_option;
        if (num22 != null) {
            i2 = num22.hashCode();
        }
        int i3 = hashCode39 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Order> {
        public String actual_carrier;
        public Long actual_price;
        public Integer archive;
        public Integer bankaccount_id;
        public Integer cancel_time;
        public Integer cb_option;
        public Long checkoutid;
        public Integer complete_time;
        public Integer create_time;
        public String currency;
        public Integer delivery_time;
        public Long escrow_fee;
        public f extinfo;
        public Boolean is_rated;
        public Integer list_type;
        public Integer logistics_status;
        public Integer mtime;
        public Integer order_type;
        public Long orderid;
        public String ordersn;
        public Long paid_amount;
        public Integer pay_time;
        public Integer payment_method;
        public Integer pickup_time;
        public Integer receive_time;
        public String remark;
        public Integer revise_time;
        public String shipping_address;
        public String shipping_carrier;
        public Integer shipping_confirm_time;
        public Long shipping_fee;
        public Integer shipping_method;
        public String shipping_name;
        public String shipping_phone;
        public String shipping_traceno;
        public Integer shopid;
        public Integer status;
        public Integer status_ext;
        public Long total_price;
        public Integer userid;

        public Builder() {
        }

        public Builder(Order order) {
            super(order);
            if (order != null) {
                this.orderid = order.orderid;
                this.shopid = order.shopid;
                this.userid = order.userid;
                this.ordersn = order.ordersn;
                this.total_price = order.total_price;
                this.actual_price = order.actual_price;
                this.paid_amount = order.paid_amount;
                this.currency = order.currency;
                this.shipping_method = order.shipping_method;
                this.shipping_name = order.shipping_name;
                this.shipping_phone = order.shipping_phone;
                this.shipping_address = order.shipping_address;
                this.shipping_fee = order.shipping_fee;
                this.shipping_carrier = order.shipping_carrier;
                this.shipping_traceno = order.shipping_traceno;
                this.actual_carrier = order.actual_carrier;
                this.order_type = order.order_type;
                this.payment_method = order.payment_method;
                this.escrow_fee = order.escrow_fee;
                this.remark = order.remark;
                this.status = order.status;
                this.create_time = order.create_time;
                this.pay_time = order.pay_time;
                this.revise_time = order.revise_time;
                this.delivery_time = order.delivery_time;
                this.complete_time = order.complete_time;
                this.cancel_time = order.cancel_time;
                this.checkoutid = order.checkoutid;
                this.extinfo = order.extinfo;
                this.is_rated = order.is_rated;
                this.status_ext = order.status_ext;
                this.archive = order.archive;
                this.mtime = order.mtime;
                this.bankaccount_id = order.bankaccount_id;
                this.logistics_status = order.logistics_status;
                this.pickup_time = order.pickup_time;
                this.shipping_confirm_time = order.shipping_confirm_time;
                this.list_type = order.list_type;
                this.receive_time = order.receive_time;
                this.cb_option = order.cb_option;
            }
        }

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public Builder total_price(Long l) {
            this.total_price = l;
            return this;
        }

        public Builder actual_price(Long l) {
            this.actual_price = l;
            return this;
        }

        public Builder paid_amount(Long l) {
            this.paid_amount = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
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

        public Builder order_type(Integer num) {
            this.order_type = num;
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder escrow_fee(Long l) {
            this.escrow_fee = l;
            return this;
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder pay_time(Integer num) {
            this.pay_time = num;
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

        public Builder complete_time(Integer num) {
            this.complete_time = num;
            return this;
        }

        public Builder cancel_time(Integer num) {
            this.cancel_time = num;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder is_rated(Boolean bool) {
            this.is_rated = bool;
            return this;
        }

        public Builder status_ext(Integer num) {
            this.status_ext = num;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder bankaccount_id(Integer num) {
            this.bankaccount_id = num;
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

        public Builder list_type(Integer num) {
            this.list_type = num;
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

        public Order build() {
            checkRequiredFields();
            return new Order(this);
        }
    }
}
