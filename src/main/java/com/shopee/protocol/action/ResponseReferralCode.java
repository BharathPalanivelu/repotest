package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseReferralCode extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REFERRAL_CODE = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String referral_code;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseReferralCode(String str, Integer num, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.referral_code = str2;
    }

    private ResponseReferralCode(Builder builder) {
        this(builder.requestid, builder.errcode, builder.referral_code);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReferralCode)) {
            return false;
        }
        ResponseReferralCode responseReferralCode = (ResponseReferralCode) obj;
        if (!equals((Object) this.requestid, (Object) responseReferralCode.requestid) || !equals((Object) this.errcode, (Object) responseReferralCode.errcode) || !equals((Object) this.referral_code, (Object) responseReferralCode.referral_code)) {
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
        String str2 = this.referral_code;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseReferralCode> {
        public Integer errcode;
        public String referral_code;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseReferralCode responseReferralCode) {
            super(responseReferralCode);
            if (responseReferralCode != null) {
                this.requestid = responseReferralCode.requestid;
                this.errcode = responseReferralCode.errcode;
                this.referral_code = responseReferralCode.referral_code;
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

        public Builder referral_code(String str) {
            this.referral_code = str;
            return this;
        }

        public ResponseReferralCode build() {
            return new ResponseReferralCode(this);
        }
    }
}
