package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingShippedFrom extends Message {
    public static final String DEFAULT_CITY = "";
    public static final Integer DEFAULT_FILTER_TYPE = 0;
    public static final Integer DEFAULT_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String city;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer filter_type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer location;

    public TrackingShippedFrom(String str, Integer num, Integer num2) {
        this.city = str;
        this.location = num;
        this.filter_type = num2;
    }

    private TrackingShippedFrom(Builder builder) {
        this(builder.city, builder.location, builder.filter_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingShippedFrom)) {
            return false;
        }
        TrackingShippedFrom trackingShippedFrom = (TrackingShippedFrom) obj;
        if (!equals((Object) this.city, (Object) trackingShippedFrom.city) || !equals((Object) this.location, (Object) trackingShippedFrom.location) || !equals((Object) this.filter_type, (Object) trackingShippedFrom.filter_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.city;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.location;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.filter_type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingShippedFrom> {
        public String city;
        public Integer filter_type;
        public Integer location;

        public Builder() {
        }

        public Builder(TrackingShippedFrom trackingShippedFrom) {
            super(trackingShippedFrom);
            if (trackingShippedFrom != null) {
                this.city = trackingShippedFrom.city;
                this.location = trackingShippedFrom.location;
                this.filter_type = trackingShippedFrom.filter_type;
            }
        }

        public Builder city(String str) {
            this.city = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder filter_type(Integer num) {
            this.filter_type = num;
            return this;
        }

        public TrackingShippedFrom build() {
            return new TrackingShippedFrom(this);
        }
    }
}
