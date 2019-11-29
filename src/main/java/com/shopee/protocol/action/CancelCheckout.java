package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CancelCheckout extends Message {
    public static final Integer DEFAULT_BUYER_CANCEL_REASON = 0;
    public static final Long DEFAULT_CHECKOUTID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer buyer_cancel_reason;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long checkoutid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public CancelCheckout(String str, Long l, String str2, BackendParam backendParam, Integer num) {
        this.requestid = str;
        this.checkoutid = l;
        this.token = str2;
        this.bparam = backendParam;
        this.buyer_cancel_reason = num;
    }

    private CancelCheckout(Builder builder) {
        this(builder.requestid, builder.checkoutid, builder.token, builder.bparam, builder.buyer_cancel_reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelCheckout)) {
            return false;
        }
        CancelCheckout cancelCheckout = (CancelCheckout) obj;
        if (!equals((Object) this.requestid, (Object) cancelCheckout.requestid) || !equals((Object) this.checkoutid, (Object) cancelCheckout.checkoutid) || !equals((Object) this.token, (Object) cancelCheckout.token) || !equals((Object) this.bparam, (Object) cancelCheckout.bparam) || !equals((Object) this.buyer_cancel_reason, (Object) cancelCheckout.buyer_cancel_reason)) {
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
        Long l = this.checkoutid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.buyer_cancel_reason;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CancelCheckout> {
        public BackendParam bparam;
        public Integer buyer_cancel_reason;
        public Long checkoutid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(CancelCheckout cancelCheckout) {
            super(cancelCheckout);
            if (cancelCheckout != null) {
                this.requestid = cancelCheckout.requestid;
                this.checkoutid = cancelCheckout.checkoutid;
                this.token = cancelCheckout.token;
                this.bparam = cancelCheckout.bparam;
                this.buyer_cancel_reason = cancelCheckout.buyer_cancel_reason;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder checkoutid(Long l) {
            this.checkoutid = l;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder buyer_cancel_reason(Integer num) {
            this.buyer_cancel_reason = num;
            return this;
        }

        public CancelCheckout build() {
            checkRequiredFields();
            return new CancelCheckout(this);
        }
    }
}
