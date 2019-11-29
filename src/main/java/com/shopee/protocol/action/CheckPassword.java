package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CheckPassword extends Message {
    public static final Boolean DEFAULT_IS_AIRPAY_PASSCODE = false;
    public static final Boolean DEFAULT_IS_PAYMENT_PASSWORD = false;
    public static final String DEFAULT_PASSWORD = "";
    public static final Boolean DEFAULT_REMAINING_QUOTA = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SCENARIO = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean is_airpay_passcode;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_payment_password;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String password;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean remaining_quota;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer scenario;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public CheckPassword(String str, String str2, String str3, BackendParam backendParam, Boolean bool, Boolean bool2, Integer num, Boolean bool3) {
        this.requestid = str;
        this.token = str2;
        this.password = str3;
        this.bparam = backendParam;
        this.is_payment_password = bool;
        this.remaining_quota = bool2;
        this.scenario = num;
        this.is_airpay_passcode = bool3;
    }

    private CheckPassword(Builder builder) {
        this(builder.requestid, builder.token, builder.password, builder.bparam, builder.is_payment_password, builder.remaining_quota, builder.scenario, builder.is_airpay_passcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckPassword)) {
            return false;
        }
        CheckPassword checkPassword = (CheckPassword) obj;
        if (!equals((Object) this.requestid, (Object) checkPassword.requestid) || !equals((Object) this.token, (Object) checkPassword.token) || !equals((Object) this.password, (Object) checkPassword.password) || !equals((Object) this.bparam, (Object) checkPassword.bparam) || !equals((Object) this.is_payment_password, (Object) checkPassword.is_payment_password) || !equals((Object) this.remaining_quota, (Object) checkPassword.remaining_quota) || !equals((Object) this.scenario, (Object) checkPassword.scenario) || !equals((Object) this.is_airpay_passcode, (Object) checkPassword.is_airpay_passcode)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.password;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.is_payment_password;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.remaining_quota;
        int hashCode6 = (hashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num = this.scenario;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_airpay_passcode;
        if (bool3 != null) {
            i2 = bool3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CheckPassword> {
        public BackendParam bparam;
        public Boolean is_airpay_passcode;
        public Boolean is_payment_password;
        public String password;
        public Boolean remaining_quota;
        public String requestid;
        public Integer scenario;
        public String token;

        public Builder() {
        }

        public Builder(CheckPassword checkPassword) {
            super(checkPassword);
            if (checkPassword != null) {
                this.requestid = checkPassword.requestid;
                this.token = checkPassword.token;
                this.password = checkPassword.password;
                this.bparam = checkPassword.bparam;
                this.is_payment_password = checkPassword.is_payment_password;
                this.remaining_quota = checkPassword.remaining_quota;
                this.scenario = checkPassword.scenario;
                this.is_airpay_passcode = checkPassword.is_airpay_passcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder password(String str) {
            this.password = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder is_payment_password(Boolean bool) {
            this.is_payment_password = bool;
            return this;
        }

        public Builder remaining_quota(Boolean bool) {
            this.remaining_quota = bool;
            return this;
        }

        public Builder scenario(Integer num) {
            this.scenario = num;
            return this;
        }

        public Builder is_airpay_passcode(Boolean bool) {
            this.is_airpay_passcode = bool;
            return this;
        }

        public CheckPassword build() {
            return new CheckPassword(this);
        }
    }
}
