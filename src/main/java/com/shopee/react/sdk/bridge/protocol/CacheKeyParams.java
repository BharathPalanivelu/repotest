package com.shopee.react.sdk.bridge.protocol;

public class CacheKeyParams {
    private final String key;

    public CacheKeyParams(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
