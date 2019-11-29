package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALConnListener;

final class ca implements QALConnListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30804a;

    ca(IMMsfCoreProxy iMMsfCoreProxy) {
        this.f30804a = iMMsfCoreProxy;
    }

    public final void onConnected() {
        TIMNetworkStatus unused = this.f30804a.networkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_CONNECTED;
        IMMsfCoreProxy.mainHandler.post(new cb(this));
        QLog.i("imsdk.IMMsfCoreProxy", 1, "onConnected");
    }

    public final void onDisconnected(int i, String str) {
        TIMNetworkStatus unused = this.f30804a.networkStatus = TIMNetworkStatus.TIM_NETWORK_STATUS_DISCONNECTED;
        IMMsfCoreProxy.mainHandler.post(new cc(this));
        QLog.e("imsdk.IMMsfCoreProxy", 1, "onDisconnected, code:" + i + "|desc:" + str);
    }

    public final void onWifiNeedAuth(String str) {
        IMMsfCoreProxy.mainHandler.post(new cd(this, str));
        QLog.i("imsdk.IMMsfCoreProxy", 1, "onWifiNeedAuth, desc: " + str);
    }
}
