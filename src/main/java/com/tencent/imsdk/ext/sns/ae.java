package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

final class ae extends TIMFriendshipManagerExt.ag {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31025b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMCallBack tIMCallBack) {
        super(tIMCallBack);
        this.f31025b = tIMFriendshipManagerExt;
    }

    public final void a() {
        this.f31011a.onSuccess();
    }

    public final void a(int i, String str) {
        this.f31011a.onError(i, str);
    }
}
