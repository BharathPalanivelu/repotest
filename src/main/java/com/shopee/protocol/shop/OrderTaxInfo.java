package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderTaxInfo extends Message {
    public static final Long DEFAULT_TAX_AMOUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long tax_amount;

    public OrderTaxInfo(Long l) {
        this.tax_amount = l;
    }

    private OrderTaxInfo(Builder builder) {
        this(builder.tax_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderTaxInfo)) {
            return false;
        }
        return equals((Object) this.tax_amount, (Object) ((OrderTaxInfo) obj).tax_amount);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.tax_amount;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<OrderTaxInfo> {
        public Long tax_amount;

        public Builder() {
        }

        public Builder(OrderTaxInfo orderTaxInfo) {
            super(orderTaxInfo);
            if (orderTaxInfo != null) {
                this.tax_amount = orderTaxInfo.tax_amount;
            }
        }

        public Builder tax_amount(Long l) {
            this.tax_amount = l;
            return this;
        }

        public OrderTaxInfo build() {
            return new OrderTaxInfo(this);
        }
    }
}
