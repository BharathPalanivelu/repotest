package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PriceRange extends Message {
    public static final Integer DEFAULT_COUNT = 0;
    public static final Long DEFAULT_MAX_PRICE = 0L;
    public static final Long DEFAULT_MIN_PRICE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long max_price;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long min_price;

    public PriceRange(Long l, Long l2, Integer num) {
        this.min_price = l;
        this.max_price = l2;
        this.count = num;
    }

    private PriceRange(Builder builder) {
        this(builder.min_price, builder.max_price, builder.count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PriceRange)) {
            return false;
        }
        PriceRange priceRange = (PriceRange) obj;
        if (!equals((Object) this.min_price, (Object) priceRange.min_price) || !equals((Object) this.max_price, (Object) priceRange.max_price) || !equals((Object) this.count, (Object) priceRange.count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.min_price;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.max_price;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.count;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PriceRange> {
        public Integer count;
        public Long max_price;
        public Long min_price;

        public Builder() {
        }

        public Builder(PriceRange priceRange) {
            super(priceRange);
            if (priceRange != null) {
                this.min_price = priceRange.min_price;
                this.max_price = priceRange.max_price;
                this.count = priceRange.count;
            }
        }

        public Builder min_price(Long l) {
            this.min_price = l;
            return this;
        }

        public Builder max_price(Long l) {
            this.max_price = l;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public PriceRange build() {
            return new PriceRange(this);
        }
    }
}
