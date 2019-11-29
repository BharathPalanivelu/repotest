package com.shopee.protocol.shop;

import com.squareup.wire.ProtoEnum;

public enum ActionCategory implements ProtoEnum {
    ACTION_PROMOTIONS(1),
    ACTION_LISTING_UPDATES(2),
    ACTION_ACTIVITY(3),
    ACTION_ORDER_UPDATES(4),
    ACTION_CHAT(5),
    ACTION_IMPT_UPDATES(6),
    ACTION_RATING(7),
    ACTION_WALLET(8),
    ACTION_ADS(9),
    ACTION_FEED(10),
    ACTION_NOW(11),
    ACTION_DISCUSS_MESSAGES(12),
    ACTION_SHOPEE_PAYLATER(13);
    
    private final int value;

    private ActionCategory(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
