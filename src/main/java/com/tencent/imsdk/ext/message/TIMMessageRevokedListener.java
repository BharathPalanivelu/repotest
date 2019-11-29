package com.tencent.imsdk.ext.message;

import com.tencent.imsdk.IMBaseListener;

public interface TIMMessageRevokedListener extends IMBaseListener {
    void onMessageRevoked(TIMMessageLocator tIMMessageLocator);
}
