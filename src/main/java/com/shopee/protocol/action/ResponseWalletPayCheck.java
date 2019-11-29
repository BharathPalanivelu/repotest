package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseWalletPayCheck extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseWalletPayCheck(String str, Integer num, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.err_message = str2;
    }

    private ResponseWalletPayCheck(Builder builder) {
        this(builder.requestid, builder.errcode, builder.err_message);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseWalletPayCheck)) {
            return false;
        }
        ResponseWalletPayCheck responseWalletPayCheck = (ResponseWalletPayCheck) obj;
        if (!equals((Object) this.requestid, (Object) responseWalletPayCheck.requestid) || !equals((Object) this.errcode, (Object) responseWalletPayCheck.errcode) || !equals((Object) this.err_message, (Object) responseWalletPayCheck.err_message)) {
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
        String str2 = this.err_message;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseWalletPayCheck> {
        public String err_message;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseWalletPayCheck responseWalletPayCheck) {
            super(responseWalletPayCheck);
            if (responseWalletPayCheck != null) {
                this.requestid = responseWalletPayCheck.requestid;
                this.errcode = responseWalletPayCheck.errcode;
                this.err_message = responseWalletPayCheck.err_message;
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

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public ResponseWalletPayCheck build() {
            return new ResponseWalletPayCheck(this);
        }
    }
}
