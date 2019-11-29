package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum InstallmentFilterOption implements ProtoEnum {
    CREDIT_CARD(1),
    NON_CREDIT_CARD(2);
    
    private final int value;

    private InstallmentFilterOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
