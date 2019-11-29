package com.shopee.protocol.action;

import com.shopee.protocol.shop.Order;
import com.shopee.protocol.shop.Refund;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderWithRefunds extends Message {
    public static final List<Refund> DEFAULT_REFUNDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Order order;
    @ProtoField(label = Message.Label.REPEATED, messageType = Refund.class, tag = 2)
    public final List<Refund> refunds;

    public OrderWithRefunds(Order order2, List<Refund> list) {
        this.order = order2;
        this.refunds = immutableCopyOf(list);
    }

    private OrderWithRefunds(Builder builder) {
        this(builder.order, builder.refunds);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderWithRefunds)) {
            return false;
        }
        OrderWithRefunds orderWithRefunds = (OrderWithRefunds) obj;
        if (!equals((Object) this.order, (Object) orderWithRefunds.order) || !equals((List<?>) this.refunds, (List<?>) orderWithRefunds.refunds)) {
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
        int hashCode = (order2 != null ? order2.hashCode() : 0) * 37;
        List<Refund> list = this.refunds;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<OrderWithRefunds> {
        public Order order;
        public List<Refund> refunds;

        public Builder() {
        }

        public Builder(OrderWithRefunds orderWithRefunds) {
            super(orderWithRefunds);
            if (orderWithRefunds != null) {
                this.order = orderWithRefunds.order;
                this.refunds = OrderWithRefunds.copyOf(orderWithRefunds.refunds);
            }
        }

        public Builder order(Order order2) {
            this.order = order2;
            return this;
        }

        public Builder refunds(List<Refund> list) {
            this.refunds = checkForNulls(list);
            return this;
        }

        public OrderWithRefunds build() {
            return new OrderWithRefunds(this);
        }
    }
}
