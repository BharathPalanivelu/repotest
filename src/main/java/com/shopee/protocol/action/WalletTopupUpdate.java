package com.shopee.protocol.action;

import com.shopee.protocol.shop.WalletTopup;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletTopupUpdate extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final WalletTopup topup;

    public WalletTopupUpdate(String str, String str2, BackendParam backendParam, WalletTopup walletTopup) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.topup = walletTopup;
    }

    private WalletTopupUpdate(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.topup);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTopupUpdate)) {
            return false;
        }
        WalletTopupUpdate walletTopupUpdate = (WalletTopupUpdate) obj;
        if (!equals((Object) this.requestid, (Object) walletTopupUpdate.requestid) || !equals((Object) this.token, (Object) walletTopupUpdate.token) || !equals((Object) this.bparam, (Object) walletTopupUpdate.bparam) || !equals((Object) this.topup, (Object) walletTopupUpdate.topup)) {
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
        WalletTopup walletTopup = this.topup;
        if (walletTopup != null) {
            i2 = walletTopup.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTopupUpdate> {
        public BackendParam bparam;
        public String requestid;
        public String token;
        public WalletTopup topup;

        public Builder() {
        }

        public Builder(WalletTopupUpdate walletTopupUpdate) {
            super(walletTopupUpdate);
            if (walletTopupUpdate != null) {
                this.requestid = walletTopupUpdate.requestid;
                this.token = walletTopupUpdate.token;
                this.bparam = walletTopupUpdate.bparam;
                this.topup = walletTopupUpdate.topup;
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

        public Builder topup(WalletTopup walletTopup) {
            this.topup = walletTopup;
            return this;
        }

        public WalletTopupUpdate build() {
            checkRequiredFields();
            return new WalletTopupUpdate(this);
        }
    }
}
