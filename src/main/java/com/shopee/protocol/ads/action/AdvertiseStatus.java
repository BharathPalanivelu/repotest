package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum AdvertiseStatus implements ProtoEnum {
    ADS_DELETED(0),
    ADS_NORMAL(1),
    ADS_PAUSED(2),
    ADS_CLOSED(3);
    
    private final int value;

    private AdvertiseStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
