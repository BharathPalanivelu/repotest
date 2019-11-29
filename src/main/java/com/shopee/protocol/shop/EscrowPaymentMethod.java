package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum EscrowPaymentMethod implements ProtoEnum {
    BANK_TRANSFER(1),
    SEVEN_ELEVEN(2);
    
    private final int value;

    private EscrowPaymentMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
