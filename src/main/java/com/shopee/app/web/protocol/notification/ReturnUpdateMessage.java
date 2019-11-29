package com.shopee.app.web.protocol.notification;

public class ReturnUpdateMessage {
    private long returnID;
    private int returnStatus;

    public int getReturnStatus() {
        return this.returnStatus;
    }

    public long getReturnID() {
        return this.returnID;
    }
}
