package com.tencent.imsdk.ext.message;

import com.tencent.imcore.IMCore;
import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.IMCoreWrapper;
import com.tencent.imsdk.IMLiteBridge;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.log.QLog;

final class an extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30996a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMManagerExt f30997b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(TIMManagerExt tIMManagerExt, TIMCallBack tIMCallBack, String str) {
        super(tIMCallBack);
        this.f30997b = tIMManagerExt;
        this.f30996a = str;
    }

    public final void onDone() {
        QLog.i(TIMManagerExt.TAG, 1, "initStorage succ");
        IMCoreWrapper.get().setIMCoreUserInited(true);
        IMLiteBridge.setCoreUser2Manager(this.f30997b.manager, IMCore.get().getUser(this.f30996a));
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        String access$000 = TIMManagerExt.TAG;
        QLog.e(access$000, 1, "initStorage failed! code: " + i + " desc: " + str);
        this.cb.onError(i, str);
    }
}
