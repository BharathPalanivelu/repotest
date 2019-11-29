package com.shopee.react.sdk.bridge.protocol;

public class DataBridgeData {
    private final String data;
    private final String key;

    public DataBridgeData(String str, String str2) {
        this.key = str;
        this.data = str2;
    }

    public String getKey() {
        return this.key;
    }

    public String getData() {
        return this.data;
    }
}
