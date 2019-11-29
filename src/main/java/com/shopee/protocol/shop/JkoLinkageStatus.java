package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum JkoLinkageStatus implements ProtoEnum {
    LINKED(1),
    UNLINKED(2);
    
    private final int value;

    private JkoLinkageStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
