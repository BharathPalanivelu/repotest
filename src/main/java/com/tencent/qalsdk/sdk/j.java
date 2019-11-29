package com.tencent.qalsdk.sdk;

import com.tencent.qalsdk.QALCallBack;
import com.tencent.qalsdk.util.QLog;

final class j implements QALCallBack {
    j(c cVar) {
    }

    public final void onError(int i, String str) {
        QLog.e("CoreWrapper", "register resp 1002,unregister error:" + i + ":" + str);
    }

    public final void onSuccess() {
        QLog.e("CoreWrapper", "register resp 1002,unregister succ");
    }
}
