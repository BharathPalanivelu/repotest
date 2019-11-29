package com.shopee.feeds.feedlibrary.util;

import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;

public class t {
    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String a(ProductEntity.ProductItem productItem) {
        if (productItem == null) {
            return "";
        }
        try {
            return String.valueOf(productItem.getShop_id()) + productItem.getItem_id();
        } catch (Exception unused) {
            return "";
        }
    }
}
