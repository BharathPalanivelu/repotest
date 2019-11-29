package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartClearOrder extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public CartClearOrder(String str, Integer num, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.token = str2;
    }

    private CartClearOrder(Builder builder) {
        this(builder.requestid, builder.shopid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartClearOrder)) {
            return false;
        }
        CartClearOrder cartClearOrder = (CartClearOrder) obj;
        if (!equals((Object) this.requestid, (Object) cartClearOrder.requestid) || !equals((Object) this.shopid, (Object) cartClearOrder.shopid) || !equals((Object) this.token, (Object) cartClearOrder.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartClearOrder> {
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartClearOrder cartClearOrder) {
            super(cartClearOrder);
            if (cartClearOrder != null) {
                this.requestid = cartClearOrder.requestid;
                this.shopid = cartClearOrder.shopid;
                this.token = cartClearOrder.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CartClearOrder build() {
            checkRequiredFields();
            return new CartClearOrder(this);
        }
    }
}
