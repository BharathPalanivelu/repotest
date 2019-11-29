package com.shopee.protocol.index.action;

import com.squareup.wire.ProtoEnum;

public enum SearchIndexType implements ProtoEnum {
    ITEM(1),
    USER(2),
    SHOP(3),
    COLLECTION(4),
    SHOPCOLLECTION(5),
    BUYERADDRESS(6),
    ORDER(7),
    ITEMMODEL(8),
    CATEGORY(9),
    PRODUCTBOOST(10),
    PROMOTION(11),
    PROMOTIONITEM(12),
    SPU(13),
    SPU_ATTR(14),
    ATTR(15),
    ITEM_COLLECTION(16),
    ITEM_SHOPCOLLECTION(17),
    ITEM_ATTR(18),
    SPU_ITEM_PRODUCTION(19),
    CURATED_ACTIVITY(20),
    CURATED_MODULE(21),
    ITEM_COMMENT(22),
    FEED_HASHTAG(23),
    ITEM_PRICE(24),
    ADS_ACCOUNT(128),
    ADS_CAMPAIGN(129),
    ADS_ADVERTISEMENT(130),
    ADS_TRANSLOG(131);
    
    private final int value;

    private SearchIndexType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
