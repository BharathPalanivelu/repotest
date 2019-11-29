package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingMarketingToken extends Message {
    public static final String DEFAULT_MEDIUM_ID = "";
    public static final Integer DEFAULT_MEDIUM_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String medium_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer medium_type;

    public TrackingMarketingToken(Integer num, String str) {
        this.medium_type = num;
        this.medium_id = str;
    }

    private TrackingMarketingToken(Builder builder) {
        this(builder.medium_type, builder.medium_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingMarketingToken)) {
            return false;
        }
        TrackingMarketingToken trackingMarketingToken = (TrackingMarketingToken) obj;
        if (!equals((Object) this.medium_type, (Object) trackingMarketingToken.medium_type) || !equals((Object) this.medium_id, (Object) trackingMarketingToken.medium_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.medium_type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.medium_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingMarketingToken> {
        public String medium_id;
        public Integer medium_type;

        public Builder() {
        }

        public Builder(TrackingMarketingToken trackingMarketingToken) {
            super(trackingMarketingToken);
            if (trackingMarketingToken != null) {
                this.medium_type = trackingMarketingToken.medium_type;
                this.medium_id = trackingMarketingToken.medium_id;
            }
        }

        public Builder medium_type(Integer num) {
            this.medium_type = num;
            return this;
        }

        public Builder medium_id(String str) {
            this.medium_id = str;
            return this;
        }

        public TrackingMarketingToken build() {
            return new TrackingMarketingToken(this);
        }
    }
}
