package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Device extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Integer DEFAULT_DEVICE_HASH = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_MACHINE_CODE = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final f DEFAULT_PN_TOKEN = f.f32736b;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer device_hash;
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String machine_code;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f pn_token;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer userid;

    public Device(f fVar, f fVar2, Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, f fVar3, Integer num5, Long l) {
        this.deviceid = fVar;
        this.pn_token = fVar2;
        this.ctime = num;
        this.mtime = num2;
        this.device_hash = num3;
        this.appversion = num4;
        this.country = str;
        this.machine_code = str2;
        this.extinfo = fVar3;
        this.userid = num5;
        this.id = l;
    }

    private Device(Builder builder) {
        this(builder.deviceid, builder.pn_token, builder.ctime, builder.mtime, builder.device_hash, builder.appversion, builder.country, builder.machine_code, builder.extinfo, builder.userid, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        if (!equals((Object) this.deviceid, (Object) device.deviceid) || !equals((Object) this.pn_token, (Object) device.pn_token) || !equals((Object) this.ctime, (Object) device.ctime) || !equals((Object) this.mtime, (Object) device.mtime) || !equals((Object) this.device_hash, (Object) device.device_hash) || !equals((Object) this.appversion, (Object) device.appversion) || !equals((Object) this.country, (Object) device.country) || !equals((Object) this.machine_code, (Object) device.machine_code) || !equals((Object) this.extinfo, (Object) device.extinfo) || !equals((Object) this.userid, (Object) device.userid) || !equals((Object) this.id, (Object) device.id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        f fVar = this.deviceid;
        int i2 = 0;
        int hashCode = (fVar != null ? fVar.hashCode() : 0) * 37;
        f fVar2 = this.pn_token;
        int hashCode2 = (hashCode + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num = this.ctime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.device_hash;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.appversion;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.machine_code;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar3 = this.extinfo;
        int hashCode9 = (hashCode8 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Integer num5 = this.userid;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l = this.id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Device> {
        public Integer appversion;
        public String country;
        public Integer ctime;
        public Integer device_hash;
        public f deviceid;
        public f extinfo;
        public Long id;
        public String machine_code;
        public Integer mtime;
        public f pn_token;
        public Integer userid;

        public Builder() {
        }

        public Builder(Device device) {
            super(device);
            if (device != null) {
                this.deviceid = device.deviceid;
                this.pn_token = device.pn_token;
                this.ctime = device.ctime;
                this.mtime = device.mtime;
                this.device_hash = device.device_hash;
                this.appversion = device.appversion;
                this.country = device.country;
                this.machine_code = device.machine_code;
                this.extinfo = device.extinfo;
                this.userid = device.userid;
                this.id = device.id;
            }
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder pn_token(f fVar) {
            this.pn_token = fVar;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder device_hash(Integer num) {
            this.device_hash = num;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder machine_code(String str) {
            this.machine_code = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Device build() {
            return new Device(this);
        }
    }
}
