package com.shopee.app.data.viewmodel.chat2;

import android.text.TextUtils;

public class Sticker {
    private String imageUrl;
    private String name;

    public Sticker(String str, String str2) {
        this.imageUrl = str;
        this.name = str2;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getName() {
        return this.name;
    }

    public boolean isNameVisible() {
        return !TextUtils.isEmpty(this.name);
    }
}
