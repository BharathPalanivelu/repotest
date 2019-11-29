package com.tencent.qalsdk.sdk;

import android.os.RemoteException;
import com.tencent.qalsdk.QALCallBack;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;

final class h extends IBaseActionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f32247a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ QALCallBack f32248b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ c f32249c;

    public final void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    public final void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    h(c cVar, a aVar, QALCallBack qALCallBack) {
        this.f32249c = cVar;
        this.f32247a = aVar;
        this.f32248b = qALCallBack;
    }

    public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        QLog.i("CoreWrapper", 1, this.f32247a.f32223a + " register resp." + toServiceMsg.getServiceCmd() + ":" + fromServiceMsg.getResultCode() + ":" + toServiceMsg.getRequestSsoSeq());
        c.a(this.f32249c, this.f32247a.f32224b);
        this.f32249c.a(toServiceMsg, fromServiceMsg, this.f32248b);
        this.f32249c.y.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
    }
}
