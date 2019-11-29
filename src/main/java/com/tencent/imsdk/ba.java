package com.tencent.imsdk;

final class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMCallBack f30740a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30741b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30742c;

    ba(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack, String str) {
        this.f30742c = iMMsfCoreProxy;
        this.f30740a = tIMCallBack;
        this.f30741b = str;
    }

    public final void run() {
        TIMCallBack tIMCallBack = this.f30740a;
        tIMCallBack.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + this.f30741b);
    }
}
