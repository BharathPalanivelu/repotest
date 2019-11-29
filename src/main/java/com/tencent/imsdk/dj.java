package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALOffLineMsg;
import com.tencent.qalsdk.QALOfflinePushListener;
import com.tencent.qalsdk.QALSDKManager;

final class dj implements QALOfflinePushListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMOfflinePushListener f30872a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMManager f30873b;

    dj(TIMManager tIMManager, TIMOfflinePushListener tIMOfflinePushListener) {
        this.f30873b = tIMManager;
        this.f30872a = tIMOfflinePushListener;
    }

    public final void onPushMsg(QALOffLineMsg qALOffLineMsg) {
        boolean isOfflinePushEnabled = IMMsfCoreProxy.get().isOfflinePushEnabled(qALOffLineMsg.getContext(), qALOffLineMsg.getID());
        QLog.d("imsdk.TIMManager", 1, "OfflinePush|1-Begin|succ|recv offline push, user: " + qALOffLineMsg.getID());
        if (!isOfflinePushEnabled) {
            QLog.d("imsdk.TIMManager", 1, "OfflinePush|2-callback|failed|offline push disabled");
        } else if (this.f30872a == null) {
            QLog.d("imsdk.TIMManager", 1, "OfflinePush|2-callback|failed|no callback ");
        } else {
            IMMsfCoreProxy.get().addPushListener(qALOffLineMsg.getContext().getApplicationContext());
            QALSDKManager.getInstance().init(qALOffLineMsg.getContext().getApplicationContext(), QALSDKManager.getInstance().getSdkAppId());
            IMMsfCoreProxy.get().handleMsg(qALOffLineMsg.getID(), qALOffLineMsg.getContext(), qALOffLineMsg.getBody());
        }
    }
}
