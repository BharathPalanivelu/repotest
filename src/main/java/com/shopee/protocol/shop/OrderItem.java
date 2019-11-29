package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class OrderItem extends Message {
    public static final Integer DEFAULT_AMOUNT = 0;
    public static final Long DEFAULT_CHATID = 0L;
    public static final String DEFAULT_CURRENCY = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_ITEM_PRICE = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_OFFERID = 0L;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_ORDER_PRICE = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_SNAPSHOTID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer amount;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long item_price;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long offerid;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long order_price;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long snapshotid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public OrderItem(Integer num, Long l, Integer num2, Long l2, Long l3, Integer num3, Long l4, Long l5, String str, Integer num4, Long l6, Long l7, Long l8, f fVar, Long l9) {
        this.userid = num;
        this.orderid = l;
        this.shopid = num2;
        this.itemid = l2;
        this.modelid = l3;
        this.amount = num3;
        this.item_price = l4;
        this.order_price = l5;
        this.currency = str;
        this.status = num4;
        this.chatid = l6;
        this.snapshotid = l7;
        this.offerid = l8;
        this.extinfo = fVar;
        this.groupid = l9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderItem(com.shopee.protocol.shop.OrderItem.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Integer r2 = r0.userid
            java.lang.Long r3 = r0.orderid
            java.lang.Integer r4 = r0.shopid
            java.lang.Long r5 = r0.itemid
            java.lang.Long r6 = r0.modelid
            java.lang.Integer r7 = r0.amount
            java.lang.Long r8 = r0.item_price
            java.lang.Long r9 = r0.order_price
            java.lang.String r10 = r0.currency
            java.lang.Integer r11 = r0.status
            java.lang.Long r12 = r0.chatid
            java.lang.Long r13 = r0.snapshotid
            java.lang.Long r14 = r0.offerid
            e.f r15 = r0.extinfo
            java.lang.Long r1 = r0.groupid
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.OrderItem.<init>(com.shopee.protocol.shop.OrderItem$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) obj;
        if (!equals((Object) this.userid, (Object) orderItem.userid) || !equals((Object) this.orderid, (Object) orderItem.orderid) || !equals((Object) this.shopid, (Object) orderItem.shopid) || !equals((Object) this.itemid, (Object) orderItem.itemid) || !equals((Object) this.modelid, (Object) orderItem.modelid) || !equals((Object) this.amount, (Object) orderItem.amount) || !equals((Object) this.item_price, (Object) orderItem.item_price) || !equals((Object) this.order_price, (Object) orderItem.order_price) || !equals((Object) this.currency, (Object) orderItem.currency) || !equals((Object) this.status, (Object) orderItem.status) || !equals((Object) this.chatid, (Object) orderItem.chatid) || !equals((Object) this.snapshotid, (Object) orderItem.snapshotid) || !equals((Object) this.offerid, (Object) orderItem.offerid) || !equals((Object) this.extinfo, (Object) orderItem.extinfo) || !equals((Object) this.groupid, (Object) orderItem.groupid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.modelid;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num3 = this.amount;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l4 = this.item_price;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.order_price;
        int hashCode8 = (hashCode7 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str = this.currency;
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l6 = this.chatid;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.snapshotid;
        int hashCode12 = (hashCode11 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.offerid;
        int hashCode13 = (hashCode12 + (l8 != null ? l8.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode14 = (hashCode13 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l9 = this.groupid;
        if (l9 != null) {
            i2 = l9.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderItem> {
        public Integer amount;
        public Long chatid;
        public String currency;
        public f extinfo;
        public Long groupid;
        public Long item_price;
        public Long itemid;
        public Long modelid;
        public Long offerid;
        public Long order_price;
        public Long orderid;
        public Integer shopid;
        public Long snapshotid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(OrderItem orderItem) {
            super(orderItem);
            if (orderItem != null) {
                this.userid = orderItem.userid;
                this.orderid = orderItem.orderid;
                this.shopid = orderItem.shopid;
                this.itemid = orderItem.itemid;
                this.modelid = orderItem.modelid;
                this.amount = orderItem.amount;
                this.item_price = orderItem.item_price;
                this.order_price = orderItem.order_price;
                this.currency = orderItem.currency;
                this.status = orderItem.status;
                this.chatid = orderItem.chatid;
                this.snapshotid = orderItem.snapshotid;
                this.offerid = orderItem.offerid;
                this.extinfo = orderItem.extinfo;
                this.groupid = orderItem.groupid;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder amount(Integer num) {
            this.amount = num;
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

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder snapshotid(Long l) {
            this.snapshotid = l;
            return this;
        }

        public Builder offerid(Long l) {
            this.offerid = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public OrderItem build() {
            checkRequiredFields();
            return new OrderItem(this);
        }
    }
}
