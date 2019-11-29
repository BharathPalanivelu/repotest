package com.shopee.protocol.shop;

import com.squareup.wire.Message;

public final class AccountIntegrationExtraInfo extends Message {
    private static final long serialVersionUID = 0;

    public int hashCode() {
        return 0;
    }

    public AccountIntegrationExtraInfo() {
    }

    private AccountIntegrationExtraInfo(Builder builder) {
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        return obj instanceof AccountIntegrationExtraInfo;
    }

    public static final class Builder extends Message.Builder<AccountIntegrationExtraInfo> {
        public Builder() {
        }

        public Builder(AccountIntegrationExtraInfo accountIntegrationExtraInfo) {
            super(accountIntegrationExtraInfo);
        }

        public AccountIntegrationExtraInfo build() {
            return new AccountIntegrationExtraInfo(this);
        }
    }
}
