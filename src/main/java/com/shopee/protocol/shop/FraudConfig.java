package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FraudConfig extends Message {
    public static final Long DEFAULT_DEVICE_MAX_CHECKOUT_AMOUNT = 0L;
    public static final Integer DEFAULT_DEVICE_MAX_CHECKOUT_COUNT = 0;
    public static final Integer DEFAULT_DEVICE_MAX_LOGIN_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long device_max_checkout_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer device_max_checkout_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer device_max_login_count;

    public FraudConfig(Integer num, Integer num2, Long l) {
        this.device_max_login_count = num;
        this.device_max_checkout_count = num2;
        this.device_max_checkout_amount = l;
    }

    private FraudConfig(Builder builder) {
        this(builder.device_max_login_count, builder.device_max_checkout_count, builder.device_max_checkout_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FraudConfig)) {
            return false;
        }
        FraudConfig fraudConfig = (FraudConfig) obj;
        if (!equals((Object) this.device_max_login_count, (Object) fraudConfig.device_max_login_count) || !equals((Object) this.device_max_checkout_count, (Object) fraudConfig.device_max_checkout_count) || !equals((Object) this.device_max_checkout_amount, (Object) fraudConfig.device_max_checkout_amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.device_max_login_count;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.device_max_checkout_count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.device_max_checkout_amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FraudConfig> {
        public Long device_max_checkout_amount;
        public Integer device_max_checkout_count;
        public Integer device_max_login_count;

        public Builder() {
        }

        public Builder(FraudConfig fraudConfig) {
            super(fraudConfig);
            if (fraudConfig != null) {
                this.device_max_login_count = fraudConfig.device_max_login_count;
                this.device_max_checkout_count = fraudConfig.device_max_checkout_count;
                this.device_max_checkout_amount = fraudConfig.device_max_checkout_amount;
            }
        }

        public Builder device_max_login_count(Integer num) {
            this.device_max_login_count = num;
            return this;
        }

        public Builder device_max_checkout_count(Integer num) {
            this.device_max_checkout_count = num;
            return this;
        }

        public Builder device_max_checkout_amount(Long l) {
            this.device_max_checkout_amount = l;
            return this;
        }

        public FraudConfig build() {
            return new FraudConfig(this);
        }
    }
}
