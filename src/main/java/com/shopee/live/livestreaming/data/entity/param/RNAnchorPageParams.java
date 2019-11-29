package com.shopee.live.livestreaming.data.entity.param;

import com.shopee.sdk.b.a;

public class RNAnchorPageParams extends a {
    private int shopid;

    public RNAnchorPageParams(int i) {
        this.shopid = i;
    }

    public int getShopid() {
        return this.shopid;
    }

    public void setShopid(int i) {
        this.shopid = i;
    }
}
