package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingPlacement implements ProtoEnum {
    KEYWORD_SEARCH(0),
    SIMILAR_ITEM_RECOMMEND(1),
    DAILY_DISCOVER_RECOMMEND(2),
    SHOP_SEARCH(3),
    SIMPLE_MODE_SEARCH(4);
    
    private final int value;

    private TrackingPlacement(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
