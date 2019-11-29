package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum LabelGroupOp implements ProtoEnum {
    AND(0),
    OR(1);
    
    private final int value;

    private LabelGroupOp(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
