package com.shopee.react.sdk.bridge.modules.app.shake;

import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.protocol.ShakeErrorResponse;
import com.shopee.react.sdk.bridge.protocol.StartShakeDetectionMessage;

public interface a {
    void a(c<ShakeErrorResponse> cVar);

    void a(StartShakeDetectionMessage startShakeDetectionMessage, c<ShakeErrorResponse> cVar);
}
