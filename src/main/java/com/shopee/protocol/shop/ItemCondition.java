package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ItemCondition implements ProtoEnum {
    NOT_SET(0),
    NEW_WITH_TAGS(1),
    NEW_WITHOUT_TAGS(2),
    NEW_WITH_DEFECTS(3),
    USED(4),
    NEW_OTHERS(5),
    USED_LIKE_NEW(6),
    USED_GOOD(7),
    USED_ACCEPTABLE(8),
    USED_WITH_DEFECTS(9);
    
    private final int value;

    private ItemCondition(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
