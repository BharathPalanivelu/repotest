package com.tencent.qalsdk.service;

import android.os.Binder;
import android.os.RemoteException;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseService;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.util.QLog;

final class h extends IBaseService.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QalService f32318a;

    public final FromServiceMsg sendSyncToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
        return null;
    }

    h(QalService qalService) {
        this.f32318a = qalService;
    }

    public final int sendToServiceMsg(ToServiceMsg toServiceMsg) throws RemoteException {
        if (toServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.w(QalService.tag, 2, "sendToServiceMsg toServiceMsg null!");
            }
            return -1;
        }
        QLog.d(QalService.tag, "service rcvmsg. ssoCmd:" + toServiceMsg.getServiceCmd() + " msfCmd:" + toServiceMsg.getMsfCommand() + " appSeq:" + toServiceMsg.getAppSeq());
        int b2 = j.b();
        if (toServiceMsg.getRequestSsoSeq() == -1) {
            toServiceMsg.setRequestSsoSeq(b2);
        }
        if (toServiceMsg.getTimeout() == -1) {
            toServiceMsg.setTimeout(10000);
        }
        try {
            Binder.getCallingUid();
            toServiceMsg.addAttribute("__base_tag_isAppMsg", true);
            if (!toServiceMsg.getServiceCmd().startsWith("cmd_sync_syncuser")) {
                QalService.msfServiceReqHandler.a(toServiceMsg);
            }
        } catch (Exception e2) {
            QLog.w(QalService.tag, 1, "service handle msg error " + e2, e2);
        }
        return b2;
    }
}
