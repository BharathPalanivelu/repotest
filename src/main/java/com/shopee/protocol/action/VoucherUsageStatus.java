package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum VoucherUsageStatus implements ProtoEnum {
    NOT_USED(0),
    USED(1),
    RETURNED(2);
    
    private final int value;

    private VoucherUsageStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
