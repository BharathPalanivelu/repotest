package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingFilterType implements ProtoEnum {
    SHORTCUT(1),
    PANEL(2);
    
    private final int value;

    private TrackingFilterType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
