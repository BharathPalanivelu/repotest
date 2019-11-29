package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TxnFeeCheckoutInfo extends Message {
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Long DEFAULT_TXN_FEE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long txn_fee;

    public TxnFeeCheckoutInfo(Integer num, Long l) {
        this.rule_id = num;
        this.txn_fee = l;
    }

    private TxnFeeCheckoutInfo(Builder builder) {
        this(builder.rule_id, builder.txn_fee);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TxnFeeCheckoutInfo)) {
            return false;
        }
        TxnFeeCheckoutInfo txnFeeCheckoutInfo = (TxnFeeCheckoutInfo) obj;
        if (!equals((Object) this.rule_id, (Object) txnFeeCheckoutInfo.rule_id) || !equals((Object) this.txn_fee, (Object) txnFeeCheckoutInfo.txn_fee)) {
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
        Long l = this.txn_fee;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TxnFeeCheckoutInfo> {
        public Integer rule_id;
        public Long txn_fee;

        public Builder() {
        }

        public Builder(TxnFeeCheckoutInfo txnFeeCheckoutInfo) {
            super(txnFeeCheckoutInfo);
            if (txnFeeCheckoutInfo != null) {
                this.rule_id = txnFeeCheckoutInfo.rule_id;
                this.txn_fee = txnFeeCheckoutInfo.txn_fee;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder txn_fee(Long l) {
            this.txn_fee = l;
            return this;
        }

        public TxnFeeCheckoutInfo build() {
            return new TxnFeeCheckoutInfo(this);
        }
    }
}
