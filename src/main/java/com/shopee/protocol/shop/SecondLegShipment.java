package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SecondLegShipment extends Message {
    public static final String DEFAULT_SHIPPING_CARRIER = "";
    public static final Integer DEFAULT_SHIPPING_DATE = 0;
    public static final Long DEFAULT_SHIPPING_FEE = 0L;
    public static final String DEFAULT_TRACKING_NUMBER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String shipping_carrier;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer shipping_date;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long shipping_fee;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String tracking_number;

    public SecondLegShipment(String str, String str2, Long l, Integer num) {
        this.shipping_carrier = str;
        this.tracking_number = str2;
        this.shipping_fee = l;
        this.shipping_date = num;
    }

    private SecondLegShipment(Builder builder) {
        this(builder.shipping_carrier, builder.tracking_number, builder.shipping_fee, builder.shipping_date);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecondLegShipment)) {
            return false;
        }
        SecondLegShipment secondLegShipment = (SecondLegShipment) obj;
        if (!equals((Object) this.shipping_carrier, (Object) secondLegShipment.shipping_carrier) || !equals((Object) this.tracking_number, (Object) secondLegShipment.tracking_number) || !equals((Object) this.shipping_fee, (Object) secondLegShipment.shipping_fee) || !equals((Object) this.shipping_date, (Object) secondLegShipment.shipping_date)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.shipping_carrier;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.tracking_number;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.shipping_fee;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shipping_date;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SecondLegShipment> {
        public String shipping_carrier;
        public Integer shipping_date;
        public Long shipping_fee;
        public String tracking_number;

        public Builder() {
        }

        public Builder(SecondLegShipment secondLegShipment) {
            super(secondLegShipment);
            if (secondLegShipment != null) {
                this.shipping_carrier = secondLegShipment.shipping_carrier;
                this.tracking_number = secondLegShipment.tracking_number;
                this.shipping_fee = secondLegShipment.shipping_fee;
                this.shipping_date = secondLegShipment.shipping_date;
            }
        }

        public Builder shipping_carrier(String str) {
            this.shipping_carrier = str;
            return this;
        }

        public Builder tracking_number(String str) {
            this.tracking_number = str;
            return this;
        }

        public Builder shipping_fee(Long l) {
            this.shipping_fee = l;
            return this;
        }

        public Builder shipping_date(Integer num) {
            this.shipping_date = num;
            return this;
        }

        public SecondLegShipment build() {
            return new SecondLegShipment(this);
        }
    }
}
