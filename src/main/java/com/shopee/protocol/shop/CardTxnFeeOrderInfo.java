package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CardTxnFeeOrderInfo extends Message {
    public static final Long DEFAULT_CARD_TXN_FEE = 0L;
    public static final Long DEFAULT_CARD_TXN_FEE_SHIPPING_FEE = 0L;
    public static final Long DEFAULT_INITIAL_TXN_FEE = 0L;
    public static final Integer DEFAULT_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long card_txn_fee;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long card_txn_fee_shipping_fee;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long initial_txn_fee;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;

    public CardTxnFeeOrderInfo(Integer num, Long l, Long l2, Long l3) {
        this.rule_id = num;
        this.card_txn_fee = l;
        this.card_txn_fee_shipping_fee = l2;
        this.initial_txn_fee = l3;
    }

    private CardTxnFeeOrderInfo(Builder builder) {
        this(builder.rule_id, builder.card_txn_fee, builder.card_txn_fee_shipping_fee, builder.initial_txn_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardTxnFeeOrderInfo)) {
            return false;
        }
        CardTxnFeeOrderInfo cardTxnFeeOrderInfo = (CardTxnFeeOrderInfo) obj;
        if (!equals((Object) this.rule_id, (Object) cardTxnFeeOrderInfo.rule_id) || !equals((Object) this.card_txn_fee, (Object) cardTxnFeeOrderInfo.card_txn_fee) || !equals((Object) this.card_txn_fee_shipping_fee, (Object) cardTxnFeeOrderInfo.card_txn_fee_shipping_fee) || !equals((Object) this.initial_txn_fee, (Object) cardTxnFeeOrderInfo.initial_txn_fee)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.rule_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.card_txn_fee;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.card_txn_fee_shipping_fee;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.initial_txn_fee;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardTxnFeeOrderInfo> {
        public Long card_txn_fee;
        public Long card_txn_fee_shipping_fee;
        public Long initial_txn_fee;
        public Integer rule_id;

        public Builder() {
        }

        public Builder(CardTxnFeeOrderInfo cardTxnFeeOrderInfo) {
            super(cardTxnFeeOrderInfo);
            if (cardTxnFeeOrderInfo != null) {
                this.rule_id = cardTxnFeeOrderInfo.rule_id;
                this.card_txn_fee = cardTxnFeeOrderInfo.card_txn_fee;
                this.card_txn_fee_shipping_fee = cardTxnFeeOrderInfo.card_txn_fee_shipping_fee;
                this.initial_txn_fee = cardTxnFeeOrderInfo.initial_txn_fee;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder card_txn_fee(Long l) {
            this.card_txn_fee = l;
            return this;
        }

        public Builder card_txn_fee_shipping_fee(Long l) {
            this.card_txn_fee_shipping_fee = l;
            return this;
        }

        public Builder initial_txn_fee(Long l) {
            this.initial_txn_fee = l;
            return this;
        }

        public CardTxnFeeOrderInfo build() {
            return new CardTxnFeeOrderInfo(this);
        }
    }
}
