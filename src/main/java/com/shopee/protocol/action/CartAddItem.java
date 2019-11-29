package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartAddItem extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Boolean DEFAULT_UPDATE_CHECKOUT_ONLY = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final CartItemInfo iteminfo;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean update_checkout_only;

    public CartAddItem(String str, Integer num, CartItemInfo cartItemInfo, String str2, Boolean bool) {
        this.requestid = str;
        this.shopid = num;
        this.iteminfo = cartItemInfo;
        this.token = str2;
        this.update_checkout_only = bool;
    }

    private CartAddItem(Builder builder) {
        this(builder.requestid, builder.shopid, builder.iteminfo, builder.token, builder.update_checkout_only);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartAddItem)) {
            return false;
        }
        CartAddItem cartAddItem = (CartAddItem) obj;
        if (!equals((Object) this.requestid, (Object) cartAddItem.requestid) || !equals((Object) this.shopid, (Object) cartAddItem.shopid) || !equals((Object) this.iteminfo, (Object) cartAddItem.iteminfo) || !equals((Object) this.token, (Object) cartAddItem.token) || !equals((Object) this.update_checkout_only, (Object) cartAddItem.update_checkout_only)) {
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
        CartItemInfo cartItemInfo = this.iteminfo;
        int hashCode3 = (hashCode2 + (cartItemInfo != null ? cartItemInfo.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.update_checkout_only;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartAddItem> {
        public CartItemInfo iteminfo;
        public String requestid;
        public Integer shopid;
        public String token;
        public Boolean update_checkout_only;

        public Builder() {
        }

        public Builder(CartAddItem cartAddItem) {
            super(cartAddItem);
            if (cartAddItem != null) {
                this.requestid = cartAddItem.requestid;
                this.shopid = cartAddItem.shopid;
                this.iteminfo = cartAddItem.iteminfo;
                this.token = cartAddItem.token;
                this.update_checkout_only = cartAddItem.update_checkout_only;
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

        public Builder iteminfo(CartItemInfo cartItemInfo) {
            this.iteminfo = cartItemInfo;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder update_checkout_only(Boolean bool) {
            this.update_checkout_only = bool;
            return this;
        }

        public CartAddItem build() {
            checkRequiredFields();
            return new CartAddItem(this);
        }
    }
}
