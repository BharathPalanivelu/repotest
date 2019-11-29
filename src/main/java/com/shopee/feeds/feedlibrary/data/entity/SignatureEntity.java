package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class SignatureEntity implements Serializable {
    private String sign;

    public String getSign() {
        String str = this.sign;
        return str == null ? "" : str;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
