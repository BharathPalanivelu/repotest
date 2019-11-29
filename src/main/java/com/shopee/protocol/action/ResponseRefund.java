package com.shopee.protocol.action;

import com.shopee.protocol.shop.Refund;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseRefund extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 3)
    public final Refund refund;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseRefund(String str, Integer num, Refund refund2) {
        this.requestid = str;
        this.errcode = num;
        this.refund = refund2;
    }

    private ResponseRefund(Builder builder) {
        this(builder.requestid, builder.errcode, builder.refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseRefund)) {
            return false;
        }
        ResponseRefund responseRefund = (ResponseRefund) obj;
        if (!equals((Object) this.requestid, (Object) responseRefund.requestid) || !equals((Object) this.errcode, (Object) responseRefund.errcode) || !equals((Object) this.refund, (Object) responseRefund.refund)) {
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
        Refund refund2 = this.refund;
        if (refund2 != null) {
            i2 = refund2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseRefund> {
        public Integer errcode;
        public Refund refund;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseRefund responseRefund) {
            super(responseRefund);
            if (responseRefund != null) {
                this.requestid = responseRefund.requestid;
                this.errcode = responseRefund.errcode;
                this.refund = responseRefund.refund;
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

        public Builder refund(Refund refund2) {
            this.refund = refund2;
            return this;
        }

        public ResponseRefund build() {
            checkRequiredFields();
            return new ResponseRefund(this);
        }
    }
}
