package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LocationInfo extends Message {
    public static final Long DEFAULT_ALTITUDE = 0L;
    public static final Integer DEFAULT_BASE = 0;
    public static final String DEFAULT_ITEM_ID = "";
    public static final Long DEFAULT_LATITUDE = 0L;
    public static final Boolean DEFAULT_LOCATION_PERMISSION = false;
    public static final Boolean DEFAULT_LOCATION_SERVICE = false;
    public static final Integer DEFAULT_LOCATION_TIMESTAMP = 0;
    public static final Long DEFAULT_LONGITUDE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long altitude;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer base;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long latitude;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean location_permission;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean location_service;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer location_timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long longitude;

    public LocationInfo(Long l, Long l2, Integer num, Integer num2, String str, Long l3, Boolean bool, Boolean bool2) {
        this.longitude = l;
        this.latitude = l2;
        this.base = num;
        this.location_timestamp = num2;
        this.item_id = str;
        this.altitude = l3;
        this.location_permission = bool;
        this.location_service = bool2;
    }

    private LocationInfo(Builder builder) {
        this(builder.longitude, builder.latitude, builder.base, builder.location_timestamp, builder.item_id, builder.altitude, builder.location_permission, builder.location_service);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (!equals((Object) this.longitude, (Object) locationInfo.longitude) || !equals((Object) this.latitude, (Object) locationInfo.latitude) || !equals((Object) this.base, (Object) locationInfo.base) || !equals((Object) this.location_timestamp, (Object) locationInfo.location_timestamp) || !equals((Object) this.item_id, (Object) locationInfo.item_id) || !equals((Object) this.altitude, (Object) locationInfo.altitude) || !equals((Object) this.location_permission, (Object) locationInfo.location_permission) || !equals((Object) this.location_service, (Object) locationInfo.location_service)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.longitude;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.latitude;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.base;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.location_timestamp;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.item_id;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Long l3 = this.altitude;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Boolean bool = this.location_permission;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.location_service;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LocationInfo> {
        public Long altitude;
        public Integer base;
        public String item_id;
        public Long latitude;
        public Boolean location_permission;
        public Boolean location_service;
        public Integer location_timestamp;
        public Long longitude;

        public Builder() {
        }

        public Builder(LocationInfo locationInfo) {
            super(locationInfo);
            if (locationInfo != null) {
                this.longitude = locationInfo.longitude;
                this.latitude = locationInfo.latitude;
                this.base = locationInfo.base;
                this.location_timestamp = locationInfo.location_timestamp;
                this.item_id = locationInfo.item_id;
                this.altitude = locationInfo.altitude;
                this.location_permission = locationInfo.location_permission;
                this.location_service = locationInfo.location_service;
            }
        }

        public Builder longitude(Long l) {
            this.longitude = l;
            return this;
        }

        public Builder latitude(Long l) {
            this.latitude = l;
            return this;
        }

        public Builder base(Integer num) {
            this.base = num;
            return this;
        }

        public Builder location_timestamp(Integer num) {
            this.location_timestamp = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder altitude(Long l) {
            this.altitude = l;
            return this;
        }

        public Builder location_permission(Boolean bool) {
            this.location_permission = bool;
            return this;
        }

        public Builder location_service(Boolean bool) {
            this.location_service = bool;
            return this;
        }

        public LocationInfo build() {
            return new LocationInfo(this);
        }
    }
}
