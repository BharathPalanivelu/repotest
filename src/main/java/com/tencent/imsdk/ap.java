package com.tencent.imsdk;

import java.util.List;

final class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMRefreshListener f30715a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ List f30716b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ IMCoreNotify f30717c;

    ap(IMCoreNotify iMCoreNotify, TIMRefreshListener tIMRefreshListener, List list) {
        this.f30717c = iMCoreNotify;
        this.f30715a = tIMRefreshListener;
        this.f30716b = list;
    }

    public final void run() {
        this.f30715a.onRefreshConversation(this.f30716b);
    }
}
