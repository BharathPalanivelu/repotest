package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserLoginRecord extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_IP = "";
    public static final Boolean DEFAULT_IS_EMULATOR = false;
    public static final Integer DEFAULT_LAST_LOGIN = 0;
    public static final String DEFAULT_LOGIN_FROM = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String ip;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_emulator;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer last_login;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String login_from;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserLoginRecord(Long l, Integer num, String str, String str2, String str3, f fVar, Integer num2, Boolean bool, String str4) {
        this.id = l;
        this.userid = num;
        this.country = str;
        this.ip = str2;
        this.login_from = str3;
        this.deviceid = fVar;
        this.last_login = num2;
        this.is_emulator = bool;
        this.source = str4;
    }

    private UserLoginRecord(Builder builder) {
        this(builder.id, builder.userid, builder.country, builder.ip, builder.login_from, builder.deviceid, builder.last_login, builder.is_emulator, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLoginRecord)) {
            return false;
        }
        UserLoginRecord userLoginRecord = (UserLoginRecord) obj;
        if (!equals((Object) this.id, (Object) userLoginRecord.id) || !equals((Object) this.userid, (Object) userLoginRecord.userid) || !equals((Object) this.country, (Object) userLoginRecord.country) || !equals((Object) this.ip, (Object) userLoginRecord.ip) || !equals((Object) this.login_from, (Object) userLoginRecord.login_from) || !equals((Object) this.deviceid, (Object) userLoginRecord.deviceid) || !equals((Object) this.last_login, (Object) userLoginRecord.last_login) || !equals((Object) this.is_emulator, (Object) userLoginRecord.is_emulator) || !equals((Object) this.source, (Object) userLoginRecord.source)) {
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
        String str = this.country;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.ip;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.login_from;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.last_login;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_emulator;
        int hashCode8 = (hashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.source;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLoginRecord> {
        public String country;
        public f deviceid;
        public Long id;
        public String ip;
        public Boolean is_emulator;
        public Integer last_login;
        public String login_from;
        public String source;
        public Integer userid;

        public Builder() {
        }

        public Builder(UserLoginRecord userLoginRecord) {
            super(userLoginRecord);
            if (userLoginRecord != null) {
                this.id = userLoginRecord.id;
                this.userid = userLoginRecord.userid;
                this.country = userLoginRecord.country;
                this.ip = userLoginRecord.ip;
                this.login_from = userLoginRecord.login_from;
                this.deviceid = userLoginRecord.deviceid;
                this.last_login = userLoginRecord.last_login;
                this.is_emulator = userLoginRecord.is_emulator;
                this.source = userLoginRecord.source;
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

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ip(String str) {
            this.ip = str;
            return this;
        }

        public Builder login_from(String str) {
            this.login_from = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder last_login(Integer num) {
            this.last_login = num;
            return this;
        }

        public Builder is_emulator(Boolean bool) {
            this.is_emulator = bool;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public UserLoginRecord build() {
            return new UserLoginRecord(this);
        }
    }
}
