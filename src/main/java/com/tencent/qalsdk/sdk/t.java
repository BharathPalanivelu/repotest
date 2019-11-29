package com.tencent.qalsdk.sdk;

import android.os.RemoteException;
import com.tencent.qalsdk.base.remote.FromServiceMsg;
import com.tencent.qalsdk.base.remote.IMsfServiceCallbacker;
import com.tencent.qalsdk.base.remote.ToServiceMsg;

final class t extends IMsfServiceCallbacker.Stub {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ s f32275a;

    t(s sVar) {
        this.f32275a = sVar;
    }

    public final void onResponse(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) throws RemoteException {
        s.a(this.f32275a, toServiceMsg, fromServiceMsg);
    }

    public final void onRecvPushResp(FromServiceMsg fromServiceMsg) throws RemoteException {
        s.a(this.f32275a, fromServiceMsg);
    }
}
