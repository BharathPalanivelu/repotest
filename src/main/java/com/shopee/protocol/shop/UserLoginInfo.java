package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class UserLoginInfo extends Message {
    public static final Integer DEFAULT_APP_VERSION = 0;
    public static final Long DEFAULT_CLIKEY = 0L;
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_NEW_SOURCE = "";
    public static final Boolean DEFAULT_PUSH_READY = false;
    public static final String DEFAULT_SERVER_ADDR = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer app_version;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long clikey;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String new_source;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean push_ready;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String server_addr;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public UserLoginInfo(Integer num, String str, Integer num2, Long l, Integer num3, Boolean bool, String str2, f fVar, Integer num4, String str3, String str4) {
        this.userid = num;
        this.server_addr = str;
        this.timestamp = num2;
        this.clikey = l;
        this.shopid = num3;
        this.push_ready = bool;
        this.country = str2;
        this.deviceid = fVar;
        this.app_version = num4;
        this.source = str3;
        this.new_source = str4;
    }

    private UserLoginInfo(Builder builder) {
        this(builder.userid, builder.server_addr, builder.timestamp, builder.clikey, builder.shopid, builder.push_ready, builder.country, builder.deviceid, builder.app_version, builder.source, builder.new_source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLoginInfo)) {
            return false;
        }
        UserLoginInfo userLoginInfo = (UserLoginInfo) obj;
        if (!equals((Object) this.userid, (Object) userLoginInfo.userid) || !equals((Object) this.server_addr, (Object) userLoginInfo.server_addr) || !equals((Object) this.timestamp, (Object) userLoginInfo.timestamp) || !equals((Object) this.clikey, (Object) userLoginInfo.clikey) || !equals((Object) this.shopid, (Object) userLoginInfo.shopid) || !equals((Object) this.push_ready, (Object) userLoginInfo.push_ready) || !equals((Object) this.country, (Object) userLoginInfo.country) || !equals((Object) this.deviceid, (Object) userLoginInfo.deviceid) || !equals((Object) this.app_version, (Object) userLoginInfo.app_version) || !equals((Object) this.source, (Object) userLoginInfo.source) || !equals((Object) this.new_source, (Object) userLoginInfo.new_source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.server_addr;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.clikey;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.shopid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.push_ready;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num4 = this.app_version;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.source;
        int hashCode10 = (hashCode9 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.new_source;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLoginInfo> {
        public Integer app_version;
        public Long clikey;
        public String country;
        public f deviceid;
        public String new_source;
        public Boolean push_ready;
        public String server_addr;
        public Integer shopid;
        public String source;
        public Integer timestamp;
        public Integer userid;

        public Builder() {
        }

        public Builder(UserLoginInfo userLoginInfo) {
            super(userLoginInfo);
            if (userLoginInfo != null) {
                this.userid = userLoginInfo.userid;
                this.server_addr = userLoginInfo.server_addr;
                this.timestamp = userLoginInfo.timestamp;
                this.clikey = userLoginInfo.clikey;
                this.shopid = userLoginInfo.shopid;
                this.push_ready = userLoginInfo.push_ready;
                this.country = userLoginInfo.country;
                this.deviceid = userLoginInfo.deviceid;
                this.app_version = userLoginInfo.app_version;
                this.source = userLoginInfo.source;
                this.new_source = userLoginInfo.new_source;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder server_addr(String str) {
            this.server_addr = str;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder clikey(Long l) {
            this.clikey = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder push_ready(Boolean bool) {
            this.push_ready = bool;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder app_version(Integer num) {
            this.app_version = num;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder new_source(String str) {
            this.new_source = str;
            return this;
        }

        public UserLoginInfo build() {
            return new UserLoginInfo(this);
        }
    }
}
