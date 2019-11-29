package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VcodeLogin extends Message {
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_VCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 7)
    public final DeviceExt ext;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean is_ghost;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String vcode;

    public VcodeLogin(String str, String str2, String str3, String str4, String str5, Boolean bool, DeviceExt deviceExt, String str6, Boolean bool2, String str7, String str8, String str9, String str10) {
        this.requestid = str;
        this.phone = str2;
        this.email = str3;
        this.username = str4;
        this.vcode = str5;
        this.is_web = bool;
        this.ext = deviceExt;
        this.country = str6;
        this.is_ghost = bool2;
        this.source = str7;
        this.otp_seed = str8;
        this.client_ip = str9;
        this.app_version_name = str10;
    }

    private VcodeLogin(Builder builder) {
        this(builder.requestid, builder.phone, builder.email, builder.username, builder.vcode, builder.is_web, builder.ext, builder.country, builder.is_ghost, builder.source, builder.otp_seed, builder.client_ip, builder.app_version_name);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VcodeLogin)) {
            return false;
        }
        VcodeLogin vcodeLogin = (VcodeLogin) obj;
        if (!equals((Object) this.requestid, (Object) vcodeLogin.requestid) || !equals((Object) this.phone, (Object) vcodeLogin.phone) || !equals((Object) this.email, (Object) vcodeLogin.email) || !equals((Object) this.username, (Object) vcodeLogin.username) || !equals((Object) this.vcode, (Object) vcodeLogin.vcode) || !equals((Object) this.is_web, (Object) vcodeLogin.is_web) || !equals((Object) this.ext, (Object) vcodeLogin.ext) || !equals((Object) this.country, (Object) vcodeLogin.country) || !equals((Object) this.is_ghost, (Object) vcodeLogin.is_ghost) || !equals((Object) this.source, (Object) vcodeLogin.source) || !equals((Object) this.otp_seed, (Object) vcodeLogin.otp_seed) || !equals((Object) this.client_ip, (Object) vcodeLogin.client_ip) || !equals((Object) this.app_version_name, (Object) vcodeLogin.app_version_name)) {
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
        String str2 = this.phone;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.email;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.username;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.vcode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool = this.is_web;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode7 = (hashCode6 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str6 = this.country;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_ghost;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str7 = this.source;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.otp_seed;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.client_ip;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.app_version_name;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VcodeLogin> {
        public String app_version_name;
        public String client_ip;
        public String country;
        public String email;
        public DeviceExt ext;
        public Boolean is_ghost;
        public Boolean is_web;
        public String otp_seed;
        public String phone;
        public String requestid;
        public String source;
        public String username;
        public String vcode;

        public Builder() {
        }

        public Builder(VcodeLogin vcodeLogin) {
            super(vcodeLogin);
            if (vcodeLogin != null) {
                this.requestid = vcodeLogin.requestid;
                this.phone = vcodeLogin.phone;
                this.email = vcodeLogin.email;
                this.username = vcodeLogin.username;
                this.vcode = vcodeLogin.vcode;
                this.is_web = vcodeLogin.is_web;
                this.ext = vcodeLogin.ext;
                this.country = vcodeLogin.country;
                this.is_ghost = vcodeLogin.is_ghost;
                this.source = vcodeLogin.source;
                this.otp_seed = vcodeLogin.otp_seed;
                this.client_ip = vcodeLogin.client_ip;
                this.app_version_name = vcodeLogin.app_version_name;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder is_web(Boolean bool) {
            this.is_web = bool;
            return this;
        }

        public Builder ext(DeviceExt deviceExt) {
            this.ext = deviceExt;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder is_ghost(Boolean bool) {
            this.is_ghost = bool;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder app_version_name(String str) {
            this.app_version_name = str;
            return this;
        }

        public VcodeLogin build() {
            return new VcodeLogin(this);
        }
    }
}
