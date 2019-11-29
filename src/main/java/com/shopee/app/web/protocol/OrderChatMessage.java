package com.shopee.app.web.protocol;

public class OrderChatMessage {
    long orderID;
    int shopID;
    int userID;

    public int getShopID() {
        return this.shopID;
    }

    public int getUserID() {
        return this.userID;
    }

    public long getOrderID() {
        return this.orderID;
    }
}
