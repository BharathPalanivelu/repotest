package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingSortType implements ProtoEnum {
    POPULAR(1),
    NEARBY(2),
    LATEST(3),
    TOP_SALES(4),
    PRICE_ASC(5),
    PRICE_DESC(6),
    RELEVANCE(7);
    
    private final int value;

    private TrackingSortType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
