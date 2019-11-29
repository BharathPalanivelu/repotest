package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CmtFilter implements ProtoEnum {
    CMT_FILTER_CONTEXT(1),
    CMT_FILTER_IMAGE(2);
    
    private final int value;

    private CmtFilter(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
