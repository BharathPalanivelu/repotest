package com.shopee.protocol.action;

import com.shopee.protocol.shop.WalletTopup;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletTopupAdd extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4)
    public final WalletTopup topup;

    public WalletTopupAdd(String str, String str2, WalletTopup walletTopup) {
        this.requestid = str;
        this.token = str2;
        this.topup = walletTopup;
    }

    private WalletTopupAdd(Builder builder) {
        this(builder.requestid, builder.token, builder.topup);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTopupAdd)) {
            return false;
        }
        WalletTopupAdd walletTopupAdd = (WalletTopupAdd) obj;
        if (!equals((Object) this.requestid, (Object) walletTopupAdd.requestid) || !equals((Object) this.token, (Object) walletTopupAdd.token) || !equals((Object) this.topup, (Object) walletTopupAdd.topup)) {
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
        WalletTopup walletTopup = this.topup;
        if (walletTopup != null) {
            i2 = walletTopup.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WalletTopupAdd> {
        public String requestid;
        public String token;
        public WalletTopup topup;

        public Builder() {
        }

        public Builder(WalletTopupAdd walletTopupAdd) {
            super(walletTopupAdd);
            if (walletTopupAdd != null) {
                this.requestid = walletTopupAdd.requestid;
                this.token = walletTopupAdd.token;
                this.topup = walletTopupAdd.topup;
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

        public Builder topup(WalletTopup walletTopup) {
            this.topup = walletTopup;
            return this;
        }

        public WalletTopupAdd build() {
            checkRequiredFields();
            return new WalletTopupAdd(this);
        }
    }
}
