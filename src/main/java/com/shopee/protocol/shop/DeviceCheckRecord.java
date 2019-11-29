package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class DeviceCheckRecord extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer userid;

    public DeviceCheckRecord(Long l, f fVar, Integer num, String str, Integer num2, Integer num3) {
        this.id = l;
        this.deviceid = fVar;
        this.userid = num;
        this.country = str;
        this.type = num2;
        this.mtime = num3;
    }

    private DeviceCheckRecord(Builder builder) {
        this(builder.id, builder.deviceid, builder.userid, builder.country, builder.type, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceCheckRecord)) {
            return false;
        }
        DeviceCheckRecord deviceCheckRecord = (DeviceCheckRecord) obj;
        if (!equals((Object) this.id, (Object) deviceCheckRecord.id) || !equals((Object) this.deviceid, (Object) deviceCheckRecord.deviceid) || !equals((Object) this.userid, (Object) deviceCheckRecord.userid) || !equals((Object) this.country, (Object) deviceCheckRecord.country) || !equals((Object) this.type, (Object) deviceCheckRecord.type) || !equals((Object) this.mtime, (Object) deviceCheckRecord.mtime)) {
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
        Integer num = this.userid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.country;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceCheckRecord> {
        public String country;
        public f deviceid;
        public Long id;
        public Integer mtime;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(DeviceCheckRecord deviceCheckRecord) {
            super(deviceCheckRecord);
            if (deviceCheckRecord != null) {
                this.id = deviceCheckRecord.id;
                this.deviceid = deviceCheckRecord.deviceid;
                this.userid = deviceCheckRecord.userid;
                this.country = deviceCheckRecord.country;
                this.type = deviceCheckRecord.type;
                this.mtime = deviceCheckRecord.mtime;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public DeviceCheckRecord build() {
            return new DeviceCheckRecord(this);
        }
    }
}
