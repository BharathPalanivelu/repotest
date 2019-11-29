package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ShopOrderTax extends Message {
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Long DEFAULT_TAX_AMOUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long tax_amount;

    public ShopOrderTax(Integer num, Long l) {
        this.shopid = num;
        this.tax_amount = l;
    }

    private ShopOrderTax(Builder builder) {
        this(builder.shopid, builder.tax_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopOrderTax)) {
            return false;
        }
        ShopOrderTax shopOrderTax = (ShopOrderTax) obj;
        if (!equals((Object) this.shopid, (Object) shopOrderTax.shopid) || !equals((Object) this.tax_amount, (Object) shopOrderTax.tax_amount)) {
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
        Long l = this.tax_amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopOrderTax> {
        public Integer shopid;
        public Long tax_amount;

        public Builder() {
        }

        public Builder(ShopOrderTax shopOrderTax) {
            super(shopOrderTax);
            if (shopOrderTax != null) {
                this.shopid = shopOrderTax.shopid;
                this.tax_amount = shopOrderTax.tax_amount;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder tax_amount(Long l) {
            this.tax_amount = l;
            return this;
        }

        public ShopOrderTax build() {
            return new ShopOrderTax(this);
        }
    }
}
