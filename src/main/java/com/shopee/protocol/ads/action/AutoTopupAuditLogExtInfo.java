package com.shopee.protocol.ads.action;

import com.shopee.protocol.action.WalletTransactionCreate;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AutoTopupAuditLogExtInfo extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final WalletTransactionCreate wallet_request;

    public AutoTopupAuditLogExtInfo(WalletTransactionCreate walletTransactionCreate) {
        this.wallet_request = walletTransactionCreate;
    }

    private AutoTopupAuditLogExtInfo(Builder builder) {
        this(builder.wallet_request);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoTopupAuditLogExtInfo)) {
            return false;
        }
        return equals((Object) this.wallet_request, (Object) ((AutoTopupAuditLogExtInfo) obj).wallet_request);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            WalletTransactionCreate walletTransactionCreate = this.wallet_request;
            i = walletTransactionCreate != null ? walletTransactionCreate.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<AutoTopupAuditLogExtInfo> {
        public WalletTransactionCreate wallet_request;

        public Builder() {
        }

        public Builder(AutoTopupAuditLogExtInfo autoTopupAuditLogExtInfo) {
            super(autoTopupAuditLogExtInfo);
            if (autoTopupAuditLogExtInfo != null) {
                this.wallet_request = autoTopupAuditLogExtInfo.wallet_request;
            }
        }

        public Builder wallet_request(WalletTransactionCreate walletTransactionCreate) {
            this.wallet_request = walletTransactionCreate;
            return this;
        }

        public AutoTopupAuditLogExtInfo build() {
            return new AutoTopupAuditLogExtInfo(this);
        }
    }
}
