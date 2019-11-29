package com.tencent.imsdk;

import com.tencent.imsdk.log.QLog;
import com.tencent.qalsdk.QALCallBack;

final class ax implements QALCallBack {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TIMCallBack f30735a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMMsfCoreProxy f30736b;

    ax(IMMsfCoreProxy iMMsfCoreProxy, TIMCallBack tIMCallBack) {
        this.f30736b = iMMsfCoreProxy;
        this.f30735a = tIMCallBack;
    }

    public final void onError(int i, String str) {
        IMErrInfo iMErrInfo = new IMErrInfo(i, str);
        BaseConstants.covertErrorCode(iMErrInfo);
        QLog.e("imsdk.IMMsfCoreProxy", 1, "unBindId failed. code: " + iMErrInfo.getCode() + "|desc: " + iMErrInfo.getMsg());
        if (this.f30735a != null) {
            QLog.i("imsdk.IMMsfCoreProxy", 1, "Logout|2-Callback|Succ|logout failed! code: " + i + ", desc: " + str);
            IMMsfCoreProxy.mainHandler.post(new ay(this, iMErrInfo));
            return;
        }
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Logout|2-Callback|Fail|user not set logout callback");
    }

    public final void onSuccess() {
        QLog.d("imsdk.IMMsfCoreProxy", 1, "unBindId succ");
        if (this.f30735a != null) {
            QLog.i("imsdk.IMMsfCoreProxy", 1, "Logout|2-Callback|Succ|logout succ");
            IMMsfCoreProxy.mainHandler.post(new az(this));
            return;
        }
        QLog.e("imsdk.IMMsfCoreProxy", 1, "Logout|2-Callback|Fail|user not set logout callback");
    }
}
