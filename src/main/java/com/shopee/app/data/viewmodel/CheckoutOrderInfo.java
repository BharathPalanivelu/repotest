package com.shopee.app.data.viewmodel;

import java.util.List;

public class CheckoutOrderInfo {
    private String currency;
    private int daysToPay;
    private List<String> images;
    private int itemCount;
    private long orderId;
    private long price;
    private String sellerAvatar;
    private int shopId;
    private int status;

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

    public int getItemCount() {
        return this.itemCount;
    }

    public void setItemCount(int i) {
        this.itemCount = i;
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public String getSellerAvatar() {
        return this.sellerAvatar;
    }

    public void setSellerAvatar(String str) {
        this.sellerAvatar = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public long getPrice() {
        return this.price;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setDaysToPay(int i) {
        this.daysToPay = i;
    }

    public int getDaysToPay() {
        return this.daysToPay;
    }
}
