package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResetPassword extends Message {
    public static final Integer DEFAULT_APPVERSION = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_EMAIL = "";
    public static final Boolean DEFAULT_IS_PAYMENT_PASSWORD = false;
    public static final Boolean DEFAULT_KICK_SELF = false;
    public static final String DEFAULT_OLDPASS = "";
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PASSWORD = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VCODE = "";
    public static final String DEFAULT_VSTR = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer appversion;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean is_payment_password;
    @ProtoField(tag = 11, type = Message.Datatype.BOOL)
    public final Boolean kick_self;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String oldpass;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String vcode;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String vstr;

    public ResetPassword(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, Boolean bool2, String str10, Integer num) {
        this.requestid = str;
        this.phone = str2;
        this.email = str3;
        this.password = str4;
        this.vcode = str5;
        this.oldpass = str6;
        this.vstr = str7;
        this.country = str8;
        this.is_payment_password = bool;
        this.token = str9;
        this.kick_self = bool2;
        this.otp_seed = str10;
        this.appversion = num;
    }

    private ResetPassword(Builder builder) {
        this(builder.requestid, builder.phone, builder.email, builder.password, builder.vcode, builder.oldpass, builder.vstr, builder.country, builder.is_payment_password, builder.token, builder.kick_self, builder.otp_seed, builder.appversion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResetPassword)) {
            return false;
        }
        ResetPassword resetPassword = (ResetPassword) obj;
        if (!equals((Object) this.requestid, (Object) resetPassword.requestid) || !equals((Object) this.phone, (Object) resetPassword.phone) || !equals((Object) this.email, (Object) resetPassword.email) || !equals((Object) this.password, (Object) resetPassword.password) || !equals((Object) this.vcode, (Object) resetPassword.vcode) || !equals((Object) this.oldpass, (Object) resetPassword.oldpass) || !equals((Object) this.vstr, (Object) resetPassword.vstr) || !equals((Object) this.country, (Object) resetPassword.country) || !equals((Object) this.is_payment_password, (Object) resetPassword.is_payment_password) || !equals((Object) this.token, (Object) resetPassword.token) || !equals((Object) this.kick_self, (Object) resetPassword.kick_self) || !equals((Object) this.otp_seed, (Object) resetPassword.otp_seed) || !equals((Object) this.appversion, (Object) resetPassword.appversion)) {
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
        String str6 = this.oldpass;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.vstr;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.country;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool = this.is_payment_password;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str9 = this.token;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool2 = this.kick_self;
        int hashCode11 = (hashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str10 = this.otp_seed;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num = this.appversion;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResetPassword> {
        public Integer appversion;
        public String country;
        public String email;
        public Boolean is_payment_password;
        public Boolean kick_self;
        public String oldpass;
        public String otp_seed;
        public String password;
        public String phone;
        public String requestid;
        public String token;
        public String vcode;
        public String vstr;

        public Builder() {
        }

        public Builder(ResetPassword resetPassword) {
            super(resetPassword);
            if (resetPassword != null) {
                this.requestid = resetPassword.requestid;
                this.phone = resetPassword.phone;
                this.email = resetPassword.email;
                this.password = resetPassword.password;
                this.vcode = resetPassword.vcode;
                this.oldpass = resetPassword.oldpass;
                this.vstr = resetPassword.vstr;
                this.country = resetPassword.country;
                this.is_payment_password = resetPassword.is_payment_password;
                this.token = resetPassword.token;
                this.kick_self = resetPassword.kick_self;
                this.otp_seed = resetPassword.otp_seed;
                this.appversion = resetPassword.appversion;
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

        public Builder oldpass(String str) {
            this.oldpass = str;
            return this;
        }

        public Builder vstr(String str) {
            this.vstr = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder is_payment_password(Boolean bool) {
            this.is_payment_password = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder kick_self(Boolean bool) {
            this.kick_self = bool;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder appversion(Integer num) {
            this.appversion = num;
            return this;
        }

        public ResetPassword build() {
            checkRequiredFields();
            return new ResetPassword(this);
        }
    }
}
