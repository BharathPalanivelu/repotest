package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopPenaltyType implements ProtoEnum {
    PENALTY_TYPE_FLUSH(-1),
    PENALTY_TYPE_MANUAL(0),
    PENALTY_TYPE_HIGH_NON_FULFILMENT(1),
    PENALTY_TYPE_HIGH_LATE_SHIPMENT(2),
    PENALTY_TYPE_PROHIBITED_LISTING(3),
    PENALTY_TYPE_COUNTERFEIT(4),
    PENALTY_TYPE_SPAM(5),
    PENALTY_TYPE_OFFICIAL_SHOP_FRAUD(6),
    PENALTY_TYPE_OFFICIAL_SHOP_FRAUD_VOUCHER(7),
    PENALTY_TYPE_CHAT_RESPONSE_RATE_OFFICIAL(8),
    PENALTY_TYPE_CHAT_RESPONSE_RATE_NORMAL(9),
    PENALTY_TYPE_COPY_IMAGE(10),
    PENALTY_TYPE_RUDE_CHAT(11),
    PENALTY_TYPE_FAKE_RETURN_ADDRESS(12);
    
    private final int value;

    private ShopPenaltyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
