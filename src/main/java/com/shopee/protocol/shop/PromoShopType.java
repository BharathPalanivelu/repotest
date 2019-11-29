package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PromoShopType implements ProtoEnum {
    Official(1),
    Prefered(2);
    
    private final int value;

    private PromoShopType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
