package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WalletProvider implements ProtoEnum {
    SHOPEE_WALLET_V2(1),
    AIRPAY_WALLET(2);
    
    private final int value;

    private WalletProvider(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
