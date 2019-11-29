package com.shopee.live.livestreaming.data.entity;

import java.io.Serializable;

public class UpLoadShowProductItem implements Serializable {
    private String currency;
    private String image;
    private long item_id;
    private String price;
    private String price_max;
    private String price_min;
    private int shop_id;

    public long getItem_id() {
        return this.item_id;
    }

    public void setItem_id(long j) {
        this.item_id = j;
    }

    public int getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(int i) {
        this.shop_id = i;
    }

    public String getImage() {
        String str = this.image;
        return str == null ? "" : str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getPrice() {
        String str = this.price;
        return str == null ? "" : str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getCurrency() {
        String str = this.currency;
        return str == null ? "" : str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getPrice_min() {
        String str = this.price_min;
        return str == null ? "" : str;
    }

    public void setPrice_min(String str) {
        this.price_min = str;
    }

    public String getPrice_max() {
        String str = this.price_max;
        return str == null ? "" : str;
    }

    public void setPrice_max(String str) {
        this.price_max = str;
    }
}
