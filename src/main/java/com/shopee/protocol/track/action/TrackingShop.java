package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingShop extends Message {
    public static final String DEFAULT_ALGORITHM = "";
    public static final Boolean DEFAULT_IS_OFFICIAL = false;
    public static final Boolean DEFAULT_IS_PREFERRED = false;
    public static final Integer DEFAULT_LOCATION = 0;
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String algorithm;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_official;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_preferred;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer location;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public TrackingShop(Integer num, Boolean bool, Boolean bool2, Integer num2, String str) {
        this.shopid = num;
        this.is_preferred = bool;
        this.is_official = bool2;
        this.location = num2;
        this.algorithm = str;
    }

    private TrackingShop(Builder builder) {
        this(builder.shopid, builder.is_preferred, builder.is_official, builder.location, builder.algorithm);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingShop)) {
            return false;
        }
        TrackingShop trackingShop = (TrackingShop) obj;
        if (!equals((Object) this.shopid, (Object) trackingShop.shopid) || !equals((Object) this.is_preferred, (Object) trackingShop.is_preferred) || !equals((Object) this.is_official, (Object) trackingShop.is_official) || !equals((Object) this.location, (Object) trackingShop.location) || !equals((Object) this.algorithm, (Object) trackingShop.algorithm)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Boolean bool = this.is_preferred;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_official;
        int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num2 = this.location;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.algorithm;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingShop> {
        public String algorithm;
        public Boolean is_official;
        public Boolean is_preferred;
        public Integer location;
        public Integer shopid;

        public Builder() {
        }

        public Builder(TrackingShop trackingShop) {
            super(trackingShop);
            if (trackingShop != null) {
                this.shopid = trackingShop.shopid;
                this.is_preferred = trackingShop.is_preferred;
                this.is_official = trackingShop.is_official;
                this.location = trackingShop.location;
                this.algorithm = trackingShop.algorithm;
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder is_preferred(Boolean bool) {
            this.is_preferred = bool;
            return this;
        }

        public Builder is_official(Boolean bool) {
            this.is_official = bool;
            return this;
        }

        public Builder location(Integer num) {
            this.location = num;
            return this;
        }

        public Builder algorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public TrackingShop build() {
            return new TrackingShop(this);
        }
    }
}
