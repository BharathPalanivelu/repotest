package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FraudCheckSkipReason implements ProtoEnum {
    SKIP_REASON_NOT_SKIPPED(0),
    SKIP_REASON_TOGGLE_OFF(1),
    SKIP_REASON_NETWORK_ERROR(2);
    
    private final int value;

    private FraudCheckSkipReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
