package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinCashbackVoucher extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Integer DEFAULT_PERCENTAGE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer percentage;

    public CoinCashbackVoucher(Integer num, Long l) {
        this.percentage = num;
        this.cap = l;
    }

    private CoinCashbackVoucher(Builder builder) {
        this(builder.percentage, builder.cap);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinCashbackVoucher)) {
            return false;
        }
        CoinCashbackVoucher coinCashbackVoucher = (CoinCashbackVoucher) obj;
        if (!equals((Object) this.percentage, (Object) coinCashbackVoucher.percentage) || !equals((Object) this.cap, (Object) coinCashbackVoucher.cap)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.percentage;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.cap;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinCashbackVoucher> {
        public Long cap;
        public Integer percentage;

        public Builder() {
        }

        public Builder(CoinCashbackVoucher coinCashbackVoucher) {
            super(coinCashbackVoucher);
            if (coinCashbackVoucher != null) {
                this.percentage = coinCashbackVoucher.percentage;
                this.cap = coinCashbackVoucher.cap;
            }
        }

        public Builder percentage(Integer num) {
            this.percentage = num;
            return this;
        }

        public Builder cap(Long l) {
            this.cap = l;
            return this;
        }

        public CoinCashbackVoucher build() {
            return new CoinCashbackVoucher(this);
        }
    }
}
