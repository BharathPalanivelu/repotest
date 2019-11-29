package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopMetricOrderType implements ProtoEnum {
    SHOP_METRIC_ORDER_LATE_SHIPMENT(1),
    SHOP_METRIC_ORDER_RETURN(2),
    SHOP_METRIC_ORDER_CANCEL(3);
    
    private final int value;

    private ShopMetricOrderType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
