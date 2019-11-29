package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum SearchItemSortType implements ProtoEnum {
    SORTBY_POPULAR_DESC(1),
    SORTBY_LATEST_DESC(2),
    SORTBY_DISTANCE_DESC(3),
    SORTBY_PRICE_DESC(4),
    SORTBY_POPULAR_ASC(5),
    SORTBY_LATEST_ASC(6),
    SORTBY_DISTANCE_ASC(7),
    SORTBY_PRICE_ASC(8),
    SORTBY_RELEVANCE(9),
    SORTBY_DISCOUNT_ASC(10),
    SORTBY_DISCOUNT_DESC(11),
    SORTBY_SHOP_REVIEW(12),
    SORTBY_ITEM_SOLD_DESC(13),
    SORTBY_EXPERIMENT(14);
    
    private final int value;

    private SearchItemSortType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
