package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderBrief extends Message {
    public static final Long DEFAULT_ACTUAL_PRICE = 0L;
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Integer DEFAULT_CANCEL_TIME = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final Integer DEFAULT_COMPLETE_TIME = 0;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_DELIVERY_TIME = 0;
    public static final Integer DEFAULT_LIST_TYPE = 0;
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Integer DEFAULT_ORDER_TYPE = 0;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final Integer DEFAULT_PAY_TIME = 0;
    public static final Integer DEFAULT_PICKUP_TIME = 0;
    public static final Integer DEFAULT_SHIPPING_CONFIRM_TIME = 0;
    public static final Integer DEFAULT_SHIPPING_METHOD = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STATUS_EXT = 0;
    public static final Long DEFAULT_TOTAL_PRICE = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long actual_price;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer cancel_time;
    @ProtoField(tag = 20, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer complete_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer create_time;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer delivery_time;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer list_type;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer order_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer pay_time;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 22, type = Message.Datatype.INT32)
    public final Integer pickup_time;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer shipping_confirm_time;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer shipping_method;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status_ext;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long total_price;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public OrderBrief(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Long l2, Long l3, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Long l4, String str, Integer num17) {
        this.orderid = l;
        this.shopid = num;
        this.userid = num2;
        this.status = num3;
        this.status_ext = num4;
        this.create_time = num5;
        this.pay_time = num6;
        this.delivery_time = num7;
        this.complete_time = num8;
        this.cancel_time = num9;
        this.shipping_confirm_time = num10;
        this.total_price = l2;
        this.actual_price = l3;
        this.shipping_method = num11;
        this.payment_method = num12;
        this.order_type = num13;
        this.archive = num14;
        this.list_type = num15;
        this.logistics_status = num16;
        this.checkoutid = l4;
        this.currency = str;
        this.pickup_time = num17;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderBrief(com.shopee.protocol.shop.OrderBrief.Builder r26) {
        /*
            r25 = this;
            r0 = r26
            r1 = r25
            java.lang.Long r2 = r0.orderid
            java.lang.Integer r3 = r0.shopid
            java.lang.Integer r4 = r0.userid
            java.lang.Integer r5 = r0.status
            java.lang.Integer r6 = r0.status_ext
            java.lang.Integer r7 = r0.create_time
            java.lang.Integer r8 = r0.pay_time
            java.lang.Integer r9 = r0.delivery_time
            java.lang.Integer r10 = r0.complete_time
            java.lang.Integer r11 = r0.cancel_time
            java.lang.Integer r12 = r0.shipping_confirm_time
            java.lang.Long r13 = r0.total_price
            java.lang.Long r14 = r0.actual_price
            java.lang.Integer r15 = r0.shipping_method
            r24 = r1
            java.lang.Integer r1 = r0.payment_method
            r16 = r1
            java.lang.Integer r1 = r0.order_type
            r17 = r1
            java.lang.Integer r1 = r0.archive
            r18 = r1
            java.lang.Integer r1 = r0.list_type
            r19 = r1
            java.lang.Integer r1 = r0.logistics_status
            r20 = r1
            java.lang.Long r1 = r0.checkoutid
            r21 = r1
            java.lang.String r1 = r0.currency
            r22 = r1
            java.lang.Integer r1 = r0.pickup_time
            r23 = r1
            r1 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r25.setBuilder(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderBrief.<init>(com.shopee.protocol.shop.OrderBrief$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderBrief)) {
            return false;
        }
        OrderBrief orderBrief = (OrderBrief) obj;
        if (!equals((Object) this.orderid, (Object) orderBrief.orderid) || !equals((Object) this.shopid, (Object) orderBrief.shopid) || !equals((Object) this.userid, (Object) orderBrief.userid) || !equals((Object) this.status, (Object) orderBrief.status) || !equals((Object) this.status_ext, (Object) orderBrief.status_ext) || !equals((Object) this.create_time, (Object) orderBrief.create_time) || !equals((Object) this.pay_time, (Object) orderBrief.pay_time) || !equals((Object) this.delivery_time, (Object) orderBrief.delivery_time) || !equals((Object) this.complete_time, (Object) orderBrief.complete_time) || !equals((Object) this.cancel_time, (Object) orderBrief.cancel_time) || !equals((Object) this.shipping_confirm_time, (Object) orderBrief.shipping_confirm_time) || !equals((Object) this.total_price, (Object) orderBrief.total_price) || !equals((Object) this.actual_price, (Object) orderBrief.actual_price) || !equals((Object) this.shipping_method, (Object) orderBrief.shipping_method) || !equals((Object) this.payment_method, (Object) orderBrief.payment_method) || !equals((Object) this.order_type, (Object) orderBrief.order_type) || !equals((Object) this.archive, (Object) orderBrief.archive) || !equals((Object) this.list_type, (Object) orderBrief.list_type) || !equals((Object) this.logistics_status, (Object) orderBrief.logistics_status) || !equals((Object) this.checkoutid, (Object) orderBrief.checkoutid) || !equals((Object) this.currency, (Object) orderBrief.currency) || !equals((Object) this.pickup_time, (Object) orderBrief.pickup_time)) {
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
        Integer num3 = this.status;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status_ext;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.create_time;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.pay_time;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.delivery_time;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.complete_time;
        int hashCode9 = (hashCode8 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.cancel_time;
        int hashCode10 = (hashCode9 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.shipping_confirm_time;
        int hashCode11 = (hashCode10 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Long l2 = this.total_price;
        int hashCode12 = (hashCode11 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.actual_price;
        int hashCode13 = (hashCode12 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num11 = this.shipping_method;
        int hashCode14 = (hashCode13 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.payment_method;
        int hashCode15 = (hashCode14 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.order_type;
        int hashCode16 = (hashCode15 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.archive;
        int hashCode17 = (hashCode16 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.list_type;
        int hashCode18 = (hashCode17 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Integer num16 = this.logistics_status;
        int hashCode19 = (hashCode18 + (num16 != null ? num16.hashCode() : 0)) * 37;
        Long l4 = this.checkoutid;
        int hashCode20 = (hashCode19 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode21 = (hashCode20 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num17 = this.pickup_time;
        if (num17 != null) {
            i2 = num17.hashCode();
        }
        int i3 = hashCode21 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderBrief> {
        public Long actual_price;
        public Integer archive;
        public Integer cancel_time;
        public Long checkoutid;
        public Integer complete_time;
        public Integer create_time;
        public String currency;
        public Integer delivery_time;
        public Integer list_type;
        public Integer logistics_status;
        public Integer order_type;
        public Long orderid;
        public Integer pay_time;
        public Integer payment_method;
        public Integer pickup_time;
        public Integer shipping_confirm_time;
        public Integer shipping_method;
        public Integer shopid;
        public Integer status;
        public Integer status_ext;
        public Long total_price;
        public Integer userid;

        public Builder() {
        }

        public Builder(OrderBrief orderBrief) {
            super(orderBrief);
            if (orderBrief != null) {
                this.orderid = orderBrief.orderid;
                this.shopid = orderBrief.shopid;
                this.userid = orderBrief.userid;
                this.status = orderBrief.status;
                this.status_ext = orderBrief.status_ext;
                this.create_time = orderBrief.create_time;
                this.pay_time = orderBrief.pay_time;
                this.delivery_time = orderBrief.delivery_time;
                this.complete_time = orderBrief.complete_time;
                this.cancel_time = orderBrief.cancel_time;
                this.shipping_confirm_time = orderBrief.shipping_confirm_time;
                this.total_price = orderBrief.total_price;
                this.actual_price = orderBrief.actual_price;
                this.shipping_method = orderBrief.shipping_method;
                this.payment_method = orderBrief.payment_method;
                this.order_type = orderBrief.order_type;
                this.archive = orderBrief.archive;
                this.list_type = orderBrief.list_type;
                this.logistics_status = orderBrief.logistics_status;
                this.checkoutid = orderBrief.checkoutid;
                this.currency = orderBrief.currency;
                this.pickup_time = orderBrief.pickup_time;
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

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder status_ext(Integer num) {
            this.status_ext = num;
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

        public Builder shipping_confirm_time(Integer num) {
            this.shipping_confirm_time = num;
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

        public Builder shipping_method(Integer num) {
            this.shipping_method = num;
            return this;
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder order_type(Integer num) {
            this.order_type = num;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder list_type(Integer num) {
            this.list_type = num;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder pickup_time(Integer num) {
            this.pickup_time = num;
            return this;
        }

        public OrderBrief build() {
            checkRequiredFields();
            return new OrderBrief(this);
        }
    }
}
