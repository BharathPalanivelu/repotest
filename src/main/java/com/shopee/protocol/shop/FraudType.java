package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FraudType implements ProtoEnum {
    FRAUD_TYPE_OTHER(1),
    FRAUD_TYPE_LOGISTICS(2),
    FRAUD_TYPE_PAYMENT(3),
    FRAUD_TYPE_ITEM(4);
    
    private final int value;

    private FraudType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
