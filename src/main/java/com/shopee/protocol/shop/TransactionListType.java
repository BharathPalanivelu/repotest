package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TransactionListType implements ProtoEnum {
    MONEY_INOUT(1),
    MONEY_IN(2),
    MONEY_OUT(3);
    
    private final int value;

    private TransactionListType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
