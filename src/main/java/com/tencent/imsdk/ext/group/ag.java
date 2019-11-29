package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class ag extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30920a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ag(TIMGroupManagerExt tIMGroupManagerExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30920a = tIMGroupManagerExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
