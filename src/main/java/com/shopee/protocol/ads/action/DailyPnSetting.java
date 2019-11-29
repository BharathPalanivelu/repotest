package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DailyPnSetting extends Message {
    public static final Long DEFAULT_BALANCE = 0L;
    public static final Boolean DEFAULT_IS_OFF = false;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long balance;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean is_off;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long timestamp;

    public DailyPnSetting(Boolean bool, Long l, Long l2) {
        this.is_off = bool;
        this.timestamp = l;
        this.balance = l2;
    }

    private DailyPnSetting(Builder builder) {
        this(builder.is_off, builder.timestamp, builder.balance);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DailyPnSetting)) {
            return false;
        }
        DailyPnSetting dailyPnSetting = (DailyPnSetting) obj;
        if (!equals((Object) this.is_off, (Object) dailyPnSetting.is_off) || !equals((Object) this.timestamp, (Object) dailyPnSetting.timestamp) || !equals((Object) this.balance, (Object) dailyPnSetting.balance)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.is_off;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Long l = this.timestamp;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.balance;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DailyPnSetting> {
        public Long balance;
        public Boolean is_off;
        public Long timestamp;

        public Builder() {
        }

        public Builder(DailyPnSetting dailyPnSetting) {
            super(dailyPnSetting);
            if (dailyPnSetting != null) {
                this.is_off = dailyPnSetting.is_off;
                this.timestamp = dailyPnSetting.timestamp;
                this.balance = dailyPnSetting.balance;
            }
        }

        public Builder is_off(Boolean bool) {
            this.is_off = bool;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder balance(Long l) {
            this.balance = l;
            return this;
        }

        public DailyPnSetting build() {
            return new DailyPnSetting(this);
        }
    }
}
