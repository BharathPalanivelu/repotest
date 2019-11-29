package com.shopee.app.data.viewmodel.chat;

import com.facebook.common.internal.Objects;
import com.shopee.app.data.viewmodel.chatP2P.VMOffer;
import com.shopee.app.util.au;

public class ChatOfferMessage extends ChatMessage {
    private String currency;
    private String imageUrl;
    private String itemName;
    private String modelName;
    private VMOffer offer;
    private long offerId;
    private int offerStatus;
    private long originalPrice;
    private long price;
    private long priceBeforeDiscount;
    private int quantity;

    public long getPrice() {
        return this.price;
    }

    public String getPriceString() {
        return au.a(this.price, this.currency);
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public int getOfferStatus() {
        return this.offerStatus;
    }

    public void setOfferStatus(int i) {
        this.offerStatus = i;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setOfferId(long j) {
        this.offerId = j;
    }

    public long getOfferId() {
        return this.offerId;
    }

    public void setItemName(String str) {
        this.itemName = str;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setModelName(String str) {
        this.modelName = str;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setPriceBeforeDiscount(long j) {
        this.priceBeforeDiscount = j;
    }

    public long getPriceBeforeDiscount() {
        return this.priceBeforeDiscount;
    }

    public void setOriginalPrice(long j) {
        this.originalPrice = j;
    }

    public long getOriginalPrice() {
        return this.originalPrice;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public VMOffer getOffer() {
        return this.offer;
    }

    public void setOffer(VMOffer vMOffer) {
        this.offer = vMOffer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatOfferMessage) || !super.equals(obj)) {
            return false;
        }
        ChatOfferMessage chatOfferMessage = (ChatOfferMessage) obj;
        if (this.price == chatOfferMessage.price && this.quantity == chatOfferMessage.quantity && this.offerStatus == chatOfferMessage.offerStatus && this.offerId == chatOfferMessage.offerId && this.priceBeforeDiscount == chatOfferMessage.priceBeforeDiscount && this.originalPrice == chatOfferMessage.originalPrice && Objects.equal(this.itemName, chatOfferMessage.itemName) && Objects.equal(this.modelName, chatOfferMessage.modelName) && Objects.equal(this.imageUrl, chatOfferMessage.imageUrl) && Objects.equal(this.offer, chatOfferMessage.offer)) {
            return true;
        }
        return false;
    }
}
