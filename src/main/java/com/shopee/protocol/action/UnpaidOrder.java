package com.shopee.protocol.action;

import com.shopee.protocol.shop.Checkout;
import com.shopee.protocol.shop.Order;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UnpaidOrder extends Message {
    public static final List<Order> DEFAULT_ORDERS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final Checkout checkout;
    @ProtoField(label = Message.Label.REPEATED, messageType = Order.class, tag = 2)
    public final List<Order> orders;

    public UnpaidOrder(Checkout checkout2, List<Order> list) {
        this.checkout = checkout2;
        this.orders = immutableCopyOf(list);
    }

    private UnpaidOrder(Builder builder) {
        this(builder.checkout, builder.orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnpaidOrder)) {
            return false;
        }
        UnpaidOrder unpaidOrder = (UnpaidOrder) obj;
        if (!equals((Object) this.checkout, (Object) unpaidOrder.checkout) || !equals((List<?>) this.orders, (List<?>) unpaidOrder.orders)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Checkout checkout2 = this.checkout;
        int hashCode = (checkout2 != null ? checkout2.hashCode() : 0) * 37;
        List<Order> list = this.orders;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<UnpaidOrder> {
        public Checkout checkout;
        public List<Order> orders;

        public Builder() {
        }

        public Builder(UnpaidOrder unpaidOrder) {
            super(unpaidOrder);
            if (unpaidOrder != null) {
                this.checkout = unpaidOrder.checkout;
                this.orders = UnpaidOrder.copyOf(unpaidOrder.orders);
            }
        }

        public Builder checkout(Checkout checkout2) {
            this.checkout = checkout2;
            return this;
        }

        public Builder orders(List<Order> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public UnpaidOrder build() {
            return new UnpaidOrder(this);
        }
    }
}
