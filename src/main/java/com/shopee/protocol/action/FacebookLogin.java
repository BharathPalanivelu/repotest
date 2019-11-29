package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class FacebookLogin extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_FB_ACCESS_TOKEN = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHOP_COVER = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 14)
    public final DeviceExt ext;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String fb_access_token;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean is_ghost;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_user_login;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_web;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String shop_cover;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String username;

    public FacebookLogin(String str, String str2, String str3, String str4, Integer num, Boolean bool, String str5, Boolean bool2, f fVar, String str6, String str7, Integer num2, Boolean bool3, DeviceExt deviceExt, String str8, String str9, String str10, Integer num3) {
        this.requestid = str;
        this.fb_access_token = str2;
        this.username = str3;
        this.portrait = str4;
        this.timestamp = num;
        this.is_web = bool;
        this.country = str5;
        this.is_user_login = bool2;
        this.deviceid = fVar;
        this.shop_cover = str6;
        this.email = str7;
        this.appversion = num2;
        this.is_ghost = bool3;
        this.ext = deviceExt;
        this.source = str8;
        this.client_ip = str9;
        this.app_version_name = str10;
        this.platform = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private FacebookLogin(com.shopee.protocol.action.FacebookLogin.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.fb_access_token
            java.lang.String r4 = r0.username
            java.lang.String r5 = r0.portrait
            java.lang.Integer r6 = r0.timestamp
            java.lang.Boolean r7 = r0.is_web
            java.lang.String r8 = r0.country
            java.lang.Boolean r9 = r0.is_user_login
            e.f r10 = r0.deviceid
            java.lang.String r11 = r0.shop_cover
            java.lang.String r12 = r0.email
            java.lang.Integer r13 = r0.appversion
            java.lang.Boolean r14 = r0.is_ghost
            com.shopee.protocol.shop.DeviceExt r15 = r0.ext
            r20 = r1
            java.lang.String r1 = r0.source
            r16 = r1
            java.lang.String r1 = r0.client_ip
            r17 = r1
            java.lang.String r1 = r0.app_version_name
            r18 = r1
            java.lang.Integer r1 = r0.platform
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.FacebookLogin.<init>(com.shopee.protocol.action.FacebookLogin$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FacebookLogin)) {
            return false;
        }
        FacebookLogin facebookLogin = (FacebookLogin) obj;
        if (!equals((Object) this.requestid, (Object) facebookLogin.requestid) || !equals((Object) this.fb_access_token, (Object) facebookLogin.fb_access_token) || !equals((Object) this.username, (Object) facebookLogin.username) || !equals((Object) this.portrait, (Object) facebookLogin.portrait) || !equals((Object) this.timestamp, (Object) facebookLogin.timestamp) || !equals((Object) this.is_web, (Object) facebookLogin.is_web) || !equals((Object) this.country, (Object) facebookLogin.country) || !equals((Object) this.is_user_login, (Object) facebookLogin.is_user_login) || !equals((Object) this.deviceid, (Object) facebookLogin.deviceid) || !equals((Object) this.shop_cover, (Object) facebookLogin.shop_cover) || !equals((Object) this.email, (Object) facebookLogin.email) || !equals((Object) this.appversion, (Object) facebookLogin.appversion) || !equals((Object) this.is_ghost, (Object) facebookLogin.is_ghost) || !equals((Object) this.ext, (Object) facebookLogin.ext) || !equals((Object) this.source, (Object) facebookLogin.source) || !equals((Object) this.client_ip, (Object) facebookLogin.client_ip) || !equals((Object) this.app_version_name, (Object) facebookLogin.app_version_name) || !equals((Object) this.platform, (Object) facebookLogin.platform)) {
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
        String str2 = this.fb_access_token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.username;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.portrait;
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
        String str6 = this.shop_cover;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.email;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num2 = this.appversion;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_ghost;
        int hashCode13 = (hashCode12 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode14 = (hashCode13 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str8 = this.source;
        int hashCode15 = (hashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.client_ip;
        int hashCode16 = (hashCode15 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.app_version_name;
        int hashCode17 = (hashCode16 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num3 = this.platform;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FacebookLogin> {
        public String app_version_name;
        public Integer appversion;
        public String client_ip;
        public String country;
        public f deviceid;
        public String email;
        public DeviceExt ext;
        public String fb_access_token;
        public Boolean is_ghost;
        public Boolean is_user_login;
        public Boolean is_web;
        public Integer platform;
        public String portrait;
        public String requestid;
        public String shop_cover;
        public String source;
        public Integer timestamp;
        public String username;

        public Builder() {
        }

        public Builder(FacebookLogin facebookLogin) {
            super(facebookLogin);
            if (facebookLogin != null) {
                this.requestid = facebookLogin.requestid;
                this.fb_access_token = facebookLogin.fb_access_token;
                this.username = facebookLogin.username;
                this.portrait = facebookLogin.portrait;
                this.timestamp = facebookLogin.timestamp;
                this.is_web = facebookLogin.is_web;
                this.country = facebookLogin.country;
                this.is_user_login = facebookLogin.is_user_login;
                this.deviceid = facebookLogin.deviceid;
                this.shop_cover = facebookLogin.shop_cover;
                this.email = facebookLogin.email;
                this.appversion = facebookLogin.appversion;
                this.is_ghost = facebookLogin.is_ghost;
                this.ext = facebookLogin.ext;
                this.source = facebookLogin.source;
                this.client_ip = facebookLogin.client_ip;
                this.app_version_name = facebookLogin.app_version_name;
                this.platform = facebookLogin.platform;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder fb_access_token(String str) {
            this.fb_access_token = str;
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

        public Builder shop_cover(String str) {
            this.shop_cover = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
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

        public FacebookLogin build() {
            checkRequiredFields();
            return new FacebookLogin(this);
        }
    }
}
