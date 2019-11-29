package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckoutCountSummary extends Message {
    public static final Integer DEFAULT_DAILY = 0;
    public static final Integer DEFAULT_MONTHLY = 0;
    public static final Integer DEFAULT_WEEKLY = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer daily;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer monthly;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer weekly;

    public CheckoutCountSummary(Integer num, Integer num2, Integer num3) {
        this.daily = num;
        this.weekly = num2;
        this.monthly = num3;
    }

    private CheckoutCountSummary(Builder builder) {
        this(builder.daily, builder.weekly, builder.monthly);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutCountSummary)) {
            return false;
        }
        CheckoutCountSummary checkoutCountSummary = (CheckoutCountSummary) obj;
        if (!equals((Object) this.daily, (Object) checkoutCountSummary.daily) || !equals((Object) this.weekly, (Object) checkoutCountSummary.weekly) || !equals((Object) this.monthly, (Object) checkoutCountSummary.monthly)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.daily;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.weekly;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.monthly;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckoutCountSummary> {
        public Integer daily;
        public Integer monthly;
        public Integer weekly;

        public Builder() {
        }

        public Builder(CheckoutCountSummary checkoutCountSummary) {
            super(checkoutCountSummary);
            if (checkoutCountSummary != null) {
                this.daily = checkoutCountSummary.daily;
                this.weekly = checkoutCountSummary.weekly;
                this.monthly = checkoutCountSummary.monthly;
            }
        }

        public Builder daily(Integer num) {
            this.daily = num;
            return this;
        }

        public Builder weekly(Integer num) {
            this.weekly = num;
            return this;
        }

        public Builder monthly(Integer num) {
            this.monthly = num;
            return this;
        }

        public CheckoutCountSummary build() {
            return new CheckoutCountSummary(this);
        }
    }
}
