package com.shopee.app.web.protocol.notification;

public class RateOrderMessage {
    private int hasGoodRate = 0;
    private long orderID;
    private int shopID;

    public long getOrderID() {
        return this.orderID;
    }

    public int getShopID() {
        return this.shopID;
    }

    public int getHasGoodRate() {
        return this.hasGoodRate;
    }
}
