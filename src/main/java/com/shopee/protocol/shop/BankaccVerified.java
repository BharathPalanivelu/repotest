package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum BankaccVerified implements ProtoEnum {
    UNSUBMIT(0),
    REQUESTED(1),
    APPROVED(2),
    REJECTED(3),
    CHECKED(4),
    BANNED(5);
    
    private final int value;

    private BankaccVerified(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
