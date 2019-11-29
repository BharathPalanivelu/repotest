package com.tencent.qalsdk.sdk;

import android.os.RemoteException;
import com.tencent.qalsdk.QALValueCallBack;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.base.remote.ToServiceMsg;

final class f extends IBaseActionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QALValueCallBack f32244a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ c f32245b;

    public final void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    public final void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    f(c cVar, QALValueCallBack qALValueCallBack) {
        this.f32245b = cVar;
        this.f32244a = qALValueCallBack;
    }

    public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (!c.a(fromServiceMsg, this.f32244a)) {
            this.f32244a.onSuccess(c.a(fromServiceMsg));
        }
    }
}
