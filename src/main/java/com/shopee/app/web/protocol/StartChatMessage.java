package com.shopee.app.web.protocol;

public class StartChatMessage {
    private String callbackId;
    private long itemID;
    private String message;
    private int shopID;
    private int userID;

    public int getShopID() {
        return this.shopID;
    }

    public void setShopID(int i) {
        this.shopID = i;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public long getItemID() {
        return this.itemID;
    }

    public void setItemID(long j) {
        this.itemID = j;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public void setCallbackId(String str) {
        this.callbackId = str;
    }

    public String getMessage() {
        return this.message;
    }
}
