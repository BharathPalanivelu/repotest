package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerDropshippingInfo extends Message {
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PHONE_NUMBER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone_number;

    public BuyerDropshippingInfo(String str, String str2) {
        this.name = str;
        this.phone_number = str2;
    }

    private BuyerDropshippingInfo(Builder builder) {
        this(builder.name, builder.phone_number);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerDropshippingInfo)) {
            return false;
        }
        BuyerDropshippingInfo buyerDropshippingInfo = (BuyerDropshippingInfo) obj;
        if (!equals((Object) this.name, (Object) buyerDropshippingInfo.name) || !equals((Object) this.phone_number, (Object) buyerDropshippingInfo.phone_number)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.phone_number;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerDropshippingInfo> {
        public String name;
        public String phone_number;

        public Builder() {
        }

        public Builder(BuyerDropshippingInfo buyerDropshippingInfo) {
            super(buyerDropshippingInfo);
            if (buyerDropshippingInfo != null) {
                this.name = buyerDropshippingInfo.name;
                this.phone_number = buyerDropshippingInfo.phone_number;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder phone_number(String str) {
            this.phone_number = str;
            return this;
        }

        public BuyerDropshippingInfo build() {
            return new BuyerDropshippingInfo(this);
        }
    }
}
