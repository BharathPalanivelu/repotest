package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum TransOperation implements ProtoEnum {
    DEDUCT_CLICK(1),
    TOPUP(2),
    TOPUP_MANUAL(3),
    TOPUP_WALLET(4);
    
    private final int value;

    private TransOperation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
