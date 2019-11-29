package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PreparationTime extends Message {
    public static final Long DEFAULT_AVERAGE_TIME = 0L;
    public static final Long DEFAULT_COUNT = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_TOTAL_TIME = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long average_time;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long count;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long total_time;

    public PreparationTime(Long l, Long l2, Long l3, Long l4) {
        this.total_time = l;
        this.count = l2;
        this.mtime = l3;
        this.average_time = l4;
    }

    private PreparationTime(Builder builder) {
        this(builder.total_time, builder.count, builder.mtime, builder.average_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PreparationTime)) {
            return false;
        }
        PreparationTime preparationTime = (PreparationTime) obj;
        if (!equals((Object) this.total_time, (Object) preparationTime.total_time) || !equals((Object) this.count, (Object) preparationTime.count) || !equals((Object) this.mtime, (Object) preparationTime.mtime) || !equals((Object) this.average_time, (Object) preparationTime.average_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.total_time;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.count;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.average_time;
        if (l4 != null) {
            i2 = l4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PreparationTime> {
        public Long average_time;
        public Long count;
        public Long mtime;
        public Long total_time;

        public Builder() {
        }

        public Builder(PreparationTime preparationTime) {
            super(preparationTime);
            if (preparationTime != null) {
                this.total_time = preparationTime.total_time;
                this.count = preparationTime.count;
                this.mtime = preparationTime.mtime;
                this.average_time = preparationTime.average_time;
            }
        }

        public Builder total_time(Long l) {
            this.total_time = l;
            return this;
        }

        public Builder count(Long l) {
            this.count = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder average_time(Long l) {
            this.average_time = l;
            return this;
        }

        public PreparationTime build() {
            return new PreparationTime(this);
        }
    }
}
