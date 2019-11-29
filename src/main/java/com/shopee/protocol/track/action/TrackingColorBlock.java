package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingColorBlock extends Message {
    public static final String DEFAULT_KEYWORDADDON = "";
    public static final Integer DEFAULT_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String keywordAddOn;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer location;

    public TrackingColorBlock(String str, Integer num) {
        this.keywordAddOn = str;
        this.location = num;
    }

    private TrackingColorBlock(Builder builder) {
        this(builder.keywordAddOn, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingColorBlock)) {
            return false;
        }
        TrackingColorBlock trackingColorBlock = (TrackingColorBlock) obj;
        if (!equals((Object) this.keywordAddOn, (Object) trackingColorBlock.keywordAddOn) || !equals((Object) this.location, (Object) trackingColorBlock.location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.keywordAddOn;
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

    public static final class Builder extends Message.Builder<TrackingColorBlock> {
        public String keywordAddOn;
        public Integer location;

        public Builder() {
        }

        public Builder(TrackingColorBlock trackingColorBlock) {
            super(trackingColorBlock);
            if (trackingColorBlock != null) {
                this.keywordAddOn = trackingColorBlock.keywordAddOn;
                this.location = trackingColorBlock.location;
            }
        }

        public Builder keywordAddOn(String str) {
            this.keywordAddOn = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public TrackingColorBlock build() {
            return new TrackingColorBlock(this);
        }
    }
}
