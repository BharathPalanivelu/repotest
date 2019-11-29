package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetSlashPriceRule extends Message {
    public static final Integer DEFAULT_COUNTDOWN_TIMER_IN_HOUR = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_DUPLICATE_PERIOD_IN_DAY = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MIN_SLASH_OFF = 0;
    public static final Long DEFAULT_EXISTING_PLAYER_MAX_COIN_REWARD = 0L;
    public static final Integer DEFAULT_EXISTING_PLAYER_MAX_SLASH_OFF = 0;
    public static final Long DEFAULT_EXISTING_PLAYER_MIN_COIN_REWARD = 0L;
    public static final Integer DEFAULT_EXISTING_PLAYER_MIN_SLASH_OFF = 0;
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final Integer DEFAULT_MAX_SLASH_FOR_OTHER = 0;
    public static final Integer DEFAULT_MAX_SLASH_PRICE_ACTIVITY = 0;
    public static final Integer DEFAULT_MAX_START_ACTIVITY_BY_DEVICE = 0;
    public static final Long DEFAULT_NEW_PLAYER_COIN_REWARD = 0L;
    public static final Integer DEFAULT_NEW_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_NEW_PLAYER_MIN_SLASH_OFF = 0;
    public static final Integer DEFAULT_PURCHASE_VALIDITY_TIMER_IN_HOUR = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SELF_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MIN_SLASH_OFF = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 15)
    public final BackendParam bparam;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer countdown_timer_in_hour;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer duplicate_period_in_day;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer duplicate_player_max_slash_off;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer duplicate_player_min_slash_off;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long existing_player_max_coin_reward;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer existing_player_max_slash_off;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long existing_player_min_coin_reward;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer existing_player_min_slash_off;
    @ProtoField(label = Message.Label.REPEATED, tag = 14, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer max_slash_for_other;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer max_slash_price_activity;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer max_start_activity_by_device;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long new_player_coin_reward;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer new_player_max_slash_off;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer new_player_min_slash_off;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer purchase_validity_timer_in_hour;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer self_max_slash_off;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer self_min_slash_off;

    public SetSlashPriceRule(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l, Long l2, Long l3, Integer num7, Integer num8, List<Long> list, BackendParam backendParam, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14) {
        this.requestid = str;
        this.country = str2;
        this.max_slash_price_activity = num;
        this.max_slash_for_other = num2;
        this.new_player_max_slash_off = num3;
        this.new_player_min_slash_off = num4;
        this.existing_player_max_slash_off = num5;
        this.existing_player_min_slash_off = num6;
        this.new_player_coin_reward = l;
        this.existing_player_max_coin_reward = l2;
        this.existing_player_min_coin_reward = l3;
        this.countdown_timer_in_hour = num7;
        this.purchase_validity_timer_in_hour = num8;
        this.itemids = immutableCopyOf(list);
        this.bparam = backendParam;
        this.max_start_activity_by_device = num9;
        this.self_max_slash_off = num10;
        this.self_min_slash_off = num11;
        this.duplicate_player_max_slash_off = num12;
        this.duplicate_player_min_slash_off = num13;
        this.duplicate_period_in_day = num14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private SetSlashPriceRule(com.shopee.protocol.action.SetSlashPriceRule.Builder r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            java.lang.String r2 = r0.requestid
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
            java.util.List<java.lang.Long> r15 = r0.itemids
            r23 = r1
            com.shopee.protocol.action.BackendParam r1 = r0.bparam
            r16 = r1
            java.lang.Integer r1 = r0.max_start_activity_by_device
            r17 = r1
            java.lang.Integer r1 = r0.self_max_slash_off
            r18 = r1
            java.lang.Integer r1 = r0.self_min_slash_off
            r19 = r1
            java.lang.Integer r1 = r0.duplicate_player_max_slash_off
            r20 = r1
            java.lang.Integer r1 = r0.duplicate_player_min_slash_off
            r21 = r1
            java.lang.Integer r1 = r0.duplicate_period_in_day
            r22 = r1
            r1 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r24.setBuilder(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.SetSlashPriceRule.<init>(com.shopee.protocol.action.SetSlashPriceRule$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSlashPriceRule)) {
            return false;
        }
        SetSlashPriceRule setSlashPriceRule = (SetSlashPriceRule) obj;
        if (!equals((Object) this.requestid, (Object) setSlashPriceRule.requestid) || !equals((Object) this.country, (Object) setSlashPriceRule.country) || !equals((Object) this.max_slash_price_activity, (Object) setSlashPriceRule.max_slash_price_activity) || !equals((Object) this.max_slash_for_other, (Object) setSlashPriceRule.max_slash_for_other) || !equals((Object) this.new_player_max_slash_off, (Object) setSlashPriceRule.new_player_max_slash_off) || !equals((Object) this.new_player_min_slash_off, (Object) setSlashPriceRule.new_player_min_slash_off) || !equals((Object) this.existing_player_max_slash_off, (Object) setSlashPriceRule.existing_player_max_slash_off) || !equals((Object) this.existing_player_min_slash_off, (Object) setSlashPriceRule.existing_player_min_slash_off) || !equals((Object) this.new_player_coin_reward, (Object) setSlashPriceRule.new_player_coin_reward) || !equals((Object) this.existing_player_max_coin_reward, (Object) setSlashPriceRule.existing_player_max_coin_reward) || !equals((Object) this.existing_player_min_coin_reward, (Object) setSlashPriceRule.existing_player_min_coin_reward) || !equals((Object) this.countdown_timer_in_hour, (Object) setSlashPriceRule.countdown_timer_in_hour) || !equals((Object) this.purchase_validity_timer_in_hour, (Object) setSlashPriceRule.purchase_validity_timer_in_hour) || !equals((List<?>) this.itemids, (List<?>) setSlashPriceRule.itemids) || !equals((Object) this.bparam, (Object) setSlashPriceRule.bparam) || !equals((Object) this.max_start_activity_by_device, (Object) setSlashPriceRule.max_start_activity_by_device) || !equals((Object) this.self_max_slash_off, (Object) setSlashPriceRule.self_max_slash_off) || !equals((Object) this.self_min_slash_off, (Object) setSlashPriceRule.self_min_slash_off) || !equals((Object) this.duplicate_player_max_slash_off, (Object) setSlashPriceRule.duplicate_player_max_slash_off) || !equals((Object) this.duplicate_player_min_slash_off, (Object) setSlashPriceRule.duplicate_player_min_slash_off) || !equals((Object) this.duplicate_period_in_day, (Object) setSlashPriceRule.duplicate_period_in_day)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.max_slash_price_activity;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.max_slash_for_other;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.new_player_max_slash_off;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.new_player_min_slash_off;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.existing_player_max_slash_off;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.existing_player_min_slash_off;
        int hashCode8 = (hashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l = this.new_player_coin_reward;
        int hashCode9 = (hashCode8 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.existing_player_max_coin_reward;
        int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.existing_player_min_coin_reward;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num7 = this.countdown_timer_in_hour;
        int hashCode12 = (hashCode11 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.purchase_validity_timer_in_hour;
        int hashCode13 = (hashCode12 + (num8 != null ? num8.hashCode() : 0)) * 37;
        List<Long> list = this.itemids;
        int hashCode14 = (hashCode13 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode15 = (hashCode14 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num9 = this.max_start_activity_by_device;
        int hashCode16 = (hashCode15 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.self_max_slash_off;
        int hashCode17 = (hashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.self_min_slash_off;
        int hashCode18 = (hashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.duplicate_player_max_slash_off;
        int hashCode19 = (hashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.duplicate_player_min_slash_off;
        int hashCode20 = (hashCode19 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.duplicate_period_in_day;
        if (num14 != null) {
            i2 = num14.hashCode();
        }
        int i3 = hashCode20 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetSlashPriceRule> {
        public BackendParam bparam;
        public Integer countdown_timer_in_hour;
        public String country;
        public Integer duplicate_period_in_day;
        public Integer duplicate_player_max_slash_off;
        public Integer duplicate_player_min_slash_off;
        public Long existing_player_max_coin_reward;
        public Integer existing_player_max_slash_off;
        public Long existing_player_min_coin_reward;
        public Integer existing_player_min_slash_off;
        public List<Long> itemids;
        public Integer max_slash_for_other;
        public Integer max_slash_price_activity;
        public Integer max_start_activity_by_device;
        public Long new_player_coin_reward;
        public Integer new_player_max_slash_off;
        public Integer new_player_min_slash_off;
        public Integer purchase_validity_timer_in_hour;
        public String requestid;
        public Integer self_max_slash_off;
        public Integer self_min_slash_off;

        public Builder() {
        }

        public Builder(SetSlashPriceRule setSlashPriceRule) {
            super(setSlashPriceRule);
            if (setSlashPriceRule != null) {
                this.requestid = setSlashPriceRule.requestid;
                this.country = setSlashPriceRule.country;
                this.max_slash_price_activity = setSlashPriceRule.max_slash_price_activity;
                this.max_slash_for_other = setSlashPriceRule.max_slash_for_other;
                this.new_player_max_slash_off = setSlashPriceRule.new_player_max_slash_off;
                this.new_player_min_slash_off = setSlashPriceRule.new_player_min_slash_off;
                this.existing_player_max_slash_off = setSlashPriceRule.existing_player_max_slash_off;
                this.existing_player_min_slash_off = setSlashPriceRule.existing_player_min_slash_off;
                this.new_player_coin_reward = setSlashPriceRule.new_player_coin_reward;
                this.existing_player_max_coin_reward = setSlashPriceRule.existing_player_max_coin_reward;
                this.existing_player_min_coin_reward = setSlashPriceRule.existing_player_min_coin_reward;
                this.countdown_timer_in_hour = setSlashPriceRule.countdown_timer_in_hour;
                this.purchase_validity_timer_in_hour = setSlashPriceRule.purchase_validity_timer_in_hour;
                this.itemids = SetSlashPriceRule.copyOf(setSlashPriceRule.itemids);
                this.bparam = setSlashPriceRule.bparam;
                this.max_start_activity_by_device = setSlashPriceRule.max_start_activity_by_device;
                this.self_max_slash_off = setSlashPriceRule.self_max_slash_off;
                this.self_min_slash_off = setSlashPriceRule.self_min_slash_off;
                this.duplicate_player_max_slash_off = setSlashPriceRule.duplicate_player_max_slash_off;
                this.duplicate_player_min_slash_off = setSlashPriceRule.duplicate_player_min_slash_off;
                this.duplicate_period_in_day = setSlashPriceRule.duplicate_period_in_day;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder max_start_activity_by_device(Integer num) {
            this.max_start_activity_by_device = num;
            return this;
        }

        public Builder self_max_slash_off(Integer num) {
            this.self_max_slash_off = num;
            return this;
        }

        public Builder self_min_slash_off(Integer num) {
            this.self_min_slash_off = num;
            return this;
        }

        public Builder duplicate_player_max_slash_off(Integer num) {
            this.duplicate_player_max_slash_off = num;
            return this;
        }

        public Builder duplicate_player_min_slash_off(Integer num) {
            this.duplicate_player_min_slash_off = num;
            return this;
        }

        public Builder duplicate_period_in_day(Integer num) {
            this.duplicate_period_in_day = num;
            return this;
        }

        public SetSlashPriceRule build() {
            return new SetSlashPriceRule(this);
        }
    }
}
