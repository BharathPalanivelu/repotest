package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class ah extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31028a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f31028a = tIMFriendshipManagerExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
