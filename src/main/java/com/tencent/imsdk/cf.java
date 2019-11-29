package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;

final class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMUserStatusListener f30810a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ ce f30811b;

    cf(ce ceVar, TIMUserStatusListener tIMUserStatusListener) {
        this.f30811b = ceVar;
        this.f30810a = tIMUserStatusListener;
    }

    public final void run() {
        this.f30810a.onForceOffline();
        QLog.e("imsdk.IMMsfCoreProxy", 1, "ForceOffline|3-Callback|Succ");
    }
}
