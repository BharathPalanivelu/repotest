package com.shopee.app.data.viewmodel.chat;

public class OfferItem {
    private long chatId;
    private boolean isSelling;
    private long itemId;
    private long modelId;
    private String modelName;
    private long offerPrice;
    private int offerQuantity;
    private int offerStatus;
    private int shopId;
    private int userId;

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public boolean isSelling() {
        return this.isSelling;
    }

    public void setSelling(boolean z) {
        this.isSelling = z;
    }

    public long getOfferPrice() {
        return this.offerPrice;
    }

    public void setOfferPrice(long j) {
        this.offerPrice = j;
    }

    public int getOfferQuantity() {
        return this.offerQuantity;
    }

    public void setOfferQuantity(int i) {
        this.offerQuantity = i;
    }

    public int getOfferStatus() {
        return this.offerStatus;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public long getModelId() {
        return this.modelId;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public boolean isOfferAccept() {
        return this.offerStatus == 1;
    }

    public boolean isOfferNew() {
        return this.offerStatus == 2;
    }

    public boolean isOfferRejected() {
        return this.offerStatus == 3;
    }

    public boolean isOfferCancel() {
        return this.offerStatus == 4;
    }
}
