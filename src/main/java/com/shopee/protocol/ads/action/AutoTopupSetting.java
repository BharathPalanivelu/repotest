package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AutoTopupSetting extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Boolean DEFAULT_ON = false;
    public static final Long DEFAULT_THRESHOLD = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean on;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long threshold;

    public AutoTopupSetting(Boolean bool, Long l, Long l2) {
        this.on = bool;
        this.threshold = l;
        this.amount = l2;
    }

    private AutoTopupSetting(Builder builder) {
        this(builder.on, builder.threshold, builder.amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoTopupSetting)) {
            return false;
        }
        AutoTopupSetting autoTopupSetting = (AutoTopupSetting) obj;
        if (!equals((Object) this.on, (Object) autoTopupSetting.on) || !equals((Object) this.threshold, (Object) autoTopupSetting.threshold) || !equals((Object) this.amount, (Object) autoTopupSetting.amount)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.on;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Long l = this.threshold;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.amount;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AutoTopupSetting> {
        public Long amount;
        public Boolean on;
        public Long threshold;

        public Builder() {
        }

        public Builder(AutoTopupSetting autoTopupSetting) {
            super(autoTopupSetting);
            if (autoTopupSetting != null) {
                this.on = autoTopupSetting.on;
                this.threshold = autoTopupSetting.threshold;
                this.amount = autoTopupSetting.amount;
            }
        }

        public Builder on(Boolean bool) {
            this.on = bool;
            return this;
        }

        public Builder threshold(Long l) {
            this.threshold = l;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public AutoTopupSetting build() {
            return new AutoTopupSetting(this);
        }
    }
}
