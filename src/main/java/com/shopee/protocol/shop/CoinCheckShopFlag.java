package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CoinCheckShopFlag implements ProtoEnum {
    SPEND(1),
    EARN(2);
    
    private final int value;

    private CoinCheckShopFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
