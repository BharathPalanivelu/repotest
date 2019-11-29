package com.shopee.app.data.viewmodel.chat;

public class ChatInfo {
    private long itemId;
    private long orderId;
    private long pChatId;
    private int shopId;
    private int toUserId;
    private int toUserShopId;

    public ChatInfo(long j, int i, int i2, long j2, long j3) {
        this.itemId = j;
        this.toUserId = i;
        this.shopId = i2;
        this.orderId = j2;
        this.pChatId = j3;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public int getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int i) {
        this.toUserId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public boolean isOrderChat() {
        return this.orderId > 0;
    }

    public long getPChatId() {
        return this.pChatId;
    }

    public void setPChatId(long j) {
        this.pChatId = j;
    }

    public void setToShopId(int i) {
        this.toUserShopId = i;
    }

    public int getToUserShopId() {
        return this.toUserShopId;
    }
}
