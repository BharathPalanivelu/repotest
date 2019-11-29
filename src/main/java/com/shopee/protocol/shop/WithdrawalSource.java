package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WithdrawalSource implements ProtoEnum {
    ONETIME_SELLER(1),
    ONETIME_ADMIN(2),
    RECURRING(3);
    
    private final int value;

    private WithdrawalSource(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
