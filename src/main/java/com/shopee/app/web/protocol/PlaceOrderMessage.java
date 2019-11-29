package com.shopee.app.web.protocol;

public class PlaceOrderMessage {
    private int orderID;
    private int shopID;
    private int userID;

    public int getOrderID() {
        return this.orderID;
    }

    public int getShopID() {
        return this.shopID;
    }

    public int getUserID() {
        return this.userID;
    }
}
