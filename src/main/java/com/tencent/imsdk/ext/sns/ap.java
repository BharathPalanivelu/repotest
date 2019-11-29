package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class ap extends TIMFriendshipManagerExt.af {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31036b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ap(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31036b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31009a.onError(i, str);
    }

    public final void a(TIMUserSearchSucc tIMUserSearchSucc) {
        this.f31009a.onSuccess(tIMUserSearchSucc);
    }
}
