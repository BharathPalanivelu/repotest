package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingAutoComplete extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final Integer DEFAULT_CLICK_LOCATION = 0;
    public static final Boolean DEFAULT_HISTORY = false;
    public static final Integer DEFAULT_LAST_SEEN_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer click_location;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean history;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer last_seen_location;

    public TrackingAutoComplete(Integer num, Integer num2, Boolean bool, Integer num3) {
        this.last_seen_location = num;
        this.click_location = num2;
        this.history = bool;
        this.catid = num3;
    }

    private TrackingAutoComplete(Builder builder) {
        this(builder.last_seen_location, builder.click_location, builder.history, builder.catid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingAutoComplete)) {
            return false;
        }
        TrackingAutoComplete trackingAutoComplete = (TrackingAutoComplete) obj;
        if (!equals((Object) this.last_seen_location, (Object) trackingAutoComplete.last_seen_location) || !equals((Object) this.click_location, (Object) trackingAutoComplete.click_location) || !equals((Object) this.history, (Object) trackingAutoComplete.history) || !equals((Object) this.catid, (Object) trackingAutoComplete.catid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.last_seen_location;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.click_location;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.history;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.catid;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingAutoComplete> {
        public Integer catid;
        public Integer click_location;
        public Boolean history;
        public Integer last_seen_location;

        public Builder() {
        }

        public Builder(TrackingAutoComplete trackingAutoComplete) {
            super(trackingAutoComplete);
            if (trackingAutoComplete != null) {
                this.last_seen_location = trackingAutoComplete.last_seen_location;
                this.click_location = trackingAutoComplete.click_location;
                this.history = trackingAutoComplete.history;
                this.catid = trackingAutoComplete.catid;
            }
        }

        public Builder last_seen_location(Integer num) {
            this.last_seen_location = num;
            return this;
        }

        public Builder click_location(Integer num) {
            this.click_location = num;
            return this;
        }

        public Builder history(Boolean bool) {
            this.history = bool;
            return this;
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public TrackingAutoComplete build() {
            return new TrackingAutoComplete(this);
        }
    }
}
