package com.shopee.protocol.shop;

import com.facebook.internal.NativeProtocol;
import com.squareup.wire.ProtoEnum;

public enum OrderDetailFlag implements ProtoEnum {
    SELLER_SEEN_ORDER_DETAIL_AFTER_SHIPPING_READY(1),
    SERVICE_BY_SHOPEE(2),
    BLOCK_MANUAL_SHIPPING(4),
    IS_WELCOME_PACKAGE(8),
    SHOP_SUPPORT_RECEIPT(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    
    private final int value;

    private OrderDetailFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
