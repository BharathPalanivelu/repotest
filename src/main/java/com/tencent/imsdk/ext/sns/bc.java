package com.tencent.imsdk.ext.sns;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;
import java.util.List;

final class bc extends TIMFriendshipManagerExt.ae<List<TIMFriendResult>> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMFriendshipManagerExt f31049b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bc(TIMFriendshipManagerExt tIMFriendshipManagerExt, TIMValueCallBack tIMValueCallBack) {
        super(tIMValueCallBack);
        this.f31049b = tIMFriendshipManagerExt;
    }

    public final void a(int i, String str) {
        this.f31007a.onError(i, str);
    }

    public final void a(List<TIMFriendResult> list) {
        this.f31007a.onSuccess(list);
    }
}
