package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopBoost;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseShopBoost extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2)
    public final ShopBoost shop_boost;

    public ResponseShopBoost(String str, ShopBoost shopBoost, Integer num) {
        this.requestid = str;
        this.shop_boost = shopBoost;
        this.errcode = num;
    }

    private ResponseShopBoost(Builder builder) {
        this(builder.requestid, builder.shop_boost, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseShopBoost)) {
            return false;
        }
        ResponseShopBoost responseShopBoost = (ResponseShopBoost) obj;
        if (!equals((Object) this.requestid, (Object) responseShopBoost.requestid) || !equals((Object) this.shop_boost, (Object) responseShopBoost.shop_boost) || !equals((Object) this.errcode, (Object) responseShopBoost.errcode)) {
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
        ShopBoost shopBoost = this.shop_boost;
        int hashCode2 = (hashCode + (shopBoost != null ? shopBoost.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseShopBoost> {
        public Integer errcode;
        public String requestid;
        public ShopBoost shop_boost;

        public Builder() {
        }

        public Builder(ResponseShopBoost responseShopBoost) {
            super(responseShopBoost);
            if (responseShopBoost != null) {
                this.requestid = responseShopBoost.requestid;
                this.shop_boost = responseShopBoost.shop_boost;
                this.errcode = responseShopBoost.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder shop_boost(ShopBoost shopBoost) {
            this.shop_boost = shopBoost;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseShopBoost build() {
            return new ResponseShopBoost(this);
        }
    }
}
