package com.shopee.app.data.viewmodel.chat;

import com.facebook.common.internal.Objects;

public class ChatProductMessage extends ChatMessage {
    private String modelName;
    private String name;
    private String price;
    private String priceBeforeDiscount;
    private int productCount;
    private long snapshotId;
    private String thumbUrl;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSnapshotId(long j) {
        this.snapshotId = j;
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public int getProductCount() {
        return this.productCount;
    }

    public void setProductCount(int i) {
        this.productCount = i;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public void setPriceBeforeDiscount(String str) {
        this.priceBeforeDiscount = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatProductMessage) || !super.equals(obj)) {
            return false;
        }
        ChatProductMessage chatProductMessage = (ChatProductMessage) obj;
        if (this.snapshotId != chatProductMessage.snapshotId || this.productCount != chatProductMessage.productCount || !Objects.equal(this.name, chatProductMessage.name) || !Objects.equal(this.thumbUrl, chatProductMessage.thumbUrl) || !Objects.equal(this.price, chatProductMessage.price) || !Objects.equal(this.priceBeforeDiscount, chatProductMessage.priceBeforeDiscount) || !Objects.equal(this.modelName, chatProductMessage.modelName)) {
            return false;
        }
        return true;
    }
}
