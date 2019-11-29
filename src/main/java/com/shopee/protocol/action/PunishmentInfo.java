package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PunishmentInfo extends Message {
    public static final Long DEFAULT_END_TIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_PENALTY_TIER = 0;
    public static final Integer DEFAULT_PUNISHMENT_TYPE = 0;
    public static final Long DEFAULT_START_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long end_time;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer penalty_tier;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer punishment_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long start_time;

    public PunishmentInfo(Long l, Integer num, Integer num2, Long l2, Long l3) {
        this.id = l;
        this.punishment_type = num;
        this.penalty_tier = num2;
        this.start_time = l2;
        this.end_time = l3;
    }

    private PunishmentInfo(Builder builder) {
        this(builder.id, builder.punishment_type, builder.penalty_tier, builder.start_time, builder.end_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PunishmentInfo)) {
            return false;
        }
        PunishmentInfo punishmentInfo = (PunishmentInfo) obj;
        if (!equals((Object) this.id, (Object) punishmentInfo.id) || !equals((Object) this.punishment_type, (Object) punishmentInfo.punishment_type) || !equals((Object) this.penalty_tier, (Object) punishmentInfo.penalty_tier) || !equals((Object) this.start_time, (Object) punishmentInfo.start_time) || !equals((Object) this.end_time, (Object) punishmentInfo.end_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.punishment_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.penalty_tier;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.start_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.end_time;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PunishmentInfo> {
        public Long end_time;
        public Long id;
        public Integer penalty_tier;
        public Integer punishment_type;
        public Long start_time;

        public Builder() {
        }

        public Builder(PunishmentInfo punishmentInfo) {
            super(punishmentInfo);
            if (punishmentInfo != null) {
                this.id = punishmentInfo.id;
                this.punishment_type = punishmentInfo.punishment_type;
                this.penalty_tier = punishmentInfo.penalty_tier;
                this.start_time = punishmentInfo.start_time;
                this.end_time = punishmentInfo.end_time;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder punishment_type(Integer num) {
            this.punishment_type = num;
            return this;
        }

        public Builder penalty_tier(Integer num) {
            this.penalty_tier = num;
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

        public PunishmentInfo build() {
            return new PunishmentInfo(this);
        }
    }
}
