package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum AutoGenType implements ProtoEnum {
    ALL_USERS(1),
    AU1(2),
    AU3(3),
    AU7(4),
    AU14(5),
    AU30(6);
    
    private final int value;

    private AutoGenType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
