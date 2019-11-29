package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceMFCursor extends Message {
    public static final Integer DEFAULT_CLIENT_TIMESTAMP = 0;
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer client_timestamp;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String item_id;

    public DeviceMFCursor(Integer num, String str) {
        this.client_timestamp = num;
        this.item_id = str;
    }

    private DeviceMFCursor(Builder builder) {
        this(builder.client_timestamp, builder.item_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceMFCursor)) {
            return false;
        }
        DeviceMFCursor deviceMFCursor = (DeviceMFCursor) obj;
        if (!equals((Object) this.client_timestamp, (Object) deviceMFCursor.client_timestamp) || !equals((Object) this.item_id, (Object) deviceMFCursor.item_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.client_timestamp;
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

    public static final class Builder extends Message.Builder<DeviceMFCursor> {
        public Integer client_timestamp;
        public String item_id;

        public Builder() {
        }

        public Builder(DeviceMFCursor deviceMFCursor) {
            super(deviceMFCursor);
            if (deviceMFCursor != null) {
                this.client_timestamp = deviceMFCursor.client_timestamp;
                this.item_id = deviceMFCursor.item_id;
            }
        }

        public Builder client_timestamp(Integer num) {
            this.client_timestamp = num;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public DeviceMFCursor build() {
            return new DeviceMFCursor(this);
        }
    }
}
