package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingAttribute extends Message {
    public static final String DEFAULT_ATTRIBUTE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String attribute;

    public TrackingAttribute(String str) {
        this.attribute = str;
    }

    private TrackingAttribute(Builder builder) {
        this(builder.attribute);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingAttribute)) {
            return false;
        }
        return equals((Object) this.attribute, (Object) ((TrackingAttribute) obj).attribute);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.attribute;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TrackingAttribute> {
        public String attribute;

        public Builder() {
        }

        public Builder(TrackingAttribute trackingAttribute) {
            super(trackingAttribute);
            if (trackingAttribute != null) {
                this.attribute = trackingAttribute.attribute;
            }
        }

        public Builder attribute(String str) {
            this.attribute = str;
            return this;
        }

        public TrackingAttribute build() {
            return new TrackingAttribute(this);
        }
    }
}
