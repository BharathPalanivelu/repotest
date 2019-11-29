package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum CardPromotionErrCode implements ProtoEnum {
    USER_MONTHLY_LIMIT(1),
    TOTAL_MONTHLY_LIMIT(2),
    USER_DAILY_LIMIT(3),
    TOTAL_DAILY_LIMIT(4),
    USER_WEEKLY_LIMIT(5),
    TOTAL_WEEKLY_LIMIT(6),
    USER_CYCLE_LIMIT(7),
    TOTAL_CYCLE_LIMIT(8),
    CREDIT_CARD_DAILY_LIMIT(9),
    CREDIT_CARD_WEEKLY_LIMIT(10),
    CREDIT_CARD_MONTHLY_LIMIT(11),
    CREDIT_CARD_CYCLE_LIMIT(12);
    
    private final int value;

    private CardPromotionErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
