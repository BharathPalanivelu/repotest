package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RateControl extends Message {
    public static final Integer DEFAULT_CMD = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_THRESHOLD_DROP = 0;
    public static final Integer DEFAULT_THRESHOLD_WARN = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer threshold_drop;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer threshold_warn;

    public RateControl(Integer num, Integer num2, Integer num3, Integer num4) {
        this.cmd = num;
        this.threshold_warn = num2;
        this.threshold_drop = num3;
        this.mtime = num4;
    }

    private RateControl(Builder builder) {
        this(builder.cmd, builder.threshold_warn, builder.threshold_drop, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RateControl)) {
            return false;
        }
        RateControl rateControl = (RateControl) obj;
        if (!equals((Object) this.cmd, (Object) rateControl.cmd) || !equals((Object) this.threshold_warn, (Object) rateControl.threshold_warn) || !equals((Object) this.threshold_drop, (Object) rateControl.threshold_drop) || !equals((Object) this.mtime, (Object) rateControl.mtime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.cmd;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.threshold_warn;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.threshold_drop;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mtime;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RateControl> {
        public Integer cmd;
        public Integer mtime;
        public Integer threshold_drop;
        public Integer threshold_warn;

        public Builder() {
        }

        public Builder(RateControl rateControl) {
            super(rateControl);
            if (rateControl != null) {
                this.cmd = rateControl.cmd;
                this.threshold_warn = rateControl.threshold_warn;
                this.threshold_drop = rateControl.threshold_drop;
                this.mtime = rateControl.mtime;
            }
        }

        public Builder cmd(Integer num) {
            this.cmd = num;
            return this;
        }

        public Builder threshold_warn(Integer num) {
            this.threshold_warn = num;
            return this;
        }

        public Builder threshold_drop(Integer num) {
            this.threshold_drop = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public RateControl build() {
            return new RateControl(this);
        }
    }
}
