package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartItemWithShop extends Message {
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final CartItemInfo info;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public CartItemWithShop(CartItemInfo cartItemInfo, Integer num) {
        this.info = cartItemInfo;
        this.shopid = num;
    }

    private CartItemWithShop(Builder builder) {
        this(builder.info, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartItemWithShop)) {
            return false;
        }
        CartItemWithShop cartItemWithShop = (CartItemWithShop) obj;
        if (!equals((Object) this.info, (Object) cartItemWithShop.info) || !equals((Object) this.shopid, (Object) cartItemWithShop.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        CartItemInfo cartItemInfo = this.info;
        int i2 = 0;
        int hashCode = (cartItemInfo != null ? cartItemInfo.hashCode() : 0) * 37;
        Integer num = this.shopid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartItemWithShop> {
        public CartItemInfo info;
        public Integer shopid;

        public Builder() {
        }

        public Builder(CartItemWithShop cartItemWithShop) {
            super(cartItemWithShop);
            if (cartItemWithShop != null) {
                this.info = cartItemWithShop.info;
                this.shopid = cartItemWithShop.shopid;
            }
        }

        public Builder info(CartItemInfo cartItemInfo) {
            this.info = cartItemInfo;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public CartItemWithShop build() {
            return new CartItemWithShop(this);
        }
    }
}
