package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum BundleDealFlagType implements ProtoEnum {
    BUNDLE_DEAL_FLAG_SHOPEE(0),
    BUNDLE_DEAL_FLAG_SHOPEE_MULTI_SHOP(1),
    BUNDLE_DEAL_FLAG_SELLER(2);
    
    private final int value;

    private BundleDealFlagType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
