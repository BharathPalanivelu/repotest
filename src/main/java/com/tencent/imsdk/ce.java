package com.tencent.imsdk;

import com.appsflyer.share.Constants;
import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALUserStatusListener;

final class ce implements QALUserStatusListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30809a;

    ce(IMMsfCoreProxy iMMsfCoreProxy) {
        this.f30809a = iMMsfCoreProxy;
    }

    public final void onForceOffline(String str) {
        QLog.i("imsdk.IMMsfCoreProxy", 1, "ForceOffline|1-Recv|Succ|recv forceoffline id: " + str);
        if (this.f30809a.getMsfUserInfo(str) != null) {
            this.f30809a.logout(str, (TIMCallBack) null);
            QLog.i("imsdk.IMMsfCoreProxy", 1, "ForceOffline|2-Logout|Succ");
            TIMUserStatusListener userStatusListener = TIMManager.getInstanceById(str).getUserConfig().getUserStatusListener();
            if (userStatusListener != null) {
                IMMsfCoreProxy.mainHandler.post(new cf(this, userStatusListener));
            } else {
                QLog.e("imsdk.IMMsfCoreProxy", 1, "ForceOffline|3-Callback|Fail|no listener found");
            }
        } else {
            QLog.i("imsdk.IMMsfCoreProxy", 1, "ForceOffline|2-Logout|no need to logout and callback");
        }
    }

    public final void onRegisterFail(String str, int i, String str2) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "reconnected...onRegisterFail error" + i + "|" + str2 + Constants.URL_PATH_DELIMITER + str);
    }

    public final void onRegisterSucc(String str) {
        QLog.e("imsdk.IMMsfCoreProxy", 1, "reconnected...register success id:" + str);
        if (this.f30809a.mode == 1) {
            try {
                TIMManager.getInstanceById(str).getCoreUser().loginSync();
            } catch (Throwable th) {
                QLog.e("imsdk.IMMsfCoreProxy", 1, "synchronization failed." + QLog.getStackTraceString(th));
            }
        }
    }
}
