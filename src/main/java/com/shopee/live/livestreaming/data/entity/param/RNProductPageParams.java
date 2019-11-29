package com.shopee.live.livestreaming.data.entity.param;

import com.shopee.sdk.b.a;

public class RNProductPageParams extends a {
    private long itemid;
    private int shopid;

    public RNProductPageParams(int i, long j) {
        this.shopid = i;
        this.itemid = j;
    }

    public int getShopid() {
        return this.shopid;
    }

    public void setShopid(int i) {
        this.shopid = i;
    }

    public long getItemid() {
        return this.itemid;
    }

    public void setItemid(long j) {
        this.itemid = j;
    }
}
