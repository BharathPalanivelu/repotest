package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class aj extends TIMFriendshipManagerExt.aa {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31030b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31030b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f30999a.onError(i, str);
    }

    public final void a(TIMGetFriendFutureListSucc tIMGetFriendFutureListSucc) {
        this.f30999a.onSuccess(tIMGetFriendFutureListSucc);
    }
}
