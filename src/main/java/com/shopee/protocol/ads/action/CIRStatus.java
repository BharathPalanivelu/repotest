package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum CIRStatus implements ProtoEnum {
    CIR_DELETED(0),
    CIR_ACTIVE(1);
    
    private final int value;

    private CIRStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
