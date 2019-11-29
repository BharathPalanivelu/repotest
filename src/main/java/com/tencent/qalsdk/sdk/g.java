package com.tencent.qalsdk.sdk;

import android.os.RemoteException;
import com.tencent.qalsdk.QALValueWithSeqCallBack;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;

final class g extends IBaseActionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QALValueWithSeqCallBack f32246a;

    public final void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    public final void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    g(c cVar, QALValueWithSeqCallBack qALValueWithSeqCallBack) {
        this.f32246a = qALValueWithSeqCallBack;
    }

    public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (!fromServiceMsg.isSuccess()) {
            String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
            if (this.f32246a != null) {
                int i = -1;
                if (toServiceMsg != null) {
                    i = toServiceMsg.getAppSeq();
                }
                this.f32246a.onError(fromServiceMsg.getResultCode(), businessFailMsg, i);
                return;
            }
            QLog.e("CoreWrapper", 1, "checkError cb null:" + fromServiceMsg.getServiceCmd() + ":" + fromServiceMsg.getResultCode());
            return;
        }
        this.f32246a.onSuccess(c.a(fromServiceMsg), toServiceMsg.getAppSeq());
    }
}
