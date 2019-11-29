package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WithdrawRequest extends Message {
    public static final Long DEFAULT_AMOUNT = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long amount;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public WithdrawRequest(String str, Long l) {
        this.requestid = str;
        this.amount = l;
    }

    private WithdrawRequest(Builder builder) {
        this(builder.requestid, builder.amount);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawRequest)) {
            return false;
        }
        WithdrawRequest withdrawRequest = (WithdrawRequest) obj;
        if (!equals((Object) this.requestid, (Object) withdrawRequest.requestid) || !equals((Object) this.amount, (Object) withdrawRequest.amount)) {
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
        Long l = this.amount;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WithdrawRequest> {
        public Long amount;
        public String requestid;

        public Builder() {
        }

        public Builder(WithdrawRequest withdrawRequest) {
            super(withdrawRequest);
            if (withdrawRequest != null) {
                this.requestid = withdrawRequest.requestid;
                this.amount = withdrawRequest.amount;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder amount(Long l) {
            this.amount = l;
            return this;
        }

        public WithdrawRequest build() {
            checkRequiredFields();
            return new WithdrawRequest(this);
        }
    }
}
