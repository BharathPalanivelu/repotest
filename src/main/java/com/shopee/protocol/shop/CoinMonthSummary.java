package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinMonthSummary extends Message {
    public static final Long DEFAULT_COIN_AMOUNT = 0L;
    public static final Integer DEFAULT_MONTH = 0;
    public static final Integer DEFAULT_YEAR = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long coin_amount;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer month;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer year;

    public CoinMonthSummary(Integer num, Integer num2, Long l) {
        this.month = num;
        this.year = num2;
        this.coin_amount = l;
    }

    private CoinMonthSummary(Builder builder) {
        this(builder.month, builder.year, builder.coin_amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinMonthSummary)) {
            return false;
        }
        CoinMonthSummary coinMonthSummary = (CoinMonthSummary) obj;
        if (!equals((Object) this.month, (Object) coinMonthSummary.month) || !equals((Object) this.year, (Object) coinMonthSummary.year) || !equals((Object) this.coin_amount, (Object) coinMonthSummary.coin_amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.month;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.year;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.coin_amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinMonthSummary> {
        public Long coin_amount;
        public Integer month;
        public Integer year;

        public Builder() {
        }

        public Builder(CoinMonthSummary coinMonthSummary) {
            super(coinMonthSummary);
            if (coinMonthSummary != null) {
                this.month = coinMonthSummary.month;
                this.year = coinMonthSummary.year;
                this.coin_amount = coinMonthSummary.coin_amount;
            }
        }

        public Builder month(Integer num) {
            this.month = num;
            return this;
        }

        public Builder year(Integer num) {
            this.year = num;
            return this;
        }

        public Builder coin_amount(Long l) {
            this.coin_amount = l;
            return this;
        }

        public CoinMonthSummary build() {
            return new CoinMonthSummary(this);
        }
    }
}
