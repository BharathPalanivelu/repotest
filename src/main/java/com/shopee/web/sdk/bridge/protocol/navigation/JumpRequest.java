package com.shopee.web.sdk.bridge.protocol.navigation;

public class JumpRequest {
    private String path;

    public JumpRequest(String str) {
        this.path = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
