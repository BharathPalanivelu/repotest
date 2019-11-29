package com.shopee.app.web.protocol;

public class ShowEditProductMessage {
    private long itemID;
    private int shopID;

    public int getShopId() {
        return this.shopID;
    }

    public void setShopId(int i) {
        this.shopID = i;
    }

    public long getItemId() {
        return this.itemID;
    }

    public void setItemId(long j) {
        this.itemID = j;
    }
}
