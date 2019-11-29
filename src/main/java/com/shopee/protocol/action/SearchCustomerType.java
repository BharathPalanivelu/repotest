package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum SearchCustomerType implements ProtoEnum {
    CUSTOMER_USER(1),
    CUSTOMER_ORDER(2),
    CUSTOMER_RECIPIENT(3),
    CUSTOMER_RECIPIENTORDER(4);
    
    private final int value;

    private SearchCustomerType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
