package com.shopee.web.sdk.bridge.protocol.externallink;

public class OpenExternalLinkRequest {
    private String url;

    public OpenExternalLinkRequest(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
