package com.tencent.imsdk;

import com.tencent.timint.TIMIntManager;

final class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30807a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ ca f30808b;

    cd(ca caVar, String str) {
        this.f30808b = caVar;
        this.f30807a = str;
    }

    public final void run() {
        if (TIMManager.getInstance().getUserConfig().getConnectionListener() != null) {
            TIMManager.getInstance().getUserConfig().getConnectionListener().onWifiNeedAuth(this.f30807a);
        }
        if (TIMIntManager.getInstance().getConnectionListener() != null) {
            TIMIntManager.getInstance().getConnectionListener().onWifiNeedAuth(this.f30807a);
        }
    }
}
