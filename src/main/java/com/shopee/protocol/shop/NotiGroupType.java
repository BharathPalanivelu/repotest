package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum NotiGroupType implements ProtoEnum {
    GROUPBY_CHECKOUT(1),
    GROUPBY_ORDER(2),
    GROUPBY_TRANS(3),
    GROUPBY_TOPUP(4),
    GROUPBY_DP_ORDER(5);
    
    private final int value;

    private NotiGroupType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
