package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopEscrowPaymentOption extends Message {
    public static final String DEFAULT_CURRENCY = "";
    public static final Integer DEFAULT_ENABLED = 0;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    public static final Long DEFAULT_SERVICE_FEE = 0L;
    public static final Integer DEFAULT_SERVICE_FEE_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String currency;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer enabled;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer payment_method;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long service_fee;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer service_fee_type;

    public ShopEscrowPaymentOption(Integer num, Integer num2, Integer num3, Long l, String str) {
        this.payment_method = num;
        this.enabled = num2;
        this.service_fee_type = num3;
        this.service_fee = l;
        this.currency = str;
    }

    private ShopEscrowPaymentOption(Builder builder) {
        this(builder.payment_method, builder.enabled, builder.service_fee_type, builder.service_fee, builder.currency);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopEscrowPaymentOption)) {
            return false;
        }
        ShopEscrowPaymentOption shopEscrowPaymentOption = (ShopEscrowPaymentOption) obj;
        if (!equals((Object) this.payment_method, (Object) shopEscrowPaymentOption.payment_method) || !equals((Object) this.enabled, (Object) shopEscrowPaymentOption.enabled) || !equals((Object) this.service_fee_type, (Object) shopEscrowPaymentOption.service_fee_type) || !equals((Object) this.service_fee, (Object) shopEscrowPaymentOption.service_fee) || !equals((Object) this.currency, (Object) shopEscrowPaymentOption.currency)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.payment_method;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.enabled;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.service_fee_type;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.service_fee;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.currency;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopEscrowPaymentOption> {
        public String currency;
        public Integer enabled;
        public Integer payment_method;
        public Long service_fee;
        public Integer service_fee_type;

        public Builder() {
        }

        public Builder(ShopEscrowPaymentOption shopEscrowPaymentOption) {
            super(shopEscrowPaymentOption);
            if (shopEscrowPaymentOption != null) {
                this.payment_method = shopEscrowPaymentOption.payment_method;
                this.enabled = shopEscrowPaymentOption.enabled;
                this.service_fee_type = shopEscrowPaymentOption.service_fee_type;
                this.service_fee = shopEscrowPaymentOption.service_fee;
                this.currency = shopEscrowPaymentOption.currency;
            }
        }

        public Builder payment_method(Integer num) {
            this.payment_method = num;
            return this;
        }

        public Builder enabled(Integer num) {
            this.enabled = num;
            return this;
        }

        public Builder service_fee_type(Integer num) {
            this.service_fee_type = num;
            return this;
        }

        public Builder service_fee(Long l) {
            this.service_fee = l;
            return this;
        }

        public Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public ShopEscrowPaymentOption build() {
            return new ShopEscrowPaymentOption(this);
        }
    }
}
