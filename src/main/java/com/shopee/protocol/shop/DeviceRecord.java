package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class DeviceRecord extends Message {
    public static final f DEFAULT_CHECKOUT_RECORD = f.f32736b;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_LOGIN_RECORD = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f checkout_record;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f login_record;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer status;

    public DeviceRecord(Long l, f fVar, String str, Integer num, Integer num2, f fVar2, f fVar3) {
        this.id = l;
        this.deviceid = fVar;
        this.country = str;
        this.mtime = num;
        this.status = num2;
        this.login_record = fVar2;
        this.checkout_record = fVar3;
    }

    private DeviceRecord(Builder builder) {
        this(builder.id, builder.deviceid, builder.country, builder.mtime, builder.status, builder.login_record, builder.checkout_record);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceRecord)) {
            return false;
        }
        DeviceRecord deviceRecord = (DeviceRecord) obj;
        if (!equals((Object) this.id, (Object) deviceRecord.id) || !equals((Object) this.deviceid, (Object) deviceRecord.deviceid) || !equals((Object) this.country, (Object) deviceRecord.country) || !equals((Object) this.mtime, (Object) deviceRecord.mtime) || !equals((Object) this.status, (Object) deviceRecord.status) || !equals((Object) this.login_record, (Object) deviceRecord.login_record) || !equals((Object) this.checkout_record, (Object) deviceRecord.checkout_record)) {
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
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar2 = this.login_record;
        int hashCode6 = (hashCode5 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.checkout_record;
        if (fVar3 != null) {
            i2 = fVar3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceRecord> {
        public f checkout_record;
        public String country;
        public f deviceid;
        public Long id;
        public f login_record;
        public Integer mtime;
        public Integer status;

        public Builder() {
        }

        public Builder(DeviceRecord deviceRecord) {
            super(deviceRecord);
            if (deviceRecord != null) {
                this.id = deviceRecord.id;
                this.deviceid = deviceRecord.deviceid;
                this.country = deviceRecord.country;
                this.mtime = deviceRecord.mtime;
                this.status = deviceRecord.status;
                this.login_record = deviceRecord.login_record;
                this.checkout_record = deviceRecord.checkout_record;
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

        public Builder login_record(f fVar) {
            this.login_record = fVar;
            return this;
        }

        public Builder checkout_record(f fVar) {
            this.checkout_record = fVar;
            return this;
        }

        public DeviceRecord build() {
            return new DeviceRecord(this);
        }
    }
}
