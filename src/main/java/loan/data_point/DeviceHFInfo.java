package loan.data_point;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceHFInfo extends Message {
    public static final Long DEFAULT_AVAILABLE_MEMORY = 0L;
    public static final Long DEFAULT_AVAILABLE_STORAGE = 0L;
    public static final Float DEFAULT_BATTERY_PERCENT;
    public static final Float DEFAULT_BATTERY_TEMPERATURE;
    public static final Integer DEFAULT_BRIGHTNESS = 0;
    public static final Integer DEFAULT_CHARGING_SOURCE = 0;
    public static final Integer DEFAULT_CLIENT_TIMESTAMP = 0;
    public static final Boolean DEFAULT_IS_CHARGING = false;
    public static final String DEFAULT_ITEM_ID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long available_memory;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long available_storage;
    @ProtoField(tag = 5, type = Message.Datatype.FLOAT)
    public final Float battery_percent;
    @ProtoField(tag = 4, type = Message.Datatype.FLOAT)
    public final Float battery_temperature;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer brightness;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer charging_source;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer client_timestamp;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_charging;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String item_id;

    static {
        Float valueOf = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
        DEFAULT_BATTERY_TEMPERATURE = valueOf;
        DEFAULT_BATTERY_PERCENT = valueOf;
    }

    public DeviceHFInfo(Long l, Long l2, Float f2, Float f3, Boolean bool, Integer num, Integer num2, String str, Integer num3) {
        this.available_memory = l;
        this.available_storage = l2;
        this.battery_temperature = f2;
        this.battery_percent = f3;
        this.is_charging = bool;
        this.charging_source = num;
        this.brightness = num2;
        this.item_id = str;
        this.client_timestamp = num3;
    }

    private DeviceHFInfo(Builder builder) {
        this(builder.available_memory, builder.available_storage, builder.battery_temperature, builder.battery_percent, builder.is_charging, builder.charging_source, builder.brightness, builder.item_id, builder.client_timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceHFInfo)) {
            return false;
        }
        DeviceHFInfo deviceHFInfo = (DeviceHFInfo) obj;
        if (!equals((Object) this.available_memory, (Object) deviceHFInfo.available_memory) || !equals((Object) this.available_storage, (Object) deviceHFInfo.available_storage) || !equals((Object) this.battery_temperature, (Object) deviceHFInfo.battery_temperature) || !equals((Object) this.battery_percent, (Object) deviceHFInfo.battery_percent) || !equals((Object) this.is_charging, (Object) deviceHFInfo.is_charging) || !equals((Object) this.charging_source, (Object) deviceHFInfo.charging_source) || !equals((Object) this.brightness, (Object) deviceHFInfo.brightness) || !equals((Object) this.item_id, (Object) deviceHFInfo.item_id) || !equals((Object) this.client_timestamp, (Object) deviceHFInfo.client_timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.available_memory;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.available_storage;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Float f2 = this.battery_temperature;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.battery_percent;
        int hashCode4 = (hashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Boolean bool = this.is_charging;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.charging_source;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.brightness;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.item_id;
        int hashCode8 = (hashCode7 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num3 = this.client_timestamp;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceHFInfo> {
        public Long available_memory;
        public Long available_storage;
        public Float battery_percent;
        public Float battery_temperature;
        public Integer brightness;
        public Integer charging_source;
        public Integer client_timestamp;
        public Boolean is_charging;
        public String item_id;

        public Builder() {
        }

        public Builder(DeviceHFInfo deviceHFInfo) {
            super(deviceHFInfo);
            if (deviceHFInfo != null) {
                this.available_memory = deviceHFInfo.available_memory;
                this.available_storage = deviceHFInfo.available_storage;
                this.battery_temperature = deviceHFInfo.battery_temperature;
                this.battery_percent = deviceHFInfo.battery_percent;
                this.is_charging = deviceHFInfo.is_charging;
                this.charging_source = deviceHFInfo.charging_source;
                this.brightness = deviceHFInfo.brightness;
                this.item_id = deviceHFInfo.item_id;
                this.client_timestamp = deviceHFInfo.client_timestamp;
            }
        }

        public Builder available_memory(Long l) {
            this.available_memory = l;
            return this;
        }

        public Builder available_storage(Long l) {
            this.available_storage = l;
            return this;
        }

        public Builder battery_temperature(Float f2) {
            this.battery_temperature = f2;
            return this;
        }

        public Builder battery_percent(Float f2) {
            this.battery_percent = f2;
            return this;
        }

        public Builder is_charging(Boolean bool) {
            this.is_charging = bool;
            return this;
        }

        public Builder charging_source(Integer num) {
            this.charging_source = num;
            return this;
        }

        public Builder brightness(Integer num) {
            this.brightness = num;
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

        public DeviceHFInfo build() {
            return new DeviceHFInfo(this);
        }
    }
}
