package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CartUpdateOrderExtraInfo extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final CartOrderExtraInfo extrainfo;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public CartUpdateOrderExtraInfo(String str, Integer num, CartOrderExtraInfo cartOrderExtraInfo, String str2) {
        this.requestid = str;
        this.shopid = num;
        this.extrainfo = cartOrderExtraInfo;
        this.token = str2;
    }

    private CartUpdateOrderExtraInfo(Builder builder) {
        this(builder.requestid, builder.shopid, builder.extrainfo, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartUpdateOrderExtraInfo)) {
            return false;
        }
        CartUpdateOrderExtraInfo cartUpdateOrderExtraInfo = (CartUpdateOrderExtraInfo) obj;
        if (!equals((Object) this.requestid, (Object) cartUpdateOrderExtraInfo.requestid) || !equals((Object) this.shopid, (Object) cartUpdateOrderExtraInfo.shopid) || !equals((Object) this.extrainfo, (Object) cartUpdateOrderExtraInfo.extrainfo) || !equals((Object) this.token, (Object) cartUpdateOrderExtraInfo.token)) {
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
        CartOrderExtraInfo cartOrderExtraInfo = this.extrainfo;
        int hashCode3 = (hashCode2 + (cartOrderExtraInfo != null ? cartOrderExtraInfo.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CartUpdateOrderExtraInfo> {
        public CartOrderExtraInfo extrainfo;
        public String requestid;
        public Integer shopid;
        public String token;

        public Builder() {
        }

        public Builder(CartUpdateOrderExtraInfo cartUpdateOrderExtraInfo) {
            super(cartUpdateOrderExtraInfo);
            if (cartUpdateOrderExtraInfo != null) {
                this.requestid = cartUpdateOrderExtraInfo.requestid;
                this.shopid = cartUpdateOrderExtraInfo.shopid;
                this.extrainfo = cartUpdateOrderExtraInfo.extrainfo;
                this.token = cartUpdateOrderExtraInfo.token;
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

        public Builder extrainfo(CartOrderExtraInfo cartOrderExtraInfo) {
            this.extrainfo = cartOrderExtraInfo;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public CartUpdateOrderExtraInfo build() {
            checkRequiredFields();
            return new CartUpdateOrderExtraInfo(this);
        }
    }
}
