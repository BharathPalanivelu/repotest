package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum SortPosition implements ProtoEnum {
    NON_SPECIFIED_POSITION(Integer.MAX_VALUE);
    
    private final int value;

    private SortPosition(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
