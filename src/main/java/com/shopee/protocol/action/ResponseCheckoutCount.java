package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCheckoutCount extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final CheckoutCountSummary device_summary;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2)
    public final CheckoutCountSummary user_summary;

    public ResponseCheckoutCount(String str, CheckoutCountSummary checkoutCountSummary, CheckoutCountSummary checkoutCountSummary2, Integer num) {
        this.requestid = str;
        this.user_summary = checkoutCountSummary;
        this.device_summary = checkoutCountSummary2;
        this.errcode = num;
    }

    private ResponseCheckoutCount(Builder builder) {
        this(builder.requestid, builder.user_summary, builder.device_summary, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckoutCount)) {
            return false;
        }
        ResponseCheckoutCount responseCheckoutCount = (ResponseCheckoutCount) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckoutCount.requestid) || !equals((Object) this.user_summary, (Object) responseCheckoutCount.user_summary) || !equals((Object) this.device_summary, (Object) responseCheckoutCount.device_summary) || !equals((Object) this.errcode, (Object) responseCheckoutCount.errcode)) {
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
        CheckoutCountSummary checkoutCountSummary = this.user_summary;
        int hashCode2 = (hashCode + (checkoutCountSummary != null ? checkoutCountSummary.hashCode() : 0)) * 37;
        CheckoutCountSummary checkoutCountSummary2 = this.device_summary;
        int hashCode3 = (hashCode2 + (checkoutCountSummary2 != null ? checkoutCountSummary2.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCheckoutCount> {
        public CheckoutCountSummary device_summary;
        public Integer errcode;
        public String requestid;
        public CheckoutCountSummary user_summary;

        public Builder() {
        }

        public Builder(ResponseCheckoutCount responseCheckoutCount) {
            super(responseCheckoutCount);
            if (responseCheckoutCount != null) {
                this.requestid = responseCheckoutCount.requestid;
                this.user_summary = responseCheckoutCount.user_summary;
                this.device_summary = responseCheckoutCount.device_summary;
                this.errcode = responseCheckoutCount.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder user_summary(CheckoutCountSummary checkoutCountSummary) {
            this.user_summary = checkoutCountSummary;
            return this;
        }

        public Builder device_summary(CheckoutCountSummary checkoutCountSummary) {
            this.device_summary = checkoutCountSummary;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseCheckoutCount build() {
            return new ResponseCheckoutCount(this);
        }
    }
}
