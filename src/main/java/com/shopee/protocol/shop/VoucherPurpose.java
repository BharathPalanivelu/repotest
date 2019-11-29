package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum VoucherPurpose implements ProtoEnum {
    VOUCHER_WELCOME(1),
    VOUCHER_REFERRAL(2),
    VOUCHER_SHOP_FOLLOW(3);
    
    private final int value;

    private VoucherPurpose(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
