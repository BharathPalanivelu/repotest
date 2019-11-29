package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AccountIntegrationThirdPartyType implements ProtoEnum {
    FOODY(3),
    AIRPAY(4),
    APPLE(5);
    
    private final int value;

    private AccountIntegrationThirdPartyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
