package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseChangePhoneCheck extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_PHONE_CHANGE_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer phone_change_errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;

    public ResponseChangePhoneCheck(String str, Integer num, Integer num2, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.phone_change_errcode = num2;
        this.token = str2;
    }

    private ResponseChangePhoneCheck(Builder builder) {
        this(builder.requestid, builder.errcode, builder.phone_change_errcode, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseChangePhoneCheck)) {
            return false;
        }
        ResponseChangePhoneCheck responseChangePhoneCheck = (ResponseChangePhoneCheck) obj;
        if (!equals((Object) this.requestid, (Object) responseChangePhoneCheck.requestid) || !equals((Object) this.errcode, (Object) responseChangePhoneCheck.errcode) || !equals((Object) this.phone_change_errcode, (Object) responseChangePhoneCheck.phone_change_errcode) || !equals((Object) this.token, (Object) responseChangePhoneCheck.token)) {
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
        Integer num2 = this.phone_change_errcode;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseChangePhoneCheck> {
        public Integer errcode;
        public Integer phone_change_errcode;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ResponseChangePhoneCheck responseChangePhoneCheck) {
            super(responseChangePhoneCheck);
            if (responseChangePhoneCheck != null) {
                this.requestid = responseChangePhoneCheck.requestid;
                this.errcode = responseChangePhoneCheck.errcode;
                this.phone_change_errcode = responseChangePhoneCheck.phone_change_errcode;
                this.token = responseChangePhoneCheck.token;
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

        public Builder phone_change_errcode(Integer num) {
            this.phone_change_errcode = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ResponseChangePhoneCheck build() {
            return new ResponseChangePhoneCheck(this);
        }
    }
}
