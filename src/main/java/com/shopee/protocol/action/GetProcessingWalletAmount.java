package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetProcessingWalletAmount extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetProcessingWalletAmount(String str, BackendParam backendParam) {
        this.requestid = str;
        this.bparam = backendParam;
    }

    private GetProcessingWalletAmount(Builder builder) {
        this(builder.requestid, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetProcessingWalletAmount)) {
            return false;
        }
        GetProcessingWalletAmount getProcessingWalletAmount = (GetProcessingWalletAmount) obj;
        if (!equals((Object) this.requestid, (Object) getProcessingWalletAmount.requestid) || !equals((Object) this.bparam, (Object) getProcessingWalletAmount.bparam)) {
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
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetProcessingWalletAmount> {
        public BackendParam bparam;
        public String requestid;

        public Builder() {
        }

        public Builder(GetProcessingWalletAmount getProcessingWalletAmount) {
            super(getProcessingWalletAmount);
            if (getProcessingWalletAmount != null) {
                this.requestid = getProcessingWalletAmount.requestid;
                this.bparam = getProcessingWalletAmount.bparam;
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

        public GetProcessingWalletAmount build() {
            return new GetProcessingWalletAmount(this);
        }
    }
}
