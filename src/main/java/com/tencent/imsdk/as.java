package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfUserInfo f30723a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30724b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ar f30725c;

    as(ar arVar, IMMsfUserInfo iMMsfUserInfo, TIMCallBack tIMCallBack) {
        this.f30725c = arVar;
        this.f30723a = iMMsfUserInfo;
        this.f30724b = tIMCallBack;
    }

    public final void run() {
        QLog.i("imsdk.IMCoreWrapper", 1, "Login|5-Callback|Succ|Login succ with imcore");
        QLog.i("imsdk.IMCoreWrapper", 1, this.f30723a.getUser() + " login succ. tinyid: " + this.f30723a.getTinyid() + " env: " + IMMsfCoreProxy.get().getEnv() + " mode: " + IMMsfCoreProxy.get().getMode());
        this.f30724b.onSuccess();
    }
}
