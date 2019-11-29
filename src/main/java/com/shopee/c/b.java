package com.shopee.c;

import com.tencent.rtmp.TXLiveBase;

public class b {
    public static void a() {
        try {
            String sDKVersionStr = TXLiveBase.getSDKVersionStr();
            c.a("liteav sdk version is : " + sDKVersionStr);
            TXLiveBase.setConsoleEnabled(false);
            TXLiveBase.setLogLevel(6);
        } catch (Exception unused) {
            c.b("get liteav sdk error");
        }
    }
}
