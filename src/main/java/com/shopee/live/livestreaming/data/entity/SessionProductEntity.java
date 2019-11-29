package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;
import java.io.Serializable;
import java.util.ArrayList;

public class SessionProductEntity extends a {
    private boolean hasMore;
    private ArrayList<ProductItem> items;
    private int max_items;
    private int next_offset;
    private int total_count;

    public int getTotal_count() {
        return this.total_count;
    }

    public void setTotal_count(int i) {
        this.total_count = i;
    }

    public int getMax_items() {
        return this.max_items;
    }

    public void setMax_items(int i) {
        this.max_items = i;
    }

    public int getNext_offset() {
        return this.next_offset;
    }

    public void setNext_offset(int i) {
        this.next_offset = i;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public ArrayList<ProductItem> getItems() {
        ArrayList<ProductItem> arrayList = this.items;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setItems(ArrayList<ProductItem> arrayList) {
        this.items = arrayList;
    }

    public class ProductItem implements Serializable {
        private String currency;
        private int discount;
        private String image;
        private long item_id;
        private String name;
        private String price;
        private String price_before_discount;
        private String price_max;
        private String price_max_before_discount;
        private String price_min;
        private String price_min_before_discount;
        private int shop_id;

        public ProductItem() {
        }

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

        public String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public void setName(String str) {
            this.name = str;
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

        public String getPrice_before_discount() {
            String str = this.price_before_discount;
            return str == null ? "" : str;
        }

        public void setPrice_before_discount(String str) {
            this.price_before_discount = str;
        }

        public String getPrice_min() {
            String str = this.price_min;
            return str == null ? "" : str;
        }

        public void setPrice_min(String str) {
            this.price_min = str;
        }

        public String getPrice_min_before_discount() {
            String str = this.price_min_before_discount;
            return str == null ? "" : str;
        }

        public void setPrice_min_before_discount(String str) {
            this.price_min_before_discount = str;
        }

        public String getPrice_max() {
            String str = this.price_max;
            return str == null ? "" : str;
        }

        public void setPrice_max(String str) {
            this.price_max = str;
        }

        public String getPrice_max_before_discount() {
            String str = this.price_max_before_discount;
            return str == null ? "" : str;
        }

        public void setPrice_max_before_discount(String str) {
            this.price_max_before_discount = str;
        }

        public int getDiscount() {
            return this.discount;
        }

        public void setDiscount(int i) {
            this.discount = i;
        }

        public String getCurrency() {
            String str = this.currency;
            return str == null ? "" : str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }
    }
}
