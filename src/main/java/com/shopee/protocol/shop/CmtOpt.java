package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CmtOpt implements ProtoEnum {
    CMT_OPT_AUTO_RATE(1),
    CMT_OPT_VALID_ITEM_RATING(2);
    
    private final int value;

    private CmtOpt(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
