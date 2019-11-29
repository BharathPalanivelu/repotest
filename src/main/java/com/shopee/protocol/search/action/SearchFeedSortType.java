package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum SearchFeedSortType implements ProtoEnum {
    PostCount(1),
    LatestUpdate(2),
    Alphabet(3),
    Popularity(4);
    
    private final int value;

    private SearchFeedSortType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
