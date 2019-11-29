package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum BankTransferOption implements ProtoEnum {
    NORMAL(1),
    ATM_PAYMENT(2),
    INTERNET_BANKING(3),
    ATM_MOBILE(4),
    ATM_INTERNET(5);
    
    private final int value;

    private BankTransferOption(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
