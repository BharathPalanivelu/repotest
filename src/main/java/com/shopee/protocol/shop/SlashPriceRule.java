package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SlashPriceRule extends Message {
    public static final Integer DEFAULT_COUNTDOWN_TIMER_IN_HOUR = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Long DEFAULT_EXISTING_PLAYER_MAX_COIN_REWARD = 0L;
    public static final Integer DEFAULT_EXISTING_PLAYER_MAX_SLASH_OFF = 0;
    public static final Long DEFAULT_EXISTING_PLAYER_MIN_COIN_REWARD = 0L;
    public static final Integer DEFAULT_EXISTING_PLAYER_MIN_SLASH_OFF = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MAX_SLASH_FOR_OTHER = 0;
    public static final Integer DEFAULT_MAX_SLASH_PRICE_ACTIVITY = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_NEW_PLAYER_COIN_REWARD = 0L;
    public static final Integer DEFAULT_NEW_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_PURCHASE_VALIDITY_TIMER_IN_HOUR = 0;
    public static final Integer DEFAULT_RULE_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer countdown_timer_in_hour;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long existing_player_max_coin_reward;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer existing_player_max_slash_off;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long existing_player_min_coin_reward;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer existing_player_min_slash_off;
    @ProtoField(tag = 14, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer max_slash_for_other;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer max_slash_price_activity;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long new_player_coin_reward;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer new_player_max_slash_off;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_player_min_slash_off;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer purchase_validity_timer_in_hour;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer rule_id;

    public SlashPriceRule(Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Long l, Long l2, Long l3, Integer num8, Integer num9, f fVar, Integer num10, Integer num11) {
        this.rule_id = num;
        this.country = str;
        this.max_slash_price_activity = num2;
        this.max_slash_for_other = num3;
        this.new_player_max_slash_off = num4;
        this.new_player_min_slash_off = num5;
        this.existing_player_max_slash_off = num6;
        this.existing_player_min_slash_off = num7;
        this.new_player_coin_reward = l;
        this.existing_player_max_coin_reward = l2;
        this.existing_player_min_coin_reward = l3;
        this.countdown_timer_in_hour = num8;
        this.purchase_validity_timer_in_hour = num9;
        this.extinfo = fVar;
        this.ctime = num10;
        this.mtime = num11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SlashPriceRule(com.shopee.protocol.shop.SlashPriceRule.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Integer r2 = r0.rule_id
            java.lang.String r3 = r0.country
            java.lang.Integer r4 = r0.max_slash_price_activity
            java.lang.Integer r5 = r0.max_slash_for_other
            java.lang.Integer r6 = r0.new_player_max_slash_off
            java.lang.Integer r7 = r0.new_player_min_slash_off
            java.lang.Integer r8 = r0.existing_player_max_slash_off
            java.lang.Integer r9 = r0.existing_player_min_slash_off
            java.lang.Long r10 = r0.new_player_coin_reward
            java.lang.Long r11 = r0.existing_player_max_coin_reward
            java.lang.Long r12 = r0.existing_player_min_coin_reward
            java.lang.Integer r13 = r0.countdown_timer_in_hour
            java.lang.Integer r14 = r0.purchase_validity_timer_in_hour
            e.f r15 = r0.extinfo
            r18 = r1
            java.lang.Integer r1 = r0.ctime
            r16 = r1
            java.lang.Integer r1 = r0.mtime
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.SlashPriceRule.<init>(com.shopee.protocol.shop.SlashPriceRule$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceRule)) {
            return false;
        }
        SlashPriceRule slashPriceRule = (SlashPriceRule) obj;
        if (!equals((Object) this.rule_id, (Object) slashPriceRule.rule_id) || !equals((Object) this.country, (Object) slashPriceRule.country) || !equals((Object) this.max_slash_price_activity, (Object) slashPriceRule.max_slash_price_activity) || !equals((Object) this.max_slash_for_other, (Object) slashPriceRule.max_slash_for_other) || !equals((Object) this.new_player_max_slash_off, (Object) slashPriceRule.new_player_max_slash_off) || !equals((Object) this.new_player_min_slash_off, (Object) slashPriceRule.new_player_min_slash_off) || !equals((Object) this.existing_player_max_slash_off, (Object) slashPriceRule.existing_player_max_slash_off) || !equals((Object) this.existing_player_min_slash_off, (Object) slashPriceRule.existing_player_min_slash_off) || !equals((Object) this.new_player_coin_reward, (Object) slashPriceRule.new_player_coin_reward) || !equals((Object) this.existing_player_max_coin_reward, (Object) slashPriceRule.existing_player_max_coin_reward) || !equals((Object) this.existing_player_min_coin_reward, (Object) slashPriceRule.existing_player_min_coin_reward) || !equals((Object) this.countdown_timer_in_hour, (Object) slashPriceRule.countdown_timer_in_hour) || !equals((Object) this.purchase_validity_timer_in_hour, (Object) slashPriceRule.purchase_validity_timer_in_hour) || !equals((Object) this.extinfo, (Object) slashPriceRule.extinfo) || !equals((Object) this.ctime, (Object) slashPriceRule.ctime) || !equals((Object) this.mtime, (Object) slashPriceRule.mtime)) {
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
        Integer num2 = this.max_slash_price_activity;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.max_slash_for_other;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.new_player_max_slash_off;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.new_player_min_slash_off;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.existing_player_max_slash_off;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.existing_player_min_slash_off;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l = this.new_player_coin_reward;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.existing_player_max_coin_reward;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.existing_player_min_coin_reward;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num8 = this.countdown_timer_in_hour;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.purchase_validity_timer_in_hour;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode14 = (hashCode13 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num10 = this.ctime;
        int hashCode15 = (hashCode14 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.mtime;
        if (num11 != null) {
            i2 = num11.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceRule> {
        public Integer countdown_timer_in_hour;
        public String country;
        public Integer ctime;
        public Long existing_player_max_coin_reward;
        public Integer existing_player_max_slash_off;
        public Long existing_player_min_coin_reward;
        public Integer existing_player_min_slash_off;
        public f extinfo;
        public Integer max_slash_for_other;
        public Integer max_slash_price_activity;
        public Integer mtime;
        public Long new_player_coin_reward;
        public Integer new_player_max_slash_off;
        public Integer new_player_min_slash_off;
        public Integer purchase_validity_timer_in_hour;
        public Integer rule_id;

        public Builder() {
        }

        public Builder(SlashPriceRule slashPriceRule) {
            super(slashPriceRule);
            if (slashPriceRule != null) {
                this.rule_id = slashPriceRule.rule_id;
                this.country = slashPriceRule.country;
                this.max_slash_price_activity = slashPriceRule.max_slash_price_activity;
                this.max_slash_for_other = slashPriceRule.max_slash_for_other;
                this.new_player_max_slash_off = slashPriceRule.new_player_max_slash_off;
                this.new_player_min_slash_off = slashPriceRule.new_player_min_slash_off;
                this.existing_player_max_slash_off = slashPriceRule.existing_player_max_slash_off;
                this.existing_player_min_slash_off = slashPriceRule.existing_player_min_slash_off;
                this.new_player_coin_reward = slashPriceRule.new_player_coin_reward;
                this.existing_player_max_coin_reward = slashPriceRule.existing_player_max_coin_reward;
                this.existing_player_min_coin_reward = slashPriceRule.existing_player_min_coin_reward;
                this.countdown_timer_in_hour = slashPriceRule.countdown_timer_in_hour;
                this.purchase_validity_timer_in_hour = slashPriceRule.purchase_validity_timer_in_hour;
                this.extinfo = slashPriceRule.extinfo;
                this.ctime = slashPriceRule.ctime;
                this.mtime = slashPriceRule.mtime;
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

        public Builder max_slash_price_activity(Integer num) {
            this.max_slash_price_activity = num;
            return this;
        }

        public Builder max_slash_for_other(Integer num) {
            this.max_slash_for_other = num;
            return this;
        }

        public Builder new_player_max_slash_off(Integer num) {
            this.new_player_max_slash_off = num;
            return this;
        }

        public Builder new_player_min_slash_off(Integer num) {
            this.new_player_min_slash_off = num;
            return this;
        }

        public Builder existing_player_max_slash_off(Integer num) {
            this.existing_player_max_slash_off = num;
            return this;
        }

        public Builder existing_player_min_slash_off(Integer num) {
            this.existing_player_min_slash_off = num;
            return this;
        }

        public Builder new_player_coin_reward(Long l) {
            this.new_player_coin_reward = l;
            return this;
        }

        public Builder existing_player_max_coin_reward(Long l) {
            this.existing_player_max_coin_reward = l;
            return this;
        }

        public Builder existing_player_min_coin_reward(Long l) {
            this.existing_player_min_coin_reward = l;
            return this;
        }

        public Builder countdown_timer_in_hour(Integer num) {
            this.countdown_timer_in_hour = num;
            return this;
        }

        public Builder purchase_validity_timer_in_hour(Integer num) {
            this.purchase_validity_timer_in_hour = num;
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

        public SlashPriceRule build() {
            return new SlashPriceRule(this);
        }
    }
}
