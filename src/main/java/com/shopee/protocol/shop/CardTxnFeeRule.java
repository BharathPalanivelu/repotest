package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CardTxnFeeRule extends Message {
    public static final Long DEFAULT_CAP = 0L;
    public static final Integer DEFAULT_CHANNEL_ID = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DESC = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_FIXED = 0L;
    public static final Long DEFAULT_MIN_FEE = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_RATE = 0L;
    public static final Integer DEFAULT_ROUNDING_METHOD = 0;
    public static final Integer DEFAULT_RULE_ID = 0;
    public static final Integer DEFAULT_START_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USER_GROUP = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long cap;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer channel_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String desc;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long fixed;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long min_fee;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long rate;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer rounding_method;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer start_time;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer user_group;

    public CardTxnFeeRule(Integer num, Integer num2, Integer num3, Integer num4, String str, Long l, Long l2, Long l3, Integer num5, Integer num6, Integer num7, String str2, Long l4, Integer num8, f fVar, Integer num9) {
        this.rule_id = num;
        this.channel_id = num2;
        this.start_time = num3;
        this.status = num4;
        this.country = str;
        this.cap = l;
        this.rate = l2;
        this.fixed = l3;
        this.rounding_method = num5;
        this.ctime = num6;
        this.mtime = num7;
        this.desc = str2;
        this.min_fee = l4;
        this.type = num8;
        this.extinfo = fVar;
        this.user_group = num9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CardTxnFeeRule(com.shopee.protocol.shop.CardTxnFeeRule.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Integer r2 = r0.rule_id
            java.lang.Integer r3 = r0.channel_id
            java.lang.Integer r4 = r0.start_time
            java.lang.Integer r5 = r0.status
            java.lang.String r6 = r0.country
            java.lang.Long r7 = r0.cap
            java.lang.Long r8 = r0.rate
            java.lang.Long r9 = r0.fixed
            java.lang.Integer r10 = r0.rounding_method
            java.lang.Integer r11 = r0.ctime
            java.lang.Integer r12 = r0.mtime
            java.lang.String r13 = r0.desc
            java.lang.Long r14 = r0.min_fee
            java.lang.Integer r15 = r0.type
            r18 = r1
            e.f r1 = r0.extinfo
            r16 = r1
            java.lang.Integer r1 = r0.user_group
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.CardTxnFeeRule.<init>(com.shopee.protocol.shop.CardTxnFeeRule$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CardTxnFeeRule)) {
            return false;
        }
        CardTxnFeeRule cardTxnFeeRule = (CardTxnFeeRule) obj;
        if (!equals((Object) this.rule_id, (Object) cardTxnFeeRule.rule_id) || !equals((Object) this.channel_id, (Object) cardTxnFeeRule.channel_id) || !equals((Object) this.start_time, (Object) cardTxnFeeRule.start_time) || !equals((Object) this.status, (Object) cardTxnFeeRule.status) || !equals((Object) this.country, (Object) cardTxnFeeRule.country) || !equals((Object) this.cap, (Object) cardTxnFeeRule.cap) || !equals((Object) this.rate, (Object) cardTxnFeeRule.rate) || !equals((Object) this.fixed, (Object) cardTxnFeeRule.fixed) || !equals((Object) this.rounding_method, (Object) cardTxnFeeRule.rounding_method) || !equals((Object) this.ctime, (Object) cardTxnFeeRule.ctime) || !equals((Object) this.mtime, (Object) cardTxnFeeRule.mtime) || !equals((Object) this.desc, (Object) cardTxnFeeRule.desc) || !equals((Object) this.min_fee, (Object) cardTxnFeeRule.min_fee) || !equals((Object) this.type, (Object) cardTxnFeeRule.type) || !equals((Object) this.extinfo, (Object) cardTxnFeeRule.extinfo) || !equals((Object) this.user_group, (Object) cardTxnFeeRule.user_group)) {
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
        Integer num2 = this.channel_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.start_time;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.cap;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.rate;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.fixed;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num5 = this.rounding_method;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.ctime;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.mtime;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str2 = this.desc;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l4 = this.min_fee;
        int hashCode13 = (hashCode12 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num8 = this.type;
        int hashCode14 = (hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode15 = (hashCode14 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num9 = this.user_group;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CardTxnFeeRule> {
        public Long cap;
        public Integer channel_id;
        public String country;
        public Integer ctime;
        public String desc;
        public f extinfo;
        public Long fixed;
        public Long min_fee;
        public Integer mtime;
        public Long rate;
        public Integer rounding_method;
        public Integer rule_id;
        public Integer start_time;
        public Integer status;
        public Integer type;
        public Integer user_group;

        public Builder() {
        }

        public Builder(CardTxnFeeRule cardTxnFeeRule) {
            super(cardTxnFeeRule);
            if (cardTxnFeeRule != null) {
                this.rule_id = cardTxnFeeRule.rule_id;
                this.channel_id = cardTxnFeeRule.channel_id;
                this.start_time = cardTxnFeeRule.start_time;
                this.status = cardTxnFeeRule.status;
                this.country = cardTxnFeeRule.country;
                this.cap = cardTxnFeeRule.cap;
                this.rate = cardTxnFeeRule.rate;
                this.fixed = cardTxnFeeRule.fixed;
                this.rounding_method = cardTxnFeeRule.rounding_method;
                this.ctime = cardTxnFeeRule.ctime;
                this.mtime = cardTxnFeeRule.mtime;
                this.desc = cardTxnFeeRule.desc;
                this.min_fee = cardTxnFeeRule.min_fee;
                this.type = cardTxnFeeRule.type;
                this.extinfo = cardTxnFeeRule.extinfo;
                this.user_group = cardTxnFeeRule.user_group;
            }
        }

        public Builder rule_id(Integer num) {
            this.rule_id = num;
            return this;
        }

        public Builder channel_id(Integer num) {
            this.channel_id = num;
            return this;
        }

        public Builder start_time(Integer num) {
            this.start_time = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder cap(Long l) {
            this.cap = l;
            return this;
        }

        public Builder rate(Long l) {
            this.rate = l;
            return this;
        }

        public Builder fixed(Long l) {
            this.fixed = l;
            return this;
        }

        public Builder rounding_method(Integer num) {
            this.rounding_method = num;
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

        public Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public Builder min_fee(Long l) {
            this.min_fee = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder user_group(Integer num) {
            this.user_group = num;
            return this;
        }

        public CardTxnFeeRule build() {
            return new CardTxnFeeRule(this);
        }
    }
}
