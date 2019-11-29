package com.tencent.imsdk;

final class bz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUserStatusListener f30802a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30803b;

    bz(IMMsfCoreProxy iMMsfCoreProxy, TIMUserStatusListener tIMUserStatusListener) {
        this.f30803b = iMMsfCoreProxy;
        this.f30802a = tIMUserStatusListener;
    }

    public final void run() {
        this.f30802a.onUserSigExpired();
    }
}
