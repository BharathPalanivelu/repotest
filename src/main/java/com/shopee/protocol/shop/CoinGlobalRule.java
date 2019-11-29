package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CoinGlobalRule extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_DISABLE_CHECK_SHOP = 0;
    public static final Long DEFAULT_EARN_CASH_UNIT = 0L;
    public static final Long DEFAULT_EARN_COIN_UNIT = 0L;
    public static final Long DEFAULT_EARN_MAX_DAILY = 0L;
    public static final Long DEFAULT_EARN_MAX_ORDER_FIX = 0L;
    public static final Long DEFAULT_EARN_MAX_WEEKLY = 0L;
    public static final Long DEFAULT_EARN_ROUNDING_UNIT = 0L;
    public static final Integer DEFAULT_EXPIRY_MONTHS = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Long DEFAULT_SPEND_CASH_UNIT = 0L;
    public static final Long DEFAULT_SPEND_MAX_DAILY = 0L;
    public static final Integer DEFAULT_SPEND_MAX_ORDER_PERCENT = 0;
    public static final Long DEFAULT_SPEND_MAX_WEEKLY = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer disable_check_shop;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long earn_cash_unit;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long earn_coin_unit;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long earn_max_daily;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long earn_max_order_fix;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long earn_max_weekly;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long earn_rounding_unit;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer expiry_months;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long spend_cash_unit;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long spend_max_daily;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer spend_max_order_percent;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long spend_max_weekly;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer status;

    public CoinGlobalRule(Integer num, String str, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, Long l8, Long l9, Integer num2, f fVar, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.rule_id = num;
        this.country = str;
        this.earn_cash_unit = l;
        this.earn_coin_unit = l2;
        this.earn_rounding_unit = l3;
        this.earn_max_daily = l4;
        this.earn_max_weekly = l5;
        this.earn_max_order_fix = l6;
        this.spend_cash_unit = l7;
        this.spend_max_daily = l8;
        this.spend_max_weekly = l9;
        this.spend_max_order_percent = num2;
        this.extinfo = fVar;
        this.ctime = num3;
        this.mtime = num4;
        this.status = num5;
        this.disable_check_shop = num6;
        this.expiry_months = num7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CoinGlobalRule(com.shopee.protocol.shop.CoinGlobalRule.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Integer r2 = r0.rule_id
            java.lang.String r3 = r0.country
            java.lang.Long r4 = r0.earn_cash_unit
            java.lang.Long r5 = r0.earn_coin_unit
            java.lang.Long r6 = r0.earn_rounding_unit
            java.lang.Long r7 = r0.earn_max_daily
            java.lang.Long r8 = r0.earn_max_weekly
            java.lang.Long r9 = r0.earn_max_order_fix
            java.lang.Long r10 = r0.spend_cash_unit
            java.lang.Long r11 = r0.spend_max_daily
            java.lang.Long r12 = r0.spend_max_weekly
            java.lang.Integer r13 = r0.spend_max_order_percent
            e.f r14 = r0.extinfo
            java.lang.Integer r15 = r0.ctime
            r20 = r1
            java.lang.Integer r1 = r0.mtime
            r16 = r1
            java.lang.Integer r1 = r0.status
            r17 = r1
            java.lang.Integer r1 = r0.disable_check_shop
            r18 = r1
            java.lang.Integer r1 = r0.expiry_months
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CoinGlobalRule.<init>(com.shopee.protocol.shop.CoinGlobalRule$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinGlobalRule)) {
            return false;
        }
        CoinGlobalRule coinGlobalRule = (CoinGlobalRule) obj;
        if (!equals((Object) this.rule_id, (Object) coinGlobalRule.rule_id) || !equals((Object) this.country, (Object) coinGlobalRule.country) || !equals((Object) this.earn_cash_unit, (Object) coinGlobalRule.earn_cash_unit) || !equals((Object) this.earn_coin_unit, (Object) coinGlobalRule.earn_coin_unit) || !equals((Object) this.earn_rounding_unit, (Object) coinGlobalRule.earn_rounding_unit) || !equals((Object) this.earn_max_daily, (Object) coinGlobalRule.earn_max_daily) || !equals((Object) this.earn_max_weekly, (Object) coinGlobalRule.earn_max_weekly) || !equals((Object) this.earn_max_order_fix, (Object) coinGlobalRule.earn_max_order_fix) || !equals((Object) this.spend_cash_unit, (Object) coinGlobalRule.spend_cash_unit) || !equals((Object) this.spend_max_daily, (Object) coinGlobalRule.spend_max_daily) || !equals((Object) this.spend_max_weekly, (Object) coinGlobalRule.spend_max_weekly) || !equals((Object) this.spend_max_order_percent, (Object) coinGlobalRule.spend_max_order_percent) || !equals((Object) this.extinfo, (Object) coinGlobalRule.extinfo) || !equals((Object) this.ctime, (Object) coinGlobalRule.ctime) || !equals((Object) this.mtime, (Object) coinGlobalRule.mtime) || !equals((Object) this.status, (Object) coinGlobalRule.status) || !equals((Object) this.disable_check_shop, (Object) coinGlobalRule.disable_check_shop) || !equals((Object) this.expiry_months, (Object) coinGlobalRule.expiry_months)) {
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
        Long l = this.earn_cash_unit;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.earn_coin_unit;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.earn_rounding_unit;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.earn_max_daily;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.earn_max_weekly;
        int hashCode7 = (hashCode6 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.earn_max_order_fix;
        int hashCode8 = (hashCode7 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.spend_cash_unit;
        int hashCode9 = (hashCode8 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.spend_max_daily;
        int hashCode10 = (hashCode9 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.spend_max_weekly;
        int hashCode11 = (hashCode10 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Integer num2 = this.spend_max_order_percent;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode13 = (hashCode12 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode14 = (hashCode13 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode16 = (hashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.disable_check_shop;
        int hashCode17 = (hashCode16 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.expiry_months;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CoinGlobalRule> {
        public String country;
        public Integer ctime;
        public Integer disable_check_shop;
        public Long earn_cash_unit;
        public Long earn_coin_unit;
        public Long earn_max_daily;
        public Long earn_max_order_fix;
        public Long earn_max_weekly;
        public Long earn_rounding_unit;
        public Integer expiry_months;
        public f extinfo;
        public Integer mtime;
        public Integer rule_id;
        public Long spend_cash_unit;
        public Long spend_max_daily;
        public Integer spend_max_order_percent;
        public Long spend_max_weekly;
        public Integer status;

        public Builder() {
        }

        public Builder(CoinGlobalRule coinGlobalRule) {
            super(coinGlobalRule);
            if (coinGlobalRule != null) {
                this.rule_id = coinGlobalRule.rule_id;
                this.country = coinGlobalRule.country;
                this.earn_cash_unit = coinGlobalRule.earn_cash_unit;
                this.earn_coin_unit = coinGlobalRule.earn_coin_unit;
                this.earn_rounding_unit = coinGlobalRule.earn_rounding_unit;
                this.earn_max_daily = coinGlobalRule.earn_max_daily;
                this.earn_max_weekly = coinGlobalRule.earn_max_weekly;
                this.earn_max_order_fix = coinGlobalRule.earn_max_order_fix;
                this.spend_cash_unit = coinGlobalRule.spend_cash_unit;
                this.spend_max_daily = coinGlobalRule.spend_max_daily;
                this.spend_max_weekly = coinGlobalRule.spend_max_weekly;
                this.spend_max_order_percent = coinGlobalRule.spend_max_order_percent;
                this.extinfo = coinGlobalRule.extinfo;
                this.ctime = coinGlobalRule.ctime;
                this.mtime = coinGlobalRule.mtime;
                this.status = coinGlobalRule.status;
                this.disable_check_shop = coinGlobalRule.disable_check_shop;
                this.expiry_months = coinGlobalRule.expiry_months;
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

        public Builder earn_cash_unit(Long l) {
            this.earn_cash_unit = l;
            return this;
        }

        public Builder earn_coin_unit(Long l) {
            this.earn_coin_unit = l;
            return this;
        }

        public Builder earn_rounding_unit(Long l) {
            this.earn_rounding_unit = l;
            return this;
        }

        public Builder earn_max_daily(Long l) {
            this.earn_max_daily = l;
            return this;
        }

        public Builder earn_max_weekly(Long l) {
            this.earn_max_weekly = l;
            return this;
        }

        public Builder earn_max_order_fix(Long l) {
            this.earn_max_order_fix = l;
            return this;
        }

        public Builder spend_cash_unit(Long l) {
            this.spend_cash_unit = l;
            return this;
        }

        public Builder spend_max_daily(Long l) {
            this.spend_max_daily = l;
            return this;
        }

        public Builder spend_max_weekly(Long l) {
            this.spend_max_weekly = l;
            return this;
        }

        public Builder spend_max_order_percent(Integer num) {
            this.spend_max_order_percent = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
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

        public Builder disable_check_shop(Integer num) {
            this.disable_check_shop = num;
            return this;
        }

        public Builder expiry_months(Integer num) {
            this.expiry_months = num;
            return this;
        }

        public CoinGlobalRule build() {
            return new CoinGlobalRule(this);
        }
    }
}
