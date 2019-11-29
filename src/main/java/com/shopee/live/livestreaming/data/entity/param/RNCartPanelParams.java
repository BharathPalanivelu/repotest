package com.shopee.live.livestreaming.data.entity.param;

import com.shopee.sdk.b.a;

public class RNCartPanelParams extends a {
    private String backdropColor;
    private int enterType;
    private long itemid;
    private int shopid;

    public RNCartPanelParams(int i, long j, String str, int i2) {
        this.shopid = i;
        this.itemid = j;
        this.backdropColor = str;
        this.enterType = i2;
    }
}
