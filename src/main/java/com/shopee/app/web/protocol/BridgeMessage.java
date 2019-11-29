package com.shopee.app.web.protocol;

import com.google.a.l;

public class BridgeMessage {
    private String callbackId;
    private l data;
    private String handlerName;

    public String getHandlerName() {
        return this.handlerName;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public l getData() {
        return this.data;
    }

    public String toString() {
        return "BridgeMessage{handlerName='" + this.handlerName + '\'' + ", callbackId='" + this.callbackId + '\'' + ", data=" + this.data + '}';
    }
}
