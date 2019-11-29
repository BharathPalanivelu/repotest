package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopMetricExtraFlag implements ProtoEnum {
    SHOP_METRIC_FIRST_THRESHOLD(1),
    SHOP_METRIC_SECOND_THRESHOLD(2),
    SHOP_METRIC_PUNISH_SECOND_THRESHOLD(1024);
    
    private final int value;

    private ShopMetricExtraFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
