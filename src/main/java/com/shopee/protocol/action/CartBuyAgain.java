package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartBuyAgain extends Message {
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CartBuyAgain(String str, Integer num, Long l, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.orderid = l;
        this.token = str2;
    }

    private CartBuyAgain(Builder builder) {
        this(builder.requestid, builder.shopid, builder.orderid, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartBuyAgain)) {
            return false;
        }
        CartBuyAgain cartBuyAgain = (CartBuyAgain) obj;
        if (!equals((Object) this.requestid, (Object) cartBuyAgain.requestid) || !equals((Object) this.shopid, (Object) cartBuyAgain.shopid) || !equals((Object) this.orderid, (Object) cartBuyAgain.orderid) || !equals((Object) this.token, (Object) cartBuyAgain.token)) {
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
        Long l = this.orderid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartBuyAgain> {
        public Long orderid;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartBuyAgain cartBuyAgain) {
            super(cartBuyAgain);
            if (cartBuyAgain != null) {
                this.requestid = cartBuyAgain.requestid;
                this.shopid = cartBuyAgain.shopid;
                this.orderid = cartBuyAgain.orderid;
                this.token = cartBuyAgain.token;
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

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CartBuyAgain build() {
            checkRequiredFields();
            return new CartBuyAgain(this);
        }
    }
}
