package com.shopee.app.web.protocol;

import java.util.List;

public class EditProductMessage {
    private long itemID;
    private int shopID;
    private int stock;
    private List<Variant> variations;

    public int getShopId() {
        return this.shopID;
    }

    public void setShopId(int i) {
        this.shopID = i;
    }

    public long getItemId() {
        return this.itemID;
    }

    public void setItemId(long j) {
        this.itemID = j;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int i) {
        this.stock = i;
    }

    public List<Variant> getVariations() {
        return this.variations;
    }

    public void setVariations(List<Variant> list) {
        this.variations = list;
    }
}
