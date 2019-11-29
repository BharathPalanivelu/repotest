package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ItemPriceInfo extends Message {
    public static final Long DEFAULT_DISCOUNT = 0L;
    public static final Long DEFAULT_PRICE_MAX = 0L;
    public static final Long DEFAULT_PRICE_MIN = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long discount;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long price_max;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long price_min;

    public ItemPriceInfo(Long l, Long l2, Long l3) {
        this.price_max = l;
        this.price_min = l2;
        this.discount = l3;
    }

    private ItemPriceInfo(Builder builder) {
        this(builder.price_max, builder.price_min, builder.discount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemPriceInfo)) {
            return false;
        }
        ItemPriceInfo itemPriceInfo = (ItemPriceInfo) obj;
        if (!equals((Object) this.price_max, (Object) itemPriceInfo.price_max) || !equals((Object) this.price_min, (Object) itemPriceInfo.price_min) || !equals((Object) this.discount, (Object) itemPriceInfo.discount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.price_max;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.price_min;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.discount;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemPriceInfo> {
        public Long discount;
        public Long price_max;
        public Long price_min;

        public Builder() {
        }

        public Builder(ItemPriceInfo itemPriceInfo) {
            super(itemPriceInfo);
            if (itemPriceInfo != null) {
                this.price_max = itemPriceInfo.price_max;
                this.price_min = itemPriceInfo.price_min;
                this.discount = itemPriceInfo.discount;
            }
        }

        public Builder price_max(Long l) {
            this.price_max = l;
            return this;
        }

        public Builder price_min(Long l) {
            this.price_min = l;
            return this;
        }

        public Builder discount(Long l) {
            this.discount = l;
            return this;
        }

        public ItemPriceInfo build() {
            return new ItemPriceInfo(this);
        }
    }
}
