package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class PaymentOption extends Message {
    public static final Integer DEFAULT_ENABLED = 0;
    public static final f DEFAULT_PARAM = f.f32736b;
    public static final Integer DEFAULT_PAYMENT_METHOD = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer enabled;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f param;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer payment_method;

    public PaymentOption(Integer num, Integer num2, f fVar) {
        this.payment_method = num;
        this.enabled = num2;
        this.param = fVar;
    }

    private PaymentOption(Builder builder) {
        this(builder.payment_method, builder.enabled, builder.param);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentOption)) {
            return false;
        }
        PaymentOption paymentOption = (PaymentOption) obj;
        if (!equals((Object) this.payment_method, (Object) paymentOption.payment_method) || !equals((Object) this.enabled, (Object) paymentOption.enabled) || !equals((Object) this.param, (Object) paymentOption.param)) {
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
        f fVar = this.param;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PaymentOption> {
        public Integer enabled;
        public f param;
        public Integer payment_method;

        public Builder() {
        }

        public Builder(PaymentOption paymentOption) {
            super(paymentOption);
            if (paymentOption != null) {
                this.payment_method = paymentOption.payment_method;
                this.enabled = paymentOption.enabled;
                this.param = paymentOption.param;
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

        public Builder param(f fVar) {
            this.param = fVar;
            return this;
        }

        public PaymentOption build() {
            return new PaymentOption(this);
        }
    }
}
