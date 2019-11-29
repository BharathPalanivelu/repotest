package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderWithInfo extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final OrderInfo info;
    @ProtoField(tag = 1)
    public final Order order;

    public OrderWithInfo(Order order2, OrderInfo orderInfo) {
        this.order = order2;
        this.info = orderInfo;
    }

    private OrderWithInfo(Builder builder) {
        this(builder.order, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderWithInfo)) {
            return false;
        }
        OrderWithInfo orderWithInfo = (OrderWithInfo) obj;
        if (!equals((Object) this.order, (Object) orderWithInfo.order) || !equals((Object) this.info, (Object) orderWithInfo.info)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Order order2 = this.order;
        int i2 = 0;
        int hashCode = (order2 != null ? order2.hashCode() : 0) * 37;
        OrderInfo orderInfo = this.info;
        if (orderInfo != null) {
            i2 = orderInfo.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderWithInfo> {
        public OrderInfo info;
        public Order order;

        public Builder() {
        }

        public Builder(OrderWithInfo orderWithInfo) {
            super(orderWithInfo);
            if (orderWithInfo != null) {
                this.order = orderWithInfo.order;
                this.info = orderWithInfo.info;
            }
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder info(OrderInfo orderInfo) {
            this.info = orderInfo;
            return this;
        }

        public OrderWithInfo build() {
            return new OrderWithInfo(this);
        }
    }
}
