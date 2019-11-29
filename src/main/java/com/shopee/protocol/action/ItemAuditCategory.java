package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum ItemAuditCategory implements ProtoEnum {
    PROHIBITED_LISTING(1),
    COUNTERFEIT(2),
    SPAM(3),
    INAPPROPRIATE_IMAGE(4),
    INSUFFICIENT_INFO(5),
    MALL_LISTING_IMPROVEMENT(6);
    
    private final int value;

    private ItemAuditCategory(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
