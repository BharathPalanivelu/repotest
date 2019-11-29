package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class OrderItemBatch extends Message {
    public static final List<OrderItemIds> DEFAULT_ITEMS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = OrderItemIds.class, tag = 1)
    public final List<OrderItemIds> items;

    public OrderItemBatch(List<OrderItemIds> list) {
        this.items = immutableCopyOf(list);
    }

    private OrderItemBatch(Builder builder) {
        this(builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemBatch)) {
            return false;
        }
        return equals((List<?>) this.items, (List<?>) ((OrderItemBatch) obj).items);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<OrderItemIds> list = this.items;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<OrderItemBatch> {
        public List<OrderItemIds> items;

        public Builder() {
        }

        public Builder(OrderItemBatch orderItemBatch) {
            super(orderItemBatch);
            if (orderItemBatch != null) {
                this.items = OrderItemBatch.copyOf(orderItemBatch.items);
            }
        }

        public Builder items(List<OrderItemIds> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public OrderItemBatch build() {
            return new OrderItemBatch(this);
        }
    }
}
