package com.shopee.protocol.search.action;

import com.squareup.wire.ProtoEnum;

public enum Command implements ProtoEnum {
    CMD_SEARCH_ITEM(1),
    CMD_SEARCH_FACET(2),
    CMD_GET_COUNT(3),
    CMD_SEARCH_SHOP_CATE_FACET(4),
    CMD_SEARCH_SHOP_HASHTAG_FACET(5),
    CMD_GET_SUBCATID(6),
    CMD_GET_ITEMSCORE(7),
    CMD_SEARCH_UGC_ITEM(8),
    CMD_CATEGORY_LIST(9),
    CMD_RANK_ITEM(10),
    CMD_SEARCH_USER(11),
    CMD_SEARCH_SHOP_ITEM(12),
    CMD_SEARCH_COVER(13),
    CMD_SEARCH_ORDER(14),
    CMD_BATCH_ITEMSCORE(15),
    CMD_SEARCH_SKU(16),
    CMD_SEARCH_ADS(17),
    CMD_SEARCH_ORDER_HINT(18),
    CMD_SEARCH_ORDER_RESULT(19),
    CMD_SEARCH_ADS_FACET(20),
    CMD_SEARCH_LOGISTIC_CHANNEL_FACET(21),
    CMD_CURATED_SEARCH(22),
    CMD_SEARCH_ORDER_BUYER(23),
    CMD_SEARCH_ORDER_SELLER(24),
    CMD_SEARCH_DUPLICATE(39),
    CMD_SEARCH_SPU(40),
    CMD_SEARCH_BRAND_FACET(41),
    CMD_FEED_SEARCH_ITEM(42),
    CMD_FEED_SEARCH_USER(43),
    CMD_SEARCH_SHOP_TYPE_FACET(44),
    CMD_FEED_SEARCH_HASHTAG(45),
    CMD_SEARCH_FILTER(46),
    CMD_GET_ALGO(80);
    
    private final int value;

    private Command(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
