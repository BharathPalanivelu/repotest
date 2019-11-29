package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseGetProcessingWalletAmount extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetProcessingWalletAmount(String str, Integer num, Long l) {
        this.requestid = str;
        this.errcode = num;
        this.amount = l;
    }

    private ResponseGetProcessingWalletAmount(Builder builder) {
        this(builder.requestid, builder.errcode, builder.amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetProcessingWalletAmount)) {
            return false;
        }
        ResponseGetProcessingWalletAmount responseGetProcessingWalletAmount = (ResponseGetProcessingWalletAmount) obj;
        if (!equals((Object) this.requestid, (Object) responseGetProcessingWalletAmount.requestid) || !equals((Object) this.errcode, (Object) responseGetProcessingWalletAmount.errcode) || !equals((Object) this.amount, (Object) responseGetProcessingWalletAmount.amount)) {
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
        Long l = this.amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetProcessingWalletAmount> {
        public Long amount;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetProcessingWalletAmount responseGetProcessingWalletAmount) {
            super(responseGetProcessingWalletAmount);
            if (responseGetProcessingWalletAmount != null) {
                this.requestid = responseGetProcessingWalletAmount.requestid;
                this.errcode = responseGetProcessingWalletAmount.errcode;
                this.amount = responseGetProcessingWalletAmount.amount;
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

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public ResponseGetProcessingWalletAmount build() {
            return new ResponseGetProcessingWalletAmount(this);
        }
    }
}
