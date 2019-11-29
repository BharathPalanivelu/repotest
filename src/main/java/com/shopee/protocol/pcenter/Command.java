package com.shopee.protocol.pcenter;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_SUBMIT_TASK(1),
    CMD_SET_ITEMPAIR(2),
    CMD_BATCH_GETITEMDETAIL(3),
    CMD_SAMESHOP_EDIT(4);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
