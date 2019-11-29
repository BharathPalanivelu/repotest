package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum AdsManualTopupStatus implements ProtoEnum {
    REJECTED(0),
    PENDING(1),
    APPROVED(2);
    
    private final int value;

    private AdsManualTopupStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
