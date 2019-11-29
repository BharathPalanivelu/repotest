package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BrandSaleOutOfStockGroup extends Message {
    public static final Integer DEFAULT_BRANDID = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer brandid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;

    public BrandSaleOutOfStockGroup(Integer num, Integer num2) {
        this.brandid = num;
        this.shopid = num2;
    }

    private BrandSaleOutOfStockGroup(Builder builder) {
        this(builder.brandid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BrandSaleOutOfStockGroup)) {
            return false;
        }
        BrandSaleOutOfStockGroup brandSaleOutOfStockGroup = (BrandSaleOutOfStockGroup) obj;
        if (!equals((Object) this.brandid, (Object) brandSaleOutOfStockGroup.brandid) || !equals((Object) this.shopid, (Object) brandSaleOutOfStockGroup.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.brandid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BrandSaleOutOfStockGroup> {
        public Integer brandid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(BrandSaleOutOfStockGroup brandSaleOutOfStockGroup) {
            super(brandSaleOutOfStockGroup);
            if (brandSaleOutOfStockGroup != null) {
                this.brandid = brandSaleOutOfStockGroup.brandid;
                this.shopid = brandSaleOutOfStockGroup.shopid;
            }
        }

        public Builder brandid(Integer num) {
            this.brandid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public BrandSaleOutOfStockGroup build() {
            return new BrandSaleOutOfStockGroup(this);
        }
    }
}
