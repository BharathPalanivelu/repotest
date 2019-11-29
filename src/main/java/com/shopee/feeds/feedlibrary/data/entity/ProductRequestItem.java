package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ProductRequestItem implements Serializable {
    private String item_ids;
    public String shop_id;

    public String getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(String str) {
        this.shop_id = str;
    }

    public String getItem_ids() {
        return this.item_ids;
    }

    public void setItem_ids(String str) {
        this.item_ids = str;
    }
}
