package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WalletType implements ProtoEnum {
    Buyer(1),
    Seller(2),
    BuyerAndSeller(3);
    
    private final int value;

    private WalletType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
