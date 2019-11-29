package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum WhiteListFeatureType implements ProtoEnum {
    TARGET_ADS_DD(9),
    TARGET_ADS_SIMILAR_ITEMS(10),
    TARGET_ADS_YMAL(11),
    SEARCH_SHOP_ADS(12),
    SEARCH_ITEM_ADS(13),
    SIMPLE_MODE(14),
    AUTO_TOP_UP(15),
    KEYWORD_ADS_OCPC(16);
    
    private final int value;

    private WhiteListFeatureType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
