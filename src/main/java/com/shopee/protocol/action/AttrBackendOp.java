package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum AttrBackendOp implements ProtoEnum {
    OP_ADD_TO_QCLIST(1),
    OP_DEL_FROM_QCLIST(2),
    OP_ADD_TO_OFFICIAL(3),
    OP_DEL_FROM_OFFICIAL(4),
    OP_ADD_TO_FAILED(5),
    OP_DEL_FROM_FAILED(6),
    OP_DEL_ATTR_FROM_MODEL(7),
    OP_CHANGE_MODEL(8);
    
    private final int value;

    private AttrBackendOp(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
