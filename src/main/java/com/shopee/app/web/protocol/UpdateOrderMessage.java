package com.shopee.app.web.protocol;

public class UpdateOrderMessage {
    private long orderID;
    private int shopID;

    public long getOrderID() {
        return this.orderID;
    }

    public int getShopID() {
        return this.shopID;
    }
}
