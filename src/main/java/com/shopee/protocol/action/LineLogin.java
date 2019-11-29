package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LineLogin extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final String DEFAULT_LINE_ACCESS_TOKEN = "";
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 7)
    public final DeviceExt ext;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean is_ghost;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean is_user_login;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String line_access_token;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String username;

    public LineLogin(String str, String str2, String str3, String str4, String str5, String str6, DeviceExt deviceExt, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Integer num2, String str7, String str8, String str9, Integer num3) {
        this.requestid = str;
        this.line_access_token = str2;
        this.username = str3;
        this.portrait = str4;
        this.email = str5;
        this.country = str6;
        this.ext = deviceExt;
        this.appversion = num;
        this.is_web = bool;
        this.is_user_login = bool2;
        this.is_ghost = bool3;
        this.timestamp = num2;
        this.source = str7;
        this.client_ip = str8;
        this.app_version_name = str9;
        this.platform = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LineLogin(com.shopee.protocol.action.LineLogin.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.line_access_token
            java.lang.String r4 = r0.username
            java.lang.String r5 = r0.portrait
            java.lang.String r6 = r0.email
            java.lang.String r7 = r0.country
            com.shopee.protocol.shop.DeviceExt r8 = r0.ext
            java.lang.Integer r9 = r0.appversion
            java.lang.Boolean r10 = r0.is_web
            java.lang.Boolean r11 = r0.is_user_login
            java.lang.Boolean r12 = r0.is_ghost
            java.lang.Integer r13 = r0.timestamp
            java.lang.String r14 = r0.source
            java.lang.String r15 = r0.client_ip
            r18 = r1
            java.lang.String r1 = r0.app_version_name
            r16 = r1
            java.lang.Integer r1 = r0.platform
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.LineLogin.<init>(com.shopee.protocol.action.LineLogin$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LineLogin)) {
            return false;
        }
        LineLogin lineLogin = (LineLogin) obj;
        if (!equals((Object) this.requestid, (Object) lineLogin.requestid) || !equals((Object) this.line_access_token, (Object) lineLogin.line_access_token) || !equals((Object) this.username, (Object) lineLogin.username) || !equals((Object) this.portrait, (Object) lineLogin.portrait) || !equals((Object) this.email, (Object) lineLogin.email) || !equals((Object) this.country, (Object) lineLogin.country) || !equals((Object) this.ext, (Object) lineLogin.ext) || !equals((Object) this.appversion, (Object) lineLogin.appversion) || !equals((Object) this.is_web, (Object) lineLogin.is_web) || !equals((Object) this.is_user_login, (Object) lineLogin.is_user_login) || !equals((Object) this.is_ghost, (Object) lineLogin.is_ghost) || !equals((Object) this.timestamp, (Object) lineLogin.timestamp) || !equals((Object) this.source, (Object) lineLogin.source) || !equals((Object) this.client_ip, (Object) lineLogin.client_ip) || !equals((Object) this.app_version_name, (Object) lineLogin.app_version_name) || !equals((Object) this.platform, (Object) lineLogin.platform)) {
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
        String str2 = this.line_access_token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.username;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.portrait;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.email;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.country;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode7 = (hashCode6 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        Integer num = this.appversion;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.is_web;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_user_login;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ghost;
        int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num2 = this.timestamp;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str7 = this.source;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.client_ip;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.app_version_name;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num3 = this.platform;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LineLogin> {
        public String app_version_name;
        public Integer appversion;
        public String client_ip;
        public String country;
        public String email;
        public DeviceExt ext;
        public Boolean is_ghost;
        public Boolean is_user_login;
        public Boolean is_web;
        public String line_access_token;
        public Integer platform;
        public String portrait;
        public String requestid;
        public String source;
        public Integer timestamp;
        public String username;

        public Builder() {
        }

        public Builder(LineLogin lineLogin) {
            super(lineLogin);
            if (lineLogin != null) {
                this.requestid = lineLogin.requestid;
                this.line_access_token = lineLogin.line_access_token;
                this.username = lineLogin.username;
                this.portrait = lineLogin.portrait;
                this.email = lineLogin.email;
                this.country = lineLogin.country;
                this.ext = lineLogin.ext;
                this.appversion = lineLogin.appversion;
                this.is_web = lineLogin.is_web;
                this.is_user_login = lineLogin.is_user_login;
                this.is_ghost = lineLogin.is_ghost;
                this.timestamp = lineLogin.timestamp;
                this.source = lineLogin.source;
                this.client_ip = lineLogin.client_ip;
                this.app_version_name = lineLogin.app_version_name;
                this.platform = lineLogin.platform;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder line_access_token(String str) {
            this.line_access_token = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder ext(DeviceExt deviceExt) {
            this.ext = deviceExt;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder is_web(Boolean bool) {
            this.is_web = bool;
            return this;
        }

        public Builder is_user_login(Boolean bool) {
            this.is_user_login = bool;
            return this;
        }

        public Builder is_ghost(Boolean bool) {
            this.is_ghost = bool;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
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

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public LineLogin build() {
            checkRequiredFields();
            return new LineLogin(this);
        }
    }
}
