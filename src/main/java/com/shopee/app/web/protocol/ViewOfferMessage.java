package com.shopee.app.web.protocol;

public class ViewOfferMessage {
    private long itemID;
    private int shopID;

    public int getShopID() {
        return this.shopID;
    }

    public long getItemID() {
        return this.itemID;
    }
}
