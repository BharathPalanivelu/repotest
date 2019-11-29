package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum SpuLabal implements ProtoEnum {
    NEW(1),
    HOT(2);
    
    private final int value;

    private SpuLabal(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
