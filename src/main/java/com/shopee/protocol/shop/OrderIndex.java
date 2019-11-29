package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderIndex extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ordersn;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public OrderIndex(Long l, Integer num, Integer num2, String str) {
        this.orderid = l;
        this.shopid = num;
        this.userid = num2;
        this.ordersn = str;
    }

    private OrderIndex(Builder builder) {
        this(builder.orderid, builder.shopid, builder.userid, builder.ordersn);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderIndex)) {
            return false;
        }
        OrderIndex orderIndex = (OrderIndex) obj;
        if (!equals((Object) this.orderid, (Object) orderIndex.orderid) || !equals((Object) this.shopid, (Object) orderIndex.shopid) || !equals((Object) this.userid, (Object) orderIndex.userid) || !equals((Object) this.ordersn, (Object) orderIndex.ordersn)) {
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
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderIndex> {
        public Long orderid;
        public String ordersn;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(OrderIndex orderIndex) {
            super(orderIndex);
            if (orderIndex != null) {
                this.orderid = orderIndex.orderid;
                this.shopid = orderIndex.shopid;
                this.userid = orderIndex.userid;
                this.ordersn = orderIndex.ordersn;
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

        public OrderIndex build() {
            return new OrderIndex(this);
        }
    }
}
