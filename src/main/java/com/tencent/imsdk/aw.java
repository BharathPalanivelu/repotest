package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30732a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f30733b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f30734c;

    aw(TIMCallBack tIMCallBack, int i, String str) {
        this.f30732a = tIMCallBack;
        this.f30733b = i;
        this.f30734c = str;
    }

    public final void run() {
        this.f30732a.onError(this.f30733b, this.f30734c);
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Login|5-Callback|Succ|Login failed! code:" + this.f30733b + ", desc:" + this.f30734c);
    }
}
