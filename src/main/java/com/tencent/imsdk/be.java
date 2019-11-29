package com.tencent.imsdk;

final class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30751a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMErrInfo f30752b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30753c;

    be(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack, IMErrInfo iMErrInfo) {
        this.f30753c = iMMsfCoreProxy;
        this.f30751a = tIMCallBack;
        this.f30752b = iMErrInfo;
    }

    public final void run() {
        TIMCallBack tIMCallBack = this.f30751a;
        if (tIMCallBack != null) {
            tIMCallBack.onError(this.f30752b.getCode(), this.f30752b.getMsg());
        }
    }
}
