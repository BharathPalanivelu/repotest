package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceExtExtinfo extends Message {
    public static final String DEFAULT_OS_VERSION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String os_version;

    public DeviceExtExtinfo(String str) {
        this.os_version = str;
    }

    private DeviceExtExtinfo(Builder builder) {
        this(builder.os_version);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceExtExtinfo)) {
            return false;
        }
        return equals((Object) this.os_version, (Object) ((DeviceExtExtinfo) obj).os_version);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.os_version;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DeviceExtExtinfo> {
        public String os_version;

        public Builder() {
        }

        public Builder(DeviceExtExtinfo deviceExtExtinfo) {
            super(deviceExtExtinfo);
            if (deviceExtExtinfo != null) {
                this.os_version = deviceExtExtinfo.os_version;
            }
        }

        public Builder os_version(String str) {
            this.os_version = str;
            return this;
        }

        public DeviceExtExtinfo build() {
            return new DeviceExtExtinfo(this);
        }
    }
}
