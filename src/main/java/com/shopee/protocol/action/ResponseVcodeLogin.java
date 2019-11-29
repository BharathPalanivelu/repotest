package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseVcodeLogin extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final Boolean DEFAULT_IS_NEW_CREATE = false;
    public static final String DEFAULT_OTP_TOKEN = "";
    public static final Boolean DEFAULT_PHONE_AUTO_CONVERTED = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TIMESTAMP = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12)
    public final Account acc;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 27, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 26, type = Message.Datatype.BOOL)
    public final Boolean is_new_create;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String otp_token;
    @ProtoField(tag = 28, type = Message.Datatype.BOOL)
    public final Boolean phone_auto_converted;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer timestamp;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;

    public ResponseVcodeLogin(String str, Integer num, Integer num2, String str2, Account account, Integer num3, String str3, String str4, Boolean bool, String str5, Boolean bool2) {
        this.requestid = str;
        this.errcode = num;
        this.userid = num2;
        this.country = str2;
        this.acc = account;
        this.timestamp = num3;
        this.token = str3;
        this.otp_token = str4;
        this.is_new_create = bool;
        this.err_message = str5;
        this.phone_auto_converted = bool2;
    }

    private ResponseVcodeLogin(Builder builder) {
        this(builder.requestid, builder.errcode, builder.userid, builder.country, builder.acc, builder.timestamp, builder.token, builder.otp_token, builder.is_new_create, builder.err_message, builder.phone_auto_converted);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseVcodeLogin)) {
            return false;
        }
        ResponseVcodeLogin responseVcodeLogin = (ResponseVcodeLogin) obj;
        if (!equals((Object) this.requestid, (Object) responseVcodeLogin.requestid) || !equals((Object) this.errcode, (Object) responseVcodeLogin.errcode) || !equals((Object) this.userid, (Object) responseVcodeLogin.userid) || !equals((Object) this.country, (Object) responseVcodeLogin.country) || !equals((Object) this.acc, (Object) responseVcodeLogin.acc) || !equals((Object) this.timestamp, (Object) responseVcodeLogin.timestamp) || !equals((Object) this.token, (Object) responseVcodeLogin.token) || !equals((Object) this.otp_token, (Object) responseVcodeLogin.otp_token) || !equals((Object) this.is_new_create, (Object) responseVcodeLogin.is_new_create) || !equals((Object) this.err_message, (Object) responseVcodeLogin.err_message) || !equals((Object) this.phone_auto_converted, (Object) responseVcodeLogin.phone_auto_converted)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.userid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Account account = this.acc;
        int hashCode5 = (hashCode4 + (account != null ? account.hashCode() : 0)) * 37;
        Integer num3 = this.timestamp;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.otp_token;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.is_new_create;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str5 = this.err_message;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool2 = this.phone_auto_converted;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseVcodeLogin> {
        public Account acc;
        public String country;
        public String err_message;
        public Integer errcode;
        public Boolean is_new_create;
        public String otp_token;
        public Boolean phone_auto_converted;
        public String requestid;
        public Integer timestamp;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(ResponseVcodeLogin responseVcodeLogin) {
            super(responseVcodeLogin);
            if (responseVcodeLogin != null) {
                this.requestid = responseVcodeLogin.requestid;
                this.errcode = responseVcodeLogin.errcode;
                this.userid = responseVcodeLogin.userid;
                this.country = responseVcodeLogin.country;
                this.acc = responseVcodeLogin.acc;
                this.timestamp = responseVcodeLogin.timestamp;
                this.token = responseVcodeLogin.token;
                this.otp_token = responseVcodeLogin.otp_token;
                this.is_new_create = responseVcodeLogin.is_new_create;
                this.err_message = responseVcodeLogin.err_message;
                this.phone_auto_converted = responseVcodeLogin.phone_auto_converted;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder acc(Account account) {
            this.acc = account;
            return this;
        }

        public Builder timestamp(Integer num) {
            this.timestamp = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder otp_token(String str) {
            this.otp_token = str;
            return this;
        }

        public Builder is_new_create(Boolean bool) {
            this.is_new_create = bool;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder phone_auto_converted(Boolean bool) {
            this.phone_auto_converted = bool;
            return this;
        }

        public ResponseVcodeLogin build() {
            checkRequiredFields();
            return new ResponseVcodeLogin(this);
        }
    }
}
