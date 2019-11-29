package com.shopee.protocol.action;

import com.shopee.protocol.shop.CoinCashbackVoucher;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VoucherResult extends Message {
    public static final Integer DEFAULT_DISCOUNT_PERCENT = 0;
    public static final Long DEFAULT_DISCOUNT_VALUE = 0L;
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Long DEFAULT_MAX_VALUE = 0L;
    public static final Long DEFAULT_MIN_SPEND = 0L;
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final Integer DEFAULT_REWARD_TYPE = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8)
    public final CoinCashbackVoucher coin_cashback_info;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer discount_percent;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long discount_value;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long max_value;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long min_spend;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer reward_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long start_time;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String voucher_code;

    public VoucherResult(String str, Long l, Long l2, Integer num, Long l3, Long l4, Long l5, CoinCashbackVoucher coinCashbackVoucher, Long l6, Integer num2) {
        this.voucher_code = str;
        this.start_time = l;
        this.end_time = l2;
        this.discount_percent = num;
        this.discount_value = l3;
        this.min_spend = l4;
        this.max_value = l5;
        this.coin_cashback_info = coinCashbackVoucher;
        this.promotionid = l6;
        this.reward_type = num2;
    }

    private VoucherResult(Builder builder) {
        this(builder.voucher_code, builder.start_time, builder.end_time, builder.discount_percent, builder.discount_value, builder.min_spend, builder.max_value, builder.coin_cashback_info, builder.promotionid, builder.reward_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VoucherResult)) {
            return false;
        }
        VoucherResult voucherResult = (VoucherResult) obj;
        if (!equals((Object) this.voucher_code, (Object) voucherResult.voucher_code) || !equals((Object) this.start_time, (Object) voucherResult.start_time) || !equals((Object) this.end_time, (Object) voucherResult.end_time) || !equals((Object) this.discount_percent, (Object) voucherResult.discount_percent) || !equals((Object) this.discount_value, (Object) voucherResult.discount_value) || !equals((Object) this.min_spend, (Object) voucherResult.min_spend) || !equals((Object) this.max_value, (Object) voucherResult.max_value) || !equals((Object) this.coin_cashback_info, (Object) voucherResult.coin_cashback_info) || !equals((Object) this.promotionid, (Object) voucherResult.promotionid) || !equals((Object) this.reward_type, (Object) voucherResult.reward_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.voucher_code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.start_time;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.end_time;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.discount_percent;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Long l3 = this.discount_value;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.min_spend;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.max_value;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        CoinCashbackVoucher coinCashbackVoucher = this.coin_cashback_info;
        int hashCode8 = (hashCode7 + (coinCashbackVoucher != null ? coinCashbackVoucher.hashCode() : 0)) * 37;
        Long l6 = this.promotionid;
        int hashCode9 = (hashCode8 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Integer num2 = this.reward_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VoucherResult> {
        public CoinCashbackVoucher coin_cashback_info;
        public Integer discount_percent;
        public Long discount_value;
        public Long end_time;
        public Long max_value;
        public Long min_spend;
        public Long promotionid;
        public Integer reward_type;
        public Long start_time;
        public String voucher_code;

        public Builder() {
        }

        public Builder(VoucherResult voucherResult) {
            super(voucherResult);
            if (voucherResult != null) {
                this.voucher_code = voucherResult.voucher_code;
                this.start_time = voucherResult.start_time;
                this.end_time = voucherResult.end_time;
                this.discount_percent = voucherResult.discount_percent;
                this.discount_value = voucherResult.discount_value;
                this.min_spend = voucherResult.min_spend;
                this.max_value = voucherResult.max_value;
                this.coin_cashback_info = voucherResult.coin_cashback_info;
                this.promotionid = voucherResult.promotionid;
                this.reward_type = voucherResult.reward_type;
            }
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder start_time(Long l) {
            this.start_time = l;
            return this;
        }

        public Builder end_time(Long l) {
            this.end_time = l;
            return this;
        }

        public Builder discount_percent(Integer num) {
            this.discount_percent = num;
            return this;
        }

        public Builder discount_value(Long l) {
            this.discount_value = l;
            return this;
        }

        public Builder min_spend(Long l) {
            this.min_spend = l;
            return this;
        }

        public Builder max_value(Long l) {
            this.max_value = l;
            return this;
        }

        public Builder coin_cashback_info(CoinCashbackVoucher coinCashbackVoucher) {
            this.coin_cashback_info = coinCashbackVoucher;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder reward_type(Integer num) {
            this.reward_type = num;
            return this;
        }

        public VoucherResult build() {
            return new VoucherResult(this);
        }
    }
}
