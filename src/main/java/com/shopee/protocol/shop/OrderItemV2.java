package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderItemV2 extends Message {
    public static final Integer DEFAULT_ACTUAL_AMOUNT = 0;
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_CHAT_ID = 0L;
    public static final Integer DEFAULT_CREATE_TIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_GROUP_ID = 0L;
    public static final Long DEFAULT_ITEM_ID = 0L;
    public static final Long DEFAULT_ITEM_PRICE = 0L;
    public static final Long DEFAULT_MODEL_ID = 0L;
    public static final Long DEFAULT_OFFER_ID = 0L;
    public static final Long DEFAULT_ORDER_ID = 0L;
    public static final Long DEFAULT_ORDER_ITEM_ID = 0L;
    public static final Integer DEFAULT_ORDER_ITEM_STATUS = 0;
    public static final Long DEFAULT_ORDER_PRICE = 0L;
    public static final String DEFAULT_REGION = "";
    public static final Integer DEFAULT_SHOP_ID = 0;
    public static final Long DEFAULT_SNAPSHOT_ID = 0L;
    public static final Integer DEFAULT_USER_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer actual_amount;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long chat_id;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer create_time;
    @ProtoField(tag = 18, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 16, type = Message.Datatype.INT64)
    public final Long group_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT64)
    public final Long item_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long item_price;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long model_id;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long offer_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long order_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long order_item_id;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer order_item_status;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long order_price;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String region;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shop_id;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long snapshot_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer user_id;

    public OrderItemV2(Long l, Integer num, Long l2, Integer num2, Long l3, Long l4, Integer num3, Integer num4, Long l5, Long l6, String str, Integer num5, Long l7, Long l8, Long l9, Long l10, Integer num6, f fVar) {
        this.order_item_id = l;
        this.user_id = num;
        this.order_id = l2;
        this.shop_id = num2;
        this.item_id = l3;
        this.model_id = l4;
        this.amount = num3;
        this.actual_amount = num4;
        this.item_price = l5;
        this.order_price = l6;
        this.region = str;
        this.order_item_status = num5;
        this.chat_id = l7;
        this.snapshot_id = l8;
        this.offer_id = l9;
        this.group_id = l10;
        this.create_time = num6;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderItemV2(com.shopee.protocol.shop.OrderItemV2.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Long r2 = r0.order_item_id
            java.lang.Integer r3 = r0.user_id
            java.lang.Long r4 = r0.order_id
            java.lang.Integer r5 = r0.shop_id
            java.lang.Long r6 = r0.item_id
            java.lang.Long r7 = r0.model_id
            java.lang.Integer r8 = r0.amount
            java.lang.Integer r9 = r0.actual_amount
            java.lang.Long r10 = r0.item_price
            java.lang.Long r11 = r0.order_price
            java.lang.String r12 = r0.region
            java.lang.Integer r13 = r0.order_item_status
            java.lang.Long r14 = r0.chat_id
            java.lang.Long r15 = r0.snapshot_id
            r20 = r1
            java.lang.Long r1 = r0.offer_id
            r16 = r1
            java.lang.Long r1 = r0.group_id
            r17 = r1
            java.lang.Integer r1 = r0.create_time
            r18 = r1
            e.f r1 = r0.extinfo
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderItemV2.<init>(com.shopee.protocol.shop.OrderItemV2$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemV2)) {
            return false;
        }
        OrderItemV2 orderItemV2 = (OrderItemV2) obj;
        if (!equals((Object) this.order_item_id, (Object) orderItemV2.order_item_id) || !equals((Object) this.user_id, (Object) orderItemV2.user_id) || !equals((Object) this.order_id, (Object) orderItemV2.order_id) || !equals((Object) this.shop_id, (Object) orderItemV2.shop_id) || !equals((Object) this.item_id, (Object) orderItemV2.item_id) || !equals((Object) this.model_id, (Object) orderItemV2.model_id) || !equals((Object) this.amount, (Object) orderItemV2.amount) || !equals((Object) this.actual_amount, (Object) orderItemV2.actual_amount) || !equals((Object) this.item_price, (Object) orderItemV2.item_price) || !equals((Object) this.order_price, (Object) orderItemV2.order_price) || !equals((Object) this.region, (Object) orderItemV2.region) || !equals((Object) this.order_item_status, (Object) orderItemV2.order_item_status) || !equals((Object) this.chat_id, (Object) orderItemV2.chat_id) || !equals((Object) this.snapshot_id, (Object) orderItemV2.snapshot_id) || !equals((Object) this.offer_id, (Object) orderItemV2.offer_id) || !equals((Object) this.group_id, (Object) orderItemV2.group_id) || !equals((Object) this.create_time, (Object) orderItemV2.create_time) || !equals((Object) this.extinfo, (Object) orderItemV2.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.order_item_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.user_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.order_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.shop_id;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l3 = this.item_id;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.model_id;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num3 = this.amount;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.actual_amount;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l5 = this.item_price;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.order_price;
        int hashCode10 = (hashCode9 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str = this.region;
        int hashCode11 = (hashCode10 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.order_item_status;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l7 = this.chat_id;
        int hashCode13 = (hashCode12 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.snapshot_id;
        int hashCode14 = (hashCode13 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.offer_id;
        int hashCode15 = (hashCode14 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.group_id;
        int hashCode16 = (hashCode15 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Integer num6 = this.create_time;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderItemV2> {
        public Integer actual_amount;
        public Integer amount;
        public Long chat_id;
        public Integer create_time;
        public f extinfo;
        public Long group_id;
        public Long item_id;
        public Long item_price;
        public Long model_id;
        public Long offer_id;
        public Long order_id;
        public Long order_item_id;
        public Integer order_item_status;
        public Long order_price;
        public String region;
        public Integer shop_id;
        public Long snapshot_id;
        public Integer user_id;

        public Builder() {
        }

        public Builder(OrderItemV2 orderItemV2) {
            super(orderItemV2);
            if (orderItemV2 != null) {
                this.order_item_id = orderItemV2.order_item_id;
                this.user_id = orderItemV2.user_id;
                this.order_id = orderItemV2.order_id;
                this.shop_id = orderItemV2.shop_id;
                this.item_id = orderItemV2.item_id;
                this.model_id = orderItemV2.model_id;
                this.amount = orderItemV2.amount;
                this.actual_amount = orderItemV2.actual_amount;
                this.item_price = orderItemV2.item_price;
                this.order_price = orderItemV2.order_price;
                this.region = orderItemV2.region;
                this.order_item_status = orderItemV2.order_item_status;
                this.chat_id = orderItemV2.chat_id;
                this.snapshot_id = orderItemV2.snapshot_id;
                this.offer_id = orderItemV2.offer_id;
                this.group_id = orderItemV2.group_id;
                this.create_time = orderItemV2.create_time;
                this.extinfo = orderItemV2.extinfo;
            }
        }

        public Builder order_item_id(Long l) {
            this.order_item_id = l;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public Builder shop_id(Integer num) {
            this.shop_id = num;
            return this;
        }

        public Builder item_id(Long l) {
            this.item_id = l;
            return this;
        }

        public Builder model_id(Long l) {
            this.model_id = l;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
            return this;
        }

        public Builder actual_amount(Integer num) {
            this.actual_amount = num;
            return this;
        }

        public Builder item_price(Long l) {
            this.item_price = l;
            return this;
        }

        public Builder order_price(Long l) {
            this.order_price = l;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public Builder order_item_status(Integer num) {
            this.order_item_status = num;
            return this;
        }

        public Builder chat_id(Long l) {
            this.chat_id = l;
            return this;
        }

        public Builder snapshot_id(Long l) {
            this.snapshot_id = l;
            return this;
        }

        public Builder offer_id(Long l) {
            this.offer_id = l;
            return this;
        }

        public Builder group_id(Long l) {
            this.group_id = l;
            return this;
        }

        public Builder create_time(Integer num) {
            this.create_time = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public OrderItemV2 build() {
            checkRequiredFields();
            return new OrderItemV2(this);
        }
    }
}
