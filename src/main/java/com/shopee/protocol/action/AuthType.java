package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum AuthType implements ProtoEnum {
    AUTHTYPE_PASSWORD(1),
    AUTHTYPE_BA_OR_CC(2),
    AUTHTYPE_OTP(3);
    
    private final int value;

    private AuthType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
