package com.shopee.web.sdk.bridge.internal;

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
        return a.f30470a.b((Object) this);
    }

    public static BridgeMessage forEvent(String str, Object obj) {
        BridgeMessage bridgeMessage = new BridgeMessage();
        bridgeMessage.handlerName = str;
        if (obj != null) {
            bridgeMessage.data = a.f30470a.a(obj);
        }
        return bridgeMessage;
    }
}
