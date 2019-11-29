package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum TxnFeeType implements ProtoEnum {
    SELLER_TXN_FEE(0),
    BUYER_TXN_FEE(1);
    
    private final int value;

    private TxnFeeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
