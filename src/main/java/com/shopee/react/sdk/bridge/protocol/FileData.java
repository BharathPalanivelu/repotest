package com.shopee.react.sdk.bridge.protocol;

public class FileData {
    private final String data;
    private final int status;

    public FileData(String str, int i) {
        this.data = str;
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public String getData() {
        return this.data;
    }
}
