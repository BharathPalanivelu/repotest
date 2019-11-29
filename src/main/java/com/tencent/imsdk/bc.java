package com.tencent.imsdk;

final class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30745a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30746b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30747c;

    bc(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack, IMErrInfo iMErrInfo) {
        this.f30747c = iMMsfCoreProxy;
        this.f30745a = tIMCallBack;
        this.f30746b = iMErrInfo;
    }

    public final void run() {
        TIMCallBack tIMCallBack = this.f30745a;
        if (tIMCallBack != null) {
            tIMCallBack.onError(this.f30746b.getCode(), this.f30746b.getMsg());
        }
    }
}
