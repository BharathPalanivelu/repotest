package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum FEQueryWriteStatus implements ProtoEnum {
    NORMAL(0),
    NO_RESULT(1),
    NORMAL_WITH_HINT(2),
    TOO_FEW(3),
    EMPTY(4),
    EMPTY_WITH_DROPWORDS(5),
    SHOP_INTENTION(6);
    
    private final int value;

    private FEQueryWriteStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
