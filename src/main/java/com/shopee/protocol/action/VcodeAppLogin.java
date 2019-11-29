package com.shopee.protocol.action;

import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class VcodeAppLogin extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_APP_VERSION_NAME = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_GHOST = false;
    public static final Boolean DEFAULT_IS_USER_LOGIN = false;
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_VCODE = "";
    public static final String DEFAULT_VCODE_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String app_version_name;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer appversion;
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
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String vcode;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String vcode_token;

    public VcodeAppLogin(String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, f fVar, Integer num2, String str6, String str7, Boolean bool2, DeviceExt deviceExt, String str8, String str9, String str10) {
        this.requestid = str;
        this.phone = str2;
        this.vcode = str3;
        this.vcode_token = str4;
        this.timestamp = num;
        this.country = str5;
        this.is_user_login = bool;
        this.deviceid = fVar;
        this.appversion = num2;
        this.email = str6;
        this.username = str7;
        this.is_ghost = bool2;
        this.ext = deviceExt;
        this.source = str8;
        this.otp_seed = str9;
        this.app_version_name = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private VcodeAppLogin(com.shopee.protocol.action.VcodeAppLogin.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.phone
            java.lang.String r4 = r0.vcode
            java.lang.String r5 = r0.vcode_token
            java.lang.Integer r6 = r0.timestamp
            java.lang.String r7 = r0.country
            java.lang.Boolean r8 = r0.is_user_login
            e.f r9 = r0.deviceid
            java.lang.Integer r10 = r0.appversion
            java.lang.String r11 = r0.email
            java.lang.String r12 = r0.username
            java.lang.Boolean r13 = r0.is_ghost
            com.shopee.protocol.shop.DeviceExt r14 = r0.ext
            java.lang.String r15 = r0.source
            r18 = r1
            java.lang.String r1 = r0.otp_seed
            r16 = r1
            java.lang.String r1 = r0.app_version_name
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.VcodeAppLogin.<init>(com.shopee.protocol.action.VcodeAppLogin$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VcodeAppLogin)) {
            return false;
        }
        VcodeAppLogin vcodeAppLogin = (VcodeAppLogin) obj;
        if (!equals((Object) this.requestid, (Object) vcodeAppLogin.requestid) || !equals((Object) this.phone, (Object) vcodeAppLogin.phone) || !equals((Object) this.vcode, (Object) vcodeAppLogin.vcode) || !equals((Object) this.vcode_token, (Object) vcodeAppLogin.vcode_token) || !equals((Object) this.timestamp, (Object) vcodeAppLogin.timestamp) || !equals((Object) this.country, (Object) vcodeAppLogin.country) || !equals((Object) this.is_user_login, (Object) vcodeAppLogin.is_user_login) || !equals((Object) this.deviceid, (Object) vcodeAppLogin.deviceid) || !equals((Object) this.appversion, (Object) vcodeAppLogin.appversion) || !equals((Object) this.email, (Object) vcodeAppLogin.email) || !equals((Object) this.username, (Object) vcodeAppLogin.username) || !equals((Object) this.is_ghost, (Object) vcodeAppLogin.is_ghost) || !equals((Object) this.ext, (Object) vcodeAppLogin.ext) || !equals((Object) this.source, (Object) vcodeAppLogin.source) || !equals((Object) this.otp_seed, (Object) vcodeAppLogin.otp_seed) || !equals((Object) this.app_version_name, (Object) vcodeAppLogin.app_version_name)) {
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
        String str3 = this.vcode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.vcode_token;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.timestamp;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        String str5 = this.country;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool = this.is_user_login;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode8 = (hashCode7 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num2 = this.appversion;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str6 = this.email;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.username;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_ghost;
        int hashCode12 = (hashCode11 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode13 = (hashCode12 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str8 = this.source;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.otp_seed;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.app_version_name;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VcodeAppLogin> {
        public String app_version_name;
        public Integer appversion;
        public String country;
        public f deviceid;
        public String email;
        public DeviceExt ext;
        public Boolean is_ghost;
        public Boolean is_user_login;
        public String otp_seed;
        public String phone;
        public String requestid;
        public String source;
        public Integer timestamp;
        public String username;
        public String vcode;
        public String vcode_token;

        public Builder() {
        }

        public Builder(VcodeAppLogin vcodeAppLogin) {
            super(vcodeAppLogin);
            if (vcodeAppLogin != null) {
                this.requestid = vcodeAppLogin.requestid;
                this.phone = vcodeAppLogin.phone;
                this.vcode = vcodeAppLogin.vcode;
                this.vcode_token = vcodeAppLogin.vcode_token;
                this.timestamp = vcodeAppLogin.timestamp;
                this.country = vcodeAppLogin.country;
                this.is_user_login = vcodeAppLogin.is_user_login;
                this.deviceid = vcodeAppLogin.deviceid;
                this.appversion = vcodeAppLogin.appversion;
                this.email = vcodeAppLogin.email;
                this.username = vcodeAppLogin.username;
                this.is_ghost = vcodeAppLogin.is_ghost;
                this.ext = vcodeAppLogin.ext;
                this.source = vcodeAppLogin.source;
                this.otp_seed = vcodeAppLogin.otp_seed;
                this.app_version_name = vcodeAppLogin.app_version_name;
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

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder vcode_token(String str) {
            this.vcode_token = str;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
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

        public Builder appversion(Integer num) {
            this.appversion = num;
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

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder app_version_name(String str) {
            this.app_version_name = str;
            return this;
        }

        public VcodeAppLogin build() {
            return new VcodeAppLogin(this);
        }
    }
}
