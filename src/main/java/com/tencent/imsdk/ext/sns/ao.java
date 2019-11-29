package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.IMCoreCallback;
import com.tencent.imsdk.TIMCallBack;

final class ao extends IMCoreCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31035a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f31035a = tIMFriendshipManagerExt;
    }

    public final void onDone() {
        this.cb.onSuccess();
    }

    public final void onFail(int i, String str) {
        this.cb.onError(i, str);
    }
}
