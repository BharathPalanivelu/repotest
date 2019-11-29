package com.shopee.app.web.protocol;

public class OpenChatMessage {
    private long itemID;
    private String message;
    private long orderID;
    private int shopID;
    private int userID;

    public int getShopID() {
        return this.shopID;
    }

    public int getUserID() {
        return this.userID;
    }

    public long getItemID() {
        return this.itemID;
    }

    public long getOrderID() {
        return this.orderID;
    }

    public String getMessage() {
        return this.message;
    }
}
