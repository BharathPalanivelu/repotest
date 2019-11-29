package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TransType implements ProtoEnum {
    OTHER_ORDER(0),
    ESCROW_ORDER(1),
    WITHDRAW(2);
    
    private final int value;

    private TransType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
