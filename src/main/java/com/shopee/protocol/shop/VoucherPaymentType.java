package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherPaymentType implements ProtoEnum {
    VPT_CREDIT_CARD_NO_INSTALLMENT(1),
    VPT_CREDIT_CARD_INSTALLMENT(2);
    
    private final int value;

    private VoucherPaymentType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
