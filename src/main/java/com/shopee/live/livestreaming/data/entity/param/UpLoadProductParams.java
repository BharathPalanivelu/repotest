package com.shopee.live.livestreaming.data.entity.param;

import java.io.Serializable;

public class UpLoadProductParams implements Serializable {
    private String item;

    public String getItem() {
        String str = this.item;
        return str == null ? "" : str;
    }

    public void setItem(String str) {
        this.item = str;
    }
}
