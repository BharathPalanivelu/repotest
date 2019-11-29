package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum GroupBuyErrCode implements ProtoEnum {
    GB_ERR_NONE(0),
    GB_PURCHASE_LIMIT(1),
    GB_UNPAID_ORDER_LIMIT(2),
    GB_GROUP_INVALID(3),
    GB_CAMPAIGN_INVALID(4);
    
    private final int value;

    private GroupBuyErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
