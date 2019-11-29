package com.shopee.protocol.ads.action;

import com.squareup.wire.ProtoEnum;

public enum ESAggSumField implements ProtoEnum {
    All(1),
    Impression(2),
    Click(3),
    Order(4),
    ItemCount(5),
    GMV(6),
    Expense(7),
    ShopItemImpression(8),
    ShopItemClick(9),
    BroadShopItemImpression(10),
    BroadShopItemClick(11),
    BroadOrder(12),
    BroadItemCount(13),
    BroadGMV(14),
    LocationInAds(15);
    
    private final int value;

    private ESAggSumField(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
