package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingOperationType implements ProtoEnum {
    TABSTAY(1),
    VIEW(2),
    IMPRESSION(3),
    CLICK(4),
    SEARCH(5),
    FILTER(6),
    SORT(7),
    LIKE(8),
    UNLIKE(9),
    EXPAND(10),
    FOLD(11);
    
    private final int value;

    private TrackingOperationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
