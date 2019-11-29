package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum AccountNS implements ProtoEnum {
    ACCOUNT_NS_INVALID(0),
    ACCOUNT_NS_USER_NAME(1),
    ACCOUNT_NS_SHOP_NAME(2);
    
    private final int value;

    private AccountNS(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
