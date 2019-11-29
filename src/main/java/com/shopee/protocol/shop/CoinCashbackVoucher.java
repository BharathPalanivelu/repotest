package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinCashbackVoucher extends Message {
    public static final Integer DEFAULT_COIN_PERCENTAGE_REAL = 0;
    public static final Long DEFAULT_EARN_CASH_UNIT = 0L;
    public static final Long DEFAULT_EARN_COIN_UNIT = 0L;
    public static final Long DEFAULT_MAX_COIN = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer coin_percentage_real;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long earn_cash_unit;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long earn_coin_unit;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long max_coin;

    public CoinCashbackVoucher(Long l, Long l2, Long l3, Integer num) {
        this.earn_cash_unit = l;
        this.earn_coin_unit = l2;
        this.max_coin = l3;
        this.coin_percentage_real = num;
    }

    private CoinCashbackVoucher(Builder builder) {
        this(builder.earn_cash_unit, builder.earn_coin_unit, builder.max_coin, builder.coin_percentage_real);
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
        if (!equals((Object) this.earn_cash_unit, (Object) coinCashbackVoucher.earn_cash_unit) || !equals((Object) this.earn_coin_unit, (Object) coinCashbackVoucher.earn_coin_unit) || !equals((Object) this.max_coin, (Object) coinCashbackVoucher.max_coin) || !equals((Object) this.coin_percentage_real, (Object) coinCashbackVoucher.coin_percentage_real)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.earn_cash_unit;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.earn_coin_unit;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.max_coin;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.coin_percentage_real;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinCashbackVoucher> {
        public Integer coin_percentage_real;
        public Long earn_cash_unit;
        public Long earn_coin_unit;
        public Long max_coin;

        public Builder() {
        }

        public Builder(CoinCashbackVoucher coinCashbackVoucher) {
            super(coinCashbackVoucher);
            if (coinCashbackVoucher != null) {
                this.earn_cash_unit = coinCashbackVoucher.earn_cash_unit;
                this.earn_coin_unit = coinCashbackVoucher.earn_coin_unit;
                this.max_coin = coinCashbackVoucher.max_coin;
                this.coin_percentage_real = coinCashbackVoucher.coin_percentage_real;
            }
        }

        public Builder earn_cash_unit(Long l) {
            this.earn_cash_unit = l;
            return this;
        }

        public Builder earn_coin_unit(Long l) {
            this.earn_coin_unit = l;
            return this;
        }

        public Builder max_coin(Long l) {
            this.max_coin = l;
            return this;
        }

        public Builder coin_percentage_real(Integer num) {
            this.coin_percentage_real = num;
            return this;
        }

        public CoinCashbackVoucher build() {
            return new CoinCashbackVoucher(this);
        }
    }
}
