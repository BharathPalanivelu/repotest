package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMUserProfile;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.List;

final class bb extends TIMFriendshipManagerExt.ad<List<TIMUserProfile>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31048b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bb(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31048b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31005a.onError(i, str);
    }

    public final void a(List<TIMUserProfile> list) {
        this.f31005a.onSuccess(list);
    }
}
