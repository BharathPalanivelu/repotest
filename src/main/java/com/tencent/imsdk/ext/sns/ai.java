package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class ai extends TIMFriendshipManagerExt.ac {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31029b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ai(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31029b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31003a.onError(i, str);
    }

    public final void a(TIMGetFriendPendencyListSucc tIMGetFriendPendencyListSucc) {
        this.f31003a.onSuccess(tIMGetFriendPendencyListSucc);
    }
}
