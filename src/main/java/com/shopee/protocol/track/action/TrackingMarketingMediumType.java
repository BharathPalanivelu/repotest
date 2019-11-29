package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingMarketingMediumType implements ProtoEnum {
    POPUP_BANNER(0),
    ACTIVITY_BANNER(1),
    CATEGORY_BANNER(2),
    PN(3),
    EDM(4),
    FB(5),
    SMS(6),
    ONLINE_MARKETING(7);
    
    private final int value;

    private TrackingMarketingMediumType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
