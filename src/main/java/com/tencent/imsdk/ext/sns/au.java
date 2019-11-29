package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.List;

final class au extends TIMFriendshipManagerExt.ab {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31042b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    au(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31042b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31001a.onError(i, str);
    }

    public final void a(List<TIMFriendGroup> list) {
        this.f31001a.onSuccess(list);
    }
}
