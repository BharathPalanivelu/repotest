package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceMFInfo extends Message {
    public static final Integer DEFAULT_BOOT_TIMESTAMP = 0;
    public static final String DEFAULT_CARRIER = "";
    public static final Integer DEFAULT_CLIENT_TIMESTAMP = 0;
    public static final String DEFAULT_ITEM_ID = "";
    public static final Boolean DEFAULT_JAILBREAK = false;
    public static final String DEFAULT_PHONE_NUMBER = "";
    public static final String DEFAULT_TIMEZONE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer boot_timestamp;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String carrier;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer client_timestamp;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean jailbreak;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String phone_number;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String timezone;

    public DeviceMFInfo(Integer num, String str, Boolean bool, String str2, String str3, String str4, Integer num2) {
        this.boot_timestamp = num;
        this.timezone = str;
        this.jailbreak = bool;
        this.phone_number = str2;
        this.carrier = str3;
        this.item_id = str4;
        this.client_timestamp = num2;
    }

    private DeviceMFInfo(Builder builder) {
        this(builder.boot_timestamp, builder.timezone, builder.jailbreak, builder.phone_number, builder.carrier, builder.item_id, builder.client_timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceMFInfo)) {
            return false;
        }
        DeviceMFInfo deviceMFInfo = (DeviceMFInfo) obj;
        if (!equals((Object) this.boot_timestamp, (Object) deviceMFInfo.boot_timestamp) || !equals((Object) this.timezone, (Object) deviceMFInfo.timezone) || !equals((Object) this.jailbreak, (Object) deviceMFInfo.jailbreak) || !equals((Object) this.phone_number, (Object) deviceMFInfo.phone_number) || !equals((Object) this.carrier, (Object) deviceMFInfo.carrier) || !equals((Object) this.item_id, (Object) deviceMFInfo.item_id) || !equals((Object) this.client_timestamp, (Object) deviceMFInfo.client_timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.boot_timestamp;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.timezone;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.jailbreak;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.phone_number;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.carrier;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.item_id;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.client_timestamp;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceMFInfo> {
        public Integer boot_timestamp;
        public String carrier;
        public Integer client_timestamp;
        public String item_id;
        public Boolean jailbreak;
        public String phone_number;
        public String timezone;

        public Builder() {
        }

        public Builder(DeviceMFInfo deviceMFInfo) {
            super(deviceMFInfo);
            if (deviceMFInfo != null) {
                this.boot_timestamp = deviceMFInfo.boot_timestamp;
                this.timezone = deviceMFInfo.timezone;
                this.jailbreak = deviceMFInfo.jailbreak;
                this.phone_number = deviceMFInfo.phone_number;
                this.carrier = deviceMFInfo.carrier;
                this.item_id = deviceMFInfo.item_id;
                this.client_timestamp = deviceMFInfo.client_timestamp;
            }
        }

        public Builder boot_timestamp(Integer num) {
            this.boot_timestamp = num;
            return this;
        }

        public Builder timezone(String str) {
            this.timezone = str;
            return this;
        }

        public Builder jailbreak(Boolean bool) {
            this.jailbreak = bool;
            return this;
        }

        public Builder phone_number(String str) {
            this.phone_number = str;
            return this;
        }

        public Builder carrier(String str) {
            this.carrier = str;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder client_timestamp(Integer num) {
            this.client_timestamp = num;
            return this;
        }

        public DeviceMFInfo build() {
            return new DeviceMFInfo(this);
        }
    }
}
