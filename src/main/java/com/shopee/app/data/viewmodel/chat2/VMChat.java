package com.shopee.app.data.viewmodel.chat2;

import com.shopee.app.database.orm.bean.chatP2P.DBChat;

public class VMChat {
    private int archive;
    private int buyCount;
    private long chatId;
    private long itemId;
    private long lastMsgId;
    private int lastMsgTime;
    private long modelId;
    private long offerPrice;
    private int offerStatus;
    private long orderId;
    private long pChatId;
    private int shopId;
    private int userId;

    public final long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public final int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public final int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public final int getBuyCount() {
        return this.buyCount;
    }

    public void setBuyCount(int i) {
        this.buyCount = i;
    }

    public final long getOfferPrice() {
        return this.offerPrice;
    }

    public void setOfferPrice(long j) {
        this.offerPrice = j;
    }

    public final int getOfferStatus() {
        return this.offerStatus;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public final long getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(long j) {
        this.lastMsgId = j;
    }

    public final int getLastMsgTime() {
        return this.lastMsgTime;
    }

    public void setLastMsgTime(int i) {
        this.lastMsgTime = i;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public final int getArchive() {
        return this.archive;
    }

    public void setArchive(int i) {
        this.archive = i;
    }

    public final long getModelId() {
        return this.modelId;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public final long getpChatId() {
        return this.pChatId;
    }

    public void setpChatId(long j) {
        this.pChatId = j;
    }

    public static void map(DBChat dBChat, VMChat vMChat) {
        vMChat.setChatId(dBChat.a());
        vMChat.setUserId(dBChat.b());
        vMChat.setShopId(dBChat.c());
        vMChat.setItemId(dBChat.d());
        vMChat.setBuyCount(dBChat.e());
        vMChat.setOfferPrice(dBChat.f());
        vMChat.setOfferStatus(dBChat.g());
        vMChat.setLastMsgId(dBChat.h());
        vMChat.setLastMsgTime(dBChat.i());
        vMChat.setOrderId(dBChat.j());
        vMChat.setArchive(dBChat.k());
        vMChat.setModelId(dBChat.l());
        vMChat.setpChatId(dBChat.m());
    }
}
