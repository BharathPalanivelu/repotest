package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum CoinRejectErrcode implements ProtoEnum {
    CR_OK(0),
    CR_INVALID_ORDERID(1),
    CR_ALREADY_SUCCESS(2),
    CR_ALREADY_FAILED(3),
    CR_ALREADY_ALLOWED(4),
    CR_ALREADY_RELEASED(5);
    
    private final int value;

    private CoinRejectErrcode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
