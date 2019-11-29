package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WholesaleTier extends Message {
    public static final Integer DEFAULT_MAX_COUNT = 0;
    public static final Integer DEFAULT_MIN_COUNT = 0;
    public static final Long DEFAULT_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer max_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer min_count;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long price;

    public WholesaleTier(Integer num, Integer num2, Long l) {
        this.min_count = num;
        this.max_count = num2;
        this.price = l;
    }

    private WholesaleTier(Builder builder) {
        this(builder.min_count, builder.max_count, builder.price);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WholesaleTier)) {
            return false;
        }
        WholesaleTier wholesaleTier = (WholesaleTier) obj;
        if (!equals((Object) this.min_count, (Object) wholesaleTier.min_count) || !equals((Object) this.max_count, (Object) wholesaleTier.max_count) || !equals((Object) this.price, (Object) wholesaleTier.price)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.min_count;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.max_count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.price;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WholesaleTier> {
        public Integer max_count;
        public Integer min_count;
        public Long price;

        public Builder() {
        }

        public Builder(WholesaleTier wholesaleTier) {
            super(wholesaleTier);
            if (wholesaleTier != null) {
                this.min_count = wholesaleTier.min_count;
                this.max_count = wholesaleTier.max_count;
                this.price = wholesaleTier.price;
            }
        }

        public Builder min_count(Integer num) {
            this.min_count = num;
            return this;
        }

        public Builder max_count(Integer num) {
            this.max_count = num;
            return this;
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public WholesaleTier build() {
            return new WholesaleTier(this);
        }
    }
}
