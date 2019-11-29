package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TaskRunnerJobType implements ProtoEnum {
    SET_ITEM_PREVIEW(1),
    UNSET_ITEM_PREVIEW(2);
    
    private final int value;

    private TaskRunnerJobType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
