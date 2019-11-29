package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SlashPriceRuleExtInfo extends Message {
    public static final Integer DEFAULT_DUPLICATE_PERIOD_IN_DAY = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_DUPLICATE_PLAYER_MIN_SLASH_OFF = 0;
    public static final List<Long> DEFAULT_ITEMIDS = Collections.emptyList();
    public static final Integer DEFAULT_MAX_START_ACTIVITY_BY_DEVICE = 0;
    public static final Integer DEFAULT_SELF_MAX_SLASH_OFF = 0;
    public static final Integer DEFAULT_SELF_MIN_SLASH_OFF = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer duplicate_period_in_day;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer duplicate_player_max_slash_off;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer duplicate_player_min_slash_off;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT64)
    public final List<Long> itemids;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer max_start_activity_by_device;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer self_max_slash_off;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer self_min_slash_off;

    public SlashPriceRuleExtInfo(List<Long> list, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.itemids = immutableCopyOf(list);
        this.max_start_activity_by_device = num;
        this.self_max_slash_off = num2;
        this.self_min_slash_off = num3;
        this.duplicate_player_max_slash_off = num4;
        this.duplicate_player_min_slash_off = num5;
        this.duplicate_period_in_day = num6;
    }

    private SlashPriceRuleExtInfo(Builder builder) {
        this(builder.itemids, builder.max_start_activity_by_device, builder.self_max_slash_off, builder.self_min_slash_off, builder.duplicate_player_max_slash_off, builder.duplicate_player_min_slash_off, builder.duplicate_period_in_day);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlashPriceRuleExtInfo)) {
            return false;
        }
        SlashPriceRuleExtInfo slashPriceRuleExtInfo = (SlashPriceRuleExtInfo) obj;
        if (!equals((List<?>) this.itemids, (List<?>) slashPriceRuleExtInfo.itemids) || !equals((Object) this.max_start_activity_by_device, (Object) slashPriceRuleExtInfo.max_start_activity_by_device) || !equals((Object) this.self_max_slash_off, (Object) slashPriceRuleExtInfo.self_max_slash_off) || !equals((Object) this.self_min_slash_off, (Object) slashPriceRuleExtInfo.self_min_slash_off) || !equals((Object) this.duplicate_player_max_slash_off, (Object) slashPriceRuleExtInfo.duplicate_player_max_slash_off) || !equals((Object) this.duplicate_player_min_slash_off, (Object) slashPriceRuleExtInfo.duplicate_player_min_slash_off) || !equals((Object) this.duplicate_period_in_day, (Object) slashPriceRuleExtInfo.duplicate_period_in_day)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Long> list = this.itemids;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        Integer num = this.max_start_activity_by_device;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.self_max_slash_off;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.self_min_slash_off;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.duplicate_player_max_slash_off;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.duplicate_player_min_slash_off;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.duplicate_period_in_day;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SlashPriceRuleExtInfo> {
        public Integer duplicate_period_in_day;
        public Integer duplicate_player_max_slash_off;
        public Integer duplicate_player_min_slash_off;
        public List<Long> itemids;
        public Integer max_start_activity_by_device;
        public Integer self_max_slash_off;
        public Integer self_min_slash_off;

        public Builder() {
        }

        public Builder(SlashPriceRuleExtInfo slashPriceRuleExtInfo) {
            super(slashPriceRuleExtInfo);
            if (slashPriceRuleExtInfo != null) {
                this.itemids = SlashPriceRuleExtInfo.copyOf(slashPriceRuleExtInfo.itemids);
                this.max_start_activity_by_device = slashPriceRuleExtInfo.max_start_activity_by_device;
                this.self_max_slash_off = slashPriceRuleExtInfo.self_max_slash_off;
                this.self_min_slash_off = slashPriceRuleExtInfo.self_min_slash_off;
                this.duplicate_player_max_slash_off = slashPriceRuleExtInfo.duplicate_player_max_slash_off;
                this.duplicate_player_min_slash_off = slashPriceRuleExtInfo.duplicate_player_min_slash_off;
                this.duplicate_period_in_day = slashPriceRuleExtInfo.duplicate_period_in_day;
            }
        }

        public Builder itemids(List<Long> list) {
            this.itemids = checkForNulls(list);
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

        public SlashPriceRuleExtInfo build() {
            return new SlashPriceRuleExtInfo(this);
        }
    }
}
