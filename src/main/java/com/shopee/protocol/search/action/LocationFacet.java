package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LocationFacet extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final MatchAddressLevels DEFAULT_LEVEL = MatchAddressLevels.COUNTRY;
    public static final String DEFAULT_LOCATION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final MatchAddressLevels level;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String location;

    public LocationFacet(String str, String str2, MatchAddressLevels matchAddressLevels) {
        this.location = str;
        this.country = str2;
        this.level = matchAddressLevels;
    }

    private LocationFacet(Builder builder) {
        this(builder.location, builder.country, builder.level);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationFacet)) {
            return false;
        }
        LocationFacet locationFacet = (LocationFacet) obj;
        if (!equals((Object) this.location, (Object) locationFacet.location) || !equals((Object) this.country, (Object) locationFacet.country) || !equals((Object) this.level, (Object) locationFacet.level)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.location;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        MatchAddressLevels matchAddressLevels = this.level;
        if (matchAddressLevels != null) {
            i2 = matchAddressLevels.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LocationFacet> {
        public String country;
        public MatchAddressLevels level;
        public String location;

        public Builder() {
        }

        public Builder(LocationFacet locationFacet) {
            super(locationFacet);
            if (locationFacet != null) {
                this.location = locationFacet.location;
                this.country = locationFacet.country;
                this.level = locationFacet.level;
            }
        }

        public Builder location(String str) {
            this.location = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder level(MatchAddressLevels matchAddressLevels) {
            this.level = matchAddressLevels;
            return this;
        }

        public LocationFacet build() {
            return new LocationFacet(this);
        }
    }
}
