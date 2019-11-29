package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingButton extends Message {
    public static final Integer DEFAULT_LOCATION = 0;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    public TrackingButton(String str, Integer num) {
        this.name = str;
        this.location = num;
    }

    private TrackingButton(Builder builder) {
        this(builder.name, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingButton)) {
            return false;
        }
        TrackingButton trackingButton = (TrackingButton) obj;
        if (!equals((Object) this.name, (Object) trackingButton.name) || !equals((Object) this.location, (Object) trackingButton.location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.location;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingButton> {
        public Integer location;
        public String name;

        public Builder() {
        }

        public Builder(TrackingButton trackingButton) {
            super(trackingButton);
            if (trackingButton != null) {
                this.name = trackingButton.name;
                this.location = trackingButton.location;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public TrackingButton build() {
            return new TrackingButton(this);
        }
    }
}
