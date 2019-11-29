package com.shopee.protocol.action;

import com.shopee.protocol.shop.Device;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RegisterDevice extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final Device device;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RegisterDevice(String str, Device device2) {
        this.requestid = str;
        this.device = device2;
    }

    private RegisterDevice(Builder builder) {
        this(builder.requestid, builder.device);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegisterDevice)) {
            return false;
        }
        RegisterDevice registerDevice = (RegisterDevice) obj;
        if (!equals((Object) this.requestid, (Object) registerDevice.requestid) || !equals((Object) this.device, (Object) registerDevice.device)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Device device2 = this.device;
        if (device2 != null) {
            i2 = device2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RegisterDevice> {
        public Device device;
        public String requestid;

        public Builder() {
        }

        public Builder(RegisterDevice registerDevice) {
            super(registerDevice);
            if (registerDevice != null) {
                this.requestid = registerDevice.requestid;
                this.device = registerDevice.device;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder device(Device device2) {
            this.device = device2;
            return this;
        }

        public RegisterDevice build() {
            return new RegisterDevice(this);
        }
    }
}
