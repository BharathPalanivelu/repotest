package com.shopee.app.web.protocol;

public class PopWebViewMessage {
    private int count;
    private String data;

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public int getCount() {
        return this.count;
    }
}
