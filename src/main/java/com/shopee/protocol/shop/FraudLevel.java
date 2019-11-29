package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FraudLevel implements ProtoEnum {
    FRAUD_LEVEL_OTHER(1),
    FRAUD_LEVEL_USER(2),
    FRAUD_LEVEL_DEVICE(3),
    FRAUD_LEVEL_WEB(4);
    
    private final int value;

    private FraudLevel(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
