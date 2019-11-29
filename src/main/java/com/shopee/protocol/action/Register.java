package com.shopee.protocol.action;

import com.shopee.protocol.shop.AccountExtInfo;
import com.shopee.protocol.shop.DeviceExt;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Register extends Message {
    public static final String DEFAULT_AUTH_SIGNATURE = "";
    public static final String DEFAULT_CAPTCHA_TOKEN = "";
    public static final Integer DEFAULT_CB_OPTION = 0;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_EMAIL_VERIFIED = false;
    public static final String DEFAULT_LANG = "";
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PHONE = "";
    public static final Integer DEFAULT_PLATFORM = 0;
    public static final String DEFAULT_PORTRAIT = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_USERNAME = "";
    public static final String DEFAULT_VCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String auth_signature;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String captcha_token;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer cb_option;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 16, type = Message.Datatype.BOOL)
    public final Boolean email_verified;
    @ProtoField(tag = 10)
    public final DeviceExt ext;
    @ProtoField(tag = 15)
    public final AccountExtInfo extinfo;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String lang;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer platform;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String username;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String vcode;

    public Register(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, DeviceExt deviceExt, String str10, String str11, String str12, Integer num, AccountExtInfo accountExtInfo, Boolean bool, Integer num2, String str13, String str14) {
        this.requestid = str;
        this.phone = str2;
        this.email = str3;
        this.password = str4;
        this.vcode = str5;
        this.username = str6;
        this.portrait = str7;
        this.nickname = str8;
        this.country = str9;
        this.ext = deviceExt;
        this.captcha_token = str10;
        this.otp_seed = str11;
        this.lang = str12;
        this.cb_option = num;
        this.extinfo = accountExtInfo;
        this.email_verified = bool;
        this.platform = num2;
        this.client_ip = str13;
        this.auth_signature = str14;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Register(com.shopee.protocol.action.Register.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.String r2 = r0.requestid
            java.lang.String r3 = r0.phone
            java.lang.String r4 = r0.email
            java.lang.String r5 = r0.password
            java.lang.String r6 = r0.vcode
            java.lang.String r7 = r0.username
            java.lang.String r8 = r0.portrait
            java.lang.String r9 = r0.nickname
            java.lang.String r10 = r0.country
            com.shopee.protocol.shop.DeviceExt r11 = r0.ext
            java.lang.String r12 = r0.captcha_token
            java.lang.String r13 = r0.otp_seed
            java.lang.String r14 = r0.lang
            java.lang.Integer r15 = r0.cb_option
            r21 = r1
            com.shopee.protocol.shop.AccountExtInfo r1 = r0.extinfo
            r16 = r1
            java.lang.Boolean r1 = r0.email_verified
            r17 = r1
            java.lang.Integer r1 = r0.platform
            r18 = r1
            java.lang.String r1 = r0.client_ip
            r19 = r1
            java.lang.String r1 = r0.auth_signature
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.Register.<init>(com.shopee.protocol.action.Register$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Register)) {
            return false;
        }
        Register register = (Register) obj;
        if (!equals((Object) this.requestid, (Object) register.requestid) || !equals((Object) this.phone, (Object) register.phone) || !equals((Object) this.email, (Object) register.email) || !equals((Object) this.password, (Object) register.password) || !equals((Object) this.vcode, (Object) register.vcode) || !equals((Object) this.username, (Object) register.username) || !equals((Object) this.portrait, (Object) register.portrait) || !equals((Object) this.nickname, (Object) register.nickname) || !equals((Object) this.country, (Object) register.country) || !equals((Object) this.ext, (Object) register.ext) || !equals((Object) this.captcha_token, (Object) register.captcha_token) || !equals((Object) this.otp_seed, (Object) register.otp_seed) || !equals((Object) this.lang, (Object) register.lang) || !equals((Object) this.cb_option, (Object) register.cb_option) || !equals((Object) this.extinfo, (Object) register.extinfo) || !equals((Object) this.email_verified, (Object) register.email_verified) || !equals((Object) this.platform, (Object) register.platform) || !equals((Object) this.client_ip, (Object) register.client_ip) || !equals((Object) this.auth_signature, (Object) register.auth_signature)) {
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
        String str5 = this.vcode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.username;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.portrait;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.nickname;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.country;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 37;
        DeviceExt deviceExt = this.ext;
        int hashCode10 = (hashCode9 + (deviceExt != null ? deviceExt.hashCode() : 0)) * 37;
        String str10 = this.captcha_token;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.otp_seed;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.lang;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num = this.cb_option;
        int hashCode14 = (hashCode13 + (num != null ? num.hashCode() : 0)) * 37;
        AccountExtInfo accountExtInfo = this.extinfo;
        int hashCode15 = (hashCode14 + (accountExtInfo != null ? accountExtInfo.hashCode() : 0)) * 37;
        Boolean bool = this.email_verified;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.platform;
        int hashCode17 = (hashCode16 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str13 = this.client_ip;
        int hashCode18 = (hashCode17 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.auth_signature;
        if (str14 != null) {
            i2 = str14.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Register> {
        public String auth_signature;
        public String captcha_token;
        public Integer cb_option;
        public String client_ip;
        public String country;
        public String email;
        public Boolean email_verified;
        public DeviceExt ext;
        public AccountExtInfo extinfo;
        public String lang;
        public String nickname;
        public String otp_seed;
        public String password;
        public String phone;
        public Integer platform;
        public String portrait;
        public String requestid;
        public String username;
        public String vcode;

        public Builder() {
        }

        public Builder(Register register) {
            super(register);
            if (register != null) {
                this.requestid = register.requestid;
                this.phone = register.phone;
                this.email = register.email;
                this.password = register.password;
                this.vcode = register.vcode;
                this.username = register.username;
                this.portrait = register.portrait;
                this.nickname = register.nickname;
                this.country = register.country;
                this.ext = register.ext;
                this.captcha_token = register.captcha_token;
                this.otp_seed = register.otp_seed;
                this.lang = register.lang;
                this.cb_option = register.cb_option;
                this.extinfo = register.extinfo;
                this.email_verified = register.email_verified;
                this.platform = register.platform;
                this.client_ip = register.client_ip;
                this.auth_signature = register.auth_signature;
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

        public Builder vcode(String str) {
            this.vcode = str;
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

        public Builder nickname(String str) {
            this.nickname = str;
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

        public Builder captcha_token(String str) {
            this.captcha_token = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder lang(String str) {
            this.lang = str;
            return this;
        }

        public Builder cb_option(Integer num) {
            this.cb_option = num;
            return this;
        }

        public Builder extinfo(AccountExtInfo accountExtInfo) {
            this.extinfo = accountExtInfo;
            return this;
        }

        public Builder email_verified(Boolean bool) {
            this.email_verified = bool;
            return this;
        }

        public Builder platform(Integer num) {
            this.platform = num;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public Builder auth_signature(String str) {
            this.auth_signature = str;
            return this;
        }

        public Register build() {
            return new Register(this);
        }
    }
}
