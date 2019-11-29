package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrdersnHint extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_ORDERSN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String ordersn;

    public OrdersnHint(String str, Long l) {
        this.ordersn = str;
        this.orderid = l;
    }

    private OrdersnHint(Builder builder) {
        this(builder.ordersn, builder.orderid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrdersnHint)) {
            return false;
        }
        OrdersnHint ordersnHint = (OrdersnHint) obj;
        if (!equals((Object) this.ordersn, (Object) ordersnHint.ordersn) || !equals((Object) this.orderid, (Object) ordersnHint.orderid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.ordersn;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.orderid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrdersnHint> {
        public Long orderid;
        public String ordersn;

        public Builder() {
        }

        public Builder(OrdersnHint ordersnHint) {
            super(ordersnHint);
            if (ordersnHint != null) {
                this.ordersn = ordersnHint.ordersn;
                this.orderid = ordersnHint.orderid;
            }
        }

        public Builder ordersn(String str) {
            this.ordersn = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public OrdersnHint build() {
            return new OrdersnHint(this);
        }
    }
}
