package com.tencent.imsdk;

final class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30743a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30744b;

    bb(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack) {
        this.f30744b = iMMsfCoreProxy;
        this.f30743a = tIMCallBack;
    }

    public final void run() {
        this.f30743a.onSuccess();
    }
}
