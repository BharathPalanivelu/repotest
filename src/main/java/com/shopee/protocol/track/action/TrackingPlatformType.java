package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingPlatformType implements ProtoEnum {
    PLATFORM_TYPE_OTHERS(1),
    PLATFORM_TYPE_IOS_WEB(2),
    PLATFORM_TYPE_IOS_APP(3),
    PLATFORM_TYPE_ANDROID_WEB(4),
    PLATFORM_TYPE_ANDROID_APP(5),
    PLATFORM_TYPE_PC_MALL(6);
    
    private final int value;

    private TrackingPlatformType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
