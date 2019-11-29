package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ServiceFeeOrderInfo extends Message {
    public static final Long DEFAULT_FEE_AMOUNT = 0L;
    public static final Long DEFAULT_INITIAL_FEE_AMOUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long fee_amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long initial_fee_amount;

    public ServiceFeeOrderInfo(Long l, Long l2) {
        this.fee_amount = l;
        this.initial_fee_amount = l2;
    }

    private ServiceFeeOrderInfo(Builder builder) {
        this(builder.fee_amount, builder.initial_fee_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceFeeOrderInfo)) {
            return false;
        }
        ServiceFeeOrderInfo serviceFeeOrderInfo = (ServiceFeeOrderInfo) obj;
        if (!equals((Object) this.fee_amount, (Object) serviceFeeOrderInfo.fee_amount) || !equals((Object) this.initial_fee_amount, (Object) serviceFeeOrderInfo.initial_fee_amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.fee_amount;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.initial_fee_amount;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ServiceFeeOrderInfo> {
        public Long fee_amount;
        public Long initial_fee_amount;

        public Builder() {
        }

        public Builder(ServiceFeeOrderInfo serviceFeeOrderInfo) {
            super(serviceFeeOrderInfo);
            if (serviceFeeOrderInfo != null) {
                this.fee_amount = serviceFeeOrderInfo.fee_amount;
                this.initial_fee_amount = serviceFeeOrderInfo.initial_fee_amount;
            }
        }

        public Builder fee_amount(Long l) {
            this.fee_amount = l;
            return this;
        }

        public Builder initial_fee_amount(Long l) {
            this.initial_fee_amount = l;
            return this;
        }

        public ServiceFeeOrderInfo build() {
            return new ServiceFeeOrderInfo(this);
        }
    }
}
