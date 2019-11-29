package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum CoinRejectActionFlag implements ProtoEnum {
    BLOCK_ORDER_COINS(1),
    BLOCK_CASHBACKVOUCHER_COINS(2),
    BLOCK_REFERRAL_COINS(4);
    
    private final int value;

    private CoinRejectActionFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
