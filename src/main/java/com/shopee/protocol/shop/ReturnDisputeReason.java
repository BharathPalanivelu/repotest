package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ReturnDisputeReason implements ProtoEnum {
    REJECT_NONRECEIPT(1),
    REJECT_OTHER(2),
    NOT_RECEIVED(3);
    
    private final int value;

    private ReturnDisputeReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
