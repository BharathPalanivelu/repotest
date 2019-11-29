package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingCategory extends Message {
    public static final Integer DEFAULT_CATID = 0;
    public static final String DEFAULT_CAT_NAME = "";
    public static final Integer DEFAULT_LOCATION = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cat_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer catid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer location;

    public TrackingCategory(Integer num, String str, Integer num2) {
        this.catid = num;
        this.cat_name = str;
        this.location = num2;
    }

    private TrackingCategory(Builder builder) {
        this(builder.catid, builder.cat_name, builder.location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingCategory)) {
            return false;
        }
        TrackingCategory trackingCategory = (TrackingCategory) obj;
        if (!equals((Object) this.catid, (Object) trackingCategory.catid) || !equals((Object) this.cat_name, (Object) trackingCategory.cat_name) || !equals((Object) this.location, (Object) trackingCategory.location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.catid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.cat_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.location;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingCategory> {
        public String cat_name;
        public Integer catid;
        public Integer location;

        public Builder() {
        }

        public Builder(TrackingCategory trackingCategory) {
            super(trackingCategory);
            if (trackingCategory != null) {
                this.catid = trackingCategory.catid;
                this.cat_name = trackingCategory.cat_name;
                this.location = trackingCategory.location;
            }
        }

        public Builder catid(Integer num) {
            this.catid = num;
            return this;
        }

        public Builder cat_name(String str) {
            this.cat_name = str;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public TrackingCategory build() {
            return new TrackingCategory(this);
        }
    }
}
