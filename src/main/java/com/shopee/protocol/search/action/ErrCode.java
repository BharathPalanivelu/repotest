package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum ErrCode implements ProtoEnum {
    Success(0),
    InternalError(1);
    
    private final int value;

    private ErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
