package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DiscountVoucher extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Integer DEFAULT_PERCENTAGE = 0;
    public static final Long DEFAULT_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer percentage;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long value;

    public DiscountVoucher(Long l, Integer num, Long l2) {
        this.value = l;
        this.percentage = num;
        this.cap = l2;
    }

    private DiscountVoucher(Builder builder) {
        this(builder.value, builder.percentage, builder.cap);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiscountVoucher)) {
            return false;
        }
        DiscountVoucher discountVoucher = (DiscountVoucher) obj;
        if (!equals((Object) this.value, (Object) discountVoucher.value) || !equals((Object) this.percentage, (Object) discountVoucher.percentage) || !equals((Object) this.cap, (Object) discountVoucher.cap)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.value;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.percentage;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.cap;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DiscountVoucher> {
        public Long cap;
        public Integer percentage;
        public Long value;

        public Builder() {
        }

        public Builder(DiscountVoucher discountVoucher) {
            super(discountVoucher);
            if (discountVoucher != null) {
                this.value = discountVoucher.value;
                this.percentage = discountVoucher.percentage;
                this.cap = discountVoucher.cap;
            }
        }

        public Builder value(Long l) {
            this.value = l;
            return this;
        }

        public Builder percentage(Integer num) {
            this.percentage = num;
            return this;
        }

        public Builder cap(Long l) {
            this.cap = l;
            return this;
        }

        public DiscountVoucher build() {
            return new DiscountVoucher(this);
        }
    }
}
