package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ItemListType implements ProtoEnum {
    DEFAULT(0),
    LATEST(1),
    POPULAR(2),
    STOCK(3),
    SOLDOUT(4),
    RECOMMEND(5),
    NEWEST(6),
    TOUCHTIME(7),
    STOCKOUT(8),
    UNLIST(9);
    
    private final int value;

    private ItemListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
