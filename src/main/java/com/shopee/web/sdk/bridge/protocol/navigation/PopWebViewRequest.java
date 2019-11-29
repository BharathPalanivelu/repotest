package com.shopee.web.sdk.bridge.protocol.navigation;

public class PopWebViewRequest {
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
