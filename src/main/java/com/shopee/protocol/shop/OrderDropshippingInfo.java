package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderDropshippingInfo extends Message {
    public static final Integer DEFAULT_ENABLED = 0;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PHONE_NUMBER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer enabled;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phone_number;

    public OrderDropshippingInfo(Integer num, String str, String str2) {
        this.enabled = num;
        this.name = str;
        this.phone_number = str2;
    }

    private OrderDropshippingInfo(Builder builder) {
        this(builder.enabled, builder.name, builder.phone_number);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderDropshippingInfo)) {
            return false;
        }
        OrderDropshippingInfo orderDropshippingInfo = (OrderDropshippingInfo) obj;
        if (!equals((Object) this.enabled, (Object) orderDropshippingInfo.enabled) || !equals((Object) this.name, (Object) orderDropshippingInfo.name) || !equals((Object) this.phone_number, (Object) orderDropshippingInfo.phone_number)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.enabled;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.phone_number;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderDropshippingInfo> {
        public Integer enabled;
        public String name;
        public String phone_number;

        public Builder() {
        }

        public Builder(OrderDropshippingInfo orderDropshippingInfo) {
            super(orderDropshippingInfo);
            if (orderDropshippingInfo != null) {
                this.enabled = orderDropshippingInfo.enabled;
                this.name = orderDropshippingInfo.name;
                this.phone_number = orderDropshippingInfo.phone_number;
            }
        }

        public Builder enabled(Integer num) {
            this.enabled = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder phone_number(String str) {
            this.phone_number = str;
            return this;
        }

        public OrderDropshippingInfo build() {
            return new OrderDropshippingInfo(this);
        }
    }
}
