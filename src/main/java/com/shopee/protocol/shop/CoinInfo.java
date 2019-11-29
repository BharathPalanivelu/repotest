package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CoinInfo extends Message {
    public static final Long DEFAULT_COIN_EARN = 0L;
    public static final Long DEFAULT_COIN_EARN_BEFORE_RETURN = 0L;
    public static final Long DEFAULT_COIN_EARN_BY_VOUCHER = 0L;
    public static final Long DEFAULT_COIN_EARN_CASH_BY_VOUCHER = 0L;
    public static final Long DEFAULT_COIN_OFFSET = 0L;
    public static final Integer DEFAULT_COIN_SPEND_RULE_ID = 0;
    public static final Long DEFAULT_COIN_USED = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long coin_earn;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long coin_earn_before_return;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long coin_earn_by_voucher;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long coin_earn_cash_by_voucher;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long coin_offset;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer coin_spend_rule_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long coin_used;

    public CoinInfo(Long l, Long l2, Integer num, Long l3, Long l4, Long l5, Long l6) {
        this.coin_used = l;
        this.coin_offset = l2;
        this.coin_spend_rule_id = num;
        this.coin_earn = l3;
        this.coin_earn_before_return = l4;
        this.coin_earn_by_voucher = l5;
        this.coin_earn_cash_by_voucher = l6;
    }

    private CoinInfo(Builder builder) {
        this(builder.coin_used, builder.coin_offset, builder.coin_spend_rule_id, builder.coin_earn, builder.coin_earn_before_return, builder.coin_earn_by_voucher, builder.coin_earn_cash_by_voucher);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinInfo)) {
            return false;
        }
        CoinInfo coinInfo = (CoinInfo) obj;
        if (!equals((Object) this.coin_used, (Object) coinInfo.coin_used) || !equals((Object) this.coin_offset, (Object) coinInfo.coin_offset) || !equals((Object) this.coin_spend_rule_id, (Object) coinInfo.coin_spend_rule_id) || !equals((Object) this.coin_earn, (Object) coinInfo.coin_earn) || !equals((Object) this.coin_earn_before_return, (Object) coinInfo.coin_earn_before_return) || !equals((Object) this.coin_earn_by_voucher, (Object) coinInfo.coin_earn_by_voucher) || !equals((Object) this.coin_earn_cash_by_voucher, (Object) coinInfo.coin_earn_cash_by_voucher)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.coin_used;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.coin_offset;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.coin_spend_rule_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.coin_earn;
        int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.coin_earn_before_return;
        int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.coin_earn_by_voucher;
        int hashCode6 = (hashCode5 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.coin_earn_cash_by_voucher;
        if (l6 != null) {
            i2 = l6.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinInfo> {
        public Long coin_earn;
        public Long coin_earn_before_return;
        public Long coin_earn_by_voucher;
        public Long coin_earn_cash_by_voucher;
        public Long coin_offset;
        public Integer coin_spend_rule_id;
        public Long coin_used;

        public Builder() {
        }

        public Builder(CoinInfo coinInfo) {
            super(coinInfo);
            if (coinInfo != null) {
                this.coin_used = coinInfo.coin_used;
                this.coin_offset = coinInfo.coin_offset;
                this.coin_spend_rule_id = coinInfo.coin_spend_rule_id;
                this.coin_earn = coinInfo.coin_earn;
                this.coin_earn_before_return = coinInfo.coin_earn_before_return;
                this.coin_earn_by_voucher = coinInfo.coin_earn_by_voucher;
                this.coin_earn_cash_by_voucher = coinInfo.coin_earn_cash_by_voucher;
            }
        }

        public Builder coin_used(Long l) {
            this.coin_used = l;
            return this;
        }

        public Builder coin_offset(Long l) {
            this.coin_offset = l;
            return this;
        }

        public Builder coin_spend_rule_id(Integer num) {
            this.coin_spend_rule_id = num;
            return this;
        }

        public Builder coin_earn(Long l) {
            this.coin_earn = l;
            return this;
        }

        public Builder coin_earn_before_return(Long l) {
            this.coin_earn_before_return = l;
            return this;
        }

        public Builder coin_earn_by_voucher(Long l) {
            this.coin_earn_by_voucher = l;
            return this;
        }

        public Builder coin_earn_cash_by_voucher(Long l) {
            this.coin_earn_cash_by_voucher = l;
            return this;
        }

        public CoinInfo build() {
            return new CoinInfo(this);
        }
    }
}
