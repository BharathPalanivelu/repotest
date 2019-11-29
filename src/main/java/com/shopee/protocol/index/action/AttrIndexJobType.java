package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum AttrIndexJobType implements ProtoEnum {
    JOB_ATTR(1),
    JOB_ATTR_VALUE(2);
    
    private final int value;

    private AttrIndexJobType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
