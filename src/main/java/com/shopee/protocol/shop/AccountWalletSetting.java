package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AccountWalletSetting implements ProtoEnum {
    DEFAULT_WALLET(0),
    ENABLE_WALLET(1),
    DISABLE_WALLET(2),
    ENABLE_CB_WALLET(3);
    
    private final int value;

    private AccountWalletSetting(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
