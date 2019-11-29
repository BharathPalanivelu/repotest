package com.tencent.imsdk;

import com.tencent.timint.TIMIntManager;

final class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ca f30805a;

    cb(ca caVar) {
        this.f30805a = caVar;
    }

    public final void run() {
        if (TIMManager.getInstance().getUserConfig().getConnectionListener() != null) {
            TIMManager.getInstance().getUserConfig().getConnectionListener().onConnected();
        }
        if (TIMIntManager.getInstance().getConnectionListener() != null) {
            TIMIntManager.getInstance().getConnectionListener().onConnected();
        }
    }
}
