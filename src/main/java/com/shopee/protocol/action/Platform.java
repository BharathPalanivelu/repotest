package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum Platform implements ProtoEnum {
    ANDROID(1),
    IOS(2);
    
    private final int value;

    private Platform(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
