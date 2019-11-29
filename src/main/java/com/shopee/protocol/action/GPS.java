package com.shopee.protocol.action;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GPS extends Message {
    public static final Float DEFAULT_LATITUDE;
    public static final Float DEFAULT_LONGITUDE;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.FLOAT)
    public final Float latitude;
    @ProtoField(tag = 1, type = Message.Datatype.FLOAT)
    public final Float longitude;

    static {
        Float valueOf = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
        DEFAULT_LONGITUDE = valueOf;
        DEFAULT_LATITUDE = valueOf;
    }

    public GPS(Float f2, Float f3) {
        this.longitude = f2;
        this.latitude = f3;
    }

    private GPS(Builder builder) {
        this(builder.longitude, builder.latitude);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GPS)) {
            return false;
        }
        GPS gps = (GPS) obj;
        if (!equals((Object) this.longitude, (Object) gps.longitude) || !equals((Object) this.latitude, (Object) gps.latitude)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Float f2 = this.longitude;
        int i2 = 0;
        int hashCode = (f2 != null ? f2.hashCode() : 0) * 37;
        Float f3 = this.latitude;
        if (f3 != null) {
            i2 = f3.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GPS> {
        public Float latitude;
        public Float longitude;

        public Builder() {
        }

        public Builder(GPS gps) {
            super(gps);
            if (gps != null) {
                this.longitude = gps.longitude;
                this.latitude = gps.latitude;
            }
        }

        public Builder longitude(Float f2) {
            this.longitude = f2;
            return this;
        }

        public Builder latitude(Float f2) {
            this.latitude = f2;
            return this;
        }

        public GPS build() {
            return new GPS(this);
        }
    }
}
