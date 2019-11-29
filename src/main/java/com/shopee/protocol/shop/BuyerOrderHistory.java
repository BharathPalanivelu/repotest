package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BuyerOrderHistory extends Message {
    public static final Integer DEFAULT_COD_ORDER_COUNT = 0;
    public static final Integer DEFAULT_COD_SUCC_COUNT = 0;
    public static final Integer DEFAULT_DELIVERY_ORDER_COUNT = 0;
    public static final Integer DEFAULT_DELIVERY_SUCC_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer cod_order_count;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer cod_succ_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer delivery_order_count;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer delivery_succ_count;

    public BuyerOrderHistory(Integer num, Integer num2, Integer num3, Integer num4) {
        this.delivery_order_count = num;
        this.delivery_succ_count = num2;
        this.cod_order_count = num3;
        this.cod_succ_count = num4;
    }

    private BuyerOrderHistory(Builder builder) {
        this(builder.delivery_order_count, builder.delivery_succ_count, builder.cod_order_count, builder.cod_succ_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerOrderHistory)) {
            return false;
        }
        BuyerOrderHistory buyerOrderHistory = (BuyerOrderHistory) obj;
        if (!equals((Object) this.delivery_order_count, (Object) buyerOrderHistory.delivery_order_count) || !equals((Object) this.delivery_succ_count, (Object) buyerOrderHistory.delivery_succ_count) || !equals((Object) this.cod_order_count, (Object) buyerOrderHistory.cod_order_count) || !equals((Object) this.cod_succ_count, (Object) buyerOrderHistory.cod_succ_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.delivery_order_count;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.delivery_succ_count;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.cod_order_count;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.cod_succ_count;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerOrderHistory> {
        public Integer cod_order_count;
        public Integer cod_succ_count;
        public Integer delivery_order_count;
        public Integer delivery_succ_count;

        public Builder() {
        }

        public Builder(BuyerOrderHistory buyerOrderHistory) {
            super(buyerOrderHistory);
            if (buyerOrderHistory != null) {
                this.delivery_order_count = buyerOrderHistory.delivery_order_count;
                this.delivery_succ_count = buyerOrderHistory.delivery_succ_count;
                this.cod_order_count = buyerOrderHistory.cod_order_count;
                this.cod_succ_count = buyerOrderHistory.cod_succ_count;
            }
        }

        public Builder delivery_order_count(Integer num) {
            this.delivery_order_count = num;
            return this;
        }

        public Builder delivery_succ_count(Integer num) {
            this.delivery_succ_count = num;
            return this;
        }

        public Builder cod_order_count(Integer num) {
            this.cod_order_count = num;
            return this;
        }

        public Builder cod_succ_count(Integer num) {
            this.cod_succ_count = num;
            return this;
        }

        public BuyerOrderHistory build() {
            return new BuyerOrderHistory(this);
        }
    }
}
