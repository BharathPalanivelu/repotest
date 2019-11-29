package com.tencent.imsdk;

final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMValueCallBack f30769a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f30770b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30771c;

    bl(IMMsfCoreProxy iMMsfCoreProxy, TIMValueCallBack tIMValueCallBack, String str) {
        this.f30771c = iMMsfCoreProxy;
        this.f30769a = tIMValueCallBack;
        this.f30770b = str;
    }

    public final void run() {
        TIMValueCallBack tIMValueCallBack = this.f30769a;
        tIMValueCallBack.onError(BaseConstants.ERR_SDK_NOT_LOGGED_IN, "current user not login. id: " + this.f30770b);
    }
}
