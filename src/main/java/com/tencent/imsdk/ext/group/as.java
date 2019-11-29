package com.tencent.imsdk.ext.group;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class as extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMGroupManagerExt f30932a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    as(TIMGroupManagerExt tIMGroupManagerExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f30932a = tIMGroupManagerExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
