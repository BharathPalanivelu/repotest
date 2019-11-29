package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SetDeviceRecord extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;

    public SetDeviceRecord(String str, f fVar, Integer num, String str2) {
        this.requestid = str;
        this.deviceid = fVar;
        this.status = num;
        this.country = str2;
    }

    private SetDeviceRecord(Builder builder) {
        this(builder.requestid, builder.deviceid, builder.status, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetDeviceRecord)) {
            return false;
        }
        SetDeviceRecord setDeviceRecord = (SetDeviceRecord) obj;
        if (!equals((Object) this.requestid, (Object) setDeviceRecord.requestid) || !equals((Object) this.deviceid, (Object) setDeviceRecord.deviceid) || !equals((Object) this.status, (Object) setDeviceRecord.status) || !equals((Object) this.country, (Object) setDeviceRecord.country)) {
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
        f fVar = this.deviceid;
        int hashCode2 = (hashCode + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.country;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetDeviceRecord> {
        public String country;
        public f deviceid;
        public String requestid;
        public Integer status;

        public Builder() {
        }

        public Builder(SetDeviceRecord setDeviceRecord) {
            super(setDeviceRecord);
            if (setDeviceRecord != null) {
                this.requestid = setDeviceRecord.requestid;
                this.deviceid = setDeviceRecord.deviceid;
                this.status = setDeviceRecord.status;
                this.country = setDeviceRecord.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SetDeviceRecord build() {
            return new SetDeviceRecord(this);
        }
    }
}
