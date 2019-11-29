package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import java.io.Serializable;
import java.util.ArrayList;

public class SaveProductEntity implements Serializable {
    private int mPageType;
    ArrayList<ProductEntity.ProductItem> productItems;

    public int getmPageType() {
        return this.mPageType;
    }

    public void setmPageType(int i) {
        this.mPageType = i;
    }

    public ArrayList<ProductEntity.ProductItem> getProductItems() {
        ArrayList<ProductEntity.ProductItem> arrayList = this.productItems;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setProductItems(ArrayList<ProductEntity.ProductItem> arrayList) {
        this.productItems = arrayList;
    }
}
