package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AccountIntegrationStatus implements ProtoEnum {
    VALID(1),
    INVALID(2);
    
    private final int value;

    private AccountIntegrationStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
