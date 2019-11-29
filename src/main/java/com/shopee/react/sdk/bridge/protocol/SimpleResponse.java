package com.shopee.react.sdk.bridge.protocol;

public class SimpleResponse {
    private int status;

    private SimpleResponse(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public static SimpleResponse with(int i) {
        return new SimpleResponse(i);
    }
}
