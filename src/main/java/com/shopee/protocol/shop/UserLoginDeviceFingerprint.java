package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserLoginDeviceFingerprint extends Message {
    public static final Integer DEFAULT_DF_HASH = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer df_hash;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserLoginDeviceFingerprint(Long l, Integer num, Integer num2, Integer num3, f fVar) {
        this.id = l;
        this.userid = num;
        this.df_hash = num2;
        this.mtime = num3;
        this.extinfo = fVar;
    }

    private UserLoginDeviceFingerprint(Builder builder) {
        this(builder.id, builder.userid, builder.df_hash, builder.mtime, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLoginDeviceFingerprint)) {
            return false;
        }
        UserLoginDeviceFingerprint userLoginDeviceFingerprint = (UserLoginDeviceFingerprint) obj;
        if (!equals((Object) this.id, (Object) userLoginDeviceFingerprint.id) || !equals((Object) this.userid, (Object) userLoginDeviceFingerprint.userid) || !equals((Object) this.df_hash, (Object) userLoginDeviceFingerprint.df_hash) || !equals((Object) this.mtime, (Object) userLoginDeviceFingerprint.mtime) || !equals((Object) this.extinfo, (Object) userLoginDeviceFingerprint.extinfo)) {
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
        Integer num2 = this.df_hash;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLoginDeviceFingerprint> {
        public Integer df_hash;
        public f extinfo;
        public Long id;
        public Integer mtime;
        public Integer userid;

        public Builder() {
        }

        public Builder(UserLoginDeviceFingerprint userLoginDeviceFingerprint) {
            super(userLoginDeviceFingerprint);
            if (userLoginDeviceFingerprint != null) {
                this.id = userLoginDeviceFingerprint.id;
                this.userid = userLoginDeviceFingerprint.userid;
                this.df_hash = userLoginDeviceFingerprint.df_hash;
                this.mtime = userLoginDeviceFingerprint.mtime;
                this.extinfo = userLoginDeviceFingerprint.extinfo;
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

        public Builder df_hash(Integer num) {
            this.df_hash = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public UserLoginDeviceFingerprint build() {
            return new UserLoginDeviceFingerprint(this);
        }
    }
}
