package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class bs implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30784a;

    bs(IMMsfCoreProxy iMMsfCoreProxy) {
        this.f30784a = iMMsfCoreProxy;
    }

    public final void onError(int i, String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "log report failed, code " + i + "|desc " + str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        QLog.d("imsdk.IMMsfCoreProxy", 1, "log report succ");
    }
}
