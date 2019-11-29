package com.shopee.protocol.track.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingSearchMethod implements ProtoEnum {
    DEFAULT_SEARCH(1),
    SEARCH_SHOPS(2),
    SEARCH_PRODUCTS(3),
    AUTO_COMPLETE(4),
    POPULAR_SEARCHES(5),
    HISTORCIAL_SEARCH(6),
    SEARCH_IN_MAIN_CATEGORY(7),
    SEARCH_IN_SUBCATEGORY(8),
    SEARCH_IN_ALL_CATEGORY(9),
    SEARCH_IN_BANNER_COLLECITON(10),
    SEARCH_IN_SHOP(11),
    SEARCH_IN_ALL_SHOPS(12);
    
    private final int value;

    private TrackingSearchMethod(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
