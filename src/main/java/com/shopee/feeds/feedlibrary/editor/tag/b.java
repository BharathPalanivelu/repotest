package com.shopee.feeds.feedlibrary.editor.tag;

import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;

public class b extends a {
    private String item_id;
    private ProductEntity.ProductItem mProductItem;
    private String productName;
    private String productPrice;
    private int shop_id;

    public ProductEntity.ProductItem n() {
        return this.mProductItem;
    }

    public void a(ProductEntity.ProductItem productItem) {
        this.mProductItem = productItem;
    }

    public String o() {
        String str = this.item_id;
        return str == null ? "" : str;
    }

    public void b(String str) {
        this.item_id = str;
    }

    public int p() {
        return this.shop_id;
    }

    public void c(int i) {
        this.shop_id = i;
    }

    public String q() {
        String str = this.productName;
        return str == null ? "" : str;
    }

    public void c(String str) {
        this.productName = str;
    }

    public void d(String str) {
        this.productPrice = str;
    }
}
