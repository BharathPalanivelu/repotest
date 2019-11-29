package com.shopee.web.sdk.bridge.protocol.version;

public class VersionResponse {
    private String appver;
    private int version;

    public VersionResponse(int i, String str) {
        this.version = i;
        this.appver = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String getAppver() {
        return this.appver;
    }

    public void setAppver(String str) {
        this.appver = str;
    }
}
