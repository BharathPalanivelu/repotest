package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DeviceExtinfo extends Message {
    public static final String DEFAULT_GCM_SUBSCRIPTION = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String gcm_subscription;

    public DeviceExtinfo(String str) {
        this.gcm_subscription = str;
    }

    private DeviceExtinfo(Builder builder) {
        this(builder.gcm_subscription);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceExtinfo)) {
            return false;
        }
        return equals((Object) this.gcm_subscription, (Object) ((DeviceExtinfo) obj).gcm_subscription);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.gcm_subscription;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DeviceExtinfo> {
        public String gcm_subscription;

        public Builder() {
        }

        public Builder(DeviceExtinfo deviceExtinfo) {
            super(deviceExtinfo);
            if (deviceExtinfo != null) {
                this.gcm_subscription = deviceExtinfo.gcm_subscription;
            }
        }

        public Builder gcm_subscription(String str) {
            this.gcm_subscription = str;
            return this;
        }

        public DeviceExtinfo build() {
            return new DeviceExtinfo(this);
        }
    }
}
