package com.tencent.imsdk;

import com.tencent.timint.TIMIntManager;

final class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ca f30806a;

    cc(ca caVar) {
        this.f30806a = caVar;
    }

    public final void run() {
        if (TIMManager.getInstance().getUserConfig().getConnectionListener() != null) {
            TIMManager.getInstance().getUserConfig().getConnectionListener().onDisconnected(0, "");
        }
        if (TIMIntManager.getInstance().getConnectionListener() != null) {
            TIMIntManager.getInstance().getConnectionListener().onDisconnected(0, "");
        }
    }
}
