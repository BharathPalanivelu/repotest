package com.shopee.react.sdk.bridge.protocol;

public class CacheResponse {
    private final String data;
    private final int error;

    public CacheResponse(int i, String str) {
        this.error = i;
        this.data = str;
    }

    public CacheResponse(int i) {
        this.error = i;
        this.data = null;
    }

    public int getError() {
        return this.error;
    }

    public String getData() {
        return this.data;
    }
}
