package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CompareMethod implements ProtoEnum {
    EQUAL(1),
    LE(2),
    GE(3),
    LESS(4),
    GREATER(5),
    IN(6),
    NOTIN(7);
    
    private final int value;

    private CompareMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
