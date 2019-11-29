package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum VoucherListType implements ProtoEnum {
    V_VALID(0),
    V_USED(1),
    V_INVALID(2);
    
    private final int value;

    private VoucherListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
