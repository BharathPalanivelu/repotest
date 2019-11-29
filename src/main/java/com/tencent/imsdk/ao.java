package com.tencent.imsdk;

final class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMRefreshListener f30713a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30714b;

    ao(IMCoreNotify iMCoreNotify, TIMRefreshListener tIMRefreshListener) {
        this.f30714b = iMCoreNotify;
        this.f30713a = tIMRefreshListener;
    }

    public final void run() {
        this.f30713a.onRefresh();
    }
}
