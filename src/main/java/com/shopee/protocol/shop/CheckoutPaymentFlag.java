package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CheckoutPaymentFlag implements ProtoEnum {
    REFUND_BY_API(1),
    NEED_BANK_ACCOUNT(2),
    IS_CREDIT_CARD(4),
    IS_FREE_SHIPPING(8),
    IS_INSTALLMENT(16),
    MANUAL_ESCROW(32),
    IS_SAFE_INTEGRATED(64),
    SUPPORT_PARTIAL_REFUND(128);
    
    private final int value;

    private CheckoutPaymentFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
