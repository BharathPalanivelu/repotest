package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum UserAgentType implements ProtoEnum {
    IOS(1),
    ANDROID(2),
    WEB(4);
    
    private final int value;

    private UserAgentType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
