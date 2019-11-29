package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import java.io.Serializable;

public class ProductPosEntity implements Serializable {
    private String item_id;
    private ProductEntity.ProductItem mProductPosItem;
    private String price;
    private String productName;
    private int shop_id;

    public String getProductName() {
        String str = this.productName;
        return str == null ? "" : str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getPrice() {
        String str = this.price;
        return str == null ? "" : str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        this.item_id = str;
    }

    public int getShop_id() {
        return this.shop_id;
    }

    public void setShop_id(int i) {
        this.shop_id = i;
    }

    public ProductEntity.ProductItem getProductPosItem() {
        return this.mProductPosItem;
    }

    public void setProductPosItem(ProductEntity.ProductItem productItem) {
        this.mProductPosItem = productItem;
    }
}
