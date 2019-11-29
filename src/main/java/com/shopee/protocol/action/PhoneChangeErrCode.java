package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum PhoneChangeErrCode implements ProtoEnum {
    PC_ERR_NONE(0),
    PC_ERR_FINGERPRINT(1);
    
    private final int value;

    private PhoneChangeErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
