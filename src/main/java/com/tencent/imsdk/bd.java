package com.tencent.imsdk;

final class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30748a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30749b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30750c;

    bd(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack, IMErrInfo iMErrInfo) {
        this.f30750c = iMMsfCoreProxy;
        this.f30748a = tIMCallBack;
        this.f30749b = iMErrInfo;
    }

    public final void run() {
        TIMCallBack tIMCallBack = this.f30748a;
        if (tIMCallBack != null) {
            tIMCallBack.onError(this.f30749b.getCode(), this.f30749b.getMsg());
        }
    }
}
