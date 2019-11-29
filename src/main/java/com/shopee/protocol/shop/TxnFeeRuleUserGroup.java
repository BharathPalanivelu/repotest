package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TxnFeeRuleUserGroup implements ProtoEnum {
    TXN_FEE_RULE_USER_DEFAULT(0),
    TXN_FEE_RULE_CB_SELLER(1),
    TXN_FEE_RULE_SPECIAL_GROUP(2);
    
    private final int value;

    private TxnFeeRuleUserGroup(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
