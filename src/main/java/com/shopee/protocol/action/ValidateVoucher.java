package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ValidateVoucher extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_VOUCHER_CODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String voucher_code;

    public ValidateVoucher(String str, String str2, String str3) {
        this.requestid = str;
        this.voucher_code = str2;
        this.token = str3;
    }

    private ValidateVoucher(Builder builder) {
        this(builder.requestid, builder.voucher_code, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValidateVoucher)) {
            return false;
        }
        ValidateVoucher validateVoucher = (ValidateVoucher) obj;
        if (!equals((Object) this.requestid, (Object) validateVoucher.requestid) || !equals((Object) this.voucher_code, (Object) validateVoucher.voucher_code) || !equals((Object) this.token, (Object) validateVoucher.token)) {
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
        String str2 = this.voucher_code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ValidateVoucher> {
        public String requestid;
        public String token;
        public String voucher_code;

        public Builder() {
        }

        public Builder(ValidateVoucher validateVoucher) {
            super(validateVoucher);
            if (validateVoucher != null) {
                this.requestid = validateVoucher.requestid;
                this.voucher_code = validateVoucher.voucher_code;
                this.token = validateVoucher.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder voucher_code(String str) {
            this.voucher_code = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ValidateVoucher build() {
            return new ValidateVoucher(this);
        }
    }
}
