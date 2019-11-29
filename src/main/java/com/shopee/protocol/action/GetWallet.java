package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetWallet extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_WALLET_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer wallet_type;

    public GetWallet(String str, String str2, BackendParam backendParam, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.wallet_type = num;
    }

    private GetWallet(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.wallet_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetWallet)) {
            return false;
        }
        GetWallet getWallet = (GetWallet) obj;
        if (!equals((Object) this.requestid, (Object) getWallet.requestid) || !equals((Object) this.token, (Object) getWallet.token) || !equals((Object) this.bparam, (Object) getWallet.bparam) || !equals((Object) this.wallet_type, (Object) getWallet.wallet_type)) {
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
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Integer num = this.wallet_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetWallet> {
        public BackendParam bparam;
        public String requestid;
        public String token;
        public Integer wallet_type;

        public Builder() {
        }

        public Builder(GetWallet getWallet) {
            super(getWallet);
            if (getWallet != null) {
                this.requestid = getWallet.requestid;
                this.token = getWallet.token;
                this.bparam = getWallet.bparam;
                this.wallet_type = getWallet.wallet_type;
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

        public Builder wallet_type(Integer num) {
            this.wallet_type = num;
            return this;
        }

        public GetWallet build() {
            return new GetWallet(this);
        }
    }
}
