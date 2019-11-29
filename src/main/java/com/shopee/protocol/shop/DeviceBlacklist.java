package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class DeviceBlacklist extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public DeviceBlacklist(Long l, f fVar, String str, Integer num, Integer num2) {
        this.id = l;
        this.deviceid = fVar;
        this.country = str;
        this.mtime = num;
        this.status = num2;
    }

    private DeviceBlacklist(Builder builder) {
        this(builder.id, builder.deviceid, builder.country, builder.mtime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceBlacklist)) {
            return false;
        }
        DeviceBlacklist deviceBlacklist = (DeviceBlacklist) obj;
        if (!equals((Object) this.id, (Object) deviceBlacklist.id) || !equals((Object) this.deviceid, (Object) deviceBlacklist.deviceid) || !equals((Object) this.country, (Object) deviceBlacklist.country) || !equals((Object) this.mtime, (Object) deviceBlacklist.mtime) || !equals((Object) this.status, (Object) deviceBlacklist.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        f fVar = this.deviceid;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.mtime;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceBlacklist> {
        public String country;
        public f deviceid;
        public Long id;
        public Integer mtime;
        public Integer status;

        public Builder() {
        }

        public Builder(DeviceBlacklist deviceBlacklist) {
            super(deviceBlacklist);
            if (deviceBlacklist != null) {
                this.id = deviceBlacklist.id;
                this.deviceid = deviceBlacklist.deviceid;
                this.country = deviceBlacklist.country;
                this.mtime = deviceBlacklist.mtime;
                this.status = deviceBlacklist.status;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public DeviceBlacklist build() {
            return new DeviceBlacklist(this);
        }
    }
}
