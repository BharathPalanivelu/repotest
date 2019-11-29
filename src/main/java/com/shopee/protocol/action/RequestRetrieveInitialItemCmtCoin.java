package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RequestRetrieveInitialItemCmtCoin extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public RequestRetrieveInitialItemCmtCoin(String str, BackendParam backendParam, Long l) {
        this.requestid = str;
        this.bparam = backendParam;
        this.cmtid = l;
    }

    private RequestRetrieveInitialItemCmtCoin(Builder builder) {
        this(builder.requestid, builder.bparam, builder.cmtid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestRetrieveInitialItemCmtCoin)) {
            return false;
        }
        RequestRetrieveInitialItemCmtCoin requestRetrieveInitialItemCmtCoin = (RequestRetrieveInitialItemCmtCoin) obj;
        if (!equals((Object) this.requestid, (Object) requestRetrieveInitialItemCmtCoin.requestid) || !equals((Object) this.bparam, (Object) requestRetrieveInitialItemCmtCoin.bparam) || !equals((Object) this.cmtid, (Object) requestRetrieveInitialItemCmtCoin.cmtid)) {
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
        Long l = this.cmtid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RequestRetrieveInitialItemCmtCoin> {
        public BackendParam bparam;
        public Long cmtid;
        public String requestid;

        public Builder() {
        }

        public Builder(RequestRetrieveInitialItemCmtCoin requestRetrieveInitialItemCmtCoin) {
            super(requestRetrieveInitialItemCmtCoin);
            if (requestRetrieveInitialItemCmtCoin != null) {
                this.requestid = requestRetrieveInitialItemCmtCoin.requestid;
                this.bparam = requestRetrieveInitialItemCmtCoin.bparam;
                this.cmtid = requestRetrieveInitialItemCmtCoin.cmtid;
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

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public RequestRetrieveInitialItemCmtCoin build() {
            return new RequestRetrieveInitialItemCmtCoin(this);
        }
    }
}
