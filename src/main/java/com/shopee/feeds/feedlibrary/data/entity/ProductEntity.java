package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductEntity implements Serializable {
    private boolean has_more;
    private ArrayList<ProductItem> items;
    private int next_offset;

    public int getNext_offset() {
        return this.next_offset;
    }

    public void setNext_offset(int i) {
        this.next_offset = i;
    }

    public boolean isHas_more() {
        return this.has_more;
    }

    public void setHas_more(boolean z) {
        this.has_more = z;
    }

    public ArrayList<ProductItem> getItems() {
        ArrayList<ProductItem> arrayList = this.items;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void setItems(ArrayList<ProductItem> arrayList) {
        this.items = arrayList;
    }

    public static class ProductItem implements Serializable {
        private String currency;
        private int discount;
        private String image;
        private boolean isEmptyItem = false;
        private boolean is_24h;
        private boolean is_official_mall;
        private boolean is_preferred;
        private String item_id;
        private String name;
        private String price;
        private String price_before_discount;
        private String price_max;
        private String price_max_before_discount;
        private String price_min;
        private String price_min_before_discount;
        private String shop_avatar;
        private int shop_id;
        private String shop_name;

        public void setIs_official_mall(boolean z) {
            this.is_official_mall = z;
        }

        public void setShop_name(String str) {
            this.shop_name = str;
        }

        public String getShop_name() {
            String str = this.shop_name;
            return str == null ? "" : str;
        }

        public boolean isEmptyItem() {
            return this.isEmptyItem;
        }

        public void setEmptyItem(boolean z) {
            this.isEmptyItem = z;
        }

        public boolean isIs_official_mall() {
            return this.is_official_mall;
        }

        public void setIs_24h(boolean z) {
            this.is_24h = z;
        }

        public boolean isIs_24h() {
            return this.is_24h;
        }

        public void setIs_preferred(boolean z) {
            this.is_preferred = z;
        }

        public boolean isIs_preferred() {
            return this.is_preferred;
        }

        public String getShop_avatar() {
            String str = this.shop_avatar;
            return str == null ? "" : str;
        }

        public void setShop_avatar(String str) {
            this.shop_avatar = str;
        }

        public String getItem_id() {
            String str = this.item_id;
            return str == null ? "" : str;
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

        public String getCurrency() {
            String str = this.currency;
            return str == null ? "" : str;
        }

        public void setCurrency(String str) {
            this.currency = str;
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
    }
}
