package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum EscrowOption implements ProtoEnum {
    ESCROW_OFF(0),
    ESCROW_ON(1);
    
    private final int value;

    private EscrowOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
