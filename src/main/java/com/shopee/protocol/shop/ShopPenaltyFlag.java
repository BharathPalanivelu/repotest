package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ShopPenaltyFlag implements ProtoEnum {
    LISTING_NON_BROWSABLE(1),
    LISTING_NON_SEARCHABLE(2),
    DISABLE_CREATE_LISTING(4),
    DISABLE_EDIT_LISTING(8),
    PUNISHMENT_DISABLE_MARKETING(16),
    PUNISHMENT_DISABLE_FREE_SHIP(32),
    PUNISHMENT_FREEZE_SHOP(64);
    
    private final int value;

    private ShopPenaltyFlag(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
