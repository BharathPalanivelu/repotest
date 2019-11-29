package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingPlatformType implements ProtoEnum {
    UNKNOWN(0),
    IOS_WEB(1),
    IOS_APP(2),
    ANDROID_WEB(3),
    ANDROID_APP(4),
    PC_MALL(5),
    OTHERS(128);
    
    private final int value;

    private TrackingPlatformType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
