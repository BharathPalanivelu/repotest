package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopShipment extends Message {
    public static final Integer DEFAULT_CARRIERID = 0;
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_IS_CUSTOM = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer carrierid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer is_custom;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long shipping_fee;

    public ShopShipment(Integer num, String str, Long l, String str2, Integer num2) {
        this.carrierid = num;
        this.name = str;
        this.shipping_fee = l;
        this.currency = str2;
        this.is_custom = num2;
    }

    private ShopShipment(Builder builder) {
        this(builder.carrierid, builder.name, builder.shipping_fee, builder.currency, builder.is_custom);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopShipment)) {
            return false;
        }
        ShopShipment shopShipment = (ShopShipment) obj;
        if (!equals((Object) this.carrierid, (Object) shopShipment.carrierid) || !equals((Object) this.name, (Object) shopShipment.name) || !equals((Object) this.shipping_fee, (Object) shopShipment.shipping_fee) || !equals((Object) this.currency, (Object) shopShipment.currency) || !equals((Object) this.is_custom, (Object) shopShipment.is_custom)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.carrierid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.shipping_fee;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.currency;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.is_custom;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopShipment> {
        public Integer carrierid;
        public String currency;
        public Integer is_custom;
        public String name;
        public Long shipping_fee;

        public Builder() {
        }

        public Builder(ShopShipment shopShipment) {
            super(shopShipment);
            if (shopShipment != null) {
                this.carrierid = shopShipment.carrierid;
                this.name = shopShipment.name;
                this.shipping_fee = shopShipment.shipping_fee;
                this.currency = shopShipment.currency;
                this.is_custom = shopShipment.is_custom;
            }
        }

        public Builder carrierid(Integer num) {
            this.carrierid = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public Builder is_custom(Integer num) {
            this.is_custom = num;
            return this;
        }

        public ShopShipment build() {
            return new ShopShipment(this);
        }
    }
}
