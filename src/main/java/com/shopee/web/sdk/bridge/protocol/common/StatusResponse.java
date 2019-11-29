package com.shopee.web.sdk.bridge.protocol.common;

public class StatusResponse {
    private int status;

    public StatusResponse(int i) {
        this.status = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
