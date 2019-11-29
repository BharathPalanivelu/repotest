package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;

public final class ActPlaceOrder extends Message {
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    public ActPlaceOrder() {
    }

    private ActPlaceOrder(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof ActPlaceOrder;
    }

    public static final class Builder extends Message.Builder<ActPlaceOrder> {
        public Builder() {
        }

        public Builder(ActPlaceOrder actPlaceOrder) {
            super(actPlaceOrder);
        }

        public ActPlaceOrder build() {
            return new ActPlaceOrder(this);
        }
    }
}
