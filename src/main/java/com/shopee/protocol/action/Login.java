package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Login extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_OTP_TOKEN = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 14)
    public final DeviceExt ext;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean is_ghost;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_user_login;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String otp_token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String username;

    public Login(String str, String str2, String str3, String str4, Integer num, Boolean bool, String str5, Boolean bool2, f fVar, String str6, Integer num2, String str7, Boolean bool3, DeviceExt deviceExt, String str8, String str9, String str10, String str11, String str12, Integer num3) {
        this.requestid = str;
        this.phone = str2;
        this.email = str3;
        this.password = str4;
        this.timestamp = num;
        this.is_web = bool;
        this.country = str5;
        this.is_user_login = bool2;
        this.deviceid = fVar;
        this.username = str6;
        this.appversion = num2;
        this.token = str7;
        this.is_ghost = bool3;
        this.ext = deviceExt;
        this.client_ip = str8;
        this.source = str9;
        this.otp_token = str10;
        this.otp_seed = str11;
        this.app_version_name = str12;
        this.platform = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Login(com.shopee.protocol.action.Login.Builder r24) {
        /*
            r23 = this;
            r0 = r24
            r1 = r23
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.phone
            java.lang.String r4 = r0.email
            java.lang.String r5 = r0.password
            java.lang.Integer r6 = r0.timestamp
            java.lang.Boolean r7 = r0.is_web
            java.lang.String r8 = r0.country
            java.lang.Boolean r9 = r0.is_user_login
            e.f r10 = r0.deviceid
            java.lang.String r11 = r0.username
            java.lang.Integer r12 = r0.appversion
            java.lang.String r13 = r0.token
            java.lang.Boolean r14 = r0.is_ghost
            com.shopee.protocol.shop.DeviceExt r15 = r0.ext
            r22 = r1
            java.lang.String r1 = r0.client_ip
            r16 = r1
            java.lang.String r1 = r0.source
            r17 = r1
            java.lang.String r1 = r0.otp_token
            r18 = r1
            java.lang.String r1 = r0.otp_seed
            r19 = r1
            java.lang.String r1 = r0.app_version_name
            r20 = r1
            java.lang.Integer r1 = r0.platform
            r21 = r1
            r1 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r23.setBuilder(r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.Login.<init>(com.shopee.protocol.action.Login$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Login)) {
            return false;
        }
        Login login = (Login) obj;
        if (!equals((Object) this.requestid, (Object) login.requestid) || !equals((Object) this.phone, (Object) login.phone) || !equals((Object) this.email, (Object) login.email) || !equals((Object) this.password, (Object) login.password) || !equals((Object) this.timestamp, (Object) login.timestamp) || !equals((Object) this.is_web, (Object) login.is_web) || !equals((Object) this.country, (Object) login.country) || !equals((Object) this.is_user_login, (Object) login.is_user_login) || !equals((Object) this.deviceid, (Object) login.deviceid) || !equals((Object) this.username, (Object) login.username) || !equals((Object) this.appversion, (Object) login.appversion) || !equals((Object) this.token, (Object) login.token) || !equals((Object) this.is_ghost, (Object) login.is_ghost) || !equals((Object) this.ext, (Object) login.ext) || !equals((Object) this.client_ip, (Object) login.client_ip) || !equals((Object) this.source, (Object) login.source) || !equals((Object) this.otp_token, (Object) login.otp_token) || !equals((Object) this.otp_seed, (Object) login.otp_seed) || !equals((Object) this.app_version_name, (Object) login.app_version_name) || !equals((Object) this.platform, (Object) login.platform)) {
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
        String str4 = this.password;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.is_web;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_user_login;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str6 = this.username;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num2 = this.appversion;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str7 = this.token;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ghost;
        int hashCode13 = (hashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode14 = (hashCode13 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str8 = this.client_ip;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.source;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.otp_token;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.otp_seed;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.app_version_name;
        int hashCode19 = (hashCode18 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num3 = this.platform;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode19 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Login> {
        public String app_version_name;
        public Integer appversion;
        public String client_ip;
        public String country;
        public f deviceid;
        public String email;
        public DeviceExt ext;
        public Boolean is_ghost;
        public Boolean is_user_login;
        public Boolean is_web;
        public String otp_seed;
        public String otp_token;
        public String password;
        public String phone;
        public Integer platform;
        public String requestid;
        public String source;
        public Integer timestamp;
        public String token;
        public String username;

        public Builder() {
        }

        public Builder(Login login) {
            super(login);
            if (login != null) {
                this.requestid = login.requestid;
                this.phone = login.phone;
                this.email = login.email;
                this.password = login.password;
                this.timestamp = login.timestamp;
                this.is_web = login.is_web;
                this.country = login.country;
                this.is_user_login = login.is_user_login;
                this.deviceid = login.deviceid;
                this.username = login.username;
                this.appversion = login.appversion;
                this.token = login.token;
                this.is_ghost = login.is_ghost;
                this.ext = login.ext;
                this.client_ip = login.client_ip;
                this.source = login.source;
                this.otp_token = login.otp_token;
                this.otp_seed = login.otp_seed;
                this.app_version_name = login.app_version_name;
                this.platform = login.platform;
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

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder is_web(Boolean bool) {
            this.is_web = bool;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder is_user_login(Boolean bool) {
            this.is_user_login = bool;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder is_ghost(Boolean bool) {
            this.is_ghost = bool;
            return this;
        }

        public Builder ext(DeviceExt deviceExt) {
            this.ext = deviceExt;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder otp_token(String str) {
            this.otp_token = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder app_version_name(String str) {
            this.app_version_name = str;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Login build() {
            checkRequiredFields();
            return new Login(this);
        }
    }
}
