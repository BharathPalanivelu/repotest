package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum BundleDealRuleType implements ProtoEnum {
    BUNDLE_DEAL_RULE_FIX_PRICE(1),
    BUNDLE_DEAL_RULE_DISCOUNT_PERCENTAGE(2),
    BUNDLE_DEAL_RULE_DISCOUNT_VALUE(3);
    
    private final int value;

    private BundleDealRuleType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
