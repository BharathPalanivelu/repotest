package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ReturnSubListType implements ProtoEnum {
    RETURN_SUB_LIST_ALL(0),
    RETURN_SUB_LIST_UNPROCESSED(1),
    RETURN_SUB_LIST_PROCESSED(2);
    
    private final int value;

    private ReturnSubListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
