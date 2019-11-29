package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopStats extends Message {
    public static final Integer DEFAULT_DAY = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STYPE = 0;
    public static final Long DEFAULT_VALUE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer day;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer stype;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long value;

    public ShopStats(Integer num, Integer num2, Integer num3, Long l) {
        this.shopid = num;
        this.day = num2;
        this.stype = num3;
        this.value = l;
    }

    private ShopStats(Builder builder) {
        this(builder.shopid, builder.day, builder.stype, builder.value);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopStats)) {
            return false;
        }
        ShopStats shopStats = (ShopStats) obj;
        if (!equals((Object) this.shopid, (Object) shopStats.shopid) || !equals((Object) this.day, (Object) shopStats.day) || !equals((Object) this.stype, (Object) shopStats.stype) || !equals((Object) this.value, (Object) shopStats.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.day;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.stype;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.value;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopStats> {
        public Integer day;
        public Integer shopid;
        public Integer stype;
        public Long value;

        public Builder() {
        }

        public Builder(ShopStats shopStats) {
            super(shopStats);
            if (shopStats != null) {
                this.shopid = shopStats.shopid;
                this.day = shopStats.day;
                this.stype = shopStats.stype;
                this.value = shopStats.value;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder day(Integer num) {
            this.day = num;
            return this;
        }

        public Builder stype(Integer num) {
            this.stype = num;
            return this;
        }

        public Builder value(Long l) {
            this.value = l;
            return this;
        }

        public ShopStats build() {
            return new ShopStats(this);
        }
    }
}
