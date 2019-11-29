package loan.data_point;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceLFInfo extends Message {
    public static final String DEFAULT_ANDROID_ID = "";
    public static final String DEFAULT_BLUETOOTH_MAC_ADDRESS = "";
    public static final String DEFAULT_BRAND = "";
    public static final Integer DEFAULT_BUILD_TIME = 0;
    public static final Integer DEFAULT_CLIENT_TIMESTAMP = 0;
    public static final String DEFAULT_DEVICE_NAME = "";
    public static final String DEFAULT_FREEFIRE_FINGERPRINT = "";
    public static final String DEFAULT_FREEFIRE_USER_ID = "";
    public static final String DEFAULT_HARDWARE = "";
    public static final String DEFAULT_IDFA = "";
    public static final String DEFAULT_IDFV = "";
    public static final String DEFAULT_ITEM_ID = "";
    public static final String DEFAULT_MAC_ADDRESS = "";
    public static final String DEFAULT_MANUFACTURER = "";
    public static final String DEFAULT_MODEL = "";
    public static final String DEFAULT_PRODUCT = "";
    public static final Integer DEFAULT_SCREEN_HEIGHT = 0;
    public static final Integer DEFAULT_SCREEN_WIDTH = 0;
    public static final Long DEFAULT_TOTAL_MEMORY = 0L;
    public static final Long DEFAULT_TOTAL_STORAGE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String android_id;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String bluetooth_mac_address;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String brand;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer build_time;
    @ProtoField(tag = 18, type = Message.Datatype.UINT32)
    public final Integer client_timestamp;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String device_name;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String freefire_fingerprint;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String freefire_user_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String hardware;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String idfa;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String idfv;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String mac_address;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String manufacturer;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String model;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String product;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer screen_height;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer screen_width;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long total_memory;
    @ProtoField(tag = 14, type = Message.Datatype.INT64)
    public final Long total_storage;

    public DeviceLFInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num, Long l, Long l2, Integer num2, Integer num3, String str12, Integer num4, String str13, String str14) {
        this.manufacturer = str;
        this.model = str2;
        this.product = str3;
        this.brand = str4;
        this.hardware = str5;
        this.device_name = str6;
        this.mac_address = str7;
        this.bluetooth_mac_address = str8;
        this.idfv = str9;
        this.idfa = str10;
        this.android_id = str11;
        this.build_time = num;
        this.total_memory = l;
        this.total_storage = l2;
        this.screen_width = num2;
        this.screen_height = num3;
        this.item_id = str12;
        this.client_timestamp = num4;
        this.freefire_user_id = str13;
        this.freefire_fingerprint = str14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DeviceLFInfo(loan.data_point.DeviceLFInfo.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.String r2 = r0.manufacturer
            java.lang.String r3 = r0.model
            java.lang.String r4 = r0.product
            java.lang.String r5 = r0.brand
            java.lang.String r6 = r0.hardware
            java.lang.String r7 = r0.device_name
            java.lang.String r8 = r0.mac_address
            java.lang.String r9 = r0.bluetooth_mac_address
            java.lang.String r10 = r0.idfv
            java.lang.String r11 = r0.idfa
            java.lang.String r12 = r0.android_id
            java.lang.Integer r13 = r0.build_time
            java.lang.Long r14 = r0.total_memory
            java.lang.Long r15 = r0.total_storage
            r22 = r1
            java.lang.Integer r1 = r0.screen_width
            r16 = r1
            java.lang.Integer r1 = r0.screen_height
            r17 = r1
            java.lang.String r1 = r0.item_id
            r18 = r1
            java.lang.Integer r1 = r0.client_timestamp
            r19 = r1
            java.lang.String r1 = r0.freefire_user_id
            r20 = r1
            java.lang.String r1 = r0.freefire_fingerprint
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: loan.data_point.DeviceLFInfo.<init>(loan.data_point.DeviceLFInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceLFInfo)) {
            return false;
        }
        DeviceLFInfo deviceLFInfo = (DeviceLFInfo) obj;
        if (!equals((Object) this.manufacturer, (Object) deviceLFInfo.manufacturer) || !equals((Object) this.model, (Object) deviceLFInfo.model) || !equals((Object) this.product, (Object) deviceLFInfo.product) || !equals((Object) this.brand, (Object) deviceLFInfo.brand) || !equals((Object) this.hardware, (Object) deviceLFInfo.hardware) || !equals((Object) this.device_name, (Object) deviceLFInfo.device_name) || !equals((Object) this.mac_address, (Object) deviceLFInfo.mac_address) || !equals((Object) this.bluetooth_mac_address, (Object) deviceLFInfo.bluetooth_mac_address) || !equals((Object) this.idfv, (Object) deviceLFInfo.idfv) || !equals((Object) this.idfa, (Object) deviceLFInfo.idfa) || !equals((Object) this.android_id, (Object) deviceLFInfo.android_id) || !equals((Object) this.build_time, (Object) deviceLFInfo.build_time) || !equals((Object) this.total_memory, (Object) deviceLFInfo.total_memory) || !equals((Object) this.total_storage, (Object) deviceLFInfo.total_storage) || !equals((Object) this.screen_width, (Object) deviceLFInfo.screen_width) || !equals((Object) this.screen_height, (Object) deviceLFInfo.screen_height) || !equals((Object) this.item_id, (Object) deviceLFInfo.item_id) || !equals((Object) this.client_timestamp, (Object) deviceLFInfo.client_timestamp) || !equals((Object) this.freefire_user_id, (Object) deviceLFInfo.freefire_user_id) || !equals((Object) this.freefire_fingerprint, (Object) deviceLFInfo.freefire_fingerprint)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.manufacturer;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.model;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.product;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.brand;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.hardware;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.device_name;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.mac_address;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.bluetooth_mac_address;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.idfv;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.idfa;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.android_id;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Integer num = this.build_time;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.total_memory;
        int hashCode13 = (hashCode12 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.total_storage;
        int hashCode14 = (hashCode13 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.screen_width;
        int hashCode15 = (hashCode14 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.screen_height;
        int hashCode16 = (hashCode15 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str12 = this.item_id;
        int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num4 = this.client_timestamp;
        int hashCode18 = (hashCode17 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str13 = this.freefire_user_id;
        int hashCode19 = (hashCode18 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.freefire_fingerprint;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceLFInfo> {
        public String android_id;
        public String bluetooth_mac_address;
        public String brand;
        public Integer build_time;
        public Integer client_timestamp;
        public String device_name;
        public String freefire_fingerprint;
        public String freefire_user_id;
        public String hardware;
        public String idfa;
        public String idfv;
        public String item_id;
        public String mac_address;
        public String manufacturer;
        public String model;
        public String product;
        public Integer screen_height;
        public Integer screen_width;
        public Long total_memory;
        public Long total_storage;

        public Builder() {
        }

        public Builder(DeviceLFInfo deviceLFInfo) {
            super(deviceLFInfo);
            if (deviceLFInfo != null) {
                this.manufacturer = deviceLFInfo.manufacturer;
                this.model = deviceLFInfo.model;
                this.product = deviceLFInfo.product;
                this.brand = deviceLFInfo.brand;
                this.hardware = deviceLFInfo.hardware;
                this.device_name = deviceLFInfo.device_name;
                this.mac_address = deviceLFInfo.mac_address;
                this.bluetooth_mac_address = deviceLFInfo.bluetooth_mac_address;
                this.idfv = deviceLFInfo.idfv;
                this.idfa = deviceLFInfo.idfa;
                this.android_id = deviceLFInfo.android_id;
                this.build_time = deviceLFInfo.build_time;
                this.total_memory = deviceLFInfo.total_memory;
                this.total_storage = deviceLFInfo.total_storage;
                this.screen_width = deviceLFInfo.screen_width;
                this.screen_height = deviceLFInfo.screen_height;
                this.item_id = deviceLFInfo.item_id;
                this.client_timestamp = deviceLFInfo.client_timestamp;
                this.freefire_user_id = deviceLFInfo.freefire_user_id;
                this.freefire_fingerprint = deviceLFInfo.freefire_fingerprint;
            }
        }

        public Builder manufacturer(String str) {
            this.manufacturer = str;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder product(String str) {
            this.product = str;
            return this;
        }

        public Builder brand(String str) {
            this.brand = str;
            return this;
        }

        public Builder hardware(String str) {
            this.hardware = str;
            return this;
        }

        public Builder device_name(String str) {
            this.device_name = str;
            return this;
        }

        public Builder mac_address(String str) {
            this.mac_address = str;
            return this;
        }

        public Builder bluetooth_mac_address(String str) {
            this.bluetooth_mac_address = str;
            return this;
        }

        public Builder idfv(String str) {
            this.idfv = str;
            return this;
        }

        public Builder idfa(String str) {
            this.idfa = str;
            return this;
        }

        public Builder android_id(String str) {
            this.android_id = str;
            return this;
        }

        public Builder build_time(Integer num) {
            this.build_time = num;
            return this;
        }

        public Builder total_memory(Long l) {
            this.total_memory = l;
            return this;
        }

        public Builder total_storage(Long l) {
            this.total_storage = l;
            return this;
        }

        public Builder screen_width(Integer num) {
            this.screen_width = num;
            return this;
        }

        public Builder screen_height(Integer num) {
            this.screen_height = num;
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

        public Builder freefire_user_id(String str) {
            this.freefire_user_id = str;
            return this;
        }

        public Builder freefire_fingerprint(String str) {
            this.freefire_fingerprint = str;
            return this;
        }

        public DeviceLFInfo build() {
            return new DeviceLFInfo(this);
        }
    }
}
