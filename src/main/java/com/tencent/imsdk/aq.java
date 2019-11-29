package com.tencent.imsdk;

final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupEventListener f30718a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMGroupTipsElem f30719b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30720c;

    aq(IMCoreNotify iMCoreNotify, TIMGroupEventListener tIMGroupEventListener, TIMGroupTipsElem tIMGroupTipsElem) {
        this.f30720c = iMCoreNotify;
        this.f30718a = tIMGroupEventListener;
        this.f30719b = tIMGroupTipsElem;
    }

    public final void run() {
        this.f30718a.onGroupTipsEvent(this.f30719b);
    }
}
