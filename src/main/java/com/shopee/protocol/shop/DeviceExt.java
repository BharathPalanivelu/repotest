package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class DeviceExt extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_DEVICE_FINGERPRINT = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final f DEFAULT_FINGERPRINT_BEFORE_TEMPER = f.f32736b;
    public static final f DEFAULT_HASHED_DF_BEFORE_TEMPER = f.f32736b;
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Boolean DEFAULT_IS_FINGERPRINT_TEMPERED = false;
    public static final Boolean DEFAULT_IS_ROOTED = false;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USER_AGENT = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f device_fingerprint;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 13, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 11, type = Message.Datatype.BYTES)
    public final f fingerprint_before_temper;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f hashed_df_before_temper;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean is_fingerprint_tempered;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean is_rooted;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String user_agent;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public DeviceExt(Long l, Integer num, f fVar, f fVar2, String str, Integer num2, Integer num3, f fVar3, Boolean bool, Boolean bool2, f fVar4, f fVar5, f fVar6) {
        this.id = l;
        this.userid = num;
        this.deviceid = fVar;
        this.device_fingerprint = fVar2;
        this.user_agent = str;
        this.ctime = num2;
        this.mtime = num3;
        this.hashed_fingerprint = fVar3;
        this.is_rooted = bool;
        this.is_fingerprint_tempered = bool2;
        this.fingerprint_before_temper = fVar4;
        this.hashed_df_before_temper = fVar5;
        this.extinfo = fVar6;
    }

    private DeviceExt(Builder builder) {
        this(builder.id, builder.userid, builder.deviceid, builder.device_fingerprint, builder.user_agent, builder.ctime, builder.mtime, builder.hashed_fingerprint, builder.is_rooted, builder.is_fingerprint_tempered, builder.fingerprint_before_temper, builder.hashed_df_before_temper, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceExt)) {
            return false;
        }
        DeviceExt deviceExt = (DeviceExt) obj;
        if (!equals((Object) this.id, (Object) deviceExt.id) || !equals((Object) this.userid, (Object) deviceExt.userid) || !equals((Object) this.deviceid, (Object) deviceExt.deviceid) || !equals((Object) this.device_fingerprint, (Object) deviceExt.device_fingerprint) || !equals((Object) this.user_agent, (Object) deviceExt.user_agent) || !equals((Object) this.ctime, (Object) deviceExt.ctime) || !equals((Object) this.mtime, (Object) deviceExt.mtime) || !equals((Object) this.hashed_fingerprint, (Object) deviceExt.hashed_fingerprint) || !equals((Object) this.is_rooted, (Object) deviceExt.is_rooted) || !equals((Object) this.is_fingerprint_tempered, (Object) deviceExt.is_fingerprint_tempered) || !equals((Object) this.fingerprint_before_temper, (Object) deviceExt.fingerprint_before_temper) || !equals((Object) this.hashed_df_before_temper, (Object) deviceExt.hashed_df_before_temper) || !equals((Object) this.extinfo, (Object) deviceExt.extinfo)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.device_fingerprint;
        int hashCode4 = (hashCode3 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        String str = this.user_agent;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar3 = this.hashed_fingerprint;
        int hashCode8 = (hashCode7 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        Boolean bool = this.is_rooted;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_fingerprint_tempered;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        f fVar4 = this.fingerprint_before_temper;
        int hashCode11 = (hashCode10 + (fVar4 != null ? fVar4.hashCode() : 0)) * 37;
        f fVar5 = this.hashed_df_before_temper;
        int hashCode12 = (hashCode11 + (fVar5 != null ? fVar5.hashCode() : 0)) * 37;
        f fVar6 = this.extinfo;
        if (fVar6 != null) {
            i2 = fVar6.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DeviceExt> {
        public Integer ctime;
        public f device_fingerprint;
        public f deviceid;
        public f extinfo;
        public f fingerprint_before_temper;
        public f hashed_df_before_temper;
        public f hashed_fingerprint;
        public Long id;
        public Boolean is_fingerprint_tempered;
        public Boolean is_rooted;
        public Integer mtime;
        public String user_agent;
        public Integer userid;

        public Builder() {
        }

        public Builder(DeviceExt deviceExt) {
            super(deviceExt);
            if (deviceExt != null) {
                this.id = deviceExt.id;
                this.userid = deviceExt.userid;
                this.deviceid = deviceExt.deviceid;
                this.device_fingerprint = deviceExt.device_fingerprint;
                this.user_agent = deviceExt.user_agent;
                this.ctime = deviceExt.ctime;
                this.mtime = deviceExt.mtime;
                this.hashed_fingerprint = deviceExt.hashed_fingerprint;
                this.is_rooted = deviceExt.is_rooted;
                this.is_fingerprint_tempered = deviceExt.is_fingerprint_tempered;
                this.fingerprint_before_temper = deviceExt.fingerprint_before_temper;
                this.hashed_df_before_temper = deviceExt.hashed_df_before_temper;
                this.extinfo = deviceExt.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder device_fingerprint(f fVar) {
            this.device_fingerprint = fVar;
            return this;
        }

        public Builder user_agent(String str) {
            this.user_agent = str;
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

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public Builder is_rooted(Boolean bool) {
            this.is_rooted = bool;
            return this;
        }

        public Builder is_fingerprint_tempered(Boolean bool) {
            this.is_fingerprint_tempered = bool;
            return this;
        }

        public Builder fingerprint_before_temper(f fVar) {
            this.fingerprint_before_temper = fVar;
            return this;
        }

        public Builder hashed_df_before_temper(f fVar) {
            this.hashed_df_before_temper = fVar;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public DeviceExt build() {
            return new DeviceExt(this);
        }
    }
}
