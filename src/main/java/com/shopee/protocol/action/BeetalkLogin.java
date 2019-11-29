package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class BeetalkLogin extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_BK_ACCESS_TOKEN = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final Boolean DEFAULT_IS_WEB = false;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SHOP_COVER = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String bk_access_token;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 14)
    public final DeviceExt ext;
    @ProtoField(tag = 13, type = Message.Datatype.BOOL)
    public final Boolean is_ghost;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_user_login;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean is_web;
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

    public BeetalkLogin(String str, String str2, String str3, String str4, Integer num, Boolean bool, String str5, Boolean bool2, f fVar, String str6, String str7, Integer num2, Boolean bool3, DeviceExt deviceExt, String str8) {
        this.requestid = str;
        this.bk_access_token = str2;
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
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BeetalkLogin(com.shopee.protocol.action.BeetalkLogin.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.bk_access_token
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
            java.lang.String r1 = r0.source
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.BeetalkLogin.<init>(com.shopee.protocol.action.BeetalkLogin$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BeetalkLogin)) {
            return false;
        }
        BeetalkLogin beetalkLogin = (BeetalkLogin) obj;
        if (!equals((Object) this.requestid, (Object) beetalkLogin.requestid) || !equals((Object) this.bk_access_token, (Object) beetalkLogin.bk_access_token) || !equals((Object) this.username, (Object) beetalkLogin.username) || !equals((Object) this.portrait, (Object) beetalkLogin.portrait) || !equals((Object) this.timestamp, (Object) beetalkLogin.timestamp) || !equals((Object) this.is_web, (Object) beetalkLogin.is_web) || !equals((Object) this.country, (Object) beetalkLogin.country) || !equals((Object) this.is_user_login, (Object) beetalkLogin.is_user_login) || !equals((Object) this.deviceid, (Object) beetalkLogin.deviceid) || !equals((Object) this.shop_cover, (Object) beetalkLogin.shop_cover) || !equals((Object) this.email, (Object) beetalkLogin.email) || !equals((Object) this.appversion, (Object) beetalkLogin.appversion) || !equals((Object) this.is_ghost, (Object) beetalkLogin.is_ghost) || !equals((Object) this.ext, (Object) beetalkLogin.ext) || !equals((Object) this.source, (Object) beetalkLogin.source)) {
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
        String str2 = this.bk_access_token;
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
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BeetalkLogin> {
        public Integer appversion;
        public String bk_access_token;
        public String country;
        public f deviceid;
        public String email;
        public DeviceExt ext;
        public Boolean is_ghost;
        public Boolean is_user_login;
        public Boolean is_web;
        public String portrait;
        public String requestid;
        public String shop_cover;
        public String source;
        public Integer timestamp;
        public String username;

        public Builder() {
        }

        public Builder(BeetalkLogin beetalkLogin) {
            super(beetalkLogin);
            if (beetalkLogin != null) {
                this.requestid = beetalkLogin.requestid;
                this.bk_access_token = beetalkLogin.bk_access_token;
                this.username = beetalkLogin.username;
                this.portrait = beetalkLogin.portrait;
                this.timestamp = beetalkLogin.timestamp;
                this.is_web = beetalkLogin.is_web;
                this.country = beetalkLogin.country;
                this.is_user_login = beetalkLogin.is_user_login;
                this.deviceid = beetalkLogin.deviceid;
                this.shop_cover = beetalkLogin.shop_cover;
                this.email = beetalkLogin.email;
                this.appversion = beetalkLogin.appversion;
                this.is_ghost = beetalkLogin.is_ghost;
                this.ext = beetalkLogin.ext;
                this.source = beetalkLogin.source;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bk_access_token(String str) {
            this.bk_access_token = str;
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

        public BeetalkLogin build() {
            checkRequiredFields();
            return new BeetalkLogin(this);
        }
    }
}
