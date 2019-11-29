package com.shopee.app.react.protocol;

public class ReactAsset {
    private String file;
    private String md5;

    public String getPath() {
        return this.file;
    }

    public String getMd5() {
        return this.md5;
    }
}
