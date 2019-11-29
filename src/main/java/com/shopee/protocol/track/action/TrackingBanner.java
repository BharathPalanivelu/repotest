package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingBanner extends Message {
    public static final Integer DEFAULT_BANNER_ID = 0;
    public static final Integer DEFAULT_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer banner_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer location;

    public TrackingBanner(Integer num, Integer num2) {
        this.banner_id = num;
        this.location = num2;
    }

    private TrackingBanner(Builder builder) {
        this(builder.banner_id, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingBanner)) {
            return false;
        }
        TrackingBanner trackingBanner = (TrackingBanner) obj;
        if (!equals((Object) this.banner_id, (Object) trackingBanner.banner_id) || !equals((Object) this.location, (Object) trackingBanner.location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.banner_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.location;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingBanner> {
        public Integer banner_id;
        public Integer location;

        public Builder() {
        }

        public Builder(TrackingBanner trackingBanner) {
            super(trackingBanner);
            if (trackingBanner != null) {
                this.banner_id = trackingBanner.banner_id;
                this.location = trackingBanner.location;
            }
        }

        public Builder banner_id(Integer num) {
            this.banner_id = num;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public TrackingBanner build() {
            return new TrackingBanner(this);
        }
    }
}
