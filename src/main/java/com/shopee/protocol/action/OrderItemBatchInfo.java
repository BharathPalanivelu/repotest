package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OrderItemBatchInfo extends Message {
    public static final Long DEFAULT_ADMIN_FEE = 0L;
    public static final Long DEFAULT_BUYER_TXN_FEE = 0L;
    public static final Long DEFAULT_CARD_PROMOTION_DISCOUNT_BANK = 0L;
    public static final Long DEFAULT_CARD_PROMOTION_DISCOUNT_SHOPEE = 0L;
    public static final Long DEFAULT_COGS = 0L;
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final Long DEFAULT_COIN_OFFSET = 0L;
    public static final Long DEFAULT_COIN_USED = 0L;
    public static final Long DEFAULT_MERCHANDISE_SUBTOTAL = 0L;
    public static final Long DEFAULT_TOTAL_PRICE_EXCLUDE_SHIPPING = 0L;
    public static final Long DEFAULT_VOUCHER_DISCOUNT = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long admin_fee;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long buyer_txn_fee;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long card_promotion_discount_bank;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long card_promotion_discount_shopee;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long cogs;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long coin_offset;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long coin_used;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long merchandise_subtotal;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long total_price_exclude_shipping;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long voucher_discount;

    public OrderItemBatchInfo(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Long l10, Long l11) {
        this.total_price_exclude_shipping = l;
        this.cogs = l2;
        this.voucher_discount = l3;
        this.coin_offset = l4;
        this.coin_used = l5;
        this.coin_earn = l6;
        this.card_promotion_discount_bank = l7;
        this.card_promotion_discount_shopee = l8;
        this.buyer_txn_fee = l9;
        this.admin_fee = l10;
        this.merchandise_subtotal = l11;
    }

    private OrderItemBatchInfo(Builder builder) {
        this(builder.total_price_exclude_shipping, builder.cogs, builder.voucher_discount, builder.coin_offset, builder.coin_used, builder.coin_earn, builder.card_promotion_discount_bank, builder.card_promotion_discount_shopee, builder.buyer_txn_fee, builder.admin_fee, builder.merchandise_subtotal);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemBatchInfo)) {
            return false;
        }
        OrderItemBatchInfo orderItemBatchInfo = (OrderItemBatchInfo) obj;
        if (!equals((Object) this.total_price_exclude_shipping, (Object) orderItemBatchInfo.total_price_exclude_shipping) || !equals((Object) this.cogs, (Object) orderItemBatchInfo.cogs) || !equals((Object) this.voucher_discount, (Object) orderItemBatchInfo.voucher_discount) || !equals((Object) this.coin_offset, (Object) orderItemBatchInfo.coin_offset) || !equals((Object) this.coin_used, (Object) orderItemBatchInfo.coin_used) || !equals((Object) this.coin_earn, (Object) orderItemBatchInfo.coin_earn) || !equals((Object) this.card_promotion_discount_bank, (Object) orderItemBatchInfo.card_promotion_discount_bank) || !equals((Object) this.card_promotion_discount_shopee, (Object) orderItemBatchInfo.card_promotion_discount_shopee) || !equals((Object) this.buyer_txn_fee, (Object) orderItemBatchInfo.buyer_txn_fee) || !equals((Object) this.admin_fee, (Object) orderItemBatchInfo.admin_fee) || !equals((Object) this.merchandise_subtotal, (Object) orderItemBatchInfo.merchandise_subtotal)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.total_price_exclude_shipping;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.cogs;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.voucher_discount;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.coin_offset;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.coin_used;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.coin_earn;
        int hashCode6 = (hashCode5 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.card_promotion_discount_bank;
        int hashCode7 = (hashCode6 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.card_promotion_discount_shopee;
        int hashCode8 = (hashCode7 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.buyer_txn_fee;
        int hashCode9 = (hashCode8 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.admin_fee;
        int hashCode10 = (hashCode9 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.merchandise_subtotal;
        if (l11 != null) {
            i2 = l11.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OrderItemBatchInfo> {
        public Long admin_fee;
        public Long buyer_txn_fee;
        public Long card_promotion_discount_bank;
        public Long card_promotion_discount_shopee;
        public Long cogs;
        public Long coin_earn;
        public Long coin_offset;
        public Long coin_used;
        public Long merchandise_subtotal;
        public Long total_price_exclude_shipping;
        public Long voucher_discount;

        public Builder() {
        }

        public Builder(OrderItemBatchInfo orderItemBatchInfo) {
            super(orderItemBatchInfo);
            if (orderItemBatchInfo != null) {
                this.total_price_exclude_shipping = orderItemBatchInfo.total_price_exclude_shipping;
                this.cogs = orderItemBatchInfo.cogs;
                this.voucher_discount = orderItemBatchInfo.voucher_discount;
                this.coin_offset = orderItemBatchInfo.coin_offset;
                this.coin_used = orderItemBatchInfo.coin_used;
                this.coin_earn = orderItemBatchInfo.coin_earn;
                this.card_promotion_discount_bank = orderItemBatchInfo.card_promotion_discount_bank;
                this.card_promotion_discount_shopee = orderItemBatchInfo.card_promotion_discount_shopee;
                this.buyer_txn_fee = orderItemBatchInfo.buyer_txn_fee;
                this.admin_fee = orderItemBatchInfo.admin_fee;
                this.merchandise_subtotal = orderItemBatchInfo.merchandise_subtotal;
            }
        }

        public Builder total_price_exclude_shipping(Long l) {
            this.total_price_exclude_shipping = l;
            return this;
        }

        public Builder cogs(Long l) {
            this.cogs = l;
            return this;
        }

        public Builder voucher_discount(Long l) {
            this.voucher_discount = l;
            return this;
        }

        public Builder coin_offset(Long l) {
            this.coin_offset = l;
            return this;
        }

        public Builder coin_used(Long l) {
            this.coin_used = l;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public Builder card_promotion_discount_bank(Long l) {
            this.card_promotion_discount_bank = l;
            return this;
        }

        public Builder card_promotion_discount_shopee(Long l) {
            this.card_promotion_discount_shopee = l;
            return this;
        }

        public Builder buyer_txn_fee(Long l) {
            this.buyer_txn_fee = l;
            return this;
        }

        public Builder admin_fee(Long l) {
            this.admin_fee = l;
            return this;
        }

        public Builder merchandise_subtotal(Long l) {
            this.merchandise_subtotal = l;
            return this;
        }

        public OrderItemBatchInfo build() {
            return new OrderItemBatchInfo(this);
        }
    }
}
