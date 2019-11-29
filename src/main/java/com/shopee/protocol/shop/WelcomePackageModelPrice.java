package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WelcomePackageModelPrice extends Message {
    public static final Long DEFAULT_MODELID = 0L;
    public static final Long DEFAULT_PRICE = 0L;
    public static final Integer DEFAULT_PURCHASE_LIMIT = 0;
    public static final Long DEFAULT_REBATE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long price;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer purchase_limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long rebate;

    public WelcomePackageModelPrice(Long l, Long l2, Long l3, Integer num) {
        this.price = l;
        this.modelid = l2;
        this.rebate = l3;
        this.purchase_limit = num;
    }

    private WelcomePackageModelPrice(Builder builder) {
        this(builder.price, builder.modelid, builder.rebate, builder.purchase_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WelcomePackageModelPrice)) {
            return false;
        }
        WelcomePackageModelPrice welcomePackageModelPrice = (WelcomePackageModelPrice) obj;
        if (!equals((Object) this.price, (Object) welcomePackageModelPrice.price) || !equals((Object) this.modelid, (Object) welcomePackageModelPrice.modelid) || !equals((Object) this.rebate, (Object) welcomePackageModelPrice.rebate) || !equals((Object) this.purchase_limit, (Object) welcomePackageModelPrice.purchase_limit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.price;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.modelid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.rebate;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.purchase_limit;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WelcomePackageModelPrice> {
        public Long modelid;
        public Long price;
        public Integer purchase_limit;
        public Long rebate;

        public Builder() {
        }

        public Builder(WelcomePackageModelPrice welcomePackageModelPrice) {
            super(welcomePackageModelPrice);
            if (welcomePackageModelPrice != null) {
                this.price = welcomePackageModelPrice.price;
                this.modelid = welcomePackageModelPrice.modelid;
                this.rebate = welcomePackageModelPrice.rebate;
                this.purchase_limit = welcomePackageModelPrice.purchase_limit;
            }
        }

        public Builder price(Long l) {
            this.price = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder rebate(Long l) {
            this.rebate = l;
            return this;
        }

        public Builder purchase_limit(Integer num) {
            this.purchase_limit = num;
            return this;
        }

        public WelcomePackageModelPrice build() {
            return new WelcomePackageModelPrice(this);
        }
    }
}
