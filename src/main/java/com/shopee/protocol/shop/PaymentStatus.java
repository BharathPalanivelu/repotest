package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum PaymentStatus implements ProtoEnum {
    NONE(0),
    SUCCESS(1),
    BANK_TRANSFER_INIT(100),
    BANK_TRANSFER_VERIFYING(101),
    BANK_TRANSFER_REINIT(102),
    BANK_TRANSFER_PENDING(103),
    OFFLINE_PAYMENT(200);
    
    private final int value;

    private PaymentStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
