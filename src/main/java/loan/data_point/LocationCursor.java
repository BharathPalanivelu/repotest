package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LocationCursor extends Message {
    public static final String DEFAULT_ITEM_ID = "";
    public static final Integer DEFAULT_LOCATION_TIMESTAMP = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer location_timestamp;

    public LocationCursor(Integer num, String str) {
        this.location_timestamp = num;
        this.item_id = str;
    }

    private LocationCursor(Builder builder) {
        this(builder.location_timestamp, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationCursor)) {
            return false;
        }
        LocationCursor locationCursor = (LocationCursor) obj;
        if (!equals((Object) this.location_timestamp, (Object) locationCursor.location_timestamp) || !equals((Object) this.item_id, (Object) locationCursor.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.location_timestamp;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.item_id;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LocationCursor> {
        public String item_id;
        public Integer location_timestamp;

        public Builder() {
        }

        public Builder(LocationCursor locationCursor) {
            super(locationCursor);
            if (locationCursor != null) {
                this.location_timestamp = locationCursor.location_timestamp;
                this.item_id = locationCursor.item_id;
            }
        }

        public Builder location_timestamp(Integer num) {
            this.location_timestamp = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public LocationCursor build() {
            return new LocationCursor(this);
        }
    }
}
