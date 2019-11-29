package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckVcode extends Message {
    public static final Boolean DEFAULT_IS_PAYMENT_PASSWORD = false;
    public static final Integer DEFAULT_OPERATION = 0;
    public static final String DEFAULT_OTP_SEED = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean is_payment_password;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer operation;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String otp_seed;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String vcode;

    public CheckVcode(String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num) {
        this.requestid = str;
        this.phone = str2;
        this.vcode = str3;
        this.is_payment_password = bool;
        this.token = str4;
        this.otp_seed = str5;
        this.operation = num;
    }

    private CheckVcode(Builder builder) {
        this(builder.requestid, builder.phone, builder.vcode, builder.is_payment_password, builder.token, builder.otp_seed, builder.operation);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckVcode)) {
            return false;
        }
        CheckVcode checkVcode = (CheckVcode) obj;
        if (!equals((Object) this.requestid, (Object) checkVcode.requestid) || !equals((Object) this.phone, (Object) checkVcode.phone) || !equals((Object) this.vcode, (Object) checkVcode.vcode) || !equals((Object) this.is_payment_password, (Object) checkVcode.is_payment_password) || !equals((Object) this.token, (Object) checkVcode.token) || !equals((Object) this.otp_seed, (Object) checkVcode.otp_seed) || !equals((Object) this.operation, (Object) checkVcode.operation)) {
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
        Boolean bool = this.is_payment_password;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.token;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.otp_seed;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.operation;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckVcode> {
        public Boolean is_payment_password;
        public Integer operation;
        public String otp_seed;
        public String phone;
        public String requestid;
        public String token;
        public String vcode;

        public Builder() {
        }

        public Builder(CheckVcode checkVcode) {
            super(checkVcode);
            if (checkVcode != null) {
                this.requestid = checkVcode.requestid;
                this.phone = checkVcode.phone;
                this.vcode = checkVcode.vcode;
                this.is_payment_password = checkVcode.is_payment_password;
                this.token = checkVcode.token;
                this.otp_seed = checkVcode.otp_seed;
                this.operation = checkVcode.operation;
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

        public Builder is_payment_password(Boolean bool) {
            this.is_payment_password = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder otp_seed(String str) {
            this.otp_seed = str;
            return this;
        }

        public Builder operation(Integer num) {
            this.operation = num;
            return this;
        }

        public CheckVcode build() {
            checkRequiredFields();
            return new CheckVcode(this);
        }
    }
}
