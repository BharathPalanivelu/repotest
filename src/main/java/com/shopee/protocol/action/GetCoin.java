package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCoin extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetCoin(String str, String str2, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
    }

    private GetCoin(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCoin)) {
            return false;
        }
        GetCoin getCoin = (GetCoin) obj;
        if (!equals((Object) this.requestid, (Object) getCoin.requestid) || !equals((Object) this.token, (Object) getCoin.token) || !equals((Object) this.bparam, (Object) getCoin.bparam)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCoin> {
        public BackendParam bparam;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetCoin getCoin) {
            super(getCoin);
            if (getCoin != null) {
                this.requestid = getCoin.requestid;
                this.token = getCoin.token;
                this.bparam = getCoin.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
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

        public GetCoin build() {
            return new GetCoin(this);
        }
    }
}
