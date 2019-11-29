package com.shopee.liveimsdk.custom;

import com.shopee.liveimsdk.custom.a.a;

public interface b {
    void onDanmaKuReceive(a.d dVar);

    void onJoinGroupFailed(String str);

    void onJoinGroupSucceed(String str);

    void onLoginFailed();

    void onLoginSucceed();

    void onReceivePublicScreenMessage(a aVar);

    void onSendError(String str, String str2);

    void onSendSucess(String str, String str2);
}
