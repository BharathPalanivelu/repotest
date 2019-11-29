package com.tencent.qalsdk.sdk;

import android.os.RemoteException;
import com.tencent.qalsdk.QALCallBack;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IBaseActionListener;
import com.tencent.qalsdk.base.remote.ToServiceMsg;
import com.tencent.qalsdk.util.QLog;

final class i extends IBaseActionListener.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f32250a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ QALCallBack f32251b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ c f32252c;

    public final void onActionResult(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    public final void onRecvFromMsg(FromServiceMsg fromServiceMsg) throws RemoteException {
    }

    i(c cVar, String str, QALCallBack qALCallBack) {
        this.f32252c = cVar;
        this.f32250a = str;
        this.f32251b = qALCallBack;
    }

    public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        QLog.i("CoreWrapper", this.f32250a + " unregister resp." + toServiceMsg.getServiceCmd() + ":" + fromServiceMsg.getResultCode() + ":" + toServiceMsg.getRequestSsoSeq());
        this.f32252c.a(toServiceMsg, fromServiceMsg, this.f32251b);
        this.f32252c.y.remove(Integer.valueOf(toServiceMsg.getAppSeq()));
    }
}
