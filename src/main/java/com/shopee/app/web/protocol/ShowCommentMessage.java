package com.shopee.app.web.protocol;

public class ShowCommentMessage {
    private long itemID;
    public boolean ratings;
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

    public void setItemId(int i) {
        this.itemID = (long) i;
    }
}
