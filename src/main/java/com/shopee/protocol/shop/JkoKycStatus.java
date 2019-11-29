package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum JkoKycStatus implements ProtoEnum {
    JKO_APPROVED(1),
    JKO_REJECTED(2);
    
    private final int value;

    private JkoKycStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
