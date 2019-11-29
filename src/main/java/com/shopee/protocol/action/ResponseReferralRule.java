package com.shopee.protocol.action;

import com.shopee.protocol.shop.ReferralRule;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseReferralRule extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3)
    public final ReferralRule rule;
    @ProtoField(tag = 4)
    public final VoucherResult voucher;

    public ResponseReferralRule(String str, Integer num, ReferralRule referralRule, VoucherResult voucherResult) {
        this.requestid = str;
        this.errcode = num;
        this.rule = referralRule;
        this.voucher = voucherResult;
    }

    private ResponseReferralRule(Builder builder) {
        this(builder.requestid, builder.errcode, builder.rule, builder.voucher);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseReferralRule)) {
            return false;
        }
        ResponseReferralRule responseReferralRule = (ResponseReferralRule) obj;
        if (!equals((Object) this.requestid, (Object) responseReferralRule.requestid) || !equals((Object) this.errcode, (Object) responseReferralRule.errcode) || !equals((Object) this.rule, (Object) responseReferralRule.rule) || !equals((Object) this.voucher, (Object) responseReferralRule.voucher)) {
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
        ReferralRule referralRule = this.rule;
        int hashCode3 = (hashCode2 + (referralRule != null ? referralRule.hashCode() : 0)) * 37;
        VoucherResult voucherResult = this.voucher;
        if (voucherResult != null) {
            i2 = voucherResult.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseReferralRule> {
        public Integer errcode;
        public String requestid;
        public ReferralRule rule;
        public VoucherResult voucher;

        public Builder() {
        }

        public Builder(ResponseReferralRule responseReferralRule) {
            super(responseReferralRule);
            if (responseReferralRule != null) {
                this.requestid = responseReferralRule.requestid;
                this.errcode = responseReferralRule.errcode;
                this.rule = responseReferralRule.rule;
                this.voucher = responseReferralRule.voucher;
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

        public Builder rule(ReferralRule referralRule) {
            this.rule = referralRule;
            return this;
        }

        public Builder voucher(VoucherResult voucherResult) {
            this.voucher = voucherResult;
            return this;
        }

        public ResponseReferralRule build() {
            return new ResponseReferralRule(this);
        }
    }
}
