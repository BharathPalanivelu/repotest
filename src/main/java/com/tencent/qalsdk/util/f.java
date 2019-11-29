package com.tencent.qalsdk.util;

import com.tencent.qalsdk.QALCallBack;

final class f implements QALCallBack {
    f(e eVar) {
    }

    public final void onError(int i, String str) {
        QLog.e("GuestHelper", 1, "bindID fail:" + i + ":" + str);
    }

    public final void onSuccess() {
        QLog.e("GuestHelper", 1, "bindID succ");
    }
}
