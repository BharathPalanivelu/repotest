package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum FraudLogisticsReason implements ProtoEnum {
    OTHER_REASON(1),
    FREE_SHIPPING_DAILY_QUOTA_EXCEED(2),
    FREE_SHIPPING_WEEKLY_QUOTA_EXCEED(3),
    FREE_SHIPPING_MONTHLY_QUOTA_EXCEED(4),
    DUPLICATED_CONSIGNMENT_NO(5);
    
    private final int value;

    private FraudLogisticsReason(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
