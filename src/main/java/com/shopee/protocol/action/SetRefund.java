package com.shopee.protocol.action;

import com.shopee.protocol.shop.Refund;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetRefund extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3)
    public final Refund refund;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetRefund(String str, BackendParam backendParam, Refund refund2) {
        this.requestid = str;
        this.bparam = backendParam;
        this.refund = refund2;
    }

    private SetRefund(Builder builder) {
        this(builder.requestid, builder.bparam, builder.refund);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetRefund)) {
            return false;
        }
        SetRefund setRefund = (SetRefund) obj;
        if (!equals((Object) this.requestid, (Object) setRefund.requestid) || !equals((Object) this.bparam, (Object) setRefund.bparam) || !equals((Object) this.refund, (Object) setRefund.refund)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Refund refund2 = this.refund;
        if (refund2 != null) {
            i2 = refund2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetRefund> {
        public BackendParam bparam;
        public Refund refund;
        public String requestid;

        public Builder() {
        }

        public Builder(SetRefund setRefund) {
            super(setRefund);
            if (setRefund != null) {
                this.requestid = setRefund.requestid;
                this.bparam = setRefund.bparam;
                this.refund = setRefund.refund;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder refund(Refund refund2) {
            this.refund = refund2;
            return this;
        }

        public SetRefund build() {
            return new SetRefund(this);
        }
    }
}
