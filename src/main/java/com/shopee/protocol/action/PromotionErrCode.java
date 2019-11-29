package com.shopee.protocol.action;

import com.squareup.wire.ProtoEnum;

public enum PromotionErrCode implements ProtoEnum {
    NONE(0),
    INVALID(1),
    WRONG_CODE(2),
    CODE_EXPIRED(3),
    NO_QUOTA(4),
    NO_APPLICABLE(5),
    ALREADY_USED(6),
    MIN_BUCKET_NOT_MET(7),
    NOT_STARTED(8),
    INVALID_COUNTRY(9),
    NOT_COMPLETE_TASK(10),
    MIN_BUCKET_NOT_MET_AFTER_VOUCHER(11),
    MIN_BUCKET_NOT_MET_MAYBE_SELLER_PROMOTION(12),
    MIN_BUCKET_NOT_MET_MAYBE_CATEGORY(13),
    UA_NO_MATCH(14),
    CREDIT_CARD_NOT_MATCH(15),
    FROM_SELLER_OWN_SHOP(16),
    PAYMENT_NOT_MATCH(17),
    CLAIM_NOT_START(18);
    
    private final int value;

    private PromotionErrCode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
