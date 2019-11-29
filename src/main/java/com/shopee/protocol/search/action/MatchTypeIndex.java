package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum MatchTypeIndex implements ProtoEnum {
    MATCH_SHOP(1),
    MATCH_CATEGORY(2),
    MATCH_COLLECTION(3),
    MATCH_HASHTAG(4),
    MATCH_SHOP_CATE(5),
    MATCH_KEYWORD(6),
    MATCH_ITEM(7),
    MATCH_ATTRIBUTE(8),
    MATCH_SKU(9),
    MATCH_ADDRESS(10),
    MATCH_LOGISTIC(11),
    MATCH_VOUCHER(12),
    MATCH_RATING(13),
    MATCH_LABEL(14),
    MATCH_BRAND(15),
    MATCH_FE_CATEGORY(16);
    
    private final int value;

    private MatchTypeIndex(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
