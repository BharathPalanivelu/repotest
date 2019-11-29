package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WalletTransactionExtinfo extends Message {
    public static final String DEFAULT_REASON = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String reason;

    public WalletTransactionExtinfo(String str) {
        this.reason = str;
    }

    private WalletTransactionExtinfo(Builder builder) {
        this(builder.reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletTransactionExtinfo)) {
            return false;
        }
        return equals((Object) this.reason, (Object) ((WalletTransactionExtinfo) obj).reason);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.reason;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<WalletTransactionExtinfo> {
        public String reason;

        public Builder() {
        }

        public Builder(WalletTransactionExtinfo walletTransactionExtinfo) {
            super(walletTransactionExtinfo);
            if (walletTransactionExtinfo != null) {
                this.reason = walletTransactionExtinfo.reason;
            }
        }

        public Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public WalletTransactionExtinfo build() {
            return new WalletTransactionExtinfo(this);
        }
    }
}
