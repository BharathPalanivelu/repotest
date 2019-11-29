package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestAppleLogin extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_AUTHORIZATION_CODE = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final String DEFAULT_IDENTITY_TOKEN = "";
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String authorization_code;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 14)
    public final DeviceExt ext;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String identity_token;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_user_login;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String source;

    public RequestAppleLogin(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Integer num, String str5, String str6, String str7, Integer num2, DeviceExt deviceExt, String str8) {
        this.requestid = str;
        this.authorization_code = str2;
        this.identity_token = str3;
        this.country = str4;
        this.is_web = bool;
        this.is_user_login = bool2;
        this.appversion = num;
        this.app_version_name = str5;
        this.client_ip = str6;
        this.source = str7;
        this.platform = num2;
        this.ext = deviceExt;
        this.err_message = str8;
    }

    private RequestAppleLogin(Builder builder) {
        this(builder.requestid, builder.authorization_code, builder.identity_token, builder.country, builder.is_web, builder.is_user_login, builder.appversion, builder.app_version_name, builder.client_ip, builder.source, builder.platform, builder.ext, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestAppleLogin)) {
            return false;
        }
        RequestAppleLogin requestAppleLogin = (RequestAppleLogin) obj;
        if (!equals((Object) this.requestid, (Object) requestAppleLogin.requestid) || !equals((Object) this.authorization_code, (Object) requestAppleLogin.authorization_code) || !equals((Object) this.identity_token, (Object) requestAppleLogin.identity_token) || !equals((Object) this.country, (Object) requestAppleLogin.country) || !equals((Object) this.is_web, (Object) requestAppleLogin.is_web) || !equals((Object) this.is_user_login, (Object) requestAppleLogin.is_user_login) || !equals((Object) this.appversion, (Object) requestAppleLogin.appversion) || !equals((Object) this.app_version_name, (Object) requestAppleLogin.app_version_name) || !equals((Object) this.client_ip, (Object) requestAppleLogin.client_ip) || !equals((Object) this.source, (Object) requestAppleLogin.source) || !equals((Object) this.platform, (Object) requestAppleLogin.platform) || !equals((Object) this.ext, (Object) requestAppleLogin.ext) || !equals((Object) this.err_message, (Object) requestAppleLogin.err_message)) {
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
        String str2 = this.authorization_code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.identity_token;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.country;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.is_web;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_user_login;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num = this.appversion;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        String str5 = this.app_version_name;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.client_ip;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.source;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num2 = this.platform;
        int hashCode11 = (hashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode12 = (hashCode11 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str8 = this.err_message;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestAppleLogin> {
        public String app_version_name;
        public Integer appversion;
        public String authorization_code;
        public String client_ip;
        public String country;
        public String err_message;
        public DeviceExt ext;
        public String identity_token;
        public Boolean is_user_login;
        public Boolean is_web;
        public Integer platform;
        public String requestid;
        public String source;

        public Builder() {
        }

        public Builder(RequestAppleLogin requestAppleLogin) {
            super(requestAppleLogin);
            if (requestAppleLogin != null) {
                this.requestid = requestAppleLogin.requestid;
                this.authorization_code = requestAppleLogin.authorization_code;
                this.identity_token = requestAppleLogin.identity_token;
                this.country = requestAppleLogin.country;
                this.is_web = requestAppleLogin.is_web;
                this.is_user_login = requestAppleLogin.is_user_login;
                this.appversion = requestAppleLogin.appversion;
                this.app_version_name = requestAppleLogin.app_version_name;
                this.client_ip = requestAppleLogin.client_ip;
                this.source = requestAppleLogin.source;
                this.platform = requestAppleLogin.platform;
                this.ext = requestAppleLogin.ext;
                this.err_message = requestAppleLogin.err_message;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder authorization_code(String str) {
            this.authorization_code = str;
            return this;
        }

        public Builder identity_token(String str) {
            this.identity_token = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
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

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public Builder app_version_name(String str) {
            this.app_version_name = str;
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

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder ext(DeviceExt deviceExt) {
            this.ext = deviceExt;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public RequestAppleLogin build() {
            return new RequestAppleLogin(this);
        }
    }
}
