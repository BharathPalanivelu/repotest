package com.shopee.app.data.viewmodel;

public class OrderItemInfo {
    private int amount;
    private long chatId;
    private String currency;
    private long id;
    private long itemId;
    private String itemImage;
    private String itemName;
    private long itemPrice;
    private long modelId;
    private String modelName;
    private long modelPrice;
    private long modelPriceBeforeDiscount;
    private long orderId;
    private long orderPrice;
    private long priceBeforeDiscount;
    private int shopId;
    private long snapshotId;
    private int status;
    private int userId;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long j) {
        this.orderId = j;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getShopId() {
        return this.shopId;
    }

    public void setShopId(int i) {
        this.shopId = i;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long j) {
        this.itemId = j;
    }

    public long getModelId() {
        return this.modelId;
    }

    public void setModelId(long j) {
        this.modelId = j;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int i) {
        this.amount = i;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public long getChatId() {
        return this.chatId;
    }

    public void setChatId(long j) {
        this.chatId = j;
    }

    public void setItemPrice(long j) {
        this.itemPrice = j;
    }

    public long getItemPrice() {
        return this.itemPrice;
    }

    public void setOrderPrice(long j) {
        this.orderPrice = j;
    }

    public long getOrderPrice() {
        return this.orderPrice;
    }

    public String getItemImage() {
        return this.itemImage;
    }

    public void setItemImage(String str) {
        this.itemImage = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public void setSnapshotId(long j) {
        this.snapshotId = j;
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public boolean isRequestReturned() {
        int i = this.status;
        return i == 3 || i == 4;
    }

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public long getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public boolean hasPromotion() {
        long j = this.priceBeforeDiscount;
        return j > 0 && j != this.itemPrice;
    }

    public boolean isAnOffer() {
        return this.orderPrice != this.itemPrice;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelPrice(long j) {
        this.modelPrice = j;
    }

    public long getModelPrice() {
        return this.modelPrice;
    }

    public void setModelPriceBeforeDiscount(long j) {
        this.modelPriceBeforeDiscount = j;
    }

    public long getModelPriceBeforeDiscount() {
        return this.modelPriceBeforeDiscount;
    }

    public boolean isVariant() {
        return this.modelId > 0;
    }

    public boolean variantHasPromotion() {
        if (isVariant()) {
            long j = this.modelPriceBeforeDiscount;
            return j > 0 && j != this.modelPrice;
        }
    }

    public boolean isVariantAnOffer() {
        return isVariant() && this.orderPrice > 0 && isVariant() && this.modelPrice != this.orderPrice;
    }
}
