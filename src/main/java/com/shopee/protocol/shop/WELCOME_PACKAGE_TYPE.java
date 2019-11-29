package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum WELCOME_PACKAGE_TYPE implements ProtoEnum {
    NON_WELCOME_PACKAGE(0),
    FREE_GIFT(1),
    EXCLUSIVE_ITEMS(2);
    
    private final int value;

    private WELCOME_PACKAGE_TYPE(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
