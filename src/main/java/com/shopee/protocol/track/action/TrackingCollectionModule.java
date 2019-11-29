package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingCollectionModule extends Message {
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_LOCATION = 0;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    public TrackingCollectionModule(String str, Integer num, Integer num2) {
        this.name = str;
        this.id = num;
        this.location = num2;
    }

    private TrackingCollectionModule(Builder builder) {
        this(builder.name, builder.id, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingCollectionModule)) {
            return false;
        }
        TrackingCollectionModule trackingCollectionModule = (TrackingCollectionModule) obj;
        if (!equals((Object) this.name, (Object) trackingCollectionModule.name) || !equals((Object) this.id, (Object) trackingCollectionModule.id) || !equals((Object) this.location, (Object) trackingCollectionModule.location)) {
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
        Integer num = this.id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.location;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingCollectionModule> {
        public Integer id;
        public Integer location;
        public String name;

        public Builder() {
        }

        public Builder(TrackingCollectionModule trackingCollectionModule) {
            super(trackingCollectionModule);
            if (trackingCollectionModule != null) {
                this.name = trackingCollectionModule.name;
                this.id = trackingCollectionModule.id;
                this.location = trackingCollectionModule.location;
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public TrackingCollectionModule build() {
            return new TrackingCollectionModule(this);
        }
    }
}
