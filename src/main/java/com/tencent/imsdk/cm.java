package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class cm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ cl f30830a;

    cm(cl clVar) {
        this.f30830a = clVar;
    }

    public final void run() {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|5-Callback|Succ|login succ without imcore");
        QLog.i("imsdk.IMMsfCoreProxy", 1, this.f30830a.f30825a + " login succ. tinyid: " + this.f30830a.f30827c.getTinyid() + " env: " + IMMsfCoreProxy.get().getEnv() + " mode: " + IMMsfCoreProxy.get().getMode());
        this.f30830a.f30826b.onSuccess();
    }
}
