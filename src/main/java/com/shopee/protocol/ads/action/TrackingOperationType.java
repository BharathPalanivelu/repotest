package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum TrackingOperationType implements ProtoEnum {
    IMPRESSION(1),
    CLICK(2),
    VIEW(3),
    ADD_TO_CART(4),
    PLACE_ORDER(5),
    SHOP_IMPRESSION(1001),
    SHOP_CLICK(1002);
    
    private final int value;

    private TrackingOperationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
