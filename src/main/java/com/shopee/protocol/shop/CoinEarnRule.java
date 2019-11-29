package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CoinEarnRule extends Message {
    public static final Integer DEFAULT_BEGIN_TIME = 0;
    public static final Long DEFAULT_CASH_UNIT = 0L;
    public static final Long DEFAULT_COIN_UNIT = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_END_TIME = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_ROUNDING_UNIT = 0L;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final f DEFAULT_RULE_INFO = f.f32736b;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer begin_time;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long cash_unit;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long coin_unit;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer end_time;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long rounding_unit;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f rule_info;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer status;

    public CoinEarnRule(Integer num, String str, Integer num2, Integer num3, Long l, Long l2, Long l3, f fVar, Integer num4, Integer num5, Integer num6, String str2) {
        this.rule_id = num;
        this.country = str;
        this.begin_time = num2;
        this.end_time = num3;
        this.cash_unit = l;
        this.coin_unit = l2;
        this.rounding_unit = l3;
        this.rule_info = fVar;
        this.mtime = num4;
        this.status = num5;
        this.ctime = num6;
        this.name = str2;
    }

    private CoinEarnRule(Builder builder) {
        this(builder.rule_id, builder.country, builder.begin_time, builder.end_time, builder.cash_unit, builder.coin_unit, builder.rounding_unit, builder.rule_info, builder.mtime, builder.status, builder.ctime, builder.name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinEarnRule)) {
            return false;
        }
        CoinEarnRule coinEarnRule = (CoinEarnRule) obj;
        if (!equals((Object) this.rule_id, (Object) coinEarnRule.rule_id) || !equals((Object) this.country, (Object) coinEarnRule.country) || !equals((Object) this.begin_time, (Object) coinEarnRule.begin_time) || !equals((Object) this.end_time, (Object) coinEarnRule.end_time) || !equals((Object) this.cash_unit, (Object) coinEarnRule.cash_unit) || !equals((Object) this.coin_unit, (Object) coinEarnRule.coin_unit) || !equals((Object) this.rounding_unit, (Object) coinEarnRule.rounding_unit) || !equals((Object) this.rule_info, (Object) coinEarnRule.rule_info) || !equals((Object) this.mtime, (Object) coinEarnRule.mtime) || !equals((Object) this.status, (Object) coinEarnRule.status) || !equals((Object) this.ctime, (Object) coinEarnRule.ctime) || !equals((Object) this.name, (Object) coinEarnRule.name)) {
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
        String str = this.country;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.begin_time;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.end_time;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l = this.cash_unit;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.coin_unit;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.rounding_unit;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        f fVar = this.rule_info;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinEarnRule> {
        public Integer begin_time;
        public Long cash_unit;
        public Long coin_unit;
        public String country;
        public Integer ctime;
        public Integer end_time;
        public Integer mtime;
        public String name;
        public Long rounding_unit;
        public Integer rule_id;
        public f rule_info;
        public Integer status;

        public Builder() {
        }

        public Builder(CoinEarnRule coinEarnRule) {
            super(coinEarnRule);
            if (coinEarnRule != null) {
                this.rule_id = coinEarnRule.rule_id;
                this.country = coinEarnRule.country;
                this.begin_time = coinEarnRule.begin_time;
                this.end_time = coinEarnRule.end_time;
                this.cash_unit = coinEarnRule.cash_unit;
                this.coin_unit = coinEarnRule.coin_unit;
                this.rounding_unit = coinEarnRule.rounding_unit;
                this.rule_info = coinEarnRule.rule_info;
                this.mtime = coinEarnRule.mtime;
                this.status = coinEarnRule.status;
                this.ctime = coinEarnRule.ctime;
                this.name = coinEarnRule.name;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder begin_time(Integer num) {
            this.begin_time = num;
            return this;
        }

        public Builder end_time(Integer num) {
            this.end_time = num;
            return this;
        }

        public Builder cash_unit(Long l) {
            this.cash_unit = l;
            return this;
        }

        public Builder coin_unit(Long l) {
            this.coin_unit = l;
            return this;
        }

        public Builder rounding_unit(Long l) {
            this.rounding_unit = l;
            return this;
        }

        public Builder rule_info(f fVar) {
            this.rule_info = fVar;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public CoinEarnRule build() {
            return new CoinEarnRule(this);
        }
    }
}
